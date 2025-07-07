import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class StringsDSA {
   
//Count length of last word

public static int LengthofWord(String S)
{
int length=0;
String str=S.trim();

for(int i=str.length()-1;i>=0;i--){

    if(str.charAt(i)!=' '){
        length++;
    }
    else{
        break;
    }
}

    return length;
}

//find the index of first occurence in a string

public static int FirstOccurence(String S,String T){

      for(int i=0;i<S.length()-1;i++){

        if(S.charAt(i)==T.charAt(0)){

            if(S.substring(i,T.length()+i).equals(T)){
                return i;
            }
        }
      }
      return -1;

}

//reverse Words in String

public static String reverseWords(String str){


    String[] words=str.split(" +");
    StringBuilder strB=new StringBuilder();
    String S=str.trim();

    for(int i=words.length-1;i>=0;i--){

        strB.append(words[i]);
        strB.append(" ");
       
    }
    return strB.toString().trim();
}

//String is Palindrome

public static boolean Palindrome(String str){
//with function
//     StringBuilder s=new StringBuilder(str);
    
//     if(s.reverse().toString().equals(str)){
//         return true;

//     }
//     return false;

// Without funtion
String rev="";
for(int i=str.length()-1;i>=0;i--){
    rev=rev+str.charAt(i);
}
if(str.toLowerCase().equals(rev.toLowerCase())){
    return true;
}
return false;
 }

 //count numbers of characters

 public static int CountCharacters(String str)
 {
   int count=0;
   for(int i=0;i<str.length();i++)
   {
    if(str.charAt(i)!=' ')
       count++;
   }
   return count;
     
 }
 //Check if Anagram

 public static boolean Anagram(String str1,String str2)
 {
    if(str1.length()!=str2.length())
    {
        return false;
    }
    else{
     char[] ar1=str1.toCharArray();
     char[] ar2=str2.toCharArray();
       Arrays.sort(ar1);
         Arrays.sort(ar2);
//ar1.equals(ar2)- can also be used instead of for loop
         for(int i=0;i<ar1.length;i++){

         if(ar1[i]!=ar2[i]){
            return false;
         }
        }
    }
    return true;

 }

 //first unique Character

 public static char FirstUniqueChar(String str)
 {
            char ch[]=str.toCharArray();
            int fre[]=new int[26];
            for (char c : ch) {
                fre[c-'a']++;
            }
           for(int i=0;i<fre.length;i++){
                      if(fre[ch[i]-'a']==1){
                        return ch[i];
                      }
           }
           return '\0';

 }
 //reverse vowels in a string

 public static String ReverseVowels(String str)
      {
        char ch[]=str.toCharArray();
         int start=0;
         int end=str.length()-1;
         while (start <end) {
            if(!IsVowel(ch[start])){
                  start++;
            }
             else if(!IsVowel(ch[end]))
            {
                end--;
            }
            else{
                char temp=ch[start];
                ch[start]=ch[end];
                ch[end]=temp;
                start++;
                end--;

            }
         }
        
       return String.valueOf(ch);
 

      }  
      public static boolean IsVowel(char ch){

        if(ch=='a' ||ch=='e' || ch=='i' || ch=='o' || ch=='u') return true;
        else return false;
      }   
      
  //Word pattern
  
  public static boolean WordPattern(String S,String pattern)
  {

        char pat[]=pattern.toCharArray();
        String str[]=S.split(" ");

        HashMap<Character,String> map=new HashMap<>();
        HashSet<String> words=new HashSet<>();
        if(str.length!=pat.length) return false;

          for(int i=0;i<pat.length;i++){

                if(map.containsKey(pat[i])){
                      if(!map.get(pat[i]).equals(str[i])){

                        return false;
                      }
                    }
                      else{
                            if(words.contains(str[i])){
                                return false;
                            }
                        map.put(pat[i],str[i]);
                        words.add(str[i]);
                      }
                
            
                    }
                    return true;



  }

  //Valid palindrome

  public static boolean ValidPalindrome(String str){

           StringBuilder s=new StringBuilder(str);
 //remove all non-alphanumeric characters
         str=str.toLowerCase().replaceAll("[^A-Za-z0-9]","");
int start=0;int end=str.length()-1;
         while(start <=end){
             if(str.charAt(start)!=(str.charAt(end))){
                return false;
             }
             else{
                start++;end--;
             }
         }
         return true;
  }

  // Longest common prefix

  public static String LongestCommonPrefix(String[] str)
  {
    //just sort the array,and compare the first and last string
     
              char[] st=str[0].toCharArray();
              char[] st2=str[str.length-1].toCharArray();
              int max=0;
              Arrays.sort(str);
              for(int i=0;i<str.length;i++)
              {
              if(st[i]==st2[i])
              {
                max++;
              }
            }
              return max==0?"":String.valueOf(st).substring(0,max);
                  
  }
  //Find the Difference

  public static char StringDifference(String s,String t){
// doesnt take care of duplicates
    // for(int i=0;i<t.length();i++){

    //     if (!s.contains(String.valueOf(t.charAt(i)))) {
    //             return t.charAt(i);  
    //        }
    // }
    // return '\0';

    int[] count=new int[256];

    for (char c : s.toCharArray()) {
        count[c]++;
    }
    for (char ch : t.toCharArray()) {
        count[ch]--;

        if(count[ch]<0)return ch;
    }
    return '\0';


  }

  //Isomorphic Strings
public static boolean IsomorphicStrings(String s,String t)
{

HashMap<Character,Character> hm=new HashMap<>();
HashSet<Character> hs=new HashSet<>();
      for(int i=0;i<s.length();i++){
            
        if(hm.containsKey(s.charAt(i))){

            if(hm.get(s.charAt(i))!=t.charAt(i)){
                    return false;
                   }
                   
        }
        else{
            if(hs.contains(t.charAt(i))){
                return false;
            }
            hm.put(s.charAt(i), t.charAt(i));
            hs.add(t.charAt(i));
        }
        
                   
      }return true;
       
}

//Almost Equivalent Strings

public static boolean EquivalentStrings(String s,String t)
{
  
HashMap<Character,Integer> hs=new HashMap<>();
HashMap<Character,Integer> ht=new HashMap<>();
if(s.length()!=t.length()) return false;

for(int i=0;i<s.length();i++){
        char skey=s.charAt(i);
          char tkey=s.charAt(i);
        if(hs.containsKey(s.charAt(i))){
            hs.put(skey, hs.get(skey)+1);
        }
         if(ht.containsKey(tkey)){
            ht.put(tkey, ht.get(tkey)+1);
        }

}

for (char c : hs.keySet()) {
        int freqS = hs.getOrDefault(c, 0);
        int freqT = ht.getOrDefault(c, 0);
        if (Math.abs(freqS - freqT) > 3) {
            return false;
        }
    }
return true;
}

//Power of Two

public static boolean PowerTwo(int n)
{
     if (n <= 0) return false;
      while(n!=1)
      { 
        
         if(n%2!=0){
            return false;
         }
          n=n/2;
      }
      return true;
      
}
    public static void main(String[] args) {
        String S="Hi how are you Doing  rt";
        String haystack="Sadbutsad";
        String needle="but";
        String[] strArr={"boomrang","bolt","boing","boll"};
       // System.err.println(reverseWords(S));
       // System.out.println(Palindrome("radar"));
        //System.out.println(CountCharacters("foot ball"));
       // System.out.println(Anagram("keep","pseek"));
       // System.out.println(LengthofWord(S));
       // System.out.println(FirstOccurence(haystack,needle));
       //System.out.println(FirstUniqueChar("poppoy"));
      //System.out.println(ReverseVowels("again"));
      //System.out.println(WordPattern("apple banana banana aple","abba"));
      //System.out.println(ValidPalindrome("madamonomadama"));
      //System.out.println(LongestCommonPrefix(strArr));
     // System.out.println(StringDifference("abc","abcc"));
     // System.out.println(IsomorphicStrings("aa","gg"));
      //System.out.println(EquivalentStrings("aab", "aaabbb"));
      System.out.println(PowerTwo(1));
    }
}
