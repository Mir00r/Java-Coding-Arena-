CREATE TABLE loginapp.`uinfo` (
	`id` int(10) unsigned not null auto_increment,
	`uname` varchar(10) NOT NULL,
	`password` varchar(10) NOT NULL,
	`email` varchar(50) default NULL,
	`registeredon` date default NULL,
	PRIMARY KEY  (`id`),
    unique key `uname` (`uname`),
	UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;