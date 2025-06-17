package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 数据库连接工具类。
 * 提供了获取和关闭数据库连接的方法。
 */
public class DBUtil {
    // 数据库连接参数，请根据你的实际情况修改
    private static final String JDBC_URL = "jdbc:mysql://localhost:3307/refactored_se2?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root"; // 你的数据库用户名
    private static final String PASSWORD = ""; // 你的数据库密码

    /**
     * 获取数据库连接。
     * @return 数据库连接对象。
     * @throws SQLException 如果数据库连接失败。
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
    }

    /**
     * 关闭数据库连接。
     * @param connection 要关闭的连接对象。
     */
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("Error closing connection: " + e.getMessage());
            }
        }
    }
}