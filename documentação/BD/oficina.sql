-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 06-Ago-2017 às 02:46
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
CREATE DEFINER=`root`@`localhost` PROCEDURE `apagaPeca` (`id` INTEGER)  begin
	delete from peca_tem_fornecedor where peca_fk = id;
	delete from pecas where iditem_fk = id;
	delete from itemfinanceiro where iditem_pk = id;

end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `apagaUsuario` (`id` INTEGER)  begin 
	delete from usuario where idpessoa_fk = id;
	delete from pessoas where idpessoa_pk = id;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `apaga_cliente` (`id` INTEGER)  begin
	delete from clientes where idpessoa_fk  = id;
	delete from pessoas where idpessoa_pk = id;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `apaga_fornecedor` (`id` INTEGER)  begin
	delete from fornecedor where idpessoa_fk  = id;
	delete from pessoas where idpessoa_pk = id;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `inserirPeca` (`nomee` VARCHAR(50), `marcaa` VARCHAR(30), `valor_compraa` FLOAT, `valor_vendaa` FLOAT, `motoo` VARCHAR(50), `quantidade` INTEGER, `fornecedorr` VARCHAR(50))  begin 
declare x integer;
declare y integer;

	if(select fornecedor.idpessoa_fk from fornecedor join pessoas on fornecedor.idpessoa_fk = pessoas.idpessoa_pk where pessoas.nome = fornecedorr > 0) then
		insert into itemfinanceiro(valorunitario) values(valor_vendaa);
		select max(iditem_pk) into x from itemfinanceiro;
		insert into pecas(iditem_fk, nome, marca, valor_compra, moto) values(x, nomee, marcaa, valor_compraa, motoo);
		select fornecedor.idpessoa_fk into y from fornecedor join pessoas on fornecedor.idpessoa_fk = pessoas.idpessoa_pk where pessoas.nome = fornecedorr;	
		insert into peca_tem_fornecedor(fornecedor_fk, peca_fk, qtde) values(y, x, quantidade);	
	else
		rollback;
	end if;

end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `inserirUsuario` (`nomee` VARCHAR(40), `loginn` VARCHAR(15), `senhaa` VARCHAR(20))  begin
	declare x integer;

	insert into pessoas(nome) values (nomee);
	select max(idpessoa_pk) into x from pessoas;
	insert into usuario(idpessoa_fk, login, senha) values (x, loginn, senhaa);
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `inserir_cliente` (`nomee` VARCHAR(40), `telefonee` VARCHAR(12), `enderecoo` VARCHAR(50), `cpff` VARCHAR(12), `tipoo` VARCHAR(10))  begin	
	declare x integer; 

	insert into pessoas (nome, telefone, endereco) values (nomee, telefonee, enderecoo);
	select max(idpessoa_pk) into x from pessoas;
	insert into clientes (idpessoa_fk, cpf, tipo) values (x, cpff, tipoo);
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `inserir_fornecedor` (`nomee` VARCHAR(40), `telefonee` VARCHAR(12), `enderecoo` VARCHAR(50), `cnpjj` VARCHAR(14))  begin
	declare x integer;

	insert into pessoas (nome, telefone, endereco) values (nomee, telefonee, enderecoo);
	select max(idpessoa_pk) into x from pessoas;
	insert into fornecedor(idpessoa_fk, cnpj) values(x, cnpjj);
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `updatePeca` (`nomee` VARCHAR(50), `marcaa` VARCHAR(30), `valor_compraa` FLOAT, `valor_vendaa` FLOAT, `motoo` VARCHAR(50), `qtde` INTEGER, `fornecedorr` VARCHAR(50), `id` INTEGER)  begin
declare x integer;

	update itemfinanceiro set valorunitario = valor_vendaa where iditem_pk = id;
	update pecas set nome = nomee, marca = marcaa, valor_compra = valor_compraa, moto = motoo where iditem_fk = id;	
	select fornecedor.idpessoa_fk into x from fornecedor join pessoas on fornecedor.idpessoa_fk = pessoas.idpessoa_pk where pessoas.nome = fornecedorr;  
	update peca_tem_fornecedor set fornecedor_fk = x where peca_fk = id;
	
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `updateUsuario` (`nomee` VARCHAR(40), `loginn` VARCHAR(15), `senhaa` VARCHAR(20), `id` INTEGER)  begin

	update pessoas set nome = nomee where idpessoa_pk = id;
	update usuario set login = loginn, senha = senhaa where idpessoa_fk = id;	
	
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `update_cliente` (`nomee` VARCHAR(40), `telefonee` VARCHAR(12), `enderecoo` VARCHAR(50), `cpff` VARCHAR(12), `tipoo` VARCHAR(10), `id` INTEGER)  begin
	update pessoas set nome = nomee, telefone = telefonee, endereco = enderecoo where idpessoa_pk = id;
	update clientes set cpf = cpff, tipo = tipoo where idpessoa_fk = id;

end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `update_fornecedor` (`nomee` VARCHAR(40), `telefonee` VARCHAR(12), `enderecoo` VARCHAR(50), `cnpjj` VARCHAR(12), `id` INTEGER)  begin
	update pessoas set nome = nomee, telefone = telefonee, endereco = enderecoo where idpessoa_pk = id;
	update fornecedor set cnpj = cnpjj where idpessoa_fk = id;

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

--
-- Extraindo dados da tabela `clientes`
--

