/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lekce305;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author 2019-e-edlund
 */
public class ConTest {
    
    enum Dst{
        A ,E , N , O , S , U , Z;
    }
    
    public static void main(String[] args) throws SQLException {
        try(Connection con = DriverManager.getConnection(Config.URL, Config.USER, Config.PASSWORD)){
            try(Statement stmt = con.createStatement()){
                try(ResultSet res = stmt.executeQuery("SELECT * FROM airport")){
                    while(res.next()){
                        //System.out.println(res.getString("name"));
                        Dst dst = Dst.valueOf(res.getString("dst"));
                        //System.out.println(dst);
                           System.out.println(dst + " ");
                           System.out.println(res.getString("name"));
                        
                    }
                }
            }
        }
    }
}
    

        
       

