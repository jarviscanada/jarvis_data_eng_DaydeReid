package ca.jrvs.apps.trading.dao;

import ca.jrvs.apps.trading.model.config.MarketDataConfig;
import ca.jrvs.apps.trading.model.domain.IexQuote;
import ca.jrvs.apps.trading.util.JsonUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * MarketDataDao is responsible for getting quotes from IEX
 */
@Repository
public class MarketDataDao implements CrudRepository<IexQuote, String> {

  private static final String IEX_BATCH_PATH = "/stock/market/batch?symbols=%s&types=quote&token=";
  private final String IEX_BATCH_URL;

  private final Logger logger = LoggerFactory.getLogger(MarketDataDao.class);
  private final HttpClientConnectionManager httpClientConnectionManager;

  @Autowired
  public MarketDataDao(HttpClientConnectionManager httpClientConnectionManager,
      MarketDataConfig marketDataConfig) {
    this.httpClientConnectionManager = httpClientConnectionManager;
    IEX_BATCH_URL = marketDataConfig.getHost() + IEX_BATCH_PATH + marketDataConfig.getToken();
  }

  @Override
  public <S extends IexQuote> S save(S s) {
    throw new UnsupportedOperationException("Not implemented");
  }

  @Override
  public <S extends IexQuote> Iterable<S> saveAll(Iterable<S> iterable) {
    throw new UnsupportedOperationException("Not implemented");
  }

  /**
   * Get an IexQuote using the findAllById method as a helper
   *
   * @param ticker
   * @throws IllegalArgumentException      if given ticker is invalid
   * @throws DataRetrievalFailureException if the HTTP request failed
   */
  @Override
  public Optional<IexQuote> findById(String ticker) {
    Optional<IexQuote> iexQuote;
    List<IexQuote> quotes = findAllById(Collections.singletonList(ticker));

    if (quotes.size() == 0) {
      return Optional.empty();
    } else if (quotes.size() == 1) {
      iexQuote = Optional.of(quotes.get(0));
    } else {
      throw new DataRetrievalFailureException("ERROR: Unexpected number of quotes");
    }
    return iexQuote;
  }

  @Override
  public boolean existsById(String s) {
    throw new UnsupportedOperationException("Not implemented");
  }

  @Override
  public Iterable<IexQuote> findAll() {
    throw new UnsupportedOperationException("Not implemented");
  }

  /**
   * Get a list of iexQuotes by their tickers
   *
   * @param tickers - A list of tickers
   * @return a list of IexQuote objects
   * @throws IllegalArgumentException      if any ticker is invalid or tickers is empty
   * @throws DataRetrievalFailureException if the HTTP request failed
   */
  @Override
  public List<IexQuote> findAllById(Iterable<String> tickers) {
    if (((Collection<?>) tickers).isEmpty()) {
      throw new IllegalArgumentException("ERROR: List of tickers is empty");
    }
    String url = String.format(IEX_BATCH_URL, String.join(",", tickers));
    String responseString = executeHttpGet(url).get();
    List<IexQuote> quoteList = new ArrayList<>();
    JSONObject jsonObj = new JSONObject(responseString);
    tickers.forEach(s -> {
      if(!jsonObj.has(s)) {
        throw new IllegalArgumentException("ERROR: List contained invalid tickers");
      }
      try {
        quoteList.add(JsonUtil.toObjectFromJson(jsonObj.getJSONObject(s).getString("quote"), IexQuote.class));
      } catch (IOException ex) {
        logger.error("ERROR: Failed to convert JSON to object", ex);
      }
    });
    return quoteList;
  }

  @Override
  public long count() {
    throw new UnsupportedOperationException("Not implemented");
  }

  @Override
  public void deleteById(String s) {
    throw new UnsupportedOperationException("Not implemented");
  }

  @Override
  public void delete(IexQuote iexQuote) {
    throw new UnsupportedOperationException("Not implemented");
  }

  @Override
  public void deleteAll(Iterable<? extends IexQuote> iterable) {
    throw new UnsupportedOperationException("Not implemented");
  }

  @Override
  public void deleteAll() {
    throw new UnsupportedOperationException("Not implemented");
  }

  /**
   * Execute a GET request and return the HTTP body as a string
   *
   * @param url - The resource URL
   * @return the HTTP response body or Optional.empty for a 404 response
   * @throws DataRetrievalFailureException if the HTTP request failed or the response code is
   *                                       unexpected
   */
  private Optional<String> executeHttpGet(String url) {
    CloseableHttpClient httpClient = getHttpClient();
    HttpUriRequest getRequest = new HttpGet(url);
    try {
      HttpResponse response = httpClient.execute(getRequest);
      if (response.getStatusLine().getStatusCode() == 404) {
        return Optional.empty();
      } else if (response.getStatusLine().getStatusCode() == 200) {
        return Optional.of(EntityUtils.toString(response.getEntity()));
      } else {
        throw new DataRetrievalFailureException("ERROR: Unexpected response code");
      }
    } catch (IOException ex) {
      throw new DataRetrievalFailureException("ERROR: HTTP request failed");
    }
  }

  /**
   * Borrow an HTTP client from the httpClientConnectionManager
   *
   * @return an HTTPClient
   */
  private CloseableHttpClient getHttpClient() {
    return HttpClients.custom()
        .setConnectionManager(httpClientConnectionManager)
        .setConnectionManagerShared(true)
        .build();
  }
}
