package _031_NextPermutation

import (
	"reflect"
	"testing"
)

func TestNextPermutation(t *testing.T) {
	// Test case 1
	nums := []int{1, 2, 3}
	expected := []int{1, 3, 2}
	nextPermutation(nums)
	if !reflect.DeepEqual(nums, expected) {
		t.Errorf("Expected %v, but got %v", expected, nums)
	}

	// Test case 2
	nums = []int{3, 2, 1}
	expected = []int{1, 2, 3}
	nextPermutation(nums)
	if !reflect.DeepEqual(nums, expected) {
		t.Errorf("Expected %v, but got %v", expected, nums)
	}

	// Test case 3
	nums = []int{1, 1, 5}
	expected = []int{1, 5, 1}
	nextPermutation(nums)
	if !reflect.DeepEqual(nums, expected) {
		t.Errorf("Expected %v, but got %v", expected, nums)
	}
}
