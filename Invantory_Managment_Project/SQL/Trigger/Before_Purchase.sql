use imp;

DELIMITER \\
CREATE TRIGGER bafore_purchase before INSERT ON purchase
FOR EACH ROW 
BEGIN 
	update product
    set quantity = quantity + new.quantity
    where p_id = new.p_id;
END \\
DELIMITER ;