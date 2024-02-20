package _035_SearchInsertPosition

import (
	"testing"
)

func TestSearchInsert(t *testing.T) {
	// Test case 1: Target exists in the middle
	nums := []int{1, 3, 5, 6}
	target := 5
	expected := 2
	result := searchInsert(nums, target)
	if result != expected {
		t.Errorf("Expected %d, but got %d", expected, result)
	}

	// Test case 2: Target exists at the beginning
	nums = []int{1, 3, 5, 6}
	target = 1
	expected = 0
	result = searchInsert(nums, target)
	if result != expected {
		t.Errorf("Expected %d, but got %d", expected, result)
	}

	// Test case 3: Target exists at the end
	nums = []int{1, 3, 5, 6}
	target = 6
	expected = 3
	result = searchInsert(nums, target)
	if result != expected {
		t.Errorf("Expected %d, but got %d", expected, result)
	}

	// Test case 4: Target does not exist, should be inserted in the middle
	nums = []int{1, 3, 5, 6}
	target = 4
	expected = 2
	result = searchInsert(nums, target)
	if result != expected {
		t.Errorf("Expected %d, but got %d", expected, result)
	}

	// Test case 5: Target does not exist, should be inserted at the beginning
	nums = []int{1, 3, 5, 6}
	target = 0
	expected = 0
	result = searchInsert(nums, target)
	if result != expected {
		t.Errorf("Expected %d, but got %d", expected, result)
	}

	// Test case 6: Target does not exist, should be inserted at the end
	nums = []int{1, 3, 5, 6}
	target = 7
	expected = 4
	result = searchInsert(nums, target)
	if result != expected {
		t.Errorf("Expected %d, but got %d", expected, result)
	}
}
