/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * ���ɸ澯SOCKET������
 * @time 2014/06/22
 * @author taoye
 * @version 1.0
 * @mail taoye@deliverik.com
 */
public class IgalarmOperate extends Thread{  
	
	static Log log = LogFactory.getLog(IgalarmOperate.class);
	
	private Socket socket;//socket����
     
	/**
	 * ���ɸ澯SOCKET������ ���췽��
	 * @param socket socket����
	 */
    public IgalarmOperate(Socket socket) {  
    	this.socket=socket;  

    }  
 
    /**
     * ���ɸ澯SOCKET������ ִ�з���
     */
    public void run() {
    	
    	//ȡ�������ļ�·��
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
			//�鿴����Ƿ�����
			prop.load(new FileInputStream(path.toString()));
			//����״̬������ִ���߼�
			if("Y".equals(prop.getProperty("PLUGIN_STATUS"))){
				//��ʼ�����������
		        BufferedReader in = null;  

				BufferedWriter out = null;
		        try {  
					in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));

					out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"));
					String msg = null;
		            while ((msg = in.readLine()) != null) {
		            	log.debug("socket��ȡ��Ϣ��"+msg);
		            	//���ɸ澯���ҵ����DTO����
		            	IGCRC02DTO dto = new IGCRC02DTO();
		            	dto.setMsg(msg);
		                //�����澯��Ϣ
		            	int result = 0;
		                try {
		                	IGAlarmSocketBL igAlarmSocketBL = (IGAlarmSocketBL) WebApplicationSupport.getBean("igAlarmSocketBL");//���ɸ澯���ҵ���߼��ӿ�
		                	result = igAlarmSocketBL.registIgalarm(dto);
							if (result == 0) {
								out.write("0:��Ϣ����ɹ�\r\n");
							} else {
								out.write("1:��Ϣ����ʧ��\r\n");
							}
						} catch (Exception e) {
							if (e.getMessage() != null) {
								out.write(("1:��Ϣ����ʧ��:" + e.getMessage() + "\r\n"));
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
				out.println("9999:�����ѹر�");
				out.close();
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
    	
    	 
    }
}