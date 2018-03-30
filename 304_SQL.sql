create.sql

drop table PACKAGES;
drop table MINIVANS;
drop table COURIER;
drop table TRUCKS;
drop table DRIVER;
drop table EMPLOYEE;
drop table DELIVERYSTATIONS;
drop table OFFICE;
drop table CLIENT_LOGIN;
drop table CLIENT;

CREATE TABLE CLIENT
(
  C_NO      NUMBER                NOT NULL
    CONSTRAINT CLIENT_C_NO_PK
    PRIMARY KEY,
  C_NAME    CHAR(20) DEFAULT NULL NOT NULL,
  C_CCARD   NUMBER                NOT NULL,
  CVV       NUMBER                NOT NULL,
  C_PHONE#  NUMBER,
  C_ADDRESS CHAR(40) DEFAULT NULL NOT NULL,
  C_EMAIL   CHAR(40)
)
/
 
grant select on CLIENT to public;
 

CREATE TABLE CLIENT_LOGIN
(
  C_NO       NUMBER NOT NULL
    PRIMARY KEY
    CONSTRAINT CLIENT_LOGIN_CLIENT_C_NO_FK
    REFERENCES CLIENT,
  C_PASSWORD NUMBER(6)
    CHECK (C_PASSWORD < 1000000)
)
/

grant select on CLIENT_LOGIN to public;
 

CREATE TABLE OFFICE
(
  OFF_NO    NUMBER DEFAULT NULL  NOT NULL
    PRIMARY KEY,
  OFF_LNAME VARCHAR2(40)         NOT NULL,
  ADDRESS   VARCHAR2(40),
  CITY      VARCHAR2(20),
  OFF_STATE CHAR(2)
)
/

grant select on OFFICE to public;


CREATE TABLE DELIVERYSTATIONS
(
  STAT_NO   NUMBER DEFAULT 019 NOT NULL
    CONSTRAINT DELIVERYSTATIONS_DEV_NO_PK
    PRIMARY KEY,
  STAT_NAME CHAR(20)           NOT NULL,
  D_ADDRESS CHAR(40),
  OFF_NO    NUMBER DEFAULT NULL
    CONSTRAINT DEV_OFFICE_OFF_NO_FK
    REFERENCES OFFICE
)
/

 
grant select on DELIVERYSTATIONS to public;
 
CREATE TABLE EMPLOYEE
(
  E_PASSWORD NUMBER(6) NOT NULL,
  E_SSN      NUMBER(8) NOT NULL
    PRIMARY KEY,
  E_ADDRESS  CHAR(60) DEFAULT NULL,
  E_PNO      NUMBER,
  E_NAME     VARCHAR2(40),
  E_POSITION CHAR(50) DEFAULT NULL
)
/

 
grant select on EMPLOYEE to public;


CREATE TABLE DRIVER
(
  DRI_SSN    NUMBER(8)           NOT NULL
    CONSTRAINT DRIVER_EMPLOYEE_E_SSN_FK
    REFERENCES EMPLOYEE ON DELETE CASCADE,
  DRI_DLNO   NUMBER(7)           NOT NULL,
  DRI_OFF_NO NUMBER DEFAULT NULL NOT NULL
    CONSTRAINT DRIVER_OFFICE_OFF_NO_FK
    REFERENCES OFFICE,
  CONSTRAINT DRIVER_DRI_SSN_PK
  PRIMARY KEY (DRI_DLNO, DRI_SSN)
)
/

CREATE UNIQUE INDEX DRIVER_DRI_SSN_UINDEX
  ON DRIVER (DRI_SSN)
/

grant select on DRIVER to public;


CREATE TABLE TRUCKS
(
  T_P    NUMBER NOT NULL,
  OFF_NO NUMBER NOT NULL
    CONSTRAINT TRUCKS_OFFICE_OFF_NO_FK
    REFERENCES OFFICE
)
/
CREATE UNIQUE INDEX TRUCKS_T_P_UINDEX
  ON TRUCKS (T_P)
