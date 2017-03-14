/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.nms.model;

import com.deliverik.framework.base.BaseModel;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �豸���ϵ��Ϣʵ��ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface NMS05Info extends BaseModel {

	/**
	 * ��IDȡ��
	 * @return gid ��ID
	 */
	public Integer getGid();

	/**
	 * �豸IDȡ��
	 * @return did �豸ID
	 */
	public String getDid();

	/**
	 * ��汾ȡ��
	 * @return gversion ��汾
	 */
	public Integer getGversion();

	/**
	 * ��ʾIPȡ��
	 * @return ip ��ʾIP
	 */
	public String getIp();

	/**
	 * ��ʾMAC��ַȡ��
	 * @return mac ��ʾMAC��ַ
	 */
	public String getMac();

	/**
	 * SNMP��Ϣȡ��
	 * @return snmpid SNMP��Ϣ
	 */
	public String getSnmpid();

	/**
	 * ����ʱ��ȡ��
	 * @return instime ����ʱ��
	 */
	public String getInstime();
}
