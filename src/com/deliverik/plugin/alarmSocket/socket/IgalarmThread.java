/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.plugin.alarmSocket.socket;
  
import java.io.IOException;  
import java.net.ServerSocket;  
import java.net.Socket;  

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/***
 * ���ɸ澯socket�߳�
 * @time 2014/06/22
 * @author taoye
 * @version 1.0
 * @mail taoye@deliverik.com
 */
public class IgalarmThread extends Thread{
	
	static Log log = LogFactory.getLog(IgalarmThread.class);
	
	public ServerSocket serverSocket = null;//socket������ʵ������
	
	private static int port=60002;//�˿ں�

	/**
	 * ���ɸ澯socket�߳� ���췽��
	 * @param serverScoket socket������ʵ������
	 */
	public IgalarmThread(ServerSocket serverScoket){  
		try {
			//������socket������ʵ�����󣬽��д���
			if(null == serverSocket){  
				serverSocket = new ServerSocket(port);  
				log.debug("���ɸ澯socket��������");  
			}  
		} catch (Exception e) {  
			log.error("���ɸ澯socket������������");  
			log.error(e.getMessage());
		}  

	}  
  
	/**
	 * ���ɸ澯socket�߳� ִ�в���
	 */
	public void run(){  
		//����߳�û���ж�
		while(!this.isInterrupted()){  
			try {  
				//���տͻ���socket����
				Socket socket = serverSocket.accept();  
				
				if(null != socket && !socket.isClosed()){     
					//������ܵ�����  
					new IgalarmOperate(socket).start();  
				}  
				
			}catch (Exception e) {  
				e.printStackTrace();  
			}  
		}  
	}  
   
	/**
	 * ���ɸ澯socket�߳� ��ֹ����
	 */
	public void close(){  
		try {  
			//�ж��Ƿ����socket������ʵ������
			if(null!=serverSocket && !serverSocket.isClosed())  
			{  
				serverSocket.close();  
				log.debug("���ɸ澯socket����ر�"); 
			}  
		} catch (IOException e) {  
			log.error("���ɸ澯socket����رճ���");  
			log.error(e.getMessage());
		}  
	}  
} 