package cn.mwxu16.acm.MiYao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * 秘钥排序
 * 函数f(k)表示秘钥的复杂程度，f(k)函数的值是一个正整数，秘钥中的第1个字符后面小于它的字符数为m1,第2个字符后面小于它的字符数为m2 ，
 * f(k)=m1+m2+…+mk-1 。
 * 将秘钥容器中的所有秘钥按照f(k)升序排列
 */
public class SecretKeySort {
	private static int N = 0;		//字符串的条数
	public static void main(String[] args) throws FileNotFoundException {
		Long start = System.currentTimeMillis();
		String [] strArr = getString();		//读取字符串
		int [] arr = new int [N];		//创建一个与字符串数组等长的int数组，保存每个字符串的复杂度
		//计算每个秘钥的复杂度
		for(int i = 0; i < strArr.length ; i++){
			arr[i] = getSecretKeyComplexity(strArr[i]);
		}
		//使用冒泡排序法，对秘钥复杂度进行排序，同时将对应的秘钥进行排序
		int tempInt = 0;
		String tempString = null;
		for(int i=0;i<arr.length-1;i++){
			for(int k = 0;k<arr.length-i-1;k++){
				if(arr[k]>arr[k+1]){
					//交换复杂度
					tempInt = arr[k];
					arr[k] = arr[k+1];
					arr[k+1] = tempInt;
					//交换秘钥字符串
					tempString = strArr[k];
					strArr[k] = strArr[k+1];
					strArr[k+1] = tempString;
				}
			}
		}
		for(int i = 0; i < N; i++){
			System.out.println("复杂度:"+arr[i]+"\t秘钥："+strArr[i]);
		}
		Long end = System.currentTimeMillis();
		System.out.println("程序耗时："+(end-start)+"毫秒");
	}
	
	//计算秘钥的复杂度
	public static int getSecretKeyComplexity(String str) {
		char [] strChar = str.toCharArray();	//将字符串转为字符数组
		int complexity = 0;
		for(int i = 0; i < strChar.length - 1; i++){
			for(int j = i+1; j < strChar.length; j++){
				if(strChar[i] > strChar[j]){		//如果i后面的字符小于i，则复杂度加一
					complexity++;
				}
			}
		}
		return complexity;
	}
	
	//从文本中读取数据
	public static String [] getString() throws FileNotFoundException{
		Scanner sc=new Scanner(new FileInputStream("D:/input.txt"));	//从文本中读取测试数据
		N = Integer.parseInt(sc.nextLine());	//读取字符串的个数,不能使用nextInt，否则换行符会导致读取结果错误
		String [] str = new String [N];		//创建字符串数组
		for(int i = 0; i < N; i++){			//循环读取字符串
			str[i] = sc.nextLine();
		}
		sc.close(); 	//关闭输入
		return str;
	}
}
