
-- 定义一个存储过程
delimiter //

create procedure productpricing()
begin
	select avg(prod_price) as priceaverage
	from products;
    end //
delimiter ;   

-- 调用存储过程
call productpricing();

-- 删除一个存储过程
drop procedure if exists productpricing;