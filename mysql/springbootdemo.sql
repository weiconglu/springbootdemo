DROP DATABASE IF EXISTS springbootdemo;
CREATE DATABASE springbootdemo /*!40100 DEFAULT CHARACTER SET UTF8MB4 */;
USE springbootdemo;

CREATE TABLE IF NOT EXISTS tb_t_employee (
    id INT PRIMARY KEY AUTO_INCREMENT,
    last_name VARCHAR(50),
    email VARCHAR(50),
    gender INT,
    age INT,
    create_time DATETIME,
    update_time DATETIME
)  ENGINE=INNODB DEFAULT CHARSET=UTF8MB4 COMMENT='employee';

INSERT INTO tb_t_employee(last_name,email,gender,age) VALUES('Tom','tom@atguigu.com',1,22);
INSERT INTO tb_t_employee(last_name,email,gender,age) VALUES('Jerry','jerry@atguigu.com',0,25);
INSERT INTO tb_t_employee(last_name,email,gender,age) VALUES('Black','black@atguigu.com',1,30);
INSERT INTO tb_t_employee(last_name,email,gender,age) VALUES('White','white@atguigu.com',0,35)
