package _034_FindFirstAndLastPositionOfElementInSortedArray

import (
	"testing"
)

func TestFindPositionOfElementsIndex(t *testing.T) {
	tests := []struct {
		nums      []int
		target    int
		findFirst bool
		wantIndex int
	}{
		{[]int{1, 2, 3, 4, 5}, 3, true, 2},
		{[]int{1, 2, 3, 4, 5}, 3, false, 2},
		{[]int{1, 2, 3, 4, 5}, 6, true, -1},
		{[]int{1, 2, 3, 4, 5}, 6, false, -1},
		{[]int{1, 2, 3, 3, 3, 4, 5}, 3, true, 2},
		{[]int{1, 2, 3, 3, 3, 4, 5}, 3, false, 4},
	}

	for _, test := range tests {
		gotIndex := findPositionOfElementsIndex(test.nums, test.target, test.findFirst)
		if gotIndex != test.wantIndex {
			t.Errorf("findPositionOfElementsIndex(%v, %d, %t) = %d, want %d", test.nums, test.target, test.findFirst, gotIndex, test.wantIndex)
		}
	}
}
