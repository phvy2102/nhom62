/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlytaichinh;

import connect.GetConnectServer;
import define.users;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class QuanLyNguoiDung {
    public users checkUser(String username,String password)
    {
        users user= new users();
        Connection connection = GetConnectServer.getConnection();
        
        String sql = "SELECT * FROM USERS "
                + "WHERE tenTK=? and matKhau=?";
        try {
            
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();
            
            rs.next();      
            user.setId(rs.getInt(1));// tên cột
            user.setTenTK(rs.getString(2));
            user.setMatKhau(rs.getString(3));
            user.setFullname(rs.getString(4));
            user.setDoB(rs.getString(5));
            user.setSdt(rs.getString(6));
            user.setGioiTinh(rs.getString(7));
            user.setBank(rs.getString(8));
            user.setStk(rs.getString(9));
            
            return user;
        } catch(SQLException e){
//            System.out.println("Sai tài khoản mật khẩu");
            return null;
        }
    }
    
    public List<users> getAllNguoiDung(){
       List<users> listUser = new ArrayList<>();
       Connection con = GetConnectServer.getConnection();
       String sql = "Select * from USERS";
       try {
           PreparedStatement preparedStatement = con.prepareStatement(sql);
           ResultSet rs = preparedStatement.executeQuery();
           while(rs.next())
           {
               users newUser = new users();
               
               newUser.setId(rs.getInt("STT"));
               newUser.setTenTK(rs.getString("tenTK"));
               newUser.setMatKhau(rs.getString("matKhau"));
               newUser.setFullname(rs.getString("FullName"));
               newUser.setDoB(rs.getString("DOB"));
               newUser.setGioiTinh(rs.getString("GTinh"));
               newUser.setSdt(rs.getString("SDT"));
               newUser.setBank(rs.getString("Bank"));
               newUser.setStk(rs.getString("STK"));
               
               listUser.add(newUser);
           }
       } catch (SQLException e) {
           System.out.println("Lỗi tại lấy toàn bộ người dùng");
       }
       return listUser;
   }
    
    
    public List<users> getAllNguoiDungid_name_username(String tim){
       List<users> listXe = new ArrayList<>();
       Connection con = GetConnectServer.getConnection();
       String sql="Select * from USERS where (STT like '%" + tim + "%') "
               + "or (FullName like '%" + tim + "%') or (tenTK like '%" + tim + "%') ";
       try {
           PreparedStatement preparedStatement = con.prepareStatement(sql);
           ResultSet rs = preparedStatement.executeQuery();
           while(rs.next())
           {
               users newUser = new users();
               
               newUser.setId(rs.getInt("STT"));
               newUser.setTenTK(rs.getString("tenTK"));
               newUser.setMatKhau(rs.getString("matKhau"));
               newUser.setFullname(rs.getString("FullName"));
               newUser.setDoB(rs.getString("DOB"));
               newUser.setGioiTinh(rs.getString("GTinh"));
               newUser.setSdt(rs.getString("SDT"));
               newUser.setBank(rs.getString("Bank"));
               newUser.setStk(rs.getString("STK"));
               
               listXe.add(newUser);
           }
       } catch (SQLException e) {
           System.out.println("Lỗi tại lấy toàn bộ người dùng");
       }
       return listXe;
   }
    
    public void deleteNguoiDung(int id){
        java.sql.Connection connection = GetConnectServer.getConnection();
        
        String sql = "delete from USERS where STT = ?";
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            
            int rs = preparedStatement.executeUpdate();
                System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void addNguoiDung(users user){
        java.sql.Connection connection = GetConnectServer.getConnection();
            
            String sql = "INSERT INTO USERS (tenTK, matKhau, FullName, DOB, SDT, GTinh, BANK, STK) "
                    + "values (?,?,?,?,?,?,?,?) "
                    ;
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, user.getTenTK());
                preparedStatement.setString(2, user.getMatKhau());
                preparedStatement.setString(3, user.getFullname());
                preparedStatement.setString(4, user.getDoB());
                preparedStatement.setString(5, user.getSdt());
                preparedStatement.setString(6, user.getGioiTinh());
                preparedStatement.setString(7, user.getBank());
                preparedStatement.setString(8, user.getStk());
//                int rs = preparedStatement.executeUpdate();
//                System.out.println(rs);
                preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Lỗi tại thêm"
                    + " người dùng");
        }
        }
}
