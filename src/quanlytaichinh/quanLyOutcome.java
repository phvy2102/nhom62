/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlytaichinh;

import connect.GetConnectServer;
import define.outcome;
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
public class quanLyOutcome {
    public List<outcome> getAllOutcome(){
       List<outcome> listOutcome = new ArrayList<>();
       Connection con = GetConnectServer.getConnection();
       String sql = "Select * from CHI";
       try {
           PreparedStatement preparedStatement = con.prepareStatement(sql);
           ResultSet rs = preparedStatement.executeQuery();
           while(rs.next())
           {
               outcome newUser = new outcome();
               
               newUser.setStt(rs.getInt("STT"));
               newUser.setThang(rs.getInt("THANG"));
               newUser.setDienNuoc(rs.getString("DIENNUOC"));
               newUser.setNha(rs.getString("NHA"));
               newUser.setAnUong(rs.getString("ANUONG"));
               newUser.setDiLai(rs.getString("DILAI"));
               newUser.setyTe(rs.getString("YTE"));
               newUser.setLienLac(rs.getString("LIENLAC"));
               newUser.setKhac(rs.getString("KHAC"));

               listOutcome.add(newUser);
           }
       } catch (SQLException e) {
           System.out.println("Lỗi tại lấy toàn bộ outcome");
       }
       return listOutcome;
   }
    
    public List<outcome> getAllNguoiDungid_thang(String tim){
       List<outcome> listXe = new ArrayList<>();
       Connection con = GetConnectServer.getConnection();
       String sql="Select * from CHI where (STT like '%" + tim + "%') "
               + "or (THANG like '%" + tim + "%') ";
       try {
           PreparedStatement preparedStatement = con.prepareStatement(sql);
           ResultSet rs = preparedStatement.executeQuery();
           while(rs.next())
           {
               outcome newUser = new outcome();
               
               newUser.setStt(rs.getInt("STT"));
               newUser.setThang(rs.getInt("THANG"));
               newUser.setDienNuoc(rs.getString("DIENNUOC"));
               newUser.setNha(rs.getString("NHA"));
               newUser.setAnUong(rs.getString("ANUONG"));
               newUser.setDiLai(rs.getString("DILAI"));
               newUser.setyTe(rs.getString("YTE"));
               newUser.setLienLac(rs.getString("LIENLAC"));
               newUser.setKhac(rs.getString("KHAC"));
               
               listXe.add(newUser);
           }
       } catch (SQLException e) {
           System.out.println("Lỗi tại lấy toàn bộ income");
       }
       return listXe;
   }
}
