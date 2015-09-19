<%@page import="br.com.projetoSeLiga.model.Area"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.projetoSeLiga.dao.FachadaDAO"%>
<%@page import="java.sql.Date"%>
<%@page import="br.com.projetoSeLiga.model.Colaborador"%>
<%@page import="br.com.projetoSeLiga.dao.ColaboradorDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Contet-Type" content="text/html; charset=UTF-8">
    <title>Colaborador</title>
    <link rel='stylesheet' href='style.css' type='text/css'>
    <script type="text/javascript" src="script.js"></script>
</head>
<body>
    <div id="cabecalho">
        <%
            FachadaDAO fachadaDAO = FachadaDAO.getInstance();
            ArrayList<Area> areas = new ArrayList<Area>();
            areas = fachadaDAO.selecionarTodasAreas();
            
            HttpSession sessao = request.getSession(false);
            int dia = 1, mes = 1, ano = 2015;
            if(sessao != null) { 
        %>
            <span><a href="LogoutServlet">Logout</a></span>
            <span><a href="TelaInicial.jsp">Tela Principal</a></span>
        <% } else { %>
            <span><a href="Login.jsp">Login</a></span>
        <% } %>
    </div>
    <div id="parte1"></div>
    <div id="parte2"></div>
    <div id="principal">
        <div class="conteudo" style="float: left; margin-left: 100px; height: 700px;">
            <%! Colaborador colaborador;%>
            <%
                if(sessao != null) {
                    colaborador = (Colaborador)sessao.getAttribute("colaborador");
            %>
            <span class="principalForm">Gerenciamento de Colaborador</span>
            <form onsubmit="return validarFormularioColaborador(false)" method='post' action='AtualizarColaboradorServlet' style="width: 95%;">
            <% 
                }
                else{
                    colaborador = new Colaborador();
            %>
            <span class="principalForm">Cadastro de Colaborador</span>
            <form onsubmit="return validarFormularioColaborador(true)" method='post' action='CadastrarColaboradorServlet' style="width: 95%;">
            <% 
               }
            %>
            <%!
                String nome, cpf, rg, email, rua, complemento, bairro, cidade, uf, cep, login, senha, numeroString;
                int numero, diaNascimento = 1, mesNascimento = 1, anoNascimento = 1990;
                Date dataNascimento;
            %>
            <%
                nome = colaborador.getNome();
                cpf = colaborador.getCpf();
                rg = colaborador.getRg();
                email = colaborador.getEmail();
                rua = colaborador.getRua();
                complemento = colaborador.getComplemento();
                bairro = colaborador.getBairro();
                cidade = colaborador.getCidade();
                uf = colaborador.getUf();
                cep = colaborador.getCep();
                login = colaborador.getLogin();
                senha = colaborador.getSenha();
                numero = colaborador.getNumero();
                diaNascimento = 1;
                mesNascimento = 1;
                anoNascimento = 2015;
                numeroString = "";
                if(numero > 0)
                    numeroString = "" + numero;
                if(colaborador.getDataNascimento() != null){
                    dataNascimento = colaborador.getDataNascimento();
                    diaNascimento = Integer.parseInt(dataNascimento.toString().substring(8, 10));
                    mesNascimento = Integer.parseInt(dataNascimento.toString().substring(5, 7));
                    anoNascimento = Integer.parseInt(dataNascimento.toString().substring(0, 4));
                }
                

            %>
                <fieldset>
                <legend>Pessoal</legend>
                <label>*Nome:</label>

                <input id="nomeColaborador" type="text" name="nome" size="53" placeholder="nome completo" value="<%=nome%>" autofocus/>
                <label> | Nascimento:</label>
                <select name="diaNascimento">
                    <%
                        dia = 1;
                        for(; dia <= 31; dia++)
                        {
                            if(dia < 10){
                                
                                if(dia == diaNascimento)
                                    out.println("<option selected='selected'>0" + dia);
                                else
                                    out.println("<option>0" + dia);
                            }
                            else{
                                if(dia == diaNascimento)
                                    out.println("<option selected='selected'>" + dia);
                                else
                                    out.println("<option>" + dia);
                            }
                        }
                    %>
                </select>
                <label> / </label>
                <select name="mesNascimento">
                    <%
                        mes = 1;
                        for(; mes <= 12; mes++)
                        {
                            if(mes < 10){
                                if(mes == mesNascimento)
                                    out.println("<option selected='selected'>0" + mes);
                                else
                                    out.println("<option>0" + mes);
                            }
                            else{
                                if(mes == mesNascimento)
                                    out.println("<option selected='selected'>0" + mes);
                                else
                                    out.println("<option>" + mes);
                            }
                        }
                    %>
                </select>
                <label> / </label>
                <select name="anoNascimento">
                    <%
                        ano = 2015;
                        for(; ano >= 1900; ano--)
                        {
                            if(ano == anoNascimento)
                                    out.println("<option selected='selected'>" + ano);
                            else
                                out.println("<option>" + ano);
                        }
                    %>
                </select>

                <label>CPF:</label>
                <input type="text" name="cpf" size="25" value="<%=cpf%>"/>
                <label> | RG:</label>
                <input type="text" name="rg" size="20" value="<%=rg%>"/>
                <label> | Email:</label>
                <input type="text" name="email" size="35" value="<%=email%>"/>
            </fieldset>

            <fieldset>
                <legend>Endereço</legend>
                <label>Rua:</label>
                <input type="text" name="rua" size="38" value="<%=rua%>"/>
                <label> | Nº:</label>
                <input type="text" name="numero" size="6" value="<%=numeroString%>"/>
                <label> | Complemento:</label>
                <input type="text" name="complemento" size="27" value="<%=complemento%>"/>

                <label>Bairro:</label>
                <input type="text" name="bairro" size="27" value="<%=bairro%>"/>
                <label> | Cidade:</label>
                <input type="text" name="cidade" size="23" value="<%=cidade%>"/>
                <label> | UF:</label>
                <select name="uf" >
                    <%
                        if(uf.equals("")){
                            out.print("<option selected='selected'>");
                        }
                        else{
                            out.print("<option>");
                        }
                        if(uf.equals("AC")){
                            out.print("<option selected='selected'>AC");
                        }
                        else{
                            out.print("<option>AC");
                        }
                        if(uf.equals("AL")){
                            out.print("<option selected='selected'>AL");
                        }
                        else{
                            out.print("<option>AL");
                        }
                        if(uf.equals("AP")){
                            out.print("<option selected='selected'>AP");
                        }
                        else{
                            out.print("<option>AP");
                        }
                        if(uf.equals("AM")){
                            out.print("<option selected='selected'>AM");
                        }
                        else{
                            out.print("<option>AM");
                        }
                        if(uf.equals("BA")){
                            out.print("<option selected='selected'>BA");
                        }
                        else{
                            out.print("<option>BA");
                        }
                        if(uf.equals("CE")){
                            out.print("<option selected='selected'>CE");
                        }
                        else{
                            out.print("<option>CE");
                        }
                        if(uf.equals("DF")){
                            out.print("<option selected='selected'>DF");
                        }
                        else{
                            out.print("<option>DF");
                        }
                        if(uf.equals("ES")){
                            out.print("<option selected='selected'>ES");
                        }
                        else{
                            out.print("<option>ES");
                        }
                        if(uf.equals("GO")){
                            out.print("<option selected='selected'>GO");
                        }
                        else{
                            out.print("<option>GO");
                        }
                        if(uf.equals("MA")){
                            out.print("<option selected='selected'>MA");
                        }
                        else{
                            out.print("<option>MA");
                        }
                        if(uf.equals("MT")){
                            out.print("<option selected='selected'>MT");
                        }
                        else{
                            out.print("<option>MT");
                        }
                        if(uf.equals("MS")){
                            out.print("<option selected='selected'>MS");
                        }
                        else{
                            out.print("<option>MS");
                        }
                        if(uf.equals("MG")){
                            out.print("<option selected='selected'>MG");
                        }
                        else{
                            out.print("<option>MG");
                        }
                        if(uf.equals("PA")){
                            out.print("<option selected='selected'>PA");
                        }
                        else{
                            out.print("<option>PA");
                        }
                        if(uf.equals("PB")){
                            out.print("<option selected='selected'>PB");
                        }
                        else{
                            out.print("<option>PB");
                        }
                        if(uf.equals("PR")){
                            out.print("<option selected='selected'>PR");
                        }
                        else{
                            out.print("<option> PR");
                        }
                        if(uf.equals("PE")){
                            out.print("<option selected='selected'>PE");
                        }
                        else{
                            out.print("<option> PE");
                        }
                        if(uf.equals("PI")){
                            out.print("<option selected='selected'>PI");
                        }
                        else{
                            out.print("<option> PI");
                        }
                        if(uf.equals("RJ")){
                            out.print("<option selected='selected'>RJ");
                        }
                        else{
                            out.print("<option> RJ");
                        }
                        if(uf.equals("RN")){
                            out.print("<option selected='selected'>RN");
                        }
                        else{
                            out.print("<option> RN");
                        }
                        if(uf.equals("RS")){
                            out.print("<option selected='selected'>RS");
                        }
                        else{
                            out.print("<option> RS");
                        }
                        if(uf.equals("RO")){
                            out.print("<option selected='selected'>RO");
                        }
                        else{
                            out.print("<option> RO");
                        }
                        if(uf.equals("RR")){
                            out.print("<option selected='selected'>RR");
                        }
                        else{
                            out.print("<option> RR");
                        }
                        if(uf.equals("SC")){
                            out.print("<option selected='selected'>SC");
                        }
                        else{
                            out.print("<option> SC");
                        }
                        if(uf.equals("SP")){
                            out.print("<option selected='selected'>SP");
                        }
                        else{
                            out.print("<option> SP");
                        }
                        if(uf.equals("SE")){
                            out.print("<option selected='selected'>SE");
                        }
                        else{
                            out.print("<option> SE");
                        }
                        if(uf.equals("TO")){
                            out.print("<option selected='selected'>TO");
                        }
                        else{
                            out.print("<option> TO");
                        }
                    %>
                </select>
                <label> | CEP:</label>
                <input type="text" name="cep" size="10" value="<%=cep%>"/>
            </fieldset>

            <fieldset>
                <legend>Login</legend>
                <label>*Usuário:</label>
                <%
                if(sessao!= null){
                    out.print("<input id='loginColaborador' type='text' name='login' size='30' value='" + login + "' readonly>");
                }
                else
                    out.print("<input id='loginColaborador' type='text' name='login' size='30' value='" + login + "'>");
                %>
                <label> | *Senha:</label>
                <input id="senha" type="password" name="senha" size="15"/>
                <label> | *Confirmar Senha:</label>
                <input id="senhaRepetida" type="password" name="senhaRepetida" size="15"/>
            </fieldset>

            <span class="principalForm" style="margin-right: -40px; margin-top: 40px;">Preferências</span>

            <select id="area_selecionadas" multiple name="area_selecionadas" size="10" style="float: left; width: 140px; margin-left: 100px;">
                <%
                    forPrincipal:
                    for(int i = 0; i < areas.size(); i++){
                        for(int j = 0; j < colaborador.getAreas().size(); j++){
                            if(areas.get(i).getNome().equals(colaborador.getAreas().get(j).getNome()))
                                continue forPrincipal;
                        }
                        out.print("<option value='" + areas.get(i).getNome() + "'>" + areas.get(i).getNome()+ "</option>");
                    }
                %>
            </select>

            <select id="area_adicionadas" multiple name="area_adicionadas" size="10" style="float: right; width: 140px; margin-right: 100px;">
                <%
                    for(int i = 0; i < colaborador.getAreas().size(); i++){
                        out.print("<option value='" + colaborador.getAreas().get(i).getNome() + "'>" + colaborador.getAreas().get(i).getNome() + "</option>");
                    }
                %>
            </select>

            <input class="botaoFormatar" type="button" value="Adicionar &raquo;" onclick="adicionarAreas()" style="margin-left: 90px; margin-top: 40px; font-size: 15px;" />
            <br>
            <input class="botaoFormatar" type="button" value="&laquo; Remover" onclick="removerAreas()" style="margin-left: 90px; margin-top: 6px; font-size: 15px;" />
            <br>
            <input type="checkbox" name="concordoTermo" value="concordoTermo" style="margin-top: 100px">Concordo com os <a href="termos_de_uso2.html" style="color: #325D8D;">termos e serviços.</a>
            <%if(sessao != null) { %>
                <a href="RemoverColaboradorServlet" onclick="return confirm('Deseja realmente excluir seu perfil?\nOs dados serão excluídos permanentemente.')"><input type="button" value="Excluir" href="" style="margin-top: 50px; font-size: 25px; margin-left: 310px;"></a>
                <input type="submit" value="Alterar" style="font-size: 25px;">
            <% } else { %>
                <input type="reset" value="Limpar" style="margin-top: 50px; font-size: 25px; margin-left: 310px;">
                <input type="submit" value="Cadastrar" style="font-size: 25px;">
            <% } %>
        </div>
    </div>
</body>
</html>