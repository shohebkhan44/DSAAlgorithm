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
    public static void main(String[] args) {

        System.out.println(longestSubstringWithKDistinct("eceba", 2)); 
        System.out.println(LongestSubstringWithoutRepeatingChar("abcdefghij"));
        
    }
}