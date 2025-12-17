package Recursion;

public class Recursion {
    
    public static void main(String[] args) {
        // Print(5);
        System.out.println( Fibonacci(9));
    }

    private static void Print(int n){
        if(n<1) return;
        Print(n-1);
        System.out.println(n);
    }
    private static int Fibonacci(int n){

         if (n == 0) return 0;   // base case
        if (n == 1) return 1;   // base case
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }
}
