<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <link rel="icon" href="images/favicon.png">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <title>Cadastro</title>
    </head>

    <body>
        <header>
            <h2>Cadastro de Usuário</h2>
        </header>
        <main>
            <div class="main">
                <form action="insertUsuario" name="validarForm">
                    <div>
                        <label for="Nome">Nome:</label>
                        <input type="text" name="nome" placeholder="Digite seu nome">
                    </div>
                    <div>
                        <label for="Profissao">Profissão:</label>
                        <input type="text" name="profissao" placeholder="Digite sua profissão">
                    </div>
                    <div>
                        <label for="Idade">Idade:</label>
                        <input type="number" name="idade" placeholder="Digite sua idade">
                    </div>
                    <input type="button" value="Cadastrar" onclick="validationOfForm()" class="btn-form">
                </form>
            </div>
            <div class="description">
                <div class="title">
                    <h1>Simplificando o Gerenciamento de Funcionários</h1>
                </div>
                <div class="sub-title">
                    <p>Registre, Acompanhe e Gerencie Sua Equipe de Forma Eficiente. Veja os seus usuários abaixo:</p>
                </div>
                <a href="main" class="listar-user">Listar</a>
            </div>
        </main>

        <script src="scripts/main.js"></script>
    </body>
</html>
