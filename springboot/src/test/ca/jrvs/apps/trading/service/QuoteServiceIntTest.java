package ca.jrvs.apps.trading.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import ca.jrvs.apps.trading.TestConfig;
import ca.jrvs.apps.trading.dao.QuoteDao;
import ca.jrvs.apps.trading.model.domain.IexQuote;
import ca.jrvs.apps.trading.model.domain.Quote;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {TestConfig.class})
@Sql({"classpath:schema.sql"})
public class QuoteServiceIntTest {

  @Autowired
  private QuoteService quoteService;

  @Autowired
  private QuoteDao quoteDao;

  private Quote savedQuote;

  @Before
  public void setup() {
    quoteDao.deleteAll();

    savedQuote = new Quote();
    savedQuote.setAskPrice(10d);
    savedQuote.setAskSize(10);
    savedQuote.setBidPrice(10d);
    savedQuote.setBidSize(10);
    savedQuote.setId("AAPL");
    savedQuote.setLastPrice(10.1d);
    quoteDao.save(savedQuote);
  }

  @After
  public void tearDown() {
    quoteDao.deleteById(savedQuote.getId());
  }

  @Test
  public void findIexQuoteByTicker() {
    IexQuote iexQuote = quoteService.findIexQuoteByTicker("GOOGL");
    assertEquals("GOOGL", iexQuote.getSymbol());
    try {
      quoteService.findIexQuoteByTicker("In a hole there lived a hobbit");
      fail();
    } catch (IllegalArgumentException ex) {
      assertTrue(true);
    }
  }

  @Test
  public void updateMarketData() {
    quoteService.updateMarketData();
    Quote testQuote = quoteDao.findById(savedQuote.getId()).get();
    assertNotEquals(savedQuote, testQuote);
  }

  @Test
  public void saveQuotes() {
    quoteService.saveQuotes(Arrays.asList("GOOGL", "BEST"));
    try {
      quoteDao.findById("GOOGL").get();
      quoteDao.findById("BEST").get();
      assertTrue(true);
    } catch (NoSuchElementException ex) {
      fail();
    }
    try {
      quoteService.saveQuotes(Arrays.asList("In a hole", "There lived a hobbit"));
      fail();
    } catch(IllegalArgumentException ex) {
      assertTrue(true);
    }
  }

  @Test
  public void saveQuote() {
    Quote testQuote = new Quote();
    testQuote.setAskPrice(11d);
    testQuote.setAskSize(11);
    testQuote.setBidPrice(11d);
    testQuote.setBidSize(11);
    testQuote.setId("FB");
    testQuote.setLastPrice(11.1d);
    quoteService.saveQuote(testQuote);
    assertEquals(testQuote, quoteDao.findById(testQuote.getId()).get());
  }

  @Test
  public void findAllQuotes() {
    List<Quote> retrievedQuotes = quoteService.findAllQuotes();
    assertEquals(savedQuote, retrievedQuotes.get(0));
  }
}