/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sym.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.user.model.condition.RoleActionSearchCond;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ϵͳ����_��Ȩ����_�˵���ȨForm
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSYM0404Form extends BaseForm implements RoleActionSearchCond{
	
	/** �˵�id */
	protected String actname;
	
	/** ��Ȩ�˵�id  */
	protected String[] actionids;
	
	/** ��ɫid */
	protected Integer roleid;
	
	/** ��ɫ���� */
	protected String rolename;
	
	/**
	 * ��ɫ����ȡ��
	 * @return ��ɫ����
	 */
	public String getRolename() {
		return rolename;
	}

	/**
	 * ��ɫ�����趨
	 * @param rolename ��ɫ����
	 */
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	
	/**
	 * �˵�IDȡ��
	 * @return �˵�ID
	 */
	public String getActname() {
		return actname;
	}

	/**
	 * �˵�ID�趨
	 *
	 * @param actname �˵�ID
	 */
	public void setActname(String actname) {
		this.actname = actname;
	}
	
	/**
	 * ��ȡ�û�id
	 * @return Integer
	 */
	
	public Integer getRoleid() {
		return roleid;
	}
	/**
	 * �����û�id
	 * @param roleid Integer
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	/**
	 * ��ȡ��Ȩ�˵�id
	 * @return String[]
	 */
	
	public String[] getActionids() {
		return actionids;
	}
	
	/**
	 * ������Ȩ�˵�id
	 * @param actionids String[]
	 */
	
	public void setActionids(String[] actionids) {
		this.actionids = actionids;
	}
	
	/**
	 * ����Form
	 * @param mapping ActionMapping
	 * @param request HttpServletRequest
	 */
	
	public void reset(ActionMapping mapping,HttpServletRequest request){
		super.reset(mapping, request);
		this.actionids = null;
	}

}
