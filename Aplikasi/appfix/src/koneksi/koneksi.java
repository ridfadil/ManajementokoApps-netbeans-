/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author finnaica
 */
public class koneksi {
    private static Connection con;
    public static Connection getConnection(){
        if(con==null){
            try{
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/manajementoko","root","");
            }catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null, "Tidak Tersambung ke Database");
            }
        }
        return con;
    }
}
