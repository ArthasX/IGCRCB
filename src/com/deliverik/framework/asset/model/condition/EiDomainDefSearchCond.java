/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.condition;

/**
 * ����: �ʲ��������������ӿ� ��������: �ʲ��������������ӿ� ������¼: 2011/04/20 �޸ļ�¼:
 * <tr>
 * <td>name</td>
 * <td>�ʲ���������</td>
 * </tr>
 * <tr>
 * <td>createtime_from</td>
 * <td>�ʲ�����Ǽǿ�ʼʱ�䣨���ڵ��ڣ�</td>
 * </tr>
 * <tr>
 * <td>createtime_to</td>
 * <td>�ʲ�����Ǽǽ�ֹʱ�䣨С�ڵ��ڣ�</td>
 * </tr>
 */
public interface EiDomainDefSearchCond {
	/**
	 * �ʲ���������ȡ��
	 */
	public String getName_like();
	
	/**
	 * �ʲ����忪ʼʱ��
	 */
	public String getCreatetime_from();

	/**
	 * �ʲ������ֹʱ��
	 */
	public String getCreatetime_to();
	
	/**
	 * ����IDȡ��
	 * 
	 * @return ����ID
	 */
	public String getEiddid_eq();
	
	/**
	 * ����ȡ��
	 * 
	 * @return ����
	 */
	public Integer getEiddid();
	
	/**
	 * �汾��ȡ��
	 * 
	 * @return �汾��
	 */
	public Integer getVersion();

}