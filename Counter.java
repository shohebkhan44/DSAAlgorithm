class Countertest {
    static int count = 0;  // Class variable

    // Class method
    public static void increment() {
        count++;
    }

    public  void displayCount() {
        System.out.println("Count: " + count);
    }
}

public class Counter {
    public static void main(String[] args) {
        Countertest.increment();
        Countertest.increment();
        //Countertest.displayCount(); 
        Countertest c1=new Countertest();
        c1.displayCount();
        Countertest.increment();
        Countertest.increment();
         Countertest c2=new Countertest();
          c2.displayCount();
        // Output: Count: 2
    }
}
