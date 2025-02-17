create shecma hospital;
use hospital;

create table medico:
    id int primary key auto_increment,
    nome varchar(100) not null,
    crm varchar(10) not null,
    especialidade varchar(100) not null,

create table paciente:
    id int primary key auto_increment,
    nome varchar(100) not null,
    cpf varchar(11) not null,
    data_nascimento date not null,