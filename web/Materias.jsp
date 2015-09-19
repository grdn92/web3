<%@page import="br.com.projetoSeLiga.model.Materia"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.projetoSeLiga.dao.FachadaDAO"%>
<%@page import="br.com.projetoSeLiga.model.Colaborador"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    session="false"%>
<%! String nome;%>
<% 
    HttpSession sessao = request.getSession(false);
    if(sessao == null){
            request.getRequestDispatcher("Login.jsp").forward(request, response);
    }
    else{
          Colaborador colaborador = new Colaborador();
          FachadaDAO fachadaDAO = FachadaDAO.getInstance();
          ArrayList<Materia> materias = fachadaDAO.selecionarTodasMaterias();
          if((Colaborador)sessao.getAttribute("colaborador") != null){
              colaborador = (Colaborador)sessao.getAttribute("colaborador");
              nome = colaborador.getNome();
          }
          else {
              request.getRequestDispatcher("LogoutServlet").forward(request, response);
          }
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Materias</title>
<link rel='stylesheet' href='style.css' type='text/css'>
</head>
<body>
    <div id="cabecalho">
    
    <span><a href="LogoutServlet">Logout</a></span>
    <span><a href="TelaInicial.jsp">Tela Inicial</a></span>
    </div>
    <div id="parte1"></div>
    <div id="parte2"></div>
    <div id="principal">
        <div class="conteudo" style="width:25%; float:left; margin-left: 7px; height: 180px;">
            <span class="principalForm" style="width: 100%"><%=nome%></span>
            <ul>
                <li style="font-size: 25px;"><a href="CadastroMateria.jsp">Nova Materia</a></li>
            </ul>
        </div>
        <div class="conteudo" style="width:25%; margin-left: 7px; height: 500px;">
            <span class="principalForm" style="width: 100%">Categorias</span>
            <ul>
                <%
                    for(int i = 0; i < colaborador.getAreas().size(); i++){
                        out.print("<li><a href='#'>" + colaborador.getAreas().get(i).getNome() + "</a></li>");
                    }
                %>
            </ul>
        </div>
        <div class="conteudo" style="width:70%; float:right; margin-right: 7px; margin-top: -473px; height: 600px">
            <span class="principalForm" style="width: 100%">Minhas Materias</span>
            <div>
                <%
                    for(int i = 0; i < materias.size(); i++){
                        //if(materias.get(i).getLoginColaborador().equals(colaborador.getLogin()))
                            out.print("<h1 align='center'><a href='#'>" + materias.get(i).getTitulo() + "</a></h1>");
                    }
                %>
            </div>
        </div>
    </div>
</body>
</html>
<%
    }
%>