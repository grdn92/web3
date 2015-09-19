<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${pageContext.session == null}">
    <c:redirect url="Login.jsp" />
</c:if>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Area</title>
        <link rel='stylesheet' href='style.css' type='text/css'>
    </head>
    <body>
        <h1>Cadastro de Area</h1>
        <form method='post' action='CadastrarAreaServlet'>
            <label>Nome:</label>
            <input type="text" name="nome">
            <br>
            <input type="reset" value="Limpar">
            <input type="submit" value="Cadastrar">
        </form>
    </body>
</html>
