/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.nms.bl.task;

import com.deliverik.infogovernor.nms.model.NMS02Info;


/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: NMSBL����ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface NMSBaseBL{

	/**
	 * �汾ȡ��
	 * @return version �汾
	 */
	public Integer getVersion();

	/**
	 * �汾�趨
	 * @param version �汾
	 */
	public void setVersion(Integer version);
	
	/**
     * ��ȡͳһΨһ��ʶ
     * 
     * @return
     */
    public String getUUID();
    
    /**
	 * ����SNMP��Ϣ������
	 * @param entity SNMP��Ϣ��ʵ��
	 * @return SNMP��Ϣ������
	 */
	public String getSNMPID(NMS02Info entity);
	
	/**
	 * �������ͱ�ʶȡ��
	 * @param type ��������
	 * @return �������ͱ�ʶ
	 */
	public String getDeviceType(String type);
}
