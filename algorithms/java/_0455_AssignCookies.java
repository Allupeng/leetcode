/*
 * @lc app=leetcode.cn id=455 lang=java
 *
 * [455] Assign Cookies
 *
 * https://leetcode.cn/problems/assign-cookies/description/
 *
 * algorithms
 * Easy (56.39%)
 * Likes:    734
 * Dislikes: 0
 * Total Accepted:    327.9K
 * Total Submissions: 581.4K
 * Testcase Example:  '[1,2,3]\n[1,1]'
 *
 * Assume you are an awesome parent and want to give your children some
 * cookies. But, you should give each child at most one cookie.
 * 
 * Each child i has a greed factor g[i], which is the minimum size of a cookie
 * that the child will be content with; and each cookie j has a size s[j]. If
 * s[j] >= g[i], we can assign the cookie j to the child i, and the child i
 * will be content. Your goal is to maximize the number of your content
 * children and output the maximum number.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: g = [1,2,3], s = [1,1]
 * Output: 1
 * Explanation: You have 3 children and 2 cookies. The greed factors of 3
 * children are 1, 2, 3. 
 * And even though you have 2 cookies, since their size is both 1, you could
 * only make the child whose greed factor is 1 content.
 * You need to output 1.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: g = [1,2], s = [1,2,3]
 * Output: 2
 * Explanation: You have 2 children and 3 cookies. The greed factors of 2
 * children are 1, 2. 
 * You have 3 cookies and their sizes are big enough to gratify all of the
 * children, 
 * You need to output 2.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= g.length <= 3 * 10^4
 * 0 <= s.length <= 3 * 10^4
 * 1 <= g[i], s[j] <= 2^31 - 1
 * 
 * 
 */

import java.util.Arrays;

public class _0455_AssignCookies {
// @lc code=start
    class Solution {
        public int findContentChildren(int[] g, int[] s) {
            if (s.length == 0 || g.length == 0){
                return 0;
            }
            // 贪心策略, 最大的饼干给需求最大的孩子
            // g孩子 s饼干
            Arrays.sort(g);
            Arrays.sort(s);
            int result = 0;
            int sIndex = s.length - 1;
            for (int i = g.length - 1; i >= 0; i--){
                if (sIndex >= 0 && s[sIndex] >= g[i]){
                    result++;
                    sIndex--;
                }
            }
            return result;
        }
    }
// @lc code=end
}

