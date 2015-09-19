package br.com.projetoSeLiga.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class FabricaConexao {
 
    public static Connection abrirConexao() throws ClassNotFoundException, SQLException{
        Connection conexao;
        Class.forName("com.mysql.jdbc.Driver");
        conexao = DriverManager.getConnection("jdbc:mysql://127.0.0.1/ProjetoSeLiga3", "root", "");
        return conexao;
    }
	
    public static void fecharConexao(Connection conexao) throws SQLException
    {
        conexao.close();
    }
}