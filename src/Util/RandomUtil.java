package Util;

public class RandomUtil {
	String[] Operator = { "��", "+", "-", "��" };

	public String getRandomOperator() {
		// ��ȡ���������
		int index = (int) Math.random() * 4;
		return Operator[index];
	}

	public int getOperand(int range) {
		// �������������
		int operand = (int) Math.random() * range;
		return operand;
	}

	public String getNaturalNumber(int range) {
		// ������Ȼ��
		return String.valueOf(getOperand(range));
	}

	public String getTruTractionNumber(int range) {
		// ���������
		int denominator = getOperand(range); // ��ȡ��ĸ
		while (denominator == 0) {
			denominator = getOperand(range);
		}
		int numerator = getOperand(denominator); // ��ȡ����
		String string = String.valueOf(numerator) + "/" + String.valueOf(denominator);
		return string;
	}

	public String getImproperTractionNumber(int range) {
		// ���ɼٷ���
		String left = String.valueOf(getOperand(range));
		String right = String.valueOf(getOperand(range));
		return left + "'" + right;
	}
}