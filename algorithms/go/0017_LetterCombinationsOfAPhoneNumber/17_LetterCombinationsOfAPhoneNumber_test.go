package _017_LetterCombinationsOfAPhoneNumber

import (
	"reflect"
	"testing"
)

func TestLetterCombinations(t *testing.T) {

	tests := []struct {
		digits   string
		expected []string
	}{
		{
			digits:   "23",
			expected: []string{"ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"},
		},
		{
			digits:   "79",
			expected: []string{"pw", "px", "py", "pz", "qw", "qx", "qy", "qz", "rw", "rx", "ry", "rz", "sw", "sx", "sy", "sz"},
		},
		// Add more test cases here...
	}

	for _, test := range tests {
		result := letterCombinations(test.digits)
		if !reflect.DeepEqual(result, test.expected) {
			t.Errorf("For digits %s, expected %v, but got %v", test.digits, test.expected, result)
		}
	}
}
