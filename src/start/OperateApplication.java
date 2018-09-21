package start;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Util.ExpressionUtil;
import Util.FileUtil;
import expression.CheckExpression;
import expression.MyExpression;

public class OperateApplication {
	public static void main(String[] args) throws IOException {
		int range=0,count=0;
		for(int i=0;i<args.length;i++){
			switch (args[i]) {
			case "-n":
				count=Integer.parseInt(args[++i]);
				break;
			
			case "-r":
				range=Integer.parseInt(args[++i]);
				break;

			default:
				break;
			}
		}

		
		
		ArrayList<MyExpression> arrayList = new ArrayList<MyExpression>();
		while (arrayList.size() != count) {
			MyExpression randomExpression = ExpressionUtil.getRandomExpression(range);
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
