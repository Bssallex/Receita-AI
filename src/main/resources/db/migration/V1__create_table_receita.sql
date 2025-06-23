CREATE TABLE receita (
  id BIGSERIAL PRIMARY KEY,
  ingredientes VARCHAR(255),
  quantidade VARCHAR(255),
  validade TIMESTAMP
);