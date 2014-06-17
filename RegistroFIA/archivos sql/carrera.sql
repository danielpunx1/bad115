
create or replace procedure sp_carrera
(
    codigo_carrera1 IN carrera.codigo_carrera%type,
    nombre_carrera1 IN carrera.nombre_carrera%type,
    uv_totales1 IN carrera.uv_totales%type default 0
)
AS
BEGIN
    insert into carrera (codigo_carrera,nombre_carrera,uv_totales)
    values (codigo_carrera1,nombre_carrera1,uv_totales1);
END sp_carrera;

-- LLENAMOS LA BASE

execute sp_carrera('I10515','INGENIERIA DE SISTEMAS');
execute sp_carrera('I10501','INGENIERIA CIVIL');
execute sp_carrera('I10502','INGENIERIA INDUSTRIAL');
execute sp_carrera('I10503','INGENIERIA MECANICA');
execute sp_carrera('I10504','INGENIERIA ELECTRICA');
execute sp_carrera('I10506','INGENIERIA QUIMICA');


-- PARA CALCULAR LAS UNIDADES TOTALES DE UNA CARRERA SEGUN PENSUM

CREATE OR REPLACE TRIGGER tr_carrera_uv_totales
AFTER INSERT ON pensum
FOR EACH ROW
DECLARE
suma_uv integer;
BEGIN
    select sum(asig.uv_asignatura) into suma_uv from asignatura asig
    inner join pensum p on p.CODIGO_ASIGNATURA=asig.CODIGO_ASIGNATURA
    where p.CODIGO_CARRERA = :new.codigo_carrera;
    update carrera set uv_totales=suma_uv where CODIGO_CARRERA = :new.codigo_carrera;
END;

