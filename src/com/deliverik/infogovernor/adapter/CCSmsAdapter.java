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
	 * 初始化短信服务器信息
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
	 * 返回报文格式：
	 * 	00000164<?xml version="1.0" encoding="UTF-8"?>
	 *	<sms>
	 *		<returncode>0</returncode>  <!—返回码 -->
	 *		<returnmsg>成功</returnmsg> <!—返回内容 -->
	 *	</sms>
	 * 返回结果：
	 * 0:成功
	 * 0000：没法送，也没有异常（这种情况不会出现）
	 * 9999：发送短信异常
	 * 9998：电话号为空
	 * 9997：消息为空
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
				//获取返回码
				int startIndex = returnStr.indexOf("<returncode>");

				res = returnStr.substring(startIndex + 12,
						startIndex + 13);	
				
			} catch (Exception e) {
				res = "9999";				
				log.error("短信发送异常", e);
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
					log.error("短信发送异常", e1);
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
		System.out.println(CCSmsAdapter.getOnly().send("12345678900", "测试"));
	}
}
