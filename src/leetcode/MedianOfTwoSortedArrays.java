package leetcode;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] first = new int[] {2,3,4,6,7,8};
        int[] second = new int[] {1,5};
        MedianOfTwoSortedArrays temp = new MedianOfTwoSortedArrays();
        double res = temp.findMedianSortedArrays(first, second);
        System.out.println(res);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (((m + n) % 2) == 0) {
            return (help((m+n)/2+1, nums1, 0, m-1, nums2, 0, n-1) + help((m+n)/2, nums1, 0, m-1, nums2, 0, n-1)) / ((double) 2);
        } else {
            return (double) help((m+n)/2 + 1, nums1, 0, m-1, nums2, 0, n-1);
        }
    }

    public int help(int k, int[] nums1, int start1, int end1, int[] nums2, int start2, int end2) {
        int m = end1 - start1 + 1;
        int n = end2 - start2 + 1;
        System.out.println("k: " + k);
        System.out.println("start1: " + start1);
        System.out.println("end1: " + end1);
        System.out.println("start2: " + start2);
        System.out.println("end2: " + end2);

        if(m > n) {
            return help(k, nums2, start2, end2, nums1, start1, end1);
        }
        if(m == 0) {
            return nums2[start2 + k - 1];
        }
        if(k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        int mPos = Math.min(k/2, m);
        int nPos = k - mPos;
        if (nums1[start1 + mPos -1] < nums2[start2 + nPos -1]) {
            return help(k-mPos, nums1, start1 + mPos, end1, nums2, start2, end2);
        }else if(nums1[start1 + mPos -1] > nums2[start2 + nPos -1]) {
            return help(k-nPos, nums1, start1, end1, nums2, start2 + nPos, end2);
        } else {
            return nums1[start1 + mPos -1];
        }
    }
}
