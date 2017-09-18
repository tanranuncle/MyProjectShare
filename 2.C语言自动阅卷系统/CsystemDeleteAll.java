package cn.mwxu16.acm.Csystem;

import java.io.File;

public class CsystemDeleteAll {
	// 删除Csystem文件夹
	public static boolean DeleteAll() {
		File file = new File("d:\\Csystem");
		if (file.exists()) {
			deleteDir(file);
			return true;
		}else{
			return false;
		}
	}

	private static boolean deleteDir(File dir) {
		if (dir.isDirectory()) {
			String[] children = dir.list();
			// 递归删除目录中的子目录下
			for (int i = 0; i < children.length; i++) {
				boolean success = deleteDir(new File(dir, children[i]));
				if (!success) {
					return false;
				}
			}
		}
		// 目录此时为空，可以删除
		return dir.delete();
	}
}
