Create Table permissoes(
    idpermissoes int not null primary key auto_increment,
    permissoes varchar(30) not null
);

Insert into permissoes(permissoes) values ('professor');
Insert into permissoes(permissoes) values ('coordenador');