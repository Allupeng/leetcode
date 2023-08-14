package leetcode

import (
	"reflect"
	"testing"
)

func TestTwoSum(t *testing.T) {
	// Test case 1: Valid input
	nums1 := []int{2, 7, 11, 15}
	target1 := 9
	expected1 := []int{0, 1}
	result1 := twoSum(nums1, target1)
	if !reflect.DeepEqual(result1, expected1) {
		t.Errorf("Expected %v but got %v", expected1, result1)
	}

	// Test case 2: No solution
	nums2 := []int{2, 7, 11, 15}
	target2 := 3
	expected2 := []int{-1, -1}
	result2 := twoSum(nums2, target2)
	if !reflect.DeepEqual(result2, expected2) {
		t.Errorf("Expected %v but got %v", expected2, result2)
	}

	// Test case 3: Empty input
	nums3 := []int{}
	target3 := 5
	expected3 := []int{-1, -1}
	result3 := twoSum(nums3, target3)
	if !reflect.DeepEqual(result3, expected3) {
		t.Errorf("Expected %v but got %v", expected3, result3)
	}

	// Test case 4: Single element input
	nums4 := []int{5}
	target4 := 5
	expected4 := []int{-1, -1}
	result4 := twoSum(nums4, target4)
	if !reflect.DeepEqual(result4, expected4) {
		t.Errorf("Expected %v but got %v", expected4, result4)
	}

	// Test case 5: Multiple solutions
	nums5 := []int{3, 2, 4}
	target5 := 6
	expected5 := []int{1, 2}
	result5 := twoSum(nums5, target5)
	if !reflect.DeepEqual(result5, expected5) {
		t.Errorf("Expected %v but got %v", expected5, result5)
	}
}
