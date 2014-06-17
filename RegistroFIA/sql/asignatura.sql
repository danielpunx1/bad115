
create or replace procedure sp_asignatura
(
    codigo_asignatura1 IN asignatura.codigo_asignatura%type,
    nombre_asignatura1 IN asignatura.nombre_asignatura%TYPE,
    generalidades1 IN asignatura.generalidades%type,
    descripcion1 IN asignatura.descripcion%type,
    objetivo1 IN asignatura.objetivo%type,
    uv_asignatura1 IN asignatura.uv_asignatura%type,
    bibliografia1 IN asignatura.bibliografia%type,
    justificacion1 IN asignatura.justificacion%type,
    recurso_lab1 IN asignatura.recurso_lab%type,
    recurso_tecnologico1 IN asignatura.recurso_tecnologico%type,
    recurso_otros1 IN asignatura.recurso_otros%type,
    perfil_docente1 IN asignatura.perfil_docente%type,
    visto_bueno1 IN asignatura.visto_bueno%type,
    aprobacion1 IN asignatura.aprobacion%type
)
IS
BEGIN
    INSERT INTO asignatura (codigo_asignatura,nombre_asignatura,generalidades,descripcion,objetivo,uv_asignatura,
    bibliografia,justificacion,recurso_lab,recurso_tecnologico,recurso_otros,perfil_docente,visto_bueno,aprobacion)
    values
    (codigo_asignatura1,nombre_asignatura1,generalidades1,descripcion1,objetivo1,uv_asignatura1,
    bibliografia1,justificacion1,recurso_lab1,recurso_tecnologico1,recurso_otros1,perfil_docente1,visto_bueno1,aprobacion1);
END sp_asignatura;


--- DATOS DE LA TABLA ASIGNATURA

execute sp_asignatura('MAT115','MATEMATICAS 1',null,null,null,4,null,null,null,null,null,null,1,1);
execute sp_asignatura('MAT215','MATEMATICAS 2',null,null,null,4,null,null,null,null,null,null,1,1);
execute sp_asignatura('MAT315','MATEMATICAS 3',null,null,null,4,null,null,null,null,null,null,1,1);
execute sp_asignatura('MAT415','MATEMATICAS 4',null,null,null,4,null,null,null,null,null,null,1,1);
execute sp_asignatura('FIR115','FISICA 1',null,null,null,4,null,null,null,null,null,null,1,1);
execute sp_asignatura('FIR215','FISICA 2',null,null,null,4,null,null,null,null,null,null,1,1);
execute sp_asignatura('FIR315','FISICA 3',null,null,null,4,null,null,null,null,null,null,1,1);
execute sp_asignatura('PRN115','PROGRAMACION 1',null,null,null,4,null,null,null,null,null,null,1,1);
execute sp_asignatura('PRN215','PROGRAMACION 2',null,null,null,4,null,null,null,null,null,null,1,1);
execute sp_asignatura('PRN315','PROGRAMACION 3',null,null,null,4,null,null,null,null,null,null,1,1);
execute sp_asignatura('HDP115','HERRAMIENTAS DE PRODUCTIVIDAD',null,null,null,4,null,null,null,null,null,null,1,1);
execute sp_asignatura('MTE115','METODOS EXPERIMENTALES',null,null,null,4,null,null,null,null,null,null,1,1);
execute sp_asignatura('PSI115','PSICOLOGIA SOCIAL',null,null,null,4,null,null,null,null,null,null,1,1);
execute sp_asignatura('HSE115','HISTORIA SOCIAL',null,null,null,4,null,null,null,null,null,null,1,1);
execute sp_asignatura('MSM115','MANEJO DE SOFTWARE',null,null,null,4,null,null,null,null,null,null,1,1);
execute sp_asignatura('FDE115','FUNDAMENTOS DE ECONOMIA',null,null,null,4,null,null,null,null,null,null,1,1);


-- FIN DE LOS DATOS DE LA TABLA ASIGNATURA

