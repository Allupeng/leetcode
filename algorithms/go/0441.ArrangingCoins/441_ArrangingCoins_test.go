package _441_ArrangingCoins

import "testing"

func TestArrangeCoins(t *testing.T) {
	tests := []struct {
		n      int
		expect int
	}{
		{5, 2},
		{8, 3},
		{10, 4},
		{0, 0},
		{1, 1},
	}

	for _, test := range tests {
		got := arrangeCoins(test.n)
		if got != test.expect {
			t.Errorf("arrangeCoins(%d) = %d, want %d", test.n, got, test.expect)
		}
	}
}
