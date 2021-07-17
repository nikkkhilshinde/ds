package leetcode.contest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution {

    public static void main(String[] args) {
        System.out.println(closestCost(new int[]{2, 3}, new int[]{4,5,100}, 18));
    }

    public int minOperations(int[] nums1, int[] nums2) {
        int nums1Sum = 0;
        int nums2Sum = 0;
        Map<Integer, Integer> nums1Map = new HashMap<>();
        Map<Integer, Integer> nums2Map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            nums1Sum += nums1[1];
            nums1Map.put(nums1[i], i);
        }
        for (int i = 0; i < nums2.length; i++) {
            nums2Sum += nums2[1];
            nums1Map.put(nums2[i], i);
        }

        int opCount = 0;
        while(nums1Sum != nums2Sum){
            if(Math.abs(nums1Sum-nums2Sum) > 5){
                if(nums1Sum > nums2Sum){
                    if(nums1Map.containsKey(6)){

                    }
                }
            }
        }
        return opCount;
    }

    public static int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        close = 0;
        results.clear();
        closestDistance = Integer.MAX_VALUE;
        for (int i = 0; i < baseCosts.length; i++) {
            closestCostHelper(toppingCosts, 0, 0, baseCosts[i], target);
        }
//        results.forEach(r -> System.out.println(r));
//        System.out.println(close);
        return close;
    }
    public static List<Integer> results = new ArrayList<>();
    public static int closestDistance = Integer.MAX_VALUE;
    public static int close = 0;
    public static void closestCostHelper(int[] toppingCosts, int toppingIndex, int toppingCount, int baseCost, int target){
        if(toppingIndex == toppingCosts.length){
            if(Math.abs(target-baseCost) < closestDistance){
                close = baseCost;
                closestDistance = Math.abs(target-baseCost);
            }
            results.add(baseCost);
            return;
        }

        closestCostHelper(toppingCosts, toppingIndex + 1, 0, baseCost , target);
        closestCostHelper(toppingCosts, toppingIndex + 1, 1, baseCost + toppingCosts[toppingIndex], target);
        closestCostHelper(toppingCosts, toppingIndex + 1, 2, baseCost + 2 * toppingCosts[toppingIndex], target);
    }

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count = 0;
        int index = 0;
        if(ruleKey.equals("type")) index = 0;
        if(ruleKey.equals("color")) index = 1;
        if(ruleKey.equals("name")) index = 2;

        for (List<String> item : items) {
            if(item.get(index).equals(ruleValue)){
                count++;
            }
        }
        return count;
    }
}
