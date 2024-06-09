create database universidad

create table usuario
(
	id serial primary key,
	ci varchar(15) not null,
	nombre varchar(60) not null,
	apellidos varchar(150),
	usuario varchar(50) not null,
	password varchar(254) not null,
	telefono varchar(14) null,
	sexo boolean not null,  --false hombre/ true mujer
	rol boolean not null --0 admin / 1 docente
	--foreign key (rol_id) references rol(id)on delete cascade on update cascade
);
create table registro
(
	id serial primary key,
	usuario_id integer,
	timestamps timestamp not null,
	tipo_check varchar(3) not null, --in | out
	device varchar(15) not null,
	foreign key(usuario_id) references usuario(id)
);
-- *******************************
create table carrera
(
	id serial primary key,
	nombre varchar(100) not null,
	sigla varchar(50) not null,
	jefe_carrera integer null,
	sistema_academico varchar(1) not null -- A=anual * S=semestral
);
create table materia
(
	id serial primary key,
	nombre varchar(100) not null,
	sigla varchar(50) not null,
	carrera_id integer not null,
	foreign key(carrera_id)references carrera(id)on delete cascade on update cascade
);
create table grupo
(
	id serial primary key,
	nombre varchar(100) not null,
	sigla varchar(50) not null
);
create table materia_grupo
(
	id serial primary key,
	materia_id integer,
	grupo_id integer,
	foreign key (materia_id) references materia(id) on delete cascade on update cascade,
	foreign key (grupo_id) references grupo(id) on delete cascade on update cascade
);
create table modulo
(
	id serial primary key,
	nombre varchar(150) not null,
	latitud float NOT NULL,
    longitud float NOT NULL,
	facultad varchar(150)not null
);
create table dia
(
	id serial primary key,
	nombre varchar(20) not null
);
create table aula
(
	id serial primary key,
	nombre varchar(50)not null,
	piso varchar(15)null,
	modulo_id integer not null,
	foreign key(modulo_id) references modulo(id) on delete cascade on update cascade
);
create table grupo_aula
(
	id serial primary key,
	materia_grupo_id integer,
	aula_id integer,
	dia_id integer,
	hora_inicio time not null,
	hora_fin time not null,
	foreign key (materia_grupo_id) references materia_grupo(id) on delete cascade on update cascade,
	foreign key (dia_id) references dia(id) on delete cascade on update cascade,
	foreign key (aula_id) references aula(id) on delete cascade on update cascade
);
--***************************
create table gestion
(
	id serial primary key,
	anio integer not null,
	fecha_ini date not null,
	fecha_fin date not null
);
create table periodo
(
	id serial primary key,
	nombre varchar(50)not null
);
create table gestion_periodo
(
	id serial primary key,
	gestion_id integer not null,
	periodo_id integer not null,
	inicio_clase date not null,
	fin_clase date not null,
	evaluacion1 date null,
	evaluacion2 date null,
	evaluacion3 date null,
	foreign key (gestion_id) references gestion(id) on delete cascade on update cascade,
	foreign key (periodo_id) references periodo(id) on delete cascade on update cascade
);
-- **********
create table grupo_asignado
(
	id serial primary key,
	horas_asignadas time null,
	usuario_id integer,
	gestion_periodo_id integer,
	--periodo_id integer,
	materia_grupo_id integer,
	--grupo_id integer,
	foreign key (usuario_id) references usuario(id) on delete cascade on update cascade,
	foreign key (gestion_periodo_id) references gestion_periodo(id) on delete cascade on update cascade,
	foreign key (materia_grupo_id) references materia_grupo(id) on delete cascade on update cascade
);

-- ********************
insert into usuario(ci,nombre,apellidos,usuario,password,telefono,sexo,rol)values(777775,'pedro','lopez heredia', 'pedro1','123456','70015515',false,false); --1
insert into usuario(ci,nombre,apellidos,usuario,password,telefono,sexo,rol)values(777563,'jose','camacho', 'jose1','123456','755132',false,true); --2
insert into usuario(ci,nombre,apellidos,usuario,password,telefono,sexo,rol)values(757563,'miguel','alcon', 'alcon1','123456','7537315',false,true); --3
insert into usuario(ci,nombre,apellidos,usuario,password,telefono,sexo,rol)values(777863,'maria','suares', 'maria1','123456','7553565',true,true); --4

