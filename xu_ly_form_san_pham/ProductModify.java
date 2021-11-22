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
public class ProductModify {
    // thêm mới
    public int add(Product pr){
        Connection conn=null;
        PreparedStatement sttm=null;
        try {
           String query="insert hang_hoa(ten_hang,gia_nhap,gia_ban) values(?,?,?)";
            conn=DriverManager.getConnection("jdbc:mysql://localhost/bán hàng", "root", "");
            sttm=conn.prepareStatement(query);
            sttm.setString(1,pr.getTen_sp());
            sttm.setFloat(2, pr.getGia_nhap());
            sttm.setFloat(3, pr.getGia_ban());
            
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
     public int update(Product pr){
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
           String query="update hang_hoa set ten_hang=?,gia_nhap=?,gia_ban=? where ma_hang=?";
            conn=DriverManager.getConnection("jdbc:mysql://localhost/bán hàng", "root", "");
            sttm=conn.prepareStatement(query);
            sttm.setString(1,pr.getTen_sp());
            sttm.setFloat(2, pr.getGia_nhap());
            sttm.setFloat(3, pr.getGia_ban());
            sttm.setInt(4, pr.getMa_sp());
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
     public int delete(int ma_hang){
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
           String query="delete from hang_hoa where ma_hang = ?";
           conn=DriverManager.getConnection("jdbc:mysql://localhost/bán hàng", "root", "");
           sttm=conn.prepareStatement(query);
            sttm.setInt(1,ma_hang);
            
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
     public List<Product> getAllProduct(){
         List<Product>ls=new ArrayList<>();
        Connection conn=null;
        Statement sttm=null;
        try {
            String query="select ma_hang,ten_hang,gia_nhap,gia_ban from hang_hoa";
            conn = DriverManager.getConnection("jdbc:mysql://localhost/bán hàng", "root", "");
            sttm=conn.createStatement();
            ResultSet rs=sttm.executeQuery(query);
            while(rs.next()){
                Product pr=new Product();
                pr.setMa_sp(rs.getInt(1));
                pr.setTen_sp(rs.getString(2));
                pr.setGia_nhap(rs.getFloat(3));
                pr.setGia_ban(rs.getFloat(4));
                
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
     public Product getProductById(int ma_hang) {
         Product pr=new Product();
         Connection conn = null;
        PreparedStatement sttm = null;
         try {
             String query="select ma_hang,ten_hang,gia_nhap,gia_ban from hang_hoa where ma_hang=?";
             conn=DriverManager.getConnection("jdbc:mysql://localhost/bán hàng", "root", "");
           sttm=conn.prepareStatement(query); 
            sttm.setInt(1,ma_hang);
            ResultSet rs=sttm.executeQuery();
            while(rs.next()){
                pr.setMa_sp(rs.getInt(1));
                pr.setTen_sp(rs.getString(2));
                pr.setGia_nhap(rs.getFloat(3));
                pr.setGia_ban(rs.getFloat(4));
                
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
     public Product getProductByName(String ten_hang) {
         Product pr=new Product();
         Connection conn = null;
        PreparedStatement sttm = null;
         try {
             String query="select ma_hang,ten_hang,gia_nhap,gia_ban from hang_hoa where ten_hang=?";
             conn=DriverManager.getConnection("jdbc:mysql://localhost/bán hàng", "root", "");
           sttm=conn.prepareStatement(query); 
            sttm.setString(1,ten_hang);
            ResultSet rs=sttm.executeQuery();
            while(rs.next()){
                pr.setMa_sp(rs.getInt(1));
                pr.setTen_sp(rs.getString(2));
                pr.setGia_nhap(rs.getFloat(3));
                pr.setGia_ban(rs.getFloat(4));
                
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
