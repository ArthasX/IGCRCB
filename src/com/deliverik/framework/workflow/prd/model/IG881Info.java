/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.framework.workflow.prd.model;

import com.deliverik.framework.base.BaseModel;

/**
 * ���̲����߱���Ȩ��
 * 
 */
public interface IG881Info  extends BaseModel {
	/**
	 * ���̲����߱���Ȩ��IDȡ��
	 * @return ���̲����߱���Ȩ��ID
	 */
	public String getPipdid();
	
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
	 * ���̲����ߵ�IDȡ��
	 * @return ���̲����ߵ�ID
	 */
	public String getPpdid();
	
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
