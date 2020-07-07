package ca.jrvs.apps.trading.service;

import ca.jrvs.apps.trading.dao.MarketDataDao;
import ca.jrvs.apps.trading.dao.QuoteDao;
import ca.jrvs.apps.trading.model.domain.IexQuote;
import ca.jrvs.apps.trading.model.domain.Quote;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class QuoteService {

  private static final Logger logger = LoggerFactory.getLogger(QuoteService.class);

  private final QuoteDao quoteDao;
  private final MarketDataDao marketDataDao;

  @Autowired
  public QuoteService(QuoteDao quoteDao, MarketDataDao marketDataDao) {
    this.quoteDao = quoteDao;
    this.marketDataDao = marketDataDao;
  }

  /**
   * Update quote table from IEX source
   *
   * @throws //ResourceNotFoundException                 if ticker is not found in IEX
   * @throws org.springframework.dao.DataAccessException if unable to retrieve data
   * @throws IllegalArgumentException                    for invalid input?
   */
  public void updateMarketData() {
    Iterable<Quote> quoteList = quoteDao.findAll();
    quoteList.forEach(q -> {
      IexQuote iexQuote = marketDataDao.findById(q.getId()).get();
      Quote quote = buildQuoteFromIexQuote(iexQuote);
      quoteDao.save(quote);
    });

  }

  /**
   * Helper function which converts an IewQuote into a Quote
   */
  protected static Quote buildQuoteFromIexQuote(IexQuote iexQuote) {
    Quote quote = new Quote();
    quote.setTicker(iexQuote.getSymbol());
    quote.setAskPrice((iexQuote.getIexAskPrice() != null) ? iexQuote.getIexAskPrice() : -1);
    quote.setAskSize((iexQuote.getIexAskSize() != null) ? iexQuote.getIexAskSize().intValue() : -1);
    quote.setBidPrice((iexQuote.getIexBidPrice() != null) ? iexQuote.getIexBidPrice() : -1);
    quote.setBidSize((iexQuote.getIexBidSize() != null) ? iexQuote.getIexBidSize().intValue() : -1);
    quote.setLastPrice((iexQuote.getLatestPrice() != null) ? iexQuote.getLatestPrice() : -1);
    return quote;
  }

  /**
   * Find an IexQuote by its ticker
   *
   * @param ticker - Ticker of quote to find
   * @return an IexQuote object
   * @Throws IllegalArgumentException if ticker is invalid
   */
  public IexQuote findIexQuoteByTicker(String ticker) {
    return marketDataDao.findById(ticker)
        .orElseThrow(() -> new IllegalArgumentException("ERROR: Ticker " + ticker + " is invalid"));
  }

  /**
   * Save a given quote to the quote table without validation
   *
   * @param quote - The quote to save to the table
   */
  public Quote saveQuote(Quote quote) {
    return quoteDao.save(quote);
  }

  /**
   * Validate against IEX and save the quotes from the given tickers to the quote table
   *
   * @param tickers - The list of tickers to validate and add
   * @throws IllegalArgumentException if a ticker is not found in from IEX
   */
  public List<Quote> saveQuotes(List<String> tickers) {
    List<Quote> quoteList = new ArrayList<>();
    tickers.forEach(t -> {
      try {
        quoteList.add(saveQuote(t));
      } catch (IllegalArgumentException ex) {
        throw new IllegalArgumentException("ERROR: Ticker "+t+ "is invalid");
      }
    });
    return quoteList;
  }

  /**
   * Helper function which saves the quote from the given ticker if it can be validated by IEX
   */
  public Quote saveQuote(String ticker) {
    IexQuote iexQuote = findIexQuoteByTicker(ticker);
    Quote quote = buildQuoteFromIexQuote(iexQuote);
    return saveQuote(quote);
  }

  /**
   * Get all quotes from the quote table
   * @return a list of all the quotes
   */
  public List<Quote> findAllQuotes() {
    return (List<Quote>) quoteDao.findAll();
  }
}
