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
-- Banco de dados: `bd_perfumaria`
--
CREATE DATABASE IF NOT EXISTS `bd_perfumaria` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `bd_perfumaria`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `clientes`
--

CREATE TABLE `clientes` (
  `id_cliente` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `telefone` varchar(15) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `clientes`
--

INSERT INTO `clientes` (`id_cliente`, `nome`, `email`, `telefone`) VALUES
(1, 'Antonio B.', 'antoniobernardino@gmail.com', '119965445312'),
(2, 'Pedro Silva', 'pedraosilva@gmail.com', '11987654321'),
(3, 'Arthur Gutemberg', 'gutembergarthur@gmail.com', '1192394385'),
(4, 'Ediney Barreto', 'profediney@gmail.com', '11987655475'),
(5, 'Paulo Curriel', 'paulofisica@gmail.com', '1198798732');

-- --------------------------------------------------------

--
-- Estrutura da tabela `perfumes`
--

CREATE TABLE `perfumes` (
  `id_produto` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `marca` varchar(50) NOT NULL,
  `preco` decimal(10,2) NOT NULL,
  `estoque` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `perfumes`
--

INSERT INTO `perfumes` (`id_produto`, `nome`, `marca`, `preco`, `estoque`) VALUES
(1, 'Egeo Blue', 'O Boticário', '110.00', 35),
(2, 'Egeo Bomb Black', 'O Boticário', '110.00', 26),
(3, 'Uomini', 'O Boticário', '160.00', 98),
(4, 'Kaiak', 'Natura', '130.00', 150),
(5, 'Lily Eau de Parfum', 'O Boticário', '250.00', 48),
(6, 'Floratta Gold', 'O Boticário', '146.00', 34),
(7, 'Coffee Man ', 'O Boticário', '160.00', 89);

-- --------------------------------------------------------

--
-- Estrutura da tabela `vendas`
--

CREATE TABLE `vendas` (
  `id_venda` int(11) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `id_produto` int(11) NOT NULL,
  `quantidade` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `vendas`
--

INSERT INTO `vendas` (`id_venda`, `id_cliente`, `id_produto`, `quantidade`) VALUES
(1, 1, 2, 2),
(2, 2, 5, 1),
(3, 3, 1, 3),
(4, 4, 7, 5),
(5, 5, 5, 2);

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id_cliente`);

--
-- Índices para tabela `perfumes`
--
ALTER TABLE `perfumes`
  ADD PRIMARY KEY (`id_produto`);

--
-- Índices para tabela `vendas`
--
ALTER TABLE `vendas`
  ADD PRIMARY KEY (`id_venda`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `clientes`
--
ALTER TABLE `clientes`
  MODIFY `id_cliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de tabela `perfumes`
--
ALTER TABLE `perfumes`
  MODIFY `id_produto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de tabela `vendas`
--
ALTER TABLE `vendas`
  MODIFY `id_venda` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
