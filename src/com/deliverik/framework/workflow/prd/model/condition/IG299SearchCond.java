/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.condition;

/**
  * ����: ״̬�ɷ��ɻ����������������ӿ�
  * ��������: ״̬�ɷ��ɻ����������������ӿ�
  * ������¼: 2013/02/26
  * �޸ļ�¼: 
  */
public interface IG299SearchCond {

	/**
	 * ����״̬�ڵ�ȡ��
	 *
	 * @return psdid ����״̬�ڵ�
	 */
	public String getPsdid_eq() ;
	
	/**
	 * ����״̬�ڵ�ָ���ɷ��ɻ�������ģ����ѯȡ��
	 *
	 * @return psodid_like ����״̬�ڵ�ָ���ɷ��ɻ���ģ����ѯ
	 */
	public String getPsodid_like();
	
	/**
	 * ����״̬�ڵ�ָ���ɷ��ɻ����뾫ȷ��ѯȡ��
	 *
	 * @return orgsyscoding_eq ����״̬�ڵ�ָ���ɷ��ɻ����뾫ȷ��ѯ
	 */
	public String getOrgsyscoding_eq() ;
	
	/**
	 * ����״̬�ڵ�likeȡ��
	 * @return ����״̬�ڵ�like
	 */
	public String getPsdid_like();
	
}