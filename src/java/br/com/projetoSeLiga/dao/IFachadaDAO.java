package br.com.projetoSeLiga.dao;

import br.com.projetoSeLiga.model.Area;
import br.com.projetoSeLiga.model.Colaborador;
import br.com.projetoSeLiga.model.Materia;
import java.sql.SQLException;
import java.util.ArrayList;

public interface IFachadaDAO {
    public void cadastrarColaborador(Colaborador colaborador) throws ClassNotFoundException, SQLException;
    public void removerColaborador(String login) throws ClassNotFoundException, SQLException;
    public Colaborador selecionarColaborador(String login) throws ClassNotFoundException, SQLException;
    public ArrayList<Colaborador> selecionarTodosColaboradores() throws ClassNotFoundException, SQLException;
    public void atualizarColaborador(Colaborador colaborador) throws ClassNotFoundException, SQLException;
    
    public void cadastrarArea(Area area) throws ClassNotFoundException, SQLException;
    public void removerArea(String nome) throws ClassNotFoundException, SQLException;
    public Area selecionarArea(String nome) throws ClassNotFoundException, SQLException;
    public ArrayList<Area> selecionarTodasAreas() throws ClassNotFoundException, SQLException;
    public void atualizarArea(Area area) throws ClassNotFoundException, SQLException;
    
    public void cadastrarMateria(Materia materia) throws ClassNotFoundException, SQLException;
    public void removerMateria(String titulo) throws ClassNotFoundException, SQLException;
    public Materia selecionarMateria(String titulo) throws ClassNotFoundException, SQLException;
    public ArrayList<Materia> selecionarTodasMaterias() throws ClassNotFoundException, SQLException;
    public void atualizarMateria(Materia materia) throws ClassNotFoundException, SQLException;
}
