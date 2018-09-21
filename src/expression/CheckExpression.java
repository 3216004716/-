package expression;

import java.util.Stack;

public class CheckExpression {
	public boolean checkRepeated(MyExpression expression1, MyExpression expression2) {
		boolean flag = true;
		Stack<String> stack=new Stack<String>();
		if (expression1.getPostfixExpression().toString().equals(expression2.getPostfixExpression().toString())) {
			flag = false;
		} else {
			
		}
		return flag;
	}

	String changePosition() {
		return null;
	}
}
