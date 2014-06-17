

CREATE OR REPLACE PROCEDURE sp_pensum
(
  codigo_asignatura1 in PENSUM.CODIGO_ASIGNATURA%type,
  codigo_carrera1 IN PENSUM.CODIGO_CARRERA%type,
  tipo_materia1 in PENSUM.TIPO_MATERIA%type,
  ciclo1 in PENSUM.CICLO%type
)
IS
BEGIN
  insert into pensum (codigo_asignatura,codigo_carrera,tipo_materia,ciclo) 
  values (codigo_asignatura1,codigo_carrera1,tipo_materia1,ciclo1);
END sp_pensum;

