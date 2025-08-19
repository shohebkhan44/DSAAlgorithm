
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
public static int Floor(int[] arr,int x){

  int low=0;int high=arr.length-1;
  int ans=-1;
  int result[];
  while(low<=high){

    int mid=(low+high)/2;

    if(arr[mid]<=x){
      ans=arr[mid];
     
       low=mid+1;
    }
    else{
      high=mid-1;

    }
  }
  return ans;
}


//Search in rotated sorted array

public static int SearchRotated(int[] arr,int target)
{
    int low=0;
    int high=arr.length-1;
    int index=-1;
int mid=-1;;
    while (low<=high) {
      
   mid=(low+high)/2;
   if(arr[mid]==target){
     return mid;
   }
   //chk left sorted
   else if(arr[low]<=arr[mid]){
    if(arr[low]<=target && target<=arr[mid]){

      high=mid-1;
    }
   
   else{
    low=mid+1;
   }
  }

    else{
          if(arr[mid]<=target && target<=arr[high]){
            low=mid+1;
          }
          else{
            high=mid-1;
          }
         }  
    }
    return -1;


}

//Find minimum in rotated sorted array

public static int MinimumInRotatedSortedArray(int arr[])
{
  int min=10000;
  int low=0;int high=arr.length-1;

  while(low<=high){

    int mid=(low+high)/2;
if(arr[low]<=arr[mid])
{
      min=Math.min(min,arr[low]);
      low=mid+1;
}
else if(arr[mid]<=arr[high]){

  min=Math.min(min,arr[mid]);
  high=mid-1;
}
  }

return min;
}


//find how many times array is rotated

public static int TimesofArraySorted(int arr[])
{
  int min=10000;
  int low=0;int high=arr.length-1;
int index=-1;
  while(low<=high){

    int mid=(low+high)/2;
if(arr[low]<=arr[mid])
{
      if(arr[low]<=min){
index=low;
    min=arr[low];
  }
      low=mid+1;
}
else if(arr[mid]<=arr[high]){

  if(arr[mid]<=min){
index=mid;
    min=arr[mid];
  }
  
  high=mid-1;
}
  }

return index;
}
public static void main(String[] args) {
    int array[]={2,3,4,5,1};
      int target=79;

    int ans=BinarySearch(target,array);
  //  System.out.println("ur element");
  //   System.out.println("the elemnt found at index"+ ans);
  //   //System.out.println(FirtAndLastOccurence(array,8));
  //   System.out.println(LowerBound(array, 8));
  //   System.out.println(UpperBound(array, 8));
   
  //   for (int i : FirtAndLastOccurence(array,9)) {
  //     System.out.println(i);
  //   }
   // System.out.println("The floor from the given array is"+ Floor(array,9));
   System.out.print("index at");
   System.out.println(SearchRotated(array, 6));
   System.out.println(MinimumInRotatedSortedArray(array));
   System.out.println(TimesofArraySorted(array));




}

}
