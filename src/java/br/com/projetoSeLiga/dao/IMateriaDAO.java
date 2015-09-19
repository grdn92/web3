package br.com.projetoSeLiga.dao;

import br.com.projetoSeLiga.model.Materia;
import java.sql.SQLException;
import java.util.ArrayList;

public interface IMateriaDAO {
    public void cadastrar(Materia materia) throws ClassNotFoundException, SQLException;
    public void remover(String titulo) throws ClassNotFoundException, SQLException;
    public Materia selecionar(String titulo) throws ClassNotFoundException, SQLException;
    public ArrayList<Materia> selecionarTodos() throws ClassNotFoundException, SQLException;
    public void atualizar(Materia materia) throws ClassNotFoundException, SQLException;
}
