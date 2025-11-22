import java.util.HashSet;
import java.util.Set;

public class ArrayDSA {
    
public static void UnionArray(int[] arr,int[] ar2)
{
    // Simple union implementation using a HashSet.
    // Prints unique elements from first array followed by new elements from second array.
    Set<Integer> set = new HashSet<>();
    if (arr != null) {
        for (int x : arr) {
            if (set.add(x)) System.out.print(x + " ");
        }
    }
    if (ar2 != null) {
        for (int x : ar2) {
            if (set.add(x)) System.out.print(x + " ");
        }
    }
    System.out.println();

}

static boolean sortedArray(int [] arr){
  boolean flag=true;
    for(int i=arr.length-1;i>0;i--)
    {
        if(arr[i]<arr[i-1]){
            flag=false;
        }
    }
return flag;

}
static int secondLargest(int[] arr){
    int secondLargest=0;
    int max=arr[0];
    for(int i=1;i<arr.length-1;i++){
         if(arr[i]>max && arr[i]>secondLargest){
             secondLargest=max;
            max=arr[i];
         }
    }
    return secondLargest;
}
static int[] rotateleft(int[] arr){
    int temp=arr[0];
    for(int i=1;i<=arr.length-1;i++){
        arr[i-1]=arr[i];
    }
    arr[arr.length-1]=temp;
    return arr;
}
//from copilot
static int[] rotateleftCopy(int[] arr){
    if (arr == null || arr.length <= 1) return arr;
    int n = arr.length;
    int[] out = new int[n];
    for (int i = 0; i < n - 1; i++) out[i] = arr[i + 1];
    out[n - 1] = arr[0];
    return out;
}

static int[] rotateDpositions(int[] arr,int position){
int[] temp=new int[10];
for(int i=0;i<position;i++){
    temp[i]=arr[i];
}

for(int i=position;i<arr.length;i++)
{
    arr[i-position]=arr[i];
}

for(int i=arr.length-position;i<arr.length;i++)
{
    arr[i]=temp[i-(arr.length-position)];
}
return arr;

}
//Shift zeroes to end
static int[] shiftZeroes(int[] arr){
int j=0;
    for(int i=0;i<arr.length;i++){
          if(arr[i]!=0){
            arr[j]=arr[i];
            j++;
          }
    }
    for(int k=j;k<arr.length;k++){
        arr[k]=0;
    }
    return arr;
}
static int consecutiveOnes(int[] arr){
    int max=0;
    int counter=0;
    for(int i=0;i<arr.length;i++){
        if(arr[i]==1){
            counter+=1;
        }
        else {
        if(counter >max){
            max=counter;
            counter=0;
        }
    }
    }
    return max;
}
//SubArray with Sum K 
static int SubArrayWithSum(int arr[],int k){
 int sum=0,counter=0,max=0;
for(int i=0;i<arr.length;i++)
{
    if(arr[i]<=k && sum<k && sum!=k)
    {
        sum+=arr[i];
        counter++;
    }
    else{
        if(counter > max){
              max=counter;
               counter=0;
                sum=0;
        }
    }
}return max;
}


//two sum

static int[] twoSum(int[] arr,int k){
    //bruteforceApproach
    // for(int i=0;i<arr.length;i++){
    //     for(int j=i;j<arr.length;j++){
    //         if(arr[i]+arr[j]==k){
    //             return new int[]{i,j};
    //         }
    //     }
    // }
    //  return new int[]{-1,-1};

    //optimalApproach
    //optimalApproach
int left=0,right=arr.length-1;
while(left<right){

    if(arr[left]+arr[right]==k){
          return new int[]{left,right};
    }
    else if(arr[left]<k-arr[right]){
        left++;
    }
    
} return new int[]{-1,-1};
}

static int[] SortedZeroesOnestwos(int[] arr) {
    int low = 0, mid = 0, high = arr.length - 1;
    int temp;

    while (mid <= high) {
        if (arr[mid] == 0) {
            // swap arr[low] and arr[mid]
            temp = arr[low];
            arr[low] = arr[mid];
            arr[mid] = temp;
            low++;
            mid++;
        } else if (arr[mid] == 1) {
            mid++;
        } else {  // arr[mid] == 2
            // swap arr[mid] and arr[high]
            temp = arr[mid];
            arr[mid] = arr[high];
            arr[high] = temp;
            high--;
        }
    }
    return arr;
}
static int maxLenSubarrayWithSumLE(int[] arr, int k) {
    int left = 0, sum = 0, max = 0;
    for (int right = 0; right < arr.length; right++) {
        // if a single element exceeds k, it cannot belong to any valid window;
        // reset window to the next index
        if (arr[right] > k) {
            sum = 0;
            left = right + 1;
            continue;
        }
        sum += arr[right];
        while (sum > k && left <= right) {
            sum -= arr[left++];
        }
        max = Math.max(max, right - left + 1);
    }
    return max;
}

    public static void main(String[] args) {
        int[] ar={1,3,5,7,8};
        int[] ar2={1,2,3,1,1,-1,4,-2,3};
        int [] ar3={1,4,0,5,4,9,12,0};
        int [] ar4={0};
        int[] ar5={1,0,1,0,2,2,1,1,2,2,1};
        // Set<Integer> st=new HashSet<>();
        // for(int i=0;i<ar2.length;i++){
        //     //to insert into a set TC=nlogn
        //     st.add(ar2[i]);  
        // }
        System.out.println("two sum");
       // System.out.println(twoSum(ar, 12));
        //  for (int i : twoSum(ar, 12)) {
        //     System.out.println(i);
        // }
System.out.println("The sorted array STH_Algo");
 for (int i : SortedZeroesOnestwos(ar5)) {
            System.out.print(" " +i);
        }
        System.out.println("Longest Subarray is " + SubArrayWithSum(ar2, 5));
       
        System.out.println("Count of consecutive ones"   + consecutiveOnes(ar4));
       
        System.out.println("arrays wth xeroes at end");
        
        for (int i : shiftZeroes(ar3)) {
            System.out.print(" " +i);
        }
        System.out.println("left rotate d positions");
        int[] rotateDpos=rotateDpositions(ar, 3);
        for (int i : rotateDpos) {
            System.out.print(i);
        }
        //  System.out.println("left rotate");
        //  int[] leftRotate=rotateleft(ar);
        //  for (int i : leftRotate) {
        //     System.out.print(i);
        //  }
        //  System.out.println();
         System.out.print("Secondlargest");
        System.out.println(secondLargest(ar));
        // System.out.println("Set elements" + st);
        // System.out.println(st.size());
       // UnionArray(ar,ar2);
    System.out.println("\nUnion of ar and ar2:");
    UnionArray(ar, ar2);
        // boolean flagresponse=sortedArray(ar);
        // if (flagresponse) {
        //     System.out.println("its sorted");
        // }
        // else{
        //     System.out.println("its not sorted");
        // }
    }
}
