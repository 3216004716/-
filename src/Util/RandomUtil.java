package Util;

public class RandomUtil {

	// 获取随机操作符
	public static String getRandomOperator() {
		String[] Operator = { "×", "+", "-", "÷" };
		int index = (int) (Math.random() * 4);
		return Operator[index];
	}

	// 获取随机操作数
	public static String getRandomOperand(int range) {
		String Operand = null;
		int index = (int) (Math.random() * 4);
		if (index == 0) {// 生成分数
			index = (int) (Math.random() * 3);
			if (index == 2) {// 生成假分数
				Operand = getImproperTractionNumber(range);
			} else {// 生成真分数
				Operand = getTruTractionNumber(range);
			}
		} else {
			Operand = getNaturalNumber(range);// 生成整数
		}
		return Operand;
	}

	private static int getRangeNumber(int min, int max) {
		// 生成在min~max范围内的随机数
		int num = (int) (Math.random() * (max - min)) + min;
		return num;
	}

	private static String getNaturalNumber(int range) {
		// 生成自然数
		return String.valueOf(getRangeNumber(1, range));
	}

	private static String getTruTractionNumber(int range) {
		// 生成真分数
		int denominator = getRangeNumber(2, range); // 获取分母(大于1)
		int numerator = getRangeNumber(1, denominator); // 获取分子(大于0小于分母)
		return numerator + "/" + denominator;
	}

	private static String getImproperTractionNumber(int range) {
		// 生成假分数
		int denominator = getRangeNumber(2, range); // 获取分母(大于1)
		int temp = 0;
		int integerpart = 0;
		int numerator = 0;
		do {
			temp = getRangeNumber(denominator + 1, range * denominator);
			integerpart = temp / denominator;// 整数部分
			numerator = temp % denominator;// 分子
		} while (numerator == 0);
		return integerpart + "'" + numerator + "/" + denominator;
	}
}