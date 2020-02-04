/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ias.daoImpl;

import ias.ConnectionMariaDb;
import ias.dao.TransactionDao;
import ias.models.Asset;
import ias.models.Transaction;
import ias.view.FormOutgoing;
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
public class TransactionDaoImpl implements TransactionDao{

    
    String query_insert_new         = "INSERT INTO transaction values(null,?,?,?,?,?,?,?)";
    String query_list_tr            = "SELECT * FROM transaction where tr_number = ?";
   
    PreparedStatement ps;
    ResultSet rs;
    Connection conn;
    
     public TransactionDaoImpl(){
        super();
        conn = ConnectionMariaDb.getConnection();
    }
    @Override
    public void addNew(Transaction transaction,FormOutgoing formOutgoing) {
        
         try {
            ps = conn.prepareStatement(query_insert_new);
            ps.setString(1, transaction.getTr_number());
            ps.setString(2, transaction.getPerson_id());
            ps.setString(3, transaction.getAsset_id());
            ps.setString(4, new SimpleDateFormat("yyyy-MM-dd").format(transaction.getStarDate()));
             ps.setString(5, new SimpleDateFormat("yyyy-MM-dd").format(transaction.getEndDate()));
            ps.setString(6,transaction.getStatus());
            ps.setString(7, transaction.getType());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(formOutgoing, "Tambah data berhasil !");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Gagal menambah item baru ! "+ex.getMessage());
            Logger.getLogger(TransactionDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Transaction> listTransaction(String param) {
        List<Transaction> listTransaction = new ArrayList<>();
        try {
            ps = conn.prepareStatement(query_list_tr);
            ps.setString(1, param);
            rs = ps.executeQuery();
            while(rs.next()){
                Transaction transaction =  new Transaction(
                         rs.getInt("id"),
                         rs.getString("tr_number"),
                         rs.getString("id_pic"),
                         rs.getString("id_asset"),  
                         rs.getDate("start_date"),
                         rs.getDate("end_date"),
                         rs.getString("status"),
                         rs.getString("type"));
                listTransaction.add(transaction);
            } 
            
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Gagal load data assets ! "+ex.getMessage());
            Logger.getLogger(TransactionDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }   
        return listTransaction; 
    }
}
