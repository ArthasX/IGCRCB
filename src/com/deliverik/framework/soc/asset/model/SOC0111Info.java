/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
 * ����: �ʲ������ӿ� ��������: �ʲ������ӿ� ������¼: 2011/04/20 �޸ļ�¼:
 */
public interface SOC0111Info extends BaseModel {

	/**
	 * ����ȡ��
	 * 
	 * @return ����
	 */
	public Integer getEiddid();

	/**
	 * ����ȡ��
	 * 
	 * @return ����
	 */
	public String getName();

	/**
	 * �汾��ȡ��
	 * 
	 * @return �汾��
	 */
	public Integer getVersion();

	/**
	 * ����ȡ��
	 * 
	 * @return ����
	 */
	public String getDescription();

	/**
	 * ����ʱ��ȡ��
	 * 
	 * @return ����ʱ��
	 */
	public String getCreatetime();

	/**
	 * ����ʱ��ȡ��
	 * 
	 * @return ����ʱ��
	 */
	public String getUpdatetime();
//	/**
//	 * ����ȡ��
//	 *
//	 * @return ����
//	 */
//	public Serializable getPK();

}