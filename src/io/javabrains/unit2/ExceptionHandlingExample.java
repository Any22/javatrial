package io.javabrains.unit2;
import java.util.function.BiConsumer;
// we externalize the try catch block , by wrap a lambda into another lambda
public class ExceptionHandlingExample {
    public static void main(String[] args) {
        int [] someNumbers = {1,2,3,4};
        int key = 0 ;
        // calling method named process takes some numbers and a key apply according to lambda expressions
        process(someNumbers , key ,wrapperLambda( (v, k)-> System.out.println( v /k )));

    }

    private static void process(int [] someNumbers , int key, BiConsumer <Integer,Integer> consumer) {
        for (int i : someNumbers){
            consumer.accept(i,key);
        }

    }
    private static BiConsumer<Integer,Integer> wrapperLambda (BiConsumer<Integer,Integer> consumer){
        return (v,k) -> {
            try{
               consumer.accept(v,k);
            }catch(ArithmeticException a){
                System.out.println("Exception caught in wrapper Lambda");
            }
        };
    }
}
