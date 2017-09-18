package cn.mwxu16.acm.Csystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/*
 * 判定成绩
 * 判定出每个学生的成绩，并保存到文件中
 */
public class CsystemJuge {
	// 模块二、
	// 判定成绩并将成绩保存到文件中
	@SuppressWarnings("resource")
	public static boolean score() throws IOException {
		File file = new File("d:\\Csystem");
		if (!file.exists()) {
			return false;
		}
		
		// 1、创建分数文件
		// 第一个班级的分数
		FileOutputStream score1 = new FileOutputStream("d:\\Csystem\\score\\score1.txt");
		// 第二个班级的分数
		FileOutputStream score2 = new FileOutputStream("d:\\Csystem\\score\\score2.txt");
		// 第三个班级的分数
		FileOutputStream score3 = new FileOutputStream("d:\\Csystem\\score\\score3.txt");
		// 第四个班级的分数
		FileOutputStream score4 = new FileOutputStream("d:\\Csystem\\score\\score4.txt");
		
		// 2、判定成绩
		// 创建正确答案的Scanner对象
		Scanner scAnswer = new Scanner(new FileInputStream("d:\\Csystem\\trueAnswer\\trueAnswer.txt"));
		String trueAnswer = scAnswer.nextLine();
		Scanner sc = null;
		for (int i = 0; i < 4; i++) {
			// 创建第i个班级的Scanner对象
			if (i == 0) {
				sc = new Scanner(new FileInputStream("d:\\Csystem\\realAnswer\\realAnswer1.txt"));
			} else if (i == 1) {
				sc = new Scanner(new FileInputStream("d:\\Csystem\\realAnswer\\realAnswer2.txt"));
			} else if (i == 2) {
				sc = new Scanner(new FileInputStream("d:\\Csystem\\realAnswer\\realAnswer3.txt"));
			} else if (i == 3) {
				sc = new Scanner(new FileInputStream("d:\\Csystem\\realAnswer\\realAnswer4.txt"));
			}
			String score = "";
			// 获取i班的40个学生的全部成绩
			for (int k = 0; k < 40; k++) {
				String stuAnswer = sc.nextLine();
				// 获取第K个学生的四门课成绩（字符串形式）,并将四十个学生的成绩连在一起（每个学生的成绩后面加换行）
				score += getScore(trueAnswer, stuAnswer,0) + " " + getScore(trueAnswer, stuAnswer,1) + " "
						+ getScore(trueAnswer, stuAnswer,2) + " " + getScore(trueAnswer, stuAnswer,3) + "\r\n";
			}
			// 将四十个学生的成绩写入文件
			if (i == 0) {
				score1.write(score.getBytes());
			} else if (i == 1) {
				score2.write(score.getBytes());
			} else if (i == 2) {
				score3.write(score.getBytes());
			} else if (i == 3) {
				score4.write(score.getBytes());
			}

		}
		return true;
	}

	// 判定成绩,需要知道正确答案（以字符串形式传入正确答案），需要知道学生的答案的（以字符串形式传入每个学生的答案），哪个门课程（读第几列数据，索引）
	public static String getScore(String trueAnswer1, String stuAnswer1, int course) {
		// char[] stuScore = null;
		// char[] trueAnswer = null;
		String score = ""; // 该学生的四门课的成绩
		// 获取正确答案，并转为字符串数组
		String[] trueAnswer = trueAnswer1.split(" ");
		// 获得该学生的课程的答案，并转为字符串数组
		String[] stuAnswer = stuAnswer1.split(" ");

		int fenshu = 0;
		// 获得正确答案的字符数组
		char[] trueAnswerArr = trueAnswer[course].toCharArray();
		// 获取学生答案的字符数组
		char[] stuAnswerArr = stuAnswer[course].toCharArray();
		// 依次比较学生答案与正确答案
		for (int j = 0; j < stuAnswerArr.length; j++) {
			//当学生答案与正确答案相等、或正确答案为“？”时,都判定学生正确，分数加一
			if (stuAnswerArr[j] == trueAnswerArr[j] || trueAnswerArr[j] == '?' ) {
				fenshu++;
			}
		}
		// 将分数转为字符串
		score = fenshu + "";

		return score;
	}
}
