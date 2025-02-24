
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

public static void Secondsmallest(int[] ar) {
  final int smallest=Arrays.stream(ar).distinct().sorted().skip(1).
  findFirst().orElseThrow(()->new IllegalArgumentException("array dont hv number"));
  System.out.println("the second smallest is "+ smallest);
}

public static void duplicate(int[] ar1,int[] ar2)
{
  List<Integer> elements=Arrays.stream(ar1).filter(number ->Arrays.stream(ar2).anyMatch(ar2num->ar2num==number)).boxed().collect(Collectors.toList());
  System.err.println("duplicates are"+elements);
}
public static void reverseInplace(int[] arr){
IntStream.range(0,arr.length/2).forEach(i ->{
int temp=arr[i];
arr[i]=arr[i]=arr[arr.length-i-1];
arr[arr.length-i-1]=temp;
});

System.out.println("tayhe new arr"+Arrays.toString(arr));
}



    public static void main(String[] args) {
      String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
      int ages[]={13,5,6,8,9,5};
     String[] Logos={"audi","BMW","bentley"};
      int lowest=ages[0];
      //duplicate(ar, ar2);
      //Secondsmallest(ages);
      //reverseInplace(ar);
 for(String i:Logos){
  System.out.println(i);
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
        System.out.println(cars[i]);
      }

      for (String s: cars) {
        System.out.println(s);
      }


    }
  }