CREATE DEFINER=`root`@`localhost` PROCEDURE `save_purchase`(in id int, in price double, in dt date, in qt int)
BEGIN
	insert into purchase (p_id, price, pdate, quantity) 
    values (id, price, dt, qt);
END