-- ************************
insert into carrera(nombre,sigla,jefe_carrera,sistema_academico)values('Informatica','187-3',null,'S');  --1
insert into carrera(nombre,sigla,jefe_carrera,sistema_academico)values('Redes','187-2',1,'S'); -- 2
insert into carrera(nombre,sigla,jefe_carrera,sistema_academico)values('Sistema','187-3',null,'S');  --3
-- ********************
insert into materia(nombre,sigla,carrera_id)values('calculo I','MAT101',1); -- 1
insert into materia(nombre,sigla,carrera_id)values('introduccion','INF101',1); -- 2
insert into materia(nombre,sigla,carrera_id)values('ingles','LEN101',1); -- 3
insert into materia(nombre,sigla,carrera_id)values('estructura','INF102',1); -- 4
insert into materia(nombre,sigla,carrera_id)values('fisica 1','FIS101',1); -- 5

-- ********************
insert into grupo(nombre,sigla)values('Z1','Z1'); -- 1

-- ******************** Z1
insert into materia_grupo(materia_id,grupo_id)values(1,1); -- calculo I
insert into materia_grupo(materia_id,grupo_id)values(2,1); -- introduccion
insert into materia_grupo(materia_id,grupo_id)values(3,1); -- ingles
insert into materia_grupo(materia_id,grupo_id)values(4,1); -- estructura
insert into materia_grupo(materia_id,grupo_id)values(5,1); -- fisica

-- ********************
insert into modulo(nombre,latitud,longitud,facultad)values('facultad de ciencias de la informacion y telecomunicaciones',-152.546213,543.5412,'FICCT');
-- ********************
insert into aula(nombre,piso,modulo_id)values('10','1',1); --1
insert into aula(nombre,piso,modulo_id)values('11','1',1); --2
insert into aula(nombre,piso,modulo_id)values('12','1',1); --3
insert into aula(nombre,piso,modulo_id)values('13','1',1); --4
insert into aula(nombre,piso,modulo_id)values('14','1',1); --5
insert into aula(nombre,piso,modulo_id)values('15','1',1); --6
insert into aula(nombre,piso,modulo_id)values('46','4',1); --7
insert into aula(nombre,piso,modulo_id)values('40','4',1); --8
insert into aula(nombre,piso,modulo_id)values('41','4',1); --9
insert into aula(nombre,piso,modulo_id)values('42','4',1); --10
insert into aula(nombre,piso,modulo_id)values('Auditorio','4',1); --11
-- ********************
insert into dia(nombre)values('lunes');
insert into dia(nombre)values('martes');
insert into dia(nombre)values('miercoles');
insert into dia(nombre)values('jueves');
insert into dia(nombre)values('viernes');
insert into dia(nombre)values('sabado');
-- ********************
-- ********************calculo -1
insert into grupo_aula(materia_grupo_id,aula_id,hora_inicio,hora_fin,dia_id)values(1,2,'07:00:00','08:30:00',1);
insert into grupo_aula(materia_grupo_id,aula_id,hora_inicio,hora_fin,dia_id)values(1,2,'07:00:00','08:30:00',3);
insert into grupo_aula(materia_grupo_id,aula_id,hora_inicio,hora_fin,dia_id)values(1,3,'07:00:00','08:30:00',5);
-- ********************intro -2
insert into grupo_aula(materia_grupo_id,aula_id,hora_inicio,hora_fin,dia_id)values(2,2,'08:31:00','10:00:00',1);
insert into grupo_aula(materia_grupo_id,aula_id,hora_inicio,hora_fin,dia_id)values(2,2,'08:31:00','10:00:00',3);
insert into grupo_aula(materia_grupo_id,aula_id,hora_inicio,hora_fin,dia_id)values(2,3,'08:31:00','10:00:00',5);
-- ********************ingles -3
insert into grupo_aula(materia_grupo_id,aula_id,hora_inicio,hora_fin,dia_id)values(3,2,'10:01:00','12:00:00',1);
insert into grupo_aula(materia_grupo_id,aula_id,hora_inicio,hora_fin,dia_id)values(3,2,'10:01:00','12:00:00',3);
insert into grupo_aula(materia_grupo_id,aula_id,hora_inicio,hora_fin,dia_id)values(3,3,'10:01:00','12:00:00',5);
-- ********************estructura -4
insert into grupo_aula(materia_grupo_id,aula_id,hora_inicio,hora_fin,dia_id)values(4,2,'07:00:00','09:00:00',2);
insert into grupo_aula(materia_grupo_id,aula_id,hora_inicio,hora_fin,dia_id)values(4,2,'07:00:00','09:00:00',4);
-- ********************fisica -5
insert into grupo_aula(materia_grupo_id,aula_id,hora_inicio,hora_fin,dia_id)values(5,10,'09:01:00','12:00:00',2);
insert into grupo_aula(materia_grupo_id,aula_id,hora_inicio,hora_fin,dia_id)values(5,10,'09:01:00','12:00:00',4);
insert into grupo_aula(materia_grupo_id,aula_id,hora_inicio,hora_fin,dia_id)values(5,11,'13:01:00','15:30:00',5);
-- 0000
-- ********************
insert into gestion(anio,fecha_ini,fecha_fin)values(2024,'2024-03-15','2024-12-20');
-- ********************
insert into periodo(nombre)values('semestre 1');
insert into periodo(nombre)values('semestre 2');
insert into periodo(nombre)values('mesa examinadora');
insert into periodo(nombre)values('verano');
-- ********************
insert into gestion_periodo(gestion_id,periodo_id,inicio_clase,fin_clase,evaluacion1,evaluacion2,evaluacion3)values(1,1,'2024-03-05','2024-05-28','2024-04-18',null,null);
-- ********************
insert into grupo_asignado(usuario_id,gestion_periodo_id,materia_grupo_id)values(2,1,1);
insert into grupo_asignado(usuario_id,gestion_periodo_id,materia_grupo_id)values(2,1,2);
insert into grupo_asignado(usuario_id,gestion_periodo_id,materia_grupo_id)values(3,1,5);
-- ********************
insert into registro(usuario_id,timestamps,tipo_check,device) values(1,now(),'in','movil');
insert into registro(usuario_id,timestamps,tipo_check,device) values(1,now(),'out','movil');



