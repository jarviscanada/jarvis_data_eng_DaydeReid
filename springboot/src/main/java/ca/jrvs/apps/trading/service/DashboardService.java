package ca.jrvs.apps.trading.service;

import ca.jrvs.apps.trading.dao.AccountDao;
import ca.jrvs.apps.trading.dao.PositionDao;
import ca.jrvs.apps.trading.dao.QuoteDao;
import ca.jrvs.apps.trading.dao.TraderDao;
import ca.jrvs.apps.trading.model.domain.Account;
import ca.jrvs.apps.trading.model.domain.Position;
import ca.jrvs.apps.trading.model.domain.Quote;
import ca.jrvs.apps.trading.model.domain.Trader;
import ca.jrvs.apps.trading.model.view.PortfolioView;
import ca.jrvs.apps.trading.model.view.SecurityView;
import ca.jrvs.apps.trading.model.view.TraderAccountView;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DashboardService {

  private final TraderDao traderDao;
  private final PositionDao positionDao;
  private final AccountDao accountDao;
  private final QuoteDao quoteDao;

  @Autowired
  public DashboardService(TraderDao traderDao, PositionDao positionDao, AccountDao accountDao,
      QuoteDao quoteDao) {
    this.traderDao = traderDao;
    this.positionDao = positionDao;
    this.accountDao = accountDao;
    this.quoteDao = quoteDao;
  }

  /**
   * Create and return a TraderAccountView by trader ID
   *
   * @param traderId - The ID of the trader/account to get, must not be null
   * @return TraderAccountView for the trader/account pair
   * @throws IllegalArgumentException if traderId is null or is not found
   */
  public TraderAccountView getTraderAccount(Integer traderId) {
    if (traderId == null) {
      throw new IllegalArgumentException("ERROR: traderId is null");
    }
    try {
      Trader trader = traderDao.findById(traderId).get();
      Account account = findAccountByTraderId(traderId);
      return new TraderAccountView(trader, account);
    } catch (Exception ex) {
      throw new IllegalArgumentException("ERROR: traderId could not be found");
    }
  }

  /**
   * Create and return a PortfolioView by trader ID
   *
   * @param traderId - The ID of the trader whose portfolio to get, must not be null
   * @return PortfolioView for the trader
   * @throws IllegalArgumentException if traderId is null or is not found
   */
  public PortfolioView getPortfolioViewByTraderId(Integer traderId) {
    if (traderId == null) {
      throw new IllegalArgumentException("ERROR: traderId is null");
    }
    if (!traderDao.existsById(traderId)) {
      throw new IllegalArgumentException("ERROR: traderId could not be found");
    }
    List<Position> positionList = positionDao.findAllByAccountId(findAccountByTraderId(traderId).getId());
    List<SecurityView> securityRows = new ArrayList<>();
    positionList.forEach(p -> {
      Quote quote = quoteDao.findById(p.getTicker()).get();
      securityRows.add(new SecurityView(p.getTicker(), p, quote));
    });
    return new PortfolioView(securityRows);
  }

  /**
   * @throws IllegalArgumentException if traderId is null or not found
   */
  private Account findAccountByTraderId(Integer traderId) {
    return accountDao.findByTraderId(traderId)
        .orElseThrow(() -> new IllegalArgumentException("ERROR: Invalid traderId"));
  }
}
