-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2023-01-23 19:32:18.038

-- tables
-- Table: diver
CREATE TABLE driver (
                       id int  NOT NULL,
                       firstname varchar(250)  NOT NULL,
                       lastname varchar(250)  NOT NULL,
                       nationality_id int  NOT NULL,
                       CONSTRAINT driver_pk PRIMARY KEY (id)
);

-- Table: nationality
CREATE TABLE nationality (
                             id int  NOT NULL,
                             country varchar(250)  NOT NULL,
                             CONSTRAINT nationality_pk PRIMARY KEY (id)
);

-- Table: team
CREATE TABLE team (
                      id int  NOT NULL,
                      name varchar(250)  NOT NULL,
                      CONSTRAINT team_pk PRIMARY KEY (id)
);
-- Table: championship
CREATE TABLE championship (
                              id int  NOT NULL,
                              driver_id int  NOT NULL,
                              team_id int  NOT NULL,
                              years int  NOT NULL,
                              CONSTRAINT championship_pk PRIMARY KEY (id,driver_id,team_id)
);

-- foreign keys
-- Reference: championship_diver (table: championship)
ALTER TABLE championship ADD CONSTRAINT championship_driver
    FOREIGN KEY (driver_id)
        REFERENCES driver (id)
;

-- Reference: championship_team (table: championship)
ALTER TABLE championship ADD CONSTRAINT championship_team
    FOREIGN KEY (team_id)
        REFERENCES team (id)
;

-- Reference: diver_nationality (table: diver)
ALTER TABLE driver ADD CONSTRAINT driver_nationality
    FOREIGN KEY (nationality_id)
        REFERENCES nationality (id)
;

-- End of file.

