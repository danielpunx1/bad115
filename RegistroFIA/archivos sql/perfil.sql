


CREATE OR REPLACE SEQUENCE id_perfiles
START WITH 1
INCREMENT BY 1;

CREATE OR REPLACE PROCEDURE sp_perfil 
(
  perfil1 in PERFIL.PERFIL%type
)
IS
BEGIN
  insert into perfil (ID_PERFIL,perfil) values (s_perfil.nextval,perfil1);
END sp_perfil;

execute sp_perfil('administrador');
execute sp_perfil('docente');
execute sp_perfil('alumno');


-- NO deja insertar dos veces el mismo perfil     DANIEL

create or replace TRIGGER tr_no_repetir_perfil
BEFORE INSERT ON perfil
FOR EACH ROW
DECLARE
cantidad integer;
BEGIN
    select count(*) into cantidad from perfil where perfil = :new.perfil;
    IF cantidad > 0  THEN
       raise_application_error (-20600, 'El perfil ya se encuentra registrado' );
     END IF;
END;


--retorna los datos del perfil

create or replace procedure sp_retornar_perfiles
(
  datos out SYS_REFCURSOR
)
as
begin
  open datos for
  select id_perfil,perfil from perfil;
end sp_retornar_perfiles;


