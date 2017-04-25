-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mybanknci
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mybanknci` ;

-- -----------------------------------------------------
-- Schema mybanknci
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mybanknci` DEFAULT CHARACTER SET utf8 ;
USE `mybanknci` ;

-- -----------------------------------------------------
-- Table `mybanknci`.`Customer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mybanknci`.`Customer` ;

CREATE TABLE IF NOT EXISTS `mybanknci`.`Customer` (
  `Customer_id` INT NOT NULL,
  `Cust_FN` VARCHAR(50) NOT NULL,
  `Cust_LN` VARCHAR(50) NOT NULL,
  `DOB` DATE NOT NULL,
  `Gender` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`Customer_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mybanknci`.`Login`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mybanknci`.`Login` ;

CREATE TABLE IF NOT EXISTS `mybanknci`.`Login` (
  `Username` VARCHAR(45) NOT NULL,
  `Password` VARCHAR(45) NOT NULL,
  `Customer_Customer_id` INT NOT NULL,
  PRIMARY KEY (`Username`),
  INDEX `fk_Login_Customer1_idx` (`Customer_Customer_id` ASC),
  CONSTRAINT `fk_Login_Customer1`
    FOREIGN KEY (`Customer_Customer_id`)
    REFERENCES `mybanknci`.`Customer` (`Customer_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mybanknci`.`Account`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mybanknci`.`Account` ;

CREATE TABLE IF NOT EXISTS `mybanknci`.`Account` (
  `Account_number` INT NOT NULL,
  `Min_Balance` INT NOT NULL,
  `Current_Balance` INT NOT NULL,
  `Opening_Date` DATE NULL,
  `Access_Date` DATE NULL,
  `Customer_Customer_id` INT NOT NULL,
  PRIMARY KEY (`Account_number`),
  UNIQUE INDEX `Account_number_UNIQUE` (`Account_number` ASC),
  INDEX `fk_Account_Customer1_idx` (`Customer_Customer_id` ASC),
  CONSTRAINT `fk_Account_Customer1`
    FOREIGN KEY (`Customer_Customer_id`)
    REFERENCES `mybanknci`.`Customer` (`Customer_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mybanknci`.`Transaction`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mybanknci`.`Transaction` ;

CREATE TABLE IF NOT EXISTS `mybanknci`.`Transaction` (
  `Transaction_id` INT NOT NULL,
  `Account_Number` INT NOT NULL,
  `Amount` INT NOT NULL,
  `Trans_Date` DATE NOT NULL,
  `Description` VARCHAR(50) NULL,
  `Trans_Number` INT NULL,
  PRIMARY KEY (`Transaction_id`),
  INDEX `Account_Number_idx` (`Account_Number` ASC),
  CONSTRAINT `Account_Number`
    FOREIGN KEY (`Account_Number`)
    REFERENCES `mybanknci`.`Account` (`Account_number`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
