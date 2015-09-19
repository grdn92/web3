package br.com.projetoSeLiga.dao;

import br.com.projetoSeLiga.model.Colaborador;
import java.sql.SQLException;
import java.util.ArrayList;

public interface IColaboradorDAO {
    public void cadastrar(Colaborador colaborador) throws ClassNotFoundException, SQLException;
    public void remover(String login) throws ClassNotFoundException, SQLException;
    public Colaborador selecionar(String login) throws ClassNotFoundException, SQLException;
    public ArrayList<Colaborador> selecionarTodos() throws ClassNotFoundException, SQLException;
    public void atualizar(Colaborador colaborador) throws ClassNotFoundException, SQLException;
}
