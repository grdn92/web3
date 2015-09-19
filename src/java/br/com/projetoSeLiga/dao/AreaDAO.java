package br.com.projetoSeLiga.dao;

import br.com.projetoSeLiga.model.Area;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AreaDAO implements IAreaDAO{

    @Override
    public void cadastrar(Area area) throws ClassNotFoundException, SQLException{
        Connection conexao = FabricaConexao.abrirConexao();
        String query = "insert into Area (nome) values ('" + area.getNome() + "');";
        java.sql.PreparedStatement stmt = conexao.prepareStatement(query);
    	stmt.executeUpdate();
    	stmt.close();
    	FabricaConexao.fecharConexao(conexao);
    }

    @Override
    public void remover(String nome) throws ClassNotFoundException, SQLException{
        Connection conexao = FabricaConexao.abrirConexao();
        String query = "delete from Area where nome = " + nome;
        PreparedStatement stmt = conexao.prepareStatement(query);
        stmt.executeUpdate();
    }

    @Override
    public Area selecionar(String login) throws ClassNotFoundException, SQLException{
        Area area = null;
        PreparedStatement stmt;
        ResultSet rs;
        
        String nome = "";
        int id;
        
        Connection conexao = FabricaConexao.abrirConexao();
        String query = "select * from area where nome = " + nome;
        stmt = conexao.prepareStatement(query);
        rs = stmt.executeQuery();
        if(rs.next())
        {
            nome = rs.getString("nome");
            id = rs.getInt("id");
            
            area = new Area(nome);
            area.setId(id);
        }
        
        stmt.close();
        FabricaConexao.fecharConexao(conexao);
        
       return area;
    }

    @Override
    public ArrayList<Area> selecionarTodos() throws ClassNotFoundException, SQLException{
        ArrayList<Area> areas = new ArrayList<>();
        Area area = null;
        PreparedStatement stmt;
        ResultSet rs;
        
        String nome;
        int id;
        
        Connection conexao = FabricaConexao.abrirConexao();
        String query = "Select * from area";
        stmt = conexao.prepareStatement(query);
        rs = stmt.executeQuery();
        while(rs.next())
        {
            nome = rs.getString("nome");
            id = rs.getInt("id");
            
            area = new Area();
            
            area.setNome(nome);
            area.setId(id);
            
            areas.add(area);
        }
        
        stmt.close();
        FabricaConexao.fecharConexao(conexao);
        
        return areas;
    }

    @Override
    public void atualizar(Area area) throws ClassNotFoundException, SQLException{
        Connection conexao = FabricaConexao.abrirConexao();
        String query = "update Area set nome = '" + area.getNome() + "'' where nome = '" + 
                area.getNome()+ "'";
        java.sql.PreparedStatement stmt = conexao.prepareStatement(query);
    	stmt.executeUpdate();
    	stmt.close();
    	FabricaConexao.fecharConexao(conexao);
    }
}
