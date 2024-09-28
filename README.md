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
            Este projeto é um sistema de Cadastro de Clientes que implementa funcionalidades de CRUD: 
            Criação, Leitura, Atualização e Exclusão de registros. Utiliza o MySQL Workbench para modelar 
            e se conectar a um banco de dados MySQL, permitindo uma gestão eficiente dos dados dos clientes.
        </p>
        
  <br><br><br>

  <h2>⚙️ • Configuração</h2>
        <p>Para que o sistema funcione corretamente, siga os passos abaixo:</p>
        <ol>
            <li>
                Verifique se o <strong>IntelliJ IDEA</strong> está instalado em sua máquina como ambiente de desenvolvimento integrado (IDE).
            </li>
            <li>
                Assegure-se de que o <strong>Maven</strong> está configurado corretamente no IntelliJ IDEA, pois será utilizado como ferramenta de automação de build.
            </li>
            <li>
                Utilize o <strong>MySQL Workbench</strong> para configurar seu banco de dados. Ajuste as configurações de banco de dados, usuário e senha na classe <code>Conexao</code> dentro da pasta <code>conexao</code>.
            </li>
            <li>
                Crie o banco de dados e a tabela necessária utilizando o código SQL abaixo no MySQL Workbench:
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
            Para iniciar o formulário de cadastro de clientes, abra o projeto no <strong>IntelliJ IDEA</strong> e execute a 
            classe <code>ClienteFormulario</code>, que está localizada na pasta <code>formularios</code>.
        </p>
        
  <br><br><br>

  <h2>📜 • Licença</h2>
        <p>
            Este projeto está licenciado sob a <strong>Licença MIT</strong>, permitindo sua utilização, modificação e 
            distribuição de forma livre, desde que os devidos créditos sejam concedidos.
        </p>
    </div>
</body>
</html>
