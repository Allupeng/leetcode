package _744_FindSmallestLetterGreaterThanTarget

import "testing"

func TestNextGreatestLetter(t *testing.T) {
	tests := []struct {
		letters []byte
		target  byte
		want    byte
	}{
		{[]byte{'a', 'b', 'c'}, 'a', 'b'},
		{[]byte{'a', 'b', 'c'}, 'b', 'c'},
		{[]byte{'a', 'b', 'c'}, 'c', 'a'},
		{[]byte{'a', 'b', 'c'}, 'd', 'a'},
		{[]byte{'a', 'b', 'c', 'd', 'e'}, 'e', 'a'},
		{[]byte{'a', 'b', 'c', 'd', 'e'}, 'f', 'a'},
	}

	for _, test := range tests {
		got := nextGreatestLetter(test.letters, test.target)
		if got != test.want {
			t.Errorf("nextGreatestLetter(%v, %c) = %c, want %c", test.letters, test.target, got, test.want)
		}
	}
}
