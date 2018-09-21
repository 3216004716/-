package Util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import expression.MyExpression;

public class FileUtil {

	public static void writeQuestion(ArrayList<MyExpression> arraylist) throws IOException {
		File file = new File("Exercises.txt");
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
		for (int i = 0; i < arraylist.size(); i++) {
			String question = arraylist.get(i).getExpression();
			bw.write(i + 1 + ". " + question + " = ");
			bw.newLine();
			bw.flush();
		}
		bw.close();
	}

	public static void writeAnswer(ArrayList<MyExpression> arraylist) throws IOException {
		File file = new File("Answers.txt");
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
		for (int i = 0; i < arraylist.size(); i++) {
			String answer = arraylist.get(i).getResult();
			bw.write(i + 1 + ". " + answer);
			bw.newLine();
			bw.flush();
		}
		bw.close();
	}
}
