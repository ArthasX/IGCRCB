/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.soc.vir.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 
 * 
 */

@SuppressWarnings("serial")
public class IGVIR1101Form extends BaseForm{
	
	/**�û�id */
	protected String userid_like;
	/**�û���  */
	protected String username_like;
	/**������  */
	protected String orgsyscoding_like;
	/**��������  */
	protected String orgname;
	
	/**
	 * �û�idȡ��
	 * @return userid_like �û�id
	 */
	public String getUserid_like() {
		return userid_like;
	}
	/**
	 * �û�id�趨
	 * @param userid_like �û�id
	 */
	public void setUserid_like(String userid_like) {
		this.userid_like = userid_like;
	}
	/**
	 * �û���ȡ��
	 * @return username_like �û���
	 */
	public String getUsername_like() {
		return username_like;
	}
	/**
	 * �û����趨
	 * @param username_like �û���
	 */
	public void setUsername_like(String username_like) {
		this.username_like = username_like;
	}
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
	 * ��������ȡ��
	 * @return orgname ��������
	 */
	public String getOrgname() {
		return orgname;
	}
	/**
	 * ���������趨
	 * @param orgname ��������
	 */
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}
	
}
