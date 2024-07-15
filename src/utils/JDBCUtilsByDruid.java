package utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author raoxin
 * 1.初始化一个公共池，参数配置放在druid.properties中
 * 2.然后使用getConnection()获得连接
 * 3.使用close来关闭ResultSet resultSet, Statement statement
 * 注意如果是之前driver直接获得connect的话close就是直接关闭连接了，但是关闭连接太耗时了
 * 我们就使用了连接池，然后重写connect方法，然后关闭操作是将connect放回池中，而不是直接关闭
 */
public class JDBCUtilsByDruid {
    //这里使用静态的，一旦我创建好后，大家就可以通过这个来从连接池获得连接了
    private static DataSource ds;
    //在静态代码块完成 ds 初始化
    static {
        Properties properties = new Properties();
        try {
            //我们将用户名密码还有url都放在这个properties中
            properties.load(new FileInputStream("src\\druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(properties);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //编写 getConnection 方法
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    public static void close(ResultSet resultSet, Statement statement, Connection connection) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                //对于连接池来说，并不是真的关闭，而是将connect归还给连接池
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
