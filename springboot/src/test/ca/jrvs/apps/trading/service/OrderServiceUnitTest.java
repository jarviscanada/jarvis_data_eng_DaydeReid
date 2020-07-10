package ca.jrvs.apps.trading.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import ca.jrvs.apps.trading.dao.AccountDao;
import ca.jrvs.apps.trading.dao.PositionDao;
import ca.jrvs.apps.trading.dao.QuoteDao;
import ca.jrvs.apps.trading.dao.SecurityOrderDao;
import ca.jrvs.apps.trading.dto.MarketOrderDto;
import ca.jrvs.apps.trading.model.domain.Account;
import ca.jrvs.apps.trading.model.domain.Position;
import ca.jrvs.apps.trading.model.domain.Quote;
import ca.jrvs.apps.trading.model.domain.SecurityOrder;
import java.util.Optional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceUnitTest {

  // Not sure what to use this for?
  @Captor
  ArgumentCaptor<SecurityOrder> captorSecurityOrder;

  @Mock
  private AccountDao accountDao;

  @Mock
  private SecurityOrderDao securityOrderDao;

  @Mock
  private QuoteDao quoteDao;

  @Mock
  private PositionDao positionDao;

  @InjectMocks
  private OrderService orderService;

  @Test
  public void executeMarketOrder() {

    Account mockAccount = new Account();
    mockAccount.setAmount(200.0);
    when(accountDao.findById(anyInt())).thenReturn(Optional.of(mockAccount));

    SecurityOrder mockSecurityOrder = new SecurityOrder();
    mockSecurityOrder.setStatus("CANCELLED");
    when(securityOrderDao.save(any(SecurityOrder.class))).thenAnswer(i -> i.getArguments()[0]);
    when(securityOrderDao.findById(any())).thenReturn(Optional.of(mockSecurityOrder));

    Quote mockQuote = new Quote();
    mockQuote.setAskPrice(40.0);
    mockQuote.setBidPrice(30.0);
    when(quoteDao.existsById(anyString())).thenReturn(true);
    when(quoteDao.findById(anyString())).thenReturn(Optional.of(mockQuote));

    Position mockPosition = new Position();
    mockPosition.setPosition(30);
    when(positionDao.findById(any(), any())).thenReturn(Optional.of(mockPosition));

    MarketOrderDto orderDto = new MarketOrderDto();
    try {
      orderService.executeMarketOrder(orderDto);
      fail();
    } catch (IllegalArgumentException ex) {
      assertTrue(true);
    }
    orderDto.setAccountId(1);
    orderDto.setTicker("GOOGL");
    orderDto.setSize(10);
    SecurityOrder testOrder = orderService.executeMarketOrder(orderDto);
    assertEquals("CANCELLED", testOrder.getStatus());
    orderDto.setSize(-10);
    mockSecurityOrder.setStatus("FILLED");
    testOrder = orderService.executeMarketOrder(orderDto);
    assertEquals("FILLED", testOrder.getStatus());
  }

}