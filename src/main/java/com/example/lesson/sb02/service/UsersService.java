package com.example.lesson.sb02.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.lesson.sb02.dto.UserDTO;
import com.example.lesson.sb02.entity.UserEntity;
import com.example.lesson.sb02.repository.UsersRepository;

@Service
public class UsersService {
	@Autowired
    private UsersRepository userRepository;
    public UserDTO getUserById(Long id) {
        UserEntity entity = userRepository.findById(id).orElseThrow(() -> new RuntimeException("使用者不存在"));
        
        // 將 Entity 轉換為 DTO
        return new UserDTO(entity.getId(), entity.getUsername(), entity.getEmail(), entity.getStatus());
    }
    
    @Transactional
    public List<UserEntity> generateTestData() {
        // 先清空舊資料 (選用，依需求而定)
        // userRepository.deleteAll(); 

        List<UserEntity> users = new ArrayList<>();
        
        // 使用一個簡單的迴圈或 List.of 來建立資料
        String[] names = {"alice_lee", "bob_chen", "charlie_wang", "david_lin", "emma_wu", 
                          "frank_ho", "grace_hsu", "hank_liu", "ivy_huang", "jack_tsai"};
        
        for (int i = 0; i < names.length; i++) {
            UserEntity user = new UserEntity();
            user.setUsername(names[i]);
            user.setPassword("pass" + i); // 測試用簡單密碼
            user.setEmail(names[i] + "@example.com");
            user.setStatus(i % 3 == 0 ? 0 : 1); // 模擬不同狀態
            users.add(user);
        }
        
        return userRepository.saveAll(users);
    }

}
