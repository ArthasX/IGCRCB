/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.plugin.alarmSocket.socket;
  
import java.io.IOException;  
import java.net.ServerSocket;  
import java.net.Socket;  

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/***
 * 集成告警socket线程
 * @time 2014/06/22
 * @author taoye
 * @version 1.0
 * @mail taoye@deliverik.com
 */
public class IgalarmThread extends Thread{
	
	static Log log = LogFactory.getLog(IgalarmThread.class);
	
	public ServerSocket serverSocket = null;//socket服务器实例对象
	
	private static int port=60002;//端口号

	/**
	 * 集成告警socket线程 构造方法
	 * @param serverScoket socket服务器实例对象
	 */
	public IgalarmThread(ServerSocket serverScoket){  
		try {
			//不存在socket服务器实例对象，进行创建
			if(null == serverSocket){  
				serverSocket = new ServerSocket(port);  
				log.debug("集成告警socket服务启动");  
			}  
		} catch (Exception e) {  
			log.error("集成告警socket服务启动出错");  
			log.error(e.getMessage());
		}  

	}  
  
	/**
	 * 集成告警socket线程 执行操作
	 */
	public void run(){  
		//如果线程没有中断
		while(!this.isInterrupted()){  
			try {  
				//接收客户端socket连接
				Socket socket = serverSocket.accept();  
				
				if(null != socket && !socket.isClosed()){     
					//处理接受的数据  
					new IgalarmOperate(socket).start();  
				}  
				
			}catch (Exception e) {  
				e.printStackTrace();  
			}  
		}  
	}  
   
	/**
	 * 集成告警socket线程 终止操作
	 */
	public void close(){  
		try {  
			//判断是否存在socket服务器实例对象
			if(null!=serverSocket && !serverSocket.isClosed())  
			{  
				serverSocket.close();  
				log.debug("集成告警socket服务关闭"); 
			}  
		} catch (IOException e) {  
			log.error("集成告警socket服务关闭出错");  
			log.error(e.getMessage());
		}  
	}  
} 