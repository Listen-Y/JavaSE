import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCTest {
    //增加
    public static void JDBCinsert(int id, String name, int classId) throws SQLException {
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java_5_31?characterEncoding=utf-8&useSSL=true");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("listen");
        Connection connection = dataSource.getConnection();
        String sql = "insert into student values (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.setString(2, name);
        statement.setInt(3, classId);
        int ret = statement.executeUpdate();
        if (ret == 1) {
            System.out.println("Finish Insert");
        }
        statement.close();
        connection.close();
    }
    //修改
    public static void JDBCupdate(int id, String name, int classId) throws SQLException {
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource) dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java_5_31?characterEncoding=utf-8&useSSL=true");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("listen");
        Connection connection = dataSource.getConnection();
        String sql = "update student set name = ?, classId = ? where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, name);
        statement.setInt(2, classId);
        statement.setInt(3, id);
        int ret = statement.executeUpdate();
        if (ret == 1) {
            System.out.println("Finish update");
        }
        statement.close();
        connection.close();
    }
    //查询
    public static void JDBCselect(int id) throws SQLException {
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource) dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java_5_31?characterEncoding=utf-8&useSSL=true");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("listen");
        Connection connection = dataSource.getConnection();
        String sql = "select * from student where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet ret = statement.executeQuery();
        while (ret.next()) {
            int retInt = ret.getInt(1);
            String name = ret.getString(2);
            int classId = ret.getInt(3);
            System.out.println(retInt + " " + name + " " + classId);

        }
        ret.close();
        statement.close();
        connection.close();
    }
    //删除
    public static void JDBCdelete(int id) throws SQLException {
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource) dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java_5_31?characterEncoding=utf-8&useSSL=true");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("listen");
        Connection connection = dataSource.getConnection();
        String sql = "delete from student where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        int ret = statement.executeUpdate();
        if (ret == 1) {
            System.out.println("Finish Delete");
        }
        statement.close();
        connection.close();
    }
    public static void main(String[] args) {
        try {
            JDBCinsert(2, "刘备", 19);
            JDBCupdate(2, "刘玄德", 20);
            JDBCselect(2);
            JDBCdelete(2);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
