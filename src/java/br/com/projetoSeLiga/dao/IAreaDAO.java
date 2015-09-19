package br.com.projetoSeLiga.dao;

import br.com.projetoSeLiga.model.Area;
import java.sql.SQLException;
import java.util.ArrayList;

public interface IAreaDAO {
    public void cadastrar(Area area) throws ClassNotFoundException, SQLException;
    public void remover(String nome) throws ClassNotFoundException, SQLException;
    public Area selecionar(String nome) throws ClassNotFoundException, SQLException;
    public ArrayList<Area> selecionarTodos() throws ClassNotFoundException, SQLException;
    public void atualizar(Area area) throws ClassNotFoundException, SQLException;
}