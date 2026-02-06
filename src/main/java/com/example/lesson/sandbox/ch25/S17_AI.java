package com.example.lesson.sandbox.ch25;

import java.util.*;
import java.util.stream.Collectors;

// 定義學生物件，就像是我們在資料庫裡的一筆筆記錄
class StudentByAI {
    private String name;
    private int chinese;
    private int english;
    private int math;

    public StudentByAI(String name, int chinese, int english, int math) {
        this.name = name;
        this.chinese = chinese;
        this.english = english;
        this.math = math;
    }

    // Getter 們，就像是學生的個人資料夾標籤
    public String getName() { return name; }
    public int getChinese() { return chinese; }
    public int getEnglish() { return english; }
    public int getMath() { return math; }

    // 計算個人平均的小工具
    public double getAverage() {
        return (chinese + english + math) / 3.0;
    }
}

public class S17_AI {
    public static void main(String[] args) {
        // 準備測試數據（想像這是從 Excel 或資料庫讀進來的）
        List<StudentByAI> students = Arrays.asList(
            new StudentByAI("小明", 80, 70, 50), // 數學不及格
            new StudentByAI("小華", 90, 85, 95),
            new StudentByAI("小雅", 70, 60, 45), // 數學不及格
            new StudentByAI("小強", 65, 75, 80)
        );

        // --- 需求 1：計算每位學生的平均分數，存成 Map ---
        // 這就像是把學生的名字當成「鑰匙」，平均分數當成「寶物」鎖進保險箱
        Map<String, Double> averageMap = students.stream()
            .collect(Collectors.toMap(StudentByAI::getName, StudentByAI::getAverage));
        
        System.out.println("1. 學生平均分數查詢表：" + averageMap);

        // --- 需求 2：數學不及格 (< 60) 且依國文成績由高到低排序，印出姓名 ---
        // 這邊我們用了「過濾 (filter)」和「排序 (sorted)」
        System.out.print("2. 數學不及格名單 (按國文高低排序)：");
        students.stream()
            .filter(s -> s.getMath() < 60) // 篩選數學 < 60 的人
            .sorted(Comparator.comparingInt(StudentByAI::getChinese).reversed()) // 依國文「反向」排序（由高到低）
            .map(StudentByAI::getName) // 只要拿姓名就好，其他資訊不用了
            .forEach(name -> System.out.print(name + " ")); // 逐一印出
        System.out.println();

        // --- 需求 3：使用 mapToInt 計算全班英文總平均 ---
        // 這邊我們把學生物件轉換成「分數流」，再求平均
        students.stream()
            .mapToInt(StudentByAI::getEnglish) // 把 Stream<Student> 轉成 IntStream 分數流
            .average() // 計算平均值，會回傳 OptionalDouble (因為怕 list 是空的)
            .ifPresent(avg -> System.out.printf("3. 全班英文平均分數：%.2f\n", avg));
    }
}