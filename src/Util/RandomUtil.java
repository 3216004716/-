package Util;

public class RandomUtil {

	// ��ȡ���������
	public static String getRandomOperator() {
		String[] Operator = { "��", "+", "-", "��" };
		int index = (int) (Math.random() * 4);
		return Operator[index];
	}

	// ��ȡ���������
	public static String getRandomOperand(int range) {
		String Operand = null;
		int index = (int) (Math.random() * 4);
		if (index == 0) {// ���ɷ���
			index = (int) (Math.random() * 3);
			if (index == 2) {// ���ɼٷ���
				Operand = getImproperTractionNumber(range);
			} else {// ���������
				Operand = getTruTractionNumber(range);
			}
		} else {
			Operand = getNaturalNumber(range);// ��������
		}
		return Operand;
	}

	private static int getRangeNumber(int min, int max) {
		// ������min~max��Χ�ڵ������
		int num = (int) (Math.random() * (max - min)) + min;
		return num;
	}

	private static String getNaturalNumber(int range) {
		// ������Ȼ��
		return String.valueOf(getRangeNumber(1, range));
	}

	private static String getTruTractionNumber(int range) {
		// ���������
		int denominator = getRangeNumber(2, range); // ��ȡ��ĸ(����1)
		int numerator = getRangeNumber(1, denominator); // ��ȡ����(����0С�ڷ�ĸ)
		return numerator + "/" + denominator;
	}

	private static String getImproperTractionNumber(int range) {
		// ���ɼٷ���
		int denominator = getRangeNumber(2, range); // ��ȡ��ĸ(����1)
		int temp = 0;
		int integerpart = 0;
		int numerator = 0;
		do {
			temp = getRangeNumber(denominator + 1, range * denominator);
			integerpart = temp / denominator;// ��������
			numerator = temp % denominator;// ����
		} while (numerator == 0);
		return integerpart + "'" + numerator + "/" + denominator;
	}
}