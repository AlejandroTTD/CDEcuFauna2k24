-- database: ../DataBase/CDEcuFauna2k24.sqlite


DROP TABLE IF EXISTS CDHormiga;
DROP TABLE IF EXISTS CDUbicacion;
DROP TABLE IF EXISTS CDCatalogo;
DROP TABLE IF EXISTS CDCatalogoTipo;


CREATE TABLE CDCatalogoTipo (
     IdCatalogoTipo INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT
    ,Nombre         VARCHAR(10) NOT NULL UNIQUE
    ,Descripcion    VARCHAR(90)  

    ,Estado         VARCHAR(1)  NOT NULL DEFAULT('A')
    ,FechaCreacion  DATETIME    DEFAULT(datetime('now','localtime'))
    ,FechaModifica  DATETIME
); 


CREATE TABLE CDCatalogo (
     IdCatalogo     INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT
    ,IdCatalogoTipo INTEGER     NOT NULL REFERENCES CDCatalogoTipo (IdCatalogoTipo)
    ,Nombre         VARCHAR(10) NOT NULL UNIQUE
    ,Descripcion    VARCHAR(90)   

    ,Estado         VARCHAR(1)  NOT NULL DEFAULT('A')
    ,FechaCreacion  DATETIME    DEFAULT(datetime('now','localtime'))
    ,FechaModifica  DATETIME
); 


CREATE TABLE CDUbicacion (
     IdUbicacion    INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT
    ,Pais           VARCHAR(10) NOT NULL DEFAULT ('Ecuador') 
    ,Region         VARCHAR(10)  
    ,Provincia      VARCHAR(20)  
    ,Estado         VARCHAR(1)  NOT NULL DEFAULT('A')
    ,FechaCreacion  DATETIME    DEFAULT(datetime('now','localtime'))
    ,FechaModifica  DATETIME
); 


CREATE TABLE CDHormiga (
    IdHormiga                  INTEGER         NOT NULL PRIMARY KEY AUTOINCREMENT
    ,IdClgTipoHormiga          INTEGER         NOT NULL REFERENCES CDCatalogo(IdCatalogo)
    ,IdClgIngestaNativa        INTEGER         NOT NULL REFERENCES CDCatalogo(IdCatalogo) 
    ,IdClgGenoAlimento         INTEGER         NOT NULL REFERENCES CDCatalogo(IdCatalogo)
    ,IdclgSexo                 INTEGER         NOT NULL REFERENCES CDCatalogo(IdCatalogo)
    ,IdUbicacion            INTEGER         NOT NULL REFERENCES CDUbicacion(IdUbicacion)
    ,Estado                    VARCHAR(1)      NOT NULL DEFAULT('A')
    ,FechaCreacion             DATETIME        DEFAULT(datetime('now','localtime'))
    ,FechaModifica             DATETIME

);

