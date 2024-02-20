package _005_LongestPalindromicSubstring

import (
	"testing"
)

func TestLongestPalindrome(t *testing.T) {
	// Test case 1: Palindrome in the middle
	input := "babad"
	expected1 := "bab"
	expected2 := "aba"
	result := longestPalindrome(input)
	if result != expected1 && result != expected2 {
		if result != expected1 {
			t.Errorf("Expected %s, but got %s", expected1, result)
		} else {
			t.Errorf("Expected %s, but got %s", expected2, result)
		}
	}

	// Test case 2: Palindrome at the beginning
	input = "cbbd"
	expected := "bb"
	result = longestPalindrome(input)
	if result != expected {
		t.Errorf("Expected %s, but got %s", expected, result)
	}

	// Test case 3: Palindrome at the end
	input = "racecar"
	expected = "racecar"
	result = longestPalindrome(input)
	if result != expected {
		t.Errorf("Expected %s, but got %s", expected, result)
	}

	// Test case 4: Single character input
	input = "a"
	expected = "a"
	result = longestPalindrome(input)
	if result != expected {
		t.Errorf("Expected %s, but got %s", expected, result)
	}

	// Test case 5: Empty input
	input = ""
	expected = ""
	result = longestPalindrome(input)
	if result != expected {
		t.Errorf("Expected %s, but got %s", expected, result)
	}
}
