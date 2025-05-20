public class SortingAlgo {

    //SelectionSort
   static int[] Selectionsort(int[] arr){

    for(int i=0;i<arr.length-1;i++){
int min=i;
         for(int j=i;j<arr.length;j++)
         {
            if(arr[j]<arr[min])
            {
                min=j;
            }
         }
         int temp=arr[i];
         arr[i]=arr[min];
         arr[min]=temp;
    }
    return arr;
   }
   //bubbleSort

   static int[] bubbleSort(int[] arr){

    for(int i=0;i<arr.length-1;i++){
 for(int j=0;j<arr.length-1-i;j++){

    if(arr[j]>arr[j+1])
    {
        int temp=arr[j];
        arr[j]=arr[j+1];
        arr[j+1]=temp;
    }

 }
    }
    return arr;
   }
    public static void main(String[] args) {
        
        int[] arr={12,5,7,13,5,41};
    //int[] arrr= Selectionsort(arr);
    int[] arrr=bubbleSort(arr);
        for(int i=0;i<arrr.length;i++){
            System.out.println(arrr[i]);
        }
    }
}
