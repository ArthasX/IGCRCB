/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.vir.model.condition;


/**
 * ����:������Դͳ����ͼ��������(������)
 * ��������:������Դͳ����ͼ��������(������) 
 * ������¼: 2014/02/19
 * �޸ļ�¼: 
 */
public class VIM03CountByOrgVWSearchCondImpl implements
		VIM03CountByOrgVWSearchCond {

	/**������  */
	protected String orgsyscoding_like;
	/**����ʱ��*/
	protected String expiryTime;

	/**
	 * ������ȡ��
	 * @return orgsyscoding_like ������
	 */
	public String getOrgsyscoding_like() {
		return orgsyscoding_like;
	}
	/**
	 * �������趨
	 * @param orgsyscoding_like ������
	 */
	public void setOrgsyscoding_like(String orgsyscoding_like) {
		this.orgsyscoding_like = orgsyscoding_like;
	}
	/**
	 * ��ȡ����ʱ��
	 */
	public String getExpiryTime() {
		return expiryTime;
	}
	/**
	 * ����ʱ���趨
	 * @param expiryTime
	 */
	public void setExpiryTime(String expiryTime) {
		this.expiryTime = expiryTime;
	}
	
}
