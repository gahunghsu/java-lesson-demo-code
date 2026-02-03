package com.example.lesson.sandbox.ch14;

import java.io.IOException;

public class S29_TestQ2 {
	public static void main(String[] args) {
        try {
            // 因為 Child ctor 宣告了 throws IOException
            // 所以你在 new 物件的時候，必須用 try-catch 包起來，否則編譯不會過
            Child c = new Child();
            
        } catch (IOException e) {
            System.out.println("捕獲到例外: " + e.getMessage());
        }
    }
	
	
}

class Parent {
    // Parent ctor 宣告會拋出 IOException
    public Parent() throws IOException {
        System.out.println("執行 Parent 建構子...");
        // 模擬發生 IO 錯誤的情況（例如找不到檔案）
        // throw new IOException("父類別初始化失敗"); 
    }
}

// 子類別 (對應選項 C)
class Child extends Parent {
    
    // 規則：子類別 ctor 必須宣告拋出「相同」或「更大」範圍的例外
    // 因為它第一行會隱式呼叫 super(); 而 super() 可能會壞掉
	// 在 Java 中，拋出父類別（更大範圍）的例外也是合法的(Exception)
    public Child() throws IOException {
        super(); // 這行可以不寫，編譯器會自動補，但它就是 IOException 的來源
        System.out.println("執行 Child 建構子...");
    }
}
