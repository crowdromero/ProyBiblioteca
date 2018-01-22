
/*

Procedure  Listado Registros

*/

drop procedure if exists sp_consultar_Registros;

delimiter &&
create procedure sp_consultar_Registros()
begin
select * from registro;
end&&
delimiter ;


call sp_consultar_Registros;


/*

Procedure  Listado Usuarios

*/

drop procedure if exists sp_consultar_Usuario;

delimiter &&
create procedure sp_consultar_Usuario(in usuario varchar(8),in pass varchar(10))
begin
SET @consulta = CONCAT('select * from usuario where idUsuario=',usuario,' and usu_contraseña =', pass,'');
PREPARE ejecutar FROM @consulta;
EXECUTE ejecutar;
end&&
delimiter ;

/*

Procedure  Listado Usuarios

*/

drop procedure if exists sp_consultar_Trabajador;

delimiter &&
create procedure sp_consultar_Trabajador(in id varchar(6),in pass varchar(10))
begin
select * from trabajador
where idTrabajador=id and trab_pass =pass;
end&&
delimiter ;

call sp_consultar_Trabajador('T10001','123456');


/*

Procedure  Listado Libros Inner Join

*/

drop procedure if exists sp_consultar_Libro;

delimiter &&
create procedure sp_consultar_Libro(in titulo varchar(50),in autornom varchar(40),in autorape varchar(40),in editorial varchar(50),in genero varchar(45))
begin
select l.idlibro,l.lib_titulo,a.autor_nombre,a.autor_apellido,e.ed_nombre,l.lib_fecpub,g.genero,l.lib_cantidad
from libro as l
inner join autor as a
on l.lib_autor=a.idautor
inner join editorial as e
on l.lib_editorial=e.ideditorial 
inner join genero as g
on g.idgenero=l.lib_genero
inner join idioma as i
on i.ididioma=l.lib_idioma
where l.lib_titulo like CONCAT ('%', titulo, '%')
and a.autor_nombre like CONCAT ('%', autornom, '%')
and l.lib_titulo like CONCAT ('%', autorape, '%')
and e.ed_nombre like CONCAT ('%', editorial, '%')
and g.genero like CONCAT ('%', genero, '%');
end&&
delimiter ;

call sp_consultar_Libro('','','','','');




/*

Procedure  Registrar Libros

*/

drop procedure if exists sp_Registrar_Libros;

delimiter &&
create procedure sp_Registrar_Libros(in idLibro varchar(6),in lib_titulo varchar(50),in lib_autor varchar(6),in lib_editorial varchar(6),in lib_fecpub varchar(10),
									in lib_genero varchar(6),in lib_paginas int,in lib_cantidad int,in lib_idioma varchar(6))
begin
INSERT INTO `BD_BiBLIOTECA`.`Libro` (`idLibro`, `lib_titulo`, `lib_autor`, `lib_editorial`, `lib_fecpub`, `lib_genero`, `lib_paginas`, `lib_cantidad`, `lib_idioma`, `lib_estado`)
VALUES (idLibro, lib_titulo, lib_autor, lib_editorial, lib_fecpub, lib_genero, lib_paginas, lib_cantidad, lib_cantidad, 1);
end&&
delimiter ;

call sp_Registrar_Libros('L00002','Nuevo Libro','A00004','E00002','1992/02/10','G00001',100,1,'I00001');

select * from libro;




/*

Procedure  Modificar Libros

*/

drop procedure if exists sp_Modificar_Libros;

delimiter &&
create procedure sp_Modificar_Libros(in id varchar(6),in titulo varchar(50),in autor varchar(6),in editorial varchar(6),in fecpub varchar(10),
									in genero varchar(6),in paginas int,in cantidad int,in idioma varchar(6))
begin
update Libro as l
set l.lib_titulo=titulo,l.lib_autor=autor,l.lib_editorial=editorial,l.lib_fecpub=fecpub,l.lib_genero=genero,l.lib_paginas=paginas,l.lib_cantidad=cantidad,l.lib_idioma=idioma
where l.idLibro=id;
end&&
delimiter ;

