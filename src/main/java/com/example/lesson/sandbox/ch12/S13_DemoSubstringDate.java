package com.example.lesson.sandbox.ch12;

public class S13_DemoSubstringDate {
    /**
     * 1. 教學目標
     * 練習 indexOf 定位分隔符號，再搭配 substring 精準取出資料。
     *
     * 3. 講師講解重點 (Talking Points)
     * - 動態切割 : 強調不要寫死 substring(0, 4)，因為如果日期格式變成 "113/12/31" (民國年)，寫死的索引就會錯。使用 indexOf 定位才是強健的寫法。
     * - 包頭不包尾 : 再次複習 substring(0, 4) 不包含索引 4。
     */
    public static void main(String[] args) {
        String date = "2024/12/31";
        System.out.println("原始日期: " + date);

        // 1. 找到第一個 '/' 的位置
        int firstSlash = date.indexOf('/');

        // 2. 取出年份 (從 0 到 slash)
        // substring(start, end) -> 包頭不包尾
        String year = date.substring(0, firstSlash);

        // 3. 找到最後一個 '/' 的位置, 取出日
        int lastSlash = date.lastIndexOf('/');
        String day = date.substring(lastSlash + 1); // +1 是為了跳過斜線本身

        System.out.println("年份: " + year);
        System.out.println("日期: " + day);
        
        String month = date.substring(firstSlash + 1, lastSlash);
        System.out.println("月份: " + month);
    }
}
