<%-- 
    Document   : callOfTaxi
    Created on : 19/03/2016, 18:15:16
    Author     : Matheus Barriolo
--%>

<%@page import="model.CallOfTaxi"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Call of Taxi</h1>
        
        Nome: ${usuario.nome}<br>
        E-mail:${usuario.email}<br>
        Login:${usuario.login}<br>
        Senha:${usuario.senha}<br>
        Confirmação de senha:${usuario.confSenha}<br>
        DDD Celular: <%=((CallOfTaxi)request.getAttribute("usuario")).getDddCelular()%>
        Celular: <%=((CallOfTaxi)request.getAttribute("usuario")).getCelular()%><br>
        DDD Telefone: <%=((CallOfTaxi)request.getAttribute("usuario")).getDddTelefone()%>
        Telefone: <%=((CallOfTaxi)request.getAttribute("usuario")).getTelefone()%><br>
        Estado: <%= ((CallOfTaxi)request.getAttribute("usuario")).getEstado()%>
        Cidade: <%=((CallOfTaxi)request.getAttribute("usuario")).getCidade()%><br>
        Bairro: <%=((CallOfTaxi)request.getAttribute("usuario")).getBairro()%><br>
        Logradouro: <%=((CallOfTaxi)request.getAttribute("usuario")).getLogradouro()%><br>
        Complemento: <%=((CallOfTaxi)request.getAttribute("usuario")).getComplemento()%>
        
    </body>
</html>
