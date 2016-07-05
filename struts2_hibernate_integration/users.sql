CREATE TABLE hibernatedb.`users` (
  `uname` varchar(10) NOT NULL,
  `pwd` varchar(10) default NULL,
  `email` varchar(50) default NULL,
  `dor` date default NULL,
  PRIMARY KEY  (`uname`),
  UNIQUE KEY `email` (`email`)
);