/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.prr.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseForm;

/**
 * @Description: ����OAִ����Form
 * @Author  
 * @History 2010-9-13     �½� 
 * @Version V1.0
 */
@SuppressWarnings("serial")
public class IGPRR0109Form extends BaseForm {

	/**�������û�ID*/
	protected String[] ppuserids;
	
	/**������*/
	protected Integer prid;

	/**������ɫID*/
	protected Integer roleid;
	
	/**���̶���ID*/
	protected String pdid;
	
	/** ��ɫ���� */
	protected String rolename;
	
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		super.reset(mapping, request);
		this.ppuserids = null;
	}

	/**
	 * ��ȡ������
	 * @return ������
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * ���ñ�����
	 * @param prid ������
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * ��ȡ������ɫID
	 * @return ������ɫID
	 */
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * ���ò�����ɫID
	 * @param roleid ������ɫID
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	/**
	 * ��ȡ�������û�ID
	 * @return �������û�ID
	 */
	public String[] getPpuserids() {
		return ppuserids;
	}

	/**
	 * ���ò������û�ID
	 * @param ppuserids �������û�ID
	 */
	public void setPpuserids(String[] ppuserids) {
		this.ppuserids = ppuserids;
	}
	
	/**
	 * ���̶���IDȡ��
	 * @return ���̶���ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * ���̶���ID�趨
	 * @param pdid���̶���ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * ��ɫ����ȡ��
	 * @return ��ɫ����
	 */
	public String getRolename() {
		return rolename;
	}
	
	/**
	 * ��ɫ�����趨
	 * @param rolename��ɫ����
	 */
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
}
