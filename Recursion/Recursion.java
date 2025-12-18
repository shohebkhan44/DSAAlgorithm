package Recursion;

public class Recursion {
    
    public static void main(String[] args) {
        // Print(5);
       // System.out.println( Fibonacci(3));
       int[] arr={2,3,4,5};
       int high=arr.length-1;
       System.out.println("Tartget value"+BinarySearch(arr,0,high,4));

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
    private static int BinarySearch(int arr[],int low,int high,int target){
 if(low>high) return -1;
        int mid=(low+high)/2;
        if(arr[mid]==target) return mid;
        else if(arr[mid]>target){ 
               high=mid-1;
           return BinarySearch(arr, low, high, target);
        }
        else{
            low=mid+1;
          return  BinarySearch(arr, low, high, target); 
        }
    
 
    }
}
