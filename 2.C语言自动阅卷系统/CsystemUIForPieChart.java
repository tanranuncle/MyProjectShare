package cn.mwxu16.acm.Csystem;
import java.awt.GridLayout;
import java.io.FileNotFoundException;

import javax.swing.JFrame;

public class CsystemUIForPieChart {
	public static void getPieChart() {
		JFrame frame = new JFrame("C语言自动阅卷系统-及格率统计图");
		frame.setLayout(new GridLayout(2, 2, 10, 10));
		
//		frame.add(new BarChart().getChartPanel()); // 添加柱形图
		try {
			frame.add(new PieChart1().getChartPanel());
			frame.add(new PieChart2().getChartPanel()); // 添加饼状图
			frame.add(new PieChart3().getChartPanel()); // 添加饼状图
			frame.add(new PieChart4().getChartPanel()); // 添加饼状图
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("操作错误：\nCsystemUIForPieChart\n没找到及格率文件。。。显然是数据都清空了还去算及格率。。");;
		} // 添加饼状图
//		frame.add(new TimeSeriesChart().getChartPanel()); // 添加折线图
		
		frame.setBounds(50, 50, 800, 600);
		frame.setVisible(true);
	}
	
	
}