/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packages;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author suleyman
 */
public class baglanti {
    protected static final String HOSTNAME="jdbc:mysql://localhost:3306/rent_a_car";
    protected static final String USER = "root";
    protected static final String PASSWORD = "2472";
    Connection con =null;
    
    protected Connection baglan ()
    {
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(HOSTNAME,USER,PASSWORD);
            System.out.println("Veri tabanina baglandi");
        }
        catch (Exception e) 
        {
            System.out.println(e.getMessage()+"hata!!!");
        }
        return con;    
    }
    
    protected void baglantiKes ()
    {
        try 
        {
          con.close();
          
        } catch (Exception e) 
        {
          System.out.println("Veri tabanına Bağlanamadı");
        }    
    }
}
