Create Table Permissoes(
    idpermissoes int not null primary key auto_increment,
    permissoes varchar(30) not null
);

Create Table Horarios(
    idhorario int not null primary key auto_increment,
    horario time not null
);

Create Table Usuario(
    idusuario int not null primary key auto_increment,
    nomeusuario varchar(100) not null,
    email varchar(100) not null,
    senha varchar(100) not null
);

Create Table Turmas(
    idturma int not null primary key auto_increment,
    turma varchar(20) not null
);

Create Table Laboratorios(
    idlaboratorio int not null primary key auto_increment,
    nomelab varchar(20) not null
 );

 Create Table Agendamento(
     idagendamento int not null primary key auto_increment,
     idusuario int not null,
     idlaboratorio int not null,
     idturma int not null,
     idhorario time not null,
     data date not null
 );

Insert into permissoes(permissoes) values ('professor');
Insert into permissoes(permissoes) values ('coordenador');

Insert into horarios(horario) values ('07:20:00');
Insert into horarios(horario) values ('08:10:00');
Insert into horarios(horario) values ('09:00:00');
Insert into horarios(horario) values ('09:50:00');
Insert into horarios(horario) values ('10:05:00');
Insert into horarios(horario) values ('10:55:00');
Insert into horarios(horario) values ('11:45:00');
Insert into horarios(horario) values ('12:35:00');

Insert into usuario(nomeusuario, email, senha) values ('Rogério Furlan', 'rogerio.furlan@etec.sp.gov.br', 'senha');

Insert into turmas(turma) values ('1 adm');
Insert into turmas(turma) values ('2 adm');
Insert into turmas(turma) values ('3 adm');
Insert into turmas(turma) values ('1 mkt');
Insert into turmas(turma) values ('2 mkt');
Insert into turmas(turma) values ('3 mkt');
Insert into turmas(turma) values ('1 qui');
Insert into turmas(turma) values ('2 qui');
Insert into turmas(turma) values ('3 qui');
Insert into turmas(turma) values ('1 ds');
Insert into turmas(turma) values ('2 ds');
Insert into turmas(turma) values ('3 ds');

Insert into laboratorios(nomelab) values ('lab 1');
Insert into laboratorios(nomelab) values ('lab 2');
Insert into laboratorios(nomelab) values ('lab 3');
Insert into laboratorios(nomelab) values ('lab 4');
Insert into laboratorios(nomelab) values ('lab 5');


 Alter Table agendamento add CONSTRAINT FK_Usuario_Agendamento foreign key (idusuario) references usuario(idusuario);
 Alter Table agendamento add CONSTRAINT FK_Laboratorios_Agendamento foreign key (idlaboratorio) references laboratorios(idlaboratorio);
 Alter Table agendamento add CONSTRAINT FK_Turmas_Agendamento foreign key (idturma) references turmas(idturma);
