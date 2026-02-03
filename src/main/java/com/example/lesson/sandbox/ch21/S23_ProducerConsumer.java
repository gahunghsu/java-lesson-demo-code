package com.example.lesson.sandbox.ch21;

public class S23_ProducerConsumer {
    /**
     * 1. 教學目標
     * 展示 wait() 與 notify() 的協作機制。這是執行緒通訊最經典的範例 (生產者與消費者)。
     *
     * 3. 講師備課指引
     * - 流程解說 :
     *   1. t1 啟動，發現 10000 < 15000，呼叫 wait()，釋放鎖並卡住。
     *   2. t2 啟動，存入 10000，變為 20000，呼叫 notify()。
     *   3. t1 被喚醒，迴圈檢查 balance < amount 不成立，執行扣款。
     * - 關鍵字區分 : 詢問學生 wait() 和 sleep() 的最大差別? (wait 會釋放鎖，sleep 不會)。
     */
    public static void main(String[] args) {
        Bank bank = new Bank();

        // 提款執行緒 (消費者)
        Thread t1 = new Thread() {
            public void run() {
                // 嘗試提款 15000 (超過初始 10000，會進入 wait)
                bank.withdraw(15000);
            }
        };

        // 存款執行緒 (生產者)
        Thread t2 = new Thread() {
            public void run() {
                try { Thread.sleep(2000); } catch (Exception e) {} // 模擬延遲，確保 t1 先跑並卡住
                // 存款 10000，足夠讓 t1 提款
                bank.deposit(10000);
            }
        };

        t1.start();
        t2.start();
    }

    static class Bank {
        int balance = 10000; // 初始餘額

        // 提款方法
        synchronized void withdraw(int amount) {
            System.out.println("準備取款: " + amount);

            // 檢查餘額，若不足則等待
            while (balance < amount) {
                System.out.println("金額不足 (" + balance + " < " + amount + ")，進入等待...");
                try {
                    wait(); // 釋放鎖，進入等候池
                } catch (Exception e) {
                    System.out.println(e);
                }
            }

            // 被喚醒且餘額足夠後，執行扣款
            balance -= amount;
            System.out.println("取款完成，剩餘餘額: " + balance);
        }

        // 存款方法
        synchronized void deposit(int amount) {
            System.out.println("存入存款: " + amount);
            balance += amount;
            System.out.println("存款完成，目前餘額: " + balance);

            notify(); // 喚醒正在 wait 的執行緒
        }
    }
}
