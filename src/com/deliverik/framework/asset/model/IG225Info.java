package com.deliverik.framework.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
 * <p>
 * �ʲ�ģ��������Ϣ
 * </p>
 */
public interface IG225Info  extends BaseModel {

	/**
	 * �ʲ�ģ������IDȡ��
	 * @return �ʲ�ģ������ID
	 */
	public Integer getCid();

	/**
	 * �ʲ�ģ��IDȡ��
	 * @return �ʲ�ģ��ID
	 */
	public Integer getEid();

	/**
	 * �ʲ�ģ����������ȡ��
	 * @return �ʲ�ģ����������
	 */
	public String getCname();

	/**
	 * �ʲ�ģ������˵��ȡ��
	 * @return �ʲ�ģ������˵��
	 */
	public String getCdesc();

	/**
	 * �ʲ�ģ�����Ե�λȡ��
	 * @return �ʲ�ģ�����Ե�λ
	 */
	public String getCunit();

	/**
	 * �ʲ�ģ������״̬ȡ��
	 * @return �ʲ�ģ������״̬
	 */
	public String getCstatus();

	/**
	 * �ʲ�ģ�����Է���ȡ��
	 * @return �ʲ�ģ�����Է���
	 */
	public String getCcategory();
	
	/**
	 * �ʲ�ģ������ȡֵ��ΧIDȡ��
	 * @return �ʲ�ģ������ȡֵ��ΧID
	 */
	public String getCoption();
	
	/**
	 * �ʲ�ģ�����Ա��ȡ��
	 * @return �ʲ�ģ�����Ա��
	 */
	public String getClabel();

	/**
	 * �ʲ�ģ�������Ƿ���ʾ��ʶȡ��
	 * @return �ʲ�ģ�������Ƿ���ʾ��ʶ
	 */
	public Integer getCseq();

	/**
	 * �ʲ�ģ��������������ȡ��
	 * @return �ʲ�ģ��������������
	 */
	public String getCattach();
	
	/**
	 * �ʲ�ģ�����Ա�����ȡ��
	 * @return �ʲ�ģ�����Ա�����
	 */
	public String getCrequired();
	
	/**
	 * �ʲ�ģ����������ģ�Ͳ����ȡ��
	 * @return �ʲ�ģ����������ģ�Ͳ����
	 */
	public String getEsyscoding();
}