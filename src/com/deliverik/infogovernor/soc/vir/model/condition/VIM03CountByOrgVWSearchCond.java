/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.vir.model.condition;
/**
 * ����:������Դͳ����ͼ���������ӿ�(������)
 * ��������:������Դͳ����ͼ���������ӿ�(������) 
 * ������¼: 2014/02/19
 * �޸ļ�¼: 
 */
public interface VIM03CountByOrgVWSearchCond {

	/**
	 * ������ȡ��
	 * @return orgsyscoding ������
	 */
	public String getOrgsyscoding_like();
	/**
	 * ��ȡ����ʱ��
	 */
	public String getExpiryTime();
}
