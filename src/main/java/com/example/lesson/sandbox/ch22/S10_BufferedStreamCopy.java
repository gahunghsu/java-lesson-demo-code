package com.example.lesson.sandbox.ch22;

import java.io.*;

public class S10_BufferedStreamCopy {
    /**
     * 1. 教學目標
     * 雖然原檔 ch22_6.java 展示了 BufferedOutputStream 的語法，但為了讓學生更有感，建議講師口頭說明或稍微修改程式碼，強調 flush() 的作用。
     *
     * 3. 講師備課指引
     * - 架構圖解 : 畫出 BufferedOutputStream 包住 FileOutputStream 的樣子，說明這就是「裝飾器模式 (Decorator Pattern)」。
     * - 效能譬喻 : 解釋這就像是「累積一車垃圾再一次倒掉 (Buffer)」，而不是「每撿一個垃圾就跑去垃圾場一次 (No Buffer)」。
     */
    public static void main(String[] args) {
        try {
            // 1. 建立基礎節點串流
            FileOutputStream obj = new FileOutputStream("ch22_6.txt");

            // 2. 建立緩衝區處理串流 (裝飾器模式)
            BufferedOutputStream buf = new BufferedOutputStream(obj);

            String str = "Welcome to MINGCHI University of Technology";
            byte[] bArray = str.getBytes(); // 字元陣列改為 byte 陣列

            // 3. 寫入資料 (此時資料還在記憶體緩衝區 Buffer 中)
            buf.write(bArray);

            // 4. 強制寫入硬碟 (即使緩衝區沒滿)
            // 講師強調: 如果不 flush 也不 close，資料可能會遺失
            buf.flush();

            // 5. 關閉最外層串流即可 (內部會自動關閉 obj)
            // obj.close(); // 這行可以不用寫，buf.close() 會幫忙
            buf.close();

            System.out.println("輸出成功!");
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
