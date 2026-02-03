package com.example.lesson.sandbox.sb01;

import java.io.Serializable;
import java.util.Objects;

// 步驟 1: 定義主鍵類別 (必須實作 Serializable) [cite: 94]
public class S06_1_QuestionId implements Serializable {
    
    private Integer questionnaireId; // 對應 Entity 中的屬性名稱 [cite: 95]
    private Integer questionId;

    public S06_1_QuestionId() {} // 必須有無參數建構子 [cite: 96]
    
    public S06_1_QuestionId(Integer questionnaireId, Integer questionId) {
        this.questionnaireId = questionnaireId;
        this.questionId = questionId;
    }

    // // 必須實作 equals 和 hashCode (省略)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        S06_1_QuestionId that = (S06_1_QuestionId) o;
        return Objects.equals(questionnaireId, that.questionnaireId) && 
               Objects.equals(questionId, that.questionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(questionnaireId, questionId);
    }
}
