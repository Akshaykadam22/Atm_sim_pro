create database bankmanagementsystem;

use bankmanagementsystem;
CREATE TABLE signup (
    formno VARCHAR(20),
    name VARCHAR(20),
    father_name VARCHAR(20),
    dob VARCHAR(20),
    gender VARCHAR(20),
    email_address VARCHAR(30),
    marital_status VARCHAR(20),
    address VARCHAR(40),
    city VARCHAR(20),
    pin VARCHAR(20),
    state VARCHAR(25)
);
select * from signup;
show tables;
select* from signupTwo;
CREATE TABLE signupTwo (
    formno VARCHAR(20),
    religion VARCHAR(20),
    category VARCHAR(20),
    income VARCHAR(20),
    education VARCHAR(20),
    occupation VARCHAR(20),
    panNumber VARCHAR(20),
    aadharNumber VARCHAR(20),
    seniorCitizen VARCHAR(10),
    existingAccount VARCHAR(10)
);

CREATE TABLE signupThree (
    formno VARCHAR(255),
    accounttype VARCHAR(255),
    cardNumber VARCHAR(255),
    pinNumber VARCHAR(255),
    facuilty VARCHAR(255)
);
select* from signupThree;

create table login(formno varchar(20),cardNumber varchar(20),pinNumber varchar(20));
select * from login ;
drop table bank;
select * from  bank;
create table bank(pinNumber varchar(20), date varchar(50),type varchar(20),amount varchar(20 ));