/
ALTER TABLE TRUCKS
  ADD CONSTRAINT TRUCKS_T_P_PK
PRIMARY KEY (T_P)
/
grant select on TRUCKS to public;


 
CREATE TABLE COURIER
(
  CO_SSN  NUMBER(8) DEFAULT NULL NOT NULL
    CONSTRAINT COURIER_EMPLOYEE_E_SSN_FK
    REFERENCES EMPLOYEE ON DELETE CASCADE,
  CO_DLNO NUMBER                 NOT NULL,
  DEV_NO  NUMBER DEFAULT NULL    NOT NULL
    CONSTRAINT COURIER_DEV_DEV_NO_FK
    REFERENCES DELIVERYSTATIONS,
  CONSTRAINT COURIER_CO_DLNO_PK
  PRIMARY KEY (CO_DLNO, CO_SSN)
)
/

CREATE UNIQUE INDEX COURIER_CO_SSN_UINDEX
  ON COURIER (CO_SSN)
/

CREATE UNIQUE INDEX COURIER_C_DLNO_UINDEX
  ON COURIER (CO_DLNO)
/

 
grant select on COURIER to public;


 
CREATE TABLE MINIVANS
(
  V_P        NUMBER NOT NULL
    PRIMARY KEY,
  SATAION_NO NUMBER
    CONSTRAINT MINIVANS_DEV_DEV_NO_FK
    REFERENCES DELIVERYSTATIONS
)
/	
 
grant select on MINIVANS to public;
 


CREATE TABLE PACKAGES
(
  TRACKING_NO      NUMBER DEFAULT NULL  NOT NULL,
  RECEIVER_ADDRESS CLOB,
  RECEIVER_NAME    CLOB,
  RECEIVER_PHONENO NUMBER,
  WEIGHT           FLOAT,
  DELIVERTYPE      CHAR(14),
  STATUS           CHAR(69),
  CLIENT_NO        NUMBER
    CONSTRAINT PACKAGES_CLIENT_C_NO_FK
    REFERENCES CLIENT,
  DRI_DLNO         NUMBER(7) DEFAULT NULL,
  DEV_NO           NUMBER,
  OFFICE_NO        NUMBER,
  CO_DLNO          NUMBER(7) DEFAULT NULL,
  DRI_SSN          NUMBER(8),
  CO_SSN           NUMBER,
  SENDING_DATE     DATE,
  CONSTRAINT PACKAGES_DRI_DLNO_DRI_SSN_FK
  FOREIGN KEY (DRI_DLNO, DRI_SSN) REFERENCES DRIVER,
  CONSTRAINT PACKAGES_CO_SSN_CO_DLNO_FK
  FOREIGN KEY (CO_DLNO, CO_SSN) REFERENCES COURIER
)
/

CREATE UNIQUE INDEX PACKAGES_TRACKING_NO_UINDEX
  ON PACKAGES (TRACKING_NO)
/

ALTER TABLE PACKAGES
  ADD CONSTRAINT PACKAGES_TRACKING_NO_PK
PRIMARY KEY (TRACKING_NO)
/

grant select on PACKAGES to public;

insert into CLIENT 
values(2, 'John Justin', 98234,812, 7782463515, '418 Queen St.', '1928@163.com');


insert into CLIENT 
values(3, 'Abus Braca', 137492, 263, 7783462847, '998 Atus Ave.', '9147@126.com');

insert into CLIENT 
values(4, 'Sam Uper', 384294, 909, 6049274810, '152 West St.', 'saien@gmail.com');


insert into CLIENT_LOGIN 
values(2, 293746);

insert into CLIENT_LOGIN 
values(3, 937143);

insert into CLIENT_LOGIN 
values(4, 098765);


insert into OFFICE 
values(2200041, 'Betty Branch', '263 Sunset bolv.', 'vancouver', 'BC');

insert into OFFICE 
values(2200042, 'Sunshine Branch', '566 Dropline St.', 'vancouver', 'BC');

