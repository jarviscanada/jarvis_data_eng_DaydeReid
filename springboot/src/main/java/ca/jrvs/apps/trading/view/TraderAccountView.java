package ca.jrvs.apps.trading.view;

import ca.jrvs.apps.trading.model.domain.Account;
import ca.jrvs.apps.trading.model.domain.Trader;
import java.util.Date;

public class TraderAccountView {

  private Trader trader;
  private Account account;

  public TraderAccountView(Trader trader, Account account) {
    this.trader = trader;
    this.account = account;
  }

  public Integer getTraderId() {
    return trader.getId();
  }

  public String getFirstName() {
    return trader.getFirstName();
  }

  public String getLastName() {
    return trader.getLastName();
  }

  public Date getDob() {
    return trader.getDob();
  }

  public String getCountry() {
    return trader.getCountry();
  }

  public String getEmail() {
    return trader.getEmail();
  }

  public Integer getAccountId() {
    return account.getId();
  }

  public Double getAmount() {
    return account.getAmount();
  }
}
