package _074_SearchA2DMatrix

import "testing"

func TestSearchMatrix(t *testing.T) {
	matrix := [][]int{
		{1, 3, 5, 7},
		{10, 11, 16, 20},
		{23, 30, 34, 60},
	}

	tests := []struct {
		target int
		want   bool
	}{
		{3, true},
		{13, false},
		{23, true},
		{60, true},
		{0, false},
		{100, false},
	}

	for _, test := range tests {
		got := searchMatrix(matrix, test.target)
		if got != test.want {
			t.Errorf("searchMatrix(matrix, %d) = %t, want %t", test.target, got, test.want)
		}
	}
}
