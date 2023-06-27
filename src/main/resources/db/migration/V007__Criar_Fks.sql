 Alter Table agendamento add CONSTRAINT FK_Usuario_Agendamento foreign key (idusuario) references usuario(idusuario);
 Alter Table agendamento add CONSTRAINT FK_Laboratorios_Agendamento foreign key (idlaboratorio) references laboratorios(idlaboratorio);
 Alter Table agendamento add CONSTRAINT FK_Turmas_Agendamento foreign key (idturma) references turmas(idturma);