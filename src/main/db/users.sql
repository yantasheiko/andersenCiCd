DROP SCHEMA `andersenHibernate`;
CREATE SCHEMA `andersenHibernate` DEFAULT CHARACTER SET utf8;
USE `andersenHibernate`;

CREATE  TABLE IF NOT EXISTS `andersenHibernate`.`User` (
 `userId` INT NOT NULL AUTO_INCREMENT ,
 `email` VARCHAR(45) NULL ,
 `name` VARCHAR(45) NULL ,
 `surname` VARCHAR(45) NULL,
   PRIMARY KEY (`userId`));

INSERT INTO `andersenHibernate`.`User` (`email`, `name`, `surname`)
VALUES ('yantasheiko@gmail.com', 'Yan', 'Tasheika');
