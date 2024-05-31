/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import util.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import modelo.Produto;

/**
 *
 * @author ericoo
 */
//ALTERAÇÕES REALIZADAS - ADICIONADO CPU,DESCRICAO E ALTERADO TIPO DE STRING PARA BOOLEAN O ATRIBUTO NUMPAD
public class ProdutoDAO {
    public void cadastrar(Produto prod) throws ClassNotFoundException, SQLException {
        Connection con = FabricaConexao.getConexao();
        PreparedStatement comando = con.prepareStatement("insert into produto (nome, processador, memoria, gpu, polegadas, resolucao, descricao, wifi, bluetooth, numpad) values (?,?,?,?,?,?,?,?,?,?)");
        comando.setString(1, prod.getnome());
        comando.setString(2,prod.getCPU());
        comando.setString(3, prod.getram());
        comando.setString(4, prod.getplacavdo());
        comando.setString(5, prod.gettela());
        comando.setString(6, prod.getresolucao());
        comando.setString(7, prod.getdescricao());
        comando.setString(8, prod.getwifi());
        comando.setString(9, prod.getbluetooth());
        comando.setString(10,prod.getnumpad());
       
        comando.execute();
        con.close();
    }
    
    public void deletar(Produto prod) throws ClassNotFoundException, SQLException {
        Connection con = FabricaConexao.getConexao();
        PreparedStatement comando = con.prepareStatement("delete from produto where id = ?");
        comando.setInt(1, prod.getId());
        
        comando.execute();
        con.close();
    }
    
    //ALTERAÇÕES REALIZADAS - ADICIONADO CPU,DESCRICAO E ALTERADO TIPO DE STRING PARA BOOLEAN O ATRIBUTO NUMPAD
    public void atualizar(Produto prod) throws ClassNotFoundException, SQLException {
        Connection con = FabricaConexao.getConexao();
        PreparedStatement comando = con.prepareStatement("update produto set nome = ?, processador = ?, memoria = ?, gpu = ? , polegadas = ?, resolucao = ?, descricao = ?, wifi = ?, bluetooth = ?, numpad = ? where id = ?");
        comando.setString(1, prod.getnome());
        comando.setString(2,prod.getCPU());
        comando.setString(3, prod.getram());
        comando.setString(4, prod.getplacavdo());
        comando.setString(5, prod.gettela());
        comando.setString(6, prod.getresolucao());
        comando.setString(7, prod.getdescricao());
        comando.setString(8, prod.getwifi());
        comando.setString(9, prod.getbluetooth());
        comando.setString(10,prod.getnumpad());
        comando.setInt(11,prod.getId());
        
        comando.execute();
        con.close();
    }    
    
    //ATUALIZADO 25/05 AS 14:27
    public Produto consultarById(Produto prod) throws ClassNotFoundException, SQLException {
        Connection con = FabricaConexao.getConexao();
        PreparedStatement comando = con.prepareStatement("select * from produto where id = ?");
        comando.setInt(1, prod.getId());
        ResultSet rs = comando.executeQuery();
        Produto p = new Produto();
        if (rs.next()) {
            p.setId(rs.getInt("id"));
            p.setnome(rs.getString("nome"));
            p.setCPU(rs.getString("processador"));
            p.setram(rs.getString("memoria")); 
            p.setplacavdo(rs.getString("gpu"));
            p.settela(rs.getString("polegadas"));
            p.setresolucao(rs.getString("resolucao"));
            p.setdescricao(rs.getString("descricao"));
            p.setwifi(rs.getString("wifi"));
            p.setbluetooth(rs.getString("bluetooth"));
            p.setnumpad(rs.getString("numpad"));
        }       
        con.close();
        return p;
    }
    
    //ATUALIZADO 25/05 AS 14:30
    public List<Produto> consultarTodos() throws ClassNotFoundException, SQLException {
        Connection con = FabricaConexao.getConexao();
        PreparedStatement comando = con.prepareStatement("select * from produto");        
        ResultSet rs = comando.executeQuery();  
        
        List<Produto> lprod = new ArrayList<Produto>();
        while(rs.next()){
            Produto p = new Produto();
            p.setId(rs.getInt("id"));
            p.setnome(rs.getString("nome"));
            p.setCPU(rs.getString("processador"));
            p.setram(rs.getString("memoria")); 
            p.setplacavdo(rs.getString("gpu"));
            p.settela(rs.getString("polegadas"));
            p.setresolucao(rs.getString("resolucao"));
            p.setdescricao(rs.getString("descricao"));
            p.setwifi(rs.getString("wifi"));
            p.setbluetooth(rs.getString("bluetooth"));
            p.setnumpad(rs.getString("numpad"));
            lprod.add(p);
        }
        con.close();
        return lprod;
    }
}
