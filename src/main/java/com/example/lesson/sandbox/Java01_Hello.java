package com.example.lesson.sandbox;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class Java01_Hello {


    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Hello");

        // Example usage of StringRedisTemplate
        // stringRedisTemplate.opsForValue().set("key", "value");
    }
}