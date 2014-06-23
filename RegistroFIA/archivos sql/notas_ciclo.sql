


CREATE SEQUENCE Id_Notas
START WITH 1
INCREMENT BY 1;

create or replace PROCEDURE sp_nota_ciclo_insert
(
    CARNET IN ALUMNO.CARNET%TYPE,CODIGO_MAT IN varchar2,
    EVAL IN EVALUACIONES.EVALUACION%TYPE,notax IN NOTAS_CICLO.NOTA%TYPE
)
IS
  id_eval number;
  id_histo number;
BEGIN
    SELECT id_evaluacion into id_eval FROM EVALUACIONES E
    WHERE E.CODIGO_ASIGNATURA=CODIGO_MAT AND E.EVALUACION=EVAL;

    SELECT ID_HISTORIAL INTO id_histo FROM EXPEDIENTE E
    INNER JOIN HISTORIAL_MATERIAS HM ON E.NUM_EXPEDIENTE=HM.NUM_EXPEDIENTE
    WHERE E.CARNET=CARNET AND HM.CODIGO_ASIGNATURA=CODIGO_MAT;

    INSERT INTO NOTAS_CICLO(ID_NOTA,ID_EVALUACION,ID_HISTORIAL,NOTA)VALUES(Id_Notas.nextval,id_eval,id_histo,notax);
END sp_nota_ciclo_insert;

-- ANDERSON INSERTAR NOTAS_CICLO
EXECUTE sp_nota_ciclo_insert('ru06003', 'MAT115', 1, 8.5);
EXECUTE sp_nota_ciclo_insert('ru06003', 'MAT115', 2, 7.5);
EXECUTE sp_nota_ciclo_insert('ru06003', 'MAT115', 3, 6.5);
EXECUTE sp_nota_ciclo_insert('ru06003', 'MAT115', 4, 9.5);

EXECUTE sp_nota_ciclo_insert('ru06003', 'MTE115', 1, 8);
EXECUTE sp_nota_ciclo_insert('ru06003', 'MTE115', 2, 7);
EXECUTE sp_nota_ciclo_insert('ru06003', 'MTE115', 3, 6);
EXECUTE sp_nota_ciclo_insert('ru06003', 'MTE115', 4, 7);
EXECUTE sp_nota_ciclo_insert('ru06003', 'MTE115', 5, 9);

EXECUTE sp_nota_ciclo_insert('ru06003', 'PSI115', 1, 8);
EXECUTE sp_nota_ciclo_insert('ru06003', 'PSI115', 2, 7);
EXECUTE sp_nota_ciclo_insert('ru06003', 'PSI115', 3, 6);
EXECUTE sp_nota_ciclo_insert('ru06003', 'PSI115', 4, 7);
EXECUTE sp_nota_ciclo_insert('ru06003', 'PSI115', 5, 7);


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


--RECUPERA LAS NOTAS DE UN ALUMNO X //ANDERSON
CREATE OR REPLACE PROCEDURE sp_notas_ciclo_recuperar(
	datos out SYS_REFCURSOR,
	icarnet in ALUMNO.CARNET%TYPE
)
AS
BEGIN
	OPEN datos FOR SELECT ex.carnet, ev.codigo_asignatura, ev.evaluacion, ev.porcentaje_evaluacion, nc.nota, nc.fecha_nota FROM notas_ciclo nc INNER JOIN evaluaciones ev
		ON nc.ID_EVALUACION=ev.ID_EVALUACION INNER JOIN historial_materias hm
		ON nc.ID_HISTORIAL=hm.ID_HISTORIAL INNER JOIN expediente ex
		ON hm.NUM_EXPEDIENTE=ex.NUM_EXPEDIENTE WHERE ex.CARNET=icarnet ORDER BY ev.codigo_asignatura ASC, ev.evaluacion ASC;
END sp_notas_ciclo_recuperar;


--ACTUALIZA LOS DATOS DE LAS NOTAS //GEOVA
create or replace PROCEDURE sp_nota_ciclo_update
(
    CARNETx IN ALUMNO.CARNET%TYPE,CODIGO_MAT IN varchar2,
    EVAL IN EVALUACIONES.EVALUACION%TYPE,notax IN NOTAS_CICLO.NOTA%TYPE
)
IS
    id_eval number;
    id_histo number;
BEGIN
    SELECT id_evaluacion into id_eval FROM EVALUACIONES E
    WHERE E.CODIGO_ASIGNATURA=CODIGO_MAT AND E.EVALUACION=EVAL;

    SELECT ID_HISTORIAL INTO id_histo FROM EXPEDIENTE E
    INNER JOIN HISTORIAL_MATERIAS HM ON E.NUM_EXPEDIENTE=HM.NUM_EXPEDIENTE
    WHERE E.CARNET=CARNETx AND HM.CODIGO_ASIGNATURA=CODIGO_MAT;

    UPDATE NOTAS_CICLO nt
    SET NOTA=notax where nt.ID_HISTORIAL= id_histo and nt.ID_EVALUACION=id_eval;
END sp_nota_ciclo_update;