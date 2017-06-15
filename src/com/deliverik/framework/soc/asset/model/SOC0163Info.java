package com.deliverik.framework.soc.asset.model;

import com.deliverik.framework.user.model.entity.OrganizationTB;

/**
 * �û��ʲ���Ϣ
 * 
 */
public interface SOC0163Info {

	/**
	 * �ʲ�IDȡ��
	 * @return �ʲ�ID
	 */
	public Integer getEiid();

	/**
	 * �ʲ�ģ��IDȡ��
	 * @return �ʲ�ģ��ID
	 */
	public String getEid();

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
	 * �ʲ�����ʱ��ȡ��
	 * @return �ʲ�����ʱ��
	 */
	public String getEiupdtime();


	/**
	 * �ʲ�ģ������ȡ��
	 * @return �ʲ�ģ������
	 */
	public String getEname();
	

	/**
	 * �ʲ��汾��ȡ��
	 * @return �ʲ��汾��
	 */
	public Integer getEiversion();

	
	/**
	 * �ʲ���������ȡ��
	 * @return �ʲ���������
	 */
	public String getEiorgsyscoding();
	/**
	 * �ʲ�ģ��ȡ��
	 * @return �ʲ�ģ��
	 */
	public String getEsyscoding();
	
	/**
	 * �ʲ�����������Ϣʵ��ȡ��
	 * @return �ʲ�����������Ϣʵ��
	 */
	public OrganizationTB getOrganizationTB();
	
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
	

	/**
	 * �ʲ�ip��ȡ
	 * @return
	 */
	public String getIp();
}