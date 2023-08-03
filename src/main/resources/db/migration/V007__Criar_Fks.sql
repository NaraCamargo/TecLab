 Alter Table agendamento add CONSTRAINT FK_cadastro_agendamento foreign key (idusuario) references cadastro(idusuario);
 Alter Table agendamento add CONSTRAINT FK_Laboratorios_Agendamento foreign key (idlaboratorio) references laboratorios(idlaboratorio);
  Alter Table agendamento add CONSTRAINT FK_Horarios_Agendamento foreign key (idhorario) references horarios(idhorario);