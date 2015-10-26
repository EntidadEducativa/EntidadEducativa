-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema entidad_educativa_database
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema entidad_educativa_database
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `entidad_educativa_database` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `entidad_educativa_database` ;

-- -----------------------------------------------------
-- Table `entidad_educativa_database`.`STUDENT`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `entidad_educativa_database`.`STUDENT` (
  `est_id` INT ZEROFILL NOT NULL AUTO_INCREMENT COMMENT '',
  `est_document` BIGINT(20) UNSIGNED NOT NULL COMMENT '',
  `est_username` VARCHAR(50) NOT NULL COMMENT '',
  `est_name` VARCHAR(45) NOT NULL COMMENT '',
  `est_last_name` VARCHAR(45) NOT NULL COMMENT '',
  `est_password` VARCHAR(20) NOT NULL COMMENT '',
  `est_email` VARCHAR(100) NOT NULL COMMENT '',
  `est_telephone` BIGINT(20) ZEROFILL NOT NULL COMMENT '',
  `est_address` VARCHAR(20) NULL COMMENT '',
  `est_age` INT NULL COMMENT '',
  `est_gender` VARCHAR(10) NOT NULL COMMENT '',
  `est_roll` VARCHAR(45) NOT NULL COMMENT '',
  PRIMARY KEY (`est_id`)  COMMENT '',
  UNIQUE INDEX `est_username_UNIQUE` (`est_username` ASC)  COMMENT '',
  UNIQUE INDEX `est_id_UNIQUE` (`est_id` ASC)  COMMENT '',
  UNIQUE INDEX `est_document_UNIQUE` (`est_document` ASC)  COMMENT '');


