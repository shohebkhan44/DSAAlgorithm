
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
  else if(target<=arr[mid])
  {
          high=mid-1;
;
  }
  else{
    low=mid+1;
  }
  
}
 return -1;
}


//Lower bound

public static int LowerBound(int[] arr,int x)
{
       int low=0;int high=arr.length-1;
       int ans=arr.length;

       while (low<=high) {
        
           int mid=(low+high)/2;


           if(arr[mid]>=x){
            ans=mid;
            high=mid -1;
           }
           else{
            low=mid+1;
           }
       }
       return ans;
}
//UpperBound
public static int UpperBound(int[] arr,int x)
{
       int low=0;int high=arr.length-1;
       int ans=arr.length;

       while (low<=high) {
        
           int mid=(low+high)/2;


           if(arr[mid]>x){
            ans=mid;
            high=mid -1;
           }
           else{
            low=mid+1;
           }
       }
       return ans;
}
//first and last Occurence

public static int[] FirtAndLastOccurence(int[] arr,int x){
int lb=LowerBound(arr,x);
int ub=UpperBound(arr,x);
if(arr[lb]!=x && arr[ub-1]!=x){
  return new int[]{-1,-1};
}
if(arr[lb]==x && arr[ub-1]==x)
{
return new int[]{lb,ub-1};
}
else{
  return new int[]{-1,-1};
}
}
//find Floor and ciel
public static void Floor(int[] arr){

  int low=0;int high=arr.length-1;
  int ans=-1;
int result[];
  while(low<=high){

    int mid=(low+high)/2;

    if(arr[mid]>=mid){
      ans=arr[mid];
      
    }
    else{

    }
  }
}

public static void main(String[] args) {
    int array[]={1,3,5,6,7,8,9};
      int target=79;

    int ans=BinarySearch(target,array);
   System.out.println("ur element");
    System.out.println("the elemnt found at index"+ ans);
    //System.out.println(FirtAndLastOccurence(array,8));
    System.out.println(LowerBound(array, 8));
    System.out.println(UpperBound(array, 8));
    for (int i : FirtAndLastOccurence(array,8)) {
      System.out.println(i);
    }




}

}
