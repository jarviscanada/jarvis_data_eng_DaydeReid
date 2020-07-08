package ca.jrvs.apps.trading.dao;

import static org.junit.Assert.assertEquals;

import ca.jrvs.apps.trading.TestConfig;
import ca.jrvs.apps.trading.model.domain.Account;
import ca.jrvs.apps.trading.model.domain.Trader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.assertj.core.util.Lists;
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
public class AccountDaoIntTest {

  @Autowired
  private AccountDao accountDao;

  @Autowired
  private TraderDao traderDao;

  private Account savedAccount;
  private Trader savedTrader;

  @Before
  public void addOne() {
    savedTrader = new Trader();
    savedTrader.setFirstName("John");
    savedTrader.setLastName("Doe");
    savedTrader.setDob(new Date(2020,7, 7));
    savedTrader.setCountry("Canada");
    savedTrader.setEmail("john@doe.ca");
    savedTrader = traderDao.save(savedTrader);

    savedAccount = new Account();
    savedAccount.setTraderId(savedTrader.getId());
    savedAccount.setAmount(100.0);
    savedAccount = accountDao.save(savedAccount);
  }

  @After
  public void deleteAll() {
    accountDao.deleteAll();
    traderDao.deleteById(savedTrader.getId());
  }

  @Test
  public void findAllById() {
    List<Account> testList = Lists.newArrayList(accountDao.findAllById(
        Arrays.asList(savedAccount.getId(), -1)));
    assertEquals(1, testList.size());
    assertEquals(savedAccount, testList.get(0));
  }

  @Test
  public void saveAll() {
    System.out.println("testing 123 " + savedTrader.getId());
    List<Account> testList = new ArrayList<>();
    testList.add(new Account());
    testList.get(0).setTraderId(savedTrader.getId());
    testList.get(0).setAmount(200.0);
    testList.add(new Account());
    testList.get(1).setTraderId(savedTrader.getId());
    testList.get(1).setAmount(300.0);
    testList = (List) accountDao.saveAll(testList);
    assertEquals(testList.get(0), accountDao.findById(testList.get(0).getId()).get());
    assertEquals(testList.get(1), accountDao.findById(testList.get(1).getId()).get());
  }
}