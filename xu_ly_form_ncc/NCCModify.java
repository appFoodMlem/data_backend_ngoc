/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLST;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class NCCModify {
     // thêm mới
    public int add(quan_ly_ncc pr){
        Connection conn=null;
        PreparedStatement sttm=null;
        try {
           String query="insert nha_cc(ten_ncc,sdt_ncc) values(?,?)";
            conn=DriverManager.getConnection("jdbc:mysql://localhost/bán hàng", "root", "");
            sttm=conn.prepareStatement(query);
            sttm.setString(1,pr.getTen_ncc());
            sttm.setString(2, pr.getSdt_ncc());
            if(sttm.executeUpdate()>0)
            {
                System.out.println("Thêm mới thành công");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error"+e.toString());
        }finally{
            try {
                conn.close();
                sttm.close();
                       
            } catch (Exception e) {
            }
        }
        return -1;   //nếu thêm k thành công
    }
    //  sửa
     public int update(quan_ly_ncc pr){
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
           String query="update nha_cc set ten_ncc=?,sdt_ncc=? where ma_ncc=?";
            conn=DriverManager.getConnection("jdbc:mysql://localhost/bán hàng", "root", "");
            sttm=conn.prepareStatement(query);
            sttm.setString(1,pr.getTen_ncc());
            sttm.setString(2, pr.getSdt_ncc());
            sttm.setInt(3, pr.getMa_ncc());
            if(sttm.executeUpdate()>0)
            {
                System.out.println("sửa thành công");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error: "+e.toString());
        }finally{
            try {
                conn.close();
                sttm.close();
                       
            } catch (Exception e) {
            }
        }
        return -1;   
    }
     //xóa theo id
     public int delete(int ma_ncc){
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
           String query="delete from nha_cc where ma_ncc = ?";
           conn=DriverManager.getConnection("jdbc:mysql://localhost/bán hàng", "root", "");
           sttm=conn.prepareStatement(query);
            sttm.setInt(1,ma_ncc);
            
            if(sttm.executeUpdate()>0)
            {
                System.out.println("Xóa thành công");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error"+e.toString());
        }
        return -1;   
    }
     
     //show tất cả
     public List<quan_ly_ncc> getAllProducter(){
         List<quan_ly_ncc>ls=new ArrayList<>();
        Connection conn=null;
        Statement sttm=null;
        try {
            String query="select ma_ncc,ten_ncc,sdt_ncc from nha_cc";
            conn = DriverManager.getConnection("jdbc:mysql://localhost/bán hàng", "root", "");
            sttm=conn.createStatement();
            ResultSet rs=sttm.executeQuery(query);
            while(rs.next()){
                quan_ly_ncc pr=new quan_ly_ncc();
                pr.setMa_ncc(rs.getInt(1));
                pr.setTen_ncc(rs.getString(2));
                pr.setSdt_ncc(rs.getString(3));
                ls.add(pr);                  
            }
        } catch (Exception e) {
            System.out.println("Error"+e.toString());
        }finally{
            try {
                sttm.close();conn.close();
            } catch (Exception e) {
            }
        }
         return ls;
     }
     // tìm theo id 
     public quan_ly_ncc getProducterById(int ma_ncc) {
         quan_ly_ncc pr=new quan_ly_ncc();
         Connection conn = null;
        PreparedStatement sttm = null;
         try {
             String query="select ma_ncc,ten_ncc,sdt_ncc from nha_cc where ma_ncc=?";
             conn=DriverManager.getConnection("jdbc:mysql://localhost/bán hàng", "root", "");
           sttm=conn.prepareStatement(query); 
            sttm.setInt(1,ma_ncc);
            ResultSet rs=sttm.executeQuery();
            while(rs.next()){
                pr.setMa_ncc(rs.getInt(1));
                pr.setTen_ncc(rs.getString(2));
                pr.setSdt_ncc(rs.getString(3));
                return pr;
            }
                
         } catch (Exception e) {
                 System.out.println("Error"+e.toString());      
         }finally{
            try {
                sttm.close();
                conn.close();
            } catch (Exception e) {
            }
         }
         return null;
     }
     // tìm kiếm theo tên
     public quan_ly_ncc getProducterByName(String ten_ncc) {
         quan_ly_ncc pr=new quan_ly_ncc();
         Connection conn = null;
        PreparedStatement sttm = null;
         try {
             String query="select ma_ncc,ten_ncc,sdt_ncc from nha_cc where ten_ncc=?";
             conn=DriverManager.getConnection("jdbc:mysql://localhost/bán hàng", "root", "");
           sttm=conn.prepareStatement(query); 
            sttm.setString(1,ten_ncc);
            ResultSet rs=sttm.executeQuery();
            while(rs.next()){
                pr.setMa_ncc(rs.getInt(1));
                pr.setTen_ncc(rs.getString(2));
                pr.setSdt_ncc(rs.getString(3));
                return pr;
            }
                
         } catch (Exception e) {
                 System.out.println("Error"+e.toString());      
         }finally{
            try {
                sttm.close();
                conn.close();
            } catch (Exception e) {
            }
         }
         return null;// nếu k tìm thấy thì trả về null
     }
}
