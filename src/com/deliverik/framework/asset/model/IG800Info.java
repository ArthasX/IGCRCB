package com.deliverik.framework.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
 * �ʲ�������Ϣ
 *
 */
public interface IG800Info  extends BaseModel {

	/**
	 * �ʲ�����IDȡ��
	 * @return �ʲ�����ID
	 */
	public Integer getCiid();

	/**
	 * �ʲ�IDȡ��
	 * @return �ʲ�ID
	 */
	public Integer getEiid();

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
	 * �ʲ�����ֵȡ��
	 * @return �ʲ�����ֵ
	 */
	public String getCivalue();

	/**
	 * �ʲ����Ը���ʱ��ȡ��
	 * @return �ʲ����Ը���ʱ��
	 */
	public String getCiupdtime();

	/**
	 * �ʲ�����ʧЧʱ��ȡ��
	 * @return �ʲ�����ʧЧʱ��
	 */
	public String getCiexpire();

	/**
	 * �ʲ�����״̬ȡ��
	 * @return �ʲ�����״̬
	 */
	public String getCistatus();

	/**
	 * �ʲ����Ե�ǰ�汾ȡ��
	 * @return �ʲ����Ե�ǰ�汾
	 */
	public String getCicurver();

	/**
	 * �ʲ����԰汾ȡ��
	 * @return �ʲ����԰汾
	 */
	public Integer getCiversion();

	/**
	 * �ʲ����԰汾��Ϣȡ��
	 * @return �ʲ����԰汾��Ϣ
	 */
	public String getCiverinfo();

	/**
	 * �ʲ�ģ��������Ϣȡ��
	 * @return �ʲ�ģ��������Ϣ
	 */
	public IG225Info getConfiguration();
	
	/**
	 * �ʲ�ģ�Ͳ����ȡ��
	 * @return �ʲ�ģ�Ͳ����
	 */
	public String getEsyscoding();
	
	/**
	 * �ʲ�����С�汾ȡ��
	 * @return �ʲ�����С�汾
	 */
	public Integer getCismallversion();
}