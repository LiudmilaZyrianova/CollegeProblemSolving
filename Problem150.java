//150. Evaluate Reverse Polish Notation - M.
//Evaluate the value of an arithmetic expression in Reverse Polish Notation.


import java.util.Stack;

public class Main {

    public static int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        for (String elem : tokens){
            if (elem.equals("+")) {
                s.push(s.pop() + s.pop());
            }
            else if (elem.equals("-")) {
                s.push(s.pop() - s.pop());
            }
            else if (elem.equals("*")) {
                s.push(s.pop() * s.pop());
            }
            else if (elem.equals("/")) {
                s.push(s.pop()/s.pop());
            }
            else s.push(Integer.valueOf(elem));

        }
        return s.pop();

    }
    public static void main(String[] args){
        String[] ar = new String[5];
        ar[0] = "2";
        ar[1] = "1";
        ar[2] = "+";
        ar[3] = "3";
        ar[4] = "*";
        System.out.println(evalRPN(ar));

    }

}

