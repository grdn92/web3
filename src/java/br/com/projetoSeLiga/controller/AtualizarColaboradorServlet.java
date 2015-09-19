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

public class AtualizarColaboradorServlet extends HttpServlet{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession(false);
        Colaborador colaboradorNovo = new Colaborador();
        Colaborador colaboradorAntigo = (Colaborador)sessao.getAttribute("colaborador");
        
        colaboradorNovo.setNome(request.getParameter("nome"));
        colaboradorNovo.setCpf(request.getParameter("cpf"));
        colaboradorNovo.setRg(request.getParameter("rg"));
        colaboradorNovo.setEmail(request.getParameter("email"));
        colaboradorNovo.setRua(request.getParameter("rua"));
        try{
            colaboradorNovo.setNumero(Integer.parseInt(request.getParameter("numero")));
        }
        catch(NumberFormatException ex) {}
        colaboradorNovo.setComplemento(request.getParameter("complemento"));
        colaboradorNovo.setBairro(request.getParameter("bairro"));
        colaboradorNovo.setCidade(request.getParameter("cidade"));
        colaboradorNovo.setUf(request.getParameter("uf"));
        colaboradorNovo.setCep(request.getParameter("cep"));
        colaboradorNovo.setLogin(request.getParameter("login"));
        if(request.getParameterValues("area_adicionadas") != null){
            for(int i = 0; i < request.getParameterValues("area_adicionadas").length ; i++){
                Area area = new Area(request.getParameterValues("area_adicionadas")[i]);
                colaboradorNovo.setAreas(area);
            }
        }
        if(request.getParameter("senha").equals(""))
            colaboradorNovo.setSenha(colaboradorAntigo.getSenha());
        else
            colaboradorNovo.setSenha(request.getParameter("senha"));
        
        int diaNascimento = Integer.parseInt(request.getParameter("diaNascimento"));
        int mesNascimento = Integer.parseInt(request.getParameter("mesNascimento"));
        int anoNascimento = Integer.parseInt(request.getParameter("anoNascimento"));
        colaboradorNovo.setDataNascimento(diaNascimento, mesNascimento, anoNascimento);
        FachadaDAO fachadaDAO = FachadaDAO.getInstance();
        try{
            fachadaDAO.atualizarColaborador(colaboradorNovo);
            
            sessao.setAttribute("colaborador", colaboradorNovo);
        }
        catch(SQLException | ClassNotFoundException ex) {
            System.out.println("Erro ao conectar ao banco de dados.");
        }
        finally{
            request.getRequestDispatcher("TelaInicial.jsp").forward(request, response);
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
