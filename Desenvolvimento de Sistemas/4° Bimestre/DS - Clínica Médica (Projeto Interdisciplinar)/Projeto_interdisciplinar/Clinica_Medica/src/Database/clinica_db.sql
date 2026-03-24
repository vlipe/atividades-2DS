-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 16/10/2025 às 17:09
-- Versão do servidor: 10.4.32-MariaDB
-- Versão do PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `clinica_db`
--

create database `clinica_db`;
use `clinica_db`;

-- --------------------------------------------------------

--
-- Estrutura para tabela `agenda`
--

CREATE TABLE `agenda` (
  `cod_agenda` int(11) NOT NULL,
  `cod_medico` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `clinica`
--

CREATE TABLE `clinica` (
  `cod_clinica` int(11) NOT NULL,
  `cep` varchar(20) DEFAULT NULL,
  `nome` varchar(100) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `consulta`
--

CREATE TABLE `consulta` (
  `cod_consulta` int(11) NOT NULL,
  `cod_paciente` int(11) DEFAULT NULL,
  `cod_agenda` int(11) DEFAULT NULL,
  `descricao` text DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `horario` datetime DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `endereco`
--

CREATE TABLE `endereco` (
  `cod_end` int(11) NOT NULL,
  `bairro` varchar(100) DEFAULT NULL,
  `rua` varchar(150) DEFAULT NULL,
  `numero` varchar(10) DEFAULT NULL,
  `cod_tipo` int(11) DEFAULT NULL,
  `cod_paciente` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `especializacao`
--

CREATE TABLE `especializacao` (
  `cod_espe` int(11) NOT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `descricao` text DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `especializacao`
--

INSERT INTO `especializacao` (`cod_espe`, `nome`, `descricao`) VALUES
(1, 'Cardiologista', NULL),
(2, 'Pediatra', NULL),
(3, 'Ortopedista', NULL),
(4, 'Dermatologista', NULL),
(5, 'Ginecologista', NULL),
(6, 'Oftalmologista', NULL),
(7, 'Clínico Geral', NULL);

-- --------------------------------------------------------

--
-- Estrutura para tabela `esp_medico`
--

CREATE TABLE `esp_medico` (
  `cod_medico` int(11) NOT NULL,
  `cod_espe` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `exame`
--

CREATE TABLE `exame` (
  `cod_exame` int(11) NOT NULL,
  `cod_consulta` int(11) DEFAULT NULL,
  `cod_tipo` int(11) DEFAULT NULL,
  `diagnostico` text DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `horario` datetime DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `medico`
--

CREATE TABLE `medico` (
  `cod_medico` int(11) NOT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `crm` varchar(50) DEFAULT NULL,
  `data_nasc` date DEFAULT NULL,
  `cod_clinica` int(11) DEFAULT NULL,
  `email` varchar(100) NOT NULL,
  `senha` varchar(100) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `medico`
--

INSERT INTO `medico` (`cod_medico`, `nome`, `crm`, `data_nasc`, `cod_clinica`, `email`, `senha`) VALUES
(1, 'Marcos', '123456/SP', '1999-10-02', NULL, 'marcos@gmail.com', '1234');

-- --------------------------------------------------------

--
-- Estrutura para tabela `paciente`
--

CREATE TABLE `paciente` (
  `cod_paciente` int(11) NOT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `data_nasc` date DEFAULT NULL,
  `rg` varchar(14) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `paciente`
--

INSERT INTO `paciente` (`cod_paciente`, `nome`, `data_nasc`, `rg`, `email`, `senha`) VALUES
(5, 'Antonio', '2009-03-24', '472.757.168-44', 'antonio@gmail.com', '1234');

-- --------------------------------------------------------

--
-- Estrutura para tabela `tipo_end`
--

CREATE TABLE `tipo_end` (
  `cod_tipo` int(11) NOT NULL,
  `descricao` varchar(100) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `tipo_exame`
--

CREATE TABLE `tipo_exame` (
  `cod_tipo` int(11) NOT NULL,
  `descricao` varchar(100) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `agenda`
--
ALTER TABLE `agenda`
  ADD PRIMARY KEY (`cod_agenda`),
  ADD KEY `cod_medico` (`cod_medico`);

--
-- Índices de tabela `clinica`
--
ALTER TABLE `clinica`
  ADD PRIMARY KEY (`cod_clinica`);

--
-- Índices de tabela `consulta`
--
ALTER TABLE `consulta`
  ADD PRIMARY KEY (`cod_consulta`),
  ADD KEY `cod_paciente` (`cod_paciente`),
  ADD KEY `cod_agenda` (`cod_agenda`) USING BTREE;

--
-- Índices de tabela `endereco`
--
ALTER TABLE `endereco`
  ADD PRIMARY KEY (`cod_end`),
  ADD KEY `cod_tipo` (`cod_tipo`),
  ADD KEY `cod_paciente` (`cod_paciente`);

--
-- Índices de tabela `especializacao`
--
ALTER TABLE `especializacao`
  ADD PRIMARY KEY (`cod_espe`);

--
-- Índices de tabela `esp_medico`
--
ALTER TABLE `esp_medico`
  ADD KEY `cod_espe` (`cod_espe`),
  ADD KEY `cod_medico` (`cod_medico`) USING BTREE;

--
-- Índices de tabela `exame`
--
ALTER TABLE `exame`
  ADD PRIMARY KEY (`cod_exame`),
  ADD KEY `cod_consulta` (`cod_consulta`),
  ADD KEY `cod_tipo` (`cod_tipo`);

--
-- Índices de tabela `medico`
--
ALTER TABLE `medico`
  ADD PRIMARY KEY (`cod_medico`),
  ADD UNIQUE KEY `email` (`email`),
  ADD UNIQUE KEY `crm` (`crm`),
  ADD KEY `cod_clinica` (`cod_clinica`);

--
-- Índices de tabela `paciente`
--
ALTER TABLE `paciente`
  ADD PRIMARY KEY (`cod_paciente`),
  ADD UNIQUE KEY `rg` (`rg`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Índices de tabela `tipo_end`
--
ALTER TABLE `tipo_end`
  ADD PRIMARY KEY (`cod_tipo`);

--
-- Índices de tabela `tipo_exame`
--
ALTER TABLE `tipo_exame`
  ADD PRIMARY KEY (`cod_tipo`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `agenda`
--
ALTER TABLE `agenda`
  MODIFY `cod_agenda` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `clinica`
--
ALTER TABLE `clinica`
  MODIFY `cod_clinica` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `consulta`
--
ALTER TABLE `consulta`
  MODIFY `cod_consulta` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `endereco`
--
ALTER TABLE `endereco`
  MODIFY `cod_end` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `especializacao`
--
ALTER TABLE `especializacao`
  MODIFY `cod_espe` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de tabela `exame`
--
ALTER TABLE `exame`
  MODIFY `cod_exame` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `medico`
--
ALTER TABLE `medico`
  MODIFY `cod_medico` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `paciente`
--
ALTER TABLE `paciente`
  MODIFY `cod_paciente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
