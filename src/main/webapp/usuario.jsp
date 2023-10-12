<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<%@ page import="entity.User" %>
<%@ page import="java.util.ArrayList" %>

<%
    ArrayList<User> list = (ArrayList<User>) request.getAttribute("usuarios");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <link rel="icon" href="images/favicon.png">
        <link rel="stylesheet" href="css/table.css">
        <title>Usuários</title>
    </head>

    <body>
        <h2>Lista de usuários</h2>
        <br/>
        <table>
            <caption>Usuários</caption>
            <thead>
                <tr>
                    <th>#</th>
                    <th>Nome</th>
                    <th>Profissão</th>
                    <th>Idade</th>
                    <th>Deletar</>
                </tr>
            </thead>
            <tbody>
                <% for(int i = 0; i < list.size(); i++){ %>
                    <tr>
                        <td><%= list.get(i).getCod_registro() %></td>
                        <td><%= list.get(i).getNome() %></td>
                        <td><%= list.get(i).getProfissao() %></td>
                        <td><%= list.get(i).getIdade() %></td>
                        <td><a href="javascript: confirmarExcluir(<%= list.get(i).getCod_registro() %>)">Excluir</a></td>
                    </tr>
                <% } %>
            </tbody>
        </table>
        <div class="description">
            <div class="title">
                <h1>Simplificando o Gerenciamento de Funcionários</h1>
            </div>
            <div class="sub-title">
                <p>Registre, Acompanhe e Gerencie Sua Equipe de Forma Eficiente. Veja os seus usuários abaixo:</p>
            </div>
            <a href="index.jsp" class="listar-user">Cadastrar</a>
        </div>

        <script src="scripts/confirmador.js"></script>
    </body>
</html>
