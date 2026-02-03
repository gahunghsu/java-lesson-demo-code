package com.example.lesson.sandbox.sb01;

import jakarta.persistence.*;

// 這是錯誤示範與正確示範的對照
public class S04_EntityTypeTrapDemo {

    // 情境 A: 使用 int (基本型別) [cite: 69]
    @Entity
    @Table(name = "wrong_entity")
    public static class WrongEntity {
        @Id
        private int id; // 預設值為 0
        
        // ...
        public int getId() { return id; }
        public void setId(int id) { this.id = id; }
    }

    // 情境 B: 使用 Integer (物件型別) - 推薦做法 [cite: 66]
    @Entity
    @Table(name = "correct_entity")
    public static class CorrectEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id; // 預設值為 null
        
        // ...
        public Integer getId() { return id; }
        public void setId(Integer id) { this.id = id; }
    }

    /*
     * 講師演示邏輯:
     * 1. 當我們執行 repository.save(wrongEntity);
     * 2. 如果資料庫生成 ID 為 100。
     * 3. 回傳的 wrongEntity.getId() 依然可能是 0 (視 JPA 實作與配置而定，因為 0 是 int 的預設值，JPA 難
     * 以判斷這是新資料還是舊資料。
     *
     * 4. 當我們執行 repository.save(correctEntity);
     * 5. 回傳的 correctEntity.getId() 會立即更新為 100 [cite: 68]。
     */
}

/*
3. 講師口語重點 (Talking Points):
● 請大家看 情境 A 的 int id。在 Java 中，int 預設是 0。當 JPA 存檔後，如果沒有強制回寫，你
拿到的物件 ID 還是 0 3。
● 情境 B 是標準答案。使用 Integer 且預設為 null，JPA 知道這是一筆「全新的資料」，存檔後會
把 DB 產生最新的 ID (例如 5) 塞回來給你 4。
*/
