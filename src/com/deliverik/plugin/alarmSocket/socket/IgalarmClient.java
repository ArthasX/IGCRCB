package com.deliverik.plugin.alarmSocket.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
  
public class IgalarmClient {  
	
	private static String ip = "192.168.0.153";
	
	private static int port = 60002;
	
    public static void main(String[] args) throws Exception {  
    	//����socket����
        Socket socket = new Socket(ip, port);
        //��ȡ���������
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));  
        PrintWriter out = new PrintWriter(socket.getOutputStream());  
   
        //String msg = "����֧��PMTSǰ��-�� ��160.100.100.1�� ��789902�� MQͨ��״̬�쳣 2014-6-17 18:09:09";
//        String msg = "����֧��PMTSǰ��-�� ��160.100.100.1�� ��789902�� MQͨ��״̬�쳣[�¼��ѹر�] 2014-6-17 21:09:09";
		String msg = "���Ը澯20140910|��160.100.105.81��|��4444333��|MQͨ��״̬�쳣|2016-09-22 18:01:09|��ϵ��|1";
        out.println(msg);  
        out.flush();
        System.out.println(in.readLine());
            
        socket.close();  
    }  
}  

