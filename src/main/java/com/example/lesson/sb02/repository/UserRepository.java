package com.example.lesson.sb02.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.lesson.sb02.entity.User;

/**
 * 1. 繼承 JpaRepository<Entity, ID_Type> 即可獲得 CRUD 與分頁功能。
 * 2. 繼承結構: JpaRepository -> PagingAndSortingRepository -> CrudRepository 。
 */
@Repository // 雖然 Spring Data JPA 會自動識別繼承介面，但標上此註解是好習慣
public interface UserRepository extends JpaRepository<User, Long> {
    
    // 這裡目前不需要寫任何實作，findAll, save 等方法直接繼承而來
	//透過方法名稱生成 SQL
    // select * from users where name = ?
    List<User> findByName(String name); // [cite: 240]

    // 複合條件查詢 (And)
    // select * from users where name = ? and email = ?
    Optional<User> findByNameAndEmail(String name, String email); // [cite: 250]

    //區間查詢 (Between) 常用於日期或數值
    // select * from users where id between ? and ?
    List<User> findByIdBetween(Long startId, Long endId); // [cite: 253]
    
    //限制筆數 (Top/First)
    // select * from users ... limit 1
    Optional<User> findFirstByOrderByIdDesc(); // 取得最新加入的一筆
    
    List<User> findDistinctByNameAndEmail(String name, String email); // [cite: 255] 去除重複資料

    /**
     * 1. @Query: 撰寫 JPQL (針對 Entity 而非 Table)。
     * 2. @Modifying: 告訴 JPA 這是 INSERT/UPDATE/DELETE，而非 SELECT。
     * 3. clearAutomatically = true: 關鍵！執行後清除 Persistence Context (一級快取)，
     * 確保下次查詢時會從資料庫重新撈取最新資料，避免髒讀。
     */
    @Modifying(clearAutomatically = true) // 👈 伏筆：稍後請拿掉這個參數測試看看
    @Query("UPDATE User u SET u.email = :email WHERE u.name = :name")
    int updateEmailByName(@Param("name") String name, @Param("email") String email);
    
 // 定義分頁方法，參數必須有 Pageable，回傳建議用 Page<T>
    Page<User> findAll(Pageable pageable);

}