package io.javabrains.unit2;

public class ThisReferenceExample {

    public void doProcess( int i , Process p){
        p.process(i);

    }
    public static void main(String[] args) {
        ThisReferenceExample thisReferenceExample = new ThisReferenceExample();
        //Anonymous inner class new Process() or object it can be replaced by lambda expression
        thisReferenceExample.doProcess(10, new Process() {
            public void process(int i) {

                System.out.println(i);
                System.out.println(this);

            }
            public String toString(){
                return "This is anonymous inner class";
            }

        });

    }
}
