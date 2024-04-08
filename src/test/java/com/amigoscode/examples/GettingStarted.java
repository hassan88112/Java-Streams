package com.amigoscode.examples;

import com.amigoscode.beans.Person;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class GettingStarted {

    @Test
    public void imperativeApproach() throws IOException {
        // 1. Find people aged less or equal 18
        // 2. Then change implementation to find first 10 people
        List<Person> people = MockData.getPeople();
        List<Person> youngPerson = new ArrayList<>();
        int limit = 5;
        int count=0;
        for (Person p:people){
            if (p.getAge() <= 18){
                youngPerson.add(p);
                count++;
                if (count == limit){
                    break;
                }
            }
        }
        youngPerson.forEach(System.out::println);
    }

    @Test
    public void declarativeApproachUsingStreams() throws Exception {
        List<Person> people = MockData.getPeople();
        List<Person> youngPeople=
                people.stream()
                        .filter(p -> p.getAge() <= 18)
                        .limit(2)
                        .collect(Collectors.toList());
        youngPeople.forEach(System.out::println);
    }
}
