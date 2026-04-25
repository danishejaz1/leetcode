class Solution {
    public int lengthOfLongestSubstring(String s) {
        // HashMap to store character and its most recent index
        HashMap<Character, Integer> map = new HashMap<>();
        
        int maxLength = 0;
        int left = 0;  // Left pointer of the sliding window
        
        // Right pointer traverses the string
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            
            // If character is already in the window, move left pointer
            if (map.containsKey(currentChar)) {
                // Move left to the right of the last occurrence
                // Use Math.max to ensure left only moves forward
                left = Math.max(left, map.get(currentChar) + 1);
            }
            
            // Update the character's latest index
            map.put(currentChar, right);
            
            // Calculate max length
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}