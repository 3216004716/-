package calculate;

import java.util.ArrayList;
import java.util.Stack;

import expression.MyExpression;
import expression.PostfixExpression;
import Util.CaculateUtil;
import Util.ExpressionUtil;
import Util.RandomUtil;

public class CaculateResult {

	ArrayList<MyExpression> Question = new ArrayList<>();
	ArrayList<String> Answer = new ArrayList<>();
	ArrayList<MyExpression> PostfixExp = new ArrayList<>();

	public boolean expInArray(MyExpression exp) {
		// 判断此后缀表达式是否存在于PostfixExp
		if (PostfixExp.contains(exp)) {
			return true;
		}
		return false;
	}

	public static String expToString(ArrayList<String> PostfixExpression) {
		String string = null;
		for (int i = 0; i < PostfixExpression.size(); i++) {
			string += PostfixExpression.get(i);
		}
		return string;
	}

	public static String caculate(MyExpression myExpression) {
		PostfixExpression.toPostfixExpression(myExpression);
		ArrayList<String> postfixExpression = myExpression.getPostfixExpression();
		String temp = "";
		Stack<String> s = new Stack<>();

		String a = null;
		String b = null;
		int result = 0;
		int a1, a2, b1, b2 = 0;
		int denominator = 0;
		int numerator = 0;
		int gcd = 0;
		a:for (int i = 0; i < postfixExpression.size(); i++) {

			String item = postfixExpression.get(i);
			switch (item) {
			case "+":
				a = s.pop();
				b = s.pop();
				if (CaculateUtil.isNumeric(a) && CaculateUtil.isNumeric(b)) {
					result = Integer.parseInt(a) + Integer.parseInt(b);
					temp = String.valueOf(result);
				} else if (CaculateUtil.isNumeric(a) && !CaculateUtil.isNumeric(b)) {
					denominator = CaculateUtil.getDenominator(b);
					numerator = CaculateUtil.getNumerator(b);
					numerator = Integer.parseInt(a) * denominator + numerator;
					temp = numerator + "/" + denominator;
				} else if (!CaculateUtil.isNumeric(a) && CaculateUtil.isNumeric(b)) {
					denominator = CaculateUtil.getDenominator(a);
					numerator = CaculateUtil.getNumerator(a);
					numerator = Integer.parseInt(b) * denominator + numerator;
					temp = numerator + "/" + denominator;
				} else {
					a1 = CaculateUtil.getDenominator(a);
					a2 = CaculateUtil.getNumerator(a);
					b1 = CaculateUtil.getDenominator(b);
					b2 = CaculateUtil.getNumerator(b);
					numerator = a1 * b2 + a2 * b1;
					denominator = a1 * b1;
					temp = numerator + "/" + denominator;
				}
				s.push(temp);
				break;

			case "×":
				a = s.pop();
				b = s.pop();
				if (CaculateUtil.isNumeric(a) && CaculateUtil.isNumeric(b)) {
					result = Integer.parseInt(a) * Integer.parseInt(b);
					temp = String.valueOf(result);
				} else if (CaculateUtil.isNumeric(a) && !CaculateUtil.isNumeric(b)) {
					numerator = CaculateUtil.getNumerator(b);
					denominator = CaculateUtil.getDenominator(b);
					numerator = numerator * Integer.parseInt(a);
					temp = numerator + "/" + denominator;
				} else if (!CaculateUtil.isNumeric(a) && CaculateUtil.isNumeric(b)) {
					numerator = CaculateUtil.getNumerator(a);
					denominator = CaculateUtil.getDenominator(a);
					numerator = numerator * Integer.parseInt(b);
					temp = numerator + "/" + denominator;
				} else {
					a1 = CaculateUtil.getDenominator(a);
					a2 = CaculateUtil.getNumerator(a);
					b1 = CaculateUtil.getDenominator(b);
					b2 = CaculateUtil.getNumerator(b);
					numerator = a2 * b2;
					denominator = a1 * b1;
					temp = numerator + "/" + denominator;
				}
				s.push(temp);
				break;

			case "-":
				b = s.pop();
				a = s.pop();
				int inta, intb = 0;
				if (CaculateUtil.isNumeric(a) && CaculateUtil.isNumeric(b)) {
					inta = Integer.parseInt(a);
					intb = Integer.parseInt(b);
//					if (inta < intb) {
//						break;
//					} else {
						result = inta - intb;
						temp = String.valueOf(result);
//					}
				} else if (CaculateUtil.isNumeric(a) && !CaculateUtil.isNumeric(b)) {
					inta = Integer.parseInt(a);
					numerator = CaculateUtil.getNumerator(b);
					denominator = CaculateUtil.getDenominator(b);
//					if (inta * denominator < numerator) {
//						break;
//					} else {
						numerator = inta * denominator - numerator;
						temp = numerator + "/" + denominator;
//					}
				} else if (!CaculateUtil.isNumeric(a) && CaculateUtil.isNumeric(b)) {
					intb = Integer.parseInt(b);
					numerator = CaculateUtil.getNumerator(a);
					denominator = CaculateUtil.getDenominator(a);
//					if (numerator < intb * denominator) {
//						break;
//					} else {
						numerator = numerator - intb * denominator;
						temp = numerator + "/" + denominator;
//					}
				} else {
					a1 = CaculateUtil.getDenominator(a);
					a2 = CaculateUtil.getNumerator(a);
					b1 = CaculateUtil.getDenominator(b);
					b2 = CaculateUtil.getNumerator(b);
//					if (a2 * b1 < a1 * b2) {
//						break;
//					} else {
						numerator = a2 * b1 - a1 * b2;
						denominator = a1 * b1;
						temp = numerator + "/" + denominator;
//					}
				}
				if(temp.contains("-")){
					myExpression.setCheckAnswer(false);
					break a;
				}
				s.push(temp);
				break;

			case "÷":
				b = s.pop();
				a = s.pop();
				int inta1 = 0, intb1 = 0;
				if (CaculateUtil.isNumeric(a) && CaculateUtil.isNumeric(b)) {
					inta1 = Integer.parseInt(a);
					intb1 = Integer.parseInt(b);
					if (intb1 == 0) {
						break;
					} else if ((inta1 % intb1) == 0) {
						result = inta1 / intb1;
						temp = String.valueOf(result);
					} else {
						numerator = inta1;
						denominator = intb1;
						temp = numerator + "/" + denominator;
					}
				} else if (CaculateUtil.isNumeric(a) && !CaculateUtil.isNumeric(b)) {
					inta1 = Integer.parseInt(a);
					numerator = CaculateUtil.getNumerator(b);
					denominator = CaculateUtil.getDenominator(b);
					int temp1 = numerator;
					numerator = inta1 * denominator;
					denominator = temp1;
					temp = numerator + "/" + denominator;
				} else if (!CaculateUtil.isNumeric(a) && CaculateUtil.isNumeric(b)) {
					intb1 = Integer.parseInt(b);
					numerator = CaculateUtil.getNumerator(a);
					denominator = CaculateUtil.getDenominator(a);
					denominator = denominator * intb1;
					temp = numerator + "/" + denominator;
				} else {
					a1 = CaculateUtil.getDenominator(a);
					a2 = CaculateUtil.getNumerator(a);
					b1 = CaculateUtil.getDenominator(b);
					b2 = CaculateUtil.getNumerator(b);
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

		// gcd = CaculateUtil.getGreatestCommonDivisor(numerator,
		// denominator);// 获得最大公约数
		// numerator /= gcd;
		// denominator /= gcd;
		// if (numerator / denominator >= 1) {
		// temp = numerator / denominator + "'";
		// }
		// temp += numerator % denominator + "/" + denominator;
		return temp;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			MyExpression myExpression = ExpressionUtil.getRandomExpression(50);
			// myExpression.setExpression("17/55 + 6'4/5 + 5");
			PostfixExpression.toPostfixExpression(myExpression);
			String caculate = caculate(myExpression);
			if(myExpression.isCheckAnswer()){				
				System.out.print(myExpression.getExpression() + " = ");
				System.out.println(caculate);
			}
		}

	}
}
