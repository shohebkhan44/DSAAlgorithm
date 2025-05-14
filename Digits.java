import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Digits {
    
    public static void main(String[] args) {
        System.out.println("Count of  digits are");
        System.out.println("hi");
        System.out.println(digit(23456));
        System.out.println(Reversedigit(23456));
        System.err.println(palindrome(125210));
        System.out.println(Armstrong(1634));
        System.out.println("all divisors");
       // AllDivisors(36);
       System.out.println(primeNumber(17876751));
       System.out.println(GCD(11, 17));
    }
    //count number of digits
    public static int digit(int num){
        int count=0;
        while(num>0){
            count+=1;
            num=num/10;
          
        }

        return count;
    }
    //reverse a number
    public static int Reversedigit(int num){
        int rev=0;
        while(num>0){
            int lastdigit=num%10;
            num=num/10;
            rev=(rev*10)+lastdigit;
        }
        return rev;
    }
    //palindrome
    public static boolean palindrome(int pal){
int reverse=Reversedigit(pal);
        if(reverse==pal){
            return true;
        }
        else{
            return false;
        }
    }
    //Armstrong number
    public static boolean Armstrong(int num){
         // Find the number of digits in the number
    int Digits = String.valueOf(num).length();
        int sum=0;
        int lastdigit;
        int dup=num;
        while(num>0){
            lastdigit=num%10;
            sum+=Math.pow(lastdigit, Digits);
            num/=10;
        }
        if(sum==dup){
            System.out.println(sum);
            return true;
        }
        else{
            System.out.println(sum);
         return   false;
        }
}
// print all divisors
public static void AllDivisors(int num){
int dup=num;
   List<Integer> smallDivisors = new ArrayList<>();
    List<Integer> largeDivisors = new ArrayList<>();
    for(int i=1;i<=Math.sqrt(num);i++){
         
        if(num % i == 0) {
            //System.out.println(i);
            smallDivisors.add(i); 
        }
        if((num/i) !=i){
            //System.out.println(num/i);
            smallDivisors.add(num/i); 
        }
        


    }
    for (int divisor : smallDivisors) {
        System.out.println(divisor);
    }
}

//prime number
public static boolean primeNumber(int num){
    //a number which has two factors 1 and the number itself.
    int count=0;
    for(int i=0;i<=num;i++){

    
    if(num %1== i ){
        count+=1;
        
    }
    
   
}
   if(count==2){
    return true;
}
   else {
    return false;}
}

//GCD of two numbers
public static int GCD(int m,int n ){
int max=1;
for(int i=1;i<Math.min(m,n);i++){
    if(m % i ==0 && n % i==0)
       {
             if(i>max){
                max=i;
             }
       }
    
}
    return max;
}
}
