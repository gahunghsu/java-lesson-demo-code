package com.example.lesson.sandbox.ch24;

import java.util.HashMap;
import java.util.Map;

import tools.jackson.databind.ObjectMapper;

public class S19_MapJsonExample {
	public static void main(String[] args) {
        try {
            // 1. 建立 Map 並放入資料
            Map<String, Object> map = new HashMap<>();
            map.put("id", 101);
            map.put("name", "Gemini");
            map.put("role", "AI Assistant");

            // ---------------------------------------------------------
            // 2. 高效走訪 (entrySet)
            // ---------------------------------------------------------
            System.out.println("--- 開始走訪 Map ---");
            // 直接取得包含 Key 與 Value 的 Entry 物件，比使用 keySet() 後再 get() 更快
            for (Map.Entry<String, Object> e : map.entrySet()) {
                String key = e.getKey();
                Object val = e.getValue();
                System.out.println("Key: " + key + ", Value: " + val);
            }

            // ---------------------------------------------------------
            // 3. JSON 序列化 (使用 Jackson ObjectMapper)
            // ---------------------------------------------------------
            ObjectMapper mapper = new ObjectMapper();

            // 將 Map 轉換為 JSON 字串 (writeValueAsString)
            String json = mapper.writeValueAsString(map);
            System.out.println("\n--- JSON 序列化結果 ---");
            System.out.println(json);

            // 將 JSON 字串轉回 Map (readValue)
            Map<String, Object> deserializedMap = mapper.readValue(json, Map.class);
            System.out.println("\n--- 反序列化後的資料測試 ---");
            System.out.println("Name from Map: " + deserializedMap.get("name"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
