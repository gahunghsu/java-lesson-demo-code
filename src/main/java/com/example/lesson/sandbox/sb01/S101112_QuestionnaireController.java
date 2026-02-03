package com.example.lesson.sandbox.sb01;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

// 1. @CrossOrigin: 允許不同網域的前端 (如 localhost:3000) 呼叫此 API [cite: 180, 181]
@CrossOrigin
// 2. @RestController: 等同於 @Controller + @ResponseBody, 專門回傳 JSON [cite: 153, 154]
@RestController
@RequestMapping("/api/questionnaire") // 設定基礎路徑
public class S101112_QuestionnaireController {

    @Autowired
    private S09_QuestionnaireService questionnaireService;

    // 3. @PostMapping: 簡化的 @RequestMapping, 專門處理新增請求 [cite: 165]
    // 4. @RequestBody: 將前端傳來的 JSON 字串轉換為 Java 物件 [cite: 167]
    @PostMapping
    public S0203_Questionnaire create(@RequestBody S0203_Questionnaire q) {
        // 呼叫 Service 執行業務邏輯
        return questionnaireService.createQuestionnaire(q);
    }

    // 範例: @GetMapping 處理查詢 [cite: 164]
    @GetMapping
    public String hello() {
        return "API is working!";
    }
}

/*
3. 講師口語重點 (Talking Points):
● 第 11 行:現在開發 API，我們一律用 @RestController，這樣就不用每個方法都寫
@ResponseBody 了 11。
● 第 20 行: @RequestBody 是關鍵。如果前端送 JSON 過來，沒加這個註釋，參數 q 會是空的
(null) 12。
● 第 9 行: 如果之後前端同學跟你抱怨說連不上 API 出現 CORS 錯誤，記得回來加上
@CrossOrigin 這張「通行證」13。
*/
