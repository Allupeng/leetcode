package _035_SearchInsertPosition

import "testing"

func TestSearchInsert(t *testing.T) {
	tests := []struct {
		nums   []int
		target int
		want   int
	}{
		{[]int{1, 3, 5, 6}, 5, 2},
		{[]int{1, 3, 5, 6}, 2, 1},
		{[]int{1, 3, 5, 6}, 7, 4},
		{[]int{1, 3, 5, 6}, 0, 0},
		{[]int{1}, 0, 0},
		{[]int{1}, 1, 0},
	}

	for _, test := range tests {
		got := searchInsert(test.nums, test.target)
		if got != test.want {
			t.Errorf("searchInsert(%v, %d) = %d, want %d", test.nums, test.target, got, test.want)
		}
	}
}
