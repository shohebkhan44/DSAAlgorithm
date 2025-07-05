import java.util.Arrays;

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
    public static void main(String[] args) {
        String S="Hi how are you Doing  rt";
        String haystack="Sadbutsad";
        String needle="but";
       // System.err.println(reverseWords(S));
       // System.out.println(Palindrome("radar"));
        //System.out.println(CountCharacters("foot ball"));
       // System.out.println(Anagram("keep","pseek"));
       // System.out.println(LengthofWord(S));
       // System.out.println(FirstOccurence(haystack,needle));
       //System.out.println(FirstUniqueChar("poppoy"));
      System.out.println(ReverseVowels("again"));
    }
}
