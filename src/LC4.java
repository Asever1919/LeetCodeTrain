import java.util.ArrayList;

public class LC4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int left = (m + n + 1) / 2;
        int right = (m + n + 2) / 2;
        return (findKth(nums1, 0, nums2, 0, left) + findKth(nums1, 0, nums2, 0, right)) / 2.0;
    }
    // 定义一个函数来在两个有序数组中找到第K个元素
    public int findKth(int[] nums1, int i, int[] nums2, int j, int k) {
        // 为了避免产生新的数组从而增加时间复杂度，我们使用两个变量i和j分别来标记数组nums1和nums2的起始位置
        // 处理一些边界问题，比如当某一个数组的起始位置大于等于其数组长度时，说明其所有数字均已经被淘汰了，相当于一个空数组
        // 实际上就变成了在另一个数组中找数字，直接就可以找出来了
        if (i >= nums1.length) return nums2[j + k - 1]; // 如果为空数组，则直接返回。
        if (j >= nums2.length) return nums1[i + k - 1]; // 如果为空数组，则直接返回。
        // 如果K=1的话，那么我们只要比较nums1和nums2的起始位置i和j上的数字就可以了
        if (k == 1) return Math.min(nums1[i], nums2[j]);
        // 一般情况：
        // 加快搜索的速度，我们要使用二分法，对K二分，意思是我们需要分别在nums1和nums2中查找第K/2个元素，注意这里由于两个数组的长度不定，
        // 所以有可能某个数组没有第K/2个数字，所以我们需要先检查一下，数组中到底存不存在第K/2个数字，如果存在就取出来，否则就赋值上一个整型最大值
        // 如果某个数组没有第K/2个数字，那么我们就淘汰另一个数字的前K/2个数字即可
        int midVal1 = (i + k / 2 - 1 < nums1.length) ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
        int midVal2 = (j + k / 2 - 1 < nums2.length) ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;
        // 比较这两个数组的第K/2小的数字midVal1和midVal2的大小，如果第一个数组的第K/2个数字小的话，
        // 那么说明我们要找的数字肯定不在nums1中的前K/2个数字，所以我们可以将其淘汰，
        // 将nums1的起始位置向后移动K/2个，并且此时的K也自减去K/2，调用递归。
        if (midVal1 < midVal2) {
            return findKth(nums1, i + k / 2, nums2, j, k - k / 2);
        } else {
            // 反之，我们淘汰nums2中的前K/2个数字，并将nums2的起始位置向后移动K/2个，并且此时的K也自减去K/2，调用递归即可。
            return findKth(nums1, i, nums2, j + k / 2, k - k / 2);
        }
    }
}
