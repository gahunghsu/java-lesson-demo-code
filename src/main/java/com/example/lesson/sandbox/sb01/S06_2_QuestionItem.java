package com.example.lesson.sandbox.sb01;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 步驟 2: 在 Entity 上使用 @IdClass
@Entity
@IdClass(S06_1_QuestionId.class) // 指定剛剛寫的主鍵類別
@Table(name = "question_item")
@Data
@NoArgsConstructor // 自動生成無參數建構子
@AllArgsConstructor // 自動生成全參數建構子
public class S06_2_QuestionItem {

    @Id // 第一個 PK
    @Column(name = "questionnaire_id")
    private Integer questionnaireId;

    @Id // 第二個 PK
    @Column(name = "question_id")
    private Integer questionId;

    @Column(name = "content")
    private String content;

	 // Getters 和 Setters 會由 @Data 自動產出
	 // toString() 也會自動產出，方便 Log 觀察
}

/*
3. 講師口語重點 (Talking Points):
● 請看 QuestionItem 類別，我們有 兩個 @Id 7。這在一般情況下是不允許的。
● 所以我們在類別頭頂加上 @IdClass(QuestionId.class)，告訴 JPA:「這兩個 ID 的規則，請去
參考 QuestionId 這個類別」8。
*/
