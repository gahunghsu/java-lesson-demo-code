package com.example.lesson.sb02.vo;

public record UserVO(
	    String name,
	    String contact,
	    String statusText // 將 1/0 轉換為 "啟用/停用"
	) {}

