package com.deliverik.infogovernor.adapter;

public class CodeDefinition {
	
	/** 邮件设定信息 */
	public final static String MAIL = "152"; 
	/** 短信平台设定信息 */
	public final static String SMS = "153"; 
	/** LDAP设定信息 */
	public final static String LDAP = "154"; 
	/** 报表设定信息 */
	public final static String BIRT = "155"; 
	/** AD设定信息 */
	public final static String AD = "158"; 
	
	/** 报表文件路径 */
	public final static String BIRT_URL = "1";
	
	
	/** 邮件发送地址 */
	public final static String MAIL_FROM = "1"; 
	/** 邮件SMTP */
	public final static String MAIL_SMTP = "2"; 
	/** 邮件用户名 */
	public final static String MAIL_USERNAME = "3"; 
	/** 邮件密码 */
	public final static String MAIL_PASSWORD = "4"; 
	/** 是否发送邮件 */
	public final static String MAIL_IS_SEND = "5"; 
	
	/** SMS_IP_ADDRESS */
	public final static String SMS_IP_ADDRESS = "1"; 
	/** SMS_PORT */
	public final static String SMS_PORT = "2"; 
	/** 是否发送短信 */
	public final static String SMS_IS_SEND = "3"; 
	
	/** 短信猫设备连接端口号 */
	public final static String SMS_CONN_PORT = "10";
	
	/** 短信记录过期时间 */
	public final static String SMS_EXP_DATE = "11"; 
	
	/** 短信记录最大重发次数 */
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
	
	/** 运维保证首页设置 */
	public final static String INDEX_PERSION = "1"; 
	/** 领导首页设置 */
	public final static String INDEX_MANAGER = "2"; 
	/**处长首页设置 */
	public final static String INDEX_BUSSESS = "3"; 
	/**耗材人员设置 */
	public final static String INDEX_ITEMS = "4"; 
	/**后勤人员设置 */
	public final static String INDEX_LOM = "5"; 

	/**流程填报模板设定信息*/
	public final static String FLOW_TEMP_CCID = "910";
	public final static String FLOW_TEMP_PCCID = "158";
	
	/**流程填报模板类型*/
	public final static String FLOW_TEMP_INCIDENT = "0001";
	public final static String FLOW_TEMP_PROBLEM = "0002";
	public final static String FLOW_TEMP_CHANGE = "0003";
	public final static String FLOW_TEMP_DEPLOYMENT = "0004";
	public final static String FLOW_TEMP_SERVICE = "0005";
	public final static String FLOW_TEMP_WORK = "0006";
}
