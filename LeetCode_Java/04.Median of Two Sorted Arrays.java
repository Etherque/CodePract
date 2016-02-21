/* There are two sorted arrays nums1 and nums2 of size m and n respectively. 
Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
*/

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;

        if((m + n) % 2 != 0) {
            return findKth(nums1, 0, m - 1, nums2, 0, n - 1, (m + n)/2 + 1);
        } 
        else {
            double x = findKth(nums1, 0, m - 1, nums2, 0, n - 1, (m + n)/2);
            double y = findKth(nums1, 0, m - 1, nums2, 0, n - 1, (m + n)/2 + 1);
            return (x + y)/2.0;
        }
    }
    
    public double findKth(int[] A, int Astart, int Aend, int[] B, int Bstart, int Bend, int k) {
        int Alen = Aend - Astart + 1;
        int Blen = Bend - Bstart + 1;
        if(Alen > Blen) return findKth(B, Bstart, Bend, A, Astart, Aend, k);
        
        if(Alen == 0) return B[Bstart + k - 1];
        if(k == 1) return Math.min(A[Astart], B[Bstart]);
        
        int partA = Math.min(k/2, Alen);
        int partB = k - partA;
        
        if(A[Astart + partA - 1] < B[Bstart + partB - 1]) return findKth(A, Astart + partA, Aend, B, Bstart, Bend, k - partA);
        else if(A[Astart + partA - 1] > B[Bstart + partB - 1]) return findKth(A, Astart, Aend, B, Bstart + partB, Bend, k - partB);
        else return A[Astart + partA - 1];
    }
}

