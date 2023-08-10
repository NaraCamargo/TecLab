Create Table agendamento(
     idagendamento int primary key auto_increment,
     idusuario int not null,
     idlaboratorio int not null,
     idhorario int not null,
     data date not null
 );

