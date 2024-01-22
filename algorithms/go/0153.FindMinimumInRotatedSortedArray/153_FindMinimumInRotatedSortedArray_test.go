package _153_FindMinimumInRotatedSortedArray

import "testing"

func TestFindMinI(t *testing.T) {
	tests := []struct {
		nums []int
		want int
	}{
		{[]int{4, 5, 6, 7, 0, 1, 2}, 0},
		{[]int{3, 4, 5, 1, 2}, 1},
		{[]int{11, 13, 15, 17}, 11},
		{[]int{1}, 1},
		{[]int{2, 1}, 1},
	}

	for _, test := range tests {
		got := findMinI(test.nums)
		if got != test.want {
			t.Errorf("findMin(%v) = %d, want %d", test.nums, got, test.want)
		}
	}
}
