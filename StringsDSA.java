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
int j=0;
    for(int i=words.length-1;i>=0;i--){

        strB.append(words[i]);
        strB.append(" ");
       
    }
    return strB.toString().trim();
}
    public static void main(String[] args) {
        String S="Hi how are you Doing  rt";
        String haystack="Sadbutsad";
        String needle="but";
        System.err.println(reverseWords(S));
       // System.out.println(LengthofWord(S));
       // System.out.println(FirstOccurence(haystack,needle));
    }
}
