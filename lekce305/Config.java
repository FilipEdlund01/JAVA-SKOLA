/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lekce305;

/**
 *
 * @author 2019-e-edlund
 */
public class Config {
    
    public static final String API = "jdbc";
     public static final String CONN = "mysql";
      public static final String HOST = "localhost";
       public static final String DATABASE = "dk-301_airports";
        public static final String USER = "dk-301";
         public static final String PASSWORD = "iqFppJNo";
           public static final String URL = API + ":" + CONN + "://" + HOST + "/" +DATABASE;
   
    public static void main(String[] args) {
        
        
    }
}
