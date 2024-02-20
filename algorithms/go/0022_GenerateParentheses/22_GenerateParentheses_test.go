package _022_GenerateParentheses

import (
	"reflect"
	"testing"
)

func TestGenerateParentheses(t *testing.T) {
	tests := []struct {
		n        int
		expected []string
	}{
		{
			n:        1,
			expected: []string{"()"},
		},
		{
			n:        2,
			expected: []string{"(())", "()()"},
		},
		{
			n:        3,
			expected: []string{"((()))", "(()())", "(())()", "()(())", "()()()"},
		},
		// Add more test cases here...
	}

	for _, test := range tests {
		var result []string
		backtrace(test.n, 0, 0, "", &result)
		if !reflect.DeepEqual(result, test.expected) {
			t.Errorf("For n=%d, expected %v, but got %v", test.n, test.expected, result)
		}
	}
}
