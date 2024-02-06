-- liquibase formatted sql

-- changeset version:1 dbms:mysql runAlways:true failOnError:true
CREATE TABLE IF NOT EXISTS bot_template_version (
    bot_template_version_id INT AUTO_INCREMENT,
    bot_template_bot_template_id INT,
    bot_template_version FLOAT,
    PRIMARY KEY (bot_template_version_id)
);
-- rollback DROP TABLE bot_template_version;

-- changeset version:2 dbms:mysql runAlways:false failOnError:false
INSERT INTO bot_template_version (bot_template_bot_template_id, bot_template_version) VALUES (1, 0.1);