INSERT INTO `clientes` (`idpessoa_fk`, `cpf`, `tipo`) VALUES
(1, '13374077633', 1),
(2, '0000000', 2),
(3, '987654321', 1),
(4, '12345123450', 1),
(6, '39480000', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `fornecedor`
--

CREATE TABLE `fornecedor` (
  `idpessoa_fk` int(11) NOT NULL,
  `cnpj` varchar(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `fornecedor`
--

INSERT INTO `fornecedor` (`idpessoa_fk`, `cnpj`) VALUES
(14, '1111111'),
(42, '1111111'),
(44, '1111111');

-- --------------------------------------------------------

--
-- Estrutura da tabela `itemfinanceiro`
--

CREATE TABLE `itemfinanceiro` (
  `iditem_pk` int(11) NOT NULL,
  `valorunitario` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `itemfinanceiro`
--

INSERT INTO `itemfinanceiro` (`iditem_pk`, `valorunitario`) VALUES
(1, 15),
(2, 9);

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
  `valor_compra` float DEFAULT NULL,
  `moto` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `pecas`
--

INSERT INTO `pecas` (`iditem_fk`, `nome`, `marca`, `valor_compra`, `moto`) VALUES
(1, 'Lona Freio Traseira', 'Fabreck', 152, 'Titan 125adfdaf'),
(2, 'Lampada Farol', 'ladsa', 9, 'Titan 150');

-- --------------------------------------------------------

--
-- Estrutura da tabela `peca_tem_fornecedor`
--

CREATE TABLE `peca_tem_fornecedor` (
  `fornecedor_fk` int(11) NOT NULL,
  `peca_fk` int(11) NOT NULL,
  `qtde` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `peca_tem_fornecedor`
--

INSERT INTO `peca_tem_fornecedor` (`fornecedor_fk`, `peca_fk`, `qtde`) VALUES
(14, 1, 3),
(14, 2, 3);

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

--
-- Extraindo dados da tabela `pessoas`
--

INSERT INTO `pessoas` (`idpessoa_pk`, `nome`, `telefone`, `endereco`) VALUES
(1, 'Rodrigo Marques', '91023746', 'Rua 15'),
(2, 'Maria A', '1111111', 'Avenida A'),
(3, 'Ritaa', '2222', 'Av. 18'),
(4, 'Evanio', '12345678', 'Rua João Alves Ferreira bairro 6 n 190'),
(6, 'Juliana', '9102300', 'Av. x'),
(10, 'Ro', '11', 'Rua'),
(11, 'Ro', '11', 'Rua'),
(12, 'Ro', '11', 'Rua'),
(14, 'Dois Irmaos Moto Peças', '1234', 'Rua x'),
(41, 'Rodrigo', NULL, NULL),
(42, 'Galpão das Motos', '9999999999', 'Rua 10'),
(44, 'Tres Irmaos moto Pecas', '000000000', 'Rua X'),
(45, 'Janio', NULL, NULL);

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

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`idpessoa_fk`, `login`, `senha`) VALUES
(41, 'digoleeke', '12345678'),
(45, 'janiooo', '12345678');

-- --------------------------------------------------------

--
-- Estrutura da tabela `veiculo`
--

CREATE TABLE `veiculo` (
  `id` int(11) NOT NULL,
  `idpessoa_fk` int(11) DEFAULT NULL,
  `placa` varchar(9) NOT NULL,
  `marca` varchar(20) DEFAULT NULL,
  `ano` int(11) DEFAULT NULL,
  `modelo` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `veiculo`
--

INSERT INTO `veiculo` (`id`, `idpessoa_fk`, `placa`, `marca`, `ano`, `modelo`) VALUES
(1, 1, '1111', 'Honda', 2000, 'Titan 125'),
(2, 2, ' 1daf', ' xxadf', 1, 'nasdf'),
(3, 3, '11', '213123', 12321, '12321'),
(4, 2, 'gsx-xxx', 'Honda', 2000, 'Titan 150'),
(5, 3, 'gsx-8888', 'Honda', 2008, 'Titan 125');

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
-- Indexes for table `peca_tem_fornecedor`
--
ALTER TABLE `peca_tem_fornecedor`
  ADD KEY `fornecedor_fk` (`fornecedor_fk`),
  ADD KEY `peca_fk` (`peca_fk`);

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
  ADD PRIMARY KEY (`id`,`placa`),
  ADD KEY `idpessoa_fk` (`idpessoa_fk`);

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
  MODIFY `iditem_pk` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `pessoas`
--
ALTER TABLE `pessoas`
  MODIFY `idpessoa_pk` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=46;
--
-- AUTO_INCREMENT for table `transacaofinanceira`
--
ALTER TABLE `transacaofinanceira`
  MODIFY `idtran_pk` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `veiculo`
--
ALTER TABLE `veiculo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
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
-- Limitadores para a tabela `peca_tem_fornecedor`
--
ALTER TABLE `peca_tem_fornecedor`
  ADD CONSTRAINT `peca_tem_fornecedor_ibfk_1` FOREIGN KEY (`fornecedor_fk`) REFERENCES `fornecedor` (`idpessoa_fk`),
  ADD CONSTRAINT `peca_tem_fornecedor_ibfk_2` FOREIGN KEY (`peca_fk`) REFERENCES `pecas` (`iditem_fk`);

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
  ADD CONSTRAINT `veiculo_ibfk_1` FOREIGN KEY (`idpessoa_fk`) REFERENCES `clientes` (`idpessoa_fk`);

--
-- Limitadores para a tabela `veiculo_item`
--
ALTER TABLE `veiculo_item`
  ADD CONSTRAINT `veiculo_item_ibfk_1` FOREIGN KEY (`iditem_fk`) REFERENCES `itemfinanceiro` (`iditem_pk`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
