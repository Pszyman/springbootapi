
CREATE TABLE IF NOT EXISTS customer (
  pesel VARCHAR(45) NOT NULL, PRIMARY KEY (pesel),
  firstname VARCHAR(45) NOT NULL,
  surname VARCHAR(45) NOT NULL
);