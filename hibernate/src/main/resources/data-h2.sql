--DROP TABLE IF EXISTS `COMPANY`;
DROP TABLE IF EXISTS `WORKER`;
--
--CREATE TABLE COMPANY (
--  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
--  name VARCHAR(45) NOT NULL,
--  description VARCHAR(255) NOT NULL,
--  PRIMARY KEY(id)
--) engine=innodb default charset=utf8 collate=utf8_spanish_ci;

CREATE TABLE WORKER (
  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  COMPANY_id INTEGER UNSIGNED NOT NULL,
  name VARCHAR(255) NOT NULL,
  surname VARCHAR(255) NOT NULL,
  workerType VARCHAR(20) NOT NULL,
  PRIMARY KEY(id),
  CONSTRAINT fk_person_company FOREIGN KEY(COMPANY_id) REFERENCES COMPANY(id),
  CONSTRAINT unique_name UNIQUE (name)
) engine=innodb default charset=utf8 collate=utf8_spanish_ci;
--
--CREATE TABLE worker (
--  id BIGINT NOT NULL,
--  worker_type VARCHAR(20) NOT NULL,
--  name VARCHAR(255) NOT NULL,
--  surname VARCHAR(255) NOT NULL,
--  company_id BIGINT NULL,
--  CONSTRAINT pk_worker PRIMARY KEY (id)
--);

ALTER TABLE worker ADD CONSTRAINT FK_WORKER_ON_COMPANY FOREIGN KEY (company_id) REFERENCES company (id);
ALTER TABLE worker ADD CONSTRAINT unique_name UNIQUE (name);
