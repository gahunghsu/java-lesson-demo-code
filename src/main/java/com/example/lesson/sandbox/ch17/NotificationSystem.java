import java.util.*;

// --- [介面 Interface]: 定義「行為規範」 ---
// 「團隊開發」的合約，只要是訊息，就必須具備「檢查格式」的能力，才不會造成有人新增「訊息」種類，但沒有「檢查格式」
interface Verifiable {
    boolean validate(); 
}

// --- [抽象類別 Abstract Class]: 定義「共同特徵」 ---
// 所有的訊息都有內容，但「發送」這件事，郵件跟簡訊做法完全不同
abstract class Message implements Verifiable {
    String content;
    String recipient;

    Message(String recipient, String content) {
        this.recipient = recipient;
        this.content = content;
    }

    // [抽象方法]: 強制子類別一定要實作自己的發送邏輯
    abstract void send();

    // [Overload 多載]: 提供不同的顯示方式
    void display() { System.out.println("訊息內容: " + content); }
    void display(String prefix) { System.out.println(prefix + ": " + content); }
}

// --- [子類別 Inheritance]: 實作具體功能 ---
class EmailMessage extends Message {
    EmailMessage(String recipient, String content) { super(recipient, content); }

    @Override
    public boolean validate() {
        // [正規表達式 Regex]: 檢查 Email 格式
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return recipient.matches(regex);
    }

    @Override
    void send() { System.out.println("發送 Email 給 " + recipient + ": " + content); }
}

class SmsMessage extends Message {
    SmsMessage(String recipient, String content) { super(recipient, content); }

    @Override
    public boolean validate() {
        // [字元 char]: 簡單檢查開頭是否為數字
        char firstChar = recipient.charAt(0);
        return Character.isDigit(firstChar) && recipient.length() == 10;
    }

    @Override
    void send() { System.out.println("發送簡訊給 " + recipient + ": " + content); }
}

// --- [主程式]: 展現多型 Polymorphism ---
public class NotificationSystem {
    public static void main(String[] args) {
        // [多型]: 用父類別清單管理不同子類別物件
        List<Message> tasks = new ArrayList<>();
        tasks.add(new EmailMessage("teacher@java.com", "學生說講太快了！"));
        tasks.add(new SmsMessage("0912345678", "收到，我會慢一點。"));

        for (Message m : tasks) {
            if (m.validate()) { //介面是為了**「抽離實作細節」**。主程式不需要知道 validate 是用字元檢查還是用正規表達式檢查，它只需要知道呼叫 validate() 這個方法會成功就好。
                m.send(); // [動態繫結]: 自動根據物件類型決定呼叫哪個 send()
            } else {
                System.out.println("格式錯誤，無法發送！");
            }
        }
    }
}

/*
### 1. 整合程式碼範例

這段程式碼展示了如何利用 **抽象類別** 定義骨架，**介面** 定義規範，並透過 **正規表達式** 進行資料檢查。
  
## 2. 深度拆解：為什麼要這樣做？不這樣做會怎樣？

這部分是你可以直接放進簡報，用來堵住學生嘴巴（笑）的強力邏輯：

| 章節 | 為什麼要這樣寫？ (優點) | 如果不這樣做 (直接寫在一個 Class 裡) |
| --- | --- | --- |
| **字串與 Regex** | **精準且高效**：一行 Regex 就能判斷電子郵件，程式碼極其乾淨。 | 你得用無數個 `if-else`、`indexOf`、`substring` 去檢查 `@` 在哪，程式碼會變成一團亂麻。 |
| **繼承 & 抽象類別** | **減少重複、強制標準**：所有訊息都有 `recipient`。抽象類別確保了「發送前一定要有內容」。 | 每個地方都要重寫 `recipient` 變數。如果有人忘記寫 `send()` 方法，程式執行到一半才會崩潰。 |
| **介面 (Interface)** | **功能外掛化**：今天訊息要「驗證」，明天訊息要「加密」，介面讓功能像外掛一樣好拆裝。 | 你的 `Message` 類別會變得很臃腫，因為你要把所有不相關的功能（驗證、加密、備份）全塞進去。 |
| **Override (覆寫)** | **個性化處理**：同樣是 `send()`，Email 走 SMTP 協定，簡訊走電信通訊。 | 你必須在一個 `send()` 方法裡寫 `if (isEmail) {...} else if (isSms) {...}`。 |
| **Overload (多載)** | **使用者的體貼**：讓呼叫者可以選擇傳 1 個參數或 2 個參數，不需要記一堆奇怪的方法名。 | 你得取名為 `displayWithNoPrefix()` 和 `displayWithPrefix()`，超級難記。 |
| **多型 (Polymorphism)** | **系統的擴充性**：**這是精華！** 當你要增加「Line 訊息」時，主程式的 `for` 迴圈一行都不用改。 | 每增加一個訊息種類，你的主程式（`main`）就要大改一次，增加新的 `if` 判斷，最後沒人敢動這隻程式。 |
*/
