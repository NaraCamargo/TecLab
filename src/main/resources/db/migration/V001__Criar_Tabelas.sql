Create Table Agendamento(

    idagendamento int not null auto_increment primary key,
    idusuario int not null auto_increment foreign key,
    idlaboratorio int not null auto_increment foreign key,
    idturma int not null auto_increment foreign key,
    idhorario Time not null auto_increment foreign key,
    data date not null
);

