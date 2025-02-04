CREATE TABLE sala (
  Id int(11) NOT NULL AUTO_INCREMENT,
  Nome varchar(60) NOT NULL,
  QtdeAssentos int(100) NOT NULL,
  PRIMARY KEY (Id)
);

CREATE TABLE assento (
  Codigo varchar(2) NOT NULL,
  StatusAssento varchar(10) NOT NULL,
  SalaId int(11) NOT NULL,
  PRIMARY KEY (Codigo),
  FOREIGN KEY (SalaId) REFERENCES sala (Id)
);

CREATE TABLE filme (
  Id int(11) NOT NULL AUTO_INCREMENT,
  Nome varchar(60) NOT NULL,
  Descricao varchar(500) NOT NULL,
  Classificacao varchar(2) NOT NULL,
  MinutosTotais int(3) NOT NULL,
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

CREATE TABLE cliente (
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
  SessaoId int(11) NOT NULL,
  ClienteId varchar(11) NOT NULL,
  PRIMARY KEY (Id),
  FOREIGN KEY (SessaoId) REFERENCES sessao (Id),
  FOREIGN KEY (ClienteId) REFERENCES cliente (Cpf)
);
-- Inserindo 5 registros na tabela 'sala'
INSERT INTO sala (Nome, QtdeAssentos) VALUES
('Sala 1', 100),
('Sala 2', 150),
('Sala 3', 120),
('Sala 4', 80),
('Sala 5', 200);

-- Inserindo 5 registros na tabela 'assento'
INSERT INTO assento (Codigo, StatusAssento, SalaId) VALUES
('A1', 'Livre', 1),
('A2', 'Ocupado', 1),
('B1', 'Livre', 2),
('B2', 'Ocupado', 2),
('C1', 'Livre', 3);

-- Inserindo 5 registros na tabela 'filme'
INSERT INTO filme (Nome, Descricao, Classificacao, MinutosTotais) VALUES
('Filme A', 'Ação e aventura', '12', 120),
('Filme B', 'Comédia romântica', '14', 90),
('Filme C', 'Terror psicológico', '16', 110),
('Filme D', 'Documentário histórico', '10', 70),
('Filme E', 'Animação infantil', 'L', 80);

-- Inserindo 5 registros na tabela 'sessao'
INSERT INTO sessao (Cam, HorarioDaSessao, FilmeId, SalaId) VALUES
('Câmera 1', '2025-01-25', 1, 1),
('Câmera 2', '2025-01-26', 2, 2),
('Câmera 3', '2025-01-27', 3, 3),
('Câmera 4', '2025-01-28', 4, 4),
('Câmera 5', '2025-01-29', 5, 5);

-- Inserindo 5 registros na tabela 'cliente'
INSERT INTO cliente (Cpf, Nome, Email, Senha, Telefone) VALUES
('11111111111', 'João Silva', 'joao@gmail.com', 'senha123', '(11) 98765-4321'),
('22222222222', 'Maria Souza', 'maria@gmail.com', 'senha456', '(21) 91234-5678'),
('33333333333', 'Carlos Pereira', 'carlos@gmail.com', 'senha789', '(31) 99876-5432'),
('44444444444', 'Ana Oliveira', 'ana@gmail.com', 'senha321', '(41) 92345-6789'),
('55555555555', 'Fernanda Lima', 'fernanda@gmail.com', 'senha654', '(51) 98765-0987');

-- Inserindo 5 registros na tabela 'ingresso'
INSERT INTO ingresso (Preco, SessaoId, ClienteId) VALUES
(30.50, 1, '11111111111'),
(25.00, 2, '22222222222'),
(40.00, 3, '33333333333'),
(35.00, 4, '44444444444'),
(20.00, 5, '55555555555');

SELECT sessao.HorarioDaSessao, sessao.Cam, sala.Nome as Sala, filme.Nome as Filme
FROM sessao INNER JOIN sala ON sessao.SalaId = sala.Id INNER JOIN filme ON sessao.FilmeId = filme.Id ORDER BY HorarioDaSessao;

SELECT ingresso.Id, ingresso.Preco, sessao.Id as Sessao, cliente.Nome as Cliente FROM ingresso INNER JOIN sessao ON ingresso.SessaoId = sessao.Id INNER 
JOIN cliente ON ingresso.ClienteId = cliente.Cpf WHERE ingresso.Id = 3;

SELECT ingresso.Id AS IngressoId, ingresso.Preco, sessao.Id AS SessaoId, sessao.Cam, sessao.HorarioDaSessao, 
sala.Id AS SalaId, sala.Nome AS SalaNome, sala.QtdeAssentos, filme.Id AS FilmeId, filme.Nome AS FilmeNome,
cliente.Cpf AS ClienteCpf, cliente.Nome AS ClienteNome
FROM ingresso INNER JOIN sessao ON ingresso.SessaoId = sessao.Id 
INNER JOIN sala ON sessao.SalaId = sala.Id 
INNER JOIN filme ON sessao.FilmeId = filme.Id 
INNER JOIN cliente ON ingresso.ClienteId = cliente.Cpf 
ORDER BY ingresso.Id;
