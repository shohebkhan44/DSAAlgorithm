
public class ArrayDSA {
    
public static void UnionArray(int[] arr,int[] ar2){
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
                i++;j++;
             }
    }
}

}

    public static void main(String[] args) {
        int[] ar={1,3,5,7,8};
        int[] ar2={2,3,4,5,9};
        UnionArray(ar,ar2);
    }
}
