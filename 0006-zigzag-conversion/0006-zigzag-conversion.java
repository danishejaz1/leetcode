class Solution {
    public String convert(String s, int numRows) {
        // Edge cases
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }
        
        // Create a list to store characters for each row
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }
        
        int currentRow = 0;
        boolean goingDown = false;
        
        // Traverse the string and place characters in appropriate rows
        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);
            
            // Change direction at the first or last row
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }
            
            // Move to next row
            currentRow += goingDown ? 1 : -1;
        }
        
        // Combine all rows
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }
        
        return result.toString();
    }
}