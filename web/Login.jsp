<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    session="false"%>
<% 
    HttpSession sessao = request.getSession(false);
    if(sessao != null)  {
        request.getRequestDispatcher("TelaInicial.jsp").forward(request, response);
    }
    else {
%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<link rel='stylesheet' href='style.css' type='text/css'>
</head>
<body>
    <div id="cabecalho">
    <span><a href="GerenciamentoColaborador.jsp">Cadastre-se</a></span>
    </div>
    <div id="parte1"></div>
    <div id="parte2"></div>
    <div id="principal">
        <div class="conteudo" style="float: left; margin-left: 100px">
            <span class="principalForm">Entrar</span>
            <form method='post' action='LoginServlet'>
                <label>Nome de usuário:</label>
                <input type="text" name="login" size="30" style="margin-bottom: -5px;" autofocus />
                <label style="font-size: 5px;">Precisa de uma conta? <a href="GerenciamentoColaborador.jsp" style="color: #325D8D;">Cadastre-se aqui!</a></label>
                <br>
                <label>Senha:</label>
                <input type="password" name="senha" size="30" style="margin-bottom: -5px;" />
                <label style="font-size: 5px;"><a href="RecuperacaoSenha.jsp" style="color: #325D8D;">Esqueci minha senha</a></label>
                <br>
                <input type="checkbox" name="lembrarDados" style="margin-top: 20px; margin-right: 5px;">Lembrar dados
                <br>
                <input type="reset" value="Cancelar" style="margin-top: 15px;">
                <input type="submit" value="Entrar">
            </form>
        </div>
    </div>
</body>
</html>
<%
	}
%>