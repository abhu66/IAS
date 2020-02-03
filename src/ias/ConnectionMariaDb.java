/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ias;

import ias.view.FormLogin;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author asyst
 */
public class ConnectionMariaDb {

    private static Connection conn;

    public static Connection getConnection() {
        try {
            String url = "jdbc:mysql://localhost/ias_db";
            String user = "root";
            String password = "";
            conn = DriverManager.getConnection(url, user, password);
            System.err.println("Connection Success");
            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Windows".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            FormLogin fl = new FormLogin(null, true);
            fl.setVisible(true);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Connection Failed ! " + e.getMessage());
        }
        return conn;
    }
}
