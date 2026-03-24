create database clinica_db
use clinica_db


CREATE TABLE clinica(
  cod_clinica int identity primary key NOT NULL,
  cep varchar(20),
  nome varchar(100)
)

CREATE TABLE medico(
  cod_medico int identity primary key NOT NULL,
  nome varchar(100),
  crm varchar(50) UNIQUE,
  data_nasc date,
  cod_clinica int,
  foreign key (cod_clinica) references clinica(cod_clinica)
)

CREATE TABLE especializacao (
  cod_espe int primary key NOT NULL,
  nome varchar(100),
  descricao text
)

CREATE TABLE tipo_end (
  cod_tipo int primary key NOT NULL,
  descricao varchar(100)
)

CREATE TABLE paciente (
  cod_paciente int identity primary key NOT NULL,
  nome varchar(100),
  data_nasc date,
  rg varchar(20) UNIQUE,
  email varchar(100) UNIQUE,
  senha varchar(255)
)

CREATE TABLE endereco(
  cod_end int identity primary key NOT NULL,
  cod_paciente int,
  bairro varchar(100),
  rua varchar(150),
  numero varchar(10),
  cod_tipo int
  foreign key (cod_paciente) references paciente(cod_paciente),
  foreign key (cod_tipo) references tipo_end(cod_tipo)
)

CREATE TABLE agenda (
  cod_agenda int identity Primary Key NOT NULL,
  cod_medico int,
  foreign key (cod_medico) references medico(cod_medico),
)

CREATE TABLE consulta (
  cod_consulta int identity primary key NOT NULL,
  cod_paciente int,
  cod_agenda int,
  descricao text,
  statusC varchar(50),
  horario datetime
  foreign key (cod_paciente) references paciente(cod_paciente),
  foreign key (cod_agenda) references agenda(cod_agenda)
)

CREATE TABLE tipo_exame (
  cod_tipo int primary key NOT NULL,
  descricao varchar(100)
)

CREATE TABLE exame (
  cod_exame int identity primary key NOT NULL,
  cod_consulta int,
  cod_tipo int,
  diagnostico text,
  statusE varchar(50),
  horario datetime
  foreign key (cod_consulta) references consulta(cod_consulta),
  foreign key (cod_tipo) references tipo_exame(cod_tipo)
)

CREATE TABLE esp_medico (
  cod_medico int NOT NULL,
  cod_espe int NOT NULL
  foreign key (cod_medico) references medico(cod_medico),
  foreign key (cod_espe) references especializacao(cod_espe)
)