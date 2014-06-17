
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