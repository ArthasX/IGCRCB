/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.vir.model.condition;
/**
 * ����:������Դͳ����ͼ���������ӿ�(���û�)
 * ��������:������Դͳ����ͼ���������ӿ�(���û�) 
 * ������¼: 2014/02/19
 * �޸ļ�¼: 
 */
public interface VIM03CountByUserVWSearchCond {

	/**
	 * �û�idȡ��
	 * @return userid_like �û�id
	 */
	public String getUserid_like();
	/**
	 * �û���ȡ��
	 * @return username �û���
	 */
	public String getUsername_like();
	/**
	 * ������ȡ��
	 * @return orgsyscoding ������
	 */
	public String getOrgsyscoding_like();
}
