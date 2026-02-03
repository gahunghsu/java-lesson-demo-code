package com.example.lesson.sandbox.sb01;

import jakarta.persistence.*;

// 1. @Entity: 告訴 Spring 這是要對應資料庫的類別 
// 2. @Table: 指定資料庫中的表名為 "questionnaire" 
@Entity
@Table(name = "questionnaire")
public class S0203_Questionnaire {

    // 3. @Id: 這是身分證字號 (Primary Key) 
    // 4. @GeneratedValue: 委託資料庫自動生成流水號 (Auto Increment) 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id; // 注意:這裡使用 Integer 而非 int (詳見 Slide 04)

    // 5. @Column: 對應資料表欄位，可設定長度與是否為空 
    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "description")
    private String description;

    // 必須保留無參數建構子，JPA 才能運作
    public S0203_Questionnaire() {
    }

    // Getter & Setter (省略以節省版面)
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}

/*
3. 講師口語重點 (Talking Points):
● 第 7 行: 請學生注意，如果 Class 名稱 (Questionnaire) 和資料表名稱不一樣，一定要加
@Table(name="...")，否則 JPA 找不到家 1。
● 第 14 行: 強調 GenerationType.IDENTITY。請提醒學生，這對應到 MySQL 的 AI (Auto
Increment) 設定，如果資料庫沒勾選這個，程式會報錯 2。
*/
