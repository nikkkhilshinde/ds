package leetcode.arrays;

import java.lang.reflect.Array;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
//        int[] a = searchRange(new int[]{1}, 1);
//        System.out.println(String.format("[%d, %d]", a[0], a[1]));
//        System.out.println(findMedianSortedArrays(new int[]{}, new int[]{}));
//        System.out.println(threeSumClosest(new int[]{1, 1, 1, 0}, -100));

        int[] arr = new int[]{3,2,3,1,2,4,5,5,6};
        List<Integer>  list = new ArrayList<>();
        Set<String> set = new TreeSet<>();
        System.out.println(findKthLargest(arr, 4));
    }
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        helpergenerate("",0,0,n,list);
        return list;
    }

    public void helpergenerate(String output, int open, int close, int max, List<String> result){
        if(open + close == 2 * max){
            result.add(output);
            return;
        }

        if(open < max){
            helpergenerate(output + "(" , open + 1, close, max, result);
        }
        if(close < open){
            helpergenerate(output + ")", open , close + 1, max, result);
        }
    }
    public static int findKthLargest(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        Collections.sort(list);
        return list.get(nums.length - k);
    }


    public int removeElement(int[] nums, int val) {
        int first = 0;
        int second = 0;
        while (second < nums.length) {
            if (nums[first] != val && nums[second] != val) {
                nums[first] = nums[second];
                first++;
                second++;
            }
            if (nums[first] == val) {
                nums[first] = nums[second];
                first++;
            } else {
                second++;
            }
        }
        return first + 1;
    }

    public int removeDuplicates(int[] nums) {
        int first = 0;
        int last = 1;
        while (first < nums.length || last < nums.length) {
            if (nums[first] == nums[last]) {
                last++;
            } else {
                first++;
                nums[first] = nums[last];
                last++;
            }
        }
        return first;
    }

    public static int threeSumClosest(int[] nums, int target) {

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (frequencyMap.containsKey(nums[i])) {
                frequencyMap.put(nums[i], frequencyMap.get(nums[i]) + 1);
            } else {
                frequencyMap.put(nums[i], 1);
            }
        }
        int sum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int temp = nums[i] + nums[j];
                int rem = target - temp;
                for (int k = 0; k <= Math.abs(target - sum); k++) {
                    if (rem - k == nums[i] && rem - k == nums[j]) {
                        if (frequencyMap.containsKey(rem - k) && frequencyMap.get(rem - k) > 2) {
                            sum = temp + rem - k;
                            break;
                        }
                    } else if (rem - k == nums[i]) {
                        if (frequencyMap.containsKey(rem - k) && frequencyMap.get(rem - k) > 1) {
                            sum = temp + rem - k;
                            break;
                        }
                    } else if (rem - k == nums[j]) {
                        if (frequencyMap.containsKey(rem - k) && frequencyMap.get(rem - k) > 1) {
                            sum = temp + rem - k;
                            break;
                        }
                    } else {
                        if (frequencyMap.containsKey(rem - k)) {
                            sum = temp + rem - k;
                        }
                    }
                }
            }
        }
        return sum;
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == nums2.length && nums1.length == 0) {
            return 0.0;
        }
        int p1 = 0;
        int p2 = 0;
        List<Integer> mergedList = new ArrayList<>();
        int length = nums1.length + nums2.length;

        while (p1 != nums1.length && p2 != nums2.length) {
            if (nums1[p1] == nums2[p2]) {
                mergedList.add(nums1[p1]);
                mergedList.add(nums2[p2]);
                p1++;
                p2++;
            } else {
                if (nums1[p1] < nums2[p2]) {
                    mergedList.add(nums1[p1]);
                    p1++;
                } else {
                    mergedList.add(nums2[p2]);
                    p2++;
                }
            }

        }
        while (p1 != nums1.length) {
            mergedList.add(nums1[p1]);
            p1++;
        }
        while (p2 != nums2.length) {
            mergedList.add(nums2[p2]);
            p2++;
        }
        if (length % 2 == 0) {
            return (double) (mergedList.get((length / 2) - 1) + mergedList.get((length / 2))) / 2;
        } else {
            return (double) mergedList.get(length / 2);
        }
    }

    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};
        return searchRangeWrapper(nums, target, 0, nums.length - 1);
    }

    public static int[] searchRangeWrapper(int[] nums, int target, int low, int high) {
        if (low <= high) {
            int mid = (high + low) / 2;
            if (nums[mid] == target) {
                int midTemp = mid;
                while (midTemp >= 0) {
                    if (nums[midTemp] == target) {
                        midTemp--;
                    } else {
                        break;
                    }
                }
                int lowerBound = midTemp;
                midTemp = mid;
                while (midTemp < high) {
                    if (nums[midTemp] == target) {
                        midTemp++;
                    } else {
                        break;
                    }
                }
                int upperBound = midTemp;
                if (lowerBound == upperBound && lowerBound >= 0) return new int[]{lowerBound, upperBound};
                return new int[]{lowerBound + 1, upperBound - 1};
            } else {
                if (target < nums[mid]) {
                    return searchRangeWrapper(nums, target, low, mid);
                } else {
                    return searchRangeWrapper(nums, target, mid + 1, high);
                }
            }
        }
        return new int[]{-1, -1};
    }

    public int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) return i;
        }
        return -1;
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Set<String> strings = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                Set<Integer> set = new HashSet<>();
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = -(nums[i] + nums[j] + nums[k]);
                    if (set.contains(sum)) {
                        List<Integer> quadruple = new ArrayList<>();
                        quadruple.add(nums[i]);
                        quadruple.add(nums[j]);
                        quadruple.add(nums[k]);
                        quadruple.add(sum);
                        Collections.sort(quadruple);
                        StringBuilder stringBuilder = new StringBuilder();
                        quadruple.forEach(q -> stringBuilder.append(q + ":"));
                        if (!strings.contains(stringBuilder.toString())) {
                            System.out.println(String.format("[%d, %d, %d, %d]", nums[i], nums[j], nums[k], sum));
                            strings.add(stringBuilder.toString());
                        }
                    } else {
                        set.add(sum);
                    }
                }
            }
        }
        return null;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Set<String> strings = new HashSet<>();
        List<List<Integer>> triplets = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            Set<Integer> integers = new HashSet<>();

            for (int j = i + 1; j < nums.length; j++) {
                int rem = -(nums[i] + nums[j]);
                if (integers.contains(rem)) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[j]);
                    triplet.add(rem);
                    Collections.sort(triplet);
                    StringBuilder stringBuilder = new StringBuilder();
                    triplet.forEach(t -> {
                        stringBuilder.append(t + ":");
                    });
                    if (!strings.contains(stringBuilder.toString())) {
                        strings.add(stringBuilder.toString());
                        triplets.add(triplet);
//                        System.out.println(String.format("[%d, %d, %d]", nums[i], nums[j], -rem));

                    }
                } else {
                    integers.add(nums[j]);
                }
            }
        }

        return triplets;
    }

    private static void addTriplet(Set<String> tripStrings, List<List<Integer>> triplets, int num, int num1, int sum) {
        ArrayList<Integer> triplet = new ArrayList<>();
        triplet.add(num);
        triplet.add(num1);
        triplet.add(-sum);
        Collections.sort(triplet);
        StringBuilder stringBuilder = new StringBuilder();
        triplet.forEach(t -> {
            stringBuilder.append(t + ":");
        });
        if (!tripStrings.contains(stringBuilder.toString())) {
            triplets.add(triplet);
            tripStrings.add(stringBuilder.toString());
        }
    }


    public int maxArea(int[] height) {
        int low = 0;
        int high = height.length - 1;
        int max = Integer.MIN_VALUE;
        while (low < high) {
            if (max < (high - low) * (Math.min(height[low], height[high]))) {
                max = (high - low) * (Math.min(height[low], height[high]));
            }
            if (height[low] < height[high]) {
                low++;
            } else {
                high++;
            }
        }
        return max;
    }
}
