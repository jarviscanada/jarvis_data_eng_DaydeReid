package ca.jrvs.apps.trading.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import ca.jrvs.apps.trading.TestConfig;
import ca.jrvs.apps.trading.model.domain.Quote;
import java.util.Arrays;
import java.util.List;
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
public class QuoteDaoIntTest {

  @Autowired
  private QuoteDao quoteDao;

  private Quote savedQuote;

  @Before
  public void insertOne() {
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
  public void deleteOne() {
    quoteDao.deleteById(savedQuote.getId());
  }

  @Test
  public void testSave() {
    Quote testQuote = new Quote();
    testQuote.setAskPrice(11d);
    testQuote.setAskSize(11);
    testQuote.setBidPrice(11d);
    testQuote.setBidSize(11);
    testQuote.setId("GOOGL");
    testQuote.setLastPrice(11.1d);
    quoteDao.save(testQuote);
    Quote retrievedQuote = quoteDao.findById(testQuote.getId()).get();
    assertEquals(testQuote, retrievedQuote);
  }

  @Test
  public void testSaveAll() {
    Quote testQuoteA = new Quote();
    testQuoteA.setAskPrice(11d);
    testQuoteA.setAskSize(11);
    testQuoteA.setBidPrice(11d);
    testQuoteA.setBidSize(11);
    testQuoteA.setId("BEST");
    testQuoteA.setLastPrice(11.1d);
    Quote testQuoteB = new Quote();
    testQuoteB.setAskPrice(9d);
    testQuoteB.setAskSize(9);
    testQuoteB.setBidPrice(9d);
    testQuoteB.setBidSize(9);
    testQuoteB.setId("FB");
    testQuoteB.setLastPrice(9.1d);
    quoteDao.saveAll(Arrays.asList(testQuoteA, testQuoteB));
    Quote retrievedQuoteA = quoteDao.findById(testQuoteA.getId()).get();
    assertEquals(testQuoteA, retrievedQuoteA);
    Quote retrievedQuoteB = quoteDao.findById(testQuoteB.getId()).get();
    assertEquals(testQuoteB, retrievedQuoteB);
  }

  @Test
  public void testFindById() {
    Quote retrievedQuote = quoteDao.findById(savedQuote.getId()).get();
    assertEquals(savedQuote, retrievedQuote);
  }

  @Test
  public void testExistsById() {
    assertTrue(quoteDao.existsById(savedQuote.getId()));
    assertFalse(quoteDao.existsById("In a hole there lived a hobbit"));
  }

  @Test
  public void testFindAll() {
    List<Quote> retrievedQuotes = (List) quoteDao.findAll();
    assertEquals(savedQuote, retrievedQuotes.get(0));
  }

  @Test
  public void testCount() {
    assertEquals(1, quoteDao.count());
  }

  @Test
  public void testDeleteById() {
    quoteDao.deleteById(savedQuote.getId());
    assertFalse(quoteDao.existsById(savedQuote.getId()));
  }

  @Test
  public void testDeleteAll() {
    quoteDao.deleteAll();
    assertFalse(quoteDao.existsById(savedQuote.getId()));
  }
}