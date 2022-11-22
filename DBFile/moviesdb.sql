create table usuarios
(
    carnet VARCHAR(20) primary key not null,
    nom_usuario VARCHAR(30) not null,
    ape_usuario VARCHAR(30) not null,
    tipo VARCHAR(30),
    telcasa VARCHAR(9),
    celular VARCHAR(9),
    email VARCHAR(100),
    estado VARCHAR(20),
    clave VARCHAR(50) not null,
    acessosistemas INTEGER,
    esadministrador INTEGER
);

create table peliculas
(
    idpelicula SERIAL primary key not null ,
    nombre VARCHAR(200),
    nomb_ingles VARCHAR(200),
    yearp INTEGER,
    duracion INTEGER
);

create table fotos
(
    idfoto SERIAL primary key not null,
    idpelicula INTEGER references peliculas(idpelicula),
    foto VARCHAR(254),
    primera VARCHAR(1)
);

create table categoria
(
    idcategoria SERIAL primary key not null,
    categoria VARCHAR(200)
);

create table peliculavista
(
    idpeliculavista SERIAL primary key not null,
    idpelicula INTEGER references peliculas(idpelicula),
    carnet VARCHAR(20) references usuarios(carnet),
    comentario TEXT,
    calificacion INT
);

create table categoriapeliculas
(
    idcatpelicula SERIAL primary key not null,
    idcategoria INT references categoria(idcategoria),
    idpelicula INT references peliculas(idpelicula)
);

/*Vistas*******************************************************************************************************************************/
/*View foto*/
create or replace view fotosVista
as select idfoto, f.idpelicula, p.nombre, foto, primera
from fotos f
inner join peliculas p on f.idpelicula = p.idpelicula;

select * from fotosVista;

/*View pelicula*/
create or replace view peliculasVista
as select p.idpelicula,nombre, nomb_ingles,c.idcategoria, c.categoria, yearp, duracion
from peliculas p
INNER JOIN categoriapeliculas cp on p.idpelicula = cp.idpelicula
INNER JOIN categoria c on cp.idcategoria = c.idcategoria;

select * from peliculasVista;

/*View peliculaUsuario*/
create or replace view peliculaCatalogoVista
as select p.idpelicula,nombre, nomb_ingles, f.foto, c.categoria, yearp, duracion
from peliculas p
INNER JOIN categoriapeliculas cp on p.idpelicula = cp.idpelicula
INNER JOIN categoria c on cp.idcategoria = c.idcategoria
INNER JOIN fotos f on p.idpelicula = f.idpelicula where primera = 'y';

select * from peliculaCatalogoVista;
/*Vistas*******************************************************************************************************************************/



/*Funciones*******************************************************************************************************************************/
/*Update foto*/
CREATE OR REPLACE FUNCTION updatefotosprimera(idfotoParamether INTEGER, idpeliculaParamether INTEGER) RETURNS VOID AS
$$
BEGIN
    update fotos set primera = 'n' where idpelicula = idpeliculaParamether;
    update fotos set primera = 'y' where idfoto = idfotoParamether;
END
$$
  LANGUAGE 'plpgsql';

/*add pelicula*/
CREATE OR REPLACE FUNCTION insertarPelicula(nombreP VARCHAR(200), nomb_inglesP varchar(200), idcategoriaP INTEGER, yearpP INTEGER, duracionP INTEGER) RETURNS VOID AS
$$
DECLARE
        idpeliculaP int;
BEGIN
    INSERT INTO  peliculas(nombre, nomb_ingles, yearp, duracion) VALUES (nombreP, nomb_inglesP, yearpP, duracionP) RETURNING idpelicula INTO idpeliculaP;
    INSERT INTO  categoriapeliculas(idcategoria, idpelicula) VALUES (idcategoriaP, idpeliculaP);
END
$$
  LANGUAGE 'plpgsql';

SELECT insertarPelicula('Queso','Crack', 1, 200, 200);

/*Update pelicula*/
CREATE OR REPLACE FUNCTION updatePelicula(idpeliculaP INTEGER, nombreP VARCHAR(200), nomb_inglesP varchar(200), idcategoriaP INTEGER, yearpP INTEGER, duracionP INTEGER) RETURNS VOID AS
$$
DECLARE
BEGIN
    UPDATE  peliculas SET nombre = nombreP, nomb_ingles = nomb_inglesP, yearp = yearpP, duracion = duracionP WHERE idpelicula = idpeliculaP;
    UPDATE  categoriapeliculas SET idcategoria = idcategoriaP, idpelicula = idpeliculaP WHERE idpelicula = idpeliculaP;
END
$$
  LANGUAGE 'plpgsql';

SELECT updatePelicula(4, 'ha1', 'ha2', 3, 100,100);
    UPDATE  categoriapeliculas SET idcategoria = 1, idpelicula = 4 WHERE idpelicula = 4 AND idcategoria = 1;
/*Funciones*******************************************************************************************************************************/



/*Tries*******************************************************************************************************************************/
UPDATE fotos SET idpelicula =7, foto = 'arsrasa', primera = 'y' WHERE idfoto = 3

INSERT INTO peliculavista(idpelicula, carnet, comentario, calificacion) values (?, ?, ? ,?);
/*Tries*******************************************************************************************************************************/
