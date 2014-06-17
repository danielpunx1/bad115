
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

