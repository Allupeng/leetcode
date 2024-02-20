package _011_ContainerWithMostWater

import (
	"testing"
)

func TestMaxArea(t *testing.T) {
	height := []int{1, 8, 6, 2, 5, 4, 8, 3, 7}
	expected := 49
	result := maxArea(height)
	if result != expected {
		t.Errorf("Expected %v, but got %v", expected, result)
	}

	height = []int{1, 1}
	expected = 1
	result = maxArea(height)
	if result != expected {
		t.Errorf("Expected %v, but got %v", expected, result)
	}

	height = []int{4, 3, 2, 1, 4}
	expected = 16
	result = maxArea(height)
	if result != expected {
		t.Errorf("Expected %v, but got %v", expected, result)
	}

	height = []int{1, 2, 1}
	expected = 2
	result = maxArea(height)
	if result != expected {
		t.Errorf("Expected %v, but got %v", expected, result)
	}
}
