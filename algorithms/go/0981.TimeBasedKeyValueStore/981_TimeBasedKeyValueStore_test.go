package _981_TimeBasedKeyValueStore

import "testing"

func TestTimeMap_Get(t *testing.T) {
	// Create a new TimeMap
	timeMap := Constructor()

	// Add some key-value pairs
	timeMap.Set("key1", "value1", 1)
	timeMap.Set("key1", "value2", 3)
	timeMap.Set("key1", "value3", 5)
	timeMap.Set("key2", "value4", 2)
	timeMap.Set("key2", "value5", 4)
	timeMap.Set("key2", "value6", 6)

	// Test cases
	tests := []struct {
		key       string
		timestamp int
		want      string
	}{
		{"key1", 0, ""},       // No entry for key1 at timestamp 0
		{"key1", 1, "value1"}, // Entry for key1 at timestamp 1
		{"key1", 2, "value1"}, // Entry for key1 at timestamp 1 (closest previous timestamp)
		{"key1", 3, "value2"}, // Entry for key1 at timestamp 3
		{"key1", 4, "value2"}, // Entry for key1 at timestamp 3 (closest previous timestamp)
		{"key1", 5, "value3"}, // Entry for key1 at timestamp 5
		{"key1", 6, "value3"}, // Entry for key1 at timestamp 5 (closest previous timestamp)
		{"key2", 1, ""},       // No entry for key2 at timestamp 1
		{"key2", 2, "value4"}, // Entry for key2 at timestamp 2
		{"key2", 3, "value4"}, // Entry for key2 at timestamp 2 (closest previous timestamp)
		{"key2", 4, "value5"}, // Entry for key2 at timestamp 4
		{"key2", 5, "value5"}, // Entry for key2 at timestamp 4 (closest previous timestamp)
		{"key2", 6, "value6"}, // Entry for key2 at timestamp 6
		{"key2", 7, "value6"}, // Entry for key2 at timestamp 6 (closest previous timestamp)
	}

	// Run the tests
	for _, test := range tests {
		got := timeMap.Get(test.key, test.timestamp)
		if got != test.want {
			t.Errorf("Get(%s, %d) = %s, want %s", test.key, test.timestamp, got, test.want)
		}
	}
}
