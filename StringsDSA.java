import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

//Concatenated words
public static List<String> ConcatenatedWords(String[] words){

       HashMap<String,Boolean> hm=new HashMap<>(); 
       Set<String>  st=new HashSet<>(Arrays.asList(words));
       List<String> result=new ArrayList<>();
       for(int i=0;i<words.length;i++){

                 if(isConcatenate(words[i],st,hm)){
 result.add(words[i]);

                 }

       }

return result;
}

//To chk word is concatenate

public static boolean isConcatenate(String str,Set<String> st,HashMap<String,Boolean> hm){

          if(hm.containsKey(str)){
            return hm.get(str);
          }
          
                for(int i=0;i<str.length()-1;i++){
                  String prefix=str.substring(0,i+1);
                  String suffix=str.substring(i+1);
                     
                  if((st.contains(prefix) && st.contains(suffix)) ||
                   (st.contains(prefix) && isConcatenate(suffix, st, hm))){

                         hm.put(str, true);
                         return true;

                   }
                     

                }
               hm.put(str, false);
                   return false;
}

//string S is subsequence of other string T

public static boolean  IsSubsequence(String S,String T)
{
       int i=0;int j=0;
         while(i<=S.length()-1 && j<=T.length()-1){

        if (S.charAt(i) == T.charAt(j)) 
          {
               i++;j++;
          }
          else{
            j++;
          }

        }
      boolean result = (i == S.length());

return result;
}

//Reverse only characters

public static char[] ReverseCharacters(String str)
{
  char[] newStr=str.toCharArray();
int start=0;int end=str.length()-1;
            
             while (start < end) {
              if(!Character.isLetter(newStr[start])){
                start++;
              }
              else if(!Character.isLetter(newStr[end]))
              {
                     end--;
              }
    else {
                 char temp=newStr[start];
                 newStr[start]=newStr[end];
                 newStr[end]=temp;
            start++;end--;
             }


             }
             return newStr; 
   }


//prefix of any word

public static int prefixofWord(String str,String search)
{
      String words[]=str.split(" ");

      for(int i=0;i<words.length;i++)
      {
           if(words[i].startsWith(search)){

            return i+1;
           }

      }
      return -1;
    }

    //Number of vowels strings

    public static int NumberOfVowels(String str[])
    {

      int count=0;
        for(int i=0;i<=str.length-1;i++)
        {
          char start=str[i].charAt(0);
          char end=str[i].charAt(str[i].length()-1);
           if(start=='a' ||start=='e' ||start=='i' ||start=='o' ||start=='u'){

           
           if(end=='a' ||end=='e'||end=='i' ||end=='o' ||end=='u' ){
                  count++; 
           }

        }
      }
       return count;
             
    }


//Merge String Alternate

public static String MergedAlternate(String S,String T)
{
     
            StringBuilder mergedString=new StringBuilder(); 
            int Sindex=0;int Tindex=0;
            
             while(Sindex < S.length() && Tindex < T.length() ){

                    mergedString.append(S.charAt(Sindex++));
                    mergedString.append(T.charAt(Tindex++));
             }
             while (Sindex < S.length()) {
                   mergedString.append(S.charAt(Sindex++));
    }
                  while (Tindex < T.length()) {
                   mergedString.append(T.charAt(Tindex++));
            }
             

         return mergedString.toString();    
            
}

//Contains the charcter in words

public static List<Integer> ContainsCharacter(String[] str,char x)
{

int i=0;
List<Integer> ls=new ArrayList<>();
  

while (i<str.length) {
     
  if(str[i].indexOf(x)!=-1){
      ls.add(i);

  }
  i++;
}
return ls;


}

//Roman to integers

public static int ConvertRtoInt(String S){
int sum=0;int prevalue=0;
HashMap<Character,Integer> hm=new HashMap<>();

    hm.put('I',1);
     hm.put('V',5); hm.put('X',10); hm.put('L',50);
      hm.put('C',100); hm.put('D',500); hm.put('M',1000);
for(int i=S.length()-1;i>=0;i--)
{
  int curretValue=hm.get(S.charAt(i));
    if(prevalue<=curretValue){
      sum+=curretValue;
    }
    else{
      sum-=curretValue;
    }
    prevalue=curretValue;

}
return sum;

}

// Valid Parentheses

public static Boolean ValidParentheses(String str)
{
  while(true)
  {
    String original=str;
  

   
    str=str.replace("()", ""); 
    str=str.replace("{}", "");
    str=str.replace("[]", "");
   
   if(str.equals(original))
    return str.isEmpty();
   }
}


    public static void main(String[] args) {
        String S="Hi how are you Doing  rt";
        String haystack="Sadbutsad";
        String needle="but";
        String[] strArr={"boomrang","bolt","boing","boll"};
       String[] words = {"cat", "cats", "dog", "catsdog", "rat", "ratcatdog"};
       // List<String> result = ConcatenatedWords(words);

        // System.out.println("Concatenated Words:");
        // for (String word : result) {
        //     System.out.println(word);
        // }

       
       // System.err.println(reverseWords(S));
       // System.out.println(Palindrome("radar"));
        //System.out.println(CountCharacters("foot ball"));
       // System.out.println(Anagram("keep","pseek"));
       // System.out.println(LengthofWord(S));
        //System.out.println(FirstOccurence(haystack,needle));
       //System.out.println(FirstUniqueChar("poppoy"));
      //System.out.println(ReverseVowels("again"));
      //System.out.println(WordPattern("apple banana banana aple","abba"));
      //System.out.println(ValidPalindrome("madamonomadama"));
      //System.out.println(LongestCommonPrefix(strArr));
     // System.out.println(StringDifference("abc","abcc"));
     // System.out.println(IsomorphicStrings("aa","gg"));
      //System.out.println(EquivalentStrings("aab", "aaabbb"));
      //System.out.println(PowerTwo(1));
      //System.out.println(IsSubsequence("abc", "dabjhc"));
      //System.out.println(ReverseCharacters("a-bC-dEf-ghIj"));
      //System.out.println(prefixofWord("drum burger along fre","dr"));
      String[] str={"apple", "orange", "banana", "umbrella", "Ink", "echo", 
      "try", "area", "sky", "Egg"};;
      //System.out.println(NumberOfVowels(str));
      //System.out.println(MergedAlternate("abc", "pqr"));
      //System.out.println(ContainsCharacter(str,'a'));
      //System.out.println(ConvertRtoInt("F"));
      System.out.println(ValidParentheses("{[()]}"));

    }
}
