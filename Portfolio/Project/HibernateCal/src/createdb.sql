use myhibernatedb;
create table eventcalendar(
 id int NOT NULL auto_increment,
 eventDate DATETIME default CURRENT_TIMESTAMP,
 name VARCHAR(256) default NULL,
 email VARCHAR(256) default NULL,
 phone VARCHAR(20) default NULL,
 lkaddress int default NULL,
 notes VARCHAR(512) default NULL,
 PRIMARY KEY (id)
);

create table address(
 id int NOT NULL auto_increment,
 address VARCHAR(256) default NULL,
 PRIMARY KEY (id)
);