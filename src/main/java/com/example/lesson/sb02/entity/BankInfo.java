package com.example.lesson.sb02.entity;

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
@Table(name = "bank_info")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_number")
    private String accountNumber;

    private Double balance;

    // [教學重點]: 為了演示 JOIN，這裡簡單儲存 person_id
    // 實戰中通常會設定 @OneToOne 或 @ManyToOne 關聯
    @Column(name = "person_id")
    private Long personId; 
}

