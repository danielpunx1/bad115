
-- crea el procedimeinto par insertar DANIEL
CREATE OR REPLACE PROCEDURE sp_alumno 
(
carnet1 in alumno.carnet%type, id_usuario1 in ALUMNO.ID_USUARIO%type, nombres1 in ALUMNO.NOMBRES%type, apellidos1 in ALUMNO.APELLIDOS%type,
fecha_nac1 in ALUMNO.FECHA_NAC%type, direccion1 in ALUMNO.DIRECCION%type, email1 in ALUMNO.EMAIL%type, tipo_sangre1 in ALUMNO.TIPO_SANGRE%type,
num_emergencia1 in ALUMNO.NUM_EMERGENCIA%type, nombre_madre1 in ALUMNO.NOMBRE_MADRE%type, nombre_padre1 in ALUMNO.NOMBRE_PADRE%type
) 
IS
BEGIN
  insert into alumno (carnet,id_usuario,nombres,apellidos,fecha_nac,direccion,email,tipo_sangre,num_emergencia,nombre_madre,nombre_padre) 
  values (carnet1,id_usuario1,nombres1,apellidos1,fecha_nac1,direccion1,email1,tipo_sangre1,num_emergencia1,nombre_madre1,nombre_padre1);
END sp_alumno;

CREATE OR REPLACE PROCEDURE sp_alumno_modificar 
(
carnet1 in alumno.carnet%type, 
nombres1 in ALUMNO.NOMBRES%type, 
apellidos1 in ALUMNO.APELLIDOS%type,
fecha_nac1 in ALUMNO.FECHA_NAC%type, 
direccion1 in ALUMNO.DIRECCION%type, 
email1 in ALUMNO.EMAIL%type, 
tipo_sangre1 in ALUMNO.TIPO_SANGRE%type,
num_emergencia1 in ALUMNO.NUM_EMERGENCIA%type, 
nombre_madre1 in ALUMNO.NOMBRE_MADRE%type, 
nombre_padre1 in ALUMNO.NOMBRE_PADRE%type
) 
IS
BEGIN
  update alumno set nombres=nombres1,apellidos=apellidos1,fecha_nac=fecha_nac1,
  direccion=direccion1,email=email1,tipo_sangre=tipo_sangre1,num_emergencia=num_emergencia1,
  nombre_madre=nombre_madre1,nombre_padre=nombre_padre1 where carnet=carnet1;
END sp_alumno_modificar;


-- RETORNA LOS ALUMNOS DANIEL
create or replace procedure sp_alumnos_retornar
(
  datos out SYS_REFCURSOR,
  carnet1 in ALUMNO.CARNET%type DEFAULT 'NO'
)
as
begin
  if carnet1 != 'NO' THEN
      open datos for
      select carnet,nombres,apellidos,fecha_nac,direccion,email,tipo_sangre,num_emergencia,nombre_madre,nombre_padre 
      from alumno where carnet = carnet1;
  ELSE
      open datos for
      select carnet from alumno;
  END IF;
end sp_alumnos_retornar;


-- no deja meter dos veces el mismo carnet    DANIEL

create or replace TRIGGER tr_no_repetir_alumno
BEFORE INSERT ON alumno
FOR EACH ROW
DECLARE
cantidad integer;
BEGIN
    select count(*) into cantidad from alumno where carnet = :new.carnet;
    IF cantidad > 0  THEN
       raise_application_error (-20600, 'El carnet del alumno ya se encuentra registrado' );
     END IF;
END;



