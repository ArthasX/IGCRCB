package com.deliverik.framework.user.model;

/**
 * <p>
 * ��ɫ�˵���Ȩ��Ϣ
 * </p>
 */
public interface RoleActionInfo {

	/**
	 * ��ɫ�˵���ȨIDȡ��
	 * @return ��ɫ�˵���ȨID
	 */
	public  Integer getRaid();

	/**
	 * ��ɫIDȡ��
	 * @return ��ɫID
	 */
	public  Integer getRoleid();

	/**
	 * �˵�IDȡ��
	 * @return �˵�ID
	 */
	public  String getActname();

	/**
	 * ��ɫ���ڲ˵���Ȩ��ȡ��
	 * @return ��ɫ���ڲ˵���Ȩ��
	 */
	public  String getRaperm();

	/**
	 * ��ɫ���ڲ˵���Ȩ�޵�˵��ȡ��
	 * @return ��ɫ���ڲ˵���Ȩ�޵�˵��
	 */
	public  String getRadesc();
	
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