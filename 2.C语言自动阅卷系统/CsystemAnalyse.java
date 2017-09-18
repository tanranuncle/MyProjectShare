package cn.mwxu16.acm.Csystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/*
 * 分析模块
 * 每个班的每门课的平均成绩
 * 成绩处于指定分数的的学生人数
 * 标准差
 * 及格率
 */
public class CsystemAnalyse {
	// 一、
	// 求平均数,计算出所有的平均数，存到文件中
	public static boolean getAverage() throws IOException {
		File file = new File("d:\\Csystem");
		if (file.exists()) {
			realGetAverage();
			return true;
		}else{
			return false;
		}
	}
	public static void realGetAverage() throws IOException {
		// 1、创建平均数文件
		FileOutputStream average = new FileOutputStream("d:\\Csystem\\analyse\\average.txt");
		// 2、获得四个班的平均成绩
		String strAverage = "";
		// 分别求四个班的平均成绩
		for (int i = 0; i < 4; i++) {
			Scanner sc = null;
			// 创建第i个班级的Scanner对象
			if (i == 0) {
				sc = new Scanner(new FileInputStream("d:\\Csystem\\score\\score1.txt"));
			} else if (i == 1) {
				sc = new Scanner(new FileInputStream("d:\\Csystem\\score\\score2.txt"));
			} else if (i == 2) {
				sc = new Scanner(new FileInputStream("d:\\Csystem\\score\\score3.txt"));
			} else if (i == 3) {
				sc = new Scanner(new FileInputStream("d:\\Csystem\\score\\score4.txt"));
			}
			// 获得一个班四门课的的平均成绩
			strAverage += getAllScore(sc) + "\r\n";
			sc.close();
		}
		// 将四个班的及格率写到文件中
		average.write(strAverage.getBytes());
	}
	// 统计及格率
		public static String getAllScore(Scanner sc) {
			String allAverage = "";
			int count1 = 0; // 统计第一门课的成绩
			int count2 = 0; // 统计第二门课的成绩
			int count3 = 0; // 统计第三门课的成绩
			int count4 = 0; // 统计第四门课的成绩
			for (int i = 0; i < 40; i++) {
				String score = sc.nextLine();
				String[] scoreArr = score.split(" ");
				// 四门课的成绩
				count1 += Integer.parseInt(scoreArr[0]);
				count2 += Integer.parseInt(scoreArr[1]);
				count3 += Integer.parseInt(scoreArr[2]);
				count4 += Integer.parseInt(scoreArr[3]);
			}
			// 求平均成绩
			double average1 = (double) count1 / 40;
			double average2 = (double) count2 / 40;
			double average3 = (double) count3 / 40;
			double average4 = (double) count4 / 40;
			// 格式化及格率
			allAverage = String.format("%.2f", average1) + " " + String.format("%.2f", average2) + " "
					+ String.format("%.2f", average3) + " " + String.format("%.2f", average4);
			return allAverage;
		}
	
	
	
	
	

	// 四、
	// 求及格率,统计出每个班的及格率，存到文件中
	public static void getPassRate() throws IOException {
		// 1、创建及格率文件
		FileOutputStream passRate = new FileOutputStream("d:\\Csystem\\analyse\\passRate.txt");
		// 2、获得四个班的及格率
		String strPassRate = "";
		// 分别求四个班的及格率
		for (int i = 0; i < 4; i++) {
			Scanner sc = null;
			// 创建第i个班级的Scanner对象
			if (i == 0) {
				sc = new Scanner(new FileInputStream("d:\\Csystem\\score\\score1.txt"));
			} else if (i == 1) {
				sc = new Scanner(new FileInputStream("d:\\Csystem\\score\\score2.txt"));
			} else if (i == 2) {
				sc = new Scanner(new FileInputStream("d:\\Csystem\\score\\score3.txt"));
			} else if (i == 3) {
				sc = new Scanner(new FileInputStream("d:\\Csystem\\score\\score4.txt"));
			}
			// 获得一个班四门课的的及格率
			strPassRate += getAllPassRate(sc) + "\r\n";
			sc.close();
		}
		// 将四个班的及格率写到文件中
		passRate.write(strPassRate.getBytes());
	}

	// 统计及格率
	public static String getAllPassRate(Scanner sc) {
		String allPassRate = "";
		int count1 = 0; // 统计第一门课的不及格人数
		int count2 = 0; // 统计第二门课的不及格人数
		int count3 = 0; // 统计第三门课的不及格人数
		int count4 = 0; // 统计第四门课的不及格人数
		for (int i = 0; i < 40; i++) {
			String score = sc.nextLine();
			String[] scoreArr = score.split(" ");
			// 四门课的成绩
			int a = Integer.parseInt(scoreArr[0]);
			int b = Integer.parseInt(scoreArr[1]);
			int c = Integer.parseInt(scoreArr[2]);
			int d = Integer.parseInt(scoreArr[3]);
			// 分别统计四门课的不及格人数
			if (a < 6) {
				count1++;
			}
			if (b < 6) {
				count2++;
			}
			if (c < 6) {
				count3++;
			}
			if (d < 6) {
				count4++;
			}
		}
		// 求及格率
		double passRate1 = (double) (40 - count1) / 40;
		double passRate2 = (double) (40 - count2) / 40;
		double passRate3 = (double) (40 - count3) / 40;
		double passRate4 = (double) (40 - count4) / 40;
		// 格式化及格率
		allPassRate = String.format("%.2f", passRate1) + " " + String.format("%.2f", passRate2) + " "
				+ String.format("%.2f", passRate3) + " " + String.format("%.2f", passRate4);
		return allPassRate;
	}
}
