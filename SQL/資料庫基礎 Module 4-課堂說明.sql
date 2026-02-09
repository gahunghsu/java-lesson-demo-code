-- 日期函數
-- 1. 取得系統當前時間 (NOW)
-- 模擬：插入一筆新的填寫紀錄，submitted_at 使用當下時間
INSERT INTO respondents (questionnaire_id, name, email, phone, age, submitted_at)
VALUES (1, '王小明', 'wang@example.com', '0912345678', 25, NOW()); 

-- 2. 日期比較 (CURDATE)
-- 找出「今天」還可以填寫的問卷 (結束日期大於等於今天)
SELECT title, end_time
FROM questionnaires
WHERE end_time >= CURDATE();

-- 聚合函數

-- 1. 計算總填寫人數 (COUNT)
-- 統計問卷 ID 為 1 的填寫總數
SELECT COUNT(*) AS 總填寫人數 
FROM respondents 
WHERE questionnaire_id = 1; 

-- 2. 計算平均年齡 (AVG)
-- 統計問卷 ID 為 1 的填寫者平均年齡
-- 若有人沒填年齡 (NULL)，AVG 會自動忽略該筆資料
SELECT AVG(age) AS 平均年齡 
FROM respondents 
WHERE questionnaire_id = 1; 

-- 3. 找出最大與最小年齡 (MAX, MIN)
SELECT 
    MAX(age) AS 最年長, 
    MIN(age) AS 最年輕 
FROM respondents 
WHERE questionnaire_id = 1; 

-- 資料分組與篩選
-- 1. 分組統計 (GROUP BY)
SELECT 
    q.title AS 問卷標題,
    COUNT(r.id) AS 填寫人數
FROM questionnaires q
LEFT JOIN respondents r ON q.id = r.questionnaire_id
GROUP BY q.id, q.title; -- [cite: 923]
-- 這裡依據問卷 ID 和標題分組，把屬於同一份問卷的人「聚在一起」數人頭

-- 2. 分組後篩選 (HAVING)
-- 延續上題，但我們只想看「填寫人數 > 50」的問卷
SELECT 
    q.title AS 問卷標題,
    COUNT(r.id) AS 填寫人數
FROM questionnaires q
LEFT JOIN respondents r ON q.id = r.questionnaire_id
GROUP BY q.id, q.title
HAVING COUNT(r.id) > 50;

-- 字串與數學函數
-- 1. 字串串接 (CONCAT)
-- 輸出格式：王小明 (wang@example.com)
SELECT CONCAT(name, ' (', email, ')') AS 詳細資訊
FROM respondents; -- [cite: 940]

-- 2. 字串取代 (REPLACE) - 簡易個資遮蔽
-- 把 gmail.com 替換成 *****
SELECT REPLACE(email, 'gmail.com', '*****') AS 遮蔽信箱
FROM respondents; -- [cite: 942]

-- 3. 數學四捨五入 (ROUND)
-- 計算平均年齡，並取到小數點下 1 位
SELECT 
    questionnaire_id,
    ROUND(AVG(age), 1) AS 平均年齡 -- [cite: 947]
FROM respondents
GROUP BY questionnaire_id;

-- DCL - 權限與安全
-- 1. 建立行銷分析專用帳號 (CREATE USER)
-- 'marketing' 是帳號，'%' 代表可以從任何 IP 登入 (方便但要注意安全)
CREATE USER 'marketing'@'%' IDENTIFIED BY 'secure_password'; 

-- 2. 授權 (GRANT) - 最小權限原則
-- 只給予 dynamic_survey_db 資料庫的 SELECT 權限
GRANT SELECT ON dynamic_survey_db.* TO 'marketing'@'%';

-- 3. 讓權限立即生效
FLUSH PRIVILEGES; -- [cite: 901]

-- (補充) 如果要收回權限
-- REVOKE SELECT ON dynamic_survey_db.* FROM 'marketing'@'%';