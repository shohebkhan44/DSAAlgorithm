package DSAAlgorithm;
public class StringsJava {

    public static void main(String[] args) {
        String str="football";
        //charAt() method return char
        char ch=str.charAt(3);
        System.out.println("the char at 3" + ch);

        //turning a character array to a string
        char[] charr={'a','a','r','o'};
        String strr="Hello";
        String strr2=new String("Hello");

        String arrtostr=null;
        arrtostr=arrtostr.copyValueOf(charr,0,4);
        System.out.println(arrtostr);
        System.out.println(arrtostr.copyValueOf(charr,0,4).length());
        //String substr=arrtostr.substring(2);
        System.out.println(arrtostr.substring(0,3));
        System.out.println(strr.indexOf('l'));
        System.out.println(strr.lastIndexOf('l'));
        System.out.println(strr.replace('l', 'p'));
        System.out.println(strr);
        if(strr==strr2){
            System.out.println("they are equal");
        }
        else{
            System.out.println("they are not equal");
        }
        //System.out.println(strr.split('%e'));
        System.out.println(strr.trim());

//StringBuilder and StringBuffer
//stringbuilder is thread safe compare to stringbuffer
StringBuilder sb=new StringBuilder("football");
sb.append('c');
System.out.println(sb);


    }
}