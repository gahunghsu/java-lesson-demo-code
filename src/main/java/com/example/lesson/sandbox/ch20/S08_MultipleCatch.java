package com.example.lesson.sandbox.ch20;

import java.util.*;

public class S08_MultipleCatch {
    /**
     * 1. 教學目標
     * 證明 catch 區塊是有順序性的。若將父類別異常 (Exception) 放在子類別異常 (ArithmeticException) 之前，編譯器會報錯 (Unreachable code)。
     *
     * 3. 講師備課指引
     * - 觀念譬喻 : 可以用「捕魚」來比喻。如果你先用網眼最小的網子 (Specific Exception) 撈，再用大網子 (Parent Exception) 撈，是合理的。反之，如果你先用大網子，小魚大魚全被撈走了，後面的小網子就沒用了 (Unreachable)。
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("請輸入除數:");

        try {
            int x = 10;
            int y = scanner.nextInt(); // 可能拋出 InputMismatchException
            System.out.println(x / y); // 可能拋出 ArithmeticException
        } catch (InputMismatchException e) {
            System.out.println("輸入格式錯誤");
        } catch (ArithmeticException e) {
            System.out.println("算術錯誤");
        } catch (Exception e) {
            // 正確寫法: 放在最後當作「安全網」
            System.out.println("其他未知的錯誤: " + e);
        }
    }
}
