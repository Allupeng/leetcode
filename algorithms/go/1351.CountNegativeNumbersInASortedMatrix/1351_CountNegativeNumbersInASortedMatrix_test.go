package _351_CountNegativeNumbersInASortedMatrix

import "testing"

func TestCountNegatives(t *testing.T) {
	tests := []struct {
		grid [][]int
		want int
	}{
		{
			grid: [][]int{
				{4, 3, 2, -1},
				{3, 2, 1, -1},
				{1, 1, -1, -2},
				{-1, -1, -2, -3},
			},
			want: 8,
		},
		{
			grid: [][]int{
				{3, 2},
				{1, 0},
			},
			want: 0,
		},
		{
			grid: [][]int{
				{1, -1},
				{-1, -1},
			},
			want: 3,
		},
		{
			grid: [][]int{
				{-1},
			},
			want: 1,
		},
	}

	for _, test := range tests {
		got := countNegatives(test.grid)
		if got != test.want {
			t.Errorf("countNegatives(%v) = %d, want %d", test.grid, got, test.want)
		}
	}
}
