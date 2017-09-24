package leetcode;

import java.util.HashMap;
import java.util.Map;


public class TwoSum {
	public static void main(String[] args) {
		TwoSum twoSum = new TwoSum();
		int[] nums = new int[]{3,2,4};
		int target = 6;
		int[] res = twoSum.twoSum(nums, target);
		System.out.printf("The first index: %d%n"
				+ "The second index: %d%n", res[0], res[1]);
	}
	
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> myMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			myMap.put(nums[i], i);
		}
		int[] res = new int[2];
		for (int i = 0; i < nums.length; i++) {
			if (myMap.containsKey(target - nums[i]) && myMap.get(target - nums[i]) != i) {
				res[0] = Math.min(i, myMap.get(target - nums[i]));
				res[1] = Math.max(i, myMap.get(target - nums[i]));
				break;
			}
		}
		return res;
	}
}