-- --------------------------------------------------------------------------------
-- Name:		Lance Brown
-- Class:		IT-262 Java 2
-- Abstract:	StudentInfo
-- --------------------------------------------------------------------------------

-- --------------------------------------------------------------------------------
-- Options
-- --------------------------------------------------------------------------------
USE dbHCM		            -- Don't work in master
SET NOCOUNT ON				-- Report only errors

-- ----------------------------------------------------------------------
-- Drops
-- ----------------------------------------------------------------------
IF OBJECT_ID( 'TContacts' )						IS NOT NULL		DROP TABLE TContacts;
IF OBJECT_ID( 'TMajors' )						IS NOT NULL		DROP TABLE TMajors;


GO

-- ----------------------------------------------------------------------
-- Tables
-- ----------------------------------------------------------------------
CREATE TABLE TContacts
(
	intContactID                     INTEGER        NOT NULL,
	strFirstName                     VARCHAR(50)    NOT NULL,
	strLastName                      VARCHAR(50)    NOT NULL,
	strPhoneNumber                   VARCHAR(50)    NOT NULL,
	strEmailAddress                  VARCHAR(50)    NOT NULL,
    strMajor                         VARCHAR(50)    NOT NULL,
	CONSTRAINT TContacts_PK PRIMARY KEY CLUSTERED ( intContactID ))
CREATE TABLE TMajors
(
	intMajorID                       INTEGER        NOT NULL,
	strMajorCode                     VARCHAR(50)    NOT NULL,
	strDesc                          VARCHAR(50)    NOT NULL,
	strExtendedDesc                  VARCHAR(50)    NOT NULL,
	CONSTRAINT TContacts_PK PRIMARY KEY CLUSTERED ( intContactID ))

-- Employees
INSERT INTO TContacts(intContactID, strFirstName, strLastName, strPhoneNumber, strEmailAddress, strMajor)
VALUES
    (1,	"Jess",	"Doddrell",	"479-276-1737",	"jdoddrell0@spiegel.de",	"HITC"),
    (2,	"Eustacia",	"Jandak",	"631-530-8291",	"ejandak1@cbsnews.com",	"CAPC"),
    (3,	"Alessandro",	"Boolsen",	"662-564-5967",	"aboolsen2@baidu.com",	"ESET"),
    (4,	"Elton",	"Stammirs",	"774-965-9620",	"estammirs3@usgs.gov",	"WEBM")

INSERT INTO TMajors(intMajorID,	strMajorCode,	strDesc,	strExtendedDesc)
VALUES
    (1,	"HITC",	"Health Info Tech",	"Health Information Technician Certificate"),
    (2,	"CAPC",	"Computer App",	"Computer Applications Certificate"),
    (3,	"ESET",	"Elec Systems",	"Electronics Systems Major"),
    (4,	"WEBM",	"Web Multimedia Design",	"Web and Multimedia Design")

GO
