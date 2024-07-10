create table PUBLIC.MASCOTAS
	(
		ID             BIGINT auto_increment,
		ESPECIE        CHARACTER VARYING(100) not null,
		RAZA           CHARACTER VARYING(100),
		EDAD           INTEGER,
		CODIGO         CHARACTER VARYING(10),
		RESPONSABLE_ID CHARACTER VARYING(20)  not null,
		constraint PK_MASCOTAS
			primary key (ID)
	);

create index PUBLIC.MASCOTAS_ID_INDEX
	on PUBLIC.MASCOTAS (ID);
create index PUBLIC.MASCOTAS_RESPONSABLE_INDEX
	on PUBLIC.MASCOTAS (RESPONSABLE_ID);

create table PUBLIC.INGRESOS
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
			foreign key (ID_MASCOTA) references PUBLIC.MASCOTAS
	);

create index PUBLIC.INGRESOS_ID_INDEX
	on PUBLIC.INGRESOS (ID);
create index PUBLIC.INGRESOS_RESPONSABLE_INDEX
	on PUBLIC.INGRESOS (RESPONSABLE_ID);

insert into mascostas values (1, 'Perro', 'Pasor alemán', 4.5, 'GT456DF', '00000042L');
insert into ingresos values (1, '2024-03-12', '2024-05-10', null, 1, '00000042L');