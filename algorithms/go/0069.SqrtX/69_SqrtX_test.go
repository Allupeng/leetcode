package _69_SqrtX

import "testing"

func TestMySqrt(t *testing.T) {
	tests := []struct {
		x    int
		want int
	}{
		{4, 2},
		{8, 2},
		{16, 4},
		{25, 5},
		{36, 6},
	}

	for _, test := range tests {
		got := mySqrt(test.x)
		if got != test.want {
			t.Errorf("mySqrt(%d) = %d, want %d", test.x, got, test.want)
		}
	}
}
