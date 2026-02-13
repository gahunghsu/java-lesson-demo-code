package com.example.lesson.sb02.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.lesson.sb02.entity.PersonInfo;
import com.example.lesson.sb02.repository.PersonInfoRepository;
import com.example.lesson.sb02.vo.PersonBankRecord;

@Service
public class PersonService {

    private final PersonInfoRepository repository;

    public PersonService(PersonInfoRepository repository) {
        this.repository = repository;
    }
    
    public List<PersonInfo> findAll() {
		return repository.findAll();
	}
    
    @Transactional
    public void insertRawData() {
    	 // --- 測試 INSERT (Native SQL) ---
        System.out.println(" 執行原生 INSERT...");
    	repository.insertRawData("測試人員A", 25, LocalDate.now());
        repository.insertRawData("測試人員B", 40, LocalDate.now());
	}
    
    public void findByAgeGreaterThan() {
    	 // --- 測試模式一：JPQL ---
        System.out.println(" 測試 JPQL (Age >= 30)...");
        List<PersonInfo> jpqlResults = repository.findByAgeGreaterThanJpql(30);
        System.out.println("JPQL 結果筆數: " + jpqlResults.size());

        // --- 測試模式二：Native SQL ---
        System.out.println(" 測試 Native SQL (Age >= 30)...");
        List<PersonInfo> nativeResults = repository.findByAgeGreaterThanNative(30);
        System.out.println("Native SQL 結果筆數: " + nativeResults.size());
	}
    
    public void findByNameAndAge() {
    	// --- 測試方法一：定位符號 (?1, ?2) ---
        System.out.println("測試定位符號查詢 (?1, ?2)...");
        repository.findByNameAndAgePositional("測試人員B", 40)
                .forEach(p -> System.out.println("找到: " + p.getName()));
        
        repository.findByNameAndAgePositionalChange("測試人員B", 40)
        .forEach(p -> System.out.println("找到: " + p.getName()));

        // --- 測試方法二：命名參數 (:inputName) ---
        System.out.println("測試命名參數查詢 (:inputName)...");
        repository.findByNameAndNameAged("測試人員B", 40)
                .forEach(p -> System.out.println("找到: " + p.getName()));
        
        repository.findByNameAndAgeNamed("測試人員B", 40)
        .forEach(p -> System.out.println("找到: " + p.getName()));
    }

    @Transactional
    public void updateNameById() {
        // 為了後續測試，我們先抓出資料庫中的一筆資料來取得 ID
        PersonInfo sample = repository.findAll().stream().findFirst().orElse(null);
        
        if (sample != null) {
            Long targetId = sample.getId();

            // --- 測試 UPDATE (@Modifying) ---
            System.out.println("\n[2] 執行 UPDATE (ID: " + targetId + ")...");
            int updatedRows = repository.updateNameById(targetId, "Test User " + targetId);
            System.out.println("更新行數: " + updatedRows);
        }
    }
    
    /**
     * 演示緩存陷阱 (Live Demo)
     */
    @Transactional // [必要]: DML 操作需要事務
    public void demoCacheTrap(String name) {
        // 1. 先查詢 (JPA 把資料快取到 Level 1 Cache)
    	PersonInfo person = repository.findByNameNative(name).get(0);
        System.out.println("查詢 1 (Before): " + person); // 假設是 "Taipei"

        // 2. 執行 Update (直接打 DB，但 JPA Cache 不知道)
        // 呼叫 updateCityLegacy (沒有 clearAutomatically)
        repository.updateAgeLegacy(name, 88);

        // 3. 同一個事務內再次查詢
        // [觀察點]: 這裡會直接從 Cache 拿舊資料，而不會去 DB 查
        PersonInfo personAgain = repository.findByNameNative(name).get(0);
        System.out.println("查詢 2 (After Legacy Update): " + personAgain); // 😱 仍然是 "Taipei"!
    }
    
    /**
     * 演示緩存陷阱 (Live Demo)
     */
    @Transactional // [必要]: DML 操作需要事務
    public void demoCacheClean(String name) {
        // 1. 先查詢 (JPA 把資料快取到 Level 1 Cache)
    	PersonInfo person = repository.findByNameNative(name).get(0);
        System.out.println("查詢 1 (Before): " + person); // 假設是 "Taipei"

        // 2. 執行 Update (直接打 DB，但 JPA Cache 不知道)
        // 呼叫 updateCityLegacy (沒有 clearAutomatically)
        repository.updateAgeCorrectly(name, 88);

        // 3. 同一個事務內再次查詢
        // [觀察點]: 這裡會直接從 Cache 拿舊資料，而不會去 DB 查
        PersonInfo personAgain = repository.findByNameNative(name).get(0);
        System.out.println("查詢 2 (After Legacy Update): " + personAgain); // 😱 仍然是 "Taipei"!
    }
    
    @Transactional
    public int insertIfNotExists(String name, int age) {
		// 測試 idempotent insert
		return repository.insertIfNotExists(name, age);
	}
    
    @Transactional
    public void deleteMinors(int age) {
    	repository.deleteMinors(age);
    }
    
    public List<Map<String, Object>> findPersonMapByAge(int age) {
		return repository.findPersonMapByAge(age);
	}
    
    public List<PersonInfo> findPersonObjectByAge(int age) {
    			return repository.findPersonObjectByAge(age);
    }
    
    public List<PersonInfo> searchAdvanced(String name, Integer minAge, Integer maxAge) {
		return repository.searchAdvanced(name, minAge, maxAge);
	}
    
    public List<PersonBankRecord> findRichPeople(){
    			return repository.findRichPeople(10000.0);
    }
    
    public Page<PersonBankRecord> demoPagination() {
        // 查詢第 0 頁，每頁 3 筆資料 [cite: 376]
        Pageable pageRequest = PageRequest.of(0, 3);
        
        Page<PersonBankRecord> pageResult = repository.findPeopleByAgeWithPaging(18, pageRequest);
        
        System.out.println("總頁數: " + pageResult.getTotalPages());
        System.out.println("本頁資料: " + pageResult.getContent());
        
        return pageResult;
    }

}