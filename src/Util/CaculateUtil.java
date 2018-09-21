package Util;

public class CaculateUtil {

	public static boolean isNumeric(String string) {
		// �ж��Ƿ�Ϊ����
		if (string.contains("/")) {
			return false;
		}
		return true;
	}

	public static String toImproperTractionNumber(String string) {
		// ת�ɼٷ���
		int integer = 0;
		int numerator = 0; // ����
		int denominator = 0; // ��ĸ
		String itnum = null;
		if (!isNumeric(string)) {
			if (string.contains("'")) {
				String[] s = string.split("'");
				integer = Integer.parseInt(s[0]);
				String[] s1 = s[1].split("/");
				numerator = Integer.parseInt(s1[0]);
				denominator = Integer.parseInt(s1[1]);
				itnum = integer * denominator + numerator + "/" + denominator;
			} else {
				itnum = string;
			}
		}
		return itnum;
	}

	public static int getGreatestCommonDivisor(int a, int b) {
		// �����Լ��
		int temp = 1;
		for (int i = 2; i <= Math.min(a, b); i++) {
			if (a % i == 0 && b % i == 0) {
				temp *= i;
				a /= i;
				b /= i;
				i -= 1;
			}

		}
		return temp;
	}

	public static String reduceFractiong(String temp) {
		// Լ��
		if (!isNumeric(temp)) {
			int numerator = getNumerator(temp);// ����
			int denominator = getDenominator(temp);// ��ĸ
			int gcd = getGreatestCommonDivisor(numerator, denominator);// ������Լ��
			numerator /= gcd;
			denominator /= gcd;
			temp = numerator + "/" + denominator;
			if (denominator==1) {
				temp=String.valueOf(numerator);
			}else if (numerator / denominator >= 1 && numerator % denominator != 0) {
				temp = numerator / denominator + "'" + numerator % denominator + "/" + denominator;
			}
		}
		return temp;
	}

	public static int getNumerator(String string) {
		// ��÷�����
		int numerator = 0;
		String string2 = toImproperTractionNumber(string);
		String[] s1 = string2.split("/");
		numerator = Integer.parseInt(s1[0]);
		return numerator;
	}

	public static int getDenominator(String string) {
		// ��÷�ĸ��
		int denominator = 0;
		String string2 = toImproperTractionNumber(string);
		String[] s1 = string2.split("/");
		denominator = Integer.parseInt(s1[1]);
		return denominator;
	}

	public static void main(String[] args) {
		System.out.println(getGreatestCommonDivisor(84, 640));
	}
}
