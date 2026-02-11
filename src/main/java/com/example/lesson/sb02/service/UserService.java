package com.example.lesson.sb02.service;

import org.springframework.stereotype.Service;

import com.example.lesson.sb02.entity.User;
import com.example.lesson.sb02.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {
     private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * [基礎]: 演示 Optional 的優雅處理 (Java 17+ 推薦寫法)
     */
    public User getUserInfo(Long id) {
        // findById 回傳 Optional，避免直接 .get()
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("找不到使用者 ID: " + id));
    }
    
    //[基礎]: 刪除操作
    @Transactional
    public void deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            System.out.println("使用者不存在，無法刪除");
        }
    }

    /**
     * [進階]: 修改操作必須在 Transaction 內執行。
     * 若拿掉 @Transactional，會拋出 TransactionRequiredException。
     */
    @Transactional // 👈 關鍵：所有的 Update/Delete 都需要事務支援
    public void updateUserEmail(String name, String newEmail) {
        int rowsAffected = userRepository.updateEmailByName(name, newEmail);
        System.out.println("🔥 資料庫影響筆數: " + rowsAffected);
    }
}
