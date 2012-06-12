/*
    $Id: sample.sql 3637 2010-06-07 00:59:13Z unsaved $
    Exemplifies use of SqlTool.
    PCTASK Table creation
*/

/* Ignore error for these two statements */
\c true
DROP TABLE pctasklist;
DROP TABLE pctask;
\c false

\p Creating table pctask
CREATE TABLE pctask (
    id integer identity,
    name varchar(40),
    description varchar(256),
    url varchar(80),
    UNIQUE (name)
);

\p Creating table pctasklist
CREATE TABLE pctasklist (
    id integer identity,
    host varchar(20) not null,
    tasksequence int not null,
    pctask integer,
    assigndate timestamp default current_timestamp,
    completedate timestamp,
    show boolean default true,
    FOREIGN KEY (pctask) REFERENCES pctask,
    UNIQUE (host, tasksequence)
);


CREATE TABLE  menu (
  idmenu varchar(50) NOT NULL,
  label varchar(255) NOT NULL,
  link varchar(255) NOT NULL,
  status varchar(45) NOT NULL,
  tipo varchar(45) NOT NULL,
  pai varchar(50)
)


\p Granting privileges
GRANT select ON pctask TO public;
GRANT all ON pctask TO tomcat;
GRANT select ON pctasklist TO public;
GRANT all ON pctasklist TO tomcat;

\p Inserting test records
INSERT INTO pctask (name, description, url) VALUES (
    'task one', 'Description for task 1', 'http://cnn.com');
INSERT INTO pctasklist (host, tasksequence, pctask) VALUES (
    'admc-masq', 101, (SELECT id FROM pctask WHERE name = 'task one'));

commit;