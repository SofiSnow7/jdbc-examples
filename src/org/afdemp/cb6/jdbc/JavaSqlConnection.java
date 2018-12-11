/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.afdemp.cb6.jdbc;


import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import static javax.swing.text.html.HTML.Tag.SELECT;

/**
 *
 * @author Sofia
 */
public class JavaSqlConnection {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {           

            String user     = "eshopAdmin";
            String password = "eshopAdmin123";
            
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/eshop?characterEncoding=utf-8&autoReconnect=true",
                user,
                password
            );                         
                  
            Statement stmt = con.createStatement();   
            
            ResultSet rs = stmt.executeQuery("SELECT name, count(pid) as Users FROM product left join favourites on product.id = favourites.uid group by name");
            
            while(rs.next()) {
                String name  = rs.getString(1);
                int Users    = rs.getInt(2);                
                
                System.out.println("Product: " + name + " , Users: " + Users);
            }                        
        }
        catch(Throwable t) {
            System.out.println(t.getMessage());
            t.printStackTrace();
        }
                
        
    }
    
}

        
      
