Create Table usuario(
    idusuario int not null primary key auto_increment,
    nomeusuario varchar(100) not null,
    email varchar(100) not null,
    senha varchar(100) not null
);

Insert into usuario(nomeusuario, email, senha) values ('Rogério Furlan', 'rogerio.furlan@etec.sp.gov.br', 'senha');