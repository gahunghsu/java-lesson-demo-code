package com.example.lesson.sb02.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson.sb02.entity.PersonInfo;
import com.example.lesson.sb02.service.PersonService;
import com.example.lesson.sb02.vo.PersonBankRecord;

@RestController
public class PersonInfoController {

	@Autowired
	private PersonService personService;

	@PostMapping("/insert")
	public String insertData() {
		personService.insertRawData();
		return "資料已插入 (請查看後端日誌確認)";
	}

	@GetMapping("/query-all")
	public List<PersonInfo> queryAllData() {
		return personService.findAll();
	}

	@GetMapping("/query-by-age")
	public String queryByAge() {
		personService.findByAgeGreaterThan();
		return "查詢已執行 (請查看後端日誌確認)";
	}

	@GetMapping("/query-by-name-age")
	public String queryByNameAndAge() {
		personService.findByNameAndAge();
		return "依姓名和年齡查詢已執行 (請查看後端日誌確認)";
	}

	@PutMapping("/update-name")
	public String updateName() {
		personService.updateNameById();
		return "名稱更新已執行 (請查看後端日誌確認)";
	}

	@PostMapping("/insert-if-not-exists")
	public int insertIfNotExists(@RequestBody PersonInfo person) {
		// 這裡可以直接從 person 物件拿值
		return personService.insertIfNotExists(person.getName(), person.getAge());
	}

	@PostMapping("/test-transaction")
	public void demoCacheTrap(@RequestBody PersonInfo person) {
		personService.demoCacheTrap(person.getName());
	}
	
	@PostMapping("/test-transaction-clean")
	public void demoCacheClean(@RequestBody PersonInfo person) {
		personService.demoCacheClean(person.getName());
	}
	
	@DeleteMapping("/delete-minors/{age}")
	public void deleteMinors(@PathVariable("age") Integer age) {
		personService.deleteMinors(age);
	}
	
	@GetMapping("/person-map-by-age/{age}")
	public List<Map<String, Object>> findPersonMapByAge(@PathVariable("age") Integer age) {
		return personService.findPersonMapByAge(age);
	}
	
	@GetMapping("/person-object-by-age/{age}")
	public List<PersonInfo> findPersonObjectByAge(@PathVariable("age") Integer age) {
		return personService.findPersonObjectByAge(age);
	}
	
	@GetMapping("/searchAdvanced")
	public List<PersonInfo> searchAdvanced() {
		return personService.searchAdvanced("七", 18, 45);
	}
	
	@GetMapping("/rich-people")
	public List<PersonBankRecord> findRichPeople() {
		return personService.findRichPeople();
	}
	
	@GetMapping("/rich-people-paged")
	public Page<PersonBankRecord> findRichPeoplePaged() {
		return personService.demoPagination();
	}
	
	

}
