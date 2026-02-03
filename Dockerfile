# 1. 選擇基礎映像檔 (Base Image)
# 請根據您的 JDK 版本調整，例如 eclipse-temurin:17-jdk-alpine 或 21-jdk-alpine
FROM eclipse-temurin:21-jdk-alpine

# 2. 設定工作目錄 (可選，但推薦)
WORKDIR /app

# 3. 建立一個暫存用的 volume (Spring Boot Tomcat 有時需要)
VOLUME /tmp

# 4. 將剛剛 build 好的 jar 檔複製進容器，並重新命名為 app.jar
# 注意：請確保 build/libs/ 下只有一個 jar，或是直接指定完整檔名
COPY build/libs/*.jar app.jar

# 5. 設定容器啟動時執行的指令
ENTRYPOINT ["java", "-jar", "/app/app.jar"]