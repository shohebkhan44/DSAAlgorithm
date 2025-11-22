import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SlidingWindowTwopointer {

    

  //longest  substring with max k distinct characters
  
  
  private static int longestSubstringWithKDistinct(String s,int k)
  {
    int maxlength=0;int left=0,right=0;
    HashMap<Character,Integer> map=new HashMap<>();
            char[] str=s.toCharArray();
    while (right<s.length()) {
        
           map.put(str[right], map.getOrDefault(str[right], 0) + 1);


            while (map.size()>k) {
                map.put(str[left],map.get(str[left])-1);
                if(map.get(str[left])==0){
                    map.remove(str[left]);
                    
                }
                left=left+1;
            }
                
                    maxlength=Math.max(maxlength,right- left+1);
                
                right=right+1;
            
    }
    
    return maxlength;
  }

  //LongestSubstring without repeating characters

  private static int LongestSubstringWithoutRepeatingChar(String s)
  {
          int left=0;int right=0;
          
          
          int[] hashArray = new int[256]; // supports extended ASCII
    Arrays.fill(hashArray, -1); // initialize all values to -1
          int maxlength=0;
          char[] str=s.toCharArray();
          while (right <s.length()) {
            
              if(hashArray[str[right]]!=-1)
              {

                         if(hashArray[str[right]]>=left)
                         {
                            left=hashArray[str[right]]+1;
                         }
              }
               maxlength=Math.max(maxlength,right-left+1);
              hashArray[str[right]]=right;
              right++;
              

          }
          return maxlength;


  }

  //Longest Subarray with consecutive 1's with max K zeroes


  private static int LongestSubarray(int[] arr,int k)
  {

    int zeroes=0,left=0,right=0;
    int maxlength=0;
    while (right<arr.length) {
        
        if(arr[right]==0){
            zeroes++;
        }
        if(zeroes>k)
        {
            if(arr[left]==0) {
                
                zeroes--;
            }
            left=left+1;
        }
         maxlength=Math.max(maxlength, right-left+1);
         right++;

    }
    return maxlength;



  }

  //fruits in baskets

  private static int fruitsInbaskets(int[] fruits,int k)
  {
int left=0,right=0,maxlength=0;
HashMap<Integer,Integer> map=new HashMap<>();
        while (right<fruits.length) {
            
            map.put(fruits[right],map.getOrDefault(fruits[right], 0)+1);
            if(map.size()<=k)
            {
                maxlength=Math.max(maxlength, right-left+1);
            }
            else{

                while (map.size()<=k) {
                    
                    map.put(fruits[left],map.getOrDefault(fruits[left], 0)-1);
               if(map.get(fruits[left])==0){
                    map.remove(fruits[left]);
                    
                }
                left=left+1;

            }
        }
        right++;
        }
        return maxlength;

  }

  //Longest repeating character replacement

  private static int longestRepeatingCharacter(String s, int k) {
    int left = 0;
    int maxCount = 0;
    int maxLength = 0;
    Map<Character, Integer> map = new HashMap<>();

    for (int right = 0; right < s.length(); right++) {
        char ch = s.charAt(right);
        map.put(ch, map.getOrDefault(ch, 0) + 1);

        maxCount = Math.max(maxCount, map.get(ch));

        // if the remaining characters in the window are more than k, shrink window
        while ((right - left + 1) - maxCount > k) {
            char leftChar = s.charAt(left);
            map.put(leftChar, map.get(leftChar) - 1);
            left++;
        }

        maxLength = Math.max(maxLength, right - left + 1);
    }

    return maxLength;
}


    public static int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1);  // base case: prefix sum 0 occurs once

        int sum = 0;
        int count = 0;

        for (int num : nums) {
            sum += num;

            // If (sum - goal) has occurred before, it means we found a valid subarray
            count += prefixSumCount.getOrDefault(sum - goal, 0);

            // Store current sum count
            prefixSumCount.put(sum, prefixSumCount.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
    public static void main(String[] args) {

        int[] arr={1,0,0,1,1,0,0,1,1};
        int[] fruits={3,3,3,1,2,1,1,2,3,3,4};
       // System.out.println(longestSubstringWithKDistinct("eceba", 2)); 
       // System.out.println(LongestSubstringWithoutRepeatingChar("abcdefghij"));
        System.out.println(LongestSubarray(arr, 2));
        int[] nums = {1, 0, 1, 0, 1};
        int goal = 2;

        //System.out.println("Number of subarrays with sum = " + goal + ": " + numSubarraysWithSum(nums, goal));
    
      //  System.out.println(fruitsInbaskets(fruits, 2));
         int result = longestRepeatingCharacter("AABABBA", 1);
       // System.out.println("Longest substring length with at most " + 1  + " replacements: " + result);

        
    }
}