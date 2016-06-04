CREATE DEFINER=`root`@`localhost` PROCEDURE `avg_price`(productid int)
BEGIN
	select truncate((sum(price*quantity) / sum(quantity)), 2) avgprice from purchase
    where p_id = productid;
END