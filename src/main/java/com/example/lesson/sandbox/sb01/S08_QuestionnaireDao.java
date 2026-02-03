package com.example.lesson.sandbox.sb01;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

// 1. @Repository: 宣告這是 DAO 層 [cite: 121]
// 2. 繼承 JpaRepository<T, ID>: T 是 Entity 類別, ID 是主鍵的型別 [cite: 123, 124, 125]
@Repository
public interface S08_QuestionnaireDao extends JpaRepository<S0203_Questionnaire, Integer> {

    // 這裡什麼都不用寫，就已經擁有 save, findById, delete, findAll 等功能

    // 進階:如果需要根據標題查詢，只需定義方法名
    // List<Questionnaire> findByTitle(String title);
    List<S0203_Questionnaire> findByTitle(String title);
}

/*
3. 講師口語重點 (Talking Points):
● 重點在第 10 行的泛型 <Questionnaire, Integer>。
● 請學生檢查:前面的 Questionnaire 有沒有導對 package? 後面的 Integer 是不是跟 Entity
裡面的 @Id 型態一樣? 千萬不能寫小寫的 int 9。
*/
