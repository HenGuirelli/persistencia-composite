create database if not exists arvore;
use arvore;

create table Arvore (
    _hash int not null, /*hash palavra reservada*/
    pai int,
    node boolean not null,
    nome varchar(30),
    conteudo varchar(30)
);


