/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prd.form;

import javax.servlet.ServletRequest;

import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description:�û���ѯform 
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRD0201Form extends BaseForm{

	/** ������ */
	protected String orgid;
	
	/** �û����� */
	protected String username;

	/**
	 * ������ȡ��
	 * @return ������
	 */
	public String getOrgid() {
		return orgid;
	}

	/**
	 * �������趨
	 * @param orgid ������
	 */
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	/**
	 * �û�����ȡ��
	 * @return �û�����
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * �û������趨
	 * @param username �û�����
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void reset(ActionMapping mapping, ServletRequest request) {
		super.reset(mapping, request);
		this.orgid = null;
	}
}
