
create or replace PACKAGE CURSORES AS
TYPE cursorDinamico IS REF CURSOR;

PROCEDURE OBTENER_DATOS(DUI IN VARCHAR2,LISTA IN OUT CURSORES.cursorDinamico);
PROCEDURE LLENAR_COMBO(CODIGO_ASIGNATURA IN VARCHAR2,LISTA2 OUT CURSORES.cursorDinamico);
PROCEDURE LLENAR_TEXTFIELDALUMNO(CODIGO_ASIGNATURA IN VARCHAR2,LISTA3 OUT CURSORES.cursorDinamico);
PROCEDURE LLENAR_TEXTFIELDALUMNO2(CODIGO_ASIGNATURA IN VARCHAR2,LISTA4 OUT CURSORES.cursorDinamico,
    eval IN EVALUACIONES.EVALUACION%TYPE);
PROCEDURE LLENAR_TEXTFIELDALUMNO3(CODIGO_ASIGNATURA IN VARCHAR2,cCarnet IN VARCHAR2,LISTA5 OUT CURSORES.cursorDinamico);
PROCEDURE Obtener_asignatura(Codigo IN VARCHAR2,LISTA6 OUT CURSORES.cursorDinamico);
END CURSORES;




create or replace PACKAGE BODY CURSORES AS

    PROCEDURE OBTENER_DATOS(DUI IN VARCHAR2,LISTA IN OUT CURSORES.cursorDinamico) IS
    LISTA2 CURSORES.cursorDinamico;
DUI2 varchar2(10) := DUI;
BEGIN
OPEN LISTA2 FOR
SELECT codigo_asignatura,estado_imparte  from historial_docente
where historial_docente.dui=DUI2;
LISTA:=LISTA2;
END OBTENER_DATOS;

PROCEDURE LLENAR_COMBO(CODIGO_ASIGNATURA IN VARCHAR2,LISTA2 OUT CURSORES.cursorDinamico) IS
    CODIGO varchar2(10):=CODIGO_ASIGNATURA;
    BEGIN
    OPEN LISTA2 FOR
    SELECT EVALUACION,PORCENTAJE_EVALUACION FROM EVALUACIONES
    WHERE EVALUACIONES.CODIGO_ASIGNATURA=CODIGO;
END LLENAR_COMBO;

PROCEDURE LLENAR_TEXTFIELDALUMNO(CODIGO_ASIGNATURA IN VARCHAR2,LISTA3 OUT CURSORES.cursorDinamico) IS
    CODIGO3 varchar2(10):=CODIGO_ASIGNATURA;
    BEGIN
    OPEN LISTA3 FOR
    select a.carnet,a.nombres,a.apellidos,nt.nota from alumno a inner join expediente ex on a.carnet=ex.carnet
           inner join historial_materias hm on ex.num_expediente=hm.num_expediente inner join notas_ciclo nt
           on hm.id_historial= nt.id_historial
    where hm.codigo_asignatura=CODIGO3;
END LLENAR_TEXTFIELDALUMNO;
PROCEDURE LLENAR_TEXTFIELDALUMNO2(CODIGO_ASIGNATURA IN VARCHAR2,LISTA4 OUT CURSORES.cursorDinamico,eval IN EVALUACIONES.EVALUACION%TYPE) IS
    CODIGO4 varchar2(10):=CODIGO_ASIGNATURA;
    EVALU NUMBER :=eval;
    BEGIN
    OPEN LISTA4 FOR
    select a.carnet,a.nombres,a.apellidos,nt.nota from alumno a inner join expediente ex on
        a.carnet=ex.carnet inner join historial_materias hm on ex.num_expediente=hm.num_expediente
        inner join notas_ciclo nt on hm.id_historial= nt.id_historial inner join evaluaciones eva on
        eva.id_evaluacion=nt.id_evaluacion
        where hm.codigo_asignatura=CODIGO4 and eva.evaluacion=EVALU;
END LLENAR_TEXTFIELDALUMNO2;
PROCEDURE LLENAR_TEXTFIELDALUMNO3(CODIGO_ASIGNATURA IN VARCHAR2,cCarnet IN VARCHAR2,LISTA5 OUT CURSORES.cursorDinamico) IS
    CODIGO4 varchar2(10):=CODIGO_ASIGNATURA;
    carn varchar2(8):=cCarnet;
    BEGIN
    OPEN LISTA5 FOR
    select a.nombres,a.apellidos,nt.nota from alumno a inner join expediente ex on a.carnet=ex.carnet
           inner join historial_materias hm on ex.num_expediente=hm.num_expediente inner join notas_ciclo nt
           on hm.id_historial= nt.id_historial
    where hm.codigo_asignatura=CODIGO4 and ex.carnet=carn;
END LLENAR_TEXTFIELDALUMNO3;

PROCEDURE Obtener_asignatura(Codigo IN VARCHAR2,LISTA6 OUT CURSORES.cursorDinamico) IS
Codigox varchar2(10) := Codigo;
BEGIN
OPEN LISTA6 FOR
SELECT *  from asignatura asig
where asig.CODIGO_ASIGNATURA=Codigox;
END Obtener_asignatura;

END CURSORES;

