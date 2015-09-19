package br.com.projetoSeLiga.controller;

import br.com.projetoSeLiga.dao.FachadaDAO;
import br.com.projetoSeLiga.model.Colaborador;
import br.com.projetoSeLiga.model.Materia;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CadastrarMateriaServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession(false);
        Materia materia = new Materia();
        materia.setTitulo(request.getParameter("titulo"));
        materia.setTexto(request.getParameter("texto"));
        materia.setNomeArea(request.getParameter("area"));
        materia.setLoginColaborador(((Colaborador)sessao.getAttribute("colaborador")).getLogin());
        FachadaDAO fachadaDAO = FachadaDAO.getInstance();
        try{
            fachadaDAO.cadastrarMateria(materia);
        }
        catch(ClassNotFoundException | SQLException ex){
            System.out.println("Erro: " + ex);
        }
        finally{
            request.getRequestDispatcher("Materias.jsp").forward(request, response);
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
