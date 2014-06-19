
--CIERRA EL CICLO PARA CALCULAR CUM, PROMEDIO...

CREATE OR REPLACE PROCEDURE sp_cerrar_ciclo(VAR IN INTEGER)
IS
BEGIN
    update historial_materias set estado='aprobada' where estado='en curso' and nota_final >= 5.95;   
    update historial_materias set estado='reprobada' where estado='en curso' and nota_final < 5.95;
    delete from notas_ciclo; 
END sp_cerrar_ciclo;



--CALCULA EL CUM DESPUES DE CERRAR CICLO

CREATE OR REPLACE TRIGGER tr_expediente_cum
BEFORE DELETE ON notas_ciclo 
FOR EACH ROW
DECLARE
var integer;
var2 float;
var3 integer;
BEGIN
   select num_expediente into var from historial_materias where id_historial = :old.id_historial;
   select sum(nota_final) into var2 from historial_materias where estado='aprobada' and num_expediente = var;
   select count(*) into var3 from historial_materias where estado='aprobada' and num_expediente = var;   
   update expediente set cum=(var2/var3) where num_expediente = var;
END;

