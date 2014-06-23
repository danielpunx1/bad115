
CREATE SEQUENCE id_evaluaciones_insert 
START WITH 1
INCREMENT BY 1;

CREATE OR REPLACE PROCEDURE sp_evaluaciones
(
  codigo_asignatura1 in EVALUACIONES.CODIGO_ASIGNATURA%type, 
  porcentaje_evaluacion1 in EVALUACIONES.PORCENTAJE_EVALUACION%type
)
IS
BEGIN
  insert into evaluaciones (id_evaluacion,codigo_asignatura,evaluacion,porcentaje_evaluacion)
  values (id_evaluaciones.nextval,codigo_asignatura1,0,porcentaje_evaluacion1);
END sp_evaluaciones;


-- Asigna el nombre de la evaluacion es decir si es 1 , 2 , 3 y no permite q se pase del 100 la sumatoria de los porcentajes

create or replace trigger tr_evaluaciones_numer
BEFORE INSERT ON evaluaciones
FOR EACH ROW
DECLARE
total integer;
porcentotal float;
BEGIN
    select count(*) into total from evaluaciones where CODIGO_ASIGNATURA = :new.CODIGO_ASIGNATURA;
    :new.evaluacion := (total+1);
    select sum(porcentaje_evaluacion) into porcentotal from evaluaciones where CODIGO_ASIGNATURA = :new.CODIGO_ASIGNATURA;
    IF (porcentotal + :new.porcentaje_evaluacion) > 1.01 THEN
         raise_application_error (-20600, 'Error el porcentaje supero el 100%. Porcentaje disponible : ' || ( :new.porcentaje_evaluacion - ((porcentotal + :new.porcentaje_evaluacion)-1)) || ' ' ); 
    END IF;
END;


EXECUTE sp_evaluaciones_insert('MTE115',0.20);
EXECUTE sp_evaluaciones_insert('MTE115',0.20);
EXECUTE sp_evaluaciones_insert('MTE115',0.20);
EXECUTE sp_evaluaciones_insert('MTE115',0.20);
EXECUTE sp_evaluaciones_insert('MTE115',0.20);

EXECUTE sp_evaluaciones_insert('MAT115',0.25);
EXECUTE sp_evaluaciones_insert('MAT115',0.25);
EXECUTE sp_evaluaciones_insert('MAT115',0.25);
EXECUTE sp_evaluaciones_insert('MAT115',0.25);

EXECUTE sp_evaluaciones_insert('IAI115',0.20);
EXECUTE sp_evaluaciones_insert('IAI115',0.20);
EXECUTE sp_evaluaciones_insert('IAI115',0.20);
EXECUTE sp_evaluaciones_insert('IAI115',0.20);
EXECUTE sp_evaluaciones_insert('IAI115',0.10);
EXECUTE sp_evaluaciones_insert('IAI115',0.10);

EXECUTE sp_evaluaciones_insert('PSI115',0.20);
EXECUTE sp_evaluaciones_insert('PSI115',0.20);
EXECUTE sp_evaluaciones_insert('PSI115',0.20);
EXECUTE sp_evaluaciones_insert('PSI115',0.20);
EXECUTE sp_evaluaciones_insert('PSI115',0.20);


