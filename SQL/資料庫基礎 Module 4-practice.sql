CREATE TABLE `orders` (
  `drink_name` varchar(150) DEFAULT NULL,
  `price` int NOT NULL,
  `quantity` int DEFAULT NULL,
  `customer_name` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO orders VALUES('RED TEA', 50, 10, 'Ted'),
('RED TEA', 50, 100, 'Ted'),('RED TEA', 50, 200, 'Ted'),
('GREEN TEA', 50, 10, 'Alice'),('GREEN TEA', 50, 10, 'Jenny');

INSERT INTO orders VALUES('RED TEA', 50, 10, 'Ted');

USE dynamic_survey;

SELECT drink_name, SUM(quantity) AS 總銷售杯數, SUM(price * quantity) as 總收入
  FROM orders 
 group by drink_name;
 
SELECT drink_name, SUM(quantity) AS 總銷售杯數, SUM(price * quantity) as 總收入
  FROM orders 
 group by drink_name
having SUM(price * quantity) > 5000;
 
select concat(customer_name, ' (VIP)') as 'VIP',  count(customer_name) as 購買次數
  FROM orders 
 group by customer_name
having count(customer_name) > 3;