package com.deliverik.framework.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
 * <p>
 * �ʲ���Ϣ
 * </p>
 */
public interface IG013Info  extends BaseModel {

	/**
	 * �ʲ�IDȡ��
	 * @return �ʲ�ID
	 */
	public Integer getEiid();

	/**
	 * �ʲ�ģ��IDȡ��
	 * @return �ʲ�ģ��ID
	 */
	public Integer getEid();

	/**
	 * �ʲ�����ȡ��
	 * @return �ʲ�����
	 */
	public String getEiname();
	
	/**
	 * �ʲ����ȡ��
	 * @return �ʲ����
	 */
	public String getEilabel();

	/**
	 * �ʲ�˵��ȡ��
	 * @return �ʲ�˵��
	 */
	public String getEidesc();

	/**
	 * �ʲ�����ʱ��ȡ��
	 * @return �ʲ�����ʱ��
	 */
	public String getEiupdtime();

	/**
	 * �ʲ�״̬ȡ��
	 * @return �ʲ�״̬
	 */
	public String getEistatus();

	/**
	 * �ʲ��汾��ȡ��
	 * @return �ʲ��汾��
	 */
	public Integer getEiversion();


	/**
	 * �ʲ��Ǽ���ȡ��
	 * @return �ʲ��Ǽ���
	 */
	public String getEiinsdate();
	
	/**
	 * �ʲ��������������ȡ��
	 * @return �ʲ��������������
	 */
	public String getEiorgsyscoding();
	
	/**
	 * �ʲ�ģ�Ͳ����ȡ��
	 * @return �ʲ�ģ�Ͳ����
	 */
	public String getEsyscoding();
	
	/**
	 * �ʲ�������ȡ��
	 * @return �ʲ�������
	 */
	public String getEiuserid();
	
	/**
	 * �ʲ�����������ȡ��
	 * @return �ʲ�����������
	 */
	public String getEiusername();
	
	/**
	 * �ʲ�С�汾ȡ��
	 * @return �ʲ�С�汾
	 */
	public Integer getEismallversion();
	
	/**
	 * �ʲ����������ڵ�ʵ���ʶȡ��
	 * @return �ʲ����������ڵ�ʵ���ʶ
	 */
	public Integer getEirootmark();
	
}