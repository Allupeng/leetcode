package _287_FindTheDuplicateNumber

import (
	"testing"
)

func TestFindDuplicate(t *testing.T) {
	tests := []struct {
		nums []int
		want int
	}{
		{[]int{1, 3, 4, 2, 2}, 2},
		{[]int{3, 1, 3, 4, 2}, 3},
		{[]int{1, 1}, 1},
		{[]int{1, 1, 2}, 1},
		{[]int{2, 2, 2, 2, 2}, 2},
	}

	for _, test := range tests {
		got := findDuplicate(test.nums)
		if got != test.want {
			t.Errorf("findDuplicate(%v) = %d, want %d", test.nums, got, test.want)
		}
	}
}
