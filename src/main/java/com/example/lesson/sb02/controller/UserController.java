package com.example.lesson.sb02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson.sb02.dto.UserDTO;
import com.example.lesson.sb02.service.UsersService;
import com.example.lesson.sb02.vo.UserVO;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UsersService userService;

    @GetMapping("/{id}")
    public Long getUser(@PathVariable("id") Long id) {
    	System.out.println("id = " + id);
//    	userService.generateTestData();
//    	
//    	// 1. 從 Service 拿到 DTO
//        UserDTO dto = userService.getUserById(id);
//
//        // 2. 將 DTO 轉換為前端需要的 VO 格式
//        UserVO vo = new UserVO(dto.username(),dto.email(),dto.status() == 1 ? "帳號啟用中" : "帳號已停用");
//        return ResponseEntity.ok(vo);
    	return id;
    }
    
    @GetMapping("/user")
    public Integer getUser(@RequestParam( value = "limit", required = false, defaultValue = "10" )  int limit) {        
    	System.out.println("limit = " + limit);
    	return limit;
    }
    
}

