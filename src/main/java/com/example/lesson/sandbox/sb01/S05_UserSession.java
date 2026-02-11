package com.example.lesson.sandbox.sb01;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
// import org.hibernate.annotations.Type; // Hibernate specific

@Entity
@Table(name = "user_session")
@Data
@NoArgsConstructor // 自動生成無參數建構子
@AllArgsConstructor // 自動生成全參數建構子
public class S05_UserSession {

    // 1. @Type(type = "uuid-char"): 告訴 Hibernate 把這個欄位當作 UUID 字串存進 DB (VARCHAR/CHAR)
    // Note: 在較新版本的 Hibernate (6.x+) 中，UUID 通常會自動映射，或者使用 @JdbcTypeCode(SqlTypes.CHAR)。
    // 原文註解: @Type(type = "uuid-char")
    @Id
    @Column(name = "session_id")
    // @Type(type = "uuid-char") 
    private UUID id = UUID.randomUUID(); // 2. 在 Java 端直接生成初始值

    @Column(name = "user_name")
    private String userName;
}

/*
3. 講師口語重點 (Talking Points):
● 注意第 9 行的 private UUID id = UUID.randomUUID();。跟流水號不同，UUID 我們通常自己
在 Java 這邊生出來 5。
● 第 8 行的 @Type 非常重要。資料庫通常看不懂 Java 的 UUID 物件，我們要告訴它「請把它
當作字串 (char) 來處理」6。
*/
