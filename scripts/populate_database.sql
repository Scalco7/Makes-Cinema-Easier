use projetocinema;

-- Inserindo salas
INSERT INTO sala (Nome, Largura, Profundidade) VALUES
('Sala IMAX', 7, 9),
('Sala 3D', 7, 7),
('Sala VIP', 3, 9);

-- Inserindo filmes
INSERT INTO filme (Nome, Descricao, Classificacao, MinutosTotais, Imagem) VALUES
('Oppenheimer', 'Filme baseado na história de J. Robert Oppenheimer e o desenvolvimento da bomba atômica.', '16+', 180, 'link_para_imagem_1'),
('Avatar: O Caminho da Água', 'Continuação do épico de ficção científica de James Cameron.', '12+', 192, 'link_para_imagem_2'),
('Duna: Parte Dois', 'Paul Atreides une forças com os Fremen para se vingar dos conspiradores que destruíram sua família.', '14', 165, 'link_para_imagem_4'),
('Velozes & Furiosos 10', 'Dom Toretto e sua equipe enfrentam um novo inimigo que busca vingança.', '12+', 142, 'link_para_imagem_5'),
('Homem-Aranha: Através do Aranhaverso', 'Miles Morales viaja pelo multiverso e encontra diferentes versões do Homem-Aranha.', '10', 140, 'link_para_imagem_6'),
('John Wick 4: Baba Yaga', 'John Wick enfrenta inimigos poderosos em sua busca por liberdade.', '16+', 169, 'link_para_imagem_7'),
('Barbie', 'Barbie embarca em uma jornada pelo mundo real após questionar sua vida perfeita.', 'Livre', 114, 'link_para_imagem_8'),
('Wonka', 'A história de origem do famoso chocolateiro Willy Wonka.', 'Livre', 116, 'link_para_imagem_9'),
('Guardiões da Galáxia Vol. 3', 'O grupo de heróis espaciais enfrenta uma nova ameaça para salvar um de seus membros.', '12+', 150, 'link_para_imagem_10'),
('Super Mario Bros. - O Filme', 'Animação baseada no famoso jogo da Nintendo.', 'Livre', 92, 'link_para_imagem_3');

-- Inserindo sessões
INSERT INTO sessao (Cam, HorarioDaSessao, FilmeId, SalaId) VALUES
('Legendado', '2025-02-10 19:00:00', 1, 1),
('Dublado', '2025-02-10 21:00:00', 2, 2),
('3D', '2025-02-11 16:00:00', 3, 3);

-- Inserindo usuários
INSERT INTO usuario (Cpf, Nome, Email, Senha, Telefone) VALUES
('12345678901', 'Carlos Silva', 'carlos.silva@email.com', 'senha123', '11987654321'),
('98765432100', 'Ana Souza', 'ana.souza@email.com', 'senha456', '21998765432'),
('45612378900', 'Mariana Costa', 'mariana.costa@email.com', 'senha789', '31987654321');

-- Inserindo ingressos
INSERT INTO ingresso (Preco, Assento, NomeCliente, SessaoId) VALUES
(50.00, 'A1', 'Carlos Silva', 1),
(40.00, 'B2', 'Ana Souza', 2),
(60.00, 'C3', 'Mariana Costa', 3);
