package com.example.lesson.sb02.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "person_info") // [教學重點]: 這是資料庫真實的表名 (Snake Case)
@Data
@NoArgsConstructor 
@AllArgsConstructor
public class PersonInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // [教學重點]: JPQL 查詢時使用 "name"，對應資料庫的 "user_name"
    @Column(name = "user_name", nullable = false)
    private String name;

    private Integer age;

    private LocalDate entryDate;

    public PersonInfo(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
