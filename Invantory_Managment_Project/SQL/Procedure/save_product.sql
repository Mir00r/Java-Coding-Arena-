CREATE DEFINER=`root`@`localhost` PROCEDURE `save_product`(productName varchar(40) )
BEGIN
	insert into product (pname) values (productName);
END