package com.company;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Calculator {

    private static final String[] low_priority_functions = { "+", "-" };
    private static final String[] medium_priority_functions = { "*", "/" };

    private static String[] infix_to_postfix(String expression){
        List<String> infix = Arrays.asList(expression.split(" "));
        Stack<String> stack = new Stack<>();
        List<String> postfix = new ArrayList<>();
        for (String i: infix
             ) {
            try {
                double out = Double.parseDouble(i);
                postfix.add(i);
            }
            catch (Exception e){
                if(i.equals("(")){
                    stack.push(i);
                }
                else if(i.equals(")")){
                    String x;
                    while(!stack.isEmpty() && !(x = stack.pop()).equals("(")){
                        postfix.add(x);
                    }
                }
                else if(Arrays.asList(medium_priority_functions).contains(i)){
                    while(!stack.isEmpty() && (Arrays.asList(medium_priority_functions).contains(stack.peek()))){
                        postfix.add(stack.pop());
                    }
                    stack.push(i);
                }
                else if(Arrays.asList(low_priority_functions).contains(i)){
                    while(!stack.isEmpty() && ((Arrays.asList(low_priority_functions).contains(stack.peek()) || Arrays.asList(medium_priority_functions).contains(stack.peek())))){
                        postfix.add(stack.pop());
                    }
                    stack.push(i);
                }
            }
        }
        while (!stack.isEmpty()){
            postfix.add(stack.pop());
        }
        return postfix.toArray(new String[0]);
    }

    private static Double eval_postfix(String[] expression){
        Stack<Double> numbers = new Stack<>();
        for (String i: expression
             ) {
            try {
                Double x = Double.parseDouble(i);
                numbers.push(x);
            }
            catch (Exception e) {
                switch (i){
                    case "+":
                        numbers.push(numbers.pop() + numbers.pop());
                        break;
                    case "-":
                        Double b = numbers.pop();
                        Double a = numbers.pop();
                        numbers.push(a - b);
                        break;
                    case "*":
                        numbers.push(numbers.pop() * numbers.pop());
                        break;
                    case "/":
                        Double c = numbers.pop();
                        Double d = numbers.pop();
                        numbers.push(d / c);
                        break;
                }
            }
        }
        return numbers.pop();
    }

    public static Double evaluate(String expression) {
        String[] postfix = infix_to_postfix(expression);
        return Calculator.eval_postfix(postfix);
    }
}
