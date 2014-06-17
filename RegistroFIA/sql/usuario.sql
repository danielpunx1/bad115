
-- para insertar en la tabla usuario  DANIEL

CREATE OR REPLACE PROCEDURE sp_usuario_insertar 
(
  id_usuario1 in USUARIO.ID_USUARIO%type, id_perfil1 in USUARIO.ID_PERFIL%type, pass1 in USUARIO.PASS%type,
  estado_usuario1 in USUARIO.ESTADO_USUARIO%type DEFAULT 1
)
IS
BEGIN
  insert into usuario (id_usuario,id_perfil,pass,estado_usuario) values (id_usuario1,id_perfil1,pass1,estado_usuario1);
END sp_usuario_insertar;



-- para modificar los usuarios DANIEL

CREATE OR REPLACE PROCEDURE sp_usuario_modificar 
(
  id_usuario1 in USUARIO.ID_USUARIO%type, 
  pass1 in USUARIO.PASS%type,
  estado_usuario1 in USUARIO.ESTADO_USUARIO%type
)
IS
BEGIN
    update usuario set estado_usuario=estado_usuario1, pass=pass1 where id_usuario=id_usuario1;
END sp_usuario_modificar;