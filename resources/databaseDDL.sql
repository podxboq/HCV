create table MASCOTAS
	(
		ID             BIGINT auto_increment,
		ESPECIE        CHARACTER VARYING(100) not null,
		RAZA           CHARACTER VARYING(100),
		EDAD           INTEGER,
		CODIGO         CHARACTER VARYING(10),
		RESPONSABLE_ID CHARACTER VARYING(20)  not null,
		F_BAJA         DATE,
		constraint PK_MASCOTAS
			primary key (ID)
	);

create index MASCOTAS_ID_INDEX
	on MASCOTAS (ID);
create index MASCOTAS_RESPONSABLE_INDEX
	on MASCOTAS (RESPONSABLE_ID);

create table INGRESOS
	(
		ID             BIGINT auto_increment,
		F_ALTA         DATE                  not null,
		F_BAJA         DATE,
		F_ANULA        DATE,
		ID_MASCOTA     BIGINT                not null,
		RESPONSABLE_ID CHARACTER VARYING(20) not null,
		constraint PK_INGRESOS
			primary key (ID),
		constraint FK_INGRESOS_MASCOTAS
			foreign key (ID_MASCOTA) references MASCOTAS
	);

create index INGRESOS_ID_INDEX
	on INGRESOS (ID);
create index INGRESOS_RESPONSABLE_INDEX
	on INGRESOS (RESPONSABLE_ID);