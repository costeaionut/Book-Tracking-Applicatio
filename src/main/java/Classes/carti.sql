CREATE TABLE carti(
id_carte int,
titlu varchar(100) not null,
autor varchar(100) not null,
nr_pagini int,
nota float,
PRIMARY KEY (id_carte)
);

CREATE TABLE utilizatori(
nume_utilizator varchar(50),
parola varchar(50) not null,
nume varchar(50) not null,
prenume varchar(50) not null,
email varchar(50) not null unique,
rol number(1),
PRIMARY KEY (nume_utilizator),
CONSTRAINT ck_rol CHECK (rol IN (1,0))
);

CREATE TABLE carti_citite(
id_carte int,
nume_utilizator varchar(50),
progres int,
data_inceput date,
data_sfarsit date,
recenzie varchar (256),
nota float,
FOREIGN KEY (id_carte) references carti(id_carte) ON DELETE CASCADE,
FOREIGN KEY (nume_utilizator) references utilizatori(nume_utilizator) ON DELETE CASCADE,
PRIMARY KEY (id_carte, nume_utilizator)
);

CREATE TABLE prieteni(
id_prietenie int,
utilizator_1 varchar(50) not null,
utilizator_2 varchar(50) not null,
PRIMARY KEY (id_prietenie),
FOREIGN KEY (utilizator_1) references utilizatori(nume_utilizator) ON DELETE CASCADE,
FOREIGN KEY (utilizator_2) references utilizatori(nume_utilizator) ON DELETE CASCADE
);

CREATE TABLE recomandari(
id_recomandare int,
id_carte int not null,
utilizator_1 varchar(50) not null,
utilizator_2 varchar(50) not null,
PRIMARY KEY (id_recomandare),
FOREIGN KEY (utilizator_1) references utilizatori(nume_utilizator) ON DELETE CASCADE,
FOREIGN KEY (utilizator_2) references utilizatori(nume_utilizator) ON DELETE CASCADE
);











