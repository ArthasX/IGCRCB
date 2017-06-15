package com.deliverik.framework.user.model;

import com.deliverik.framework.base.BaseModel;

/**
 * <p>
 * �˵���Ϣ
 * </p>
 */
public interface Action  extends BaseModel {

	/**
	 * �˵�IDȡ��
	 * @return �˵�ID
	 */
	public String getActname();
	
	/**
	 * �˵���ʾ����ȡ��
	 * @return �˵���ʾ����
	 */
	public  String getActlabel();

	/**
	 * �˵�����ȡ��
	 * @return �˵�����
	 */
	public  String getActdesc();

	/**
	 * �˵�URLȡ��
	 * @return �˵�URL
	 */
	public  String getActurl();

	/**
	 * �˵�����ȡ��
	 * @return �˵�����
	 */
	public  String getActtype();

	/**
	 * һ���˵�IDȡ��
	 * @return һ���˵�ID
	 */
	public  Integer getActl1id();

	/**
	 * �����˵�IDȡ��
	 * @return �����˵�ID
	 */
	public  Integer getActl2id();

	/**
	 * �����˵�IDȡ��
	 * @return �����˵�ID
	 */
	public  Integer getActl3id();
	
	/**
	 * �˵��������ɫ����(���ŷָ�)ȡ��
	 * @return �˵��������ɫ����(���ŷָ�)
	 */
	public  String getActroletype();

	/**
	 * �˵�����IDȡ��
	 * @return �˵�����ID
	 */
	public String getActsortid();
	
	/**
	 * �˵�URL����ȡ��
	 * @return �˵�URL����
	 */
	public String getActurltype();

}