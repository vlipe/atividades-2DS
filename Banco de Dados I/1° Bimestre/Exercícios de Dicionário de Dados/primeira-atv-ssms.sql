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





-- exercício 2

-- criando um bd

create database ExercBD02

-- entrando no bd

use ExercBD02

-- criando tabela do funcionário 

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





 -- exercício 3


 -- criando um bd

 create database ExercBD03A

 -- entrando no bd

 use ExercBD03A

 -- criando tabela da papelaria

 create table papelaria
 (
 ID_Produto int PRIMARY KEY Not Null , -- criando campo ID_Produto
 Nome varchar(50) Not Null, -- criando campo Nome
 Estoque int Not Null , -- criando campo Estoque
 Preco float Not Null, -- criando campo Preco
 );





 -- exercício 3 - b

  -- criando um bd

 create database ExercBD03B

 -- entrando no bd

 use ExercBD03B

 -- criando tabela do funcionário 

 create table funcionario
 (
 RM int PRIMARY KEY Not Null , -- criando campo RM
 Nome varchar(50) Not Null, -- criando campo Nome
 CPF varchar(11) Not Null, -- criando campo CPF
 Cargo varchar(50) Not Null, -- criando campo Cargo
 Salario float Not Null, -- criando campo Salario
 );





  -- exercício 3 - c

  -- criando um bd

 create database ExercBD03C

 -- entrando no bd

 use ExercBD03C

 -- criando tabela do fornecedor 

 create table Fornecedor
 (
 ID_Fornecedor int PRIMARY KEY Not Null , -- criando campo ID_Fornecedor
 Nome varchar(50) Not Null, -- criando campo Nome
 CNPJ varchar(18) Not Null, -- criando campo CNPJ
 Telefone varchar(14) Not Null, -- criando campo Telefone
 Produto varchar(50) Not Null, -- criando campo Produto
 );





   -- exercício 3 - d

  -- criando um bd

 create database ExercBD03D

 -- entrando no bd

 use ExercBD03D

 -- criando tabela do departamento 

 create table Departamento
 (
 ID_Departamento int PRIMARY KEY Not Null , -- criando campo ID_Departamento
 Nome varchar(50) Not Null, -- criando campo Nome 
 Localizacao varchar(100) Not Null, -- criando campo Localizacao. avisar a prof que escrevi o atributo diferente em comparação a tabela porque fica destacado se escrito corretamente
 Responsavel varchar(30) Not Null, -- criando campo Responsavel
 Email varchar(70) Not Null, -- criando campo Email
 );





 -- exercício extra, baseado nos outros 6

-- criando um bd

create database ExercBDExtra

-- entrando no bd

use ExercBDExtra

-- criando tabela de consultas veterinárias

create table ConsultasVet
(
 ID_Consulta int PRIMARY KEY Not Null, -- criando campo ID_Consulta
 NumRegistroPet int Not Null, -- criando campo NumRegistroPet
 NomeDono varchar(80) Not Null, -- criando campo NomeDono
 DataConsulta datetime Not Null, -- criando campo DataConsulta
 TipoConsulta varchar(50) Not Null, -- criando campo TipoConsulta
 Veterinario varchar(80) Not Null, -- criando campo Veterinario
 Valor float Not Null, -- criando campo Valor
 Observacoes text NULL -- criando campo Observacoes
);
