/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * 
 */


package com.csebank.lom.model;
import com.deliverik.framework.user.model.entity.OrganizationTB;

/**
 * 
 *  �Ӵ����˲�ѯʵ��
 * 
 * @author songhaiyang@deliverik.com
 * 
 */
public interface GuestRecption {
	/**
	 * �Ӵ�����IDȡ��
	 * 
	 * @return �Ӵ�RID
	 */
	public Integer getRgid();
	
	/**
	 * �Ӵ�����IDȡ��
	 * 
	 * @return �Ӵ�����ID
	 */
	public Integer getRid();
	
	/**
	 * �Ӵ���������ȡ��
	 * 
	 * @return �Ӵ���������
	 */
	public String getRname();
	
	/**
	 * ��Ҫ���벿��ȡ��
	 * 
	 * @return ��Ҫ���벿��
	 */
	public String getRapporgid();
	
	/**
	 * �Ӵ���ʼ����ȡ��
	 * 
	 * @return �Ӵ���ʼ����
	 */
	public String getRstime();
	
	/**
	 * �Ӵ���������ȡ��
	 * 
	 * @return �Ӵ���������
	 */
	public String getRetime();

	/**
	 *  �Ӵ����˵�λȡ��
	 * 
	 * @return �Ӵ����˵�λ
	 */
	public String getRgunit();

	/**
	 * �Ӵ���������ȡ��
	 * 
	 * @return �ӿ�������
	 */
	public String getRgname();
	
	/** ״̬��1�����У�2������ȡ��
	 * 
	 *  @return ״̬��
	 */
	public String getRstatus();
	
	/** ������Ϣʵ��ȡ��
	 * 
	 * @return ������Ϣʵ��
	 */
	public OrganizationTB getOrganizationTB();

}