package cn.mwxu16.acm.dain24;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dian24 {

	public String testString(String str, String ssss) throws InterruptedException {
		// 参数：str,标签上的四个数。ssss,文本框中的内容
		// 获取四个整数的数组
		int[] arr = getIntArr(str);
		// 获取用的组合方式（字符串）
		List<String> answerStris = easyCount(arr);
		// 如果集合非空，说明有可用解，遍历集合
		int i = 0; // 标志位，0代表输入结果与结果集不匹配，1代表匹配
		if (!answerStris.isEmpty()) {
			for (String string : answerStris) {
				if (ssss.equals(string)) {
					i = 1;		
					break;
				}
			}
		}
		if (i == 1) {
			return "恭喜你，答对了！";
		}
		return "很遗憾，答错了！";
	}

	// 用户点击开始按钮时，在这里得到四个1到10的随机数，并将四个随机数拼成字符串返回
	public String getString() {
		String randomStr = "";
		Random ran = new Random();
		for (int i = 0; i < 4; i++) {
			if (i < 3) {
				randomStr += (ran.nextInt(10) + 1) + ",";
			} else {
				randomStr += (ran.nextInt(10) + 1) + "";
			}
		}
		// 获取四个整数的数组
		int[] arr = getIntArr(randomStr);
		// 获取用的组合方式（字符串）
		List<String> answerStris = easyCount(arr);
		// 如果集合非空，说明有可用解，遍历集合
		if (!answerStris.isEmpty()) {
			return randomStr;
		} else {
			randomStr = getString(); // 若没有，则再次调用本方法，直到获取到有解的四个数
		}
		return randomStr;
	}

	// 用户点击开始按钮时，在这里得到四个1到10的随机数，并将四个随机数拼成字符串返回
	public String getAnswer(String str) {
		// 获取四个整数的数组
		int[] arr = getIntArr(str);
		// 获取用的组合方式（字符串）
		List<String> answerStris = easyCount(arr);
		// 如果集合非空，说明有可用解，遍历集合
		if (!answerStris.isEmpty()) {
			for (String s : answerStris) {
				return s;
			}
		} 
		return "没有正确答案！";
	}

	// 在这里生成四个随机数
	public static int[] getIntArr(String str) {
		String[] strArr = str.split(",");
		int[] arr = new int[4];
		for (int i = 0; i < 4; i++) {

			arr[i] = Integer.parseInt(strArr[i]);
		}
		return arr;
	}

	// 创建字符串集合，用于存储所有可用解
	private List<String> answerList = new ArrayList<String>();

	public List<String> getAnswerList() {
		return answerList;
	}

	public static class Data {
		public float[] arr;
		public String expStr = "";
		public String[] strs;

		public Data() {
		}

		public Data(int a, int b, int c, int d) {
			arr = new float[] { a, b, c, d };
			strs = new String[] { a + "", b + "", c + "", d + "" };
			expStr = a + "";
		}

		public Data(int arr[]) {
			this.arr = new float[] { arr[0], arr[1], arr[2], arr[3] };
			this.strs = new String[] { arr[0] + "", arr[1] + "", arr[2] + "", arr[3] + "" };
		}
	}

	public void count(Data data) {
		float[] arr = data.arr;
		if (arr.length <= 1) {
			if (arr.length == 1 && arr[0] == 24) {
				answerList.add(data.expStr.substring(1, data.expStr.length() - 1));
			}
			return;
		}
		for (int i = 0, len = arr.length; i < len - 1; i++) {
			for (int j = i + 1; j < len; j++) {
				float x = arr[i];
				float y = arr[j];
				String xs = data.strs[i];
				String ys = data.strs[j];
				for (int k = 0; k < 6; k++) {
					Data newData = getNewArr(data, i);
					switch (k) {
					case 0:
						newData.arr[j - 1] = x + y;
						newData.expStr = xs + "+" + ys;
						break;
					case 1:
						newData.arr[j - 1] = x - y;
						newData.expStr = xs + "-" + ys;
						break;
					case 2:
						newData.arr[j - 1] = y - x;
						newData.expStr = ys + "-" + xs;
						break;
					case 3:
						newData.arr[j - 1] = x * y;
						newData.expStr = xs + "*" + ys;
						break;
					case 4:
						if (y != 0) {
							newData.arr[j - 1] = x / y;
							newData.expStr = xs + "/" + ys;
						} else {
							continue;
						}
						break;
					case 5:
						if (x != 0) {
							newData.arr[j - 1] = y / x;
							newData.expStr = ys + "/" + xs;
						} else {
							continue;
						}
						break;
					}
					newData.expStr = "(" + newData.expStr + ")";
					newData.strs[j - 1] = newData.expStr;
					count(newData);
				}
			}
		}

	}

	private static Data getNewArr(Data data, int i) {
		Data newData = new Data();
		newData.expStr = data.expStr;
		newData.arr = new float[data.arr.length - 1];
		newData.strs = new String[data.arr.length - 1];
		for (int m = 0, len = data.arr.length, n = 0; m < len; m++) {
			if (m != i) {
				newData.arr[n] = data.arr[m];
				newData.strs[n] = data.strs[m];
				n++;
			}
		}
		return newData;
	}

	public static final List<String> easyCount(int[] curRandNums) {
		Dian24 dian24 = new Dian24();
		dian24.count(new Data(curRandNums));
		// Set<String> set = new HashSet<String>(dian24.getAnswerList());//
		// 通过set集合去重
		// return new ArrayList<String>(set); // 将set集合转为list集合返回

		return dian24.getAnswerList();
	}

}