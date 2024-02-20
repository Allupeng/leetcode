package _004_MedianOfTwoSortedArrays

import (
	"testing"
)

func TestFindMedianSortedArrays(t *testing.T) {
	nums1 := []int{1, 3}
	nums2 := []int{2}
	expected := 2.0
	result := findMedianSortedArrays(nums1, nums2)
	if result != expected {
		t.Errorf("Expected %v, but got %v", expected, result)
	}

	nums1 = []int{1, 2}
	nums2 = []int{3, 4}
	expected = 2.5
	result = findMedianSortedArrays(nums1, nums2)
	if result != expected {
		t.Errorf("Expected %v, but got %v", expected, result)
	}

	nums1 = []int{0, 0}
	nums2 = []int{0, 0}
	expected = 0.0
	result = findMedianSortedArrays(nums1, nums2)
	if result != expected {
		t.Errorf("Expected %v, but got %v", expected, result)
	}

	nums1 = []int{}
	nums2 = []int{1}
	expected = 1.0
	result = findMedianSortedArrays(nums1, nums2)
	if result != expected {
		t.Errorf("Expected %v, but got %v", expected, result)
	}

	nums1 = []int{2}
	nums2 = []int{}
	expected = 2.0
	result = findMedianSortedArrays(nums1, nums2)
	if result != expected {
		t.Errorf("Expected %v, but got %v", expected, result)
	}
}
