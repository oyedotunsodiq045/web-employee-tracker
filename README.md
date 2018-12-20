# 1: Set Up Database Environment - MySQL Workbench

# Create User - user:sodiq, pwd:sodiq
CREATE USER 'user'@'localhost' IDENTIFIED BY 'password';

# Grant User All Privileges
GRANT ALL PRIVILEGES ON * . * TO 'user'@'localhost';

# Create Database - neptune_sodiq
CREATE DATABASE database_name;

# Create Table - employee
CREATE TABLE `database_name`.`table_name` (
  
`id` INT NOT NULL AUTO_INCREMENT,
  
`first_name` VARCHAR(255) NOT NULL,
  
`last_name` VARCHAR(255) NOT NULL,
  
`username` VARCHAR(255) NOT NULL,
  
`department` VARCHAR(255) DEFAULT NULL,
  
`email` VARCHAR(255) NOT NULL,
  
`phone_number` VARCHAR(255) DEFAULT NULL,
  
`password` VARCHAR(255) NOT NULL,
  
`designation` VARCHAR(255) DEFAULT NULL,
  
`address` VARCHAR(255) DEFAULT NULL,
  
`dor` DATE,
  
PRIMARY KEY (`id`),
  
UNIQUE INDEX `employee_id_UNIQUE` (`id` ASC) VISIBLE,
  
UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE,
  
UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  
UNIQUE INDEX `usercol_UNIQUE` (`password` ASC) VISIBLE,
  
UNIQUE INDEX `phone_number_UNIQUE` (`phone_number` ASC) VISIBLE);


# Insert Sample Data - 1st Data
INSERT INTO `database_name`.`table_name` (`id`, `first_name`, `last_name`, `username`, `department`, `email`, `phone_number`, `password`, `designation`, `address`, `dor`) VALUES (1, 'Sodiq', 'Oyedotun', 'soyedotun', 'Technology', 'soyedotun@neptune.com', '08175044840', 'soyedotun', 'Software Engineer', 'Ebutemetta Lagos', '2018-12-04');

# Insert Sample Data - Subsequent Data
INSERT INTO `database_name`.`table_name` (`first_name`, `last_name`, `username`, `department`, `email`, `phone_number`, `password`, `designation`, `address`, `dor`) VALUES ('Shile', 'Roland', 'rolly', 'Quality Assurance', 'rolly@neptune.com', '07174545689', 'rolly', 'Software Tester', 'Surulere Lagos', '2016-06-22');