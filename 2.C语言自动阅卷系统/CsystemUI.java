package cn.mwxu16.acm.Csystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/*
 * C语言自动阅卷系统
 * 界面
 */
public class CsystemUI {
	private static JFrame f; // 创建窗体
	private static JTextField t; // 创建文本框
	private static JTextArea t1; // 创建文本框
	private static JLabel lable; // 创建标签
	private static JLabel lable1; // 创建标签
	private static JLabel lable2; // 创建标签
	private static JLabel lable3; // 创建标签

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		initDian24(); // 调用初始化方法
	}

	// 创建窗口并添加按钮，为按钮绑定监听事件
	public static void initDian24() throws FileNotFoundException {
		f = new JFrame("C语言自动阅卷系统"); // 程序右上角标题
		f.setLayout(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 关闭窗口时退出虚拟机

		lable = new JLabel("欢迎使用自动阅卷系统~"); // 欢迎标签
		lable.setBounds(20, 15, 600, 20); // 标签的位置和大小
		f.add(lable); // 添加标签输入框到界面中

		lable1 = new JLabel(""); // 提示标签
		lable1.setBounds(20, 75, 600, 20); // 标签的位置和大小
		f.add(lable1); // 添加标签输入框到界面中

		lable2 = new JLabel("author ： mwxu"); // 提示标签
		lable2.setBounds(20, 515, 600, 20); // 标签的位置和大小
		f.add(lable2); // 添加标签输入框到界面中

		lable3 = new JLabel("mail   : mwxu16@gmail.com"); // 提示标签
		lable3.setBounds(20, 540, 600, 20); // 标签的位置和大小
		f.add(lable3); // 添加标签输入框到界面中

		t1 = new JTextArea(""); // 文本域
		t1.setBounds(20, 105, 850, 400); // 位置和大小
		f.add(t1); // 添加文本域输入框到界面中
		File file = new File("d:\\README.txt");
		if (file.exists()) {
			Scanner sc = new Scanner(new FileInputStream("d:\\README.txt"));
			String s = "";
			boolean b = true;
			while(b)
			if(sc.hasNextLine()){
				s += "\n" +sc.nextLine();
			}else{
				b = false;
			}
			t1.setText(s);
		}else{
			t1.setText("请把README.txt文件放到D盘根目录下。。。");
		}
		// 创建开始按钮
		{
			JButton btn = new JButton();
			btn.setText("生成原始数据");
			btn.setBounds(20, 40, 115, 30); // 参数意义：按钮右上角横坐标，按钮右上角纵坐标，按钮横向长度，按钮纵向高度
			f.add(btn);
			btn.addActionListener(new CsystemUI.initAll());
		}
		// 创建提交按钮
		{
			JButton btn = new JButton();
			btn.setText("清空原始数据");
			btn.setBounds(145, 40, 115, 30); // 参数意义：按钮右上角横坐标，按钮右上角纵坐标，按钮横向长度，按钮纵向高度
			f.add(btn);
			btn.addActionListener(new CsystemUI.deleteAll());
		}

		// 创建提交按钮
		{
			JButton btn = new JButton();
			btn.setText("判定分数");
			btn.setBounds(270, 40, 90, 30); // 参数意义：按钮右上角横坐标，按钮右上角纵坐标，按钮横向长度，按钮纵向高度
			f.add(btn);
			btn.addActionListener(new CsystemUI.JugeAll());
		}
		// 创建提交按钮
		{
			JButton btn = new JButton();
			btn.setText("平均成绩");
			btn.setBounds(370, 40, 100, 30); // 参数意义：按钮右上角横坐标，按钮右上角纵坐标，按钮横向长度，按钮纵向高度
			f.add(btn);
			btn.addActionListener(new CsystemUI.allAverage());
		}
		// 创建提交按钮
		{
			JButton btn = new JButton();
			btn.setText("及格率");
			btn.setBounds(480, 40, 105, 30); // 参数意义：按钮右上角横坐标，按钮右上角纵坐标，按钮横向长度，按钮纵向高度
			f.add(btn);
			btn.addActionListener(new CsystemUI.passRate());
		}

		// 创建提交按钮
		{
			JButton btn = new JButton();
			btn.setText("及格率统计图");
			btn.setBounds(600, 40, 120, 30); // 参数意义：按钮右上角横坐标，按钮右上角纵坐标，按钮横向长度，按钮纵向高度
			f.add(btn);
			btn.addActionListener(new CsystemUI.passRateChart());
		}
		// 创建提交按钮
		{
			JButton btn = new JButton();
			btn.setText("退出");
			btn.setBounds(730, 40, 100, 30); // 参数意义：按钮右上角横坐标，按钮右上角纵坐标，按钮横向长度，按钮纵向高度
			f.add(btn);
			btn.addActionListener(new CsystemUI.exitCsystem());
		}

		f.setBounds(220, 60, 910, 610); // 设置启动时窗口的位置
		f.setVisible(true); // 设置窗口是否可见

	}

	// ----------------------------下面是监听器---------------------------------------------
	// 创建生成原始数据按钮监听器，点击该按钮即可生成学生答案和正确答案
	static class initAll implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				CsystemInit.init();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				lable1.setText("操作失败！");
			}
			lable1.setText("成功生成原始数据！  数据保存在D:\\Csystem目录下");
		}
	}

	// 创建清空原始数据按钮监听器，点击该按钮即可删除Csystem文件夹
	static class deleteAll implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (CsystemDeleteAll.DeleteAll()) {
				lable1.setText("成功清空原始数据！");
			} else {
				lable1.setText("原始数据不存在！");
			}
		}
	}

	// 创建判定分数按钮监听器，点击该按钮即可判定所有人的分数
	static class JugeAll implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				if (CsystemJuge.score()) {
					lable1.setText("成功判定分数！ 数据保存在D:\\Csystem\\score目录下");
				} else {
					lable1.setText("原始数据不存在");
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				lable1.setText("操作失败！");
			}
		}
	}

	// 创建平均成绩按钮监听器，点击该按钮即可求各班各科目的平均分数
	static class allAverage implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				if (CsystemAnalyse.getAverage()) {
					lable1.setText("已求出分数！ 数据保存在D:\\Csystem\\analyse目录下");
				} else {
					lable1.setText("原始数据不存在");
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				lable1.setText("操作失败！");
			}
		}
	}

	// 创建及格率按钮监听器，点击该按钮即可求各班各科目的及格率
	static class passRate implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				CsystemAnalyse.getPassRate();

				lable1.setText("已求出及格率！ 数据保存在D:\\Csystem\\analyse目录下");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				lable1.setText("操作失败！");
			}
		}
	}

	// 创建及格率统计图按钮监听器，点击该按钮即可求各班各科目的及格率统计图
	static class passRateChart implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				CsystemUIForPieChart.getPieChart();
				lable1.setText("请看图，别看我！");
			} catch (Exception ee) {
				lable1.setText("尴尬。。。出错了！");
			}
		}

	}

	// 创建退出按钮监听器，点击该按钮时退出虚拟机
	static class exitCsystem implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
}
