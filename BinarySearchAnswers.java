public class BinarySearchAnswers {
    

    //find the square root of given interger/number

    public static int SqrtBS(int num){
       int ans=1;int low=1;int high=num;
       while (low<=high) {
        
        int mid=(low+high)/2;
        if(mid*mid <=num){
            ans=mid;
            low=mid+1;
        }
        else{
            high=mid-1;
        }
       }

        return ans;
    }

    public static void main(String[] args) {
        int num=49;
        System.out.println("square root of"+ num  +"is"+SqrtBS(num));
    }
}
