/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * @Description: ����BEAN
 * @History 2012-10-17 �½�
 * @History 2014-07-10  taoye@deliverik.com �޸�  
 * 			�޸����ݣ� ��Գ������ж���ģ������޸�
 */
public class CCEvent {
	
	/** �ֻ��ż���,�ֻ���֮����;�ָ� */
	private String smsReceiverMobile;
	
	/** ��Ϣ���� */
	private String smsContent;

	public CCEvent(String phone, String text)
			throws UnsupportedEncodingException {
		this.smsReceiverMobile = phone;
		this.smsContent = text;
	}
	
	/** ���ŷ����˺� */
	private String systemAccount = "CSOT";
	
	/** ���ŷ�������,����֮��� */
	private String systemPassword = "e10adc3949ba59abbe56e057f20f883e";
	

	/**
	 * ���Ͷ�����Ϣ
	 * ���Ͷ��Ÿ�ʽ��
	 * <?xml version="1.0" encoding="utf-8"?>
	   <sms>
	   	<account>xd</account>
		<password>e10adc3949ba59abbe56e057f20f883e</password>
		<pack uuid="" name="SOCKET_10" sendType="0" startTime="" endTime="" scheduleTime="" deadline="" priority="0" bizType="1" distinctFlag="false" templateNo="">
			<content>���в���</content>
			<tickets>
				<ticket mobile="13600000001" isVip="false" content=""/>
				<ticket mobile="13600000002" isVip="false" content=""/>
				<ticket mobile="13600000003" isVip="false" content=""/>
			</tickets>
		</pack>
	   </sms>
	   
	 * account:�����˺�  ��Ӧ  systemAccount
	 * password:����     ��Ӧ   systemPassword
	 * content:��������
	 * mobile:�ֻ���
	 * 
	 */
	public byte[] getMessageBytes() throws Exception {
		//������Ϣ��
		DocumentBuilderFactory dbf = DocumentBuilderFactory
				.newInstance();
		DocumentBuilder builder = null;
		try {
			builder = dbf.newDocumentBuilder();
		} catch (Exception e) {
		}
		Document doc = builder.newDocument();

		Element root = doc.createElement("sms");
		// ��SMS��ӵ�XML�ļ���
		doc.appendChild(root);

		// ����account�ڵ�
		Element account = doc.createElement("account");
		root.appendChild(account);
		Text t_Account = doc.createTextNode(systemAccount);
		account.appendChild(t_Account);

		// ����password�ڵ�
		Element password = doc.createElement("password");
		root.appendChild(password);
		Text t_Password = doc
				.createTextNode(systemPassword);
		password.appendChild(t_Password);

		// ����pack�ڵ�
		Element pack = doc.createElement("pack");
		// ����ID
		pack.setAttribute("uuid", "");
		// ��������
		pack.setAttribute("name", "");
		// ���ͷ�ʽ
		// Ⱥ����0
		// �鷢��1
		// ģ�巢�ͣ�2
		String sendType = "0";
		pack.setAttribute("sendType", sendType);
		// ���Ϳ�ʼʱ��
		pack.setAttribute("startTime", "");
		// ���ͽ���ʱ��
		pack.setAttribute("endTime", "");
		// �ƻ�����ʱ��
		pack.setAttribute("scheduleTime", "");
		// ��ϢʧЧʱ��
		pack.setAttribute("deadline", "");
		// ��Ϣ���ȼ�
		pack.setAttribute("priority", "0");
		// ��Ϣҵ�����ͱ��
		pack.setAttribute("bizType", "1");
		// ģ����
		pack.setAttribute("templateNo", "");
		// �Ƿ�����ظ����� true:�� false:��
		pack.setAttribute("distinctFlag", "true");

		root.appendChild(pack);

		// ����content�ڵ�
		Element content = doc.createElement("content");
		pack.appendChild(content);
		Text t_Content = doc.createTextNode(smsContent);
		content.appendChild(t_Content);
		
		// ����tickets�ڵ�
		Element tickets = doc.createElement("tickets");
		pack.appendChild(tickets);
		//���͵��ֻ����� 
		String[] allSmsReceiverMobile = smsReceiverMobile.split(";");

		for (int count = 0; count < allSmsReceiverMobile.length; count++) {

			String mySmsReceiverMobile = allSmsReceiverMobile[count];

			// ADD 20140221 chendh �ú���Ϊ�պ������� 
			if (mySmsReceiverMobile == null
					|| "".equals(mySmsReceiverMobile)
					|| " ".equals(mySmsReceiverMobile)
					|| "null".equals(mySmsReceiverMobile)
					|| mySmsReceiverMobile.length() != 11) {
				continue;
			}
			// ����ticket�ڵ�
			Element ticket = doc.createElement("ticket");
			// �ֻ���
			ticket.setAttribute("mobile", allSmsReceiverMobile[count]);
			// �Ƿ�VIP
			ticket.setAttribute("isVip", "false");
			// ����
			ticket.setAttribute("content", "");

			tickets.appendChild(ticket);
		}
		String smsXMLStr = this.xml2String(doc);
		// ����Ϣ��ǰ�������Ϣͷ
		smsXMLStr = this.AddMessageHeaser(smsXMLStr);
		//���ɱ���
		return smsXMLStr.toString().getBytes("UTF-8");
	}
	
	/**
	 * �����Ϣͷ
	 * 
	 * @param str ������Ϣ
	 * @return
	 */
	private String AddMessageHeaser(String str) {
		// ��Ϣͷ�̶�8�ַ�
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
	 * XMLת��String
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
