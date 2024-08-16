-- database: ../DataBase/CDEcuFauna2k24.sqlite

INSERT INTO CDCatalogoTipo
 ( Nombre,               Descripcion )  VALUES
( "Tipo hormiga "       ,"larva, soldado...")
,( "Sexo"               ,"Macho, hembra...")
,( "Ingesta Nativa"     ,"Carnivoro, herbivoro...")
,( "GenoAlimento"       ,"XX,XY,X,,,");



INSERT INTO CDCatalogo
 ( IdCatalogoTipo ,Nombre,Descripcion   ) VALUES

 (  1 ,'Larva'   ,'Tipo de hormiga') 
,(  1 ,'Solado'  ,'Tipo de hormiga') 
,(  1 ,'Reina'   ,'Tipo de hormiga') 
,(  1 ,'Zangano' ,'Tipo de hormiga') 
,(  2,'Masculino','tipos de sexualidad')            
,(  2,'Femenino' ,'tipos de sexualidad')
,(  2, 'Asexual'  ,'tipos de sexualidad')            
,(  3,'Carnivoro'  ,'Tipo de Dieta de la hormiga')      
,(  3,'Herbivoro'  ,'Tipo de Dieta de la hormiga')       
,(  3,'Omnivoro'   ,'Tipo de Dieta de la hormiga')       
,(  3,'Insectivoro','Tipo de Dieta de la hormiga')       
,(  4,'XX'    ,'Tipo de Genoalimento')
,(  4,'XY'    ,'Tipo de Genoalimento')
,(  4,'X'     ,'Tipo de Genoalimento');


INSERT INTO CDUbicacion 
(Region, provincia) VALUES
( "Costa", "Esmeraldas"),       
( "Costa", "Manabí"),           
( "Costa", "Los Ríos"),         
( "Costa", "Guayas"),           
( "Costa", "Santa Elena"),      
( "Costa", "Santo Domingo"),    
("Sierra" , "Carchi"),           
("Sierra" , "Imbabura"),         
("Sierra" , "Pichincha"),        
("Sierra" , "Cotopaxi"),         
("Sierra" , "Tungurahua"),       
("Sierra" , "Bolívar"),          
("Sierra", "Chimborazo"),       
("Sierra" , "Cañar"),            
("Sierra" , "Azuay"),            
("Sierra" , "Loja"),  
( "Oriente", "Sucumbíos"),        
( "Oriente", "Napo"),             
( "Oriente", "Orellana"),         
( "Oriente", "Pastaza"),          
( "Oriente", "Morona Santiago"),  
( "Oriente", "Zamora Chinchipe"), 
("Insular", "Galápagos");        


INSERT INTO CDHormiga 
(IdClgTipoHormiga, IdClgIngestaNativa, IdClgGenoAlimento, IdClgSexo, IdUbicacion) VALUES
   ( 2,                8,               13,                   5,                 1 ),
   ( 3,                10,              13,                   7,                 7 ),
   ( 1,                8,               14,                   5,                16 ),
   ( 4,                9,               12,                   6,                11 );


SELECT H.IdHormiga, CDC.Nombre AS Sexo, CDC.IdCatalogoTipo
FROM CDHormiga H
JOIN CDCatalogo CDC ON H.IdClgTipoHormiga = CDC.IdCatalogo;

DELETE FROM CDHormiga 
WHERE IdClgTipoHormiga IN (2, 3, 1, 4)
AND IdClgIngestaNativa IN (8, 10, 8, 9)
AND IdClgGenoAlimento IN (13, 13, 14, 12)
AND IdClgSexo IN (5, 7, 5, 6)
AND IdUbicacion IN (1, 7, 16, 11);


