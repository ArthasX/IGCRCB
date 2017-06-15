/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.plugin.change.socket;
  
import java.io.IOException;  
import java.net.ServerSocket;  
import java.net.Socket;  

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/***
 * 流程日志实体socket线程
 * @time 2015/07/08
 * @author zhangqiang
 * @version 1.0
 * @mail zhangqiang@deliverik.com
 */
public class ChangeThread extends Thread{
	
	static Log log = LogFactory.getLog(ChangeThread.class);
	
	public ServerSocket serverSocket = null;//socket服务器实例对象
	
	private static int port=8976;//端口号

	/**
	 * 流程日志实体socket线程 构造方法
	 * @param serverScoket socket服务器实例对象
	 */
	public ChangeThread(ServerSocket serverScoket){  
		try {
			//不存在socket服务器实例对象，进行创建
			if(null == serverSocket){  
				System.out.println("流程日志实体启动成功");
				serverSocket = new ServerSocket(port);  
				log.debug("流程日志实体socket服务启动");  
			}  
		} catch (Exception e) {  
			log.error("流程日志实体socket服务启动出错");  
			log.error(e.getMessage());
		}  

	}  
  
	/**
	 * 流程日志实体socket线程 执行操作
	 */
	public void run(){  
		//如果线程没有中断
		while(!this.isInterrupted()){  
			try {  
				//接收客户端socket连接
				Socket socket = serverSocket.accept();  
				
				if(null != socket && !socket.isClosed()){     
					//处理接受的数据  
					new ChangeOperate(socket).start();  
				}  
				
			}catch (Exception e) {  
				e.printStackTrace();  
			}  
		}  
	}  
   
	/**
	 * 流程日志实体socket线程 终止操作
	 */
	public void close(){  
		try {  
			//判断是否存在socket服务器实例对象
			if(null!=serverSocket && !serverSocket.isClosed())  
			{  
				serverSocket.close();  
				log.debug("流程日志实体socket服务关闭"); 
			}  
		} catch (IOException e) {  
			log.error("流程日志实体socket服务关闭出错");  
			log.error(e.getMessage());
		}  
	}  
} 