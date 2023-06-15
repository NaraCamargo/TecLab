Create Table Agendamento(

    idagendamento int not null auto_increment primary key,
    idusuario int not null auto_increment foreign key,
    idlaboratorio int not null auto_increment foreign key,
    idturma int not null auto_increment foreign key,
    idhorario Time not null auto_increment foreign key,
    data date not null
);

Create Table Permissoes(

    idpermissoes int not null auto_increment primary key,
    permissoes String not null auto_increment,
);

Insert into permissoes(permissoes) values ('professor', 'coordenador');

Create Table Horarios(

    idhorario int not null auto_increment primary key,
    horario time not null
);

Insert into horarios(horario) values ('07:20:00', '08:10:00', '09:00:00', '09:50:00', '10:05:00', '10:55:00', '11:45:00', '12:35:00');

Create Table Usuario(


);