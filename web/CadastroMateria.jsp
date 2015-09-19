<%@page import="java.util.ArrayList"%>
<%@page import="br.com.projetoSeLiga.model.Area"%>
<%@page import="br.com.projetoSeLiga.model.Area"%>
<%@page import="br.com.projetoSeLiga.dao.FachadaDAO"%>
<%@page import="br.com.projetoSeLiga.model.Colaborador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel='stylesheet' href='style.css' type='text/css'>
    </head>
    <% 
        HttpSession sessao = request.getSession(false);
        if(sessao == null){
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }
        else{
            FachadaDAO fachadaDAO = FachadaDAO.getInstance();
            Colaborador colaborador = new Colaborador();
            ArrayList<Area> areas = fachadaDAO.selecionarTodasAreas();
            if((Colaborador)sessao.getAttribute("colaborador") != null){
                colaborador = (Colaborador)sessao.getAttribute("colaborador");
            }
          else {
              request.getRequestDispatcher("LogoutServlet").forward(request, response);
          }
    %>
    <body>
        <div id="cabecalho">

        <span><a href="LogoutServlet">Logout</a></span>
        </div>
        <div id="parte1"></div>
        <div id="parte2"></div>
        <div id="principal">
            <form method='post' action='CadastrarMateriaServlet'>
                <label>Area:</label>
                <select id="area_adicionadas" name="area">
                    <%
                        for(int i = 0; i < colaborador.getAreas().size(); i++){
                            out.print("<option value='" + colaborador.getAreas().get(i).getNome() + "'>" + colaborador.getAreas().get(i).getNome() + "</option>");
                        }
                    %>
                </select>
                <br>
                <label>Titulo:</label>
                <input type="text" name="titulo">
                <br>
                <textarea placeholder="Digite o texto da materia aqui" rows="30" cols="100" name="texto"></textarea>

                <input type="reset" value="Limpar">
                <input type="submit" value="Cadastrar">

            </form>
        </div>
    </body>
</html>
<%
        }
%>