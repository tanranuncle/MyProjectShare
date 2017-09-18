package cn.mwxu16.acm.Csystem;

import java.io.IOException;
/*
 * C语言自动阅卷系统
 * 核心功能——————的——————测试类
 */
public class Csystem {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		CsystemInit.init(); // 初始化
		CsystemJuge.score(); // 判定所有人的分数
		CsystemAnalyse.getPassRate(); 	//计算每班的及格率（学生只要有一门不及格就认为是不及格）
		CsystemAnalyse.getAverage(); 	//计算每班的中，每门课的平均成绩
//		 test();
	}
}
