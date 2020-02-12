/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ias.daoImpl;

import ias.ConnectionMariaDb;
import ias.dao.UnitDao;
import ias.models.Unit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asyst
 */
public class UnitDaoImpl implements UnitDao{
 
    String query_list_unit        = "SELECT * FROM satuan";
  
    PreparedStatement ps;
    ResultSet rs;
    Connection conn;
    
    public UnitDaoImpl(){
        super();
        conn = ConnectionMariaDb.getConnection();
    }
    @Override
    public List<Unit> getAllUnit() {
        List<Unit> listAllUnit = new ArrayList();
        try {
            ps = conn.prepareStatement(query_list_unit);
            rs = ps.executeQuery();
            while(rs.next()){
                Unit unit = new Unit(rs.getInt("id"), rs.getString("name"));
                listAllUnit.add(unit);
            }} catch (SQLException ex) {
            Logger.getLogger(UnitDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
       return listAllUnit;
        
    }
    
    
}
