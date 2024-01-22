package _154_FindMinimumInRotatedSortedArrayIi

import "testing"

func TestFindMin(t *testing.T) {
	tests := []struct {
		nums []int
		want int
	}{
		{[]int{4, 4, 6, 7, 0, 1, 2}, 0},
		{[]int{2, 2, 3, 4, 5}, 2},
		{[]int{2, 2, 2, 0, 1}, 0},
		{[]int{3, 4, 5, 1, 2}, 1},
	}

	for _, test := range tests {
		got := findMin(test.nums)
		if got != test.want {
			t.Errorf("findMin(%v) = %d, want %d", test.nums, got, test.want)
		}
	}
}
