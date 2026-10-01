class Solution {
    public boolean isValid(String str) {
        Stack<Character> st= new Stack<>();

        for(int i=0;i<str.length();i++)
        {
             if (str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '[') {
                st.push(str.charAt(i));
            }
            else
            {
                if(st.size()==0){
                    return false;
                }

                char top = st.peek();

                if ((top == '(' && str.charAt(i) == ')') ||
                    (top == '{' && str.charAt(i) == '}') ||
                    (top == '[' && str.charAt(i) == ']')) {
                    st.pop();
                } 
                else {
                    return false;
                }
            }

        }
        return st.size()==0;
    }
}