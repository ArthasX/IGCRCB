package com.deliverik.infogovernor.adapter;

public class CodeDefinition {
	
	/** �ʼ��趨��Ϣ */
	public final static String MAIL = "152"; 
	/** ����ƽ̨�趨��Ϣ */
	public final static String SMS = "153"; 
	/** LDAP�趨��Ϣ */
	public final static String LDAP = "154"; 
	/** �����趨��Ϣ */
	public final static String BIRT = "155"; 
	/** AD�趨��Ϣ */
	public final static String AD = "158"; 
	
	/** �����ļ�·�� */
	public final static String BIRT_URL = "1";
	
	
	/** �ʼ����͵�ַ */
	public final static String MAIL_FROM = "1"; 
	/** �ʼ�SMTP */
	public final static String MAIL_SMTP = "2"; 
	/** �ʼ��û��� */
	public final static String MAIL_USERNAME = "3"; 
	/** �ʼ����� */
	public final static String MAIL_PASSWORD = "4"; 
	/** �Ƿ����ʼ� */
	public final static String MAIL_IS_SEND = "5"; 
	
	/** SMS_IP_ADDRESS */
	public final static String SMS_IP_ADDRESS = "1"; 
	/** SMS_PORT */
	public final static String SMS_PORT = "2"; 
	/** �Ƿ��Ͷ��� */
	public final static String SMS_IS_SEND = "3"; 
	
	/** ����è�豸���Ӷ˿ں� */
	public final static String SMS_CONN_PORT = "10";
	
	/** ���ż�¼����ʱ�� */
	public final static String SMS_EXP_DATE = "11"; 
	
	/** ���ż�¼����ط����� */
	public final static String SMS_SEND_COUNT = "12"; 
	
	
	/** LocalorizationType */
	public final static String LDAP_LOCALORIZATIONTYPE = "1"; 
	/** AuthorizationType */
	public final static String LDAP_AUTHORIZATIONTYPE = "2"; 
	/** LdapUrl */
	public final static String LDAP_URL = "3"; 
	/** LdapUID */
	public final static String LDAP_UID = "4"; 
	/** LdapNode */
	public final static String LDAP_NODE = "5"; 

	
	/** LocalorizationType */
	public final static String AD_LOCALORIZATIONTYPE = "1"; 
	/** AuthorizationType */
	public final static String AD_AUTHORIZATIONTYPE = "2"; 
	/** ADUrl */
	public final static String AD_URL = "3"; 
	/** ADdomain */
	public final static String AD_DOMAIN = "4"; 
	
	/** ��ά��֤��ҳ���� */
	public final static String INDEX_PERSION = "1"; 
	/** �쵼��ҳ���� */
	public final static String INDEX_MANAGER = "2"; 
	/**������ҳ���� */
	public final static String INDEX_BUSSESS = "3"; 
	/**�Ĳ���Ա���� */
	public final static String INDEX_ITEMS = "4"; 
	/**������Ա���� */
	public final static String INDEX_LOM = "5"; 

	/**�����ģ���趨��Ϣ*/
	public final static String FLOW_TEMP_CCID = "910";
	public final static String FLOW_TEMP_PCCID = "158";
	
	/**�����ģ������*/
	public final static String FLOW_TEMP_INCIDENT = "0001";
	public final static String FLOW_TEMP_PROBLEM = "0002";
	public final static String FLOW_TEMP_CHANGE = "0003";
	public final static String FLOW_TEMP_DEPLOYMENT = "0004";
	public final static String FLOW_TEMP_SERVICE = "0005";
	public final static String FLOW_TEMP_WORK = "0006";
}
