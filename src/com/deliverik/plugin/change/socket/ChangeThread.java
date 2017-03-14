/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.plugin.change.socket;
  
import java.io.IOException;  
import java.net.ServerSocket;  
import java.net.Socket;  

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/***
 * ������־ʵ��socket�߳�
 * @time 2015/07/08
 * @author zhangqiang
 * @version 1.0
 * @mail zhangqiang@deliverik.com
 */
public class ChangeThread extends Thread{
	
	static Log log = LogFactory.getLog(ChangeThread.class);
	
	public ServerSocket serverSocket = null;//socket������ʵ������
	
	private static int port=8976;//�˿ں�

	/**
	 * ������־ʵ��socket�߳� ���췽��
	 * @param serverScoket socket������ʵ������
	 */
	public ChangeThread(ServerSocket serverScoket){  
		try {
			//������socket������ʵ�����󣬽��д���
			if(null == serverSocket){  
				System.out.println("������־ʵ�������ɹ�");
				serverSocket = new ServerSocket(port);  
				log.debug("������־ʵ��socket��������");  
			}  
		} catch (Exception e) {  
			log.error("������־ʵ��socket������������");  
			log.error(e.getMessage());
		}  

	}  
  
	/**
	 * ������־ʵ��socket�߳� ִ�в���
	 */
	public void run(){  
		//����߳�û���ж�
		while(!this.isInterrupted()){  
			try {  
				//���տͻ���socket����
				Socket socket = serverSocket.accept();  
				
				if(null != socket && !socket.isClosed()){     
					//������ܵ�����  
					new ChangeOperate(socket).start();  
				}  
				
			}catch (Exception e) {  
				e.printStackTrace();  
			}  
		}  
	}  
   
	/**
	 * ������־ʵ��socket�߳� ��ֹ����
	 */
	public void close(){  
		try {  
			//�ж��Ƿ����socket������ʵ������
			if(null!=serverSocket && !serverSocket.isClosed())  
			{  
				serverSocket.close();  
				log.debug("������־ʵ��socket����ر�"); 
			}  
		} catch (IOException e) {  
			log.error("������־ʵ��socket����رճ���");  
			log.error(e.getMessage());
		}  
	}  
} 