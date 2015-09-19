package br.com.projetoSeLiga.controller;

import br.com.projetoSeLiga.dao.FachadaDAO;
import br.com.projetoSeLiga.model.Colaborador;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
       String login = request.getParameter("login").toLowerCase();
       String senha = request.getParameter("senha");
       FachadaDAO fachadaDAO = FachadaDAO.getInstance();
       ArrayList <Colaborador> colaboradores;
       colaboradores = fachadaDAO.selecionarTodosColaboradores();
       Iterator<Colaborador> iterator = colaboradores.iterator();
       Colaborador colaborador;
       boolean loginComSucesso = false;
       while(iterator.hasNext()){
           colaborador = iterator.next();
           if(login.equals(colaborador.getLogin()) && senha.equals(colaborador.getSenha())){
               loginComSucesso = true;
               HttpSession sessao = request.getSession();
               //Colaborador colaborador = fachadaDAO.selecionarColaborador(colaborador.getLogin());
               sessao.setAttribute("colaborador", colaborador);
               sessao.setAttribute("cadastroColaboradorSucesso", false);
               sessao.setAttribute("exclusaoColaboradorSucesso", false);
               request.getRequestDispatcher("TelaInicial.jsp").forward(request, response);
           }
       }
       if(!loginComSucesso)
            request.getRequestDispatcher("login_error.html").forward(request, response);
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
