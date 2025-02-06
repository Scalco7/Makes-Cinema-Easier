CREATE database projetocinema;

use projetoCinema;

CREATE TABLE sala (
  Id int(11) NOT NULL AUTO_INCREMENT,
  Nome varchar(60) NOT NULL,
  Largura int(100) NOT NULL,
  Profundidade int(100) NOT NULL,
  PRIMARY KEY (Id)
);

CREATE TABLE filme (
  Id int(11) NOT NULL AUTO_INCREMENT,
  Nome varchar(60) NOT NULL,
  Descricao varchar(500) NOT NULL,
  Classificacao varchar(2) NOT NULL,
  MinutosTotais int(3) NOT NULL,
  Imagem LONGTEXT,
  PRIMARY KEY (Id)
);

CREATE TABLE sessao (
  Id int(11) NOT NULL AUTO_INCREMENT,
  Cam varchar(30) NOT NULL,
  HorarioDaSessao date NOT NULL,
  FilmeId int(11) NOT NULL,
  SalaId int(11) NOT NULL,
  PRIMARY KEY (Id),
  FOREIGN KEY (FilmeId) REFERENCES filme (Id),
  FOREIGN KEY (SalaId) REFERENCES sala (Id)
);

CREATE TABLE usuario (
  Cpf varchar(11) NOT NULL,
  Nome varchar(60) NOT NULL,
  Email varchar(250) NOT NULL,
  Senha varchar(250) NOT NULL,
  Telefone varchar(20) NOT NULL,
  PRIMARY KEY (Cpf)
);

CREATE TABLE ingresso (
  Id int(11) NOT NULL AUTO_INCREMENT,
  Preco float(5) NOT NULL,
  Assento varchar(3) NOT NULL,
  NomeCliente varchar(100) NOT NULL,
  SessaoId int(11) NOT NULL,
  PRIMARY KEY (Id),
  FOREIGN KEY (SessaoId) REFERENCES sessao (Id)
);