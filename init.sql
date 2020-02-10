CREATE DATABASE IF NOT EXISTS patterns
    COLLATE utf8_general_ci;
CREATE DATABASE IF NOT EXISTS patterns
    COLLATE utf8_general_ci;

USE patterns;

DROP TABLE IF EXISTS pattern;

CREATE TABLE pattern
(
    id       	BIGINT(20)  NOT NULL AUTO_INCREMENT,
    name     	VARCHAR(50) NULL,
    description VARCHAR(500) NULL,
    typ 		VARCHAR(9)  NULL,
    isMain   	BIT(1)      NULL,
    rating   	DOUBLE      NULL,
    PRIMARY KEY (id)
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8;