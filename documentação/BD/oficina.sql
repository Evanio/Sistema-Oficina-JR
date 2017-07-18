-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 16-Jul-2017 às 22:42
-- Versão do servidor: 10.1.9-MariaDB
-- PHP Version: 5.6.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `oficina`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `apaga_cliente` (`id` INTEGER)  begin
	delete from clientes where idpessoa_fk  = id;
	delete from pessoas where idpessoa_pk = id;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `inserir_cliente` (`nomee` VARCHAR(40), `telefonee` VARCHAR(12), `enderecoo` VARCHAR(50), `cpff` VARCHAR(12), `tipoo` VARCHAR(10))  begin	
	declare x integer; 

	insert into pessoas (nome, telefone, endereco) values (nomee, telefonee, enderecoo);
	select max(idpessoa_pk) into x from pessoas;
	insert into clientes (idpessoa_fk, cpf, tipo) values (x, cpff, tipoo);
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `update_cliente` (`nomee` VARCHAR(40), `telefonee` VARCHAR(12), `enderecoo` VARCHAR(50), `cpff` VARCHAR(12), `tipoo` VARCHAR(10), `id` INTEGER)  begin
	update pessoas set nome = nomee, telefone = telefonee, endereco = enderecoo where idpessoa_pk = id;
	update clientes set cpf = cpff, tipo = tipoo where idpessoa_fk = id;

end$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `clientes`
--

