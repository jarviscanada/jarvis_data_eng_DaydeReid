package ca.jrvs.apps.jdbc;

import ca.jrvs.apps.jdbc.util.DataAccessObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderDAO extends DataAccessObject<Order> {

  final static Logger logger = LoggerFactory.getLogger(JDBCExecutor.class);

  private static final String GET_ONE = "SELECT c.first_name, c.last_name, c.email, o.order_id, o.creation_date, o.total_due, o.status, s.first_name, s.last_name, s.email, ol.quantity, p.code, p.name, p.size, p.variety, p.price FROM orders o JOIN customer c ON o.customer_id=c.customer_id JOIN salesperson s ON o.salesperson_id=s.salesperson_id JOIN order_item ol ON ol.order_id=o.order_id JOIN product p ON ol.product_id=p.product_id WHERE o.order_id=?";

  public OrderDAO(Connection connection) {
    super(connection);
  }

  @Override
  public Order findById(long id) {
    Order order = new Order();
    try (PreparedStatement statement = this.connection.prepareStatement(GET_ONE)) {
      statement.setLong(1, id);
      ResultSet rs = statement.executeQuery();
      long orderId = 0;
      List<OrderLine> orderLines = new ArrayList<>();
      while (rs.next()) {
        if (orderId == 0) {
          order.setCustomerFirstName(rs.getString(1));
          order.setCustomerLastName(rs.getString(2));
          order.setCustomerEmail(rs.getString(3));
          order.setId(rs.getLong(4));
          orderId = order.getId();
          order.setCreationDate(rs.getDate(5));
          order.setTotalDue(rs.getDouble(6));
          order.setStatus(rs.getString(7));
          order.setSalespersonFirstName(rs.getString(8));
          order.setSalespersonLastName(rs.getString(9));
          order.setSalespersonEmail(rs.getString(10));
        }
        OrderLine orderLine = new OrderLine();
        orderLine.setQuantity(rs.getInt(11));
        orderLine.setProductCode(rs.getString(12));
        orderLine.setProductName(rs.getString(13));
        orderLine.setProductSize(rs.getInt(14));
        orderLine.setProductVariety(rs.getString(15));
        orderLine.setProductPrice(rs.getDouble(16));
        orderLines.add(orderLine);
      }
      order.setOrderLines(orderLines);
    } catch (SQLException ex) {
      this.logger.error("Failed to perform SQL query", ex);
      throw new RuntimeException(ex);
    }
    return order;
  }

  @Override
  public List<Order> findAll() {
    return null;
  }

  @Override
  public Order update(Order dto) {
    return null;
  }

  @Override
  public Order create(Order dto) {
    return null;
  }

  @Override
  public void delete(long id) {

  }
}
