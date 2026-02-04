/* Write an algorithm that will binary search through a given integer arr
and return a target variable of your choosing */

public class TestInt2 {
   
   public static void main(String[] args) {
        int[] arr = {1,2,3};
        int target = 1;
        System.out.println(BS(arr,target));
     }
  
  public static int BS(int[] arr, int target) {
   
   
   int left = 0, right = arr.length - 1;
    
    // Simple check to find the direction
    boolean isAsc = arr[left] < arr[right];

    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (arr[mid] == target) return mid;

        if (isAsc) {
            if (target < arr[mid]) right = mid - 1;
            else left = mid + 1;
        } else {
            if (target > arr[mid]) right = mid - 1;
            else left = mid + 1;
        }
    }
    return -1;
   }
}
      
      
      
      
/* Here is the code I wrote:     

public class Solution {
    public static void main(String[] args) {
        // Write a binary search function to search through an arr and find a target
        
    }
    
    public int binarySearch (int [] arr, target) {
        // Define variables
        int middle = arr.length / 2;
        int left = 0;
        int right = arr[arr.length - 1];
        int i = 0;
    
        // If arr empty 
        if (arr.length == 0)
            return;
    
        
        // While loop
        while (left != right) {
            if (arr[middle] == target) {
                return middle;
            } else if (arr[middle] > target) {
                //Compute new middle by going right
                left = middle;
                middle = (left + right) / 2;
            } else if (arr[middle] < target) {
                //Compute new middle by going left
                right = middle;
                middle = (left + right) / 2;
            }
        }
    }
}
  
  

Other Notes:


1. You never tested your code with your own input function
2. Your loop is at risk of being infinite by writing left = middle || 
   right == middle and not left = middle + 1 || right = middle - 1

Line, The Issue, The Consequence
51,right = arr[arr.length - 1],"IndexOutOfBoundsException. You set the pointer to the value of the last element, not its position. If the last number is 100 but the array only has 10 items, the code crashes immediately."
56,return;,"Compilation Error. Your method is declared as int, so you must return a number (like -1), not nothing."
60,while (left != right),"Infinite Loop Risk. If the target isn't there, left and right might skip past each other and never be equal."
65 & 69,left = middle / right = middle,"Infinite Loop. If the range shrinks to 2 elements, middle will stay the same forever, and the pointers will never move. You need + 1 or - 1."
66 & 70,middle = (left + right) / 2,"Stagnant Logic. You are recalculating the middle inside the if blocks, which makes the code messy. It belongs at the very top of the while loop so it updates automatically every time."

/*Questions to ask the interviewer

1. Is the array sorted? and if so, in which directions?
2. How should I handle duplicates? (return the first occurence or any)
3. Can I assume the input fits in memory or should I account for interfer overflow when calculating the midpoint
*/