-- criar bd Exemplo_Select
CREATE DATABASE Exemplo_Select;

-- abrir bd Exemplo_Select
use Exemplo_Select;

-- cria��o tabela Categoria
CREATE TABLE Categoria
(
Cod_Categoria int,
Nome_Categoria varchar (15) NOT NULL,
Descricao varchar(25) NULL,
PRIMARY KEY (Cod_Categoria)
 );

INSERT into categoria (Cod_categoria,Nome_categoria,descricao) 
VALUES (1,'Beverages','Soft drinks');

INSERT into categoria (Cod_categoria,Nome_categoria,descricao) 
VALUES (2,'Condiments','Sweet and savory sauces');

INSERT into categoria (Cod_categoria,Nome_categoria,descricao) 
VALUES (3,'Confections','candies');

INSERT into categoria (Cod_categoria,Nome_categoria,descricao) 
VALUES (4,'Dairy Products','Queijo');

INSERT into categoria (Cod_categoria,Nome_categoria,descricao) 
VALUES (5,'Grains/Cereals','cereal');

INSERT into categoria (Cod_categoria,Nome_categoria,descricao) 
VALUES (6,'Meat/Poultry','Prepared meats');

INSERT into categoria (Cod_categoria,Nome_categoria,descricao) 
VALUES (7,'Produce','Dried fruit and bean curd');

INSERT into categoria (Cod_categoria,Nome_categoria,descricao) 
VALUES (8,'Seafood','Seaweed and fish');

select * from categoria;

CREATE TABLE Envio
 (
	Cod_Envio int,
 	DataEnvio datetime,
  	Frete int,
	NomeNavio varchar(40),
 	Cidade varchar(15),
	Regiao varchar(15),
 	Pais varchar(15)
 );


INSERT INTO Envio (Cod_Envio,DataEnvio,Frete,NomeNavio,Cidade,Regiao,Pais)
VALUES (10248,'7/4/1996',32.38,'Vins et alcools Chevalier','Abbaye','Reims','France');

INSERT INTO Envio (Cod_Envio,DataEnvio,Frete,NomeNavio,Cidade,Regiao,Pais)
VALUES (10249,'7/5/1996',11.61,'Toms Spezialitaten','Luisenstr',nULL,'Germany');

INSERT INTO Envio (Cod_Envio,DataEnvio,Frete,NomeNavio,Cidade,Regiao,Pais)
VALUES (10250,'7/8/1996',65.83,'Hanari Carnes','Rio de Janeiro','Sudeste','Brazil');

INSERT INTO Envio (Cod_Envio,DataEnvio,Frete,NomeNavio,Cidade,Regiao,Pais)
VALUES (10251,'7/8/1996',41.34,'Victuailles en stock','Lyon',NULL,'France');

INSERT INTO Envio (Cod_Envio,DataEnvio,Frete,NomeNavio,Cidade,Regiao,Pais)
VALUES (10252,'7/9/1996',51.30,'Supremes delices','Boulevard Tirou', 'Charleroi','Belgium');

INSERT INTO Envio (Cod_Envio,DataEnvio,Frete,NomeNavio,Cidade,Regiao,Pais)
VALUES (10253,'7/10/1996',58.17,'Hanari Carnes','Rio de Janeiro','Sudeste','Brazil');

INSERT INTO Envio (Cod_Envio,DataEnvio,Frete,NomeNavio,Cidade,Regiao,Pais)
vALUES (10254,'7/11/1996',22.98,'Chop-suey Chinese','Bern',NULL,'Switzerland');

INSERT INTO Envio (Cod_Envio,DataEnvio,Frete,NomeNavio,Cidade,Regiao,Pais)
VALUES (10255,'7/12/1996',148.33,'Richter Supermarkt','Geneve',	NULL,'Switzerland');

INSERT INTO Envio (Cod_Envio,DataEnvio,Frete,NomeNavio,Cidade,Regiao,Pais)
VALUES (10256,'15/7/1996',13.97,'Wellington Importadora','Resende','Sul','Brazil');

INSERT INTO Envio (Cod_Envio,DataEnvio,Frete,NomeNavio,Cidade,Regiao,Pais)
VALUES (10257,'8/8/1996',81.91,'HILARION-Abastos','San Cristobal','Tachira','Venezuela');

INSERT INTO Envio (Cod_Envio,DataEnvio,Frete,NomeNavio,Cidade,Regiao,Pais)
VALUES (10258,'17/7/1996',140.51,'Ernst Handel','Kirchgasse','Graz','Austria');


select * from Envio;


CREATE TABLE Territorio
(
       Cod_Territorio varchar(20) NOT NULL,
       Territoriodescricao varchar(50) NOT NULL,
       Cod_Regiao int
);



