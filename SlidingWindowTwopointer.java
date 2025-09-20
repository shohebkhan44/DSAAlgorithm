import java.util.Arrays;
import java.util.HashMap;

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

  //Longest Subarray with consecutive !s with max K zeroes


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
    public static void main(String[] args) {

        int[] arr={1,0,0,1};
        int[] fruits={3,3,3,1,2,1,1,2,3,3,4};
       // System.out.println(longestSubstringWithKDistinct("eceba", 2)); 
       // System.out.println(LongestSubstringWithoutRepeatingChar("abcdefghij"));
        //System.out.println(LongestSubarray(arr, 2));
        System.out.println(fruitsInbaskets(fruits, 2));
        
    }
}