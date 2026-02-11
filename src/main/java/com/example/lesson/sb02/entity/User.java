package com.example.lesson.sb02.entity;

// Spring Boot 3 必須使用 jakarta.*，而非 javax.*
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Entity 標示這是一個與資料庫映射的類別
 */
@Entity
@Table(name = "users") // 指定資料庫中的 Table 名稱
@Data
@NoArgsConstructor // 自動生成無參數建構子
@AllArgsConstructor // 自動生成全參數建構子
public class User {

    @Id // 對應 Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 對應 Auto Increment
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

	private String email;

    // 為了方便演示用的建構子
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
}

