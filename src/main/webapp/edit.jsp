<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <link rel="icon" href="images/favicon.png">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <title>Edit</title>
    </head>

    <body>
        <header>
            <h2>Editar usuário</h2>
        </header>
        <main>
            <div class="main">
                <form action="updateUsuario" name="validarForm">
                    <div>
                        <label for="Cod_registro">Id:</label>
                        <input type="text" name="cod_registro" readonly value="<% out.print(request.getAttribute("cod_registro")); %>">
                    </div>
                    <div>
                        <label for="Nome">Nome:</label>
                        <input type="text" name="nome" value="<% out.print(request.getAttribute("nome")); %>">
                    </div>
                    <div>
                        <label for="Profissao">Profissão:</label>
                        <input type="text" name="profissao" value="<% out.print(request.getAttribute("profissao")); %>">
                    </div>
                    <div>
                        <label for="Idade">Idade:</label>
                        <input type="number" name="idade" value="<% out.print(request.getAttribute("idade")); %>">
                    </div>
                    <input type="button" value="Atualizar" onclick="validationOfForm()" class="btn-form">
                </form>
            </div>
                <a href="main" class="listar-user">Listar</a>
        </main>

        <script src="scripts/main.js"></script>
    </body>
</html>
