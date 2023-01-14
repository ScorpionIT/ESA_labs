CREATE TABLE BOOK
(
    ID  uuid    not null unique,
    NAME  VARCHAR(255) NOT NULL,
    PUBLISH_DATE   timestamp NOT NULL,
    PAGE_COUNT integer not null,
    AUTHOR_ID uuid,
    PRIMARY KEY (ID)
);
create table AUTHOR
(
    ID uuid not null unique,
    NAME  VARCHAR(255) NOT NULL,
    SURNAME  VARCHAR(255) NOT NULL,
    COUNTRY  VARCHAR(255) NOT NULL,
    primary key (ID)
);

ALTER TABLE BOOK
    ADD CONSTRAINT AUTHOR_FK FOREIGN KEY (AUTHOR_ID) REFERENCES AUTHOR (ID);