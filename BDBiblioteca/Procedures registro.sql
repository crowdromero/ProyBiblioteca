
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


call sp_consultar_Usuario('72696054','123456');



