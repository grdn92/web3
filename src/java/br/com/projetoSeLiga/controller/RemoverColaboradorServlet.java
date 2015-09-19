package br.com.projetoSeLiga.controller;

import br.com.projetoSeLiga.dao.FachadaDAO;
import br.com.projetoSeLiga.model.Colaborador;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RemoverColaboradorServlet extends HttpServlet{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession(false);
        Colaborador colaborador = (Colaborador)sessao.getAttribute("colaborador");
        System.out.println("login: " + colaborador.getLogin());
        if(sessao != null){
            FachadaDAO fachadaDAO = FachadaDAO.getInstance();
            try{
                fachadaDAO.removerColaborador(colaborador.getLogin());
                sessao.setAttribute("exclusaoColaboradorSucesso", true);
                request.getRequestDispatcher("Login.jsp").forward(request, response);
                sessao.invalidate();
            }
            catch(SQLException | ClassNotFoundException ex) {
                System.out.println("Erro ao conectar ao banco de dados.");
                request.getRequestDispatcher("Login.jsp").forward(request, response);
            }
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

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
