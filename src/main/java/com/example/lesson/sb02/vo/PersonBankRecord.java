package com.example.lesson.sb02.vo;

/**
 * 使用 Java Record 定義 VO
 * Record 會自動生成：全參數建構子、Getter (不帶 get 前綴)、toString、equals 與 hashCode
 */
public record PersonBankRecord(String name, Integer age, Double balance) { }
