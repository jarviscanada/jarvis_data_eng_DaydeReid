package ca.jrvs.apps.trading.controller;

import ca.jrvs.apps.trading.model.domain.IexQuote;
import ca.jrvs.apps.trading.model.domain.Quote;
import ca.jrvs.apps.trading.service.QuoteService;
import com.sun.org.apache.xpath.internal.operations.Quo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

//@Api(value = "quote", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Controller
@RequestMapping("/quote")
public class QuoteController {

  private QuoteService quoteService;

  @Autowired
  public QuoteController(QuoteService quoteService) {
    this.quoteService = quoteService;
  }

  @ApiOperation(value = "Show iexQuote", notes = "Show an iexQuote for a given ticker symbol")
  @ApiResponses(value = {@ApiResponse(code = 404, message = "Ticker is not found")})
  @GetMapping(path = "/iex/ticker/{ticker}")
  @ResponseStatus(HttpStatus.OK)
  @ResponseBody
  public IexQuote getQuote(@PathVariable String ticker) {
    try {
      return quoteService.findIexQuoteByTicker(ticker);
    } catch (Exception ex) {
      throw ResponseExceptionUtil.getResponseStatusException(ex);
    }
  }

  @ApiOperation(value = "Update quote table using IEX data", notes = "Update all quotes in the quote table. Use IEX trading API as market data source.")
  @PutMapping(path = "/iexMarketData")
  @ResponseStatus
  @ResponseBody
  public void updateMarketData() {
    try {
      quoteService.updateMarketData();
    } catch (Exception ex) {
      throw ResponseExceptionUtil.getResponseStatusException(ex);
    }
  }

  @ApiOperation(value = "Update a given quote in the quote table", notes = "Manually update a quote in the quote table using IEX market data")
  @PutMapping(path = "/")
  @ResponseStatus(HttpStatus.OK)
  @ResponseBody
  public Quote putQuote(@RequestBody Quote quote) {
    try {
      return quoteService.saveQuote(quote);
    } catch (Exception ex) {
      throw ResponseExceptionUtil.getResponseStatusException(ex);
    }
  }

  @ApiOperation(value = "Add a new ticker to the daily list (quote table)", notes = "Add a new ticker/symbol to the quote table, making it tradable")
  @PostMapping(path = "/tickerId/{tickerId}")
  @ResponseStatus(HttpStatus.CREATED)
  @ApiResponses(value = {@ApiResponse(code = 404, message = "Ticker not found in IEX system")})
  @ResponseBody
  public Quote createQuote(@PathVariable String tickerId) {
    try {
      return quoteService.saveQuote(tickerId);
    } catch (Exception ex) {
      throw ResponseExceptionUtil.getResponseStatusException(ex);
    }
  }

  @ApiOperation(value = "Show the daily list", notes = "Show the daily list for this trading system.")
  @GetMapping(path = "/dailylist")
  @ResponseStatus(HttpStatus.OK)
  @ResponseBody
  public List<Quote> getDailyList() {
    try {
      return quoteService.findAllQuotes();
    } catch (Exception ex) {
      throw ResponseExceptionUtil.getResponseStatusException(ex);
    }
  }
}
