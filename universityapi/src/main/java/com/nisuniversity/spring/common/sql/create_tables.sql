create database university;
use university;

CREATE TABLE `university`.`college` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `address` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `phone_number` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `university`.`student` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `lastname` VARCHAR(45) NULL,
  `jmbg` VARCHAR(45) NULL,
  `birth_date` TIMESTAMP NULL,
  `address` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `phone_number` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));


  
CREATE TABLE `university`.`college_student`(
	`id` INT NOT NULL AUTO_INCREMENT,
	`college_id` INT NULL,
	`student_id` INT NULL,
	PRIMARY KEY (`id`));

ALTER TABLE `university`.`college_student` ADD CONSTRAINT `fk_college` FOREIGN KEY(`college_id`)
REFERENCES `university`.`college` (`id`)
ALTER TABLE `university`.`college_student` ADD CONSTRAINT `fk_student` FOREIGN KEY(`student_id`)
REFERENCES `university`.`student` (`id`)




insert into student(name,lastname,jmbg,birth_date,address,email,phone_number) values ('Aleksandar', 'Grujic','1803996340047', '1996-01-01 11:11:11.000000', 'Gligorija Diklica 31','grujaca@gmail.com','0629782743')
insert into student(name,lastname,jmbg,birth_date,address,email,phone_number) values ('Mihajlo', 'Micic','123124312313', '1995-01-01 11:11:11.000000', 'Proleterska 31','mihajlomicic@gmail.com','0623243456')
