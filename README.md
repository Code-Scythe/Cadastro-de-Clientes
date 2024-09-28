<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
    <div class="container">
        <h1>📋 • Cadastro de Clientes</h1>
        <p>
            Este projeto é um sistema de Cadastro de Clientes que implementa funcionalidades de CRUD (Criação, Leitura, Atualização e Exclusão de registros) e utiliza o MySQL Workbench para gerenciar um banco de dados MySQL.
        </p>

<br><br><br>

<h2>⚙️ • Configuração</h2>
        <ol>
            <li>
                Verifique se o <strong>IntelliJ IDEA</strong> está instalado.
            </li>
            <li>
                Assegure-se de que o <strong>Maven</strong> está configurado no IntelliJ IDEA.
            </li>
            <li>
                Ajuste as configurações de banco de dados na classe <code>Conexao</code> na pasta <code>conexao</code>.
            </li>
            <li>
                O projeto foi desenvolvido em <strong>Java</strong> com <strong>JDK 21 LTS</strong>.
            </li>
            <li>
                Crie o banco de dados e a tabela utilizando o código SQL abaixo:
            </li>
        </ol>
        <pre><code>CREATE DATABASE CLIENTES_DB;

USE CLIENTES_DB;

CREATE TABLE CLIENTES (
    ID INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    TIPO_PESSOA CHAR(1),
    CPF_CNPJ VARCHAR(20) UNIQUE,
    NOME VARCHAR(150) NOT NULL,
    LIMITE_CREDITO NUMERIC(10, 2) NOT NULL
);</code></pre>

<br><br><br>

<h2>🚀 • Execução</h2>
        <p>
            Para iniciar o formulário de cadastro, execute a classe <code>ClienteFormulario</code> na pasta <code>formularios</code>.
        </p>

<br><br><br>

<h2>📜 • Licença</h2>
        <p>
            Este projeto está licenciado sob a <strong>Licença MIT</strong>.
        </p>
    </div>
</body>
</html>
