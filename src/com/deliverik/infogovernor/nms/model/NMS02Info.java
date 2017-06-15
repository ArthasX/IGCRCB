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
 * Description: SNMP������Ϣʵ��ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface NMS02Info extends BaseModel {

	/**
	 * ����ȡ��
	 * @return ����
	 */
	public String getId();

	/**
	 * SNMP�汾ȡ��
	 * @return SNMP�汾
	 */
	public Integer getSnmpVersion();

	/**
	 * �˿�ȡ��
	 * @return �˿�
	 */
	public Integer getSnmpPort();

	/**
	 * ��ȡ������ȡ��
	 * @return ��ȡ������
	 */
	public String getReadCommit();

	/**
	 * д��������ȡ��
	 * @return д��������
	 */
	public String getWriteCommit();

	/**
	 * �Ƿ�����SNMP����ȡ��
	 * @return �Ƿ�����SNMP����
	 */
	public String getIsEnableSnmpProxy();

	/**
	 * ����IPȡ��
	 * @return ����IP
	 */
	public String getSnmpProxyIP();

	/**
	 * V3��ȫ����ȡ��
	 * @return V3��ȫ����
	 */
	public String getSnmpSecurityLevel();

	/**
	 * V3��ȫ�û�ȡ��
	 * @return V3��ȫ�û�
	 */
	public String getSnmpUser();

	/**
	 * V3����������ȡ��
	 * @return V3����������
	 */
	public String getSnmpSecurityContext();

	/**
	 * V3�����������趨
	 * @param snmpSecurityContext V3����������
	 */
	public void setSnmpSecurityContext(String snmpSecurityContext);

	/**
	 * V3�����֤Э��ȡ��
	 * @return V3�����֤Э��
	 */
	public String getSnmpAuthType();

	/**
	 * V3�����֤����ȡ��
	 * @return V3�����֤����
	 */
	public String getSnmpPassword();

	/**
	 * V3��˽Э��ȡ��
	 * @return V3��˽Э��
	 */
	public String getSnmpPrivacyType();

	/**
	 * V3��˽����ȡ��
	 * @return V3��˽����
	 */
	public String getSnmpPrivacyPassPhrase();

	/**
	 * ����ʱ��ȡ��
	 * @return ����ʱ��
	 */
	public String getInstime();
	
	/**
	 * ɾ����ʶȡ��
	 * @return ɾ����ʶ
	 */
	public String getDeleteflag();
}
