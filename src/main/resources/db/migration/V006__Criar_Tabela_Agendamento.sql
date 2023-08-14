Create Table Agendamento(
     idagendamento int not null primary key AUTO_INCREMENT,
     idusuario int not null,
     idlaboratorio int not null,
     idhorario int not null,
     data date not null
 );

