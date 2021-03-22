/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author herrmann
 */
public class Conector {

    private static Connection con;

    public static Connection getConnection() {
        try {

            String url = "jdbc:mysql://localhost:3306/";
            String banco = "bikes";
            String usuario = "root";
            String senha = "aluno@LP3";

            // conectando com o banco
            con = DriverManager.getConnection(url + banco, usuario, senha);
            return con;
        } catch (SQLException ex) {
                ex.printStackTrace();
                return null;
        }
    }
}
