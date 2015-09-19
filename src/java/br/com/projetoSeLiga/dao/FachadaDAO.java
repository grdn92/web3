package br.com.projetoSeLiga.dao;

import br.com.projetoSeLiga.model.Area;
import br.com.projetoSeLiga.model.Colaborador;
import br.com.projetoSeLiga.model.Materia;
import java.sql.SQLException;
import java.util.ArrayList;

public class FachadaDAO implements IFachadaDAO{
    private FachadaDAO(){};
    
    private static FachadaDAO instance = null;
    private final ColaboradorDAO colaboradorDAO = new ColaboradorDAO();
    private final AreaDAO areaDAO = new AreaDAO();
    private final MateriaDAO materiaDAO = new MateriaDAO();
    
    public static FachadaDAO getInstance(){
        if(instance == null)
            instance = new FachadaDAO();
        return instance;
    }
    
    @Override
    public void cadastrarColaborador(Colaborador colaborador) throws ClassNotFoundException, SQLException{
        colaboradorDAO.cadastrar(colaborador);
    }
    
    @Override
    public void removerColaborador(String login) throws ClassNotFoundException, SQLException{
        colaboradorDAO.remover(login);
    }
    
    @Override
    public Colaborador selecionarColaborador(String login) throws ClassNotFoundException, SQLException{
        return colaboradorDAO.selecionar(login);
    }
    
    @Override
    public ArrayList<Colaborador> selecionarTodosColaboradores() throws ClassNotFoundException, SQLException{
        return colaboradorDAO.selecionarTodos();
    }
    
    @Override
    public void atualizarColaborador(Colaborador colaborador) throws ClassNotFoundException, SQLException{
        colaboradorDAO.atualizar(colaborador);
    }
    
    @Override
    public void cadastrarArea(Area area) throws ClassNotFoundException, SQLException{
        areaDAO.cadastrar(area);
    }
    
    @Override
    public void removerArea(String nome) throws ClassNotFoundException, SQLException{
        areaDAO.remover(nome);
    }
    
    @Override
    public Area selecionarArea(String nome) throws ClassNotFoundException, SQLException{
        return areaDAO.selecionar(nome);
    }
    
    @Override
    public ArrayList<Area> selecionarTodasAreas() throws ClassNotFoundException, SQLException{
        return areaDAO.selecionarTodos();
    }
    
    @Override
    public void atualizarArea(Area area) throws ClassNotFoundException, SQLException{
        areaDAO.atualizar(area);
    }
    
    @Override
    public void cadastrarMateria(Materia materia) throws ClassNotFoundException, SQLException{
        materiaDAO.cadastrar(materia);
    }
    
    @Override
    public void removerMateria(String titulo) throws ClassNotFoundException, SQLException{
        materiaDAO.remover(titulo);
    }
    
    @Override
    public Materia selecionarMateria(String titulo) throws ClassNotFoundException, SQLException{
       return materiaDAO.selecionar(titulo);
    }
    
    @Override
    public ArrayList<Materia> selecionarTodasMaterias() throws ClassNotFoundException, SQLException{
        return materiaDAO.selecionarTodos();
    }
    
    @Override
    public void atualizarMateria(Materia materia) throws ClassNotFoundException, SQLException{
        materiaDAO.atualizar(materia);
    }
}
