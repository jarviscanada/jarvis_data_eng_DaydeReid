package ca.jrvs.apps.trading.model.view;

import ca.jrvs.apps.trading.model.domain.Position;
import ca.jrvs.apps.trading.model.domain.Quote;

public class SecurityView {

  private final String ticker;
  private final Position position;
  private final Quote quote;

  public SecurityView(String ticker, Position position, Quote quote) {
    this.ticker = ticker;
    this.quote = quote;
    this.position = position;
  }

  public String getTicker() {
    return ticker;
  }

  public Position getPosition() {
    return position;
  }

  public Quote getQuote() {
    return quote;
  }
}
