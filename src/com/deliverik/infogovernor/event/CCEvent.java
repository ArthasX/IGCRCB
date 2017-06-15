/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.event;

import java.io.StringWriter;
import java.io.UnsupportedEncodingException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 * @Description: 短信BEAN
 * @History 2012-10-17 新建
 * @History 2014-07-10  taoye@deliverik.com 修改  
 * 			修改内容： 针对常熟银行短信模版进行修改
 */
public class CCEvent {
	
	/** 手机号集合,手机号之间用;分割 */
	private String smsReceiverMobile;
	
	/** 消息内容 */
	private String smsContent;

	public CCEvent(String phone, String text)
			throws UnsupportedEncodingException {
		this.smsReceiverMobile = phone;
		this.smsContent = text;
	}
	
	/** 短信发送账号 */
	private String systemAccount = "CSOT";
	
	/** 短信发送密码,加密之后的 */
	private String systemPassword = "e10adc3949ba59abbe56e057f20f883e";
	

	/**
	 * 发送短信信息
	 * 发送短信格式：
	 * <?xml version="1.0" encoding="utf-8"?>
	   <sms>
	   	<account>xd</account>
		<password>e10adc3949ba59abbe56e057f20f883e</password>
		<pack uuid="" name="SOCKET_10" sendType="0" startTime="" endTime="" scheduleTime="" deadline="" priority="0" bizType="1" distinctFlag="false" templateNo="">
			<content>下行测试</content>
			<tickets>
				<ticket mobile="13600000001" isVip="false" content=""/>
				<ticket mobile="13600000002" isVip="false" content=""/>
				<ticket mobile="13600000003" isVip="false" content=""/>
			</tickets>
		</pack>
	   </sms>
	   
	 * account:发送账号  对应  systemAccount
	 * password:密码     对应   systemPassword
	 * content:短信内容
	 * mobile:手机号
	 * 
	 */
	public byte[] getMessageBytes() throws Exception {
		//生成消息体
		DocumentBuilderFactory dbf = DocumentBuilderFactory
				.newInstance();
		DocumentBuilder builder = null;
		try {
			builder = dbf.newDocumentBuilder();
		} catch (Exception e) {
		}
		Document doc = builder.newDocument();

		Element root = doc.createElement("sms");
		// 将SMS添加到XML文件中
		doc.appendChild(root);

		// 创建account节点
		Element account = doc.createElement("account");
		root.appendChild(account);
		Text t_Account = doc.createTextNode(systemAccount);
		account.appendChild(t_Account);

		// 创建password节点
		Element password = doc.createElement("password");
		root.appendChild(password);
		Text t_Password = doc
				.createTextNode(systemPassword);
		password.appendChild(t_Password);

		// 创建pack节点
		Element pack = doc.createElement("pack");
		// 批次ID
		pack.setAttribute("uuid", "");
		// 批次名称
		pack.setAttribute("name", "");
		// 发送方式
		// 群发：0
		// 组发：1
		// 模板发送：2
		String sendType = "0";
		pack.setAttribute("sendType", sendType);
		// 发送开始时间
		pack.setAttribute("startTime", "");
		// 发送结束时间
		pack.setAttribute("endTime", "");
		// 计划发送时间
		pack.setAttribute("scheduleTime", "");
		// 信息失效时间
		pack.setAttribute("deadline", "");
		// 信息优先级
		pack.setAttribute("priority", "0");
		// 信息业务类型编号
		pack.setAttribute("bizType", "1");
		// 模板编号
		pack.setAttribute("templateNo", "");
		// 是否过滤重复号码 true:是 false:否
		pack.setAttribute("distinctFlag", "true");

		root.appendChild(pack);

		// 创建content节点
		Element content = doc.createElement("content");
		pack.appendChild(content);
		Text t_Content = doc.createTextNode(smsContent);
		content.appendChild(t_Content);
		
		// 创建tickets节点
		Element tickets = doc.createElement("tickets");
		pack.appendChild(tickets);
		//发送的手机号码 
		String[] allSmsReceiverMobile = smsReceiverMobile.split(";");

		for (int count = 0; count < allSmsReceiverMobile.length; count++) {

			String mySmsReceiverMobile = allSmsReceiverMobile[count];

			// ADD 20140221 chendh 该号码为空号则跳过 
			if (mySmsReceiverMobile == null
					|| "".equals(mySmsReceiverMobile)
					|| " ".equals(mySmsReceiverMobile)
					|| "null".equals(mySmsReceiverMobile)
					|| mySmsReceiverMobile.length() != 11) {
				continue;
			}
			// 创建ticket节点
			Element ticket = doc.createElement("ticket");
			// 手机号
			ticket.setAttribute("mobile", allSmsReceiverMobile[count]);
			// 是否VIP
			ticket.setAttribute("isVip", "false");
			// 内容
			ticket.setAttribute("content", "");

			tickets.appendChild(ticket);
		}
		String smsXMLStr = this.xml2String(doc);
		// 在消息体前面添加消息头
		smsXMLStr = this.AddMessageHeaser(smsXMLStr);
		//生成报文
		return smsXMLStr.toString().getBytes("UTF-8");
	}
	
	/**
	 * 添加消息头
	 * 
	 * @param str 报文信息
	 * @return
	 */
	private String AddMessageHeaser(String str) {
		// 消息头固定8字符
		try {
			String lenStr = "00000000"
					+ String.valueOf(str.getBytes("UTF-8").length + 8);

			lenStr = lenStr.substring(lenStr.length() - 8);

			str = lenStr + str;
		} catch (Exception e) {

		}

		return str;
	}
	
	/**
	 * XML转成String
	 */
	private String xml2String(Document doc) {

		StringWriter writer = new StringWriter();

		DOMSource doms = new DOMSource(doc);
		StreamResult sr = new StreamResult(writer);

		try {
			TransformerFactory.newInstance().newTransformer().transform(doms,sr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return writer.toString();

	}
}
