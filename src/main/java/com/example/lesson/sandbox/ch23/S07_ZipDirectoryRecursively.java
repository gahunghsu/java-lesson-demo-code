package com.example.lesson.sandbox.ch23;

import java.io.*;
import java.util.zip.*;

public class S07_ZipDirectoryRecursively {
    /**
     * 1. 教學目標
     * 展示如何使用遞迴 (Recursion) 來處理資料夾結構，並強調 ZipEntry 名稱必須包含路徑 (如 "dir/file.txt")，否則結構會扁平化。
     *
     * 3. 講師備課指引
     * - 遞迴概念 : 解釋 zipFile 方法會呼叫自己。如果是檔案就寫入，如果是目錄就進去遍歷。
     * - 隱藏坑 : 特別提醒 childFile.getName() 只會給檔名，必須傳遞 parent path 才能保留資料夾結構。
     */
    public static void main(String[] args) throws IOException {
        // 0. 準備測試目錄結構
        File myDir = new File("myDir");
        myDir.mkdir();
        new File(myDir, "subFile.txt").createNewFile();

        // 準備要壓縮的資料夾
        String sourceFile = "myDir";
        FileOutputStream fos = new FileOutputStream("ch23_3.zip");
        ZipOutputStream zipOut = new ZipOutputStream(fos);

        File fileToZip = new File(sourceFile);

        // 開始遞迴壓縮
        zipFile(fileToZip, fileToZip.getName(), zipOut);

        zipOut.close();
        fos.close();
        System.out.println("資料夾壓縮完成! ");
    }

    private static void zipFile(File fileToZip, String fileName, ZipOutputStream zipOut) throws IOException {
        // 判斷是否為隱藏檔 (可選)
        if (fileToZip.isHidden()) {
            return;
        }

        if (fileToZip.isDirectory()) {
            // 若是目錄，確保名稱以 "/" 結尾
            if (fileName.endsWith("/")) {
                zipOut.putNextEntry(new ZipEntry(fileName));
                zipOut.closeEntry();
            } else {
                zipOut.putNextEntry(new ZipEntry(fileName + "/"));
                zipOut.closeEntry();
            }

            // 遍歷目錄下的所有檔案
            File[] children = fileToZip.listFiles();
            for (File childFile : children) {
                // 遞迴呼叫: 傳入新的路徑名稱 (父目錄/子檔名)
                zipFile(childFile, fileName + "/" + childFile.getName(), zipOut);
            }
            return; // 目錄處理完畢，返回
        }

        // 若是檔案，執行標準壓縮流程
        FileInputStream fis = new FileInputStream(fileToZip);
        ZipEntry zipEntry = new ZipEntry(fileName);
        zipOut.putNextEntry(zipEntry);

        byte[] bytes = new byte[1024];
        int length;
        while ((length = fis.read(bytes)) >= 0) {
            zipOut.write(bytes, 0, length);
        }
        fis.close();
    }
}
