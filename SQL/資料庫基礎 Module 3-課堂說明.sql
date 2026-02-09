-- 1. Inner Join 
SELECT 
    q.title AS 問卷標題, 
    qs.q_title AS 題目內容,
    qs.q_type AS 題型
FROM questionnaires q
INNER JOIN questions qs ON q.id = qs.questionnaire_id;

-- 2. Left Join
SELECT 
    q.title AS 問卷標題,
    COUNT(r.id) AS 填寫人數
FROM questionnaires q -- [左表] 所有的問卷都要顯示
LEFT JOIN respondents r ON q.id = r.questionnaire_id -- [右表] 對應的填寫者
GROUP BY q.id, q.title; 

-- 3.UNION 聯集
-- 假設問卷 ID 1 是滿意度調查，ID 2 是產品調查
SELECT email FROM respondents WHERE questionnaire_id = 1
UNION -- 自動過濾重複
SELECT email FROM respondents WHERE questionnaire_id = 2;

SELECT email FROM respondents WHERE questionnaire_id = 1
UNION ALL -- 無過濾
SELECT email FROM respondents WHERE questionnaire_id = 2;

-- 4. Subquery 子查詢 - 巢狀篩選
SELECT title 
  FROM questionnaires q
 WHERE EXISTS ( -- NOT EXISTS
    SELECT 'Y'
      FROM questions qs 
     WHERE qs.questionnaire_id = q.id 
       AND qs.q_type = 'Single'
);

SELECT title 
  FROM questionnaires q
 WHERE q.id IN ( -- NOT IN
    SELECT qs.questionnaire_id
      FROM questions qs 
     WHERE qs.q_type = 'Single'
);

-- CASE WHEN(條件分類)
SELECT 
    name,
    age,
    CASE 
        WHEN age < 20 THEN '青少年 (Youth)'
        WHEN age BETWEEN 20 AND 60 THEN '成年 (Adult)'
        ELSE '長者 (Senior)'
    END AS age_group 
FROM respondents;

-- COALESCE (空值處理)
SELECT 
    name, 
    COALESCE(age, 0) AS age_fixed -- 如果 age 是 NULL，就回傳 0 [cite: 834]
FROM respondents;

INSERT INTO questions (questionnaire_id, q_title, q_type, options, sort_order) 
VALUES 
(3, '您的性別', 'Single', '[{"code":0, "val":"男"}, {"code":1, "val":"女"}]', 1),
(3, '您最喜歡的產品功能 (多選)', 'Multi', 
'[{"code":"A", "val":"快速搜尋"}, {"code":"B", "val":"介面美觀"}, 
{"code":"C", "val":"客服親切"}]', 2),
(3, '其他建議', 'Text', NULL, 3);

SELECT q.title AS 問卷標題, 
       qs.q_title AS 題目內容,
       qs.q_type AS 題型
  FROM questionnaires q
 INNER JOIN questions qs ON q.id = qs.questionnaire_id;

INSERT INTO `dynamic_survey`.`respondents` 
(`questionnaire_id`, `email`, `name`, `age`, `submitted_at`) 
VALUES
(4, 'alice.wong@example.com', 'Alice Wong', 24, '2026-02-09 10:00:00'),
(4, 'bob.chen@gmail.com', 'Bob Chen', 31, '2026-02-09 10:15:22'),
(4, 'charlie.lin@outlook.com', 'Charlie Lin', 45, '2026-02-09 11:05:40'),
(4, 'david.kao@yahoo.com', 'David Kao', 19, '2026-02-09 12:30:15'),
(4, 'emily.liu@company.org', 'Emily Liu', 28, '2026-02-09 13:45:00'),
(4, 'frank.hsieh@service.net', 'Frank Hsieh', 52, '2026-02-09 14:10:10'),
(4, 'grace.tsai@edu.tw', 'Grace Tsai', 22, '2026-02-09 15:00:05'),
(4, 'henry.lee@gmail.com', 'Henry Lee', 37, '2026-02-09 15:20:33'),
(4, 'isabella.wu@cloud.com', 'Isabella Wu', 26, '2026-02-09 16:05:12'),
(4, 'jack.huang@tech.io', 'Jack Huang', 41, '2026-02-09 16:55:59');

SELECT q.title AS 問卷標題,
       COUNT(r.id) AS 填寫人數
  FROM questionnaires q -- [左表] 所有的問卷都要顯示
  LEFT JOIN respondents r ON q.id = r.questionnaire_id -- [右表] 對應的填寫者
 GROUP BY q.id, q.title; 
 
SELECT name, email FROM respondents WHERE questionnaire_id = 3
 UNION ALL -- 
SELECT name, email FROM respondents WHERE questionnaire_id = 4;

SELECT title 
  FROM questionnaires q
 WHERE NOT EXISTS (
    SELECT 'Y'
      FROM questions qs 
     WHERE qs.questionnaire_id = q.id 
       AND qs.q_type = 'Single'
);

SELECT title 
  FROM questionnaires q
 WHERE q.id NOT IN ( 
    SELECT qs.questionnaire_id
      FROM questions qs 
     WHERE qs.q_type = 'Single'
);

SELECT email FROM respondents WHERE questionnaire_id = 4;
