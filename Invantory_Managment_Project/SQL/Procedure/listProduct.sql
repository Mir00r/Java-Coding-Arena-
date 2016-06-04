CREATE DEFINER=`root`@`localhost` PROCEDURE `listProduct`()
BEGIN
	select pname from product;
END