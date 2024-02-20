package _003_LongestSubstringWithoutRepeatingCharacters

import (
	"testing"
)

func TestLengthOfLongestSubstring(t *testing.T) {
	// Test case 1: No repeating characters
	s := "abcde"
	expected := 5
	result := lengthOfLongestSubstring(s)
	if result != expected {
		t.Errorf("Expected %d, but got %d", expected, result)
	}

	// Test case 2: Repeating characters in the middle
	s = "abcabcbb"
	expected = 3
	result = lengthOfLongestSubstring(s)
	if result != expected {
		t.Errorf("Expected %d, but got %d", expected, result)
	}

	// Test case 3: Repeating characters at the beginning
	s = "bbbbb"
	expected = 1
	result = lengthOfLongestSubstring(s)
	if result != expected {
		t.Errorf("Expected %d, but got %d", expected, result)
	}

	// Test case 4: Repeating characters at the end
	s = "pwwkew"
	expected = 3
	result = lengthOfLongestSubstring(s)
	if result != expected {
		t.Errorf("Expected %d, but got %d", expected, result)
	}

	// Test case 5: Empty string
	s = ""
	expected = 0
	result = lengthOfLongestSubstring(s)
	if result != expected {
		t.Errorf("Expected %d, but got %d", expected, result)
	}
}
