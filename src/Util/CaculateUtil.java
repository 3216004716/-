package Util;

public class CaculateUtil {

	public static boolean isNumeric(String string) {
		if (string.contains("/")) {
			return false;
		}
		return true;
	}

	public static String toImproperTractionNumber(String string) {
		// 转成假分数
		int integer = 0;
		int numerator = 0; // 分子
		int denominator = 0; // 分母
		String itnum = null;
		if (!isNumeric(string)) {
			if (string.contains("'")) {
				String[] s = string.split("'");
				integer = Integer.parseInt(s[0]);
				String[] s1 = s[1].split("/");
				numerator = Integer.parseInt(s1[0]);
				denominator = Integer.parseInt(s1[1]);
				itnum = integer * denominator + numerator + "/" + denominator;
			}else {
				itnum=string;
			}
		}
		return itnum;
	}

	public static int getLowestCommonMultiple(int a, int b) {
		// 最小公倍数
		int i;
		for (i = 1; i <= a * b; i++) {
			if (i % a == 0 && i % b == 0) {
				break;
			}
		}
		return i;
	}

	public static int getGreatestCommonDivisor(int a, int b) {
		// 最大公约数
		int temp = 1;
		for (int i = 2; i <= Math.min(a, b); i++) {
			if (a % i == 0 && b % i == 0) {
				temp *= i;
			}
			a /= i;
			b /= i;
			i -= 1;
		}
		return temp;
	}

	public static int getNumerator(String string) {
		//获得分子数
		int numerator = 0;
		String string2= toImproperTractionNumber(string);
		String[] s1 = string2.split("/");
		numerator = Integer.parseInt(s1[0]);
		return numerator;
	}

	public static int getDenominator(String string) {
		//获得分母数
		int denominator = 0;
		String string2= toImproperTractionNumber(string);
		String[] s1 = string2.split("/");
		denominator = Integer.parseInt(s1[1]);
		return denominator;
	}


	public static void main(String[] args) {
		System.out.println(getGreatestCommonDivisor(8, 64));
		System.out.println(getLowestCommonMultiple(56, 120));
	}
}
