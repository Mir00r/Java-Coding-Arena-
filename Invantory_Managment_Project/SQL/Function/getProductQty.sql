CREATE DEFINER=`root`@`localhost` FUNCTION `getProductQty`(product_name varchar(50) ) RETURNS int(11)
BEGIN
	return (select quantity from product where pname = product_name);
RETURN 1;
END