-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 17-Abr-2025 às 18:47
-- Versão do servidor: 10.4.22-MariaDB
-- versão do PHP: 8.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `bd_escola`
--
CREATE DATABASE IF NOT EXISTS `bd_escola` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `bd_escola`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `alunos`
--

CREATE TABLE `alunos` (
  `matricula` varchar(5) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `endereco` varchar(50) NOT NULL,
  `cidade` varchar(30) NOT NULL,
  `codcurso` char(2) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `alunos`
--

INSERT INTO `alunos` (`matricula`, `nome`, `endereco`, `cidade`, `codcurso`) VALUES
('001', 'Felipe Vivêncio Rodrigues', 'Rua dos Silvas', 'São Paulo', '10'),
('002', 'João Pedro Souza', 'Rua da Oliveira', 'São Caetano', '10'),
('003', 'Antonio Bernardino', 'Rua Francisco', 'Belo Horizonte', '10'),
('004', 'Rodrigo Silva', 'Rua Ponte Rasa', 'Belém', '10'),
('005', 'Arthur Gutemberg', 'Rua Limoeiro', 'Florianópolis', '20'),
('006', 'Beatriz Galdino', 'Rua dos Santos', 'Fortaleza', '10'),
('007', 'Guilherme Deutsch Andrade', 'Rua Estevão de Carvalho', 'Santos', '20'),
('008', 'Higor Mota', 'Rua das Oliveirinhas', 'Fortaleza', '10'),
('009', 'Igor Sales', 'Rua das Rochas', 'Natal', '20'),
('010', 'João Paiva', 'Rua dos Santanas', 'Rio de Janeiro', '10'),
('011', 'João Victor Xavier', 'Rua Oliveira Viu', 'Ilhabela', '10'),
('012', 'Miguel Heleno', 'Rua Oscar Freire', 'São Paulo', '20'),
('013', 'Edna Pittner', 'Jalapão', 'Manaus', '10'),
('014', 'Bruno Aparecido Vivêncio', 'Rua André Mateus Viu', 'São Paulo', '10'),
('015', 'Giovanna Aparecida Vivêncio', 'Rua André Mateus Viu', 'São Paulo', '20'),
('016', 'Nikolas Maia', 'Rua Augusta', 'Rio de Janeiro', '10'),
('017', 'Jeferson Roberto', 'Rua do Souza', 'Guaianases', '10'),
('018', 'Rogério Bezerra', 'Rua do Japão', 'Maranhão', '20'),
('019', 'Carlos Alberto', 'Beco do Batman', 'São Paulo', '10'),
('020', 'Larrisa Manoela', 'Avenida Paulista', 'São Paulo', '10');

-- --------------------------------------------------------

--
-- Estrutura da tabela `cursos`
--

CREATE TABLE `cursos` (
  `CodCurso` char(2) NOT NULL,
  `Nome` varchar(50) NOT NULL,
  `CodDisc1` char(2) NOT NULL,
  `CodDisc2` char(2) NOT NULL,
  `CodDisc3` char(2) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `cursos`
--

INSERT INTO `cursos` (`CodCurso`, `Nome`, `CodDisc1`, `CodDisc2`, `CodDisc3`) VALUES
('11', 'Design Gráfico', '41', '42', '43'),
('22', 'Ciências de Dados', '51', '52', '53'),
('33', 'Psicologia', '61', '62', '63'),
('44', 'Marketing Digital', '71', '62', '63');

-- --------------------------------------------------------

--
-- Estrutura da tabela `disciplina`
--

CREATE TABLE `disciplina` (
  `CodDisciplina` char(2) NOT NULL,
  `NomeDisciplina` varchar(30) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `disciplina`
--

INSERT INTO `disciplina` (`CodDisciplina`, `NomeDisciplina`) VALUES
('41', 'Programação Web I'),
('42', 'Filosofia'),
('43', 'Fundamentos da Informática'),
('51', 'História'),
('52', 'Biologia'),
('53', 'Matemática'),
('61', 'Língua Inglesa'),
('62', 'Física'),
('63', 'Química'),
('71', 'Design Digital');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `alunos`
--
ALTER TABLE `alunos`
  ADD PRIMARY KEY (`matricula`);

--
-- Índices para tabela `cursos`
--
ALTER TABLE `cursos`
  ADD PRIMARY KEY (`CodCurso`);

--
-- Índices para tabela `disciplina`
--
ALTER TABLE `disciplina`
  ADD PRIMARY KEY (`CodDisciplina`);
--
