package expression;

import java.util.ArrayList;
import java.util.Stack;

public class PostfixExpression {
	public static void toPostfixExpression(MyExpression myExpression) {
		//将String类型转换成MyExpression类型的后缀表达式
		ArrayList<String> postfixExpression = generatePostfixExpression(myExpression.getExpression());
		myExpression.setPostfixExpression(postfixExpression);
	}

	private static ArrayList<String> generatePostfixExpression(String expression) {
		//生成String类型的后缀表达式
		String[] expressionArray = expression.split(" ");
		ArrayList<String> postfixExpression = new ArrayList<String>();
		Stack<String> stack = new Stack<String>();
		for (int i = 0; i < expressionArray.length; i++) {
			String item = expressionArray[i];
			String temp = "";
			switch (item) {
			case "(":
				stack.push(item);
				break;
			case ")":
				while ((stack.size() != 0) && !((temp = stack.pop()).equals("("))) {
					postfixExpression.add(temp);
				}
				break;
			case "+":
			case "-":
				while ((stack.size() != 0) && !((temp = stack.pop()).equals("("))) {
					postfixExpression.add(temp);
				}
				if (temp.equals("(")) {
					stack.push(temp);
				}
				stack.push(item);
				break;
			case "×":
			case "÷":
				while ((stack.size() != 0) && !((temp = stack.pop()).equals("("))) {
					if (temp.equals("×") || temp.equals("÷")) {
						postfixExpression.add(temp);
					} else {
						stack.push(temp);
						break;
					}
				}
				if (temp.equals("(")) {
					stack.push(temp);
				}
				stack.push(item);
				break;
			default:
				postfixExpression.add(item);
			}
		}
		while (stack.size() != 0) {
			postfixExpression.add(stack.pop());
		}
		return postfixExpression;
	}

}
