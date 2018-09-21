package expression;

import java.util.ArrayList;

import calculate.CaculateResult;

public class CheckExpression {

	public static boolean checkRepeated(MyExpression expression1, MyExpression expression2) {
		boolean flag = true;
		if (expression1.getPostfixExpression().size() == expression2.getPostfixExpression().size()) {
			if (expToString(expression1.getPostfixExpression()).equals(expToString(expression2.getPostfixExpression()))
					|| changePosition(expression1).equals(expToString(expression2.getPostfixExpression()))) {
				flag = false;
			}
		}
		return flag;
	}

	static String changePosition(MyExpression expression) {
		ArrayList<String> postfixExpression = expression.getPostfixExpression();
		String firstOperator = getFirstOperator(postfixExpression);
		if (firstOperator.equals("+") || firstOperator.equals("¡Á")) {
			int index = postfixExpression.indexOf(firstOperator);
			String temp = postfixExpression.get(index - 1);
			postfixExpression.set(index - 1, postfixExpression.get(index - 2));
			postfixExpression.set(index - 2, temp);
		}

		return expToString(postfixExpression);
	}

	static String getFirstOperator(ArrayList<String> postfixExpression) {
		String operator = "";
		for (int i = 0; i < postfixExpression.size(); i++) {
			String item = postfixExpression.get(i);
			if (item.equals("+") || item.equals("-") || item.equals("¡Á") || item.equals("¡Â")) {
				operator = item;
				break;
			}
		}
		return operator;
	}

	public static String expToString(ArrayList<String> PostfixExpression) {
		String string = null;
		for (int i = 0; i < PostfixExpression.size(); i++) {
			string += PostfixExpression.get(i);
		}
		return string;
	}

//	public static void main(String[] args) {
//		MyExpression expression1 = new MyExpression();
//		MyExpression expression2 = new MyExpression();
//		expression1.setExpression("1 ¡Â 2 ¡Á 5");
//		expression2.setExpression("1 + 5 ¡Á 2");
//		CaculateResult.caculate(expression1);
//		CaculateResult.caculate(expression2);
//		if (expression1.isCheckAnswer() && expression2.isCheckAnswer()) {
//			System.out.println(expression1.getResult());
//			System.out.println(expression2.getResult());
//			System.out.println(checkRepeated(expression1, expression2));
//		}
//
//	}
}
