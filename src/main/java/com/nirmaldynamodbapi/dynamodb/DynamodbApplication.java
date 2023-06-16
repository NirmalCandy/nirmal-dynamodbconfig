package com.nirmaldynamodbapi.dynamodb;

import com.nirmaldynamodbapi.entity.Person;
import com.nirmaldynamodbapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@SpringBootApplication
public class DynamodbApplication {
	public static void main(String[] args) {
		SpringApplication.run(DynamodbApplication.class, args);

	}

}
