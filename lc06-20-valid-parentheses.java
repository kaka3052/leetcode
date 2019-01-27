// 20. Valid Parentheses
// Easy

// Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

// An input string is valid if:

// Open brackets must be closed by the same type of brackets.
// Open brackets must be closed in the correct order.
// Note that an empty string is also considered valid.

// Example 1:

// Input: "()"
// Output: true
// Example 2:

// Input: "()[]{}"
// Output: true
// Example 3:

// Input: "(]"
// Output: false
// Example 4:

// Input: "([)]"
// Output: false
// Example 5:

// Input: "{[]}"
// Output: true

class Solution {
    Map map = new HashMap();
    Stack stack = new Stack();
    
    public void init(){
        map.put(")", "(");
        map.put("]", "[");
        map.put("}", "{");
    }
    public boolean isValid(String s) {   
        init();
        //loop s
        char[] charArray = s.toCharArray();
        int len = charArray.length;
        for (int i = 0; i < len; i++){
            String cur = "" + charArray[i];
            String prev = stack.empty()? "" : (String)stack.peek();
            if (map.containsKey(cur)){
                if (map.get(cur).equals( prev)){
                    stack.pop();
                }else{
                    return false;
                }
            }else{
                stack.push(cur);
            }
            
        }
        return stack.empty();  
    }
}