import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Arrayhard {


public static List<List<Integer>> threeSum(int[] arr) {
    int n = arr.length;
    List<List<Integer>> result = new ArrayList<>();
     Arrays.sort(arr);
     //System.out.print(Arrays.sort(arr));
    for (int i = 0; i < n - 2; i++) {
         if (i > 0 && arr[i] == arr[i - 1]) continue;
        for (int j = i + 1; j < n - 1; j++) {
            for (int k = j + 1; k < n; k++) {
                if (arr[i] + arr[j] + arr[k] == 0) {
                    result.add(Arrays.asList(i,j,k));
                    //return new int[]{i, j, k};
                }
            }
        }
    }
    // If no such triplet exists
    return result;
}

public static int LenthofSubarraySum(int[] arr){
// int sum=0,cnt=0,maxCnt=0;
// for(int i=0;i<arr.length;i++){
//     sum=0;
//     for(int j=i;j<arr.length;j++){
    
//         sum+=arr[j];
//         if(sum==0){
//            // maxCnt=cnt;
//             maxCnt=Math.max(maxCnt,j-i+1);
            
//         }

//     }
// }
// return maxCnt;


//using HAspmap



    HashMap<Integer, Integer> map = new HashMap<>();
    int maxLen = 0;
    int sum = 0;

    for (int i = 0; i < arr.length; i++) {
        sum += arr[i];

        if (sum == 0) {
            maxLen = i + 1;
        } else if (map.containsKey(sum)) {
            maxLen = Math.max(maxLen, i - map.get(sum));
        } else {
            map.put(sum, i);
        }
    }

    return maxLen;
}

//BinarySearch
public static int BinarySearch(int arr[],int target){
int low=0,high=arr.length-1;

    while(low<=high){
    int mid=low+(high-low)/2;
        if(arr[mid]==target){
            return arr[mid];
        }
        if(arr[mid]<target)
        {
            low=mid+1;
        }
        else{
            high=mid-1;
        }
    }
    return -1;
}
//Overlapping Arrays

public static List<int[]> findOverlapping(List<int[]> intervals)
{
   List<int[]> ans=new ArrayList<>();

    // Sort by start time
    intervals.sort(Comparator.comparingInt(a -> a[0]));

//System.out.println(intervals);
    for(int i=1;i<intervals.size();i++){
          int[] prev=intervals.get(i-1);
          int[]  curr=intervals.get(i);

          if(curr[0]<=prev[1] ){

           // System.out.println(i +" "+prev[0]+" "+ curr[1]);
                 ans.add(new int[] {
               Math.max(prev[0], curr[0]),
                Math.min(prev[1], curr[1])

          });
    }
  
    }
return ans;
}

//Merge OverLapping Intervals

public static List<int[]> MergeOverlapping(List<int[]> intervals){
List<int[]>  merge=new ArrayList<>();

intervals.sort(Comparator.comparingInt(a->a[0]));

if(intervals==null || intervals.size()<2) return intervals;

merge.add(intervals.get(0));

int [] current=intervals.get(0);


for(int i=0;i<intervals.size();i++){

    int[] next=intervals.get(i);

    if(current[1]>=next[0]){

        current[1]=Math.max(current[1], next[1]);
    }
    else{
        current=next;
        merge.add(current);
    }

}



return merge;
}

public static void main (String[] args) {
    int[] nums = {1,5,7,9,12,24,36};
    int[] arr2={1,-1,3,2,-2,-8,1,7,10,2,3,7,9,10};
    // int[] num = Arrays.sort(nums);
    //List<List<Integer>> result = threeSum(nums);
    //System.out.println(result);
    // System.out.println(LenthofSubarraySum(arr2));
     //System.out.println(BinarySearch(nums,24));

      List<int[]> intervals = Arrays.asList(
            new int[] {1, 3},
            new int[] {2, 6},
            new int[] {8, 9},
            new int[] {9, 11},
            new int[] {8, 10},
            new int[] {15, 18},
            new int[] {16, 17}
        );

        List<int[]> overlaps = findOverlapping(intervals);

        System.out.println("Overlapping intervals:");
        for (int[] interval : overlaps) {
            System.out.println(Arrays.toString(interval));
        }
 

        System.err.println("merge");
        List<int[]> merged=MergeOverlapping(intervals);

        for(int[] i : merged){
            System.out.println(Arrays.toString(i));
        }

       
    
}
}

