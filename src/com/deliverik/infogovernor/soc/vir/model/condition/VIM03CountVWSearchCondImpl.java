/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.vir.model.condition;


/**
 * ����:������Դͳ����ͼ��������
 * ��������:������Դͳ����ͼ��������
 * ������¼: 2014/02/19
 * �޸ļ�¼: 
 */
public class VIM03CountVWSearchCondImpl implements
		VIM03CountVWSearchCond {
	
	/**�û�id */
	protected String userid;
	/**����id */
	protected String orgsyscoding;
	/**�������� */
	protected String expirytime_greater;
	
	/**�û�����ͳ��*/
	protected String countUser;
	/**��������ͳ��*/
	protected String countOrg;
	/**��Ŀ����ͳ��*/
	protected String countProj;
	
	/**
	 * �û�idȡ��
	 * @return userid �û�id
	 */
	public String getUserid() {
		return userid;
	}
	/**
	 * ����idȡ��
	 * @return orgsyscoding ����id
	 */
	public String getOrgsyscoding() {
		return orgsyscoding;
	}
	/**
	 * ��������ȡ��
	 * @return expirytime_greater ��������
	 */
	public String getExpirytime_greater() {
		return expirytime_greater;
	}
	/**
	 * �û�id�趨
	 * @param userid �û�id
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}
	/**
	 * ����id�趨
	 * @param orgsyscoding ����id
	 */
	public void setOrgsyscoding(String orgsyscoding) {
		this.orgsyscoding = orgsyscoding;
	}
	/**
	 * ���������趨
	 * @param expirytime_greater ��������
	 */
	public void setExpirytime_greater(String expirytime_greater) {
		this.expirytime_greater = expirytime_greater;
	}
	/**
	 * �û�����ͳ��ȡ��
	 * @return countUser �û�����ͳ��
	 */
	public String getCountUser() {
		return countUser;
	}
	/**
	 * ��������ͳ��ȡ��
	 * @return countOrg ��������ͳ��
	 */
	public String getCountOrg() {
		return countOrg;
	}
	/**
	 * ��Ŀ����ͳ��ȡ��
	 * @return countProj ��Ŀ����ͳ��
	 */
	public String getCountProj() {
		return countProj;
	}
	/**
	 * �û�����ͳ���趨
	 * @param countUser �û�����ͳ��
	 */
	public void setCountUser(String countUser) {
		this.countUser = countUser;
	}
	/**
	 * ��������ͳ���趨
	 * @param countOrg ��������ͳ��
	 */
	public void setCountOrg(String countOrg) {
		this.countOrg = countOrg;
	}
	/**
	 * ��Ŀ����ͳ���趨
	 * @param countProj ��Ŀ����ͳ��
	 */
	public void setCountProj(String countProj) {
		this.countProj = countProj;
	}
	
}
