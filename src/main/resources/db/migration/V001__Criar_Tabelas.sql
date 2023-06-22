Create Table Permissoes(
    idpermissoes int not null primary key auto_increment,
    permissoes varchar(30) not null
);

Create Table Horarios(
    idhorario int not null primary key auto_increment,
    horario time not null
);

Create Table Usuario(
    idusuario int not null auto_increment,
    nomeusuario varchar(100) not null,
    email varchar(100) not null,
    senha varchar(100) not null
);

Create Turmas(
    idturma int not null auto_increment,
    turma varchar(20) not null
);

Create Laboratorios(
    idlaboratorio int not null auto_increment,
    nomelab varchar(20) not null
 );

 Create Table Agendamento(
     idagendamento int not null primary key auto_increment,
     idusuario int not null foreign key,
     idlaboratorio int not null foreign key,
     idturma int not null foreign key,
     idhorario Time not null foreign key,
     data date not null
 );

Insert into permissoes(permissoes) values ('professor', 'coordenador');

Insert into horarios(horario) values ('07:20:00', '08:10:00', '09:00:00', '09:50:00', '10:05:00', '10:55:00', '11:45:00', '12:35:00');

Insert into usuario(nomeusuario, email, senha) values ('Rogério Furlan', 'rogerio.furlan@etec.sp.gov.br', 'senha');

Insert into turmas(turma) values ('1 adm', '2 adm', '3 adm','1 mkt', '2 mkt', '3 mkt', '1 qui', '2 qui', '3 qui', '1 ds', '2 ds', '3 ds');

Insert into laboratorios(nomelab) values ('lab 1', 'lab 2','lab 3','lab 4','lab 5');


 Alter Table agendamento add CONSTRAINT FK_Usuario_Agendamento foreign key (idusuario) references usuario(idusuario);
 Alter Table agendamento add CONSTRAINT FK_Laboratorios_Agendamento foreign key (idlaboratorio) references laboratorios(idlaboratorio);
 Alter Table agendamento add CONSTRAINT FK_Turmas_Agendamento foreign key (idturma) references turmas(idturma);
 Alter Table agendamento add CONSTRAINT FK_Horarios_Agendamento foreign key (idhorario) references horarios(idhorario);