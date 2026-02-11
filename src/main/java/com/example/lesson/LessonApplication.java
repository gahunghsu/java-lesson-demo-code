package com.example.lesson;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.example.lesson.sb02.entity.User;
import com.example.lesson.sb02.repository.UserRepository;

//Spring Boot 的招牌，有了它才會開始掃描與自動配置
@SpringBootApplication
public class LessonApplication {

	// Java 程式的標準入口 main 方法
	public static void main(String[] args) {
		// 這一行指令啟動了整個 Spring Container
		SpringApplication.run(LessonApplication.class, args);
		// 講師可在此加入一行 Console 輸出，證明程式從這裡開始
		System.out.println("🚀 Lesson 專案啟動成功！");
	}

}

/*
 * 講解重點 程式導讀：指著 @SpringBootApplication 說明這是負責啟動 Spring Boot 的自動配置與元件掃描機制。
 * 
 * 
 * 新手誤區：強調 main 方法是必須的，沒有它，這個 Spring 專案就只是一堆不會動的類別檔。
 */
