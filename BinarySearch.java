
public class BinarySearch {
    

public static int BinarySearch(int target,int[] arr){
int size=arr.length;
int low=0;
int high=size-1;
  while (low<=high) {

    int mid=low+high/2;
    if(arr[mid]==target)
    {
        return mid;
    }
    else if(target>arr[mid]){
        low=mid+1;
    }
    else{
        high=mid-1;
    }
  }
  return -1;
}


public static void main(String[] args) {
    int array[]={1,3,5,6,7,9,12,79};
    int target=9;
    
   
    System.out.println("the elemnt found is  "+BinarySearch(target,array));
    System.out.println("exception error foun bro");
    
}

}