Insert Into Territorio Values ('01581','Westboro',1);
Insert Into Territorio Values ('01730','Bedford',1);
Insert Into Territorio Values ('01833','Georgetow',1);
Insert Into Territorio Values ('02116','Boston',1);
Insert Into Territorio Values ('02139','Cambridge',1);
Insert Into Territorio Values ('02184','Braintree',1);
Insert Into Territorio Values ('02903','Providence',1);
Insert Into Territorio Values ('03049','Hollis',3);
Insert Into Territorio Values ('03801','Portsmouth',3);
Insert Into Territorio Values ('06897','Wilton',1);
Insert Into Territorio Values ('07960','Morristown',1);
Insert Into Territorio Values ('08837','Edison',1);
Insert Into Territorio Values ('10019','New York',1);
Insert Into Territorio Values ('10038','New York',1);
Insert Into Territorio Values ('11747','Mellvile',1);
Insert Into Territorio Values ('14450','Fairport',1);
Insert Into Territorio Values ('19428','Philadelphia',3);
Insert Into Territorio Values ('19713','Neward',1);
Insert Into Territorio Values ('20852','Rockville',1);
Insert Into Territorio Values ('27403','Greensboro',1);
Insert Into Territorio Values ('27511','Cary',1);
Insert Into Territorio Values ('29202','Columbia',4);
Insert Into Territorio Values ('30346','Atlanta',4);
Insert Into Territorio Values ('31406','Savannah',4);
Insert Into Territorio Values ('32859','Orlando',4);
Insert Into Territorio Values ('33607','Tampa',4);
Insert Into Territorio Values ('40222','Louisville',1);
Insert Into Territorio Values ('44122','Beachwood',3);
Insert Into Territorio Values ('45839','Findlay',3);
Insert Into Territorio Values ('48075','Southfield',3);
Insert Into Territorio Values ('48084','Troy',3);
Insert Into Territorio Values ('48304','Bloomfield Hills',3);
Insert Into Territorio Values ('53404','Racine',3);
Insert Into Territorio Values ('55113','Roseville',3);
Insert Into Territorio Values ('55439','Minneapolis',3);
Insert Into Territorio Values ('60179','Hoffman Estates',2);
Insert Into Territorio Values ('60601','Chicago',2);
Insert Into Territorio Values ('72716','Bentonville',4);
Insert Into Territorio Values ('75234','Dallas',4);
Insert Into Territorio Values ('78759','Austin',4);
Insert Into Territorio Values ('80202','Denver',2);
Insert Into Territorio Values ('80909','Colorado Springs',2);
Insert Into Territorio Values ('85014','Phoenix',2);
Insert Into Territorio Values ('85251','Scottsdale',2);
Insert Into Territorio Values ('90405','Santa Monica',2);
Insert Into Territorio Values ('94025','Menlo Park',2);
Insert Into Territorio Values ('94105','San Francisco',2);
Insert Into Territorio Values ('95008','Campbell',2);
Insert Into Territorio Values ('95054','Santa Clara',2);
Insert Into Territorio Values ('95060','Santa Cruz',2);
Insert Into Territorio Values ('98004','Bellevue',2);
Insert Into Territorio Values ('98052','Redmond',2);
Insert Into Territorio Values ('98104','Seattle',2);

select * from Territorio;


-- exerc�cio 1, atualizar conte�do "Queijo" por "cheeses" (fiz o inverso, pois o conte�do j� era "Queijo".)

update Categoria set Descricao = 'Cheeses' where Descricao like 'Queijo';
select * from Categoria;



-- exerc�cio 2, atualizar conte�do "Confections" por "Confeitos"

update Categoria set Nome_Categoria = 'Confeitos' where Nome_Categoria like 'Confections';
select * from Categoria;


-- exerc�cio 3, atualizar conte�do "Peixes"

update Categoria set Descricao = 'Peixes' where Cod_Categoria = 8;
select * from Territorio;


-- exerc�cio 4, atualizar conte�do "New York" por "Nova Iorque"

update Territorio set Territoriodescricao = 'Nova Iorque' where Territoriodescricao like 'New York';
select * from Territorio;


-- exerc�cio 5, atualizar conte�do de "2" para "22"

update Territorio set Cod_Regiao = 22 where Cod_Regiao = 2;
select * from Territorio;


-- exerc�cio 6, atualizar conte�do para "9" onde � "menor que 3000"

update Territorio set Cod_Regiao = '9' where Cod_Territorio < 3000;
select * from Territorio;


-- exerc�cio 7, atualizar conte�do de "San Francisco" para "S�o Francisco"

update Territorio set Territoriodescricao = 'S�o Francisco' where Territoriodescricao like 'San Francisco';
select * from Territorio;


-- exerc�cio 8, atualizar conte�do de "Lyon" para "Le�o"

update Envio set Cidade = 'Le�o' where Cidade like 'Lyon';
select * from Envio;


-- exerc�cio 9, atualizar conte�do de "Switzerland" para "Su�cia"

