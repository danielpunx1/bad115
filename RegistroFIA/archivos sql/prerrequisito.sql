
create or replace procedure sp_prerrequisito
(
    codigo_asignatura1 IN prerrequisito.codigo_asignatura%type,
    materia_rrequisito1 IN prerrequisito.materia_rrequisito%type
)
IS
BEGIN
    INSERT INTO prerrequisito (id,codigo_asignatura,materia_rrequisito) 
    VALUES (id_prerrequisito.nextval,codigo_asignatura1,materia_rrequisito1);
END sp_prerrequisito;

--para verifica que no se pueda ingresar dos veces una materia como prerrequisito para una misma materia

CREATE OR REPLACE TRIGGER tr_prerrequisito_no_repetir
BEFORE INSERT ON prerrequisito
FOR EACH ROW
DECLARE
total integer;
BEGIN
	IF :new.codigo_asignatura != :new.materia_rrequisito THEN
      select count(*) into total from prerrequisito where CODIGO_ASIGNATURA = :new.codigo_asignatura
      and MATERIA_RREQUISITO = :new.MATERIA_RREQUISITO;
      IF total > 0  THEN
         raise_application_error (-20600, 'La asignatura ' || :new.codigo_asignatura || ' ya tiene como requisito ' || :new.materia_rrequisito || ' ' );
      END IF;
  ELSE
      raise_application_error (-20600, 'La asignatura ' || :new.codigo_asignatura || ' NO puede ser requisito de ella misma ' );
  END IF;
END;


--ingresamos datos


execute sp_prerrequisito('FIR115','MAT115');
execute sp_prerrequisito('FIR115','MTE115');
execute sp_prerrequisito('HSE115','PSI115');
execute sp_prerrequisito('MAT215','MAT115');
execute sp_prerrequisito('MSM115','IAI115');
execute sp_prerrequisito('PRN115','IAI115');
execute sp_prerrequisito('MAT315','MAT215');
execute sp_prerrequisito('MAT415','MAT315');
execute sp_prerrequisito('FIR215','FIR115');
execute sp_prerrequisito('FIR215','MAT215');
execute sp_prerrequisito('FIR315','FIR215');
execute sp_prerrequisito('FIR315','MAT215');
execute sp_prerrequisito('FIR315','FIR115');


-- proc para retornar las materias requisitos de una materia y eliminarlas

create or replace PROCEDURE sp_pre_ret_eliminar
(
    materia IN PRERREQUISITO.CODIGO_ASIGNATURA%type,
    datos OUT SYS_REFCURSOR
)
AS
BEGIN
    open datos for
    select materia_rrequisito from prerrequisito where CODIGO_ASIGNATURA = materia;
END sp_pre_ret_eliminar;


-- Elminar las materias requisitos asociadas a una materia en especifico

CREATE OR REPLACE PROCEDURE sp_prerrequisito_eliminar
(
   codigo_asignatura1 IN PRERREQUISITO.CODIGO_ASIGNATURA%type,
   materia_rrequisito1 IN PRERREQUISITO.MATERIA_RREQUISITO%type
)
AS
BEGIN
    delete from prerrequisito where CODIGO_ASIGNATURA=codigo_asignatura1 and MATERIA_RREQUISITO=materia_rrequisito1;
END sp_prerrequisito_eliminar;


--procedimiento que retorna las asignaturas a usar para los prerrequisitos

CREATE OR REPLACE PROCEDURE sp_asignatura_retornar2
(
    datos OUT SYS_REFCURSOR
)
AS
BEGIN
    open datos for
    select distinct(codigo_asignatura) from prerrequisito;
END sp_asignatura_retornar2;








