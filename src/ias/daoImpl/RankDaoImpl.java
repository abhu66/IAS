/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ias.daoImpl;

import ias.ConnectionMariaDb;
import ias.dao.RankDao;
import ias.models.Rank;
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
public class RankDaoImpl implements RankDao{
    
    String query_list_rank         = "SELECT * FROM pangkat";
  
    PreparedStatement ps;
    ResultSet rs;
    Connection conn;
    
    public RankDaoImpl(){
        super();
        conn = ConnectionMariaDb.getConnection();
    }

    @Override
    public List<Rank> getAllRank() {
        List<Rank> listAllRank = new ArrayList();
        try {
            ps = conn.prepareStatement(query_list_rank);
            rs = ps.executeQuery();
            while(rs.next()){
                Rank rank = new Rank(rs.getInt("id"), rs.getString("name"));
                listAllRank.add(rank);
            }} catch (SQLException ex) {
            Logger.getLogger(RankDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
       return listAllRank;
    }
}
