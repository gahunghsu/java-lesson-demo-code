package com.example.lesson.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.Duration;

/**
 * OTP (One-Time Password) 服務層
 * 負責處理驗證碼的生命週期：生成、儲存(Redis)、發送(Email) 與 驗證。
 */
@Service
public class OtpService {

    // 使用 StringRedisTemplate 是因為 OTP 通常是純字串操作，效能較好且易於維護
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private JavaMailSender mailSender;

    // 設定 OTP 的有效期限 (TTL)。此處設定為 2 分鐘，過期後 Redis 會自動清除資料
    private static final Duration OTP_DURATION = Duration.ofMinutes(2);

    /**
     * 發送 OTP 的主要業務邏輯
     *
     * @param email 接收驗證碼的電子郵件地址
     */
    public void sendOtp(String email) {
        // 1. 生成高強度的隨機 6 位數驗證碼
        String otp = generateOtp();

        // 2. 將驗證碼存入 Redis
        // Key 設計規範：使用 "前綴:識別值" (OTP:email) 以避免 Key 衝突
        // 同時設定 TTL (Time-To-Live)，利用 Redis 特性實現自動過期
        String redisKey = "OTP:" + email;
        redisTemplate.opsForValue().set(redisKey, otp, OTP_DURATION);

        // 3. 透過郵件發送驗證碼給使用者
        sendEmail(email, otp);

        // 僅供開發階段除錯使用，正式環境建議使用 Logger 記錄並遮蔽部分資訊
        System.out.println("OTP sent to " + email + ": " + otp);
    }

    /**
     * 驗證使用者輸入的 OTP 是否正確
     *
     * @param email 使用者信箱 (用於查找 Redis Key)
     * @param inputOtp 使用者輸入的驗證碼
     * @return 驗證成功回傳 true，失敗或過期回傳 false
     */
    public boolean verifyOtp(String email, String inputOtp) {
        String redisKey = "OTP:" + email;

        // 從 Redis 獲取暫存的驗證碼
        String storedOtp = redisTemplate.opsForValue().get(redisKey);

        // 驗證邏輯：
        // 1. 檢查 storedOtp 是否為 null (若為 null 代表已過期或不存在)
        // 2. 比對 Redis 中的值與使用者輸入是否一致
        if (storedOtp != null && storedOtp.equals(inputOtp)) {
            // [資安最佳實踐] 驗證成功後立即刪除 OTP
            // 防止 "Replay Attack" (重放攻擊)，確保該驗證碼無法被二次使用
            redisTemplate.delete(redisKey);
            return true;
        }
        return false;
    }

    // --- 私有輔助方法 (Helper Methods) ---

    /**
     * 生成 6 位數隨機數字字串
     * 使用 SecureRandom 而非 Random，以確保密碼學上的安全性 (不可預測性)
     */
    private String generateOtp() {
        SecureRandom random = new SecureRandom();
        int num = random.nextInt(1000000); // 生成 0 ~ 999999 之間的數字
        return String.format("%06d", num); // 格式化為 6 位數，不足位數補 0 (例如: 5 -> 000005)
    }

    /**
     * 建構並發送簡易郵件
     */
    private void sendEmail(String to, String otp) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("您的驗證碼 (OTP)");
        message.setText("親愛的使用者您好，\n\n您的驗證碼是：" + otp + "\n請在 2 分鐘內使用，逾期失效。");
        mailSender.send(message);
    }
}