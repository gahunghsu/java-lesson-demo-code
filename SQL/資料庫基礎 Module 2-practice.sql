CREATE TABLE if not exists `members` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(150) NOT NULL COMMENT '姓名',
  `age` int COMMENT '年齡',
  `city` varchar(150) NOT NULL COMMENT '居住地',
  `join_date` date NOT NULL COMMENT '加入時間',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

insert into members(name, age, city, join_date) values('小名', 18, 'Taipei', '2026-02-01');
insert into members(name, age, city, join_date) values('小明', 36, 'Taipei', '2026-02-01');
insert into members(name, age, city, join_date) values('大華', 20, 'Taina', '2026-02-01');
insert into members(name, age, city, join_date) values('Alice Chen', 18, 'Taipei', '2026-01-01');
insert into members(name, age, city, join_date) values('Alice Wang', 27, 'Taipei', '2026-01-02');
insert into members(name, age, city, join_date) values('Alice Hsu', 26, 'Taipei', '2026-01-03');
insert into members(name, age, city, join_date) values('Alice Wu', 25, 'Hsinchu', '2026-02-01');
insert into members(name, age, city, join_date) values('Alice Hunag', 24, 'Hsinchu', '2026-02-02');
insert into members(name, age, city, join_date) values('Alice 123', 23, 'Taina', '2026-02-03');
insert into members(name, age, city, join_date) values('Alice 456', 22, 'Taina', '2026-02-04');
insert into members(name, age, city, join_date) values('Alice 789', 21, 'NY', '2026-02-05');
insert into members(name, age, city, join_date) values('Alice 987', 20, 'LA', '2026-02-06');
insert into members(name, age, city, join_date) values('Alice 654', 19, 'Tokyo', '2026-02-07');
insert into members(name, age, city, join_date) values('Alice 321', 18, '1235', '2026-02-08');

select * from members;

update members set city = 'New Taipei City' where city = 'Taipei';

select * 
  from members 
where city = 'New Taipei City' 
  and age between 20 and 30;

select * from members where name like '%Alice%' order by join_date desc limit 10 offset 10;

select * from members where name like '%Alice%' order by join_date desc;
