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
public class IGVIR1104Form extends BaseForm{

	/**�鿴����*/
	protected String showType;
	
	/**��ѯ���� */
	protected String searchType;
	
	/**�û�id */
	protected String userid;
	
	/**������  */
	protected String orgsyscoding;
	
	/** ��Ŀ���� */
    protected Integer pid_eq;

	/**
	 * ��ѯ����ȡ��
	 * @return searchType ��ѯ����
	 */
	public String getSearchType() {
		return searchType;
	}

	/**
	 * �鿴����ȡ��
	 * @return showType �鿴����
	 */
	public String getShowType() {
		return showType;
	}

	/**
	 * �鿴�����趨
	 * @param showType �鿴����
	 */
	public void setShowType(String showType) {
		this.showType = showType;
	}

	/**
	 * ��ѯ�����趨
	 * @param searchType ��ѯ����
	 */
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	/**
	 * �û�idȡ��
	 * @return userid �û�id
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * �û�id�趨
	 * @param userid �û�id
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * ������ȡ��
	 * @return orgsyscoding ������
	 */
	public String getOrgsyscoding() {
		return orgsyscoding;
	}

	/**
	 * �������趨
	 * @param orgsyscoding ������
	 */
	public void setOrgsyscoding(String orgsyscoding) {
		this.orgsyscoding = orgsyscoding;
	}

	/**
	 * ��Ŀ����ȡ��
	 * @return pid_eq ��Ŀ����
	 */
	public Integer getPid_eq() {
		return pid_eq;
	}

	/**
	 * ��Ŀ�����趨
	 * @param pid_eq ��Ŀ����
	 */
	public void setPid_eq(Integer pid_eq) {
		this.pid_eq = pid_eq;
	}
	
}
