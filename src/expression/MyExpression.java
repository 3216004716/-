package expression;

import java.util.ArrayList;

public class MyExpression {

	String expression;
	ArrayList<String> postfixExpression;
	String result;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

	public ArrayList<String> getPostfixExpression() {
		return postfixExpression;
	}

	public void setPostfixExpression(ArrayList<String> postfixExpression) {
		this.postfixExpression = postfixExpression;
	}

}
