/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sym.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.user.model.condition.RoleActionSearchCond;
import com.deliverik.infogovernor.sym.model.condition.RoleReportSearchCond;

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
public class IGSYM0415Form extends BaseForm implements RoleActionSearchCond,RoleReportSearchCond{
	
	/** �˵�id */
	protected String actname;
	
	/** ��Ȩ�˵�id  */
	protected String[] actionids;
	
	/** ��ɫid */
	protected Integer roleid;
	
	/** ��ɫ���� */
	protected String rolename;
	

	
	/**
	 * ����ID
	 */
	
	protected Integer rfdid;
	
	protected String rrperm;
	
	protected String rrdesc;
	
	protected String fingerprint;
	
	protected String rfdtitle;
	
	/**
	 * δ��Ȩ��ɫ����
	 */
	
	protected String[] rfdids;
	
	/**
	 * ����Ȩ��ɫ����
	 */
	
	protected String[] rfdidy;
	
	/**
	 * ����ʽ1-ɾ����0-���
	 */
	
	protected String mode;
	
	protected String urid;
	
	protected String rfdpictype;
	
	protected String rfdtype;
	
	protected String rfdtypename;
	
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

	public Integer getRfdid() {
		return rfdid;
	}

	public void setRfdid(Integer rfdid) {
		this.rfdid = rfdid;
	}

	public String getRrperm() {
		return rrperm;
	}

	public void setRrperm(String rrperm) {
		this.rrperm = rrperm;
	}

	public String getRrdesc() {
		return rrdesc;
	}

	public void setRrdesc(String rrdesc) {
		this.rrdesc = rrdesc;
	}

	public String getFingerprint() {
		return fingerprint;
	}

	public void setFingerprint(String fingerprint) {
		this.fingerprint = fingerprint;
	}

	public String getRfdtitle() {
		return rfdtitle;
	}

	public void setRfdtitle(String rfdtitle) {
		this.rfdtitle = rfdtitle;
	}


	public String[] getRfdids() {
		return rfdids;
	}

	public void setRfdids(String[] rfdids) {
		this.rfdids = rfdids;
	}

	public String[] getRfdidy() {
		return rfdidy;
	}

	public void setRfdidy(String[] rfdidy) {
		this.rfdidy = rfdidy;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getUrid() {
		return urid;
	}

	public void setUrid(String urid) {
		this.urid = urid;
	}

	public String getRfdpictype() {
		return rfdpictype;
	}

	public void setRfdpictype(String rfdpictype) {
		this.rfdpictype = rfdpictype;
	}

	public String getRfdtype() {
		return rfdtype;
	}

	public void setRfdtype(String rfdtype) {
		this.rfdtype = rfdtype;
	}

	public String getRfdtypename() {
		return rfdtypename;
	}

	public void setRfdtypename(String rfdtypename) {
		this.rfdtypename = rfdtypename;
	}

	
}
