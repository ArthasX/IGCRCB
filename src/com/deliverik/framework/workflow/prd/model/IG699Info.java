/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.framework.workflow.prd.model;

import com.deliverik.framework.base.BaseModel;

/**
 * ����ȱʡ�����߱���Ȩ��
 * 
 */
public interface IG699Info  extends BaseModel {
	/**
	 * ����ȱʡ�����߱���Ȩ��IDȡ��
	 * @return ����ȱʡ�����߱���Ȩ��ID
	 */
	public String getPdvid();
	
	/**
	 * ���̱���IDȡ��
	 * @return ���̱���ID
	 */
	public String getPidid();
	
	/**
	 * ����״̬��IDȡ��
	 * @return ����״̬��ID
	 */
	public String getPsdid();

	/**
	 * ����Ϣȡ��
	 * @return ����Ϣ
	 */
	public IG007Info getProcessInfoDef();
	
	/**
	 * ����ȱʡ�����߱���Ȩ��ȡ��
	 * @return ����ȱʡ�����߱���Ȩ��
	 */
	public String getPidaccess();

	/**
	 * ���̱����Ƿ����ȡ��
	 *
	 * @return ���̱����Ƿ����
	 */
	public String getPidrequired();
}
