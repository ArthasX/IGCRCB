/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.framework.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
 * <p>
 * �ʲ�ģ������ȡֵ��Χ
 * </p>
 */
public interface IG545Info  extends BaseModel {

	/**
	 * �ʲ�ģ������ȡֵ��ΧIDȡ��
	 * @return �ʲ�ģ������ȡֵ��ΧID
	 */
	public Integer getCcdid();

	/**
	 * �ʲ�ģ������ȡֵ��Χ��ʶȡ��
	 * @return �ʲ�ģ������ȡֵ��Χ��ʶ
	 */
	public String getCcdcategory();
	
	/**
	 * �ʲ�ģ������ȡֵ��Χ��ʶ����ȡ��
	 * @return �ʲ�ģ������ȡֵ��Χ��ʶ����
	 */
	public String getCcdlabel();

	/**
	 * �ʲ�ģ������ȡֵ��Χֵȡ��
	 * @return �ʲ�ģ������ȡֵ��Χֵ
	 */
	public String getCcdvalue();

	/**
	 * �ʲ�ģ������ȡֵ��Χ״̬ȡ��
	 * @return �ʲ�ģ������ȡֵ��Χ״̬
	 */
	public String getCcdstatus();

	/**
	 * �ʲ�ģ������ȡֵ��Χ����Ӧ��ȡ��
	 * @return �ʲ�ģ������ȡֵ��Χ����Ӧ��
	 */
	public String getCcdtype();

	/**
	 * �ʲ�ģ������ȡֵ��ΧԤ���ֶ�ȡ��
	 * @return �ʲ�ģ������ȡֵ��ΧԤ���ֶ�
	 */
	public String getCcdinfo();

}