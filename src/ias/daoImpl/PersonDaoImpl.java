/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ias.daoImpl;

import ias.ConnectionMariaDb;
import ias.dao.PersonDao;
import ias.models.Asset;
import ias.models.Person;
import ias.view.FormNewPic;
import java.sql.Connection;
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
public class PersonDaoImpl implements PersonDao{
    String query_insert_new             = "INSERT INTO Person values(null,?,?,?,?,?)";
    String query_list_person            = "SELECT * FROM Person WHERE nip = ? or name = ?";
    String query_list_person_all        = "SELECT * FROM Person ORDER BY id DESC";
    String query_find_by_nip            = "SELECT * FROM Person where nip = ?";
    String query_update_person          = "UPDATE Person set name = ? ,rank = ?, position = ?,phone_number = ? where nip = ? ";
  
    PreparedStatement ps;
    ResultSet rs;
    Connection conn;

    public PersonDaoImpl() {
        super();
        conn = ConnectionMariaDb.getConnection();
    }
    
    
    @Override
    public void addNewPic(Person person,FormNewPic formNewPic) {
      try {
            ps = conn.prepareStatement(query_insert_new);
            ps.setString(1, person.getNip());
            ps.setString(2, person.getName());
            ps.setString(3, person.getRank());
            ps.setString(4, person.getPosition());
            ps.setString(5, person.getPhone_number());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Berhasil disimpan !");
            formNewPic.tablePerson();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Gagal disimpan ! "+ex.getMessage());
            Logger.getLogger(PersonDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Person> getAllPerson(String param) {
         List<Person> listPerson = new ArrayList<>();
        try {
            if(param.length() == 0 || param.isEmpty() || param == null){
               ps = conn.prepareStatement(query_list_person_all);
            }
            else {
                 ps = conn.prepareStatement(query_list_person);
                 ps.setString(1, param);
                 ps.setString(2, param);

            }
            rs = ps.executeQuery();
            while(rs.next()){
                Person person =  new Person(
                         rs.getInt("id"),
                         rs.getString("nip"),
                         rs.getString("name"),
                         rs.getString("rank"),  
                         rs.getString("position"),
                         rs.getString("phone_number"));
                         listPerson.add(person);
            } 
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Gagal load data assets ! "+ex.getMessage());
            Logger.getLogger(PersonDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }   
        return listPerson;
    }

    @Override
    public Person findByNip(String nip) {
         Person person = null;
        try {
            ps = conn.prepareStatement(query_find_by_nip);
            ps.setString(1, nip);
            rs = ps.executeQuery();
            while(rs.next()){
                person =  new Person(
                         rs.getInt("id"),
                         rs.getString("nip"),
                         rs.getString("name"),
                         rs.getString("rank"),  
                         rs.getString("position"),
                         rs.getString("phone_number"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return person;
    }

    @Override
    public void saveOnEdit(Person person) {
       try {
            ps = conn.prepareStatement(query_update_person);
  
            ps.setString(1, person.getName());
            ps.setString(2, person.getRank());
            ps.setString(3, person.getPosition());
            ps.setString(4, person.getPhone_number());
            ps.setString(5, person.getNip());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Berhasil diubah !");
            //formNewPic.tablePerson();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Gagal diubah ! "+ex.getMessage());
            Logger.getLogger(PersonDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
