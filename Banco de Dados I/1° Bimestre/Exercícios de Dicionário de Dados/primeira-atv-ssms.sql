-- criando um bd

create database ExercBD01

use ExercBD01

-- criando tabela

create table pet
(
 NumRegistro int, -- criando campo NumRegistro
 Nome varchar(80) Not Null, -- criando campo Nome
 Especie varchar(25) Not Null, -- criando campo Especie
 Raca varchar(30) Not Null, -- criando campo Raca
 Cor varchar(40) Not Null, -- criando campo Cor
 Nascimento datetime Not Null, -- criando campo Nascimento
 Sexo varchar(9) Not Null -- criando campo Sexo
);





-- exerc�cio 2

-- criando um bd

create database ExercBD02

-- entrando no bd

use ExercBD02

-- criando tabela do funcion�rio 

create table Funcionario
(
 CodFunc int, -- criando campo CodFunc
 NomeFunc varchar(50), -- criando campo NomeFunc
 CodDepto int, -- criando campo CodDepto
 Ramal int NULL , -- criando campo Ramal
 Salario float, -- criando campo Salario
 DataAdmissao datetime, -- criando campo DataAdmissao
 DataCadastro datetime, -- criando campo DataCadastro
 Sexo char(1) -- criando campo Sexo
 );





 -- exerc�cio 3


 -- criando um banco de dados

 create database ExercBD03A

 -- entrando no banco de dados

 use ExercBD03A

 -- criando tabela de papelaria

 create table papelaria
 (
 ID_Produto int PRIMARY KEY Not Null , -- campo para o id do produto
 Nome varchar(50) Not Null, -- campo para o nome do produto
 Estoque int Not Null , -- campo para o estoque do produto
 Preco float Not Null, -- campo para o pre�o do produto
 );






 -- exerc�cio 3 - b

  -- criando um banco de dados

 create database ExercBD03B

 -- entrando no banco de dados

 use ExercBD03B

 -- criando tabela de funcion�rios

 create table funcionario
 (
 RM int PRIMARY KEY Not Null , -- campo para o rm do funcion�rio
 Nome varchar(50) Not Null, -- campo para o nome do funcion�rio
 CPF varchar(11) Not Null, -- campo para o cpf do funcion�rio
 Cargo varchar(50) Not Null, -- campo para o cargo do funcion�rio
 Salario float Not Null, -- campo para o sal�rio do funcion�rio
 );






  -- exerc�cio 3 - c

  -- criando um banco de dados

 create database ExercBD03C

 -- entrando no banco de dados

 use ExercBD03C

 -- criando tabela de fornecedores

 create table Fornecedor
 (
 ID_Fornecedor int PRIMARY KEY Not Null , -- campo para o id do fornecedor
 Nome varchar(50) Not Null, -- campo para o nome do fornecedor
 CNPJ varchar(18) Not Null, -- campo para o cnpj do fornecedor
 Telefone varchar(14) Not Null, -- campo para o telefone do fornecedor
 Produto varchar(50) Not Null, -- campo para o produto fornecido
 );






   -- exerc�cio 3 - d

  -- criando um banco de dados

 create database ExercBD03D

 -- entrando no banco de dados

 use ExercBD03D

 -- criando tabela de departamentos

 create table Departamento
 (
 ID_Departamento int PRIMARY KEY Not Null , -- campo para o id do departamento
 Nome varchar(50) Not Null, -- campo para o nome do departamento 
 Localizacao varchar(100) Not Null, -- campo para a localiza��o do departamento
 Responsavel varchar(30) Not Null, -- campo para o respons�vel pelo departamento
 Email varchar(70) Not Null, -- campo para o email do departamento
 );






 -- exerc�cio extra, baseado nos outros 6

-- criando um banco de dados

create database ExercBDExtra

-- entrando no banco de dados

use ExercBDExtra

-- criando tabela de consultas veterin�rias

create table ConsultasVet
(
 ID_Consulta int PRIMARY KEY Not Null, -- campo para o id da consulta
 NumRegistroPet int Not Null, -- campo para o n�mero de registro do pet
 NomeDono varchar(80) Not Null, -- campo para o nome do dono do pet
 DataConsulta datetime Not Null, -- campo para a data da consulta
 TipoConsulta varchar(50) Not Null, -- campo para o tipo da consulta
 Veterinario varchar(80) Not Null, -- campo para o nome do veterin�rio
 Valor float Not Null, -- campo para o valor da consulta
 Observacoes text NULL -- campo para observa��es adicionais da consulta
);





-- exercicio extra, novamente

-- criando um banco de dados para um sistema de ado��o de pets com tr�s tabelas

create database ExercBDAdo��o;

-- entrando no banco de dados

use ExercBDAdo��o;

-- criando tabela de animais dispon�veis para ado��o

create table AnimaisAdocao (
    ID_Animal INT PRIMARY KEY NOT NULL, -- campo para o id do animal
    Nome VARCHAR(50) NOT NULL, -- campo para o nome do animal
    Especie VARCHAR(25) NOT NULL, -- campo para a esp�cie do animal
    Raca VARCHAR(30) NOT NULL, -- campo para a ra�a do animal
    Idade INT NOT NULL, -- campo para a idade do animal em anos
    Peso FLOAT NOT NULL, -- campo para o peso do animal
    Sexo CHAR(1) NOT NULL, -- campo para o sexo do animal
    EstadoSaude VARCHAR(100) NOT NULL, -- campo para o estado de sa�de do animal
    DataChegada DATETIME NOT NULL -- campo para a data de chegada ao abrigo
);

-- criando tabela de adotantes

create table Adotantes (
    ID_Adotante INT PRIMARY KEY NOT NULL, -- campo para o id do adotante
    Nome VARCHAR(80) NOT NULL, -- campo para o nome do adotante
    CPF VARCHAR(11) NOT NULL, -- campo para o cpf do adotante
    Endereco VARCHAR(100) NOT NULL, -- campo para o endere�o do adotante
    Telefone VARCHAR(14) NOT NULL, -- campo para o telefone do adotante
    Email VARCHAR(70) NOT NULL -- campo para o email do adotante
);

-- criando tabela de ado��es

create table Adocoes (
    ID_Adocao INT PRIMARY KEY NOT NULL, -- campo para o id da ado��o
    ID_Animal INT NOT NULL, -- campo para o id do animal adotado
    ID_Adotante INT NOT NULL, -- campo para o id do adotante
    DataAdocao DATETIME NOT NULL, -- campo para a data da ado��o
    Status VARCHAR(20) NOT NULL -- campo para o status da ado��o (em processo, conclu�da, cancelada)
);
