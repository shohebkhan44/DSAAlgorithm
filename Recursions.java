public class Recursions {
    public static void main(String[] args) {
        int[] arr={1,2,3,4};
        String str="hello";
        String str1="mamamamamamamm";
        String str2="fooo";
        printNumber(4);
        printNames("greattt", 4);
        Print1toN(1,4);
        PrintSum(0,5);
        ReverseArray(0,arr,arr.length);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
        }
        System.out.println(Strpalindrome(0,str,str.length()));
    }
        //print  number  recursively
    public static void printNumber(int n){
        if (n<=0) {//base condition
            return;
        }

        System.out.println(n);
        printNumber(n-1);
    }
    //print name n times recursively
    public static void printNames(String name,int c){

   if(c<=0){
return;
   }
        System.out.println(name);
        printNames(name, c-1);
    }

    //print 1 to n recursively

    public static void Print1toN(int i,int n){
           if(i>n){
return;
           }
        System.out.println(i);
  Print1toN(i+1,n);
    }

    public static void PrintSum(int sum,int n){

    if(n<=0){
        System.out.println(sum);
        return;
    }
    sum+=n;//for fatorial use sum*=n;
    //System.out.println(sum);
  PrintSum(sum,n-1);

    }
    public static void ReverseArray(int l,int[] arr,int r){
     
        if(l>=r){
            return ;
        }
arr[l]=arr[l]+arr[r-1];
arr[r-1]=arr[l]-arr[r-1];
arr[l]=arr[l]-arr[r-1];


 ReverseArray(l+1,arr,r-1);
    }
    //check if string i palindrome
    public static boolean Strpalindrome(int l,String str,int r){
        if(l>r){
            return true;
        }
if(str.charAt(l)!=str.charAt(r-1))
{
     return false;
     }
     return Strpalindrome(l+1, str, r-1);
    }

}

