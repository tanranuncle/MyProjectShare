package cn.mwxu16.acm.Csystem;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

/*
 * 初始化模块
 * 生成学生答案和正确答案
 */
public class CsystemInit {
	// 模块一、
	// 生成初始数据（标准答案、四个班的答案（其中每个班人数为40人，每人有四门课，每门课有十个选择题））
	public static void init() throws IOException, InterruptedException {
		// 1、创建目录结构
		File file1 = new File("d:\\Csystem\\trueAnswer");	//正确答案
		file1.mkdirs();
		File file2 = new File("d:\\Csystem\\realAnswer");	//真实答案
		file2.mkdirs();
		File file3 = new File("d:\\Csystem\\score");		//分数
		file3.mkdirs();
		File file4 = new File("d:\\Csystem\\analyse");		//分析结果
		file4.mkdirs();

		// 2、创建答案文件
		// 正确答案
		FileOutputStream trueAnswer = new FileOutputStream("d:\\Csystem\\trueAnswer\\trueAnswer.txt");
		// 第一个班级的答案
		FileOutputStream realAnswer1 = new FileOutputStream("d:\\Csystem\\realAnswer\\realAnswer1.txt");
		// 第二个班级的答案
		FileOutputStream realAnswer2 = new FileOutputStream("d:\\Csystem\\realAnswer\\realAnswer2.txt");
		// 第三个班级的答案
		FileOutputStream realAnswer3 = new FileOutputStream("d:\\Csystem\\realAnswer\\realAnswer3.txt");
		// 第四个班级的答案
		FileOutputStream realAnswer4 = new FileOutputStream("d:\\Csystem\\realAnswer\\realAnswer4.txt");

		// 4、生成答案
		// 正确答案
		String strTrueAnswerArr = getTrueAnswer() + " " + getTrueAnswer() + " " + getTrueAnswer() + " "
				+ getTrueAnswer();
		// 第一个班的答案
		String[] strRealAnswer1Arr = new String[40];
		for (int i = 0; i < 40; i++) {
			// 第i个人的四门课的答案，中间用空格隔开，方便后面处理
			strRealAnswer1Arr[i] = getRealAnswer() + " " + getRealAnswer() + " " + getRealAnswer() + " "
					+ getRealAnswer() + "\r\n";
		}
		// 第二个班的答案
		String[] strRealAnswer2Arr = new String[40];
		for (int i = 0; i < 40; i++) {
			// 第i个人的四门课的答案，中间用空格隔开，方便后面处理
			strRealAnswer2Arr[i] = getRealAnswer() + " " + getRealAnswer() + " " + getRealAnswer() + " "
					+ getRealAnswer() + "\r\n";
		}
		// 第三个班的答案
		String[] strRealAnswer3Arr = new String[40];
		for (int i = 0; i < 40; i++) {
			// 第i个人的四门课的答案，中间用空格隔开，方便后面处理
			strRealAnswer3Arr[i] = getRealAnswer() + " " + getRealAnswer() + " " + getRealAnswer() + " "
					+ getRealAnswer() + "\r\n";
		}
		// 第四个个班的答案
		String[] strRealAnswer4Arr = new String[40];
		for (int i = 0; i < 40; i++) {
			// 第i个人的四门课的答案，中间用空格隔开，方便后面处理
			strRealAnswer4Arr[i] = getRealAnswer() + " " + getRealAnswer() + " " + getRealAnswer() + " "
					+ getRealAnswer() + "\r\n";
		}
		// 5、向答案文件中写入生成的答案
		// 写入正确答案
		trueAnswer.write(strTrueAnswerArr.getBytes());
		// 写入第一个班的答案
		for (int i = 0; i < 40; i++) {
			realAnswer1.write(strRealAnswer1Arr[i].getBytes());
		}
		// 写入第二个班的答案
		for (int i = 0; i < 40; i++) {
			realAnswer2.write(strRealAnswer2Arr[i].getBytes());
		}
		// 写入第三个班的答案
		for (int i = 0; i < 40; i++) {
			realAnswer3.write(strRealAnswer3Arr[i].getBytes());
		}
		// 写入第四个班的答案
		for (int i = 0; i < 40; i++) {
			realAnswer4.write(strRealAnswer4Arr[i].getBytes());
		}
		// 6、关闭输出流
		trueAnswer.close();
		realAnswer1.close();
		realAnswer2.close();
		realAnswer3.close();
		realAnswer4.close();
	}

	// 获取真实答案
	public static String getRealAnswer() {
		Random rd = new Random();
		char[] charArr = new char[10];
		for (int i = 0; i < 10; i++) {
			// 生成随机生成ABCD
			// 注：rd.nextInt(a)+b，生成的随机数范围是b到a+b-1，包括b和a+b-1
			charArr[i] = (char) (rd.nextInt(4) + 65);
		}
		String s = new String(charArr);
		return s;
	}

	// 获取正确答案
	public static String getTrueAnswer() throws InterruptedException {
		Random rd = new Random();
		char[] charArr = new char[10];
		for (int i = 0; i < 10; i++) {
			Long time = System.currentTimeMillis();
			String s = time.toString();
			// 获取系统当前时间毫秒值，若是以4结尾，就生成一个问号答案，否则正常生成ABCD答案
			if (s.endsWith("4")) {
				charArr[i] = '?';
			} else {
				// 生成随机生成ABCD
				// 注：rd.nextInt(a)+b，生成的随机数范围是b到a+b-1，包括b和a+b-1
				charArr[i] = (char) (rd.nextInt(4) + 65);
			}
			Thread.sleep(1); // 由于计算机运行太快，为了避免连续多个值都是以4结尾，导致正确答案出现大量问号，休眠一秒
		}
		String s = new String(charArr);
		return s;
	}
}
