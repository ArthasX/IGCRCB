package com.deliverik.plugin.alarmSocket.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
  
public class IgalarmClient {  
	
	private static String ip = "192.168.0.153";
	
	private static int port = 60002;
	
    public static void main(String[] args) throws Exception {  
    	//创建socket连接
        Socket socket = new Socket(ip, port);
        //获取输入输出流
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));  
        PrintWriter out = new PrintWriter(socket.getOutputStream());  
   
        //String msg = "二代支付PMTS前置-主 （160.100.100.1） （789902） MQ通道状态异常 2014-6-17 18:09:09";
//        String msg = "二代支付PMTS前置-主 （160.100.100.1） （789902） MQ通道状态异常[事件已关闭] 2014-6-17 21:09:09";
		String msg = "测试告警20140910|（160.100.105.81）|（4444333）|MQ通道状态异常|2016-09-22 18:01:09|联系人|1";
        out.println(msg);  
        out.flush();
        System.out.println(in.readLine());
            
        socket.close();  
    }  
}  

