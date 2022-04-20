/**
description:
	You are given an integer array height of length n.
	There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
	Find two lines that together with the x-axis form a container, such that the container contains the most water.
	Return the maximum amount of water a container can store.
	Notice that you may not slant the container.
**/
//package src

func maxArea(height []int) int {
	left, right := 0, len(height)-1
	result := -1
	for left < right {
		matrix_len := right - left
		width := min(height[left], height[right])
		area := matrix_len * width
		result = max(result, area)
		if height[left] <= height[right] {
			left++
		} else {
			right--
		}
	}
	return result
}

func max(a int, b int) int {
	if a < b {
		return b
	} else {
		return a
	}
}

func min(a int, b int) int {
	if a < b {
		return a
	} else {
		return b
	}
}