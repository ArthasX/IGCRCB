package com.deliverik.infogovernor.adapter;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.utility.CodeListUtils;
import com.deliverik.infogovernor.util.StringEncrypt;

public class MailAdapter {
	
	private static final Log log = LogFactory.getLog(MailAdapter.class);
	private static MailAdapter inst = null;
	
	public static MailAdapter getInstance() {
		if(null == inst){
			inst = new MailAdapter();
		}
		return inst;
	}
	
	private MailAdapter(){}
	
	public int sendMail(String title, String content, String[] receiverArr, String[]... ccAndBcc) {
		
		CodeListUtils ctlBL = (CodeListUtils) WebApplicationSupport.getBean("codeListUtils");
		String strFrom = ctlBL.getCodeValue(CodeDefinition.MAIL, "", "", CodeDefinition.MAIL_FROM);
		String smtp = ctlBL.getCodeValue(CodeDefinition.MAIL, "", "", CodeDefinition.MAIL_SMTP);
		String username = ctlBL.getCodeValue(CodeDefinition.MAIL, "", "", CodeDefinition.MAIL_USERNAME);
		String password = ctlBL.getCodeValue(CodeDefinition.MAIL, "", "", CodeDefinition.MAIL_PASSWORD);
		password = StringEncrypt.asciiToChar(password);
		
		Properties props = new Properties();
		props.put("mail.smtp.host", smtp);// �洢�����ʼ�����������Ϣ
		props.put("mail.smtp.auth", "true");// ͬʱͨ����֤
		Session s = Session.getInstance(props, null);
		
		s.setDebug(false);
		Message message = new MimeMessage(s);
		try {
			message.setSubject(title);
		} catch (MessagingException e) {
			log.error("�ʼ������쳣", e);
			return 0;
		}
		try {
			message.setContent(content, "text/html;charset=utf-8");
		} catch (MessagingException e) {
			log.error("�ʼ������쳣", e);
			return 0;
		}
		try {
			message.saveChanges();
		} catch (MessagingException e) {
			log.error("�ʼ��洢�쳣", e);
			return 0;
		}
		Address from = null;
		try {
			from = new InternetAddress(strFrom);
		} catch (AddressException e) {
			log.error("�ʼ����͵�ַ�쳣", e);
			return 0;
		}
		try {
			message.setFrom(from);
		} catch (MessagingException e) {
			log.error("�ʼ����͵�ַ�쳣", e);
			return 0;
		}
		
		InternetAddress[] TOAddress = new InternetAddress[receiverArr.length];
		for (int i = 0; i < receiverArr.length; i++) {
			try {
				TOAddress[i] = new InternetAddress(receiverArr[i]);
			} catch (AddressException e) {
				log.error("�ʼ��ռ��˵�ַ�쳣", e);
				return 0;
			}
		}
		try {
			message.setRecipients(Message.RecipientType.TO, TOAddress);
		} catch (MessagingException e) {
			log.error("�ʼ��ռ��˵�ַ�쳣", e);
			return 0;
		}
		
		if(ccAndBcc != null && ccAndBcc.length > 0 && ccAndBcc[0] != null){
			InternetAddress[] CCAddress = new InternetAddress[ccAndBcc[0].length];
			for (int i = 0; i < ccAndBcc[0].length; i++) {
				try {
					CCAddress[i] = new InternetAddress(ccAndBcc[0][i]);
				} catch (AddressException e) {
					log.error("�ʼ������˵�ַ�쳣", e);
				}
			}
			try {
				message.setRecipients(Message.RecipientType.CC, CCAddress);
			} catch (MessagingException e) {
				log.error("�ʼ������˵�ַ�쳣", e);
			}
		}
		
		if(ccAndBcc != null && ccAndBcc.length > 1 && ccAndBcc[1] != null){
			InternetAddress[] BCCAddress = new InternetAddress[ccAndBcc[1].length];
			for (int i = 0; i < ccAndBcc[1].length; i++) {
				try {
					BCCAddress[i] = new InternetAddress(ccAndBcc[1][i]);
				} catch (AddressException e) {
					log.error("�ʼ������˵�ַ�쳣", e);
					return 0;
				}
			}
			try {
				message.setRecipients(Message.RecipientType.BCC, BCCAddress);
			} catch (MessagingException e) {
				log.error("�ʼ������˵�ַ�쳣", e);
				return 0;
			}
		}
		
		Transport transport = null;
		try {
			transport = s.getTransport("smtp");
		} catch (NoSuchProviderException e) {
			log.error("�ʼ���֧��SMTP����", e);
			return 0;
		}
		
		try {
			transport.connect(smtp, username, password);
		} catch (MessagingException e) {
			log.error("�ʼ������������쳣", e);
			return 0;
		}
		try {
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		} catch (MessagingException e) {
			log.error("�ʼ������쳣", e);
			return 0;
		}
		log.debug("�ʼ����ͳɹ�");
		return 0;
	}
}
