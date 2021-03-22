/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import factory.Conector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modeDominio.Bike;

/**
 *
 * @author herrmann
 */
public class BikeDao {
    private Connection con; 

    public BikeDao() {
        con = Conector.getConnection();
    }
    
    public ArrayList<Bike> getListaBikes(){
        ArrayList<Bike> listaBikes = new ArrayList();
        Statement stmt;
        
        try{
            stmt = con.createStatement();
            ResultSet res = stmt.executeQuery("select bike.*,marca.nomemarca from bike\n" +
                                               "join marca on (marca.codmarca = bike.codmarca)");
            while (res.next()){
                Bike bk = new Bike(res.getInt("codbike"), 
                                   res.getString("modelobike"),
                                   res.getFloat("valor"),
                                   res.getInt("codmarca"),                                   
                                   res.getString("nomemarca"));
                listaBikes.add(bk);
                System.out.println("Adicionando bike na lista: "+bk);
            }
            
            res.close();
            stmt.close();
            con.close();
            return listaBikes;
        }catch (SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }
    
}
