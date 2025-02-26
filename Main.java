
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

public static void Secondsmallest(int[] ar) {
  //final int smallest=Arrays.stream(ar).distinct().sorted().skip(1).
  final int SecontSmallest=Arrays.stream(ar).distinct().sorted().skip(1).
  findFirst().orElseThrow(()->new IllegalArgumentException("array dont hv number"));
  System.out.println("the second smallest is "+ SecontSmallest);
}

public static void duplicate(int[] ar1,int[] ar2)
{
  List<Integer> elements=Arrays.stream(ar1).filter(number ->Arrays.stream(ar2).
  anyMatch(ar2num->ar2num==number)).boxed().collect(Collectors.toList());
  System.err.println("duplicates are"+elements);

  List<Integer> ele=Arrays.stream(ar1).filter(num ->Arrays.stream(ar2).
  anyMatch(ar2num ->ar2num==num)).boxed().collect(Collectors.toList());
  
}
public static void reverseInplace(int[] arr){
IntStream.range(0,arr.length/2).forEach(i ->{
int temp=arr[i];
arr[i]=arr[i]=arr[arr.length-i-1];
arr[arr.length-i-1]=temp;
});

//System.out.println("tayhe new arr"+Arrays.toString(arr));
}



    public static void main(String[] args) {
      String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
      int ages[]={13,5,6,8,9,5};
     String[] Logos={"audi","BMW","bentley"};
      int lowest=ages[0];
      //duplicate(ar, ar2);
      Secondsmallest(ages);
      //reverseInplace(ar);
 for(String i:Logos){
  //System.out.println(i);
 }
      for(int i:ages){
        if (lowest> i) {
          lowest=i;
        }
      }
     //System.out.println("the lowest age is" +  lowest);
      //System.out.println(cars[2]);
      //System.out.println(cars.length);


      for(int i=2;i<cars.length;i++){
        //System.out.println(cars[i]);
      }

      for (String s: cars) {
        //System.out.println(s);
      }
      //pattern -1
// for(int i=0;i<4;i++){
//   for(int j=0;j<4;j++)
//   {
//     System.out.print('*');
//   }
//   System.out.println();
// }

//pattern-2
// for(int i=1;i<=4;i++){
//     for(int j=0;j<i;j++)
//     {
//       System.out.print('*');
//     }
//     System.out.println();
//   }

//pattern-3

// for(int i=0;i<=4;i++){
//   for(int j=0;j<=i;j++)
//   {
//     System.out.print(j+1);
//   }
//   System.out.println();
// }

//pattern -4

// for(int i=5;i>0;i--){
//   for(int j=0;j<i;j++)
//   {
//     System.out.print('*');
//   }
//   System.out.println();
// }

//pattern-6

for(int i=5;i>0;i--){
  for(int j=1;j<=i;j++)
  {
    System.out.print(j);
  }
  System.out.println();
}

//pattern-7

// for(int i=5;i>0;i--){
//   for(int j=1;j<=i-1;j++)
//   {
//     System.out.print(" ");
//   }
//       for(int k=0;k<i*2+1;k++){
//         System.out.print('*');
//       }
    
//   }
  //System.out.println();
}


    }
  }