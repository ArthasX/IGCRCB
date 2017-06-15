/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.plugin.alarmSocket.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.infogovernor.crc.dto.IGCRC02DTO;
import com.deliverik.plugin.alarmSocket.bl.IGAlarmSocketBL;
import com.system.plugins.utils.PluginsDataUtils;

/***
 * 集成告警SOCKET操作类
 * @time 2014/06/22
 * @author taoye
 * @version 1.0
 * @mail taoye@deliverik.com
 */
public class IgalarmOperate extends Thread{  
	
	static Log log = LogFactory.getLog(IgalarmOperate.class);
	
	private Socket socket;//socket对象
     
	/**
	 * 集成告警SOCKET操作类 构造方法
	 * @param socket socket对象
	 */
    public IgalarmOperate(Socket socket) {  
    	this.socket=socket;  

    }  
 
    /**
     * 集成告警SOCKET操作类 执行方法
     */
    public void run() {
    	
    	//取得配置文件路径
    	PluginsDataUtils pdUtil = new PluginsDataUtils();
    	StringBuffer path = new StringBuffer();
    	path.append(pdUtil.getAbsolutePathByClass());
    	path.append(File.separator);
    	path.append("WEB-INF");
    	path.append(File.separator);
    	path.append("plugin");
    	path.append(File.separator);
    	path.append("alarmSocket");
    	path.append(File.separator);
    	path.append("config");
    	path.append(File.separator);
    	path.append("config.properties");
    	Properties prop = new Properties();
    	
    	try {
			//查看插件是否启用
			prop.load(new FileInputStream(path.toString()));
			//启用状态下正常执行逻辑
			if("Y".equals(prop.getProperty("PLUGIN_STATUS"))){
				//初始化输入输出流
		        BufferedReader in = null;  

				BufferedWriter out = null;
		        try {  
					in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));

					out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"));
					String msg = null;
		            while ((msg = in.readLine()) != null) {
		            	log.debug("socket获取信息："+msg);
		            	//集成告警相关业务用DTO创建
		            	IGCRC02DTO dto = new IGCRC02DTO();
		            	dto.setMsg(msg);
		                //新增告警信息
		            	int result = 0;
		                try {
		                	IGAlarmSocketBL igAlarmSocketBL = (IGAlarmSocketBL) WebApplicationSupport.getBean("igAlarmSocketBL");//集成告警相关业务逻辑接口
		                	result = igAlarmSocketBL.registIgalarm(dto);
							if (result == 0) {
								out.write("0:信息处理成功\r\n");
							} else {
								out.write("1:信息处理失败\r\n");
							}
						} catch (Exception e) {
							if (e.getMessage() != null) {
								out.write(("1:信息处理失败:" + e.getMessage() + "\r\n"));
								e.printStackTrace();
								log.error(e.getMessage());
							}
						} finally {
							out.flush();

						}

		            }  
		        } catch(IOException ex) {  
		        	log.error(ex.getMessage());
		        } finally {  
		            try {  
		                in.close();  
		            } catch (Exception e) {}  
		            try {  
		                out.close();  
		           } catch (Exception e) {}  
		            try {  
		            	socket.close();  
		            } catch (Exception e) {}  
		        } 
			}else{
				PrintWriter out = new PrintWriter(socket.getOutputStream());
				out.println("9999:服务已关闭");
				out.close();
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
    	
    	 
    }
}