insert into OFFICE 
values(2200043, 'Window Branch', '734 Abtues Ave.', 'vancouver', 'BC');


insert into DELIVERYSTATIONS
values(301, 'Cool Station', '778 Main Mall', 2200041);

insert into DELIVERYSTATIONS
values(302, 'Cold Station', '225 18th Ave.', 2200043);

insert into DELIVERYSTATIONS 
values(303, 'Heat Station', '989 101th St.', 2200041);



insert into EMPLOYEE values(139232, 23121144, '001 Aota St.', 7784612014, 'Cass AliFragi', 'COURIER');

insert into EMPLOYEE values(124482, 19342373, '201 EE St.', 7784612014, 'Ow Ali', 'COURIER');

insert into EMPLOYEE values(131988, 26375698, '501 Ottaw Ave.', 7784612014, 'Code Fragi', 'COURIER');

insert into EMPLOYEE values(131989, 26375691, '501 Ottaw Ave.', 7784612024, 'Blue Fragi', 'DRIVER');

insert into EMPLOYEE values(131912, 26375692, '501 Ottaw Ave.', 7784122014, 'Red Fragi', 'DRIVER');

insert into EMPLOYEE values(131923, 26375693, '501 Ottaw Ave.', 7784612324, 'Yellow Fragi', 'DRIVER');

insert into EMPLOYEE values(131954, 26375694, '501 Ottaw Ave.', 7789122014, 'Black Fragi', 'MANAGER');


insert into COURIER 
values(23121144, 9476123, 301);

insert into COURIER 
values(19342373, 0981264, 302);

insert into COURIER 
values(26375698, 8763567, 302);



insert into DRIVER values(26375691, 1238273, 2200041);
insert into DRIVER values(26375692, 1039572, 2200043);
insert into DRIVER values(26375693, 2342349, 2200042);






insert into MINIVANS 
values(8010912471,303);

insert into MINIVANS 
values(8012134289,302);

insert into MINIVANS 
values(8019920982,301);

insert into TRUCKS 
values(1012023,2200042);

insert into TRUCKS 
values(9900912,2200043);

insert into TRUCKS 
values(1012830,2200041);



insert into PACKAGES 
values(1201, '891 King St.', 'Lily Smith', 7782341762, 0.3, 'Express', 'deliver_by_driver', 2, 1238273, 301, 20041, 9476123, 26375691,23121144, DATE '2018-03-21');

insert into PACKAGES 
values(1202, '892 A St.', 'E.X. Pial', 779982345, 12.1, 'Express', 'deliver_by_driver', 2, 1039572, 302, 20041, 0981264,26375692, 19342373,DATE '2018-03-22');

insert into PACKAGES 
values(1203, '893 BC St.', 'C. Bei', 7781298762, 0.8, 'Normal', 'deliver_by_driver', 2, 1039572, 301, 20042, 9476123,26375692, 23121144, DATE '2018-03-23');

insert into PACKAGES 
values(1204, '894 DE St.', 'Yuri Tezuka', 7787263491, 0.4, 'Express', 'deliver_by_courier', 3, 2342349,303, 20042, 8763567,  26375693,26375698, DATE '2018-03-24');

insert into PACKAGES 
values(1205, '895 SaSa St.', 'Ming Ming', 7780927342, 1.5, 'Normal', 'deliver_by_driver', 2, 1039572, 303, 20041, 0981264, 26375692, 19342373, DATE '2018-03-25');

insert into PACKAGES 
values(1206, '896 Dou St.', 'Davis Smith', 6043219872, 4, 'Normal', 'delivered', 4, 1238273, 301, 20041, 9476123, 26375691, 23121144, DATE '2018-03-26');

insert into PACKAGES 
values(1207, '897 Ming St.', 'Jarvis Ou', 7780913482, 3, 'Express', 'deliver_by_courier', 4, 2342349, 301, 20043, 8763567, 26375693, 26375698, DATE '2018-03-27');

commit;

