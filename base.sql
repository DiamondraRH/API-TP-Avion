    create database avion;
    CREATE ROLE avion LOGIN password 'avion';
    ALTER DATABASE avion OWNER TO avion;

    \c avion avion

    create table utilisateur (
        id_utilisateur SERIAL PRIMARY KEY NOT NULL,
        nom VARCHAR(100),
        email VARCHAR(50) UNIQUE,
        mdp VARCHAR(100),
        token VARCHAR(100),
        date_creation TIMESTAMP NULL,
        date_expiration TIMESTAMP NULL
    );

    create table marque(
        id_marque SERIAL PRIMARY KEY NOT NULL,
        intitule VARCHAR(100) UNIQUE
    );

    create table avion(
        id_avion SERIAL PRIMARY KEY NOT NULL,
        immatriculation VARCHAR(50) NOT NULL,
        places  INTEGER ,
        portes  INTEGER ,
        image_avion VARCHAR(100),
        id_marque INTEGER REFERENCES marque(id_marque)
    );

    create table kilometrage(
        id_kilometrage SERIAL PRIMARY KEY NOT NULL,
        id_avion INTEGER REFERENCES avion(id_avion),
        date_kilometrage DATE NOT NULL,
        distance float8
    );

    select extract (month from date_expiration) from assurance;

    create table assurance (
        id_assurance serial not null PRIMARY KEY,
        id_avion int references avion(id_avion),
        date_obtention date ,
        date_expiration date
    );
    
    INSERT INTO assurance(id_avion,date_obtention,date_expiration) VALUES
        (1,'2022-01-02','2023-01-20'),
        (2,'2022-02-22','2023-01-20'),
        (3,'2022-03-12','2023-02-21'),
        (4,'2022-04-23','2023-03-21'),
        (5,'2022-05-11','2023-03-20');


    INSERT INTO marque(intitule) VALUES
        ('Boeing'),
        ('CRJ'),
        ('Falcon');

    INSERT INTO avion(immatriculation, places, portes, id_marque) VALUES
        ('Boeing 717 ', 300, 4, 1),
        ('Boeing 736', 200, 5, 1),
        ('CRJ-1000', 500, 4, 2),
        ('CRJ-700', 90, 5, 3),
        ('Falcon 8X', 100, 5, 3),
        ('Falcon 6X', 810, 5, 3);
        
    INSERT INTO kilometrage(id_avion, date_kilometrage, distance) VALUES 
        (1, '2022-12-13', 0), 
        (1, '2022-12-14', 13), 
        (1, '2022-12-15', 30), 
        (1, '2022-12-16', 54); 
        

    CREATE OR REPLACE FUNCTION update_token()
    RETURNS TRIGGER 
    AS
    $$
    BEGIN
        IF NEW.token IS NULL OR NEW.token = '' THEN
            UPDATE utilisateur SET date_creation = NULL , date_expiration = NULL WHERE id_utilisateur = OLD.id_utilisateur;
        ELSE
            UPDATE utilisateur SET date_creation = now() , date_expiration = now() + interval '3 hours' WHERE id_utilisateur = OLD.id_utilisateur;
        END IF;
        RETURN NEW;
    END;
    $$ LANGUAGE plpgsql;


    CREATE TRIGGER update_token 
    AFTER UPDATE OF token ON utilisateur
    FOR EACH ROW
    EXECUTE PROCEDURE update_token();

    INSERT INTO utilisateur (nom, email, mdp) 
    VALUES ('Rakoto' , 'rakoto@gmail.com', md5('rakoto1234'));
  
    CREATE OR REPLACE VIEW avion_detail AS
        SELECT avion.* , kilometrage.distance
        FROM avion JOIN kilometrage 
        ON avion.id_avion = kilometrage.id_avion
    ;
