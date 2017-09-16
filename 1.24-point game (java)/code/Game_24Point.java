package cn.mwxu16.acm.dain24;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Game_24Point {
	private static JFrame f; // 创建窗体
	private static JTextField t; // 创建文本框
	private static JLabel lable; // 创建标签
	private static JLabel lable2; // 创建标签

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		initDian24(); // 调用初始化方法
	}

	// 创建窗口并添加按钮，为按钮绑定监听事件
	public static void initDian24() {
		f = new JFrame("24点游戏"); // 程序右上角标题
		f.setLayout(null);
		t = new JTextField(); // 文本输入框
		t.setBounds(20, 5, 250, 40); // 文本输入框的位置和大小
		f.add(t); // 添加文本输入框到界面中
		
		lable2 = new JLabel(""); // 提示标签
		lable2.setBounds(20, 45, 250, 20); // 标签输入框的位置和大小
		f.add(lable2); // 添加标签输入框到界面中
		
		lable = new JLabel(""); // 四个数标签
		lable.setBounds(20, 65, 250, 20); // 标签输入框的位置和大小
		f.add(lable); // 添加标签输入框到界面中

		int x = 20; // 第一个按钮的右上角横坐标
		int y = 140; // 第一个按钮的右上角纵坐标
		String[] str = { "7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "*", "(", ")", "10", "/" }; // 按钮上的文字
		for (int i = 0; i < str.length; i++) // 循环创建按钮
		{
			JButton btn = new JButton(); // 创建按钮
			btn.setText(str[i]); // 设置按钮上的文字
			btn.setBounds(x, y, 60, 40); // 设置按钮按钮的位置和大小
			if (x < 215) // 自动调整下一个按钮的位置参数
			{
				x += 65;
			} else {
				x = 20;
				y += 45;
			}
			f.add(btn); // 添加按钮到界面中
			btn.addActionListener(new Game_24Point.myInputListener());
		}
		// 创建清零按钮
		{
			JButton btn = new JButton();
			btn.setText("删除");
			btn.setBounds(150, 95, 60, 40); // 参数意义：按钮右上角横坐标，按钮右上角纵坐标，按钮横向长度，按钮纵向高度
			f.add(btn);
			btn.addActionListener(new Game_24Point.myDeleteListener());
		}
		// 创建开始按钮
		{
			JButton btn = new JButton();
			btn.setText("开始");
			btn.setBounds(85, 95, 60, 40); // 参数意义：按钮右上角横坐标，按钮右上角纵坐标，按钮横向长度，按钮纵向高度
			f.add(btn);
			btn.addActionListener(new Game_24Point.myStartListener());
		}
		// 创建重置按钮
		{
			JButton btn = new JButton();
			btn.setText("重置");
			btn.setBounds(215, 95, 60, 40); // 参数意义：按钮右上角横坐标，按钮右上角纵坐标，按钮横向长度，按钮纵向高度
			f.add(btn);
			btn.addActionListener(new Game_24Point.myResetListener());
		}
		// 创建帮助按钮
		{
			JButton btn = new JButton();
			btn.setText("帮助");
			btn.setBounds(20, 95, 60, 40); // 参数意义：按钮右上角横坐标，按钮右上角纵坐标，按钮横向长度，按钮纵向高度
			f.add(btn);
			btn.addActionListener(new Game_24Point.myHelpListener());
		}
		// 创建提交按钮
		{
			JButton btn = new JButton();
			btn.setText("提交");
			btn.setBounds(20, 320, 256, 40); // 参数意义：按钮右上角横坐标，按钮右上角纵坐标，按钮横向长度，按钮纵向高度
			f.add(btn);
			btn.addActionListener(new Game_24Point.mySubmiitListener());
		}
		f.setBounds(500, 200, 310, 410); // 设置启动时窗口的位置
		f.setVisible(true); // 设置窗口是否可见

	}

	// 创建输入按钮监听器，在文本框显示字符串
	static class myInputListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String s = t.getText();
			t.setText(s + e.getActionCommand());
		}
	}

	// 创建提交按钮监听器，提交文本框中的字符串
	static class mySubmiitListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Dian24 dian24 = new Dian24();	//获取对象
			String s = lable.getText();		//获取lable上的值
			String s2 = t.getText();		//获取输入框内的值
			try {
				//判断用户输入的答案是否正确
				lable.setText(dian24.testString(s, s2));
			} catch (Exception e1) {
				//若出现异常，说明lable标签上的内容为空，提示先点击开始
				lable.setText("请先点击开始按钮！");
				lable2.setText("");
			}
		}
	}

	// 创建删除按钮监听器，清空文本框
	static class myDeleteListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			t.setText(""); // 清空输入框

		}
	}

	// 创建重置按钮监听器，清空文本框
	static class myResetListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			t.setText(""); // 清空输入框
			lable.setText(""); // 清空标签
			lable2.setText(""); // 清空标签

		}
	}

	// 创建帮助按钮监听器，清空文本框
	static class myHelpListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Dian24 dian24 = new Dian24();
			String s = lable.getText();		//获取lable上的值
			try {
				//判断用户输入的答案是否正确
				lable.setText(dian24.getAnswer(s));
			} catch (Exception e1) {
				//若出现异常，说明lable标签上的内容为空，提示先点击开始
				lable.setText("帮助一次还不够？重新开始吧！");
			}
			lable2.setText("正确答案是：");
		}
	}

	// 创建开始按钮监听器，清空文本框，并在标签显示四个随机数
	static class myStartListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Dian24 dian24 = new Dian24();
			lable2.setText("四个数是：");
			lable.setText(dian24.getString()); // 设置标签的值为四个随机数
			t.setText(""); // 设置文本框为空

		}
	}

}
