Create Table Cadastro(
    idusuario int not null primary key auto_increment,
    nomeusuario varchar(100) not null,
    email varchar(100) not null,
    senha varchar(100) not null,
    idpermissoes int not null
);

