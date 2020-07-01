import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.security.cert.LDAPCertStoreParameters;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC {

    public static void testJDBCSelect() throws SQLException {
        //1创建DataSource对象
        DataSource dataSource = new MysqlDataSource();
        //2连接数据库
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java_5_31?characterEncoding=utf-8&useSSL=true");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("listen");
        Connection connection = dataSource.getConnection();
        //3拼接sql
        String sql = "select * from student";
        PreparedStatement statement = connection.prepareStatement(sql);
        //4执行sql
        ResultSet resultSet = statement.executeQuery();
        //5遍历得到的集合
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int classId = resultSet.getInt("classId");
            System.out.println("id " + id + " name " + name + " classId " + classId);
        }
        //6关闭资源
        resultSet.close();
        statement.close();
        connection.close();
    }

    public static void testJDBCUpdate(int id, String name) throws SQLException {
        //1创建DataSource对象
        DataSource dataSource = new MysqlDataSource();
        //2连接数据库
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java_5_31?characterEncoding=utf-8&useSSL=true");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("listen");
        Connection connection = dataSource.getConnection();
        //3拼接sql
        String sql = "update student set name = ? where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, name);
        statement.setInt(2, id);
        //4执行sql
        int ret = statement.executeUpdate();
        if (ret == 1) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }
        //5关闭资源
        statement.close();
        connection.close();
    }

    public static void testJDBCDelete(int id) throws SQLException {
        //1创建DataSource对象
        DataSource dataSource = new MysqlDataSource();
        //2连接数据库
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java_5_31?characterEncoding=utf-8&useSSL=true");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("listen");
        Connection connection = dataSource.getConnection();
        //3拼接sql
        String sql = "delete from student where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        //4执行sql
        int ret = statement.executeUpdate();
        if (ret == 1) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
        //5关闭资源
        statement.close();
        connection.close();
    }

    public static void testJDBCInsert(int id, String name, int calssId) throws SQLException {
        //1创建DataSource对象
        DataSource dataSource = new MysqlDataSource();
        //2连接数据库
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java_5_31?characterEncoding=utf-8&useSSL=true");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("listen");
        Connection connection = dataSource.getConnection();
        // 3 拼接sql语句
        String sql = "insert into student values(?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.setString(2, name);
        statement.setInt(3, calssId);
        // 4 执行sql语句
        int ret = statement.executeUpdate();
        if (ret == 1) {
            System.out.println("插入成功");
        } else {
            System.out.println("插入失败");
        }
        // 5 关闭连接
        statement.close();
        connection.close();
    }
    public static void main(String[] args) throws SQLException {
        testJDBCDelete(1);
        testJDBCInsert(1,"张飞", 12);
        testJDBCUpdate(1, "张翼德");
        testJDBCSelect();
    }
}
