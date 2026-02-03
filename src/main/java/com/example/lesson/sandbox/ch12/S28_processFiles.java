package com.example.lesson.sandbox.ch12;

public class S28_processFiles {
	public static void main(String[] args) {
		String fileList = processFiles(new String[] {
			"Main.java",
			"Utils.JAVA",
			"Readme.txt",
			"Test.Java",
			"image.png"
		});
		System.out.println(fileList); // 輸出: Main;Utils;Test
    }
	
	public static String processFiles(String[] files) {
	    // 1. 準備一個「空籃子」 (StringBuilder)，用來裝最後整理好的檔名
	    StringBuilder sb = new StringBuilder();

	    // 2. 【翻找檔案】把資料夾裡的檔案一個一個拿出來看
	    for (String f : files) {
	        
	        // 3. 【條件篩選】檢查是不是 .java 檔 (不管大小寫都算)
	        // 這就像過濾網，只有符合條件的才能進入下一步
	    	// .java 或 .JAVA 或 .JaVa 都算
	    	// .javac 或 .txt 就不算
	        if (f.toLowerCase().endsWith(".java")) {
	            
	            // 4. 【去副檔名】把後面的 ".java" 撕掉，只留下檔名
	            // 例如 "main.java" 變成 "main"
	            String name = f.substring(0, f.lastIndexOf("."));

	            // 5. 【串接標籤】如果籃子裡已經有東西了，就先加個「;」隔開
	            // 這樣才不會讓兩個檔名黏在一起 (例如 main;test)
	            if (sb.length() > 0) {
	                sb.append(";");
	            }
	            
	            // 6. 把處理好的乾淨檔名放進籃子
	            sb.append(name);
	        }
	    }
	    
	    return sb.toString();
	}
}
