package start;

import java.io.IOException;
import java.util.ArrayList;

import Util.ExpressionUtil;
import Util.FileUtil;
import expression.CheckExpression;
import expression.MyExpression;

public class OperateApplication {
	public static void main(String[] args) throws IOException {
		ArrayList<MyExpression> arrayList = new ArrayList<MyExpression>();
		while (arrayList.size() != 10) {
			MyExpression randomExpression = ExpressionUtil.getRandomExpression(100);
			boolean flag = randomExpression.isCheckAnswer();// 检查结果
			// 检查重复
			for (int i = 0; i < arrayList.size(); i++) {
				if (!CheckExpression.checkRepeated(randomExpression, arrayList.get(i))) {
					flag = false;
					break;
				}
			}
			if (flag) {
				arrayList.add(randomExpression);
			}
		}
		FileUtil.writeQuestion(arrayList);
		FileUtil.writeAnswer(arrayList);
		// for (int i = 0; i < arrayList.size(); i++) {
		// System.out.println(i + ". " + arrayList.get(i).getExpression() + " = " +
		// arrayList.get(i).getResult());
		// }
	}
}
