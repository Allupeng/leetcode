package _020_ValidParentheses

import (
	"testing"
)

func TestIsValid(t *testing.T) {
	// Test case 1: Valid parentheses
	s := "()"
	expected := true
	result := isValid(s)
	if result != expected {
		t.Errorf("Expected %t, but got %t", expected, result)
	}

	// Test case 2: Valid nested parentheses
	s = "([])"
	expected = true
	result = isValid(s)
	if result != expected {
		t.Errorf("Expected %t, but got %t", expected, result)
	}

	// Test case 3: Invalid parentheses
	s = "([)]"
	expected = false
	result = isValid(s)
	if result != expected {
		t.Errorf("Expected %t, but got %t", expected, result)
	}

	// Test case 4: Invalid nested parentheses
	s = "([)]"
	expected = false
	result = isValid(s)
	if result != expected {
		t.Errorf("Expected %t, but got %t", expected, result)
	}

	// Test case 5: Empty string
	s = ""
	expected = true
	result = isValid(s)
	if result != expected {
		t.Errorf("Expected %t, but got %t", expected, result)
	}
}
