<%-- 
    Document   : listaUsuario
    Created on : 25/03/2016, 19:40:09
    Author     : Matheus Barriolo
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de usuarios</title>
    </head>
    <body>
        <h1>Listagem de usuarios</h1>
        
        <sql:setDataSource var="usuario" driver="com.mysql.jdbc.Driver"
                           url="jdbc:mysql://localhost/calloftaxi"
                           user="root"  password="271193"/>

        <sql:query dataSource="${usuario}" var="result">
            SELECT * from usuario;
        </sql:query>

        <table border="1" width="50%">
            <tr>
                <th>Nome</th>
                <th>Email</th>
                <th>Login</th>
                <th>Senha</th>
                <th>Confirmação de Senha</th>
                <th>DDD Celular</th>
                <th>Celular</th>
                <th>DDD Telefone</th>
                <th>Telefone</th>
                <th>Estado</th>
                <th>Cidade</th>
                <th>Bairro</th>
                <th>Logradouro</th>
                <th>Complemento</th>

            </tr>
            <c:forEach var="row" items="${result.rows}">
                <tr>
                    <td><c:out value="${row.nome}"/></td>
                    <td><c:out value="${row.email}"/></td>
                     <td><c:out value="${row.login}"/></td>
                    <td><c:out value="${row.senha}"/></td>
                    <td><c:out value="${row.confSenha}"/></td>
                    <td><c:out value="${row.dddCelular}"/></td>
                    <td><c:out value="${row.celular}"/></td>
                    <td><c:out value="${row.dddTelefone}"/></td>
                    <td><c:out value="${row.telefone}"/></td>
                    <td><c:out value="${row.estado}"/></td>
                    <td><c:out value="${row.cidade}"/></td>
                    <td><c:out value="${row.bairro}"/></td>
                    <td><c:out value="${row.logradouro}"/></td>
                    <td><c:out value="${row.complemento}"/></td>
                </tr>
            </c:forEach>
        </table>
           <a href="http://localhost:8080/piTaxi/">Cadastrar novo usuário</a>
    </body>
</html>
