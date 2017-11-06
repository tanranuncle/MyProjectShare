package cn.mwxu16.FileDownLoad;

import org.junit.Test;

public class TestDownload {
	
	@Test
	public void test(){
		DownloadUtil.downloadFile("http://fbaso.cn/www/misc/image_code?r=0.2609072445790739", "D:/ImageForOCR/1234.png");
	}
}
