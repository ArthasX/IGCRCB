/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.vir.model.condition;
/**
 * ����:������Դͳ����ͼ���������ӿ�
 * ��������:������Դͳ����ͼ���������ӿ�
 * ������¼: 2014/02/19
 * �޸ļ�¼: 
 */
public interface VIM03CountVWSearchCond {
	/**
	 * �û�idȡ��
	 * @return userid �û�id
	 */
	public String getUserid();
	/**
	 * ����idȡ��
	 * @return orgsyscoding ����id
	 */
	public String getOrgsyscoding();
	/**
	 * ��������ȡ��
	 * @return expirytime_greater ��������
	 */
	public String getExpirytime_greater();
	/**
	 * �û�����ͳ��ȡ��
	 * @return countUser �û�����ͳ��
	 */
	public String getCountUser();
	/**
	 * ��������ͳ��ȡ��
	 * @return countOrg ��������ͳ��
	 */
	public String getCountOrg();
	/**
	 * ��Ŀ����ͳ��ȡ��
	 * @return countProj ��Ŀ����ͳ��
	 */
	public String getCountProj();
}
