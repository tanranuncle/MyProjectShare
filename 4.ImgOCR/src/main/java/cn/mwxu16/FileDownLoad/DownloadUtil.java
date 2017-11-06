package cn.mwxu16.FileDownLoad;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
/*
 * 作用：
 * 将远程文件下载到本地
 */
public class DownloadUtil {

		//remoteFilePath ： 远程文件地址（文件来源）。如：http://www.baidu.com/test.png
		//localFilePath : 本地文件地址（存储在本地哪个文件中）。如：D:/1234.png
		public static void downloadFile(String remoteFilePath, String localFilePath)
	    {
	        URL urlfile = null;
	        HttpURLConnection httpUrl = null;
	        BufferedInputStream bis = null;
	        BufferedOutputStream bos = null;
	        File f = new File(localFilePath);
	        try
	        {
	            urlfile = new URL(remoteFilePath);
	            httpUrl = (HttpURLConnection)urlfile.openConnection();
	            httpUrl.connect();
	            bis = new BufferedInputStream(httpUrl.getInputStream());
	            bos = new BufferedOutputStream(new FileOutputStream(f));
	            int len = 2048;
	            byte[] b = new byte[len];
	            while ((len = bis.read(b)) != -1)
	            {
	                bos.write(b, 0, len);
	            }
	            bos.flush();
	            bis.close();
	            httpUrl.disconnect();
	        }
	        catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	        finally
	        {
	            try
	            {
	                bis.close();
	                bos.close();
	            }
	            catch (IOException e)
	            {
	                e.printStackTrace();
	            }
	        }
	    }
}
