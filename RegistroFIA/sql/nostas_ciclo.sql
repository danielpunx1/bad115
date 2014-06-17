

CREATE SEQUENCE Id_Notas
START WITH 1
INCREMENT BY 1;

CREATE OR REPLACE PROCEDURE SP_Nota_Ciclo
(
  id_eval IN NOTAS_CICLO.ID_EVALUACION%TYPE,
  id_histo IN NOTAS_CICLO.ID_HISTORIAL%TYPE,
  notax IN NOTAS_CICLO.NOTA%TYPE)
IS
BEGIN
  INSERT INTO NOTAS_CICLO(ID_NOTA,ID_EVALUACION,ID_HISTORIAL,NOTA,FECHA_NOTA)VALUES(Id_Notas.nextval,id_eval,id_histo,notax,sysdate);
END SP_Nota_Ciclo;




-- no deja insertar dos veces la nota para una misma evaluacion   DANIEL

create or replace TRIGGER tr_no_repetir_evaluacion
BEFORE INSERT ON notas_ciclo
FOR EACH ROW
DECLARE
cantidad integer;
BEGIN
    select count(*) into cantidad from notas_ciclo where ID_EVALUACION = :new.id_evaluacion and ID_HISTORIAL = :new.id_historial;
    IF cantidad > 0  THEN
       raise_application_error (-20600, 'La Nota correspondiente a la evaluacion ya fue ingresada' );
     END IF;
END;



