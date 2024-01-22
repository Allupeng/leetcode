package _033_SearchInRotatedSortedArray

import "testing"

func TestSearch(t *testing.T) {
	tests := []struct {
		nums   []int
		target int
		want   int
	}{
		{[]int{4, 5, 6, 7, 0, 1, 2}, 0, 4},
		{[]int{4, 5, 6, 7, 0, 1, 2}, 3, -1},
		{[]int{1}, 0, -1},
		{[]int{1, 3}, 3, 1},
		{[]int{3, 1}, 1, 1},
	}

	for _, test := range tests {
		got := search(test.nums, test.target)
		if got != test.want {
			t.Errorf("search(%v, %d) = %d, want %d", test.nums, test.target, got, test.want)
		}
	}
}
