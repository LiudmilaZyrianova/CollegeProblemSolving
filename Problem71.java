//71. Simplify Path - M
//Given an absolute path for a file (Unix-style), simplify it. Or in other words, convert it to the canonical path.

import java.util.Stack;

public class Main {

    public static String simplifyPath(String path){
        Stack<String> s = new Stack<>();
        String[] arr = path.split("/");
        for (String elem : arr){
            if (elem.equals("..")) {
                if (!s.empty()) s.pop();
            } else if (elem.equals(".")){}
            else if (elem.length()==0) {}
            else s.push(elem);
        }
        Stack<String> s2 = new Stack<>();
        while (!s.empty()) {
            s2.push(s.pop());
        }
        StringBuilder sb = new StringBuilder();
        while (!s2.empty()) {
            sb.append('/');
            sb.append(s2.pop());
        }
        sb.append('/');
        return sb.toString();
    }
    public static void main(String[] args){
        System.out.println(simplifyPath("///hello/c///alloha"));
        System.out.println(simplifyPath("/../"));

    }

}

