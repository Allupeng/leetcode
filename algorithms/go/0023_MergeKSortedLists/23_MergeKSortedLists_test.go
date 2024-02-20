package _023_MergeKSortedLists

import (
	"reflect"
	"testing"
)

func TestConquer(t *testing.T) {
	// Test case 1
	l1 := &ListNode{Val: 1, Next: &ListNode{Val: 4, Next: &ListNode{Val: 5}}}
	l2 := &ListNode{Val: 1, Next: &ListNode{Val: 3, Next: &ListNode{Val: 4}}}
	expected := &ListNode{Val: 1, Next: &ListNode{Val: 1, Next: &ListNode{Val: 3, Next: &ListNode{Val: 4, Next: &ListNode{Val: 4, Next: &ListNode{Val: 5}}}}}}
	result := conquer(l1, l2)
	if !reflect.DeepEqual(result, expected) {
		t.Errorf("Expected %v, but got %v", expected, result)
	}

	// Test case 2
	l1 = nil
	l2 = &ListNode{Val: 0}
	expected = &ListNode{Val: 0}
	result = conquer(l1, l2)
	if !reflect.DeepEqual(result, expected) {
		t.Errorf("Expected %v, but got %v", expected, result)
	}

	// Test case 3
	l1 = &ListNode{Val: 2}
	l2 = nil
	expected = &ListNode{Val: 2}
	result = conquer(l1, l2)
	if !reflect.DeepEqual(result, expected) {
		t.Errorf("Expected %v, but got %v", expected, result)
	}
}
