package com.task07.task07_06;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Runner {

    public void run() {

        List<Integer> list =
                Stream.iterate(10, n -> n + 10)
                        .limit(10)
                        .map(n -> n / 2)
                        .collect(Collectors.toList());

        System.out.println(list);

        List<Person> persons = getPersonsList();

        persons.stream().forEach(System.out::println);

        List<Person> collect =
                persons.stream()
                        .filter(p -> p.getSex().equals(Person.Sex.MALE) && p.getAge() > 17 && p.getAge() < 55)
                        .collect(Collectors.toList());
        System.out.println(collect);

        double average =
                persons.stream()
                        .filter(p -> p.getSex().equals(Person.Sex.FEMALE))
                        .mapToInt(Person::getAge)
                        .average()
                        .getAsDouble();
        System.out.println(average);
    }

    public List<Person> getPersonsList() {
        return Arrays.asList(
                new Person("Ivan", 22, Person.Sex.MALE),
                new Person("Ava", 35, Person.Sex.FEMALE),
                new Person("John", 19, Person.Sex.MALE),
                new Person("Kate", 25, Person.Sex.FEMALE),
                new Person("Sam", 35, Person.Sex.MALE)
        );
    }
}
