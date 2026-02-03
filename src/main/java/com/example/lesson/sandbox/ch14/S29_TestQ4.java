package com.example.lesson.sandbox.ch14;

public class S29_TestQ4 {
	
}

class Bird {
    // 父類別定義為 protected
    protected void fly() {
        System.out.println("Bird is flying");
    }
}

class Eagle extends Bird {
    // 錯誤示範：預設權限（default/package-private）比 protected 還要嚴格
    // 這會導致編譯錯誤：'fly()' in 'Eagle' clashes with 'fly()' in 'Bird'; 
    // attempting to assign weaker access privileges ('package-private'); was 'protected'
    
    /* void fly() { 
        System.out.println("Eagle is flying");
    } 
    */

    // 正確做法：必須維持 protected 或放大成 public
    @Override
    public void fly() {
        System.out.println("Eagle is flying high!");
    }
}
