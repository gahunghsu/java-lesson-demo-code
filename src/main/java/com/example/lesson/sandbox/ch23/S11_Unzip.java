package com.example.lesson.sandbox.ch23;

import java.io.*;
import java.util.zip.*;

public class S11_Unzip {
    /**
     * 1. 教學目標
     * 展示如何使用 ZipInputStream 搭配 getNextEntry 來逐一還原檔案。
     *
     * 3. 講師備課指引
     * - 關鍵差異 : 壓縮是用 putNextEntry，解壓縮是用 getNextEntry。
     * - 防呆機制 : 原檔程式碼可能沒有處理「父目錄不存在」的問題。講師應特別強調 newFile.getParentFile().mkdirs() 這行的重要性，否則解壓到子目錄時會報錯。
     */
    public static void main(String[] args) throws IOException {
        // 確保有檔案可解壓 (使用 S06 產生的 ch23_2.zip)
        String fileZip = "ch23_2.zip";
        File destDir = new File("unzip_output");

        // 建立解壓目錄
        if (!destDir.exists()) destDir.mkdirs();

        byte[] buffer = new byte[1024];
        ZipInputStream zis = new ZipInputStream(new FileInputStream(fileZip));
        ZipEntry zipEntry = zis.getNextEntry();

        while (zipEntry != null) {
            File newFile = newFile(destDir, zipEntry);
            if (zipEntry.isDirectory()) {
                if (!newFile.isDirectory() && !newFile.mkdirs()) {
                    throw new IOException("Failed to create directory " + newFile);
                }
            } else {
                // 修正: 確保父目錄存在
                File parent = newFile.getParentFile();
                if (!parent.isDirectory() && !parent.mkdirs()) {
                    throw new IOException("Failed to create directory " + parent);
                }

                // 寫入檔案
                FileOutputStream fos = new FileOutputStream(newFile);
                int len;
                while ((len = zis.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);
                }
                fos.close();
            }
            zipEntry = zis.getNextEntry();
        }
        zis.closeEntry();
        zis.close();
        System.out.println("解壓縮完成! 檔案在 unzip_output 目錄中");
    }

    // 安全性檢查: 防止 Zip Slip 漏洞 (路徑穿越攻擊)
    public static File newFile(File destinationDir, ZipEntry zipEntry) throws IOException {
        File destFile = new File(destinationDir, zipEntry.getName());

        String destDirPath = destinationDir.getCanonicalPath();
        String destFilePath = destFile.getCanonicalPath();

        if (!destFilePath.startsWith(destDirPath + File.separator)) {
            throw new IOException("Entry is outside of the target dir: " + zipEntry.getName());
        }

        return destFile;
    }
}
