package com.deliverik.infogovernor.adapter;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.utility.CodeListUtils;
import com.deliverik.infogovernor.event.CCEvent;

public class CCSmsAdapter {
	static Log log = LogFactory.getLog(CCSmsAdapter.class);
	private String ipAddress;
	private Integer port;
	public static CodeListUtils ctlBL = (CodeListUtils) WebApplicationSupport.getBean("codeListUtils");
	
	public CCSmsAdapter(){
		initServerInfo();
	}
	
	public static CCSmsAdapter getOnly() {
		return new CCSmsAdapter();
	}
	
	/**
	 * ��ʼ�����ŷ�������Ϣ
	 */
	private void initServerInfo(){
		if(ipAddress==null||"".equals(ipAddress)){
			String ipAddress = ctlBL.getCodeValue(CodeDefinition.SMS, "", "", CodeDefinition.SMS_IP_ADDRESS);
			setIpAddress(ipAddress);
		}
		if(port==null||"".equals(port)){
			String port = ctlBL.getCodeValue(CodeDefinition.SMS, "", "", CodeDefinition.SMS_PORT);
			setPort(Integer.parseInt(port));
		}
	}
	
	private void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	private void setPort(Integer port) {
		this.port = port;
	}

	
	/**
	 * ���ر��ĸ�ʽ��
	 * 	00000164<?xml version="1.0" encoding="UTF-8"?>
	 *	<sms>
	 *		<returncode>0</returncode>  <!�������� -->
	 *		<returnmsg>�ɹ�</returnmsg> <!���������� -->
	 *	</sms>
	 * ���ؽ����
	 * 0:�ɹ�
	 * 0000��û���ͣ�Ҳû���쳣���������������֣�
	 * 9999�����Ͷ����쳣
	 * 9998���绰��Ϊ��
	 * 9997����ϢΪ��
	 */
	public String send(String telephone, String message){
		String res = "";
		if(null == telephone || "".equals(telephone.trim())){
			res = "9998";
		}else if(null == message || "".equals(message.trim())){
			res = "9997";
		}else{
			Socket socket = null;
			OutputStream os = null;
			InputStream is = null;
			BufferedReader buf = null;
			String result = null;
			String returnStr = null;
			try {
				CCEvent cc = new CCEvent(telephone, message);
				socket = new Socket(ipAddress, port);
				socket.setSoTimeout(1000*30);
				os = socket.getOutputStream();
				is = socket.getInputStream();
				os.write(cc.getMessageBytes());
				os.flush();
				buf = new BufferedReader(new InputStreamReader(is,"UTF-8"));
				while((result = buf.readLine()) != null){
					returnStr += result.trim();
					if("</sms>".equals(result.trim())) {
						break;
					}
				}
				//��ȡ������
				int startIndex = returnStr.indexOf("<returncode>");

				res = returnStr.substring(startIndex + 12,
						startIndex + 13);	
				
			} catch (Exception e) {
				res = "9999";				
				log.error("���ŷ����쳣", e);
			} finally {
				try{
					if(os != null) {
						os.close();
					}
					if(buf != null) {
						buf.close();
					}
					if(socket!=null){
						socket.close();
					}
				}catch(Exception e1){
					res = "9999";
					log.error("���ŷ����쳣", e1);
				}
			}
		}
		if(StringUtils.isEmpty(res)) {
			res = "0000";
			return res;
		} else {
			return res;
		}
	}
	
	public static void main(String[] args) throws Exception{
		System.out.println(CCSmsAdapter.getOnly().send("12345678900", "����"));
	}
}
