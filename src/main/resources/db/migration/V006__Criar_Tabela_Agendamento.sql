Create Table agendamento(
     idagendamento int not null primary key auto_increment,
     idusuario int not null,
     idlaboratorio int not null,
     idhorario time not null,
     data date not null
 );

Insert into agendamento(idusuario, idlaboratorio, idhorario, data) values ('1','3','1','2023-06-27');
