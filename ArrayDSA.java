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
static int secondLargest(int[] arr){
    int secondLargest=0;
    int max=arr[0];
    for(int i=1;i<arr.length-1;i++){
         if(arr[i]>max && arr[i]>secondLargest){
            max=arr[i];
            secondLargest=max;
         }
    }
    return secondLargest;
}
static int[] rotateleft(int[] arr){
    int temp=arr[0];
    for(int i=1;i<=arr.length-1;i++){
        arr[i-1]=arr[i];
    }
    arr[arr.length-1]=temp;
    return arr;
}

static int[] rotateDpositions(int[] arr,int position){
int[] temp=new int[10];
for(int i=0;i<position;i++){
    temp[i]=arr[i];
}

for(int i=position;i<arr.length;i++)
{
    arr[i-position]=arr[i];
}

for(int i=arr.length-position;i<arr.length;i++)
{
    arr[i]=temp[i-(arr.length-position)];
}
return arr;

}
//Shift zeroes to end
static int[] shiftZeroes(int[] arr){
int j=0;
    for(int i=0;i<arr.length;i++){
          if(arr[i]!=0){
            arr[j]=arr[i];
            j++;
          }
    }
    for(int k=j;k<arr.length;k++){
        arr[k]=0;
    }
    return arr;
}


    public static void main(String[] args) {
        int[] ar={1,3,5,7,8};
        int[] ar2={1,1,2,2,2,2,3,4,5,9,7,13};
        int [] ar3={1,4,0,5,4,9,12,0};
        // Set<Integer> st=new HashSet<>();
        // for(int i=0;i<ar2.length;i++){
        //     //to insert into a set TC=nlogn
        //     st.add(ar2[i]);
        // }
        System.out.println("arrays wth xeroes at end");
        
        for (int i : shiftZeroes(ar3)) {
            System.out.print(" " +i);
        }
        System.out.println("left rotate d positions");
        int[] rotateDpos=rotateDpositions(ar, 3);
        for (int i : rotateDpos) {
            System.out.print(i);
        }
        //  System.out.println("left rotate");
        //  int[] leftRotate=rotateleft(ar);
        //  for (int i : leftRotate) {
        //     System.out.print(i);
        //  }
        //  System.out.println();
        // System.out.print("Secondlargest");
        // //System.out.println(secondLargest(ar));
        // System.out.println("Set elements" + st);
        // System.out.println(st.size());
       // UnionArray(ar,ar2);
        // boolean flagresponse=sortedArray(ar);
        // if (flagresponse) {
        //     System.out.println("its sorted");
        // }
        // else{
        //     System.out.println("its not sorted");
        // }
    }
}
