package _015_3Sum

import (
	"reflect"
	"testing"
)

func TestThreeSum(t *testing.T) {
	nums := []int{-1, 0, 1, 2, -1, -4}
	expected := [][]int{{-1, -1, 2}, {-1, 0, 1}}
	result := threeSum(nums)
	if !reflect.DeepEqual(result, expected) {
		t.Errorf("Expected %v, but got %v", expected, result)
	}

	nums = []int{}
	expected = [][]int{}
	result = threeSum(nums)
	if !reflect.DeepEqual(result, expected) {
		t.Errorf("Expected %v, but got %v", expected, result)
	}

	nums = []int{0}
	expected = [][]int{}
	result = threeSum(nums)
	if !reflect.DeepEqual(result, expected) {
		t.Errorf("Expected %v, but got %v", expected, result)
	}

	nums = []int{0, 0, 0}
	expected = [][]int{{0, 0, 0}}
	result = threeSum(nums)
	if !reflect.DeepEqual(result, expected) {
		t.Errorf("Expected %v, but got %v", expected, result)
	}

	nums = []int{-2, 0, 1, 1, 2}
	expected = [][]int{{-2, 0, 2}, {-2, 1, 1}}
	result = threeSum(nums)
	if !reflect.DeepEqual(result, expected) {
		t.Errorf("Expected %v, but got %v", expected, result)
	}
}