update Envio set Pais = 'Su�cia' where Pais like 'Switzerland';
select * from Envio;


-- exerc�cio 10, atualizar Regiao para "Nada" onde Regiao � NULL

update Envio set Regiao = 'Nada' where Regiao is null;
select * from Envio;


-- exerc�cio 11, atualizar conte�do de "Hanari Carnes" para "Canarinho"

update Envio set NomeNavio = 'Canarinho' where NomeNavio like 'Hanari Carnes';
select * from Envio;


-- exerc�cio 12, atualizar conte�do para 200 onde Frete � maior ou igual a 100

update Envio set Frete = 200 where Frete >= 100;
select * from Envio;


-- exerc�cio 13, atualizar conte�do de "Sudeste" para "Norte"

update Envio set Regiao = 'Norte' where Regiao like 'Sudeste';
select * from Envio;





-- exerc�cios adicionais


-- cria��o do banco de dados tematizado do jogo "brawl stars"

create database brawl_stars;


-- entrando no bd

use brawl_stars;


-- cria��o da tabela brawler (termo para personagem no jogo)

create table brawler
(
	Cod_Brawler int,
	Nome varchar(20),
 	Raridade varchar(20),
	poderDEestrela varchar(25),
  	Acessorio varchar(25),
	Hipercarga varchar(30) NULL,
	Trio varchar(25),
	TituloMaestria varchar(25),
	Qntd_Skins int NULL
);


-- inserindo valores aos atributos

insert into brawler values (62, 'Mandy', '�pica', 'Ao Alcance', 'Calda Caramelizada', 'Doces para Todos!', 'Terra dos Doces', 'Rapadura', 8);
insert into brawler values (22, 'Eug�nio', 'Mit�ca', 'Tapa Astral', 'Esp�ritos Vingativos', 'Hiperm�os', 'Viajantes M�sticos', 'Fala com a minha m�o!', 6);
insert into brawler values (23, 'Carl', 'Super-Rara', 'Pirueta Protetora', 'Rastro Flamejante', 'P�-Quente', 'Mineradores de Gemas', 'Abalo Sism�co', 10);
insert into brawler values (68, 'Charlie', 'Mit�ca', 'Digest�o', 'Aranhas', 'Infesta��o', 'Circo Bizarro ', 'A Incr�vel', 5);
insert into brawler values (72, 'Melodie', 'Mit�ca', 'Ritmo Acelerado', 'Gancho', 'Flash Mob', 'Karaoke', 'Indom�vel', 7);
insert into brawler values (71, 'Angelo', '�pica', 'Aura T�xica', 'Voo Aspirante', 'Meu Habitat', 'P�ntano do Amor', 'Sanguessuga', 5);
insert into brawler values (20, 'Penny', 'Super-Rara', 'Bolsos Cheios', 'Barril de Sal', 'Supercanh�o', 'Piratas', 'Apelou, perdeu!', 8);
insert into brawler values (24, 'Rosa', 'Rara', 'Vida Vegetal', 'Urtiga', 'Ra�zes Firmes', 'C�pula Biol�gica', 'Tomando um ar', 8);
insert into brawler values (91, 'Kaze', 'Ultra-Lend�ria', 'Cegueira Total', 'Troca-Ninja', NULL, 'Corte Fatal', 'Sombra Silenciosa', 2);
insert into brawler values (4, 'Spike', 'Lend�ria', 'Bola Curva', 'Cacto Pacato', 'Floresc�ncia', 'Velho-oeste', 'Sem igual', 11);

select * from brawler;


-- exerc�cio 14, atualizar t�tulo "Rapadura" para "Rainha dos Doces"

update brawler set TituloMaestria = 'Rainha do Doce' where Nome like 'Mandy';
select * from brawler;


-- exerc�cio 15, aumentar em 1 a quantidade de skins em brawlers de raridade "�pica"

update brawler set Qntd_Skins = Qntd_Skins + 1 where Raridade like '�pica';
select * from brawler;


-- exerc�cio 16, atualizar valores "NULL" para �N�o possui� no campo "Hipercarga"

update brawler set Hipercarga = 'N�o possui' where Hipercarga is null;
select * from brawler;


-- exerc�cio 17, atualizar conte�do "Piratas" para "Marujos"

update brawler set Trio = 'Marujos' where Trio like 'Piratas';
select * from brawler;


-- exerc�cio 18, atualizar quantidade de skins em brawlers que h� "menos que 6" para "6"

update brawler set Qntd_Skins = 6 where Qntd_Skins < 6;
select * from brawler;


-- exerc�cio 19, atualizar "Hipercarga" para "Explos�o Espinhosa", filtrando pelo "Nome" sendo "Spike"

update brawler set Hipercarga = 'Explos�o Espinhosa' where Nome like 'Spike';
select * from brawler;
