-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 09-Abr-2025 às 19:04
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
-- Banco de dados: `bd_empresa`
--
CREATE DATABASE IF NOT EXISTS `bd_empresa` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `bd_empresa`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `clientes`
--

CREATE TABLE `clientes` (
  `Cod_Cliente` int(11) NOT NULL,
  `Nome` varchar(50) NOT NULL,
  `CPF` varchar(14) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Telefone` varchar(20) NOT NULL,
  `Endereco` varchar(80) NOT NULL,
  `Cidade` varchar(40) NOT NULL,
  `UF` char(2) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `clientes`
--

INSERT INTO `clientes` (`Cod_Cliente`, `Nome`, `CPF`, `Email`, `Telefone`, `Endereco`, `Cidade`, `UF`) VALUES
(1, 'João da Silva', '123.456.789-00', 'joao@email.com', '(11)91234-5678', 'Rua das Flores, 123', 'São Paulo', 'SP'),
(2, 'Maria Oliveira', '987.654.321-00', 'maria@email.com', '(21)99876-5432', 'Av. Brasil, 456', 'Rio de Janeiro', 'RJ'),
(3, 'Carlos Pereira', '321.654.987-00', 'carlos@email.com', '(31)98765-4321', 'Rua Minas, 789', 'Belo Horizonte', 'MG'),
(4, 'Ana Costa', '456.123.789-00', 'ana@email.com', '(41)93456-7890', 'Rua Paraná, 101', 'Curitiba', 'PR'),
(5, 'Fernanda Souza', '789.123.456-00', 'fernanda@email.com', '(51)97654-3210', 'Av. Ipiranga, 202', 'Porto Alegre', 'RS');

-- --------------------------------------------------------

--
-- Estrutura da tabela `fornecedores`
--

CREATE TABLE `fornecedores` (
  `Cod_Fornecedor` int(11) NOT NULL,
  `Razao_Social` varchar(70) NOT NULL,
  `Nome_Fantasia` varchar(70) NOT NULL,
  `CNPJ` varchar(20) NOT NULL,
  `Endereco` varchar(50) NOT NULL,
  `Num` varchar(7) NOT NULL,
  `Bairro` varchar(25) NOT NULL,
  `Cidade` varchar(25) NOT NULL,
  `Fone` varchar(18) NOT NULL,
  `Nome_Contato` varchar(20) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Site` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `fornecedores`
--

INSERT INTO `fornecedores` (`Cod_Fornecedor`, `Razao_Social`, `Nome_Fantasia`, `CNPJ`, `Endereco`, `Num`, `Bairro`, `Cidade`, `Fone`, `Nome_Contato`, `Email`, `Site`) VALUES
(1, 'Sueco LTDA.', 'Sueco Tinturaria', ' 12.345.678/0001-99', 'Av. Rodrigues Vivêncio', '87', 'Ponte das Cruzes', 'São Paulo', '(11) 2228-9643', 'Sra. Edna', 'suecotextil@gmail.com', 'suecotextil.com.br'),
(2, 'Alfa Distribuidora LTDA.', 'Alfa Bebidas', '23.456.789/0001-11', 'R. das Acácias', '121', 'Centro', 'Campinas', '(19) 3022-9988', 'Sr. Roberto', 'comercial@alfabebidas.com', 'alfabebidas.com.br'),
(3, 'Solar Engenharia ME', 'SolarTech', '34.567.890/0001-22', 'Av. Paulista', '450', 'Bela Vista', 'São Paulo', '(11) 3555-1122', 'Sra. Lúcia', 'contato@solartech.com', 'solartech.com.br'),
(4, 'NutriVida Suplementos Ltda.', 'NutriVida', '45.678.901/0001-33', 'R. Saúde', '80', 'Saúde', 'São Paulo', '(11) 2222-5544', 'Sr. Eduardo', 'suporte@nutrivida.com', 'nutrivida.com.br'),
(5, 'Verde Limpo Produtos ME', 'Verde Limpo', '56.789.012/0001-44', 'Av. Amazonas', '102', 'Jardim Brasil', 'Guarulhos', '(11) 2999-3322', 'Sra. Helena', 'atendimento@verdelimpo.com', 'verdelimpo.com.br'),
(6, 'TecnoPrint Gráfica LTDA.', 'TecnoPrint', '67.890.123/0001-55', 'R. do Livro', '67', 'Vila Mariana', 'São Paulo', '(11) 3888-4455', 'Sr. Marcos', 'marcosp@tecnoprint.com', 'tecnoprint.com.br'),
(7, 'GlobalTech Soluções Digitais', 'GlobalTech', '78.901.234/0001-66', 'R. Tecnologia', '89', 'Centro', 'São Caetano', '(11) 4433-6677', 'Sra. Beatriz', 'suporte@globaltech.com', 'globaltech.com.br'),
(8, 'MundoPet Comércio Animal', 'MundoPet', '89.012.345/0001-77', 'R. dos Bichos', '33', 'Jardim América', 'Osasco', '(11) 3688-2255', 'Sr. Henrique', 'contato@mundopet.com.br', 'mundopet.com.br'),
(9, 'Delícias da Serra ME', 'Serra Alimentos', '90.123.456/0001-88', 'Av. da Colina', '200', 'Serra Azul', 'Bragança Pta', '(11) 3455-0001', 'Sra. Cláudia', 'vendas@serraalimentos.com', 'serraalimentos.com.br'),
(10, 'Viva Moda LTDA.', 'Viva Look', '12.210.210/0001-99', 'R. Fashion', '17', 'Bom Retiro', 'São Paulo', '(11) 3344-7788	', 'Sr. Paulo', 'estiloviva@vivalooks.com', 'vivalooks.com.br');

-- --------------------------------------------------------

--
-- Estrutura da tabela `produtos`
--

CREATE TABLE `produtos` (
  `Cod_Produto` int(11) NOT NULL,
  `Descricao` varchar(50) NOT NULL,
  `Unidade` varchar(2) NOT NULL,
  `Qtde_Estoque` double NOT NULL,
  `Caracteristicas` varchar(50) NOT NULL,
  `Cod_Fornecedor` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `produtos`
--

INSERT INTO `produtos` (`Cod_Produto`, `Descricao`, `Unidade`, `Qtde_Estoque`, `Caracteristicas`, `Cod_Fornecedor`) VALUES
(1, 'Controle DualForce X', 'un', 120, 'Sem fio, vibração, LED RGB', 6),
(2, 'Headset Gamer Storm Z300', 'un', 75, 'Surround 7.1, micro destacável', 7),
(3, 'Teclado Mecânico Titan RGB', 'un', 50, 'Switch azul, anti-ghosting', 13),
(4, 'Mouse Óptico Venom V2', 'un', 110, '7200 DPI, RGB, 6 botões', 13),
(5, 'Placa de Vídeo GTX 1660 Super', 'un', 22, '6GB GDDR6, NVIDIA', 3),
(6, 'Monitor 24\" UltraFast 144Hz', 'un', 40, '1ms, Full HD, HDMI/DP', 2),
(7, 'SSD NVMe 1TB FlashStorm', 'un', 85, 'Leitura 3500MB/s, M.2 PCIe', 14),
(8, 'Cadeira Gamer Black Knight', 'un', 18, 'Reclinável, apoio lombar', 10),
(9, 'Webcam Full HD Focus Pro', 'un', 65, '1080p, foco automático', 6),
(10, 'Controle Arcade RetroBox', 'un', 30, '8 botões, entrada USB', 8),
(11, 'Hub USB 4 portas FastCharge', 'un', 95, 'USB 3.0, alimentação externa', 7),
(12, 'Roteador Gamer 5GHz Falcon', 'un', 28, 'Dual band, 4 antenas', 3),
(13, 'Fonte 600W PowerX Modular', 'un', 34, 'PFC Ativo, 80 Plus Bronze', 4),
(14, 'Controle Nintendo Switch Pro', 'un', 60, 'Bluetooth, vibração HD', 16),
(15, 'Óculos VR Immersive 360', 'un', 12, 'Compatível com PC e PS5', 5);

-- --------------------------------------------------------

--
-- Estrutura da tabela `vendas`
--

CREATE TABLE `vendas` (
  `Cod_Venda` int(11) NOT NULL,
  `Data_Venda` date NOT NULL,
  `Cod_Cliente` int(11) NOT NULL,
  `Valor_Total` float(10,2) NOT NULL,
  `Forma_Pagamento` varchar(20) NOT NULL COMMENT 'cartão, dinheiro etc'
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `vendas`
--

INSERT INTO `vendas` (`Cod_Venda`, `Data_Venda`, `Cod_Cliente`, `Valor_Total`, `Forma_Pagamento`) VALUES
(1, '2005-04-01', 1, 199.99, 'Cartão de Crédito'),
(2, '2025-04-02', 2, 349.50, 'Pix'),
(3, '2025-04-03', 3, 120.00, 'Dinheiro'),
(4, '2025-04-04', 4, 560.75, 'Cartão de Débito'),
(5, '2025-04-05', 5, 89.90, 'Boleto');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`Cod_Cliente`);

--
-- Índices para tabela `fornecedores`
--
ALTER TABLE `fornecedores`
  ADD PRIMARY KEY (`Cod_Fornecedor`);

--
-- Índices para tabela `produtos`
--
ALTER TABLE `produtos`
  ADD PRIMARY KEY (`Cod_Produto`);

--
-- Índices para tabela `vendas`
--
ALTER TABLE `vendas`
  ADD PRIMARY KEY (`Cod_Venda`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `clientes`
--
ALTER TABLE `clientes`
  MODIFY `Cod_Cliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de tabela `fornecedores`
--
ALTER TABLE `fornecedores`
  MODIFY `Cod_Fornecedor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de tabela `produtos`
--
ALTER TABLE `produtos`
  MODIFY `Cod_Produto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de tabela `vendas`
--
ALTER TABLE `vendas`
  MODIFY `Cod_Venda` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
