

CREATE SEQUENCE id_historial
START WITH 1
INCREMENT BY 1;

CREATE OR REPLACE PROCEDURE sp_historial_materias
(
	v_codigo_asignatura in HISTORIAL_MATERIAS.CODIGO_ASIGNATURA%TYPE,
	v_num_expediente in HISTORIAL_MATERIAS.NUM_EXPEDIENTE%TYPE,
	v_nota_final in HISTORIAL_MATERIAS.NOTA_FINAL%TYPE DEFAULT 0.0,
	v_matricula in HISTORIAL_MATERIAS.MATRICULA%TYPE DEFAULT 1,
	v_estado in HISTORIAL_MATERIAS.ESTADO%TYPE DEFAULT 'en curso',
	v_year_ciclo in HISTORIAL_MATERIAS.YEAR_CICLO%TYPE,
	v_ciclo in HISTORIAL_MATERIAS.CICLO%TYPE DEFAULT 0
)
IS
BEGIN
	INSERT INTO historial_materias(id_historial,codigo_asignatura,num_expediente,nota_final, matricula, estado, year_ciclo, ciclo)
	VALUES (id_historial.nextval,v_codigo_asignatura,v_num_expediente, v_nota_final, v_matricula, v_estado, v_year_ciclo, v_ciclo);
END sp_historial_materias;




--trigger q calcula si la lleva en primera o en segunda DANIEL

--CREATE OR REPLACE TRIGGER matricula_materia
--BEFORE INSERT ON historial_materias
--FOR EACH ROW
--DECLARE 
--total integer;
--ciclos integer;
--cursada integer;
--BEGIN 
-- select count(*) into cursada from historial_materias where CODIGO_ASIGNATURA = :new.CODIGO_ASIGNATURA 
-- and num_expediente = :new.num_expediente and estado='en curso' or estado='aprobada';
-- IF cursada < 1 THEN
--     select count(*) into total from historial_materias where CODIGO_ASIGNATURA = :new.CODIGO_ASIGNATURA
--     and num_expediente = :new.num_expediente and estado='reprobada';
--     :new.matricula := (total+1);
--     select pensum.ciclo into ciclos from pensum where pensum.codigo_asignatura = :new.CODIGO_ASIGNATURA;
--     :new.ciclo := ciclos;
--     IF :new.matricula > 4  THEN
--       raise_application_error (-20600, 'La materia ' || :new.codigo_asignatura || ' ya fue reprobada 3 veces' );
--     END IF;
-- ELSE
--     raise_application_error (-20600,'La materia ' || :new.codigo_asignatura || ' ya fue aprobada o se encuentra en curso');
-- END IF;
--END;


CREATE OR REPLACE TRIGGER matricula_materia
BEFORE INSERT ON historial_materias
FOR EACH ROW
DECLARE 
total integer;
ciclos integer;
cursada integer;
requisitos integer;
cumple_requisito integer;
BEGIN 
 select count(*) into cursada from historial_materias where CODIGO_ASIGNATURA = :new.CODIGO_ASIGNATURA 
 and num_expediente = :new.num_expediente and estado='en curso' or estado='aprobada';
 
 select count(*) into requisitos from prerrequisito where codigo_asignatura = :new.codigo_asignatura;
 
 IF requisitos != 0 THEN
       select count(*) into cumple_requisito from HISTORIAL_MATERIAS where codigo_asignatura 
       IN ( select materia_rrequisito from prerrequisito where codigo_asignatura = :new.codigo_asignatura) 
       and estado = 'aprobada';
       
       IF requisitos != cumple_requisito THEN
               raise_application_error (-20600,'Debe tener aprobadas todas las materias requisito para poder inscribir : ' || :new.codigo_asignatura || ' ');
       ELSE
               IF cursada < 1 THEN
                   select count(*) into total from historial_materias where CODIGO_ASIGNATURA = :new.CODIGO_ASIGNATURA
                   and num_expediente = :new.num_expediente and estado='reprobada';
                   :new.matricula := (total+1);
                   select pensum.ciclo into ciclos from pensum where pensum.codigo_asignatura = :new.CODIGO_ASIGNATURA;
                   :new.ciclo := ciclos;
                   IF :new.matricula > 4  THEN
                     raise_application_error (-20600, 'La materia ' || :new.codigo_asignatura || ' ya fue reprobada 3 veces' );
                   END IF;
               ELSE
                   raise_application_error (-20600,'La materia ' || :new.codigo_asignatura || ' ya fue aprobada o se encuentra en curso');
               END IF;
       END IF;
 ELSE
       IF cursada < 1 THEN
            select count(*) into total from historial_materias where CODIGO_ASIGNATURA = :new.CODIGO_ASIGNATURA
            and num_expediente = :new.num_expediente and estado='reprobada';
            :new.matricula := (total+1);
            select pensum.ciclo into ciclos from pensum where pensum.codigo_asignatura = :new.CODIGO_ASIGNATURA;
            :new.ciclo := ciclos;
            IF :new.matricula > 4  THEN
                 raise_application_error (-20600, 'La materia ' || :new.codigo_asignatura || ' ya fue reprobada 3 veces' );
            END IF;
       ELSE
                 raise_application_error (-20600,'La materia ' || :new.codigo_asignatura || ' ya fue aprobada o se encuentra en curso');
       END IF;
 END IF;
END;


-- calcula la nota despues de insertar en NOTAS_CICLO   DANIEL

create or replace TRIGGER tr_nota_final
AFTER INSERT ON notas_ciclo
FOR EACH ROW
DECLARE
porcen float;
BEGIN
    select ev.PORCENTAJE_EVALUACION into porcen from evaluaciones ev
    where ev.ID_EVALUACION = :new.ID_EVALUACION;
    update historial_materias set nota_final=nota_final+( :new.nota * porcen ) where id_historial = :new.id_historial;
END;


--RETORNA EL HISTORIAL DE MATERIAS DE X ALUMNO
CREATE OR REPLACE PROCEDURE sp_h_materias_recuperar(
	datos out SYS_REFCURSOR,
	icarnet in ALUMNO.CARNET%TYPE
)
AS
BEGIN
	OPEN datos FOR SELECT ex.carnet, hm.codigo_asignatura, hm.matricula, hm.nota_final, hm.estado, hm.year_ciclo 
	FROM historial_materias hm INNER JOIN expediente ex
		ON hm.NUM_EXPEDIENTE=ex.NUM_EXPEDIENTE WHERE ex.CARNET=icarnet;
END sp_h_materias_recuperar;




