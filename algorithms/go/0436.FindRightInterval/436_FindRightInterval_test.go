package _436_FindRightInterval

import (
	"reflect"
	"testing"
)

func TestFindRightInterval(t *testing.T) {
	tests := []struct {
		intervals [][]int
		want      []int
	}{
		{
			intervals: [][]int{{1, 2}},
			want:      []int{-1},
		},
		{
			intervals: [][]int{{3, 4}, {2, 3}, {1, 2}},
			want:      []int{-1, 0, 1},
		},
		{
			intervals: [][]int{{1, 4}, {2, 3}, {3, 4}},
			want:      []int{-1, 2, -1},
		},
		// Add more test cases here...
	}

	for _, test := range tests {
		got := findRightInterval(test.intervals)
		if !reflect.DeepEqual(got, test.want) {
			t.Errorf("findRightInterval(%v) = %v, want %v", test.intervals, got, test.want)
		}
	}
}
