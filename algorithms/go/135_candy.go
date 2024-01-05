/*
 * @lc app=leetcode.cn id=135 lang=golang
 *
 * [135] Candy
 *
 * https://leetcode.cn/problems/candy/description/
 *
 * algorithms
 * Hard (49.46%)
 * Likes:    1427
 * Dislikes: 0
 * Total Accepted:    272.5K
 * Total Submissions: 550.9K
 * Testcase Example:  '[1,0,2]'
 *
 * There are n children standing in a line. Each child is assigned a rating
 * value given in the integer array ratings.
 *
 * You are giving candies to these children subjected to the following
 * requirements:
 *
 *
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 *
 *
 * Return the minimum number of candies you need to have to distribute the
 * candies to the children.
 *
 *
 * Example 1:
 *
 *
 * Input: ratings = [1,0,2]
 * Output: 5
 * Explanation: You can allocate to the first, second and third child with 2,
 * 1, 2 candies respectively.
 *
 *
 * Example 2:
 *
 *
 * Input: ratings = [1,2,2]
 * Output: 4
 * Explanation: You can allocate to the first, second and third child with 1,
 * 2, 1 candies respectively.
 * The third child gets 1 candy because it satisfies the above two
 * conditions.
 *
 *
 *
 * Constraints:
 *
 *
 * n == ratings.length
 * 1 <= n <= 2 * 10^4
 * 0 <= ratings[i] <= 2 * 10^4
 *
 *
 */
package leetcode

// @lc code=start
func candy(ratings []int) int {
	candys := make([]int, len(ratings))
	for i := 0; i < len(ratings); i++ {
		candys[i] = 1
	}
	// 如果右边的评分比左边的高，右边的糖果数为左边的 + 1
	for i := 1; i < len(ratings); i++ {
		if ratings[i] > ratings[i-1] {
			candys[i] = candys[i-1] + 1
		}
	}
	// 如果左边的评分比右边高，且左边的糖果数量不大于右边，那么更新为右边 + 1
	for i := len(ratings) - 1; i > 0; i-- {
		if ratings[i] < ratings[i-1] {
			candys[i-1] = max(candys[i-1], candys[i]+1)
		}
	}
	res := 0
	for _, v := range candys {
		res += v
	}
	return res
}

// @lc code=end
