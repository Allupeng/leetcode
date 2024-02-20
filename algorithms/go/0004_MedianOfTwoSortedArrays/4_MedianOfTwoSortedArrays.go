package _004_MedianOfTwoSortedArrays

/*
 * @lc app=leetcode.cn id=4 lang=golang
 *
 * [4] Median of Two Sorted Arrays
 *
 * https://leetcode.cn/problems/median-of-two-sorted-arrays/description/
 *
 * algorithms
 * Hard (41.96%)
 * Likes:    7010
 * Dislikes: 0
 * Total Accepted:    1.1M
 * Total Submissions: 2.5M
 * Testcase Example:  '[1,3]\n[2]'
 *
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return
 * the median of the two sorted arrays.
 *
 * The overall run time complexity should be O(log (m+n)).
 *
 *
 * Example 1:
 *
 *
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 *
 *
 * Example 2:
 *
 *
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 *
 *
 *
 * Constraints:
 *
 *
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -10^6 <= nums1[i], nums2[i] <= 10^6
 *
 *
 */

// @lc code=start
func findMedianSortedArrays(nums1 []int, nums2 []int) float64 {
	m, n := len(nums1), len(nums2)
	if m == 0 && n == 0 {
		return 0.0
	}
	combined := make([]int, m+n)
	i, j, k := 0, 0, 0
	for i < m && j < n {
		if nums1[i] <= nums2[j] {
			combined[k] = nums1[i]
			k++
			i++
		} else {
			combined[k] = nums2[j]
			k++
			j++
		}
	}
	for i < m {
		combined[k] = nums1[i]
		k++
		i++
	}
	for j < n {
		combined[k] = nums2[j]
		k++
		j++
	}
	mid := len(combined) / 2
	if len(combined)%2 == 0 {
		return float64(combined[mid]+combined[mid-1]) / 2.0
	} else {
		return float64(combined[mid])
	}
}

// @lc code=end