-- -----------------------------------------------------
-- Table `entidad_educativa_database`.`TEACHER`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `entidad_educativa_database`.`TEACHER` (
  `teach_est_id` INT ZEROFILL NOT NULL AUTO_INCREMENT COMMENT '',
  `teach_document` BIGINT(20) UNSIGNED NOT NULL COMMENT '',
  `teach_username` VARCHAR(50) NOT NULL COMMENT '',
  `teach_name` VARCHAR(45) NOT NULL COMMENT '',
  `teach_last_name` VARCHAR(45) NOT NULL COMMENT '',
  `teach_password` VARCHAR(20) NOT NULL COMMENT '',
  `teach_email` VARCHAR(100) NOT NULL COMMENT '',
  `teach_telephone` BIGINT(20) ZEROFILL NOT NULL COMMENT '',
  `teach_address` VARCHAR(20) NULL COMMENT '',
  `teach_age` INT NULL COMMENT '',
  `teach_gender` VARCHAR(10) NOT NULL COMMENT '',
  `teach_roll` VARCHAR(45) NOT NULL COMMENT '',
  `teach_profile` VARCHAR(45) NOT NULL COMMENT '',
  `teach_salary` DECIMAL(50,2) NOT NULL COMMENT '',
  PRIMARY KEY (`teach_est_id`)  COMMENT '',
  UNIQUE INDEX `teach_est_id_UNIQUE` (`teach_est_id` ASC)  COMMENT '',
  UNIQUE INDEX `teach_document_UNIQUE` (`teach_document` ASC)  COMMENT '',
  UNIQUE INDEX `teach_username_UNIQUE` (`teach_username` ASC)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `entidad_educativa_database`.`ADMINISTRATIVE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `entidad_educativa_database`.`ADMINISTRATIVE` (
  `adm_est_id` INT ZEROFILL NOT NULL AUTO_INCREMENT COMMENT '',
  `adm_document` BIGINT(20) UNSIGNED NOT NULL COMMENT '',
  `adm_username` VARCHAR(50) NOT NULL COMMENT '',
  `adm_name` VARCHAR(45) NOT NULL COMMENT '',
  `adm_last_name` VARCHAR(45) NOT NULL COMMENT '',
  `adm_password` VARCHAR(20) NOT NULL COMMENT '',
  `adm_email` VARCHAR(100) NOT NULL COMMENT '',
  `adm_telephone` BIGINT(20) ZEROFILL NOT NULL COMMENT '',
  `adm_address` VARCHAR(20) NULL COMMENT '',
  `adm_age` INT NULL COMMENT '',
  `adm_gender` VARCHAR(10) NOT NULL COMMENT '',
  `adm_roll` VARCHAR(45) NOT NULL COMMENT '',
  `adm_position` VARCHAR(45) NOT NULL COMMENT '',
  `adm_dependence` VARCHAR(45) NOT NULL COMMENT '',
  PRIMARY KEY (`adm_est_id`)  COMMENT '',
  UNIQUE INDEX `adm_est_id_UNIQUE` (`adm_est_id` ASC)  COMMENT '',
  UNIQUE INDEX `adm_document_UNIQUE` (`adm_document` ASC)  COMMENT '',
  UNIQUE INDEX `adm_username_UNIQUE` (`adm_username` ASC)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `entidad_educativa_database`.`PAYMENT`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `entidad_educativa_database`.`PAYMENT` (
  `pay_id` BIGINT(50) NOT NULL AUTO_INCREMENT COMMENT '',
  `pay_value` DECIMAL(50,2) NULL COMMENT '',
  `pay_date` DATE NULL COMMENT '',
  `STUDENT_est_id` INT ZEROFILL NULL COMMENT '',
  `TEACHER_teach_est_id` INT ZEROFILL NULL COMMENT '',
  `ADMINISTRATIVE_adm_est_id1` INT ZEROFILL NULL COMMENT '',
  UNIQUE INDEX `pay_id_UNIQUE` (`pay_id` ASC)  COMMENT '',
  INDEX `fk_PAYMENT_STUDENT1_idx` (`STUDENT_est_id` ASC)  COMMENT '',
  INDEX `fk_PAYMENT_TEACHER1_idx` (`TEACHER_teach_est_id` ASC)  COMMENT '',
  INDEX `fk_PAYMENT_ADMINISTRATIVE2_idx` (`ADMINISTRATIVE_adm_est_id1` ASC)  COMMENT '',
  PRIMARY KEY (`pay_id`)  COMMENT '',
  CONSTRAINT `fk_PAYMENT_STUDENT1`
    FOREIGN KEY (`STUDENT_est_id`)
    REFERENCES `entidad_educativa_database`.`STUDENT` (`est_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PAYMENT_TEACHER1`
    FOREIGN KEY (`TEACHER_teach_est_id`)
    REFERENCES `entidad_educativa_database`.`TEACHER` (`teach_est_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PAYMENT_ADMINISTRATIVE2`
    FOREIGN KEY (`ADMINISTRATIVE_adm_est_id1`)
    REFERENCES `entidad_educativa_database`.`ADMINISTRATIVE` (`adm_est_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `entidad_educativa_database`.`COURSE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `entidad_educativa_database`.`COURSE` (
  `course_id` INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '',
  `course_name` VARCHAR(45) NOT NULL COMMENT '',
  `course_start_date` DATE NULL COMMENT '',
  `course_end_date` DATE NULL COMMENT '',
  `course_schedule` VARCHAR(45) NOT NULL COMMENT '',
  `course_price` DECIMAL(20,2) NOT NULL COMMENT '',
  `TEACHER_teach_est_id` INT ZEROFILL NULL COMMENT '',
  PRIMARY KEY (`course_id`)  COMMENT '',
  UNIQUE INDEX `course_id_UNIQUE` (`course_id` ASC)  COMMENT '',
  UNIQUE INDEX `course_name_UNIQUE` (`course_name` ASC)  COMMENT '',
  INDEX `fk_COURSE_TEACHER1_idx` (`TEACHER_teach_est_id` ASC)  COMMENT '',
  CONSTRAINT `fk_COURSE_TEACHER1`
    FOREIGN KEY (`TEACHER_teach_est_id`)
    REFERENCES `entidad_educativa_database`.`TEACHER` (`teach_est_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `entidad_educativa_database`.`ADMINISTRATOR`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `entidad_educativa_database`.`ADMINISTRATOR` (
  `admin_id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `admin_name` VARCHAR(45) NOT NULL COMMENT '',
  `admin_username` VARCHAR(20) NOT NULL COMMENT '',
  `admin_password` VARCHAR(20) NOT NULL COMMENT '',
  `admin_lastname` VARCHAR(45) NOT NULL COMMENT '',
  PRIMARY KEY (`admin_id`)  COMMENT '',
  UNIQUE INDEX `admin_id_UNIQUE` (`admin_id` ASC)  COMMENT '',
  UNIQUE INDEX `admin_username_UNIQUE` (`admin_username` ASC)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `entidad_educativa_database`.`ADMINISTRATOR_has_COURSE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `entidad_educativa_database`.`ADMINISTRATOR_has_COURSE` (
  `ADMINISTRATOR_admin_id` INT NULL COMMENT '',
  `COURSE_course_id` INT UNSIGNED NULL COMMENT '',
  INDEX `fk_ADMINISTRATOR_has_COURSE_COURSE1_idx` (`COURSE_course_id` ASC)  COMMENT '',
  INDEX `fk_ADMINISTRATOR_has_COURSE_ADMINISTRATOR1_idx` (`ADMINISTRATOR_admin_id` ASC)  COMMENT '',
  CONSTRAINT `fk_ADMINISTRATOR_has_COURSE_ADMINISTRATOR1`
    FOREIGN KEY (`ADMINISTRATOR_admin_id`)
    REFERENCES `entidad_educativa_database`.`ADMINISTRATOR` (`admin_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ADMINISTRATOR_has_COURSE_COURSE1`
    FOREIGN KEY (`COURSE_course_id`)
    REFERENCES `entidad_educativa_database`.`COURSE` (`course_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `entidad_educativa_database`.`ADMINISTRATOR_has_TEACHER`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `entidad_educativa_database`.`ADMINISTRATOR_has_TEACHER` (
  `ADMINISTRATOR_admin_id` INT NULL COMMENT '',
  `TEACHER_teach_est_id` INT ZEROFILL NULL COMMENT '',
  INDEX `fk_ADMINISTRATOR_has_TEACHER_TEACHER1_idx` (`TEACHER_teach_est_id` ASC)  COMMENT '',
  INDEX `fk_ADMINISTRATOR_has_TEACHER_ADMINISTRATOR1_idx` (`ADMINISTRATOR_admin_id` ASC)  COMMENT '',
  CONSTRAINT `fk_ADMINISTRATOR_has_TEACHER_ADMINISTRATOR1`
    FOREIGN KEY (`ADMINISTRATOR_admin_id`)
    REFERENCES `entidad_educativa_database`.`ADMINISTRATOR` (`admin_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ADMINISTRATOR_has_TEACHER_TEACHER1`
    FOREIGN KEY (`TEACHER_teach_est_id`)
    REFERENCES `entidad_educativa_database`.`TEACHER` (`teach_est_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `entidad_educativa_database`.`ADMINISTRATOR_has_STUDENT`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `entidad_educativa_database`.`ADMINISTRATOR_has_STUDENT` (
  `ADMINISTRATOR_admin_id` INT NULL COMMENT '',
  `STUDENT_est_id` INT ZEROFILL NULL COMMENT '',
  INDEX `fk_ADMINISTRATOR_has_STUDENT_STUDENT1_idx` (`STUDENT_est_id` ASC)  COMMENT '',
  INDEX `fk_ADMINISTRATOR_has_STUDENT_ADMINISTRATOR1_idx` (`ADMINISTRATOR_admin_id` ASC)  COMMENT '',
  CONSTRAINT `fk_ADMINISTRATOR_has_STUDENT_ADMINISTRATOR1`
    FOREIGN KEY (`ADMINISTRATOR_admin_id`)
    REFERENCES `entidad_educativa_database`.`ADMINISTRATOR` (`admin_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ADMINISTRATOR_has_STUDENT_STUDENT1`
    FOREIGN KEY (`STUDENT_est_id`)
    REFERENCES `entidad_educativa_database`.`STUDENT` (`est_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `entidad_educativa_database`.`ADMINISTRATOR_has_ADMINISTRATIVE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `entidad_educativa_database`.`ADMINISTRATOR_has_ADMINISTRATIVE` (
  `ADMINISTRATOR_admin_id` INT NULL COMMENT '',
  `ADMINISTRATIVE_adm_est_id` INT ZEROFILL NULL COMMENT '',
  INDEX `fk_ADMINISTRATOR_has_ADMINISTRATIVE_ADMINISTRATIVE1_idx` (`ADMINISTRATIVE_adm_est_id` ASC)  COMMENT '',
  INDEX `fk_ADMINISTRATOR_has_ADMINISTRATIVE_ADMINISTRATOR1_idx` (`ADMINISTRATOR_admin_id` ASC)  COMMENT '',
  CONSTRAINT `fk_ADMINISTRATOR_has_ADMINISTRATIVE_ADMINISTRATOR1`
    FOREIGN KEY (`ADMINISTRATOR_admin_id`)
    REFERENCES `entidad_educativa_database`.`ADMINISTRATOR` (`admin_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ADMINISTRATOR_has_ADMINISTRATIVE_ADMINISTRATIVE1`
    FOREIGN KEY (`ADMINISTRATIVE_adm_est_id`)
    REFERENCES `entidad_educativa_database`.`ADMINISTRATIVE` (`adm_est_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `entidad_educativa_database`.`PAYMENT_has_COURSE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `entidad_educativa_database`.`PAYMENT_has_COURSE` (
  `PAYMENT_pay_id` BIGINT(50) NULL COMMENT '',
  `COURSE_course_id` INT UNSIGNED NULL COMMENT '',
  INDEX `fk_PAYMENT_has_COURSE_COURSE1_idx` (`COURSE_course_id` ASC)  COMMENT '',
  INDEX `fk_PAYMENT_has_COURSE_PAYMENT1_idx` (`PAYMENT_pay_id` ASC)  COMMENT '',
  CONSTRAINT `fk_PAYMENT_has_COURSE_PAYMENT1`
    FOREIGN KEY (`PAYMENT_pay_id`)
    REFERENCES `entidad_educativa_database`.`PAYMENT` (`pay_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PAYMENT_has_COURSE_COURSE1`
    FOREIGN KEY (`COURSE_course_id`)
    REFERENCES `entidad_educativa_database`.`COURSE` (`course_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `entidad_educativa_database`.`STUDENT_has_COURSE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `entidad_educativa_database`.`STUDENT_has_COURSE` (
  `STUDENT_est_id` INT ZEROFILL NULL COMMENT '',
  `COURSE_course_id` INT UNSIGNED NULL COMMENT '',
  INDEX `fk_STUDENT_has_COURSE_COURSE1_idx` (`COURSE_course_id` ASC)  COMMENT '',
  INDEX `fk_STUDENT_has_COURSE_STUDENT1_idx` (`STUDENT_est_id` ASC)  COMMENT '',
  CONSTRAINT `fk_STUDENT_has_COURSE_STUDENT1`
    FOREIGN KEY (`STUDENT_est_id`)
    REFERENCES `entidad_educativa_database`.`STUDENT` (`est_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_STUDENT_has_COURSE_COURSE1`
    FOREIGN KEY (`COURSE_course_id`)
    REFERENCES `entidad_educativa_database`.`COURSE` (`course_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `entidad_educativa_database`.`TEACHER_has_COURSE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `entidad_educativa_database`.`TEACHER_has_COURSE` (
  `TEACHER_teach_est_id` INT ZEROFILL NULL COMMENT '',
  `COURSE_course_id` INT UNSIGNED NULL COMMENT '',
  INDEX `fk_TEACHER_has_COURSE_COURSE1_idx` (`COURSE_course_id` ASC)  COMMENT '',
  INDEX `fk_TEACHER_has_COURSE_TEACHER1_idx` (`TEACHER_teach_est_id` ASC)  COMMENT '',
  CONSTRAINT `fk_TEACHER_has_COURSE_TEACHER1`
    FOREIGN KEY (`TEACHER_teach_est_id`)
    REFERENCES `entidad_educativa_database`.`TEACHER` (`teach_est_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_TEACHER_has_COURSE_COURSE1`
    FOREIGN KEY (`COURSE_course_id`)
    REFERENCES `entidad_educativa_database`.`COURSE` (`course_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `entidad_educativa_database`.`ADMINISTRATIVE_has_COURSE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `entidad_educativa_database`.`ADMINISTRATIVE_has_COURSE` (
  `ADMINISTRATIVE_adm_est_id` INT ZEROFILL NULL COMMENT '',
  `COURSE_course_id` INT UNSIGNED NULL COMMENT '',
  INDEX `fk_ADMINISTRATIVE_has_COURSE_COURSE1_idx` (`COURSE_course_id` ASC)  COMMENT '',
  INDEX `fk_ADMINISTRATIVE_has_COURSE_ADMINISTRATIVE1_idx` (`ADMINISTRATIVE_adm_est_id` ASC)  COMMENT '',
  CONSTRAINT `fk_ADMINISTRATIVE_has_COURSE_ADMINISTRATIVE1`
    FOREIGN KEY (`ADMINISTRATIVE_adm_est_id`)
    REFERENCES `entidad_educativa_database`.`ADMINISTRATIVE` (`adm_est_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ADMINISTRATIVE_has_COURSE_COURSE1`
    FOREIGN KEY (`COURSE_course_id`)
    REFERENCES `entidad_educativa_database`.`COURSE` (`course_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
