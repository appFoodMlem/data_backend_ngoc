/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLST;

/**
 *
 * @author Admin
 */
public class Product {
    private int ma_sp;
    private String ten_sp;
    private float gia_nhap;
    private float gia_ban;

    public Product() {
    }

    public Product(int ma_sp, String ten_sp, float gia_nhap, float gia_ban) {
        this.ma_sp = ma_sp;
        this.ten_sp = ten_sp;
        this.gia_nhap = gia_nhap;
        this.gia_ban = gia_ban;
    }

    public int getMa_sp() {
        return ma_sp;
    }

    public void setMa_sp(int ma_sp) {
        this.ma_sp = ma_sp;
    }

    public String getTen_sp() {
        return ten_sp;
    }

    public void setTen_sp(String ten_sp) {
        this.ten_sp = ten_sp;
    }

    public float getGia_nhap() {
        return gia_nhap;
    }

    public void setGia_nhap(float gia_nhap) {
        this.gia_nhap = gia_nhap;
    }

    public float getGia_ban() {
        return gia_ban;
    }

    public void setGia_ban(float gia_ban) {
        this.gia_ban = gia_ban;
    }
    
}