select * from grupo_aula
select * from materia_grupo
select * from grupo_asignado

drop table grupo_asignado;
--  ++++++++++++++++++
drop table registro;
drop table usuario;
--  ++++++++++++++++++
drop table grupo_aula;
drop table dia;
drop table aula;
drop table modulo;
drop table materia_grupo;
drop table materia;
drop table grupo;
drop table carrera;
--  ++++++++++++++++++
drop table gestion_periodo;
drop table gestion;
drop table periodo;

-- grupos de materia fisica
select m.nombre, g.nombre
from materia_grupo mg
JOIN materia m ON mg.materia_id = m.id
join grupo g on mg.grupo_id = g.id
where m.nombre = 'fisica II'


select m.nombre, g.nombre, d.nombre,ga.hora_inicio,ga.hora_fin, a.nombre
from grupo_aula ga
join materia_grupo mg on ga.materia_grupo_id=mg.id
join grupo g on mg.grupo_id = g.id
JOIN materia m ON mg.materia_id = m.id
join dia d on ga.dia_id = d.id
join aula a on ga.aula_id = a.id
where m.nombre = 'fisica II'


SELECT 
    m.nombre AS materia,
    g.nombre AS grupo,
    a.nombre AS aula,
    a.piso AS piso,
    ga.hora_inicio,
    ga.hora_fin,
    d.nombre AS dia
FROM 
    grupo_aula ga
JOIN 
    materia_grupo mg ON ga.materia_grupo_id = mg.id
JOIN 
    materia m ON mg.materia_id = m.id
JOIN 
    grupo g ON mg.grupo_id = g.id
JOIN 
    aula a ON ga.aula_id = a.id
JOIN 
    dia d ON ga.dia_id = d.id
WHERE d.nombre = 'sabado'