call sp_Modificar_Libros('L00002','Nuevo Libro modificado','A00004','E00002','1992/02/10','G00001',100,1,'I00001');

select * from libro;



/*

Procedure  Consultar Autor

*/

drop procedure if exists sp_consultar_Autor;

delimiter &&
create procedure sp_consultar_Autor(in nombre varchar(40),in apellido varchar(40))
begin
select * from autor
where autor_nombre like CONCAT ('%', nombre, '%')
and autor_apellido like CONCAT ('%', apellido, '%');
end&&
delimiter ;

call sp_consultar_Autor('','');

select * from Autor;


/*

Procedure  Consultar Editorial

*/

drop procedure if exists sp_consultar_Editorial;

delimiter &&
create procedure sp_consultar_Editorial(in nombre varchar(50))
begin
select * from editorial
where ed_nombre like CONCAT ('%', nombre, '%');
end&&
delimiter ;

call sp_consultar_Editorial('i');

select * from editorial;




/*

Procedure  Registrar Usuario

*/

drop procedure if exists sp_Registrar_Usuario;

delimiter &&
create procedure sp_Registrar_Usuario(in idUsuario varchar(8),in nombre varchar(45),in usu_apellido varchar(45),in usu_direccion varchar(100),in usu_telefono varchar(9),in usu_contraseña varchar(10))
begin
INSERT INTO `BD_BiBLIOTECA`.`Usuario` (`idUsuario`, `usu_nombre`, `usu_apellido`, `usu_direccion`, `usu_telefono`, `usu_contraseña`, `usu_estado`)
VALUES (idUsuario, nombre, usu_apellido, usu_direccion, usu_telefono, usu_contraseña, 1);
end&&
delimiter ;

call sp_Registrar_Usuario('76346254','Juan','Perez','Calle Juanito Alimaña 123','995524566','123456');
select * from usuario;



/*

Procedure  Registrar Reserva

*/

drop procedure if exists sp_Registrar_Registro;

delimiter &&
create procedure sp_Registrar_Registro(in idusuario varchar(8),in idlibro varchar(6))
begin
INSERT INTO `BD_BiBLIOTECA`.`Registro` (`idusuario`, `idlibro`, `reg_horareserva`, `reg_horadevolucion`)
VALUES (idusuario, idlibro, NOW(),null);
end&&
delimiter ;

call sp_Registrar_Registro('76346254','L00002');
select * from registro;

/*

Procedure  Registrar Reserva

*/

drop procedure if exists sp_Modificar_Registro;

delimiter &&
create procedure sp_Modificar_Registro(in id int)
begin
update Registro 
set reg_horadevolucion=now()
where idRegistro=id;
end&&
delimiter ;

call sp_Modificar_Registro(1);
select * from registro;


/*

Procedure  Listado Registros Inner Join

*/

drop procedure if exists sp_Consultar_Registro;

delimiter &&
create procedure sp_Consultar_Registro(in titulo varchar(50),in usuario varchar(8))
begin
select r.idRegistro,r.idlibro,l.lib_titulo,a.autor_nombre,a.autor_apellido,r.idusuario,u.usu_nombre,u.usu_apellido,r.reg_horareserva,r.reg_horadevolucion
from registro as r
inner join libro as l
on r.idlibro=l.idLibro
inner join usuario as u
on r.idusuario=u.idUsuario
inner join autor as a
on l.lib_autor=a.idautor
where l.lib_titulo like CONCAT ('%', titulo, '%')
and u.idusuario like CONCAT ('%', usuario, '%');
end&&
delimiter ;

call sp_Consultar_Registro('libro','76346254');


/*

Procedure  Listado Idiomas

*/

drop procedure if exists sp_Consultar_Idioma;

delimiter &&
create procedure sp_Consultar_Idioma()
begin
select * from idioma;
end&&
delimiter ;

call sp_Consultar_Idioma();



/*

Procedure  Listado Idiomas

*/

drop procedure if exists sp_Consultar_Genero;

delimiter &&
create procedure sp_Consultar_Genero()
begin
select * from genero;
end&&
delimiter ;

call sp_Consultar_Genero();

