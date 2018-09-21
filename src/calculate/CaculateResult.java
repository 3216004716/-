package calculate;

import java.util.ArrayList;
import java.util.Stack;

import expression.MyExpression;
import expression.PostfixExpression;
import Util.CaculateUtil;

public class CaculateResult {

	public static void caculate(MyExpression myExpression) {
		PostfixExpression.toPostfixExpression(myExpression);
		ArrayList<String> postfixExpression = myExpression.getPostfixExpression();
		String temp = "";
		Stack<String> s = new Stack<>();

		String rightOperand = null;
		String leftOperand = null;
		int result = 0;
		int a1, a2, b1, b2 = 0;
		int denominator = 0;
		int numerator = 0;
		a: for (int i = 0; i < postfixExpression.size(); i++) {

			String item = postfixExpression.get(i);
			switch (item) {
			case "+":
				rightOperand = s.pop();
				leftOperand = s.pop();
				if (CaculateUtil.isNumeric(rightOperand) && CaculateUtil.isNumeric(leftOperand)) {
					result = Integer.parseInt(rightOperand) + Integer.parseInt(leftOperand);
					temp = String.valueOf(result);
				} else if (CaculateUtil.isNumeric(rightOperand) && !CaculateUtil.isNumeric(leftOperand)) {
					denominator = CaculateUtil.getDenominator(leftOperand);
					numerator = CaculateUtil.getNumerator(leftOperand);
					numerator = Integer.parseInt(rightOperand) * denominator + numerator;
					temp = numerator + "/" + denominator;
				} else if (!CaculateUtil.isNumeric(rightOperand) && CaculateUtil.isNumeric(leftOperand)) {
					denominator = CaculateUtil.getDenominator(rightOperand);
					numerator = CaculateUtil.getNumerator(rightOperand);
					numerator = Integer.parseInt(leftOperand) * denominator + numerator;
					temp = numerator + "/" + denominator;
				} else {
					a1 = CaculateUtil.getDenominator(rightOperand);
					a2 = CaculateUtil.getNumerator(rightOperand);
					b1 = CaculateUtil.getDenominator(leftOperand);
					b2 = CaculateUtil.getNumerator(leftOperand);
					numerator = a1 * b2 + a2 * b1;
					denominator = a1 * b1;
					temp = numerator + "/" + denominator;
				}
				s.push(temp);
				break;

			case "¡Á":
				rightOperand = s.pop();
				leftOperand = s.pop();
				if (CaculateUtil.isNumeric(rightOperand) && CaculateUtil.isNumeric(leftOperand)) {
					result = Integer.parseInt(rightOperand) * Integer.parseInt(leftOperand);
					temp = String.valueOf(result);
				} else if (CaculateUtil.isNumeric(rightOperand) && !CaculateUtil.isNumeric(leftOperand)) {
					numerator = CaculateUtil.getNumerator(leftOperand);
					denominator = CaculateUtil.getDenominator(leftOperand);
					numerator = numerator * Integer.parseInt(rightOperand);
					temp = numerator + "/" + denominator;
				} else if (!CaculateUtil.isNumeric(rightOperand) && CaculateUtil.isNumeric(leftOperand)) {
					numerator = CaculateUtil.getNumerator(rightOperand);
					denominator = CaculateUtil.getDenominator(rightOperand);
					numerator = numerator * Integer.parseInt(leftOperand);
					temp = numerator + "/" + denominator;
				} else {
					a1 = CaculateUtil.getDenominator(rightOperand);
					a2 = CaculateUtil.getNumerator(rightOperand);
					b1 = CaculateUtil.getDenominator(leftOperand);
					b2 = CaculateUtil.getNumerator(leftOperand);
					numerator = a2 * b2;
					denominator = a1 * b1;
					temp = numerator + "/" + denominator;
				}
				s.push(temp);
				break;

			case "-":
				leftOperand = s.pop();
				rightOperand = s.pop();
				int inta, intb = 0;
				if (CaculateUtil.isNumeric(rightOperand) && CaculateUtil.isNumeric(leftOperand)) {
					inta = Integer.parseInt(rightOperand);
					intb = Integer.parseInt(leftOperand);
					result = inta - intb;
					temp = String.valueOf(result);
				} else if (CaculateUtil.isNumeric(rightOperand) && !CaculateUtil.isNumeric(leftOperand)) {
					inta = Integer.parseInt(rightOperand);
					numerator = CaculateUtil.getNumerator(leftOperand);
					denominator = CaculateUtil.getDenominator(leftOperand);
					numerator = inta * denominator - numerator;
					temp = numerator + "/" + denominator;
				} else if (!CaculateUtil.isNumeric(rightOperand) && CaculateUtil.isNumeric(leftOperand)) {
					intb = Integer.parseInt(leftOperand);
					numerator = CaculateUtil.getNumerator(rightOperand);
					denominator = CaculateUtil.getDenominator(rightOperand);
					numerator = numerator - intb * denominator;
					temp = numerator + "/" + denominator;
				} else {
					a1 = CaculateUtil.getDenominator(rightOperand);
					a2 = CaculateUtil.getNumerator(rightOperand);
					b1 = CaculateUtil.getDenominator(leftOperand);
					b2 = CaculateUtil.getNumerator(leftOperand);
					numerator = a2 * b1 - a1 * b2;
					denominator = a1 * b1;
					temp = numerator + "/" + denominator;
				}
				if (temp.contains("-")||temp.equals("0")) {
					myExpression.setCheckAnswer(false);
					break a;
				}
				s.push(temp);
				break;

			case "¡Â":
				leftOperand = s.pop();
				rightOperand = s.pop();
				int integer_a = 0, integer_b = 0;
				if (CaculateUtil.isNumeric(rightOperand) && CaculateUtil.isNumeric(leftOperand)) {
					integer_a = Integer.parseInt(rightOperand);
					integer_b = Integer.parseInt(leftOperand);
					if (integer_b == 0) {
						break;
					} else if ((integer_a % integer_b) == 0) {
						result = integer_a / integer_b;
						temp = String.valueOf(result);
					} else {
						numerator = integer_a;
						denominator = integer_b;
						temp = numerator + "/" + denominator;
					}
				} else if (CaculateUtil.isNumeric(rightOperand) && !CaculateUtil.isNumeric(leftOperand)) {
					integer_a = Integer.parseInt(rightOperand);
					numerator = CaculateUtil.getNumerator(leftOperand);
					denominator = CaculateUtil.getDenominator(leftOperand);
					int temp1 = numerator;
					numerator = integer_a * denominator;
					denominator = temp1;
					temp = numerator + "/" + denominator;
				} else if (!CaculateUtil.isNumeric(rightOperand) && CaculateUtil.isNumeric(leftOperand)) {
					integer_b = Integer.parseInt(leftOperand);
					numerator = CaculateUtil.getNumerator(rightOperand);
					denominator = CaculateUtil.getDenominator(rightOperand);
					denominator = denominator * integer_b;
					temp = numerator + "/" + denominator;
				} else {
					a1 = CaculateUtil.getDenominator(rightOperand);
					a2 = CaculateUtil.getNumerator(rightOperand);
					b1 = CaculateUtil.getDenominator(leftOperand);
					b2 = CaculateUtil.getNumerator(leftOperand);
					numerator = a2 * b1;
					denominator = a1 * b2;
					temp = numerator + "/" + denominator;
				}
				s.push(temp);
				break;

			default:
				s.push(item);
				break;
			}
		}
		myExpression.setResult(CaculateUtil.reduceFractiong(temp));
	}
}
