USE dbcorretor;
 
-- Inserir dados na tabela CORRETOR
INSERT INTO CORRETOR (NOME, CPF, TELEFONE, EMAIL, SENHA)
VALUES ('João Silva', '11987654321', 'joao@email.com', 'senha123');

-- Inserir dados na tabela CLIENTE
INSERT INTO CLIENTE (NOME, CPF, DT_NASCIMENTO, EMAIL, CNH, TELEFONE, ESTADO_CIVIL, GENERO, RUA, BAIRRO, NUMERO, COMPLEMENTO, CIDADE, UF, CEP)
VALUES ('Maria Oliveira', '98765432198', '1990-05-15', 'maria@email.com', '123456789', '11987654321', 'Solteiro(a)', 'Feminino', 'Rua A', 'Centro', '100', '', 'São Paulo', 'SP', '12345678');
 
-- Inserir dados na tabela VEICULO
INSERT INTO VEICULO (MODELO, MARCA, PRECO, ANO_MODELO, TIPO_COMBUSTIVEL, RUA, BAIRRO, NUMERO, COMPLEMENTO, CIDADE, UF, CEP, CLIENTE_ID)
VALUES ('Gol', 'Volkswagen', '40000.00', '2020', 'Flex', 'Rua B', 'Centro', '200', '', 'São Paulo', 'SP', '12345678', 1);
 
-- Inserir dados na tabela SEGURADORA
INSERT INTO SEGURADORA (NOME, CNPJ, TELEFONE, EMAIL)
VALUES ('Seguradora XYZ', '12345678901234', '11987654321', 'seguradora@email.com');

-- Inserir dados na tabela SINISTRO
INSERT INTO SINISTRO (TIPO, DT_HORA, DESCRICAO)
VALUES ('Colisão', '2024-03-20 12:30:00', 'Colisão frontal com outro veículo.');
 
-- Inserir dados na tabela SEGURO
INSERT INTO SEGURO (NOME, RCF_DANOS_MATERIAIS, ROF_DANOS_FISICOS, DT_INICIO_VIGENCIA, DT_FIM_VIGENCIA, NUMERO_PROPOSTA, FRANQUIA, CARRO_RESERVA, NUM_APOLICE, STATUS, SINISTRO_ID, SEGURADORA_ID, VEICULO_ID,  CLIENTE_ID)
VALUES ('Seguro Auto', 10000.00, 5000.00, '2024-04-15', '2025-04-15', 'PROPOSTA123', 1000.00, 1, 'APOLICE123', 1,  1, 1, 1, 1);
 
SELECT * FROM SINISTRO;
SELECT * FROM SEGURO;
SELECT * FROM CORRETOR;
SELECT * FROM SEGURADORA;
