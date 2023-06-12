/*
 * @lc app=leetcode.cn id=150 lang=java
 *
 * [150] Evaluate Reverse Polish Notation
 *
 * https://leetcode.cn/problems/evaluate-reverse-polish-notation/description/
 *
 * algorithms
 * Medium (52.67%)
 * Likes:    745
 * Dislikes: 0
 * Total Accepted:    279.7K
 * Total Submissions: 531.1K
 * Testcase Example:  '["2","1","+","3","*"]'
 *
 * You are given an array of strings tokens that represents an arithmetic
 * expression in a Reverse Polish Notation.
 * 
 * Evaluate the expression. Return an integer that represents the value of the
 * expression.
 * 
 * Note that:
 * 
 * 
 * The valid operators are '+', '-', '*', and '/'.
 * Each operand may be an integer or another expression.
 * The division between two integers always truncates toward zero.
 * There will not be any division by zero.
 * The input represents a valid arithmetic expression in a reverse polish
 * notation.
 * The answer and all the intermediate calculations can be represented in a
 * 32-bit integer.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: tokens = ["2","1","+","3","*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: tokens = ["4","13","5","/","+"]
 * Output: 6
 * Explanation: (4 + (13 / 5)) = 6
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
 * Output: 22
 * Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= tokens.length <= 10^4
 * tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the
 * range [-200, 200].
 * 
 * 
 */

import java.util.Stack;

public class _0150_EvaluateReversePolishNotation {
// @lc code=start
    class Solution {
        public int evalRPN(String[] tokens) {
            Stack<String> stack = new Stack<>();
            for (int i = 0; i < tokens.length; i++){
                String token = tokens[i];
                // when token is operand , push token to stack
                // when token is operator, pop two elements from stack
                // first pop is second operand and second pop is first operand
                // use operator to calculate two operands,and push result to stack
                if (isAOperator(token)){
                    int secondOperand = Integer.parseInt(stack.pop());
                    int firstOperand = Integer.parseInt(stack.pop());
                    int tmpResult = calculate(firstOperand, secondOperand, token);
                    stack.push(String.valueOf(tmpResult));
                }else {
                    // push token to stack
                    stack.push(token);
                }
            }
            return Integer.parseInt(stack.pop());
        }

        private boolean isAOperator(String token){
            return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
        }

        private int calculate(int operand1, int operand2, String operator){
            switch (operator){
                case "+":
                    return operand1 + operand2;
                case "-":
                    return operand1 - operand2;
                case "*":
                    return operand1 * operand2;
                case "/":
                    return operand1 / operand2;
                default:
                    throw new IllegalArgumentException("illegal operator");
            }
        }

    }
// @lc code=end
}

