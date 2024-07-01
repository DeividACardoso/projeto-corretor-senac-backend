-- Criar o banco de dados
DROP DATABASE dbcorretor;
CREATE DATABASE dbcorretor;

-- Usar o banco de dados seguro_auto
USE dbcorretor;

-- Criar tabela CORRETOR
CREATE TABLE CORRETOR (
    ID INT PRIMARY KEY AUTO_INCREMENT UNIQUE,
    NOME VARCHAR(100) NOT NULL,
    CPF VARCHAR(11) NOT NULL,
    TELEFONE VARCHAR(11) NOT NULL,
    EMAIL VARCHAR(100) NOT NULL,
    SENHA VARCHAR(100) NOT NULL,
    ROLE TINYINT
);
-- Criar tabela CLIENTE
CREATE TABLE CLIENTE (
  ID INT PRIMARY KEY AUTO_INCREMENT UNIQUE,
  NOME VARCHAR(100) NOT NULL,
  CPF VARCHAR(11) NOT NULL,
  DT_NASCIMENTO DATE NOT NULL,
  EMAIL VARCHAR(100) NOT NULL,
  CNH VARCHAR(9),
  TELEFONE VARCHAR(11) NOT NULL,
  ESTADO_CIVIL VARCHAR(30) NOT NULL,
  GENERO VARCHAR(30) NOT NULL,
  RUA VARCHAR(100) NOT NULL,
  BAIRRO VARCHAR(100) NOT NULL,
  NUMERO VARCHAR(100) NOT NULL,
  COMPLEMENTO VARCHAR(100),
  CIDADE VARCHAR(100) NOT NULL,
  UF VARCHAR(2) NOT NULL,
  CEP VARCHAR(8) NOT NULL
);

-- Criar tabela VEICULO
CREATE TABLE VEICULO (
  ID INT PRIMARY KEY AUTO_INCREMENT UNIQUE,
  MODELO VARCHAR(45) NOT NULL,
  MARCA VARCHAR(45) NOT NULL,
  PRECO VARCHAR(25) NOT NULL,
  ANO_MODELO YEAR NOT NULL,
  TIPO_COMBUSTIVEL VARCHAR(45) NOT NULL,
  RUA VARCHAR(100) NOT NULL,
  BAIRRO VARCHAR(100) NOT NULL,
  NUMERO VARCHAR(100) NOT NULL,
  COMPLEMENTO VARCHAR(100),
  CIDADE VARCHAR(100) NOT NULL,
  UF VARCHAR(2) NOT NULL,
  CEP VARCHAR(8) NOT NULL,
  CLIENTE_ID INT NOT NULL,
  FOREIGN KEY (CLIENTE_ID) REFERENCES CLIENTE(ID)
);

-- Criar tabela SEGURADORA
CREATE TABLE SEGURADORA (
  ID INT PRIMARY KEY AUTO_INCREMENT UNIQUE,
  NOME VARCHAR(150) NOT NULL,
  CNPJ VARCHAR(14) NOT NULL,
  TELEFONE VARCHAR(11) NOT NULL,
  EMAIL VARCHAR(100) NOT NULL
);

-- Criar tabela SEGURO
CREATE TABLE SEGURO (
  ID INT PRIMARY KEY AUTO_INCREMENT UNIQUE,
  NOME VARCHAR(100) NOT NULL,
  RCF_DANOS_MATERIAIS DOUBLE,
  ROF_DANOS_FISICOS DOUBLE,
  DT_INICIO_VIGENCIA DATE NOT NULL,
  DT_FIM_VIGENCIA DATE NOT NULL,
  NUMERO_PROPOSTA VARCHAR(45) NOT NULL,
  FRANQUIA DOUBLE,
  CARRO_RESERVA TINYINT,
  NUM_APOLICE VARCHAR(100) NOT NULL,
  STATUS BOOLEAN NOT NULL,
  SEGURADORA_ID INT NOT NULL,
  VEICULO_ID INT NOT NULL,
  CLIENTE_ID INT NOT NULL,
  FOREIGN KEY (CLIENTE_ID) REFERENCES CLIENTE(ID),
  FOREIGN KEY (VEICULO_ID) REFERENCES VEICULO(ID),
  FOREIGN KEY (SEGURADORA_ID) REFERENCES SEGURADORA(ID)
);

-- Criar tabela SINISTRO
CREATE TABLE SINISTRO (
  ID INT PRIMARY KEY AUTO_INCREMENT ,
  TIPO VARCHAR(100) NOT NULL,
  DT_HORA DATETIME NOT NULL,
  DESCRICAO VARCHAR(300) NOT NULL,
  SEGURO_ID INT NOT NULL,
  FOREIGN KEY (SEGURO_ID) REFERENCES SEGURO(ID)
);
