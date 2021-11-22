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
public class CustomerModify {
    // thêm mới
    public int add(Customer pr){
        Connection conn=null;
        PreparedStatement sttm=null;
        try {
           String query="insert khach_hang(ten_khach,sdt_khach) values(?,?)";
            conn=DriverManager.getConnection("jdbc:mysql://localhost/bán hàng", "root", "");
            sttm=conn.prepareStatement(query);
            sttm.setString(1,pr.getTen_khach());
            sttm.setString(2, pr.getSdt_khach());
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
     public int update(Customer pr){
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
           String query="update khach_hang set ten_khach=?,sdt_khach=? where ma_khach=?";
            conn=DriverManager.getConnection("jdbc:mysql://localhost/bán hàng", "root", "");
            sttm=conn.prepareStatement(query);
            sttm.setString(1,pr.getTen_khach());
            sttm.setString(2, pr.getSdt_khach());
            sttm.setInt(3, pr.getMa_khach());
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
     public int delete(int ma_khach){
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
           String query="delete from khach_hang where ma_khach = ?";
           conn=DriverManager.getConnection("jdbc:mysql://localhost/bán hàng", "root", "");
           sttm=conn.prepareStatement(query);
            sttm.setInt(1,ma_khach);
            
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
     public List<Customer> getAllCustomer(){
         List<Customer>ls=new ArrayList<>();
        Connection conn=null;
        Statement sttm=null;
        try {
            String query="select ma_khach,ten_khach,sdt_khach from khach_hang";
            conn = DriverManager.getConnection("jdbc:mysql://localhost/bán hàng", "root", "");
            sttm=conn.createStatement();
            ResultSet rs=sttm.executeQuery(query);
            while(rs.next()){
                Customer pr=new Customer();
                pr.setMa_khach(rs.getInt(1));
                pr.setTen_khach(rs.getString(2));
                pr.setSdt_khach(rs.getString(3));
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
     public Customer getCustomerById(int ma_khach) {
         Customer pr=new Customer();
         Connection conn = null;
        PreparedStatement sttm = null;
         try {
             String query="select ma_khach,ten_khach,sdt_khach from khach_hang where ma_khach=?";
             conn=DriverManager.getConnection("jdbc:mysql://localhost/bán hàng", "root", "");
           sttm=conn.prepareStatement(query); 
            sttm.setInt(1,ma_khach);
            ResultSet rs=sttm.executeQuery();
            while(rs.next()){
                pr.setMa_khach(rs.getInt(1));
                pr.setTen_khach(rs.getString(2));
                pr.setSdt_khach(rs.getString(3));
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
     public Customer getCustomerByName(String ten_khach) {
         Customer pr=new Customer();
         Connection conn = null;
        PreparedStatement sttm = null;
         try {
             String query="select ma_khach,ten_khach,sdt_khach from khach_hang where ten_khach=?";
             conn=DriverManager.getConnection("jdbc:mysql://localhost/bán hàng", "root", "");
           sttm=conn.prepareStatement(query); 
            sttm.setString(1,ten_khach);
            ResultSet rs=sttm.executeQuery();
            while(rs.next()){
                pr.setMa_khach(rs.getInt(1));
                pr.setTen_khach(rs.getString(2));
                pr.setSdt_khach(rs.getString(3));
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
