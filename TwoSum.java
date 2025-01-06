package DSAAlgorithm;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public  static int[] twoSumm(int[] ar, int target)

    {
        Map<Integer, Integer> d = new HashMap<>();
        for (int i = 0; i < ar.length; i++)
        {
            int x = ar[i];
            int y = Math.abs(x - target);
            if (d.containsKey(y))
             {
                return new int[] { d.get(y), i };
            } 

            d.put((x),i);
        }
        throw new IllegalArgumentException("No solution found");
    }

    public static void main(String[] args) {
        int[] ar = { 2, 7, 11, 15};
        int target = 17;
        System.out.println("huhuhuh");
        try {
            int[] result = twoSumm(ar, target);

            // Output the result (indices of the two numbers that sum to target)
            System.out.println("Indices of the two numbers that add up to " + target + ": [" + result[0] + ", " + result[1] + "]");
        } catch (IllegalArgumentException e)
        {
            // In case no solution is found (though we expect there to be one)
            System.out.println(e.getMessage());
        }
    }
}
