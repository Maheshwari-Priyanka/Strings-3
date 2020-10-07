// Problem 2
// Time Complexity: O(n) where n = length of string
// Space Complexity: O(m) where m = length of digits in the string

// Algorithm
// 1 - initialize a sign to '+' and stack
// 2 - loop over string upto its length
// 3 - check if reached last iteration
// 4 - if char is digit, get the num
// 5 - if char is not digit or not space, 
// 6 - then check for sign match
// 7 - change the sign to current sign and reinitialize num to 0
// 8 - loop through stack
// 9 - keep adding the num to result
class Solution {
  public int calculate(String s) {
    int n = s.length();

    if(s == null || n == 0) {
      return 0;
    }

    int num = 0;
    // 1
    Stack<Integer> stack = new Stack<>();
    char sign = '+';

    // 2
    for(int i = 0; i <= n; i++) {
      // 3
      char c = i == n ? 0 : s.charAt(i);
      // 4
      if(Character.isDigit(c)) {
        num = num * 10 + c - '0';
      }
      // 5
      if(!Character.isDigit(c) && c != ' ') {
        // 6
        if(sign == '+') {
          stack.push(num);
        } else if(sign == '-') {
          stack.push(-num);
        } else if(sign == '*') {
          stack.push(stack.pop() * num);
        } else if(sign == '/') {
          stack.push(stack.pop() / num);
        }
        // 7
        num = 0;
        sign = c;
      }
    }

    num = 0;
    // 8
    for(int i : stack) {
      // 9
      num += i;
    }
    
    return num;
  }
}
