package com.example.lesson.sandbox.ch22;

import java.io.*;

public class S06_ByteStreamCopy {
    /**
     * 1. 教學目標
     * 展示如何使用基礎的位元串流 (FileInputStream, FileOutputStream) 來複製任何二進位檔案 (如圖片)。說明 read() 與 write() 的基本用法。
     *
     * 3. 講師備課指引
     * - 關鍵方法 : 講解 src.available() 可以取得檔案大小，讓我們能建立一個剛剛好的 byte 陣列。
     * - 風險提示 : 這種「一次讀全部」的方法只適合小檔案。如果檔案好幾 GB，記憶體會爆掉，這時就需要「緩衝區串流」的分批讀取概念。
     */
    public static void main(String[] args) {
        try {
            // 1. 建立輸入串流 (讀取原始圖片)
            // 講師提醒: 請確保專案根目錄下有 "洪錦魁 1.jpg" 這個檔案
            // 若無檔案，請先隨意放一張圖片改名測試
            File inputFile = new File("洪錦魁 1.jpg");
            if (!inputFile.exists()) {
                System.out.println("找不到檔案: " + inputFile.getAbsolutePath());
                System.out.println("請先準備一張圖片命名為 '洪錦魁 1.jpg' 放入專案根目錄");
                return;
            }

            FileInputStream src = new FileInputStream(inputFile);

            // 2. 建立輸出串流 (寫入新圖片)
            FileOutputStream dst = new FileOutputStream("洪錦魁 2.jpg");

            // 3. 檢查檔案大小並建立對應的 byte 陣列 (一次搬運)
            System.out.println("檔案大小: " + src.available() + " bytes");
            byte[] pic = new byte[src.available()];

            // 4. 讀取並寫入
            src.read(pic); // 從輸入串流讀取圖檔資料存入 pic 陣列
            dst.write(pic); // 將 pic 陣列資料寫到輸出串流

            // 5. 關閉串流 (重要！)
            src.close();
            dst.close();

            System.out.println("圖檔拷貝成功");
        } catch (IOException e) {
            System.out.println("發生錯誤: " + e);
        }
    }
}
