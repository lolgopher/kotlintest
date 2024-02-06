-- liquibase formatted sql

-- changeset init:1 dbms:mysql runAlways:true failOnError:true
CREATE TABLE IF NOT EXISTS bot_template (
    id INT AUTO_INCREMENT,
    organization_id INT,
    bot_template_name VARCHAR(64),
    PRIMARY KEY (id)
);
-- rollback DROP TABLE bot_template;

-- changeset init:2 dbms:mysql runAlways:true failOnError:true
CREATE TABLE IF NOT EXISTS organization (
   id INT AUTO_INCREMENT,
   organization_name VARCHAR(64),
   PRIMARY KEY (id)
);
-- rollback DROP TABLE organization;

-- changeset init:3 dbms:mysql runAlways:false failOnError:false
INSERT INTO organization (id, organization_name) VALUES (1, 'DAISO');
INSERT INTO bot_template (id, organization_id, bot_template_name) VALUES (1, 1, 'Franchise Bot');