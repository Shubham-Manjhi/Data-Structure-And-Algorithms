<!DOCTYPE html>
<html>
<head>
    <style>
        .bordered-page {
            width: 210mm; /* A4 width */
            height: 297mm; /* A4 height */
            border: 6px solid;
            border-image-source: linear-gradient(45deg, #ff6b6b, #ffcc00, #1dd1a1);
            border-image-slice: 1;
            padding: 20px;
            margin: 20px auto;
            background-color: #f9f9f9;
            border-radius: 15px;
            box-sizing: border-box;
        }
    </style>
</head>
<body>

<div class="bordered-page">

## <div style="background-color:#ADD8E6; color:black; padding:15px; border-radius:10px; text-align:center; font-size:20px;"> 💡 LeetCode 125: Valid Palindrome </div>

### <div style="background-color:#FFB6C1; color:black; padding:10px; border-radius:5px; text-align:left;">❓ **Question**</div>
> Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

### <div style="background-color:#FFD700; color:black; padding:10px; border-radius:5px; text-align:left;">📌 **Example**</div>
#### **Example 1**
```plaintext
Input: "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
```
#### **Example 2**
```plaintext
Input: "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
```

### <div style="background-color:#32CD32; color:black; padding:10px; border-radius:5px; text-align:left;">🚀 **Approach**</div>
- **Normalize the String:**
    - Remove non-alphanumeric characters.
    - Convert to lowercase.
- **Two-Pointer Technique:**
    - Use two pointers, one at the beginning and one at the end.
    - Compare characters while moving the pointers towards the center.

### <div style="background-color:#FFA07A; color:black; padding:10px; border-radius:5px; text-align:left;">💻 **Java Solution**</div>
```java
class Solution {
    public boolean isPalindrome(String s) {
        // Initialize two pointers, left at start and right at end
        int left = 0, right = s.length() - 1;
        while (left < right) {
            // Move left pointer to the next alphanumeric character
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) left++;
            // Move right pointer to the previous alphanumeric character
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) right--;
            // Compare characters ignoring case
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) return false;
            left++;
            right--;
        }
        return true;
    }
}
```

### <div style="background-color:#FFD700; color:black; padding:10px; border-radius:5px; text-align:left;">📖 **Example Walkthrough**</div>

| Step | Left Pointer | Right Pointer | Comparison | Action |
|------|-------------|--------------|------------|--------|
| 1    | 'a'        | 'a'          | ✅ Match  | Move Pointers |
| 2    | 'm'        | 'm'          | ✅ Match  | Move Pointers |
| 3    | 'a'        | 'a'          | ✅ Match  | Move Pointers |
| 4    | 'n'        | 'n'          | ✅ Match  | Move Pointers |
| ...  | ...        | ...          | ...        | ... |
| Final| ---        | ---          | ✅ Valid Palindrome | Return `true` |

### <div style="background-color:#D8BFD8; color:black; padding:10px; border-radius:5px; text-align:left;">🔍 **Complexity Analysis**</div>
✅ **Time Complexity:** `O(N)`, where `N` is the length of the string. Each character is processed once.

✅ **Space Complexity:** `O(1)`, as no extra space is used apart from variables.

</div>
</body>
</html>

