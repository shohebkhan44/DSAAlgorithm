import java.util.ArrayList;
import java.util.Arrays;
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
public static void main(String[] args) {
    int[] nums = {-1,0,1,2,-1,-4};
    // int[] num = Arrays.sort(nums);
    List<List<Integer>> result = threeSum(nums);
    System.out.println(result);
    
}
}

