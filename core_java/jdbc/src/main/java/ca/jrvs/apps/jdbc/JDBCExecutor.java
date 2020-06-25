package ca.jrvs.apps.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JDBCExecutor {

  final static Logger logger = LoggerFactory.getLogger(JDBCExecutor.class);

  public static void main(String[] args) {
    BasicConfigurator.configure();
    DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost", "hplussport", "user",
        "pass");
    try {
      Connection connection = dcm.getConnection();
      OrderDAO orderDAO = new OrderDAO(connection);
      Order order = orderDAO.findById(1000);
      JDBCExecutor.logger.debug(order.toString());
    } catch (SQLException ex) {
      JDBCExecutor.logger.error("Failed to perform SQL query", ex);
    }
  }
}
