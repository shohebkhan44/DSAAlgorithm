public class Recursion {
    
//finding power
public static double Power(int x,int n)
{

    double num=n;
    double ans=1;

    while (num>0) {
        
        if(num%2== 0)
        {
            x=x*x;
            num=num/2;
        }
        else{
            ans=ans*x;
            num=num-1;

        }
    }
    if(n<0) {
        ans=(double)1.0/(double)ans;
    }

    return ans;

}
    public static void main(String[] args) {
        
          System.out.println("the answer is" + " "+Power(2, 10));

    }
}
