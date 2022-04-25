/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlytaichinh;

import connect.GetConnectServer;
import define.income;
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
public class quanLyIncome {
    public List<income> getAllIncome(){
       List<income> listIncome = new ArrayList<>();
       Connection con = GetConnectServer.getConnection();
       String sql = "Select * from THU";
       try {
           PreparedStatement preparedStatement = con.prepareStatement(sql);
           ResultSet rs = preparedStatement.executeQuery();
           while(rs.next())
           {
               income newUser = new income();
               
               newUser.setStt(rs.getInt("STT"));
               newUser.setThang(rs.getInt("THANG"));
               newUser.setLuong(rs.getString("LUONG"));
               newUser.setPhuCap(rs.getString("PHUCAP"));
               newUser.setThuong(rs.getString("THUONG"));
               newUser.setDauTu(rs.getString("DAUTU"));
               newUser.setLai(rs.getString("LAI"));

               listIncome.add(newUser);
           }
       } catch (SQLException e) {
           System.out.println("Lỗi tại lấy toàn bộ income");
       }
       return listIncome;
   }
    
    public List<income> getAllNguoiDungid_thang(String tim){
       List<income> listXe = new ArrayList<>();
       Connection con = GetConnectServer.getConnection();
       String sql="Select * from THU where (STT like '%" + tim + "%') "
               + "or (THANG like '%" + tim + "%') ";
       try {
           PreparedStatement preparedStatement = con.prepareStatement(sql);
           ResultSet rs = preparedStatement.executeQuery();
           while(rs.next())
           {
               income newUser = new income();
               
               newUser.setStt(rs.getInt("STT"));
               newUser.setThang(rs.getInt("THANG"));
               newUser.setLuong(rs.getString("LUONG"));
               newUser.setPhuCap(rs.getString("PHUCAP"));
               newUser.setThuong(rs.getString("THUONG"));
               newUser.setDauTu(rs.getString("DAUTU"));
               newUser.setLai(rs.getString("LAI"));
               
               listXe.add(newUser);
           }
       } catch (SQLException e) {
           System.out.println("Lỗi tại lấy toàn bộ income");
       }
       return listXe;
   }
}
