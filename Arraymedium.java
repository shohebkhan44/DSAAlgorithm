import java.util.HashMap;

public class Arraymedium {

    static  int majorityElement(int arr[]){
//brute force
//time complexity=O(n2)
// int counter=0,size=(arr.length/2),element=0,max=0;
// for(int i=0;i<arr.length;i++){
//     counter=0;
//     for(int j=i;j<arr.length;j++){
//    if(arr[j]==arr[i]){
//     counter++;
//    }
//     }

//     if(counter>size){
//         max=counter;
//         return element=arr[i];
//     }
// }
// return -1;
//using Hashmap
//better solution
//time complexity =O(nlogn) + O(n)
// HashMap<Integer,Integer> map=new HashMap<>();
// int counter=0;
//      for(int i=0;i<arr.length;i++){
//         if(map.containsKey(arr[i])){
//             map.put(arr[i],map.get(arr[i])+1);
//         }
//         else{
//         map.put(arr[i], 1);
//      }
//     }
// int max=0,element=0;
//     for(int i=0;i<arr.length;i++){
//         if(map.get(arr[i])>max){
//             max=map.get(arr[i]);
//             element=arr[i];

//         }
//optimal solution
//Morse Voting Algorithm
//Time complexity O(1)
int counter=0;
int element=arr[0];
for(int i=0;i<arr.length;i++)
{
if(counter==0){
    counter=1;
    element=arr[i];
}
else if(arr[i]!=element){
    counter--;
}
else{
 counter++;
}
}
int ct=0;
for(int i=0;i<arr.length;i++){
    if(arr[i]==element){
        ct++;
    }
}
if(ct>arr.length/2){
return element;
}
else{
    return -1;
}
}
//kadanes algorithm
static int MaxSubarraySum(int[] arr){
int sum=0,max=-9999,istart;
    for(int i=0;i<arr.length;i++){
      sum+=arr[i];
      if(sum==0){
        istart=i;
      }
       if(sum<0){
            sum=0;
        }
        else {
            if(sum>max){
            max=sum;
            }
        }    
    } 
    return max;
}
static int BuysellStock(int[] arr){
  //TC=O(n2)
    // int profit=0,maxprofit=0;
    // for(int i=0;i<arr.length;i++){
    //     for(int j=arr.length-1-i;j>0;j--){
    //         profit=arr[j]-arr[i];
    //         if(profit>maxprofit){
    //              maxprofit=profit;
    //         }
    //     }
    // }
    // return maxprofit;
    int min=arr[0],max=-1,profit=0;
    //TC=O(n).
   for(int i=1;i<arr.length;i++){

       profit=arr[i]-min;

if(profit>max){
    max=profit;
}
min=Math.min(min, arr[i]);

}

    return max;
}
//Rearrange array

static void Rearrange(int arr[]){
//not wrking hv to trace back
    for(int i=0;i<arr.length;i++){
        if(i%2==0){
System.out.print(arr[i]);
        }
        else if(arr[i]<0){
             System.out.print(arr[i]);
        }
        else{
            int temp=arr[i];
            arr[i+1]=arr[i];
            arr[i+1]=temp;
           
        }
    }

}

//longest Common Subsequence

static int LongestSubseq(int arr[]){

    int cnt=0,x=0,max=0;;
    for(int i=0;i<arr.length;i++){

        x=arr[i];
        cnt=1;
        while(linearSearch(x+1,arr)==true){
            cnt++;
            x=x+1;
        }
       max=Math.max(max, cnt);
        
    }
    return  max;
}
static boolean linearSearch(int ele, int arr[]){

    for(int i=0;i<arr.length;i++){
        if(arr[i]==ele){
            return true;
        }
    }
    return false;
}

// Function to compute nCr
static int ncR(int n, int r) {
    int ans = 1;

    // Since nCr = nC(n-r)
    r = Math.min(r, n - r);

    for (int i = 1; i <= r; i++) {
        ans = ans * (n - i + 1);
        ans = ans / i;
    }

    return ans;
}

// Function to print the nth row of Pascal's Triangle (0-based)
static void printRow(int n) {
    for (int c = 0; c <=n; c++) {
        System.out.print(ncR(n, c) + " ");
    }
    System.out.println();
}
//print pascal
static void Printpascal(int rowSize){

    for(int i=0;i<rowSize;i++){
        printRow(i);
    }
}
public static void main(String[] args) {
     int[] ar5={7,1,5,3,6,4};
     int[] ar2={102,4,100,1,101,3,2,1,1,8,9};
     int[] ar3={1,-4,5,-6,5,-7,-7};
     //System.out.println("maxprofit" +" "+BuysellStock(ar5));
     //System.out.println("majority element"+majorityElement(ar5));
     //System.out.println(LongestSubseq(ar2));
     //Rearrange(ar2);
     printRow(6);
     Printpascal(6);
     System.out.println(MaxSubarraySum(ar3));
     //majorityElement(ar5);
    
}

}