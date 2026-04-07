class Solution {
    public boolean isValid(String s) {
        List<Character> opened = List.of('(', '{', '[');
        List<Character> closed = List.of(')', '}', ']');
        Stack<Character> stack = new Stack<Character>();
        for (Character c : s.toCharArray()){
            if (opened.contains(c)){
                stack.push(c); 
            } else if (closed.contains(c)){
                int index = closed.indexOf(c);
                if (stack.isEmpty() || stack.pop() != opened.get(index)){
                    return false;
                }
            }
        }
        if (!stack.isEmpty()){
            return false; 
        }
        return true;
    }
}
