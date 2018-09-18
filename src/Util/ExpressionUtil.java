package Util;

import calculate.CaculateResult;
import expression.MyExpression;
import expression.PostfixExpression;

public class ExpressionUtil {

	public static MyExpression getRandomExpression(int range) {
		// ��ȡ������ʽ
		MyExpression myExpression = null;
		int index = (int) (Math.random() * 6);
		if (index <= 1) {
			myExpression = getOneOperExp(range);// һ��������
		} else if (index == 5) {// ����������
			index = (int) (Math.random() * 2);
			if (index == 0) {
				myExpression = getThreeOperExp(range);
			} else {
				myExpression = getThreeOperExpWithBracket(range);
			}
		} else {// ����������
			index = (int) (Math.random() * 2);
			if (index == 0) {
				myExpression = getTwoOperExp(range);
			} else {
				myExpression = getTwoOperExpWithBracket(range);
			}
		}
		PostfixExpression.toPostfixExpression(myExpression);//���ɺ�׺���ʽ	
		CaculateResult.caculate(myExpression);	// ������

		return myExpression;
	}

	private static MyExpression getOneOperExp(int range) {
		// ��ȡһ���������ʽ
		MyExpression OneOperatorExpression = new MyExpression();
		String firstOperand = RandomUtil.getRandomOperand(range);
		String operator = RandomUtil.getRandomOperator();
		String nextOperand = RandomUtil.getRandomOperand(range);
		OneOperatorExpression.setExpression(jointExpression(firstOperand, operator, nextOperand));
		return OneOperatorExpression;
	}

	private static MyExpression getOneOperExpWithBracket(int range) {
		// ��ȡ������һ���������ʽ
		MyExpression OneOperExpWithBracket = getOneOperExp(range);
		OneOperExpWithBracket.setExpression(jointExpression("(", OneOperExpWithBracket.getExpression(), ")"));
		return OneOperExpWithBracket;
	}

	private static MyExpression getTwoOperExp(int range) {
		// ��ȡ�����������ʽ
		MyExpression TwoOperatorExpression = getOneOperExp(range);
		String operator = RandomUtil.getRandomOperator();
		String nextOperand = RandomUtil.getRandomOperand(range);
		TwoOperatorExpression
				.setExpression(jointExpression(TwoOperatorExpression.getExpression(), operator, nextOperand));
		return TwoOperatorExpression;
	}

	private static MyExpression getTwoOperExpWithBracket(int range) {
		// ��ȡ�����������������ʽ
		MyExpression TwoOperExpWithBracket = getOneOperExpWithBracket(range);
		String operator = RandomUtil.getRandomOperator();
		String nextOperand = RandomUtil.getRandomOperand(range);
		String expression = null;
		if ((int) (Math.random() * 2) == 0) {
			expression = jointExpression(TwoOperExpWithBracket.getExpression(), operator, nextOperand);
		} else {
			expression = jointExpression(nextOperand, operator, TwoOperExpWithBracket.getExpression());
		}
		TwoOperExpWithBracket.setExpression(expression);
		return TwoOperExpWithBracket;
	}

	private static MyExpression getThreeOperExp(int range) {
		// ��ȡ�����������ʽ
		MyExpression ThreeOperatorExpression = getTwoOperExp(range);// 1+2+3
		String operator = RandomUtil.getRandomOperator();
		String nextOperand = RandomUtil.getRandomOperand(range);
		ThreeOperatorExpression
				.setExpression(jointExpression(ThreeOperatorExpression.getExpression(), operator, nextOperand));
		return ThreeOperatorExpression;
	}

	private static MyExpression getThreeOperExpWithBracket(int range) {
		// ��ȡ�����������������ʽ
		MyExpression ThreeOperExpWithBracket = getTwoOperExpWithBracket(range);
		String operator = RandomUtil.getRandomOperator();
		String nextOperand = RandomUtil.getRandomOperand(range);
		String expression = null;
		if ((int) (Math.random() * 2) == 0) {
			expression = jointExpression(ThreeOperExpWithBracket.getExpression(), operator, nextOperand);
		} else {
			expression = jointExpression(nextOperand, operator, ThreeOperExpWithBracket.getExpression());
		}
		ThreeOperExpWithBracket.setExpression(expression);
		return ThreeOperExpWithBracket;
	}

	private static String jointExpression(String left, String operator, String right) {
		return left + " " + operator + " " + right;
	}

}
