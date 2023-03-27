package io.javabrains.unit1;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class Unit1ExerciseSolutionJava7 {
    public static void main (String[] args) {

        List<Person> people = Arrays.asList(

                new Person("Charles", "Dickens", 60),
                new Person("Lewis", "Carroll", 42),
                new Person("Thomas", "Carlyle", 51),
                new Person("Charlotte", "Bronte", 45),
                new Person("Mathew", "Arnold", 60)
        );

        //Step 1. Sort the list using the last names
        // Collections.sort(list) method sort the list in natural order,so we have taken Collections.sort() with comparator
        // for customize sorting, Comparator is an interface here

        Collections.sort(people, new Comparator<Person>() {

            @Override
            public int compare(Person o1, Person o2) {

                return o1.getLastName().compareTo(o2.getLastName());

            }

        });


        //Step2 : create a method that prints all elements in a list
        System.out.println("print all names sorted by last names ");
        printAll(people);

        //Step3 : Create a method that prints all people that have last name beginning with C
        System.out.println("prints all names  that have last names begin with C");
        printAllLastNamesBeginWithC(people);

        // Step4  : using interface condition to pass the behavior
        System.out.println("prints all names that have first name begins with C");
        printConditionally(people, new Condition() {
            @Override
            public boolean test(Person p) {

                return p.getFirstName().startsWith("C");
            }
        });

        System.out.println("prints all names that have first name begins with T");
        printConditionally(people, new Condition() {
            @Override
            public boolean test(Person p) {

                return p.getFirstName().startsWith("T");
            }
        });


    }
    //2. so we are going to design an interface to print anything using any condition , we are design a Condition interface for this purpose
    private static void printConditionally (List<Person> people,Condition condition){
        for(Person p: people)
            if (condition.test(p)) {
                System.out.println(p);
            }


    }
    private static void printAll(List<Person> people){

        for (Person p : people){
            System.out.println(p);
        }

    }

    //1. the behaviors can also be passed as parameters as if we want to get the list of all whose name starts with D , we have design another method which is not good at all
    private static void printAllLastNamesBeginWithC(List<Person> people) {

           for(Person p: people)
            if (p.getLastName().startsWith("C")) {
                System.out.println(p);
            }
    }



}
// we are passing the behaviors by creating an interface
interface Condition {
    boolean test (Person p);
}