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
public static void main(String[] args) {
     int[] ar5={7,1,5,3,6,4};
     int[] ar2={-2,-3,4,-1,-2,1,5,-3,3,4};
     System.out.println("maxprofit" +" "+BuysellStock(ar5));
     System.out.println("majority element"+majorityElement(ar5));
     System.out.println(MaxSubarraySum(ar2));
     //majorityElement(ar5);
    
}
}