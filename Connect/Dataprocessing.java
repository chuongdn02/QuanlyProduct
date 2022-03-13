/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Connect;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.ProductData;
import models.Account;
/**
 *
 * @author chuon
 */
public class Dataprocessing {
   public List<ProductData> GetAllProductData() {
        List<ProductData> PrData = new ArrayList<ProductData>();
        Connection conn = Connect.ConnectSQL();
        
        try {
            PreparedStatement ps = conn.prepareStatement("select * from ProductData");
            ResultSet result = ps.executeQuery();
            
            while (result.next()) {
                ProductData PrD = new ProductData();
                
                PrD.setmaSP(result.getInt("maSP"));
                PrD.setName(result.getString("tenSp"));
                PrD.setgia(result.getInt("gia"));
                PrD.setkhuyenMai(result.getString("khuyenMai"));
                PrD.setsoLuong(result.getInt("soLuong"));                      
                PrData.add(PrD);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dataprocessing.class.getName()).log(Level.SEVERE, null, ex);
        }
        return PrData;
    }
    
    public List<Account> GetAllAccount() {
        List<Account> accounts = new ArrayList<Account>();
        Connection conn = Connect.ConnectSQL();
        
        try {
            PreparedStatement ps = conn.prepareStatement("select * from Account");
            ResultSet result = ps.executeQuery();
            
            while (result.next()) {
                Account account = new Account();
                
                account.setID(result.getString("id"));
                account.setPassword(result.getString("password"));
                
                accounts.add(account);
            }
            return accounts;
        } catch (SQLException ex) {
            Logger.getLogger(Dataprocessing.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Account TestLogin(String id) {
        Connection conn = Connect.ConnectSQL();
        
        try {
            PreparedStatement ps = conn.prepareStatement("select * from Account");
            ResultSet result = ps.executeQuery();
            
            while (result.next()) {
                if(result.getString("id").equals(id)) {
                    Account acc = new Account();
                    System.out.println(id);
                    acc.setID(result.getString("id"));
                    acc.setPassword(result.getString("password"));
                    
                    return acc;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dataprocessing.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void SigupAccount(Account account) {
        Connection conn = Connect.ConnectSQL();
        
        try {
            PreparedStatement ps = conn.prepareStatement("insert into Account values (?,?)");
            ps.setString(1, account.getID());
            ps.setString(2, account.getPassword());
            
            int result  = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Dataprocessing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void AddNewProductData(ProductData PrD) {
        Connection conn = Connect.ConnectSQL();
        
        try {
            PreparedStatement ps = conn.prepareStatement("insert into ProductData values (?,?,?,?,?)");
            ps.setInt(1, PrD.getmaSP());
            ps.setString(2, PrD.getName());
            ps.setInt(3, PrD.getgia());
            ps.setString(4, PrD.getkhuyenMai());
            ps.setInt(5, PrD.getsoLuong());        
            
            int result  = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Dataprocessing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void DeleteProductData(String id) {
        Connection conn = Connect.ConnectSQL();
        
        try {
            PreparedStatement ps = conn.prepareStatement("delete from ProductData where maSP = ?");
            ps.setString(1, id);

            int result  = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Dataprocessing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void UpdateProductData(ProductData PrD) {
        Connection conn = Connect.ConnectSQL();
        
        try {
            PreparedStatement ps = conn.prepareStatement("update ProductData "
                    + "set tenSp = ?,gia = ?,khuyenMai = ?,soLuong = ?"
                    + "where maSp = ?");
          
            ps.setString(1, PrD.getName());
            ps.setInt(2, PrD.getgia());
            ps.setString(3, PrD.getkhuyenMai());
            ps.setInt(4, PrD.getsoLuong());  
            ps.setInt(5, PrD.getmaSP());
            int result  = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Dataprocessing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<ProductData> GetResultSearch(String searchType,String valueSearch) {
        List<ProductData> PrData = new ArrayList<>();
        Connection conn = Connect.ConnectSQL();
        
        try {
            PreparedStatement ps = null;
            switch(searchType) {
            case "maSP" : 
                 ps = conn.prepareStatement("select * from ProductData where maSp = ?");
                ps.setObject(1, valueSearch);  
                break;
            
            case "tenSP" : 
                 ps = conn.prepareStatement("select * from ProductData where tenSP = ?");
                ps.setObject(2, valueSearch);  
                break;
             
            case "gia" : 
                 ps = conn.prepareStatement("select * from ProductData where gia = ?");
                ps.setObject(3, valueSearch);  
                break;
                
            case "khuyenMai" : 
                 ps = conn.prepareStatement("select * from ProductData where khuyenMai = ?");
                ps.setObject(4, valueSearch);  
                break;   
             
            case "soLuong" : 
                 ps = conn.prepareStatement("select * from ProductData where soLuong = ?");
                ps.setObject(5, valueSearch);  
                break;
            }
            

            ResultSet result = ps.executeQuery();
            
            while(result.next()) {
                ProductData PrD = new ProductData();
                
                PrD.setmaSP(result.getInt("maSP"));
                PrD.setName(result.getString("tenSp"));
                PrD.setgia(result.getInt("gia"));
                PrD.setkhuyenMai(result.getString("khuyenMai"));
                PrD.setsoLuong(result.getInt("soLuong"));                                 
                PrData.add(PrD);
            }
            return PrData;
        } catch (SQLException ex) {
            Logger.getLogger(Dataprocessing.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    } 
}
