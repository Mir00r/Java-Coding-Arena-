
CREATE TABLE loginapp.`users` (
	`uname` varchar(10) NOT NULL,
	`password` varchar(10) NOT NULL,
	`email` varchar(50) default NULL,
	`registeredon` date default NULL,
	PRIMARY KEY  (`uname`),
	UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;