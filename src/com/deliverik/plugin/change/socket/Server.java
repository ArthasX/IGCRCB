package com.deliverik.plugin.change.socket;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	/** server监听端口 */
	private static int PORT = 8975;
	public static void main(String[] args) throws Exception {
		
		//实例化server对象
		ServerSocket server = new ServerSocket(PORT);
		while (true) {
			//等待客户端连接
			Socket accept = server.accept();
			BufferedReader in = new BufferedReader(new InputStreamReader(accept.getInputStream()));
			FileOutputStream fos = null;
			PrintWriter out = new PrintWriter(accept.getOutputStream());  
			String line = null;
			String fileName = "";
			String flag = "";
			String text ="";
			String text1 ="";
			while ((line = in.readLine()) != null) {
				if("file".equals(flag)){
					if("file-content-end".equals(line)){
						flag = "";
						//fos.close();
					}else{
						fos.write(line.getBytes());
					}
				}else{
					if(line.startsWith("filename:")){
						fileName = line.replace("filename:", "");
					}else if("file-content-start".equals(line)){
						flag = "file";
						fos = new FileOutputStream("e:\\" + fileName);
					}else if("exit".equals(line)){
						in.close();
						  //回应客户端信息
		                if(text1.equals("textEnd")){
		                	out.println("0:信息处理成功");
		                }else{
		                	out.println("1:信息处理失败");
		                }
		                out.flush();
						break;
					}
					else{
						
						if (line.startsWith("textStart:")) {
							text = line.replace("textStart:", "");
							System.out.println("报文信息："+text);
						}
						if(line.endsWith("textEnd")){
							text1 = line;
							System.out.println("报文信息："+text1);
						}
						
														
						
					}
				}
			}
		}
	}
}

