-- 1. 建立資料庫，並強制使用 utf8mb4 編碼
CREATE DATABASE IF NOT EXISTS dynamic_survey_db 
CHARACTER SET utf8mb4 
COLLATE utf8mb4_unicode_ci; 

USE dynamic_survey_db;

-- 2.建立表格與約束條件
CREATE TABLE IF NOT EXISTS questionnaires (
    -- [主鍵設定] id 為 BIGINT 且自動遞增，對應 Java Long
    id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '問卷 ID', 

    -- [字串設定] 標題長度可變，使用 VARCHAR 節省空間
    title VARCHAR(150) NOT NULL COMMENT '問卷標題',

    -- [大文字設定] 說明文字可能很長，使用 TEXT
    description TEXT COMMENT '問卷說明', 

    -- [布林值設定] MySQL 使用 TINYINT(1) 代表 Boolean
    is_published TINYINT(1) DEFAULT 0 COMMENT '發佈狀態 (0:草稿, 1:發佈)',

    -- [時間設定] 包含日期的時間，使用 DATETIME
    start_time DATETIME NOT NULL COMMENT '開始時間', 
    end_time DATETIME NOT NULL COMMENT '結束時間',

    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,

    -- [Check Constraint] 確保結束時間晚於開始時間 (資料庫層級防呆)
    CONSTRAINT chk_date_range CHECK (end_time > start_time)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS questionnaires (
    -- [主鍵設定] id 為 BIGINT 且自動遞增，對應 Java Long
    id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '問卷 ID', 

    -- [字串設定] 標題長度可變，使用 VARCHAR 節省空間
    title VARCHAR(150) NOT NULL COMMENT '問卷標題', 

    -- [大文字設定] 說明文字可能很長，使用 TEXT
    description TEXT COMMENT '問卷說明', 

    -- [布林值設定] MySQL 使用 TINYINT(1) 代表 Boolean
    is_published TINYINT(1) DEFAULT 0 COMMENT '發佈狀態 (0:草稿, 1:發佈)',

    -- [時間設定] 包含日期的時間，使用 DATETIME
    start_time DATETIME NOT NULL COMMENT '開始時間', 
    end_time DATETIME NOT NULL COMMENT '結束時間',

    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,

    -- [Check Constraint] 確保結束時間晚於開始時間 (資料庫層級防呆)
    CONSTRAINT chk_date_range CHECK (end_time > start_time) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 題目表
CREATE TABLE questions (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    
    -- [外來鍵欄位] 連結到問卷主檔
    questionnaire_id BIGINT NOT NULL,
    
    q_title VARCHAR(255) NOT NULL,
    q_type ENUM('Single', 'Multi', 'Text') NOT NULL COMMENT '題型',
    
    -- [JSON 欄位] 儲存選項陣列 [{"code":0, "val":"A"}, ...]
    options JSON COMMENT '選項清單', 
    
    sort_order INT DEFAULT 0,

    -- [外來鍵約束] 當問卷被刪除(DELETE)時，題目也會連帶刪除(CASCADE)
    CONSTRAINT fk_questionnaire 
    FOREIGN KEY (questionnaire_id) 
    REFERENCES questionnaires(id) 
    ON DELETE CASCADE 
);

-- 填寫者表 (示範 Unique 與 Check)
CREATE TABLE respondents (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    questionnaire_id BIGINT NOT NULL,
    
    email VARCHAR(100) NOT NULL,
    name VARCHAR(50) NOT NULL,
    
    -- [Check Constraint] 限制年齡必須填寫合理數值
    age INT CHECK (age >= 10 AND age <= 100), 
    
    submitted_at DATETIME DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_resp_questionnaire 
    FOREIGN KEY (questionnaire_id) 
    REFERENCES questionnaires(id) 
    ON DELETE CASCADE,

    -- [複合 Unique Key] 確保同一份問卷 (questionnaire_id) 同一個 email 只能填一次
    CONSTRAINT unique_user_response UNIQUE (questionnaire_id, email) 
);

-- [新增欄位] 客戶希望紀錄問卷的「瀏覽次數」
ALTER TABLE questionnaires 
ADD view_count INT DEFAULT 0 COMMENT '瀏覽次數';

-- [修改欄位] 發現標題 VARCHAR(150) 不夠用，擴充到 255
ALTER TABLE questionnaires 
MODIFY title VARCHAR(255) NOT NULL;

-- [刪除欄位] 假設我們不再需要紀錄填寫者的年齡
ALTER TABLE respondents 
DROP COLUMN age;

-- [建立索引] 加快使用者透過「Email」查詢填寫紀錄的速度
CREATE INDEX idx_respondent_email ON respondents(email); -- 

-- [建立檢視表] 建立一個虛擬表，專門用來查看「進行中」的問卷 (簡化查詢)
-- 邏輯：發佈狀態為 1 且 當前時間介於開始與結束時間之間
CREATE VIEW active_surveys_view AS
SELECT id, title, start_time, end_time
FROM questionnaires
WHERE is_published = 1 
  AND NOW() BETWEEN start_time AND end_time; -- 

-- 使用方式：直接查 View 即可，不用每次寫過濾條件
-- SELECT * FROM active_surveys_view;