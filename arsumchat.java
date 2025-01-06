package DSAAlgorithm;
import java.util.HashMap;
import java.util.Map;

public class arsumchat {
    
    
    
        // Make twoSum static so it can be called without creating an object
        public static int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> d = new HashMap<>();  // Map to store numbers and their indices
            for (int i = 0; i < nums.length; ++i) {  // Loop through the array
                int x = nums[i];  // Current number
                int y = target - x;  // The complement we are looking for
                
                // If the complement exists in the map, return the indices
                if (d.containsKey(y)) {
                    return new int[] {d.get(y), i};  // Return the index of complement and current number
                }
                
                // Otherwise, store the current number and its index in the map
                d.put(x, i);
            }
            
            // If no solution is found, throw an exception (though problem guarantees a solution)
            throw new IllegalArgumentException("No solution found");
        }
    
        public static void main(String[] args) {
            // Sample input
            int[] nums = {2, 7, 11, 15};  // Array of numbers
            int target = 9;  // Target sum
            
            // Call the static twoSum function directly
            try {
                int[] result = twoSum(nums, target);
    
                // Output the result (indices of the two numbers that sum to target)
                System.out.println("Indices of the two numbers that add up to " + target + ": [" + result[0] + ", " + result[1] + "]");
            } catch (IllegalArgumentException e) {
                // In case no solution is found (though we expect there to be one)
                System.out.println(e.getMessage());
            }
        }
    }
    






