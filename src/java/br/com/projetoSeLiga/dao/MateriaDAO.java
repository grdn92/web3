package br.com.projetoSeLiga.dao;

import br.com.projetoSeLiga.model.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MateriaDAO implements IMateriaDAO{
    @Override
    public void cadastrar(Materia materia) throws ClassNotFoundException, SQLException{
        Connection conexao = FabricaConexao.abrirConexao();
        String query = "insert into materia (titulo, texto, dataCadastro, idColaborador, idArea)" +
                "values('" + materia.getTitulo() + "', '" + materia.getTexto() + "', " + 
                "curdate(), (select id from colaborador where login = '" + materia.getLoginColaborador() + "'), " + 
                "(select id from area where nome = '" + materia.getNomeArea() + "'));";
        java.sql.PreparedStatement stmt = conexao.prepareStatement(query);
    	stmt.executeUpdate();
    	stmt.close();
    	FabricaConexao.fecharConexao(conexao);
    }

    @Override
    public void remover(String titulo) throws ClassNotFoundException, SQLException{
        Connection conexao = FabricaConexao.abrirConexao();
        String query = "delete from Materia where titulo = '" + titulo + "'";
        PreparedStatement stmt = conexao.prepareStatement(query);
        stmt.executeUpdate();
    }

    @Override
    public Materia selecionar(String titulo) throws ClassNotFoundException, SQLException{
        Materia materia = null;
        PreparedStatement stmt;
        ResultSet rs;
        
        String texto;
        int id, idColaborador, idArea;
        String loginColaborador, nomeArea;
        
        Connection conexao = FabricaConexao.abrirConexao();
        String query = "select * from materia where titulo = '" + titulo + "'";
        stmt = conexao.prepareStatement(query);
        rs = stmt.executeQuery();
        if(rs.next())
        {
            titulo = rs.getString("titulo");
            texto = rs.getString("texto");
            id = rs.getInt("id");
            idColaborador = rs.getInt("idColaborador");
            idArea = rs.getInt("idArea");
            
            String query2 = "select * from colaborador where id = " + idColaborador;
            PreparedStatement stmt2 = conexao.prepareStatement(query2);
            ResultSet rs2 = stmt.executeQuery();
            loginColaborador = rs2.getString("login");
            
            String query3 = "select * from area where id = " + idArea;
            PreparedStatement stmt3 = conexao.prepareStatement(query3);
            ResultSet rs3 = stmt.executeQuery();
            nomeArea = loginColaborador = rs3.getString("nome");
            
            materia = new Materia();
            
            materia.setTitulo(titulo);
            materia.setTexto(texto);
            materia.setId(id);
            materia.setLoginColaborador(loginColaborador);
            materia.setNomeArea(nomeArea);
        }
        
        stmt.close();
        FabricaConexao.fecharConexao(conexao);
        
       return materia;
    }

    @Override
    public ArrayList<Materia> selecionarTodos() throws ClassNotFoundException, SQLException{
        ArrayList<Materia> materias = new ArrayList<>();
        Materia materia = null;
        PreparedStatement stmt, stmt2, stmt3;
        ResultSet rs, rs2, rs3;
        
        String titulo, texto;
        int id, idColaborador, idArea;
        String nomeColaborador, nomeArea;
        
        
        Connection conexao = FabricaConexao.abrirConexao();
        String query = "Select * from materia";
        stmt = conexao.prepareStatement(query);
        rs = stmt.executeQuery();
        while(rs.next())
        {
            titulo = rs.getString("titulo");
            texto = rs.getString("texto");
            id = rs.getInt("id");
            idColaborador = rs.getInt("idColaborador");
            /*String query2 = "select login from Colaborador where id = " + idColaborador;
            stmt2 = conexao.prepareStatement(query2);
            rs2 = stmt2.executeQuery();
            
            idArea = rs.getInt("idArea");
            String query3 = "select nome from Area where id = " + idArea;
            stmt3 = conexao.prepareStatement(query3);
            rs3 = stmt3.executeQuery();*/
            
            materia = new Materia();
            
            materia.setTitulo(titulo);
            materia.setTexto(texto);
            materia.setId(id);
            //materia.setLoginColaborador(rs2.getString("login"));
            //materia.setNomeArea(rs3.getString("nome"));
            
            materias.add(materia);
        }
        
        stmt.close();
        FabricaConexao.fecharConexao(conexao);
        
        return materias;
    }

    @Override
    public void atualizar(Materia materia) throws ClassNotFoundException, SQLException{
        Connection conexao = FabricaConexao.abrirConexao();
        String query = "update Area set titulo = '" + materia.getTitulo() + "'' where titulo = '" + 
                materia.getTitulo()+ "'";
        java.sql.PreparedStatement stmt = conexao.prepareStatement(query);
    	stmt.executeUpdate();
    	stmt.close();
    	FabricaConexao.fecharConexao(conexao);
    }
}
