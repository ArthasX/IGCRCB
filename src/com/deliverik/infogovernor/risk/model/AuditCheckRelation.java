/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.risk.model;

import com.deliverik.framework.base.BaseModel;

/**
 * ���ռ�������������ϵʵ��ӿ�
 * 
 * @author lipeng@deliverik.com
 */
public interface AuditCheckRelation  extends BaseModel {
	/**
	 * ���ռ���������ƹ�ϵIDȡ��
	 * @return ���ռ���������ƹ�ϵID
	 */
	public Integer getAcrid();
	
	/**
	 * ���ռ��IDȡ��
	 * @return ���ռ��ID
	 */
	public Integer getRcid();

	/**
	 * ���������IDȡ��
	 * @return ���������ID
	 */
	public Integer getRadid();

	/**
	 * ������������ȡ��
	 * @return ������������
	 */
	public String getRadcode();

}