/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.framework.workflow.prr.model.condition;

/**
 * ��Ȩ��ѯ�ӿ�
 */
public interface IG711SearchCond {
	
	/**
	 * ��Ȩ��ʶλȡ��
	 * @return ��Ȩ��ʶλ
	 */
	public String getPaflag();
	
	/**
	 * ��Ȩ��ʼ����_��ȡ��
	 * @return ��Ȩ��ʼ����_��
	 */
	public String getPabegintime_f();
	
	/**
	 * ��Ȩ��ʼ����_��ȡ��
	 * @return ��Ȩ��ʼ����_��
	 */
	public String getPabegintime_t();
	
	/**
	 * ��Ȩ��ȡ��
	 * @return ��Ȩ��
	 */
	public String getPaiid();
	/**
	 * ��Ȩ����ȡ��
	 * @return ��Ȩ����
	 */
	public String getPatype();
	
	/**
	 * ��¼�û���idȡ��
	 * @return ��¼�û���id
	 */
	public String getLoginUser();
	
	/**
	 * ��Ȩ��ʶλȡ��
	 * @return ��Ȩ��ʶλ
	 */
	public String getNopaflag();
	
}
