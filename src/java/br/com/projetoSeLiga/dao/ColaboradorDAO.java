package br.com.projetoSeLiga.dao;

import br.com.projetoSeLiga.model.Area;
import br.com.projetoSeLiga.model.Colaborador;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ColaboradorDAO implements IColaboradorDAO{

    @Override
    public void cadastrar(Colaborador colaborador) throws ClassNotFoundException, SQLException{
        Connection conexao = FabricaConexao.abrirConexao();
        String query = "insert into Colaborador (nome, dataNascimento, cpf, rg," +
"                email, rua, numero, complemento, bairro," +
"                cidade, uf, cep, login, senha) values ('" + colaborador.getNome() + "','" +
                colaborador.getDataNascimento()+ "','" + colaborador.getCpf() + "','" +
                colaborador.getRg()+ "','" + colaborador.getEmail() + "','" +
                colaborador.getRua()+ "'," + colaborador.getNumero() + ",'" +
                colaborador.getComplemento()+ "','" + colaborador.getBairro() + "','" +
                colaborador.getCidade()+ "','" + colaborador.getUf() + "','" +
                colaborador.getCep() + "','" +
                colaborador.getLogin() + "','" + colaborador.getSenha() + "')";
        java.sql.PreparedStatement stmt = conexao.prepareStatement(query);
    	stmt.executeUpdate();
        stmt.close();
        for(int i = 0; i < colaborador.getAreas().size(); i++){
           String query2 = "insert into Colaborador_Area (idColaborador, idArea) "
                            + "values((select id from colaborador where login = '" + colaborador.getLogin() + "'),(select id from area where nome = '" + 
                            colaborador.getAreas().get(i).getNome() + "'));";
           java.sql.PreparedStatement stmt2 = conexao.prepareStatement(query2);
           stmt2.executeUpdate();
           stmt2.close();
        }
        
    	FabricaConexao.fecharConexao(conexao);
    }

    @Override
    public void remover(String login) throws ClassNotFoundException, SQLException{
        Connection conexao = FabricaConexao.abrirConexao();
        String query1 = "delete from Colaborador_Area where idColaborador = (select id from Colaborador where login = '" + login + "')";
        String query2 = "delete from Colaborador where login = '" + login + "'";
        
        PreparedStatement stmt1 = conexao.prepareStatement(query1);
        PreparedStatement stmt2 = conexao.prepareStatement(query2);
        stmt1.executeUpdate();
        stmt2.executeUpdate();
    }

    @Override
    public Colaborador selecionar(String login) throws ClassNotFoundException, SQLException{
        Colaborador colaborador = null;
        PreparedStatement stmt;
        ResultSet rs;
        
        int numero;
        Date dataNascimento;
        String nome, cpf, rg, email, rua, complemento, bairro, cidade, uf, cep, senha;
        
        Connection conexao = FabricaConexao.abrirConexao();
        String query = "select * from colaborador where login = '" + login + "'";
        stmt = conexao.prepareStatement(query);
        rs = stmt.executeQuery();
        if(rs.next())
        {
            nome = rs.getString("nome");
            cpf = rs.getString("cpf");
            rg = rs.getString("rg");
            email = rs.getString("email");
            rua = rs.getString("rua");
            complemento = rs.getString("complemento");
            bairro = rs.getString("bairro");
            cidade = rs.getString("cidade");
            uf = rs.getString("uf");
            cep = rs.getString("cep");
            login = rs.getString("login");
            senha = rs.getString("senha");
            numero = rs.getInt("numero");
            dataNascimento = rs.getDate("dataNascimento");
            
            colaborador = new Colaborador(nome, dataNascimento, cpf, rg, 
                email, rua, numero, complemento, bairro, 
                cidade, uf, cep, login, senha);
            colaborador.setId(rs.getInt("id"));
        }
        stmt.close();
        
        String query2 = "select * from colaborador_area where idColaborador = (select id from colaborador where login = '" + login + "'";
        PreparedStatement stmt2 = conexao.prepareStatement(query);
                
        ResultSet rs2 = stmt2.executeQuery();
        while(rs.next()){
            String nomeArea = rs.getString("nome");
            Area area = new Area();
            area.setNome(nomeArea);
            colaborador.setAreas(area);
        }
        
        rs.close();
        rs2.close();
        FabricaConexao.fecharConexao(conexao);
        
       return colaborador;
    }

    @Override
    public ArrayList<Colaborador> selecionarTodos() throws ClassNotFoundException, SQLException{
        ArrayList<Colaborador> colaboradores = new ArrayList<>();
        Colaborador colaborador = null;
        PreparedStatement stmt;
        ResultSet rs;
        
        int numero;
        Date dataNascimento;
        String nome, cpf, rg, email, rua, complemento, bairro, cidade, uf, cep, login, senha;
        
        Connection conexao = FabricaConexao.abrirConexao();
        String query = "Select * from colaborador";
        stmt = conexao.prepareStatement(query);
        rs = stmt.executeQuery();
        while(rs.next())
        {
            nome = rs.getString("nome");
            cpf = rs.getString("cpf");
            rg = rs.getString("rg");
            email = rs.getString("email");
            rua = rs.getString("rua");
            complemento = rs.getString("complemento");
            bairro = rs.getString("bairro");
            cidade = rs.getString("cidade");
            uf = rs.getString("uf");
            cep = rs.getString("cep");
            login = rs.getString("login");
            senha = rs.getString("senha");
            numero = rs.getInt("numero");
            dataNascimento = rs.getDate("dataNascimento");
            colaborador = new Colaborador(nome, dataNascimento, cpf, rg, 
                email, rua, numero, complemento, bairro, 
                cidade, uf, cep, login, senha);
            colaborador.setId(rs.getInt("id"));
            colaboradores.add(colaborador);
        }
        
        stmt.close();
        rs.close();
        FabricaConexao.fecharConexao(conexao);
        
        return colaboradores;
    }

    @Override
    public void atualizar(Colaborador colaborador) throws ClassNotFoundException, SQLException{
        Connection conexao = FabricaConexao.abrirConexao();
        String query = "update Colaborador set nome = '" + colaborador.getNome() + "', dataNascimento = '" +
                colaborador.getDataNascimento()+ "', cpf = '" + colaborador.getCpf() + "', rg = '" +
                colaborador.getRg()+ "', email = '" + colaborador.getEmail() + "', rua = '" +
                colaborador.getRua()+ "', numero = " + colaborador.getNumero() + ", complemento = '" +
                colaborador.getComplemento()+ "', bairro = '" + colaborador.getBairro() + "', cidade = '" +
                colaborador.getCidade()+ "', uf = '" + colaborador.getUf() + "', cep = '" +
                colaborador.getCep() + "', senha = '" + colaborador.getSenha() + "' where login = '" + 
                colaborador.getLogin() + "'";
        java.sql.PreparedStatement stmt = conexao.prepareStatement(query);
    	stmt.executeUpdate();
    	stmt.close();
        String query1 = "delete from Colaborador_Area where idColaborador = (select id from Colaborador where login = '" + colaborador.getLogin() + "')";
        PreparedStatement stmt1 = conexao.prepareStatement(query1);
        stmt1.executeUpdate();
        stmt1.close();
        for(int i = 0; i < colaborador.getAreas().size(); i++){
           String query2 = "insert into Colaborador_Area (idColaborador, idArea) "
                            + "values((select id from colaborador where login = '" + colaborador.getLogin() + "'),(select id from area where nome = '" + 
                            colaborador.getAreas().get(i).getNome() + "'));";
           java.sql.PreparedStatement stmt2 = conexao.prepareStatement(query2);
           stmt2.executeUpdate();
           stmt2.close();
        }
       
    	FabricaConexao.fecharConexao(conexao);
    }
}
