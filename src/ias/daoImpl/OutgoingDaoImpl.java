/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ias.daoImpl;

import ias.ConnectionMariaDb;
import ias.dao.OutgoingDao;
import ias.models.Outgoing;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author asyst
 */
public class OutgoingDaoImpl implements OutgoingDao{

    String query_insert_new         = "INSERT INTO tr_outgoing values(null,?,?,?,?,?,?,?)";
    String query_generate_number    = "SELECT * FROM tr_outgoing order by tr_number desc";
   
    PreparedStatement ps;
    ResultSet rs;
    Connection conn;
    
     public OutgoingDaoImpl(){
        super();
        conn = ConnectionMariaDb.getConnection();
    }
    
    @Override
    public void addNewOutgoing(Outgoing outgoing) {
       try {
            ps = conn.prepareStatement(query_insert_new);
            ps.setString(1, outgoing.getTr_number());
            ps.setString(2, outgoing.getId_pic());
            ps.setInt(3, outgoing.getTotal_asset());
            ps.setString(4, outgoing.getType());
            ps.setString(5, new SimpleDateFormat("yyyy-MM-dd").format(outgoing.getStartDate()));
            ps.setString(6, outgoing.getEndDate() != null ? new SimpleDateFormat("yyyy-MM-dd").format(outgoing.getEndDate()) : 
                    new SimpleDateFormat("yyyy-MM-dd").format(new  Date()));
            ps.setString(7,"NOT COMPLETE");
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Gagal membuat transaksi baru ! "+ex.getMessage());
            Logger.getLogger(OutgoingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public String generateNumberTr(){
        String tr_number = "";
        try {
            ps =conn.prepareStatement(query_generate_number);
            rs = ps.executeQuery();
            if(rs.next()){
                String trNumber = rs.getString("tr_number").substring(3);
                String AN = "" + (Integer.parseInt(trNumber) + 1);
                String NOL      = "";
                 if(AN.length()==1){
                     NOL = "00000";
                }else if(AN.length()==2){
                    NOL = "0000";
                }else if(AN.length()==3){
                    NOL = "000";
                }else if(AN.length()==4){
                    NOL = "00";
                }else if(AN.length()==5){
                    NOL = "0";
                }else if(AN.length()==6){
                    NOL = "";
                }
                 tr_number = "TR_" + NOL + AN;
            }
            else {
                tr_number = "TR_000001";
            }
        } catch (SQLException ex) {
            Logger.getLogger(OutgoingDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tr_number;
    }
}
