/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pustak;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author DHEERAJ
 */
public class PustakDB {
    Connection con;
    Statement stm;
    ResultSet rs;
    
    public PustakDB()
    {
        try{
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/pustak","root","rootwdp");
        stm=con.createStatement();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public static void main(String args[])
    {
        PustakDB ob1=new PustakDB();
    }
}
