package com.niuxiaofei.redis.utils;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 
 * @ClassName: StreamUtil
 * @Description:处理流类
 * @author:nxf
 * @date: 2019年7月16日 上午8:38:06
 */
public class StreamUtil {
	/**
	 * @Title: closeAll
	 * @Description:方法1：批量关闭流，参数能传无限个,例如传入FileInputStream对象、JDBC中Connection对象都可以关闭。
	 * @param closeables
	 * @return: void
	 * @throws IOException
	 */
	public static void closeAll(Closeable... closeables) throws IOException {
		for (Closeable closeable : closeables) {
			closeable.close();
		}
	}

	/**
	 * 
	 * @Title: copy
	 * @Description:方法2：拷贝流，将InputStream流拷到OutputStream，可以用于快速读与文件、上传下载，为了提高性能，需要使用缓冲。
	 * @param src                 输入流
	 * @param out                 输出流
	 * @param isCloseInputStream  处理完成后是否关闭输入流
	 * @param isCloseOutputStream 处理完成后是否关闭输出流
	 * @throws IOException
	 * @return: void
	 */
	public static void copy(InputStream src, OutputStream out, boolean isCloseInputStream, boolean isCloseOutputStream)
			throws IOException {
		byte[] b = new byte[1024];
		int i = 0;
		while ((i = src.read(b)) > -1) {
			out.write(b);
		}
		if (isCloseInputStream) {
			System.out.println("关闭了输入流");
		}
		if (isCloseOutputStream) {
			System.out.println("关闭了输出流");
		}
	}

	/**
	 * 
	 * @Title: readTextFile
	 * @Description:方法3：传入一个文本文件对象，默认为UTF-8编码，返回该文件内容，要求方法内部调用上面第2个方法拷贝流，结束后第1个方法关闭流
	 * @param src
	 * @return
	 * @throws IOException
	 * @return: String
	 */
	public static String readTextFile(InputStream src) throws IOException {
		OutputStream out = new FileOutputStream("h:/b.txt");
		copy(src, out, true, true);
		return out.toString();
		/*
		 * byte[] b = new byte[1024]; int i = 0; while ((i = src.read(b)) > -1) {
		 * out.write(b); } return out.toString();
		 */
	}

	/**
	 * 
	 * @Title: readTextFile
	 * @Description:方法4：传入文本文件对象，返回该文件内容(3分)，并且要求内部调用上面第3个方法
	 * @param txtFile
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @return: String
	 */
	public static String readTextFile(File txtFile) throws FileNotFoundException, IOException {
		InputStream src = new FileInputStream(txtFile);
		return readTextFile(src);
	}

	/**
	 * 
	 * @Title: readStringFromSystemIn 
	 * @Description:从控制台读取用户输入的字符串。 
	 * @param message
	 * @return
	 * @return: String
	 * @throws IOException 
	 */
	public static String readStringFromSystemIn(String message) throws IOException {
		BufferedWriter b = new BufferedWriter(new FileWriter("h:/b.txt"));
		b.write(message);
		return b.toString();
	}

	/**
	 * 
	 * @Title: readIntFromSystemIn 
	 * @Description: 从控制台读取用户输入的数字
	 * @param message
	 * @return
	 * @return: int
	 * @throws IOException 
	 */
	public static String readIntFromSystemIn(String message) throws IOException{
		BufferedWriter b = new BufferedWriter(new FileWriter("h:/c.txt"));
		b.write(message);
		return b.toString();
	}

}
