package com.deliverik.plugin.change.socket;

import java.io.BufferedReader;  
import java.io.InputStreamReader;  
import java.io.PrintWriter;  
import java.net.Socket;  
  
public class ChangeClient {  
	
	private static String ip = "127.0.0.1";
	
	private static int port = 8976;
	
    public static void main(String[] args) throws Exception {  
    	//����socket����
        Socket socket = new Socket(ip, port);
        //��ȡ���������
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));  
        PrintWriter out = new PrintWriter(socket.getOutputStream());  
   
        //String msg = "����֧��PMTSǰ��-�� ��160.100.100.1�� ��789902�� MQͨ��״̬�쳣 2014-6-17 18:09:09";
//        String msg = "����֧��PMTSǰ��-�� ��160.100.100.1�� ��789902�� MQͨ��״̬�쳣[�¼��ѹر�] 2014-6-17 21:09:09";
        String msg = "���Ը澯20140910|��160.100.100.1��|��789913��|MQͨ��״̬�쳣|2014-07-17 18:01:09|��ϵ��";
        out.println(msg);  
        out.flush();
//        System.out.println(in.readLine());
            
        socket.close();  
    }  
}  

