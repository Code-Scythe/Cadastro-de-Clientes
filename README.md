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
            Este projeto consiste em um sistema de Cadastro de Clientes que permite realizar operações de CRUD (Criação, Leitura, Atualização e Exclusão) utilizando um banco de dados MySQL.
        </p>

<br><br><br>

<h2>🌟 • Visão Geral do Projeto</h2>
        <img src="https://raw.githubusercontent.com/Code-Scythe/Cadastro-de-Clientes/refs/heads/main/imagens/Cadastro%20de%20Clientes.png" alt="Visão Geral do Projeto" style="max-width: 100%; height: auto;">

<br><br><br>

<h2>🛠️ • Tecnologias Utilizadas</h2>
        <ul>
            <li><strong>Java</strong> (JDK 21 LTS)</li>
            <li><strong>MySQL</strong> (Banco de Dados)</li>
            <li><strong>Maven</strong> (Gerenciador de Dependências)</li>
            <li><strong>IntelliJ IDEA</strong> (IDE)</li>
            <li><strong>JDBC</strong> (Java Database Connectivity)</li>
        </ul>

<br><br><br>

<h2>⚙️ • Configuração</h2>
        <ol>
            <li>Verifique se o <strong>IntelliJ IDEA</strong> está instalado.</li>
            <li>Certifique-se de que o <strong>Maven</strong> está configurado no IntelliJ IDEA.</li>
            <li>Atualize as configurações do banco de dados na classe <code>Conexao</code>.</li>
            <li>Crie o banco de dados e a tabela utilizando o seguinte código SQL:</li>
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
            Para iniciar o formulário de cadastro, execute a classe <code>ClienteFormulario</code> localizada na pasta <code>formularios</code>.
        </p>

<br><br><br>

<h2>📜 • Licença</h2>
        <p>
            Este projeto é licenciado sob a <strong>Licença MIT</strong>.
        </p>

<br><br><br>

<h2>📬 • Contato</h2>
        <p>
            Para dúvidas, sugestões ou feedback, entre em contato pelo email: 
            <a href="mailto:scythe.github@gmail.com">scythe.github@gmail.com</a>
        </p>
    </div>
</body>
</html>
