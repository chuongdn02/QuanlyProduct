/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author chuon
 */
public class ProductData {
    String tenSP,khuyenMai;
    int maSP,gia,soLuong;

    public ProductData() {
    }

    public ProductData(int maSP, String tenSP, int gia, String khuyenMai, int soLuong) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.gia = gia;
        this.khuyenMai = khuyenMai;
        this.soLuong = soLuong;
    }

    
    
    public int getmaSP() {
        return maSP;
    }
    

    public void setmaSP(int maSP) {
        this.maSP = maSP;
    }

    public String getName() {
        return tenSP;
    }

    public void setName(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getgia() {
        return gia;
    }

    public void setgia(int gia) {
        this.gia = gia;
    }

    public String getkhuyenMai() {
        return khuyenMai;
    }

    public void setkhuyenMai(String khuyenMai) {
        this.khuyenMai = khuyenMai;
    }

    public int getsoLuong() {
        return soLuong;
    }

    public void setsoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

  
    }


