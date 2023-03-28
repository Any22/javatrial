package io.javabrains.unit3;

import io.javabrains.unit1.Person;

import java.util.Arrays;
import java.util.List;

public class CollectionIterationExample {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(

                new Person ("Charles", "Dickens", 60),
                new Person ("Lewis", "Carroll", 42),
                new Person ("Thomas", "Carlyle", 51),
                new Person ("Charlotte", "Bronte", 45),
                new Person ("Mathew", "Arnold", 60)
        );
        //here you are maintaining the indexing and increment counter to iterate,hence it is called external iterate
        System.out.println("Using simple for loop");
        for (int i = 0; i< people.size() ; i++){
            System.out.println(people.get(i));
        }
        //here you are not maintaining the indexing but other things are done to iterate ,hence it is also called external iterate
        System.out.println("Using for in loop");
        for (Person p : people){
            System.out.println(p);
        }
        //internal iterators
        // foreach is called over collection and a lambda expression  is used as a parameter of for each
        System.out.println("Using for each loop introduced in java 8 for each is taking consumer here");
      // people.forEach( p -> System.out.println(p));
        people.forEach( System.out::println);
    }
}
