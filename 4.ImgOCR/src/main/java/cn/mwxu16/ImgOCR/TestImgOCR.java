package cn.mwxu16.ImgOCR;

import java.io.File;
import org.junit.Test;
import cn.mwxu16.FileDownLoad.DownloadUtil;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

/*
 * 测试使用tess4j来识别图片验证码
 * 注意：
 * 在线的图片，图片原来什么格式，保存的时候就什么格式，最好不要改变格式（虽然有时候改完格式也能打开，但是会导致程序报错）
 */
public class TestImgOCR {
	
	@Test
	public void test() {
		//将网络上的验证码下载到本地
		DownloadUtil.downloadFile("http://job.aust.edu.cn/system/resource/js/filedownload/createimage.jsp?randnum=1508387067056", "D:/ImageForOCR/1234.jpg");
		//创建要识别的验证码File对象
		File imageFile = new File("D:/ImageForOCR/1234.jpg");
		//判断验证码图片是否存在，若存在则进行识别
		if (imageFile.exists()) {
			//创建识别器实例
			Tesseract instance = new Tesseract();
			// 创建识别结果字符串
			String result;
			try {
				// 将验证码图片的内容识别为字符串
				result = instance.doOCR(imageFile);
				System.out.println("验证码是 : " + result);
			} catch (TesseractException e) {
				System.out.println("识别验证码失败！");
			}
		}else{
			System.out.println("验证码图片读取失败！");
		}
	}
	
	/*可供测试的验证码链接：
	 * 1、http://job.aust.edu.cn/system/resource/js/filedownload/createimage.jsp?randnum=1508387067056
	 * 2、
	 * 3、
	 * 
	 */
	
}
