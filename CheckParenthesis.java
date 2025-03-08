public class CheckParenthesis {
    boolean checkParenthesis(String exp) {
        String closingbraces = "]})";
        String openingbraces = "[{(";
        Stacks stk = new Stacks(exp.length());

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (ch == '{' || ch == '[' || ch == '(') {
                stk.push(ch);
            } else {
                int index = closingbraces.indexOf(ch);
                char openingbracket = openingbraces.charAt(index);
                if(stk.isEmpty()){
                    return false;
                }
                if(stk.pop()!=openingbracket){
                    return false;
                }

            }
        }
        if(!stk.isEmpty(){
            return false;
        }
        return true;
    }
}
