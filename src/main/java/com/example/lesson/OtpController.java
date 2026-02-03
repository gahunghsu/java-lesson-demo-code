package com.example.lesson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.lesson.service.OtpService;

/**
 * OTP 控制層 (Controller)
 * 這是後端應用程式的「門面」，負責定義 API 的 URL 路徑 (Endpoint)。
 * 它的職責是：接收 HTTP 請求 -> 驗證參數 -> 呼叫 Service 執行業務 -> 回傳結果。
 */
@RestController
@RequestMapping("/api/otp") // 設定此 Controller 所有 API 的基礎路徑
public class OtpController {

    @Autowired
    private OtpService otpService;

    /**
     * API: 請求發送驗證碼
     * URL: POST /api/otp/send
     * 作用: 觸發後端生成 OTP 並發送郵件
     *
     * @param email 接收者的信箱 (必填參數)
     * @return 處理結果的文字訊息
     */
    @PostMapping("/send")
    public String send(@RequestParam("email") String email) {
        // Controller 不負責具體邏輯（如怎麼產生亂數、怎麼寄信），
        // 而是直接命令 Service 去執行 "sendOtp" 這個動作。
        otpService.sendOtp(email);
        
        return "驗證碼已發送至您的信箱，請查收。";
    }

    /**
     * API: 執行驗證
     * URL: POST /api/otp/verify
     * 作用: 比對使用者輸入的驗證碼是否正確
     *
     * @param email 用於識別使用者的信箱 (Key)
     * @param code 使用者輸入的 6 位數驗證碼
     * @return 驗證成功或失敗的狀態訊息
     */
    @PostMapping("/verify")
    public String verify(@RequestParam("email") String email, @RequestParam("code") String code) {
        // 呼叫 Service 進行比對，並取得 boolean 結果
        boolean isValid = otpService.verifyOtp(email, code);

        // Controller 根據 Service 的回傳結果，決定要回應給前端什麼訊息 (或 HTTP 狀態碼)
        if (isValid) {
            return "驗證成功！";
        } else {
            return "驗證失敗：驗證碼錯誤或已過期，請重新獲取。";
        }
    }
}