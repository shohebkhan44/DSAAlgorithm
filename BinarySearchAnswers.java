import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class BinarySearchAnswers {

    // find the square root of given interger/number

    public static int SqrtBS(int num) {
        int ans = 1;
        int low = 1;
        int high = num;
        while (low <= high) {

            int mid = (low + high) / 2;
            if (mid * mid <= num) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    // helper function fr below program
    public static int nthroot(int mid, int n, int m) {
        // return 1 if ==m
        // return 0 if <m
        // return 2 if >m
        int ans = 1;
        for (int i = 1; i <= n; i++) {
            ans *= mid;
            if (ans > m)
                return 2;
        }
        if (ans < m)
            return 1;
        else
            return 0;

    }
    // Nth root of any given number

    public static int NthRootBS(int n, int m) {

        int low = 1;
        int high = m;
        int ans = 1;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (nthroot(mid, n, m) == 0) {
                return mid;
            } else if (nthroot(mid, n, m) == 1) {
                low = mid + 1;

            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    // helper function for below code

    public static int CountHours(int mid, int arr[]) {

        int totalhrs = 0;
        for (int i = 0; i < arr.length; i++) {
            totalhrs += Math.ceil((double) arr[i] / mid);

        }
        return totalhrs;
    }

    // Koko eating banana

    public static int KokoEatingBananaBS(int piles[], int hours) {

        int low = 1;
        int high = Arrays.stream(piles).max().getAsInt();

        int ans = 999999;
        while (low <= high) {
            int mid = (low + high) / 2;
            // if(CountHours(mid,piles)==hours){
            // return mid;
            // }
            if (CountHours(mid, piles) <= hours) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;

    }

    // Minimum day to make M bouquets with K adjacent flowers

    // helper function for below code

    public static boolean Ispossible(int[] Days, int day, int m, int k) {

        int counter = 0;
        int NoOfBouquets = 0;

        for (int i = 0; i < Days.length - 1; i++) {

            if (Days[i] <= day) {
                counter++;
            } else {
                NoOfBouquets += counter / k;
                counter = 0;
            }
        }
        NoOfBouquets += counter / k;
        if (NoOfBouquets >= m)
            return true;
        else
            return false;
    }

    public static int MinDaysforBouquets(int[] Days, int m, int k) {
        int low = Arrays.stream(Days).min().getAsInt();
        int high = Arrays.stream(Days).max().getAsInt();
        int ans = 0;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (Ispossible(Days, mid, m, k)) {
                ans = mid;
                high = mid - 1;

            } else {
                low = mid + 1;
            }
        }
        return ans;
    }


    //helper function for below code

    public static boolean Calc(int mid,int[] arr,int threshold){

  int sum=0;
  for(int i=0;i<arr.length;i++){
    sum+=Math.ceil(arr[i]/mid);
  }
  return sum<=threshold;
  
    }
    public static int SmallestDivisor(int[] numbers, int threshold) {
        int low = 1;
        int high = Arrays.stream(numbers).max().getAsInt();
        int ans =999999999;//chnge to larget possibe value
        while (low <= high) {

            int mid = (low + high) / 2;
            if (Calc(mid, numbers, threshold)) {
                ans =Math.min(ans, mid);
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
return ans;
    }

    //helper function for below code

    public static int Calc(int weight[],int mid){

        int load=0;int days=1;

        for(int i=0;i<weight.length;i++)
        {
              if(load+weight[i]>mid){
                   days+=1;
                   load=weight[i];
              }
              else{
                load+=weight[i];
              }
        }
        return days;
    }

    //least Capacity to ship packages within D days
    public static int LeastCapacity(int[] weight,int Days)
    {

        int low=Arrays.stream(weight).max().getAsInt();
        int sum=0;
        for(int i=0;i<weight.length;i++) {
            sum+=weight[i];
        }
        int high=sum;int ans=99999999;

        while (low<=high) {
            int mid=(low+high)/2;
             if(Calc(weight,mid)<=Days)
             {
               ans=Math.min(ans,mid);
               high=mid -1;
             }
             else{
                low=mid+1;
             }
        }
        return ans;

    }
    public static void main(String[] args) {
        int num = 27;
        int n = 4;
        int m = 256;
        int[] piles = { 3, 6, 7, 11 };
        int[] Days = { 7, 7, 7, 7, 13, 11, 12, 7 };
        int [] smallDiv={1,2,5,9};
        int [] Loads={1,2,3,4,5,6,7,8,9,10};
        // System.out.println("square root of"+ num +"is"+SqrtBS(num));
        // System.out.println(n + " root of" + " " + m + " " + "is" + " " + NthRootBS(n, m));
        // System.out.println("The minimum rate at which koko can eat is" + " " + KokoEatingBananaBS(piles, 8));
        // System.out.println(MinDaysforBouquets(Days, 2, 3));
       // System.out.println("the smallest divisor is"+ SmallestDivisor(smallDiv, 6));
       System.out.println("least capacity"+ LeastCapacity(Loads, 5));
    }
}
