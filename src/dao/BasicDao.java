package dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.JDBCUtilsByDruid;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author raoxin
 * QueryRunner是将result的结果填到到javabean中，javabean中的字段名字必须和数据库中
 * 一样
 * 1.update 更新操作
 * 2.List<T> queryMulti 返回一个list链表，里面装的是T对象，数据库中每一行作为一个对象封装到T中，这个T叫javabean，需要我们自己创建
 * 3.T querySingle 返回一行结果
 * 4.Object queryScalar返回一个值
 */
public class BasicDao<T> {
    private QueryRunner qr = new QueryRunner();
    //开发通用的 dml 方法, 针对任意的表
    public int update(String sql, Object... parameters) {
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            int update = qr.update(connection, sql, parameters);
            return update;
        } catch (SQLException e) {
            throw new RuntimeException(e); //将编译异常->运行异常 ,抛出
        } finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }
//返回多个对象(即查询的结果是多行), 针对任意表
    /**
     *
     * @param sql sql 语句，可以有 ?
     * @param clazz 传入一个类的 Class 对象 比如 Actor.class
     * @param parameters 传入 ? 的具体的值，可以是多个
     * @return 根据 Actor.class 返回对应的 ArrayList 集合
     */
    public List<T> queryMulti(String sql, Class<T> clazz, Object... parameters) {
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            return qr.query(connection, sql, new BeanListHandler<T>(clazz), parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e); //将编译异常->运行异常 ,抛出
        } finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }
    //查询单行结果 的通用方法
    public T querySingle(String sql, Class<T> clazz, Object... parameters) {
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            return qr.query(connection, sql, new BeanHandler<T>(clazz), parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e); //将编译异常->运行异常 ,抛出
        } finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }
    //查询单行单列的方法,即返回单值的方法
    public Object queryScalar(String sql, Object... parameters) {
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            return qr.query(connection, sql, new ScalarHandler(), parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e); //将编译异常->运行异常 ,抛出
        } finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }

}
