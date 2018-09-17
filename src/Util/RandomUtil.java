package Util;

public class RandomUtil {
	String[] Operator = { "×", "+", "-", "÷" };

	public String getRandomOperator() {
		// 获取随机操作符
		int index = (int) Math.random() * 4;
		return Operator[index];
	}

	public int getOperand(int range) {
		// 生成随机操作数
		int operand = (int) Math.random() * range;
		return operand;
	}

	public String getNaturalNumber(int range) {
		// 生成自然数
		return String.valueOf(getOperand(range));
	}

	public String getTruTractionNumber(int range) {
		// 生成真分数
		int denominator = getOperand(range); // 获取分母
		while (denominator == 0) {
			denominator = getOperand(range);
		}
		int numerator = getOperand(denominator); // 获取分子
		String string = String.valueOf(numerator) + "/" + String.valueOf(denominator);
		return string;
	}

	public String getImproperTractionNumber(int range) {
		// 生成假分数
		String left = String.valueOf(getOperand(range));
		String right = String.valueOf(getOperand(range));
		return left + "'" + right;
	}
}