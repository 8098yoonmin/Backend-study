-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema exam_8
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema exam_8
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `exam_8` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `exam_8` ;

-- -----------------------------------------------------
-- Table `exam_8`.`department`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `exam_8`.`department` ;

CREATE TABLE IF NOT EXISTS `exam_8`.`department` (
  `department_id` VARCHAR(50) NOT NULL,
  `department_name` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`department_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `exam_8`.`employee`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `exam_8`.`employee` ;

CREATE TABLE IF NOT EXISTS `exam_8`.`employee` (
  `employee_id` BIGINT NOT NULL,
  `employee_name` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`employee_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `exam_8`.`employee_department`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `exam_8`.`employee_department` ;

CREATE TABLE IF NOT EXISTS `exam_8`.`employee_department` (
  `employee_id` BIGINT NOT NULL,
  `department_id` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`employee_id`, `department_id`),
  INDEX `fk_employee_department` (`department_id` ASC) VISIBLE,
  CONSTRAINT `fk_department_employee`
    FOREIGN KEY (`employee_id`)
    REFERENCES `exam_8`.`employee` (`employee_id`),
  CONSTRAINT `fk_employee_department`
    FOREIGN KEY (`department_id`)
    REFERENCES `exam_8`.`department` (`department_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `exam_8`.`genre`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `exam_8`.`genre` ;

CREATE TABLE IF NOT EXISTS `exam_8`.`genre` (
  `genre_id` INT NOT NULL,
  `genre_name` VARCHAR(50) NULL,
  PRIMARY KEY (`genre_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `exam_8`.`age`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `exam_8`.`age` ;

CREATE TABLE IF NOT EXISTS `exam_8`.`age` (
  `age_id` INT NOT NULL,
  `age_limit` INT NULL,
  PRIMARY KEY (`age_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `exam_8`.`boxoffice`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `exam_8`.`boxoffice` ;

CREATE TABLE IF NOT EXISTS `exam_8`.`boxoffice` (
  `production_cost` INT NULL,
  `us_success_degree` INT NULL,
  `world_success_degree` INT NULL,
  `cost_id` INT NOT NULL,
  PRIMARY KEY (`cost_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `exam_8`.`movie`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `exam_8`.`movie` ;

CREATE TABLE IF NOT EXISTS `exam_8`.`movie` (
  `movie_id` INT NOT NULL,
  `movie_title` VARCHAR(45) NULL,
  `running_time` INT NULL,
  `movie_release` DATETIME NULL,
  `movie_trivia` VARCHAR(300) NULL,
  `movie_description` VARCHAR(500) NULL,
  `genre_id` INT NOT NULL,
  `age_id` INT NOT NULL,
  `boxoffice_cost_id` INT NOT NULL,
  PRIMARY KEY (`movie_id`),
  INDEX `fk_movie_genre1_idx` (`genre_id` ASC) VISIBLE,
  INDEX `fk_movie_age1_idx` (`age_id` ASC) VISIBLE,
  INDEX `fk_movie_boxoffice1_idx` (`boxoffice_cost_id` ASC) VISIBLE,
  CONSTRAINT `fk_movie_genre1`
    FOREIGN KEY (`genre_id`)
    REFERENCES `exam_8`.`genre` (`genre_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_movie_age1`
    FOREIGN KEY (`age_id`)
    REFERENCES `exam_8`.`age` (`age_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_movie_boxoffice1`
    FOREIGN KEY (`boxoffice_cost_id`)
    REFERENCES `exam_8`.`boxoffice` (`cost_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `exam_8`.`address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `exam_8`.`address` ;

CREATE TABLE IF NOT EXISTS `exam_8`.`address` (
  `address_id` INT NOT NULL,
  `address_name` VARCHAR(45) NULL,
  PRIMARY KEY (`address_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `exam_8`.`person`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `exam_8`.`person` ;

CREATE TABLE IF NOT EXISTS `exam_8`.`person` (
  `person_name` VARCHAR(50) NULL,
  `real_name` VARCHAR(45) NULL,
  `birthdate` DATETIME NULL,
  `person_description` VARCHAR(500) NULL,
  `person_id` INT NOT NULL,
  `address_id` INT NOT NULL,
  PRIMARY KEY (`person_id`),
  UNIQUE INDEX `person_id_UNIQUE` (`person_id` ASC) VISIBLE,
  INDEX `fk_person_address1_idx` (`address_id` ASC) VISIBLE,
  CONSTRAINT `fk_person_address1`
    FOREIGN KEY (`address_id`)
    REFERENCES `exam_8`.`address` (`address_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `exam_8`.`award`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `exam_8`.`award` ;

CREATE TABLE IF NOT EXISTS `exam_8`.`award` (
  `nominated_year` INT NULL,
  `award_year` INT NULL,
  `movie_id` INT NOT NULL,
  `person_id` INT NOT NULL,
  `award_name` VARCHAR(50) NULL,
  PRIMARY KEY (`movie_id`, `person_id`),
  INDEX `fk_award_person1_idx` (`person_id` ASC) VISIBLE,
  CONSTRAINT `fk_award_movie1`
    FOREIGN KEY (`movie_id`)
    REFERENCES `exam_8`.`movie` (`movie_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_award_person1`
    FOREIGN KEY (`person_id`)
    REFERENCES `exam_8`.`person` (`person_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `exam_8`.`occupation`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `exam_8`.`occupation` ;

CREATE TABLE IF NOT EXISTS `exam_8`.`occupation` (
  `occupation_id` INT NOT NULL,
  `occupation_name` VARCHAR(50) NULL,
  PRIMARY KEY (`occupation_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `exam_8`.`role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `exam_8`.`role` ;

CREATE TABLE IF NOT EXISTS `exam_8`.`role` (
  `role_id` INT NOT NULL,
  `movie_id` INT NOT NULL,
  `person_id` INT NOT NULL,
  `occupation_id` INT NOT NULL,
  PRIMARY KEY (`role_id`),
  INDEX `fk_role_movie1_idx` (`movie_id` ASC) VISIBLE,
  INDEX `fk_role_person1_idx` (`person_id` ASC) VISIBLE,
  INDEX `fk_role_occupation1_idx` (`occupation_id` ASC) VISIBLE,
  CONSTRAINT `fk_role_movie1`
    FOREIGN KEY (`movie_id`)
    REFERENCES `exam_8`.`movie` (`movie_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_role_person1`
    FOREIGN KEY (`person_id`)
    REFERENCES `exam_8`.`person` (`person_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_role_occupation1`
    FOREIGN KEY (`occupation_id`)
    REFERENCES `exam_8`.`occupation` (`occupation_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `exam_8`.`article`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `exam_8`.`article` ;

CREATE TABLE IF NOT EXISTS `exam_8`.`article` (
  `article_id` INT NOT NULL,
  `article_title` VARCHAR(50) NULL,
  `movie_id` INT NOT NULL,
  PRIMARY KEY (`article_id`),
  INDEX `fk_article_movie1_idx` (`movie_id` ASC) VISIBLE,
  CONSTRAINT `fk_article_movie1`
    FOREIGN KEY (`movie_id`)
    REFERENCES `exam_8`.`movie` (`movie_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
