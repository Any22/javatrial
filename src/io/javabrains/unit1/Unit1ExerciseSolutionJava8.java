package io.javabrains.unit1;

import java.util.Arrays;
import java.util.Collections;
import java.util.function.Predicate;
import java.util.List;

//in java 8 we skip the implementations(video 14 10:44) and use lambda
public class Unit1ExerciseSolutionJava8 {
    public static void main (String[] args) {

        List<Person> people = Arrays.asList(

                new Person("Charles", "Dickens", 60),
                new Person("Lewis", "Carroll", 42),
                new Person("Thomas", "Carlyle", 51),
                new Person("Charlotte", "Bronte", 45),
                new Person("Mathew", "Arnold", 60)
        );

        //Step 1. Sort the list using the last names
        Collections.sort(people, (p1 , p2) -> p1.getLastName().compareTo(p2.getLastName()));

        //Step2 : create a method that prints all elements in a list
        System.out.println("print all names sorted by last names ");
        printConditionally(people,p-> true);

        //Step3 : Create a method that prints all people that have last name beginning with C
        System.out.println("prints all names  that have last names begin with C");
        printConditionally(people, p -> p.getLastName().startsWith("C"));

        // Step4  : now using Lambda expressions in this solution
        System.out.println("prints all names that have first name begins with C");
        printConditionally(people, p -> p.getFirstName().startsWith("C"));

        System.out.println("prints all names that have first name begins with T");
        printConditionally(people, p-> p.getFirstName().startsWith("T"));

    }
    //2. so we are going to design an interface to print anything using any condition , we are design a Condition interface for this purpose
/*    private static void printConditionally (List<Person> people,Condition condition){
//        for(Person p: people)
//            if (condition.test(p)) {
//                System.out.println(p);
//            }
//
//
  }*/

    // the Predicate is functional interface provided in java 8, so we are removing user interface Condition above
    private static void printConditionally (List<Person> people,Predicate<Person> predicate){
        for(Person p: people)
            if (predicate.test(p)) {
                System.out.println(p);
            }


    }






}


