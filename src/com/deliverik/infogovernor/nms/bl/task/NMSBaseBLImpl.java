/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.nms.bl.task;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;

import com.deliverik.infogovernor.nms.model.NMS02Info;


/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: NMSBL����ʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class NMSBaseBLImpl implements NMSBaseBL {
	
	/** �豸����map */
	protected static Map<String, String> deviceTypeMap = new HashMap<String, String>();

	/** ��ID */
    public static Integer GROUPID_DEFAULT = 1;
    
    /** �������ͣ�IP�� */
    public static String TaskType_IP = "1";
    
    /** �������ͣ����� */
    public static String TaskType_SubNet = "2";
    
    /** �������ͣ�ָ��·�� */
    public static String TaskType_Route = "3";
    
	/** �汾 */
	protected Integer version;
	
	static{
		deviceTypeMap.put("AIX����", "0");
		deviceTypeMap.put("LINUX����", "1");
		deviceTypeMap.put("WIN����", "2");
		deviceTypeMap.put("������", "3");
		deviceTypeMap.put("·����", "5");
		deviceTypeMap.put("�����", "6");
	}

	/**
	 * �汾ȡ��
	 * @return version �汾
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * �汾�趨
	 * @param version �汾
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}
	
	/**
	 * ��ȡͳһΨһ��ʶ
	 * 
	 * @return
	 */
	public String getUUID() {
	    return UUID.randomUUID().toString().replace("-", "");
	}
	
	/**
	 * ����SNMP��Ϣ������
	 * @param entity SNMP��Ϣ��ʵ��
	 * @return SNMP��Ϣ������
	 */
	public String getSNMPID(NMS02Info entity){
		StringBuffer pk = new StringBuffer();
		pk.append(entity.getSnmpVersion());
		pk.append("_");
		pk.append(entity.getSnmpPort());
		pk.append("_");
		pk.append(entity.getReadCommit());
		pk.append("_");
		pk.append(entity.getWriteCommit());
		pk.append("_");
		pk.append(entity.getSnmpProxyIP());
		pk.append("_");
		pk.append(entity.getSnmpSecurityLevel());
		pk.append("_");
		pk.append(entity.getSnmpUser());
		pk.append("_");
		pk.append(entity.getSnmpSecurityContext());
		pk.append("_");
		pk.append(entity.getSnmpAuthType());
		pk.append("_");
		pk.append(entity.getSnmpPassword());
		pk.append("_");
		pk.append(entity.getSnmpPrivacyType());
		pk.append("_");
		pk.append(entity.getSnmpPrivacyPassPhrase());
		return pk.toString();
	}
	
	/**
	 * �������ͱ�ʶȡ��
	 * @param type ��������
	 * @return �������ͱ�ʶ
	 */
	public String getDeviceType(String type){
		String str = deviceTypeMap.get(type);
		if(StringUtils.isEmpty(str)){
			return "";
		}else{
			return str;
		}
	}
}