CREATE TABLE `clientes` (
  `idpessoa_fk` int(11) NOT NULL,
  `cpf` varchar(15) NOT NULL,
  `tipo` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `fornecedor`
--

CREATE TABLE `fornecedor` (
  `idpessoa_fk` int(11) NOT NULL,
  `cnpj` varchar(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `itemfinanceiro`
--

CREATE TABLE `itemfinanceiro` (
  `iditem_pk` int(11) NOT NULL,
  `valorunitario` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `notafiscal`
--

CREATE TABLE `notafiscal` (
  `idtran_fk` int(11) NOT NULL,
  `idnota_pk` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `parcelas`
--

CREATE TABLE `parcelas` (
  `idtran_fk` int(11) NOT NULL,
  `quantidade` int(11) DEFAULT NULL,
  `vencimento` date DEFAULT NULL,
  `valor_mensal` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `pecas`
--

CREATE TABLE `pecas` (
  `iditem_fk` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `marca` varchar(30) DEFAULT NULL,
  `valor_compra` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `pessoas`
--

CREATE TABLE `pessoas` (
  `idpessoa_pk` int(11) NOT NULL,
  `nome` varchar(40) DEFAULT NULL,
  `telefone` varchar(12) DEFAULT NULL,
  `endereco` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `servicos`
--

CREATE TABLE `servicos` (
  `iditem_fk` int(11) NOT NULL,
  `descricao` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `transacaofinanceira`
--

CREATE TABLE `transacaofinanceira` (
  `idtran_pk` int(11) NOT NULL,
  `idpessoa_fk` int(11) NOT NULL,
  `tipo` int(11) DEFAULT NULL,
  `data` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tran_item`
--

CREATE TABLE `tran_item` (
  `iditem_fk` int(11) NOT NULL,
  `idtran_fk` int(11) NOT NULL,
  `quantidade` int(11) DEFAULT NULL,
  `valor_total` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE `usuario` (
  `idpessoa_fk` int(11) NOT NULL,
  `login` varchar(15) NOT NULL,
  `senha` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `veiculo`
--

CREATE TABLE `veiculo` (
  `idpessoa_fk` int(11) NOT NULL,
  `placa` char(9) NOT NULL,
  `marca` varchar(20) DEFAULT NULL,
  `ano` int(11) DEFAULT NULL,
  `modelo` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `veiculo_item`
--

CREATE TABLE `veiculo_item` (
  `idveiculo_fk` varchar(9) NOT NULL,
  `iditem_fk` int(11) NOT NULL,
  `quantidade` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`idpessoa_fk`,`cpf`);

--
-- Indexes for table `fornecedor`
--
ALTER TABLE `fornecedor`
  ADD PRIMARY KEY (`idpessoa_fk`,`cnpj`);

--
-- Indexes for table `itemfinanceiro`
--
ALTER TABLE `itemfinanceiro`
  ADD PRIMARY KEY (`iditem_pk`);

--
-- Indexes for table `notafiscal`
--
ALTER TABLE `notafiscal`
  ADD PRIMARY KEY (`idtran_fk`,`idnota_pk`);

--
-- Indexes for table `parcelas`
--
ALTER TABLE `parcelas`
  ADD PRIMARY KEY (`idtran_fk`);

--
-- Indexes for table `pecas`
--
ALTER TABLE `pecas`
  ADD PRIMARY KEY (`iditem_fk`,`nome`);

--
-- Indexes for table `pessoas`
--
ALTER TABLE `pessoas`
  ADD PRIMARY KEY (`idpessoa_pk`);

--
-- Indexes for table `servicos`
--
ALTER TABLE `servicos`
  ADD PRIMARY KEY (`iditem_fk`,`descricao`);

--
-- Indexes for table `transacaofinanceira`
--
ALTER TABLE `transacaofinanceira`
  ADD PRIMARY KEY (`idtran_pk`,`idpessoa_fk`),
  ADD KEY `idpessoa_fk` (`idpessoa_fk`);

--
-- Indexes for table `tran_item`
--
ALTER TABLE `tran_item`
  ADD PRIMARY KEY (`iditem_fk`,`idtran_fk`),
  ADD KEY `idtran_fk` (`idtran_fk`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idpessoa_fk`,`login`,`senha`);

--
-- Indexes for table `veiculo`
--
ALTER TABLE `veiculo`
  ADD PRIMARY KEY (`idpessoa_fk`,`placa`);

--
-- Indexes for table `veiculo_item`
--
ALTER TABLE `veiculo_item`
  ADD PRIMARY KEY (`idveiculo_fk`,`iditem_fk`),
  ADD KEY `iditem_fk` (`iditem_fk`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `itemfinanceiro`
--
ALTER TABLE `itemfinanceiro`
  MODIFY `iditem_pk` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `pessoas`
--
ALTER TABLE `pessoas`
  MODIFY `idpessoa_pk` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `transacaofinanceira`
--
ALTER TABLE `transacaofinanceira`
  MODIFY `idtran_pk` int(11) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `clientes`
--
ALTER TABLE `clientes`
  ADD CONSTRAINT `clientes_ibfk_1` FOREIGN KEY (`idpessoa_fk`) REFERENCES `pessoas` (`idpessoa_pk`);

--
-- Limitadores para a tabela `fornecedor`
--
ALTER TABLE `fornecedor`
  ADD CONSTRAINT `fornecedor_ibfk_1` FOREIGN KEY (`idpessoa_fk`) REFERENCES `pessoas` (`idpessoa_pk`);

--
-- Limitadores para a tabela `notafiscal`
--
ALTER TABLE `notafiscal`
  ADD CONSTRAINT `notafiscal_ibfk_1` FOREIGN KEY (`idtran_fk`) REFERENCES `transacaofinanceira` (`idtran_pk`);

--
-- Limitadores para a tabela `parcelas`
--
ALTER TABLE `parcelas`
  ADD CONSTRAINT `parcelas_ibfk_1` FOREIGN KEY (`idtran_fk`) REFERENCES `transacaofinanceira` (`idtran_pk`);

--
-- Limitadores para a tabela `pecas`
--
ALTER TABLE `pecas`
  ADD CONSTRAINT `pecas_ibfk_1` FOREIGN KEY (`iditem_fk`) REFERENCES `itemfinanceiro` (`iditem_pk`);

--
-- Limitadores para a tabela `servicos`
--
ALTER TABLE `servicos`
  ADD CONSTRAINT `servicos_ibfk_1` FOREIGN KEY (`iditem_fk`) REFERENCES `itemfinanceiro` (`iditem_pk`);

--
-- Limitadores para a tabela `transacaofinanceira`
--
ALTER TABLE `transacaofinanceira`
  ADD CONSTRAINT `transacaofinanceira_ibfk_1` FOREIGN KEY (`idpessoa_fk`) REFERENCES `pessoas` (`idpessoa_pk`);

--
-- Limitadores para a tabela `tran_item`
--
ALTER TABLE `tran_item`
  ADD CONSTRAINT `tran_item_ibfk_1` FOREIGN KEY (`iditem_fk`) REFERENCES `itemfinanceiro` (`iditem_pk`),
  ADD CONSTRAINT `tran_item_ibfk_2` FOREIGN KEY (`idtran_fk`) REFERENCES `transacaofinanceira` (`idtran_pk`);

--
-- Limitadores para a tabela `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`idpessoa_fk`) REFERENCES `pessoas` (`idpessoa_pk`);

--
-- Limitadores para a tabela `veiculo`
--
ALTER TABLE `veiculo`
  ADD CONSTRAINT `veiculo_ibfk_1` FOREIGN KEY (`idpessoa_fk`) REFERENCES `pessoas` (`idpessoa_pk`);

--
-- Limitadores para a tabela `veiculo_item`
--
ALTER TABLE `veiculo_item`
  ADD CONSTRAINT `veiculo_item_ibfk_1` FOREIGN KEY (`iditem_fk`) REFERENCES `itemfinanceiro` (`iditem_pk`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
