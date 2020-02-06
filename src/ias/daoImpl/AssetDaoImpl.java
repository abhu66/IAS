/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ias.daoImpl;

import ias.ConnectionMariaDb;
import ias.dao.AssetDao;
import ias.models.Asset;
import ias.view.FormEditAsset;
import ias.view.FormNewAsset;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author asyst
 */
public class AssetDaoImpl implements AssetDao{
    
    String query_insert_new         = "INSERT INTO Asset values(null,?,?,?,?,?,?)";
    String query_list_asset         = "SELECT * FROM Asset";
    String query_list_asset_all     = "SELECT * FROM Asset ORDER BY code DESC";
    String query_find_by_code       = "SELECT * FROM Asset where code = ?";
    String query_update_asset       = "UPDATE Asset set code = ?, name = ? ,description = ?, conditions = ? where id = ? ";
    String query_update_status      = "UPDATE asset set status = ? where code = ?";
    
    PreparedStatement ps;
    ResultSet rs;
    Connection conn;
    
    public AssetDaoImpl(){
        super();
        conn = ConnectionMariaDb.getConnection();
    }

    @Override
    public void addNewAsset(Asset asset,FormNewAsset formNewAsset) {
        try {
            ps = conn.prepareStatement(query_insert_new);
            ps.setString(1, asset.code);
            ps.setString(2, asset.name);
            ps.setString(3, asset.description);
            ps.setString(4, asset.condition);
            ps.setString(5, new SimpleDateFormat("yyyy-MM-dd").format(asset.createdDate));
            ps.setString(6, asset.status);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Berhasil disimpan !");
            formNewAsset.dispose();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Gagal disimpan ! "+ex.getMessage());
            Logger.getLogger(AssetDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Asset> getAllAsset(String param) {
        List<Asset> listAsset = new ArrayList<>();
        try {
            
            String query = query_list_asset;
            StringBuilder sb = new StringBuilder();
            sb.append(query);
            if(param.length() == 0 || param.isEmpty() || param == null){
               ps = conn.prepareStatement(sb.toString());
            }
            else {
                sb.append(" where code = ? or name like '%").append(param).append("%'");
                System.out.println("Query = "+sb.toString());
                ps = conn.prepareStatement(sb.toString());
                ps.setString(1, param);
                 
               

            }
            rs = ps.executeQuery();
            while(rs.next()){
                Asset asset =  new Asset(
                         rs.getInt("id"),
                         rs.getString("code"),
                         rs.getString("name"),
                         rs.getString("description"),  
                         rs.getString("conditions"),
                         rs.getDate("created_date"),
                         rs.getString("status"));
                listAsset.add(asset);
            } 
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Gagal load data assets ! "+ex.getMessage());
            Logger.getLogger(AssetDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }   
        return listAsset;
    }

    @Override
    public Asset finByCode(String code) {
         Asset asset = null;
        try {
            ps = conn.prepareStatement(query_find_by_code);
            ps.setString(1, code);
            rs = ps.executeQuery();
            while(rs.next()){
               asset =  new Asset(
                         rs.getInt("id"),
                         rs.getString("code"),
                         rs.getString("name"),
                         rs.getString("description"),  
                         rs.getString("conditions"),
                         rs.getDate("created_date"),
                         rs.getString("status"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(AssetDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return asset;
    }

    @Override
    public void saveOnEdit(Asset asset, FormEditAsset formEditAsset) {
        try {
            ps = conn.prepareStatement(query_update_asset);
            ps.setString(1, asset.code);
            ps.setString(2, asset.name);
            ps.setString(3, asset.description);
            ps.setString(4, asset.condition);
            ps.setInt(5,asset.id);
            System.out.println("ID: "+asset.id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Berhasil diubah !");
            formEditAsset.dispose();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Gagal diubah ! "+ex.getMessage());
            Logger.getLogger(AssetDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateStatus(String code) {
        try {
            ps = conn.prepareStatement(query_update_status);
            ps.setString(1,"TERSEDIA");
            ps.setString(2, code);
         
            ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Gagal diubah ! "+ex.getMessage());
            Logger.getLogger(AssetDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }//To change body of generated methods, choose Tools | Templates.
    }
}
