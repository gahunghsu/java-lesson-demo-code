package com.example.lesson.sandbox.sb01;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service // 1. 宣告這是業務邏輯層 [cite: 137]
public class S09_QuestionnaireService {

    @Autowired // 2. 自動依賴注入 (DI) [cite: 139]
    private S08_QuestionnaireDao questionnaireDao;

    public S0203_Questionnaire createQuestionnaire(S0203_Questionnaire q) {
        // 3. 直接使用注入進來的 dao 物件進行存檔 [cite: 143]
        return questionnaireDao.save(q);
    }
}

/*
3. 講師口語重點 (Talking Points):
● 請看第 11 行的 @Autowired。這就像是 Service 是大腦，它需要手腳 (Dao) 來拿東西。
● 我們不用寫 new QuestionnaireDao()，Spring 容器會自動幫我們把做好的 Dao 物件「接」過
來放在這裡 10101010 。
*/
