package hackerearth.codearena;

import java.util.ArrayList;
import java.util.List;

class TestClass {
    public static void main(String args[]) throws Exception {

        System.out.println(mergeTwoSortedArrays(new int[]{1,2}, new int[]{3,4}));
    }

    public static double mergeTwoSortedArrays(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        List<Integer> mergedList = new ArrayList<>();

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                mergedList.add(nums1[i]);
                i++;
            } else {
                mergedList.add(nums2[j]);
                j++;
            }
            if(mergedList.size() == (nums1.length + nums2.length) / 2){
                System.out.println("Median "+mergedList.get(mergedList.size()-1));
            }
        }
        while(i < nums1.length){
            mergedList.add(nums1[i]);
            i++;
        }
        while(j < nums2.length){
            mergedList.add(nums2[j]);
            j++;
        }
        int mid = mergedList.size()/2 - 1;
        if(mergedList.size() % 2 == 0){
            return (mergedList.get(mid) + mergedList.get(mid + 1)) / 2.0;
        }else{
            return mergedList.get(mid);
        }
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        while (true) {

        }
    }

    public static void subStrings(String str, String pre) {
        if (str.length() == 0) {
            System.out.println(pre);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            String rem = str.substring(0, i) + str.substring(i + 1);
            subStrings(rem, pre + str.charAt(i));
        }
    }
}
