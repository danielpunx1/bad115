

CREATE OR REPLACE PROCEDURE sp_pensum
(
  codigo_asignatura1 in PENSUM.CODIGO_ASIGNATURA%type,
  codigo_carrera1 IN PENSUM.CODIGO_CARRERA%type,
  tipo_materia1 in PENSUM.TIPO_MATERIA%type default 'obligatoria',
  ciclo1 in PENSUM.CICLO%type
)
IS
BEGIN
  insert into pensum (codigo_asignatura,codigo_carrera,tipo_materia,ciclo) 
  values (codigo_asignatura1,codigo_carrera1,tipo_materia1,ciclo1);
END sp_pensum;

-- AGREGANDOLE MATERIAS DE UN PENSUM

execute sp_pensum('MAT215','I10515','obligatoria',2);
execute sp_pensum('MAT115','I10515','obligatoria',1);
execute sp_pensum('FIR115','I10515','obligatoria',2);
execute sp_pensum('FIR215','I10515','obligatoria',3);


-- verificamos que una materia solo se pueda asociar una vez a un pensum

CREATE OR REPLACE TRIGGER tr_pensum_una_mat_por_carrera
BEFORE INSERT ON pensum
FOR EACH ROW
DECLARE
total integer;
BEGIN
    select count(*) into total from pensum where CODIGO_ASIGNATURA = :new.codigo_asignatura
    and CODIGO_CARRERA = :new.CODIGO_CARRERA;
    IF total > 0  THEN
       raise_application_error (-20600, 'La asignatura ' || :new.codigo_asignatura || ' ya esta registrada para la carrera ' || :new.codigo_carrera || ' ' );
     END IF;
END;

