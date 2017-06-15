package com.deliverik.infogovernor.adapter;

import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import com.deliverik.framework.utility.IGStringUtils;

public class Server {

	public static void main(String[] args) {
		ServerSocket server = null;
		Socket socket = null;
		InputStream is = null;
		PrintWriter out = null;
		try {
			System.out.println("begin.........");
			server = new ServerSocket(9899);
			while (true) {
				socket = server.accept();
				is = socket.getInputStream();
				out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
				//out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "GB2312"));
				StringBuffer sbf = new StringBuffer();
				int bufferSize = 8192;
	            byte[] buf = new byte[bufferSize];
				if (is.read(buf) != -1) {
					sbf.append(new String(buf, "GB2312"));
				}
				System.out.println("start================"+IGStringUtils.getCurrentDateTime());
				System.out.println(sbf.toString());
				System.out.println("end================"+IGStringUtils.getCurrentDateTime());
				out.println("1234<hsiss><respcode>ISS0000</respcode><respmsg>³É¹¦</respmsg>");
				out.println("</hsiss>");
				out.close();
				is.close();
				socket.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
