CREATE TABLE `sales` (
  `sales_id` int NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`sales_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `orders` (
  `order_id` int NOT NULL,
  `sales_id` int DEFAULT NULL,
  `customer_name` varchar(50) DEFAULT NULL,
  `amount` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 3. 插入業務測試資料
INSERT INTO Sales VALUES (1, 'Alice'), (2, 'Bob'), (3, 'Charlie');

-- 4. 插入訂單測試資料 (刻意製造：1號業績多, 2號沒業績, 3號業績普通)
-- 同時讓 'Customer A' 滿足 VIP 條件 (6筆, 總額 12000)
INSERT INTO Orders VALUES 
(101, 1, 'Customer A', 2000), (102, 1, 'Customer A', 2000), (103, 1, 'Customer A', 2000),
(104, 1, 'Customer A', 2000), (105, 1, 'Customer A', 2000), (106, 1, 'Customer A', 2000),
(107, 3, 'Customer B', 5000), (108, 3, 'Customer B', 1000);

SELECT s.name AS 業務姓名,
       COALESCE(SUM(o.amount), 0) AS 訂單總金額
  FROM Sales s
  LEFT JOIN Orders o ON s.sales_id = o.sales_id
 GROUP BY s.sales_id, s.name;

SELECT customer_name AS 客戶名稱,
       COUNT(order_id) AS 訂單總筆數,
       SUM(amount) AS 總消費金額
  FROM Orders
 GROUP BY customer_name
HAVING COUNT(order_id) > 5 
   AND SUM(amount) > 10000;