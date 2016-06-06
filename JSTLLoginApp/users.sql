CREATE TABLE loginapp.`users` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY  (`id`)
);
 
INSERT INTO `users` (`id`,`username`,`password`) VALUES
 (1,'admin','123');