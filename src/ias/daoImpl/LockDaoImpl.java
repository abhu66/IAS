/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ias.daoImpl;

import ias.ConnectionMariaDb;
import ias.dao.LockDao;
import ias.models.Lock;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author asyst
 */
public class LockDaoImpl implements LockDao{

    String query_insert_new         = "INSERT INTO tr_lock values(null,?,?)";
    String query_update_lock        = "UPDATE tr_lock set is_lock = ? where tr_number = ? ";
    String query_delete             = "DELETE FROM tr_lock where tr_number = ?";
    String query_find_bytrnumber    = "SELECT * FROM tr_lock where tr_number = ?";
    
    PreparedStatement ps;
    ResultSet rs;
    Connection conn;
    
    public LockDaoImpl(){
        conn = ConnectionMariaDb.getConnection();
    }
    @Override
    public void addNew(Lock lock) {
        //To change body of generated methods, choose Tools | Templates.
         try {
            ps = conn.prepareStatement(query_insert_new);
            ps.setBoolean(1, lock.isIsLock());
            ps.setString(2, lock.getTr_number());
            ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Gagal membuat kunci ! "+ex.getMessage());
            Logger.getLogger(LockDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateLock(Lock lock) {
       try {
            ps = conn.prepareStatement(query_update_lock);
            ps.setBoolean(1, lock.isIsLock());
            ps.setString(2, lock.getTr_number());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Transaksi berhasil dikunci !");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Transaksi Gagal dikunci ! "+ex.getMessage());
            Logger.getLogger(LockDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteLock(String tr_number) {
        try {
            ps = conn.prepareStatement(query_delete);
            ps.setString(1, tr_number);
            ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Gagal membuat kunci ! "+ex.getMessage());
            Logger.getLogger(LockDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Lock findByTrNumber(String tr_number) {
        Lock lock = null;
     try {
            ps = conn.prepareStatement(query_find_bytrnumber);
            ps.setString(1, tr_number);
            rs = ps.executeQuery();
            if(rs.next()){
                lock =  new Lock(rs.getInt("id"),
                        rs.getBoolean("is_lock"),
                        rs.getString("tr_number"));

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Gagal membuat kunci ! "+ex.getMessage());
            Logger.getLogger(LockDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
     
     return lock;
    }
    
}
