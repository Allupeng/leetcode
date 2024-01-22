package _367_ValidPerfectSquare

import "testing"

func TestIsPerfectSquare(t *testing.T) {
	tests := []struct {
		num  int
		want bool
	}{
		{16, true},
		{25, true},
		{9, true},
		{10, false},
		{14, false},
	}

	for _, test := range tests {
		got := isPerfectSquare(test.num)
		if got != test.want {
			t.Errorf("isPerfectSquare(%d) = %t, want %t", test.num, got, test.want)
		}
	}
}
