CREATE DEFINER=`root`@`localhost` FUNCTION `getProductid`(product_name varchar(50) ) RETURNS int(11)
BEGIN
	return (select p_id from product where pname = product_name);
RETURN 1;
END