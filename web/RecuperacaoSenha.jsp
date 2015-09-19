<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Recuperação de Senha</title>
<link rel='stylesheet' href='style.css' type='text/css'>
</head>
<body>
	<div id="cabecalho">
		<span><a href="GerenciamentoColaborador.jsp">Cadastre-se</a></span>
		<span><a href="Login.jsp">Login</a></span>
	</div>
	<div id="parte1"></div>
	<div id="parte2"></div>
	<div id="principal">
		<div class="conteudo" style="float: left; margin-left: 100px">
			<span class="principalForm">Recuperar Senha</span>
			<form method='post' action='Login.jsp' style="width: 400px;">
			
				<label>Informe seu email cadastrado e clique em enviar.</label>
				<br>
				<label>Email:</label>
				<br>
				<input type="text" name="login" size="30" />
				<br>
				<input type="reset" value="Limpar">
				<input type="submit" value="Enviar">
			</form>
		</div>
	</div>
</body>
</html>