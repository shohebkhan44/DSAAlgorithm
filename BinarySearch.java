
public class BinarySearch {
    

public static int BinarySearch(int target,int[] arr){
int low=0;
int size=arr.length;
int high=size-1;

while (low<=high)
 {
  int mid=(low+high)/2;
  if(arr[mid]==target)
  {
    return arr[mid];
  }
  else if(target<arr[mid])
  {
          
          low=mid+1;
  }
  else{
    high=mid-1;
  }
  
}
 return -1;
}


public static void main(String[] args) {
    int array[]={1,3,5,6,7,9,12,79,87,89,989};
      int target=79;

    int ans=BinarySearch(target,array);
   System.out.println("ur element");
    System.out.println("the elemnt found at index"+ ans);




}

}
