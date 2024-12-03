//goal: boolean + count;
//condition: decrease or increase, at the most 3, return true;
//solution: for loop

package main.day2;
public class day2 {
    public boolean day2solution(int[] nums) {
        int i = 1;

        while (i < nums.length) {
            if ((nums[i] > nums[i-1] && nums[i] - nums[i-1] <= 3 ) || (nums[i] < nums[i-1] && nums[i-1] - nums[i] <=3)) {
                i++;
            } else {
                return false;
            } 
        }
        return true;
    }
    
}
