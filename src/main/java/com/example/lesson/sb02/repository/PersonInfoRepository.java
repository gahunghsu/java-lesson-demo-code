package com.example.lesson.sb02.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.lesson.sb02.entity.PersonInfo;

@Repository
public interface PersonInfoRepository extends JpaRepository<PersonInfo, Long> {

	// --- 模式一：JPQL (預設模式) ---
	// nativeQuery = false (預設值，可省略)
	@Query("SELECT p FROM PersonInfo p WHERE p.age>= ?1")
	List<PersonInfo> findByAgeGreaterThanJpql(Integer age);

	// --- 模式二：Native SQL (原生模式) ---
	// 必須開啟 nativeQuery = true
	@Query(value = "SELECT * FROM person_info WHERE age >= ?1", nativeQuery = true)
	List<PersonInfo> findByAgeGreaterThanNative(Integer age);

	// --- 寫入規範：UPDATE / DELETE —
	// [規範 1]: 必須加上 @Modifying 通知 JPA 這不是查詢
	// [規範 2]: 返回值可以是 void 或 int (受影響行數)
	@Modifying
	@Query("UPDATE PersonInfo p SET p.name = :newName WHERE p.id = :id")
	int updateNameById(@Param("id") Long id, @Param("newName") String newName);

	// --- 寫入規範：INSERT (特殊限制) ---
	// [規範 3]: JPQL 不支援 INSERT INTO Entity，必須用 Native Query [cite: 76]
	@Modifying
	@Query(value = "INSERT INTO person_info (user_name, age, entry_date) VALUES (:name, :age, :date)", nativeQuery = true)
	void insertRawData(@Param("name") String name, @Param("age") Integer age, @Param("date") LocalDate date);

	// --- 方法一：定位符號 (?1, ?2) ---
	// [教學風險]: 參數一多容易數錯順序
	@Query("SELECT p FROM PersonInfo p WHERE p.name = ?1 AND p.age = ?2")
	List<PersonInfo> findByNameAndAgePositional(String name, Integer age);
	
	@Query("SELECT p FROM PersonInfo p WHERE p.age = ?1 AND p.name = ?2")
	List<PersonInfo> findByNameAndAgePositionalChange(String name, Integer age);

	// --- 方法二：命名參數 (:name) (推薦 Best Practice)
	// 使用 @Param("key") 對應 SQL 中的 :key
	// 語意清晰，且不受參數順序影響
	@Query("SELECT p FROM PersonInfo p WHERE p.age = :inputAge AND p.name = :inputName")
	List<PersonInfo> findByNameAndNameAged(@Param("inputName") String name, @Param("inputAge") Integer age);
	
	@Query("SELECT p FROM PersonInfo p WHERE p.name = :inputName AND p.age = :inputAge")
	List<PersonInfo> findByNameAndAgeNamed(@Param("inputName") String name, @Param("inputAge") Integer age);

	// [進階技巧]: 防止 PK 衝突 (Idempotent Insert)
	// 利用 MySQL 語法：INSERT IGNORE 或 NOT EXISTS
	@Modifying
	@Query(value = "INSERT INTO person_info (user_name, age) " + "SELECT :name, :age WHERE NOT EXISTS "
			+ "(SELECT 1 FROM person_info WHERE user_name = :name)", nativeQuery = true)
	int insertIfNotExists(@Param("name") String name, @Param("age") Integer age);


	@Query(value = "SELECT * FROM person_info WHERE user_name = ?1", nativeQuery = true)
	List<PersonInfo> findByNameNative(String name);
	
	// [陷阱題]: 只加 @Modifying，不清除緩存
	@Modifying
	@Query("UPDATE PersonInfo p SET p.age = :newAge WHERE p.name = :name")
	int updateAgeLegacy(@Param("name") String name, @Param("newAge") int age);

	// [標準答案]: 加上 clearAutomatically = true
	// [AI 說明]: 執行後強制清空 Level 1 Cache (Persistence Context)
	// 確保下一次查詢會重新從資料庫撈取最新數據
	@Modifying(clearAutomatically = true)
	@Query("UPDATE PersonInfo p SET p.age = :newAge WHERE p.name = :name")
	int updateAgeCorrectly(@Param("name") String name, @Param("newAge") int age);

}
