/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.csebank.lom.model;


/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ʳ�ù���_ͳ�ƻ���_���ͳ����ϢMODEL
 * </p>
 * 
 * @author wuzhenqiu@deliverik.com
 * @version 1.0
 */
public interface GoodsStock {
	
	/**
	 * ���
	 * @return ���
	 */
	public String getGid();
	
	/**
	 * ��Ʒ���
	 * @return ��Ʒ���
	 */
	public String getGiodcode();
	
	/**
	 * ��Ʒ����
	 * @return ��Ʒ����
	 */
	public String getGiodname();
	
	/**
	 * ��������
	 * @return ��������
	 */
	public Integer getGiodoutnum();
	
	/**
	 * �������
	 * @return �������
	 */
	public Integer getGiodinnum();
	
	/**
	 * �����
	 * @return �����
	 */
	public Integer getGiodnum();
	
	public String getType();

}