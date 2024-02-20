package _033_SearchInRotatedSortedArray

import "testing"

func TestSearch(t *testing.T) {
	// Test case 1
	nums := []int{4, 5, 6, 7, 0, 1, 2}
	target := 0
	expected := 4
	result := search(nums, target)
	if result != expected {
		t.Errorf("Expected %d, but got %d", expected, result)
	}

	// Test case 2
	nums = []int{4, 5, 6, 7, 0, 1, 2}
	target = 3
	expected = -1
	result = search(nums, target)
	if result != expected {
		t.Errorf("Expected %d, but got %d", expected, result)
	}

	// Test case 3
	nums = []int{1}
	target = 0
	expected = -1
	result = search(nums, target)
	if result != expected {
		t.Errorf("Expected %d, but got %d", expected, result)
	}
}
