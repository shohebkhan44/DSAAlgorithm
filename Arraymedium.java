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
for(int i=0;i<arr.length;i++){
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
return element;
}

public static void main(String[] args) {
     int[] ar5={1,2,3,4,1,1,1,1,6,7,3,1};
     System.out.println("majority element"+majorityElement(ar5));
     //majorityElement(ar5);
    
}
}