package com.example.lesson.sandbox.ch12;

public class S27_filterSensitiveWords {
	public static void main(String[] args) {
		String filteredWords = filterSensitiveWords("這是一個Apple的產品，另外一個apple也是產品", new String[] {"Apple", "apple"});
		System.out.println(filteredWords);
    }
	
	/**
	 * 需求：將文字中的敏感詞，替換成相同長度的星號（*）
	 * 例如："Apple" 是敏感詞，就要變成 "*****"
	 */
	public static String filterSensitiveWords(String text, String[] badWords) {
	    // 1. 先把原始內容拿在手上，準備開始找、開始改
	    String result = text;

	    // 2. 【一一檢查】從敏感詞清單中，一個一個拿出來比對
	    for (String word : badWords) {
	        
	        // 3. 【製作遮蓋貼紙】看這個敏感詞有幾個字，就準備幾顆星
	        // 例如："bad" 有 3 個字，stars 就會是 "***"
	        String stars = "";
	        for (int i = 0; i < word.length(); i++) {
	            stars += "*";
	        }

	        // 4. 【動手塗鴉】把目前內容中所有出現該詞的地方，全部貼上星星貼紙
	        // 這裡是用新內容 (result) 取代舊內容
	        result = result.replace(word, stars);
	    }

	    // 5. 所有的壞字都塗完了，交出最終的乾淨版本
	    return result;
	}
}
