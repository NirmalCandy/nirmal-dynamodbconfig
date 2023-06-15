package com.nirmaldynamodbapi.dynamodb;

import com.nirmaldynamodbapi.entity.Person;
import com.nirmaldynamodbapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class DynamodbApplication {
	@Autowired
	private PersonRepository repository;

	@PostMapping("/saveperson")
	public Person saveperson(Person person){
		return repository.addperson(person);
	}

	@GetMapping("/getperson/{personid}")
	public Person findperson(@PathVariable String personid ){
		return repository.findpersonbypersonid(personid);
	}

	@DeleteMapping("/deleteperson")
	public String deleteperson (@RequestBody Person person) {
		return repository.deleteperson(person);
	}
    @PutMapping("/editperson")
	public String updateperson( @RequestBody Person person){
		return repository.editperson(person);

	}

	public static void main(String[] args) {
		SpringApplication.run(DynamodbApplication.class, args);


	}

}
