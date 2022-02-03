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
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 2019-e-edlund
 */
public class Airport {

    public static void main(String[] args) throws SQLException {
        Airport a = new Airport(DriverManager.getConnection(Config.URL, Config.USER, Config.PASSWORD));
      System.out.println(a.getAirportSize());
        System.out.println(a.getCountries());
        System.out.println(a.getAirportsByCountry("Germany"));

    }
    private final Connection con;

    public Airport(Connection con) {
        this.con = con;
    }

    public int getAirportSize() throws SQLException {

        // k ty tabulce lze pristupovat jenom po radcich nemuzu vytahnout 
        // nejakou informaci pomoci radek sloupek 
        // prochazim jednotlive radky potom se posouvam z leva do prava 
        // SELECT COUNT (*) FROM airport
        try (Statement stmt = con.createStatement()) {
            try (ResultSet res = stmt.executeQuery("SELECT COUNT(*)FROM airport")) {
                if (res.next()) { // preskakuje na dalsi radky kdyz tam je radek vrati true 
//                    String name = (String) res.getObject("name");
                    int count = res.getInt(1);
                    if (res.next()) {
                        throw new RuntimeException("too lines");
                    }
                    return count; // vrati pocet radku
                } else {
                    throw new RuntimeException("empty result");
                }
            }
        }
    }

    public List<String> getCountries() throws SQLException {
        List countries = new ArrayList();
        try (Statement stmt = con.createStatement()) {

            try (ResultSet res = stmt.executeQuery("SELECT DISTINCT country  FROM airport")) {

                while (res.next()) {
                    countries.add(res.getString(1));
                }

            }
        }
        return countries;

    }
    
    public List <String> getAirportsByCountry(String country) throws SQLException{
            List airportNames = new ArrayList();
        try (Statement stmt = con.createStatement()) {

            try (ResultSet res = stmt.executeQuery("SELECT name FROM airport WHERE country = '" + country +"'" )){

                while (res.next()) {
                   airportNames.add(res.getString("name"));
                }

            }
        }
        return airportNames;
    }

}
