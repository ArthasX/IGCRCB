package com.deliverik.framework.user.model;

import com.deliverik.framework.base.BaseModel;

/**
 * <p>
 * ��ɫ�˵���Ȩ��Ϣ
 * </p>
 */
public interface RoleAction  extends BaseModel {

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

}