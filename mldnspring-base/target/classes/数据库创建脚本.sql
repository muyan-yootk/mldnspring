DROP DATABASE IF EXISTS mldn ;
CREATE DATABASE mldn CHARACTER SET UTF8 ;
USE mldn ;
CREATE TABLE news(
	nid			BIGINT			AUTO_INCREMENT ,
	title		VARCHAR(50) ,
	note		TEXT ,
	pubdate		DATETIME ,
	price		DOUBLE ,
	readcount	INT ,
	CONSTRAINT PK_NID PRIMARY KEY(nid)
) engine=innodb ;