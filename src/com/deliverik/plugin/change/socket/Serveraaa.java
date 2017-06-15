package com.deliverik.plugin.change.socket;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;




public class Serveraaa {
	
	/** server监听端口 */
	private static int PORT = 8975;
	public static void main(String[] args) throws Exception {
		
		//实例化server对象
		ServerSocket server = new ServerSocket(PORT);
		while (true) {
			//等待客户端连接
			Socket accept = server.accept();
			
			
			BufferedInputStream in = new BufferedInputStream( accept.getInputStream());
			
			
			/** 上传文件保存 */
			int contents = 0;
			
			
			byte[] newSize = new byte[1];
			 in.read(newSize);
			 int aaqw = newSize[0];
			System.out.println(aaqw);
			
			byte[] isize = new byte[aaqw];
			in.read(isize);
			String assString = new String(isize,0,aaqw);
			System.out.println(assString);
			
			byte[] info = new byte[Integer.parseInt(assString)];
			in.read(info);
			String file_name = new String(info).trim();
			
			String[] acceptMsg = file_name.split("\\(\\#\\)");
			
			
			System.out.println(file_name);
			
			/** 上传文件保存流取得 */
			FileOutputStream out = new FileOutputStream("e:\\"+acceptMsg[23]);
			
			/** 上传文件保存流缓存取得 */
			BufferedOutputStream outBuffer = new BufferedOutputStream(out);
			
			
			byte[] b = new byte[8096];
			
			while ((contents = in.read(b)) !=- 1) {
				outBuffer.write(b,0,contents);
				
			}
			out.flush();
			outBuffer.flush();
			
			//文件流关闭
			outBuffer.close();
			out.close();
			in.close();

		}
	}
}

