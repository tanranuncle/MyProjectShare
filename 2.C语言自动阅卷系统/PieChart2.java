package cn.mwxu16.acm.Csystem;

import java.awt.Font;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;  
  
public class PieChart2 {  
    ChartPanel frame1; 
    static double passRate1;
    static double passRate2;
    static double passRate3;
    static double passRate4;
    public PieChart2() throws FileNotFoundException{  
          DefaultPieDataset data = getDataSet();  
          JFreeChart chart = ChartFactory.createPieChart3D("二班及格率",data,true,false,false);  
        //设置百分比  
          PiePlot pieplot = (PiePlot) chart.getPlot();  
          DecimalFormat df = new DecimalFormat("0.00%");//获得一个DecimalFormat对象，主要是设置小数问题  
          NumberFormat nf = NumberFormat.getNumberInstance();//获得一个NumberFormat对象  
          StandardPieSectionLabelGenerator sp1 = new StandardPieSectionLabelGenerator("{0}  {2}", nf, df);//获得StandardPieSectionLabelGenerator对象  
          pieplot.setLabelGenerator(sp1);//设置饼图显示百分比  
        
      //没有数据的时候显示的内容  
          pieplot.setNoDataMessage("无数据显示");  
          pieplot.setCircular(false);  
          pieplot.setLabelGap(0.02D);  
        
          pieplot.setIgnoreNullValues(true);//设置不显示空值  
          pieplot.setIgnoreZeroValues(true);//设置不显示负值  
         frame1=new ChartPanel (chart,true);  
          chart.getTitle().setFont(new Font("宋体",Font.BOLD,20));//设置标题字体  
          PiePlot piePlot= (PiePlot) chart.getPlot();//获取图表区域对象  
          piePlot.setLabelFont(new Font("宋体",Font.BOLD,10));//解决乱码  
          chart.getLegend().setItemFont(new Font("黑体",Font.BOLD,10));  
    }  
    private static DefaultPieDataset getDataSet() throws FileNotFoundException {  
    	//获取及格率
    	Scanner sc = new Scanner(new FileInputStream("d:\\Csystem\\analyse\\average.txt"));
    	sc.nextLine();
    	String [] strArr = sc.nextLine().split(" ");
    	passRate1 = Double.parseDouble(strArr[0]);
        passRate2 = Double.parseDouble(strArr[1]);
        passRate3 = Double.parseDouble(strArr[2]);
        passRate4 = Double.parseDouble(strArr[3]);
        DefaultPieDataset dataset = new DefaultPieDataset();  
        dataset.setValue("科目一",passRate1);  
        dataset.setValue("科目二",passRate2);  
        dataset.setValue("科目三",passRate3);  
        dataset.setValue("科目四",passRate4);  
        return dataset;  
}  
    public ChartPanel getChartPanel(){  
        return frame1;  
          
    }  
}  