package io.javabrains.unit3;

import io.javabrains.unit1.Person;

import java.util.Arrays;
import java.util.List;

public class StreamExample1 {
    public static void main(String[] args) {
        // By using streams we are actually creating an assembly line that works on each item
        List<Person> people = Arrays.asList(

                new Person ("Charles", "Dickens", 60),
                new Person ("Lewis", "Carroll", 42),
                new Person ("Thomas", "Carlyle", 51),
                new Person ("Charlotte", "Bronte", 45),
                new Person ("Mathew", "Arnold", 60)
        );
        //Putting all objects in conveyor belt of Assembly line and streaming them.now a bunch of method can be called on streams
        //putting all people elements in conveyor belt and for each element on conveyor belt it is getting first name
        //the parameter of filter is a predicate true if predicate is true the element remains in conveyor belt and gets printed
        //otherwise if predicates is false the elements get removed from conveyor belt and hence not printed
        // terminal operation is forEach and count
        people.stream()
                .filter(p-> p.getLastName().startsWith("C"))
                .forEach(p-> System.out.println(p.getFirstName()));

        long count = people.stream()
                .filter(p-> p.getLastName().startsWith("C"))
                .count();
        System.out.println(count);
    }

}
