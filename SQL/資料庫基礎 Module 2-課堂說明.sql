-- 1. 新增資料 (INSERT INTO)
-- 建立問卷主檔 (省略 id，因為設定為 AUTO_INCREMENT) [cite: 619]
INSERT INTO questionnaires (title, description, start_time, end_time, is_published) 
VALUES (
    '2024 年度客戶滿意度調查', 
    '請協助填寫我們本年度的服務反饋，這將有助於我們改進。', 
    '2024-01-01 00:00:00', 
    '2024-01-31 23:59:59', 
    1
);

-- 建立題目 (使用 JSON 存選項) [cite: 616]
-- 假設上一筆問卷 ID 為 1
INSERT INTO questions (questionnaire_id, q_title, q_type, is_required, options, sort_order) 
VALUES 
(1, '您的性別', 'Single', 1, '[{"code":0, "val":"男"}, {"code":1, "val":"女"}]', 1),
(1, '您最喜歡的產品功能 (多選)', 'Multi', 0, '[{"code":"A", "val":"快速搜尋"}, {"code":"B", "val":"介面美觀"}, {"code":"C", "val":"客服親切"}]', 2),
(1, '其他建議', 'Text', 0, NULL, 3);

-- 2. 修改資料 (UPDATE)
-- 暫時關閉安全更新模式 (因為我們可能不是用 Key 當條件，或是保險起見) [cite: 627]
SET SQL_SAFE_UPDATES = 0;

-- 更新結束時間 [cite: 624]
UPDATE questionnaires 
SET end_time = '2024-02-29 23:59:59' 
WHERE title = '2024 年度客戶滿意度調查';

-- 養成好習慣，改完後開啟安全模式
SET SQL_SAFE_UPDATES = 1;

-- 3. 刪除資料 (DELETE FROM)
-- 刪除特定 email 的填寫者 [cite: 632]
-- 由於我們有設定 ON DELETE CASCADE，相關的 responses (回答明細) 也會自動被刪除
DELETE FROM respondents 
WHERE email = 'test_user@example.com';

-- 4. 基礎選取與過濾 (SELECT ... WHERE)
-- 選取特定欄位，而非 SELECT * (效能較佳)，找出所有「目前進行中」且「已發佈」的問卷。
SELECT id, title, start_time, end_time 
FROM questionnaires 
WHERE is_published = 1 
  AND start_time <= NOW() 
  AND end_time >= NOW(); 
  
-- 5.去除重複 (DISTINCT)
SELECT DISTINCT q_type 
FROM questions; 

-- 6.排序
SELECT name, submitted_at 
FROM respondents 
WHERE questionnaire_id = 1
ORDER BY submitted_at DESC;

-- 7.限制筆數與分頁 (LIMIT, OFFSET)
SELECT id, title, created_at 
FROM questionnaires
ORDER BY created_at DESC
LIMIT 10, 10;

-- 8.範圍搜尋 (BETWEEN)
SELECT title, created_at 
FROM questionnaires 
WHERE created_at BETWEEN '2023-01-01 00:00:00' AND '2023-12-31 23:59:59'; 

-- 9.指定集合 (IN)
SELECT id, title 
FROM questionnaires 
WHERE id IN (1, 3, 5);

-- 10 模糊搜尋 (LIKE)
-- % 代表前後可以有任意字元
SELECT * FROM questionnaires 
WHERE title LIKE '%滿意度%';

-- 11 別名 (AS)
SELECT 
    title AS 問卷標題, 
    start_time AS 開始時間, 
    end_time AS 結束時間
FROM questionnaires;