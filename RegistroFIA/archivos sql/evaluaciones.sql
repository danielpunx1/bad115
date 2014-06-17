
CREATE SEQUENCE id_evaluaciones 
START WITH 1
INCREMENT BY 1;

CREATE OR REPLACE PROCEDURE sp_evaluaciones
(
  codigo_asignatura1 in EVALUACIONES.CODIGO_ASIGNATURA%type, evaluacion1 in EVALUACIONES.EVALUACION%type,
  porcentaje_evaluacion1 in EVALUACIONES.PORCENTAJE_EVALUACION%type
)
IS
BEGIN
  insert into evaluaciones (id_evaluacion,codigo_asignatura,evaluacion,porcentaje_evaluacion)
  values (id_evaluaciones.nextval,codigo_asignatura1,evaluacion1,porcentaje_evaluacion1);
END sp_evaluaciones;


-- Asigna el nombre de la evaluacion es decir si es EV1 EV2 EV3



