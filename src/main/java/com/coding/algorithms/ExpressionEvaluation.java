package com.coding.algorithms;

import java.util.Stack;

public class ExpressionEvaluation {

    public static void main(String[] args) {
        String expression = "(1+((2+3)*(4*5)))";
        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();
        for (char ch : expression.toCharArray()) { // Read token, push if operator.
            String s = Character.toString(ch);
            if (s.equals("("));
            else if (s.equals("+")) ops.push(s);
            else if (s.equals("-")) ops.push(s);
            else if (s.equals("*")) ops.push(s);
            else if (s.equals("/")) ops.push(s);
            else if (s.equals("sqrt")) ops.push(s);
            else if (s.equals(")")) { // Pop, evaluate, and push result if token is ")".
                String op = ops.pop();
                double v = vals.pop();
                if (op.equals("+")) v = vals.pop() + v;
                else if (op.equals("-")) v = vals.pop() - v;
                else if (op.equals("*")) v = vals.pop() * v;
                else if (op.equals("/")) v = vals.pop() / v;
                else if (op.equals("sqrt")) v = Math.sqrt(v);
                vals.push(v);
            } // Token not operator or paren: push double value.
            else vals.push(Double.parseDouble(s));
        }
        System.out.println(vals.pop());
    }
}
