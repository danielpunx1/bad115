
CREATE USER notasfia IDENTIFIED BY 1234567;
GRANT CONNECT, RESOURCE TO notasfia;

CREATE ROLE palumnos;
GRANT CONNECT TO palumnos;
GRANT SELECT ON notasfia.usuario TO palumnos;
GRANT SELECT,INSERT ON notasfia.historial_materias TO palumnos;
--GRANT SELECT ON notasfia.asignatura TO palumnos;
--GRANT SELECT ON notasfia.prerrequisito TO palumnos;
GRANT CONNECT TO palumnos;

CREATE USER alumno IDENTIFIED BY 1234567;
GRANT palumnos TO alumno;

CREATE ROLE pdocentes;
GRANT CONNECT TO palumnos;
GRANT CONNECT TO palumnos;

create user docente identified by docente;
grant connect to docente;
grant execute on basenotas.sp_perfil_insert to docente;





==============================================================
			ALUMNO Y SU ROL
==============================================================
CREATE USER perfil1 IDENTIFIED BY perfil1;

CREATE ROL alumnos;

GRANT CREATE SESSION TO alumnos;
GRANT EXECUTE ON tareabase.SP_H_MATERIAS_RECUPERAR to alumnos;
GRANT EXECUTE ON tareabase.sp_notas_ciclo_recuperar to alumnos;
GRANT EXECUTE ON tareabase.SP_H_MATERIAS_INSERT to alumnos;
GRANT EXECUTE ON tareabase.SP_H_MATERIAS_RECUPERAR to alumnos;

GRANT alumnos TO perfil1;

==============================================================
			DOCENTE Y SU ROL
==============================================================
CREATE USER perfil2
IDENTIFIED BY perfil2;

CREATE ROL docentes;

GRANT CREATE SESSION TO docentes;
GRANT EXECUTE ON tareabase.sp_asignatura_insert TO docentes;
GRANT EXECUTE ON tareabase.sp_asignatura_update TO docentes;
GRANT EXECUTE ON tareabase.sp_alumno_carnet TO docentes;
GRANT EXECUTE ON tareabase.sp_nota_ciclo_insert TO docentes;
GRANT EXECUTE ON tareabase.sp_notas_ciclo_recuperar TO docentes;
GRANT EXECUTE ON tareabase.sp_nota_ciclo_update TO docentes; 
GRANT EXECUTE ON tareabase.CURSORES.OBTENER_DATOS TO docentes;   
GRANT EXECUTE ON tareabase.CURSORES.LLENAR_COMBO TO docentes;
GRANT EXECUTE ON tareabase.CURSORES.CURSORES.LLENAR_TEXTFIELDALUMNO TO docentes;
GRANT EXECUTE ON tareabase.CURSORES.LLENAR_TEXTFIELDALUMNO2 TO docentes;
GRANT EXECUTE ON tareabase.CURSORES.LLENAR_TEXTFIELDALUMNO3 TO docentes;
GRANT EXECUTE ON tareabase.SP_PRERREQUISITO_INSERT TO docentes;
GRANT EXECUTE ON tareabase.sp_pre_ret_eliminar TO docentes;
GRANT EXECUTE ON tareabase.sp_asignatura_retornar2 TO docentes;
GRANT EXECUTE ON tareabase.SP_EVALUACIONES_INSERT TO docentes;


GRANT docentes TO perfil2;
