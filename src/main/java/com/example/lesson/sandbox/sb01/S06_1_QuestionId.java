package com.example.lesson.sandbox.sb01;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor // 自動生成無參數建構子
@AllArgsConstructor // 自動生成全參數建構子
public class S06_1_QuestionId implements Serializable {
    private Integer questionnaireId;
    private Integer questionId;
    // equals 和 hashCode 會由 @Data 自動產出
}