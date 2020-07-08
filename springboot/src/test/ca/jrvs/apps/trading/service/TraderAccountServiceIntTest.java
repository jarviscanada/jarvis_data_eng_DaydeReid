package ca.jrvs.apps.trading.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import ca.jrvs.apps.trading.TestConfig;
import ca.jrvs.apps.trading.dao.AccountDao;
import ca.jrvs.apps.trading.dao.TraderDao;
import ca.jrvs.apps.trading.model.domain.Trader;
import ca.jrvs.apps.trading.view.TraderAccountView;
import java.util.Date;
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
public class TraderAccountServiceIntTest {

  private TraderAccountView savedView;

  @Autowired
  private TraderAccountService traderAccountService;

  @Autowired
  private TraderDao traderDao;

  @Autowired
  private AccountDao accountDao;

  @Before
  public void addOne() {
    Trader trader = new Trader();
    trader.setFirstName("John");
    trader.setLastName("Doe");
    trader.setDob(new Date(2020, 7, 7));
    trader.setCountry("Canada");
    trader.setEmail("john@doe.ca");
    savedView = traderAccountService.createTraderAndAccount(trader);
  }

  @After
  public void deleteOne() {
    accountDao.deleteById(savedView.getAccountId());
    traderDao.deleteById(savedView.getTraderId());
  }

  @Test
  public void deposit() {
    traderAccountService.deposit(savedView.getTraderId(), 200.0);
    assertEquals((Double) 200.0, accountDao.findById(savedView.getAccountId()).get().getAmount());
    try {
      traderAccountService.deposit(savedView.getTraderId(), -50.0);
      fail();
    } catch (IllegalArgumentException ex) {
      assertTrue(true);
    }
    try {
      traderAccountService.deposit(-100, 200.0);
      fail();
    } catch (IllegalArgumentException ex) {
      assertTrue(true);
    }
  }

  @Test
  public void withdraw() {
    try {
      traderAccountService.withdraw(savedView.getTraderId(), 200.0);
      fail();
    } catch (IllegalArgumentException ex) {
      assertTrue(true);
    }
    traderAccountService.deposit(savedView.getTraderId(), 200.0);
    try {
      traderAccountService.withdraw(savedView.getTraderId(), 300.0);
      fail();
    } catch (IllegalArgumentException ex) {
      assertTrue(true);
    }
    try {
      traderAccountService.withdraw(-100, 200.0);
      fail();
    } catch (IllegalArgumentException ex) {
      assertTrue(true);
    }
    traderAccountService.withdraw(savedView.getTraderId(), 200.0);
    assertEquals((Double) 0.0, accountDao.findById(savedView.getAccountId()).get().getAmount());
  }

  @Test
  public void deleteTraderById() {
    try {
      traderAccountService.deleteTraderById(savedView.getTraderId());
      assertTrue(true);
    } catch (Exception ex) {
      fail();
    }
    try {
      traderAccountService.deleteTraderById(savedView.getTraderId());
      fail();
    } catch (Exception ex) {
      assertTrue(true);
    }
  }
}