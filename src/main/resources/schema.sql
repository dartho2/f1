-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2023-01-25 10:51:58.869

-- tables
-- Table: country
CREATE TABLE country (
                         id int  NOT NULL,
                         name varchar(255)  NOT NULL,
                         CONSTRAINT country_pk PRIMARY KEY (id)
);
-- Table: championship
CREATE TABLE championship (
                              years int  NOT NULL,
                              id int  NOT NULL,
                              CONSTRAINT championship_pk PRIMARY KEY (id)
);

-- Table: championships_team_driver
CREATE TABLE championships_team_driver (
                                           id int  NOT NULL,
                                           team_id int  NOT NULL,
                                           driver_id int  NOT NULL,
                                           championship_id int  NOT NULL,
                                           CONSTRAINT championships_team_driver_pk PRIMARY KEY (id)
);

-- Table: driver
CREATE TABLE driver (
                        id int  NOT NULL,
                        firstname varchar(255)  NOT NULL,
                        lastname varchar(255)  NOT NULL,
                        country_id int  NOT NULL,
                        CONSTRAINT driver_pk PRIMARY KEY (id)
);

-- Table: team
CREATE TABLE team (
                      id int  NOT NULL,
                      name varchar(255)  NOT NULL,
                      CONSTRAINT team_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: championships_driver (table: championships_team_driver)
ALTER TABLE championships_team_driver ADD CONSTRAINT championships_driver
    FOREIGN KEY (driver_id)
        REFERENCES driver (id)
;

-- Reference: championships_team (table: championships_team_driver)
ALTER TABLE championships_team_driver ADD CONSTRAINT championships_team
    FOREIGN KEY (team_id)
        REFERENCES team (id)
;

-- Reference: championships_team_driver_championship (table: championships_team_driver)
ALTER TABLE championships_team_driver ADD CONSTRAINT championships_team_driver_championship
    FOREIGN KEY (championship_id)
        REFERENCES championship (id)
;
ALTER TABLE driver ADD CONSTRAINT driver_country
    FOREIGN KEY (country_id)
        REFERENCES country (id)
;


-- End of file.

