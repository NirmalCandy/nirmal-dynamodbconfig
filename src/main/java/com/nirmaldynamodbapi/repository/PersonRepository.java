package com.nirmaldynamodbapi.repository;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.nirmaldynamodbapi.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class PersonRepository {

    @Autowired
    private DynamoDBMapper mapper;

    public Person addperson (Person person){

         mapper.save(person);
         return person;
    }
    public Person findpersonbypersonid(String personid){
        return mapper.load(Person.class,personid);
    }

    public String deleteperson(Person person){
        mapper.delete(person);
        return "person deleted";
    }
    public String editperson( Person person){
        mapper.save(person,buildExpression(person));
        return "record updated";
    }
    private DynamoDBSaveExpression buildExpression(Person person){

        DynamoDBSaveExpression dynamoDBSaveExpression= new DynamoDBSaveExpression();
        Map<String, ExpectedAttributeValue> expectedmap=new HashMap<>();
        expectedmap.put("personid",new ExpectedAttributeValue(new AttributeValue().withS(person.getPersonid())));
        dynamoDBSaveExpression.setExpected(expectedmap);
        return dynamoDBSaveExpression;
    }

}
