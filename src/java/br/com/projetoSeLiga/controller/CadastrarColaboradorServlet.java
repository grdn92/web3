package br.com.projetoSeLiga.controller;

import br.com.projetoSeLiga.dao.FachadaDAO;
import br.com.projetoSeLiga.model.Area;
import br.com.projetoSeLiga.model.Colaborador;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CadastrarColaboradorServlet extends HttpServlet{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Colaborador colaborador = new Colaborador();
        
        colaborador.setNome(request.getParameter("nome"));
        colaborador.setCpf(request.getParameter("cpf"));
        colaborador.setRg(request.getParameter("rg"));
        colaborador.setEmail(request.getParameter("email"));
        colaborador.setRua(request.getParameter("rua"));
        try{
            colaborador.setNumero(Integer.parseInt(request.getParameter("numero")));
        }
        catch(NumberFormatException ex) {}
        colaborador.setComplemento(request.getParameter("complemento"));
        colaborador.setBairro(request.getParameter("bairro"));
        colaborador.setCidade(request.getParameter("cidade"));
        colaborador.setUf(request.getParameter("uf"));
        colaborador.setCep(request.getParameter("cep"));
        colaborador.setLogin(request.getParameter("login").toLowerCase());
        colaborador.setSenha(request.getParameter("senha"));
        if(request.getParameterValues("area_adicionadas") != null){
            for(int i = 0; i < request.getParameterValues("area_adicionadas").length ; i++){
                Area area = new Area(request.getParameterValues("area_adicionadas")[i]);
                colaborador.setAreas(area);
            }
        }
        
        int diaNascimento = Integer.parseInt(request.getParameter("diaNascimento"));
        int mesNascimento = Integer.parseInt(request.getParameter("mesNascimento"));
        int anoNascimento = Integer.parseInt(request.getParameter("anoNascimento"));
        colaborador.setDataNascimento(diaNascimento, mesNascimento, anoNascimento);
        FachadaDAO fachadaDAO = FachadaDAO.getInstance();
        try{
            fachadaDAO.cadastrarColaborador(colaborador);
            HttpSession sessao = request.getSession();
            sessao.setAttribute("colaborador", colaborador);
            sessao.setAttribute("cadastroColaboradorSucesso", true);
            request.getRequestDispatcher("TelaInicial.jsp").forward(request, response);
        }
        catch(SQLException | ClassNotFoundException ex) {
            System.out.println("Erro ao conectar ao banco de dados.");
            request.getRequestDispatcher("Login.jsp").forward(request, response);
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
