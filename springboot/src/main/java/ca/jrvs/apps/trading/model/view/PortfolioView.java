package ca.jrvs.apps.trading.model.view;

import java.util.List;

public class PortfolioView {

  List<SecurityView> securityRows;

  public PortfolioView(List<SecurityView> securityRows) {
    this.securityRows = securityRows;
  }

  public List<SecurityView> getSecurityRows() {
    return securityRows;
  }
}
