import java.util.HashSet;
import java.util.Set;

public class ArrayDSA {
    
public static void UnionArray(int[] arr,int[] ar2)
{
for(int i=0;i<arr.length;i++){
    for(int j=0;j<ar2.length;j++)
    {
             if(arr[i]<ar2[j]){
                System.out.print(arr[i]);
     
                i++;
             }
             else if(arr[i]>ar2[j]){
                System.out.print(ar2[j]); 
                j++;
             }
             else
             {
                System.out.print(ar2[j]);
                
             }
    }
    
}

}

static boolean sortedArray(int [] arr){
  boolean flag=true;
    for(int i=arr.length-1;i>0;i--)
    {
        if(arr[i]<arr[i-1]){
            flag=false;
        }
    }
return flag;

}

    public static void main(String[] args) {
        int[] ar={1,3,5,7,8};
        int[] ar2={1,1,2,2,2,2,3,4,5,9,7,13};
        Set<Integer> st=new HashSet<>();
        for(int i=0;i<ar2.length;i++){
            //to insert into a set TC=nlogn
            st.add(ar2[i]);
        }
        System.out.println("Set elements" + st);
        System.out.println(st.size());
       // UnionArray(ar,ar2);
        boolean flagresponse=sortedArray(ar2);
        if (flagresponse) {
            System.out.println("its sorted");
        }
        else{
            System.out.println("its not sorted");
        }
    }
}
