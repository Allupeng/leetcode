package _704_BinarySearch

import "testing"

func TestBinarySearch(t *testing.T) {
	tests := []struct {
		nums   []int
		target int
		want   int
	}{
		{[]int{-1, 0, 3, 5, 9, 12}, 9, 4},
		{[]int{-1, 0, 3, 5, 9, 12}, 2, -1},
		{[]int{1, 3, 5, 7, 9}, 7, 3},
		{[]int{2, 4, 6, 8, 10}, 5, -1},
	}

	for _, test := range tests {
		got := search(test.nums, test.target)
		if got != test.want {
			t.Errorf("search(%v, %d) = %d, want %d", test.nums, test.target, got, test.want)
		}
	}

	for _, test := range tests {
		got := basicBinarySearch(test.nums, test.target)
		if got != test.want {
			t.Errorf("search(%v, %d) = %d, want %d", test.nums, test.target, got, test.want)
		}
	}

	for _, test := range tests {
		got := roundDownBinarySearch(test.nums, test.target)
		if got != test.want {
			t.Errorf("search(%v, %d) = %d, want %d", test.nums, test.target, got, test.want)
		}
	}

	for _, test := range tests {
		got := roundUpBinarySearch(test.nums, test.target)
		if got != test.want {
			t.Errorf("search(%v, %d) = %d, want %d", test.nums, test.target, got, test.want)
		}
	}

	for _, test := range tests {
		got := roundDownBinarySearchWithoutComparison(test.nums, test.target)
		if got != test.want {
			t.Errorf("search(%v, %d) = %d, want %d", test.nums, test.target, got, test.want)
		}
	}

	for _, test := range tests {
		got := roundUpBinarySearchWithoutComparison(test.nums, test.target)
		if got != test.want {
			t.Errorf("search(%v, %d) = %d, want %d", test.nums, test.target, got, test.want)
		}
	}
}
