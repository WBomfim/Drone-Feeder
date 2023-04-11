CREATE DATABASE IF NOT EXISTS Drone_Feeder;
USE Drone_Feeder;

CREATE TABLE IF NOT EXISTS clients (
  `id` INT NOT NULL,
  `name` VARCHAR(50) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS drones (
  `id` INT NOT NULL,
  `status` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

INSERT INTO clients (`id`, `name`, `password`) VALUES (1, 'client1', 'password1');
INSERT INTO clients (`id`, `name`, `password`) VALUES (2, 'client2', 'password2');

INSERT INTO drones (`id`, `status`) VALUES (1, 'AVAILABLE');
INSERT INTO drones (`id`, `status`) VALUES (2, 'AVAILABLE');
INSERT INTO drones (`id`, `status`) VALUES (3, 'AVAILABLE');
