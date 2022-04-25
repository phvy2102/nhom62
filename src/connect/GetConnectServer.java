
package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class GetConnectServer {
    public static Connection Connectionn(String may,String userName,String password){
        String url="jdbc:sqlserver://"+may+"\\SQLEXPRESS:1433;databaseName=FinancialManager";
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            return DriverManager.getConnection(url,userName,password);
        }
        catch(ClassNotFoundException | SQLException e)
        {
            System.out.println("Ket noi loi");
            System.out.println(e);
        }
        return null;
    }
    
    public static Connection getConnection()
    {
//        return GetConnectServer.Connectionn("LAPTOP-ATNHOQI8","sa","12345");
//        return GetConnectServer.Connectionn("DESKTOP-T6COLHJ","sa","popdaica123");
        return GetConnectServer.Connectionn("MSI","sa","blackace71202");
    }
//    public static void main(String[] args) throws SQLException {
//        Connection connection = GetConnectServer.getConnection();
//        String sql = "SELECT * FROM USERS   ";
//        PreparedStatement pstmt = connection.prepareStatement(sql);
//        ResultSet rs = pstmt.executeQuery();
//        while( rs.next()) {
//            System.out.println(rs.getString(1)+rs.getString(2)+rs.getString(3)+rs.getString(4)+rs.getString(5)+rs.getString(6)+rs.getString(7));
//        }
//}
}
