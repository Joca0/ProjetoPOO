/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author ericoo
 */
public class FabricaConexao {
    public static Connection getConexao() throws ClassNotFoundException, SQLException {

        //MySQL
        // inicia o driver passado por parâmetro
        Class.forName("com.mysql.jdbc.Driver");
        String URL = "jdbc:mysql://localhost:3306/produtos";
        String USER = "root";
        String PASSWORD = "";
        
        
        // conexão
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
