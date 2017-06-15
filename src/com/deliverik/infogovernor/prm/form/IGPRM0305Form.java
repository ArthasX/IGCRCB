/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.prm.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.Globals;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.WorkFlowConstDefine;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��������_ȱʡ����������FormBean
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGPRM0305Form extends BaseForm {
	
	/** ȱʡ������������Ϣ����ֽ��� */
	private static final int MAX_BYTE = 512;
	
	/**����ID*/
	protected String pdid;

	/**����ʽ��0-ɾ����1-����*/
	protected String mode;
	
	/**�����߽�ɫID*/
	protected String[] roleids;
	
	/**�����߽�ɫ����*/
	protected String[] rolenames;
	
	/**�������û�ID*/
	protected String[] ppuserids;
	
	/**�������û�����*/
	protected String[] ppusernames;
	
	/**�����߻���ID*/
	protected String[] pporgids;
	
	/**�����߻�������*/
	protected String[] pporgnames;
	
	
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		super.reset(mapping, request);
		this.roleids = null;
		this.rolenames = null;
		this.ppuserids = null;
		this.ppusernames = null;
		this.pporgids = null;
		this.pporgnames = null;
	}
	
	/**
	 * ȱ�������˸������
	 *
	 * @param mapping
	 * @param request
	 * @return ��������Ϣ
	 */
	public ActionErrors validate(ActionMapping mapping,HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		
		errors = super.validate(mapping, request);
		
		StringBuffer sbf = new StringBuffer("");
		if ( roleids != null ) {
			appendStr(sbf,roleids);
		}
		if ( rolenames != null ) {
			appendStr(sbf,rolenames);
		}
		if ( ppuserids != null ) {
			appendStr(sbf,ppuserids);
		}
		if ( ppusernames != null ) {
			appendStr(sbf,ppusernames);
		}
		if ( pporgids != null ) {
			appendStr(sbf,pporgids);
		}
		if ( pporgnames != null ) {
			appendStr(sbf,pporgnames);
		}
		if (!IGStringUtils.isValidBytes(sbf.toString(),MAX_BYTE)) {
			errors.add(Globals.ERROR_KEY, new ActionMessage("IGPRM0305.E002"));
		}
		
		return errors;
	}
	
	private void appendStr(StringBuffer sbf, String[] array) {
		for(String str : array) {
			sbf.append(str).append(WorkFlowConstDefine.SPILT_APPROVORS);//���ÿ���null
		}
	}


	/**
	 * ��ȡ��������ID
	 * @return ��������ID
	 */
	public String getPdid() {
		return pdid;
	}
	
	/**
	 * ������������ID
	 * @param pdid ��������ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}
	
	/**
	 * ��ȡ����ʽ
	 * @return ����ʽ
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * ���ô���ʽ
	 * @param mode ����ʽ
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}
	
	/**
	 * ��ȡ�����߽�ɫID
	 * @return �����߽�ɫID
	 */
	public String[] getRoleids() {
		return roleids;
	}
	
	/**
	 * ���ò����߽�ɫID
	 * @param roleids �����߽�ɫID
	 */
	public void setRoleids(String[] roleids) {
		this.roleids = roleids;
	}
	
	/**
	 * ��ȡ�����߽�ɫ����
	 * @return �����߽�ɫ����
	 */
	public String[] getRolenames() {
		return rolenames;
	}
	
	/**
	 * ���ò����߽�ɫ����
	 * @param rolenames �����߽�ɫ����
	 */
	public void setRolenames(String[] rolenames) {
		this.rolenames = rolenames;
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
	 * ��ȡ�������û�����
	 * @return �������û�����
	 */
	public String[] getPpusernames() {
		return ppusernames;
	}
	
	/**
	 * ���ò������û�����
	 * @param ppusernames �������û�����
	 */
	public void setPpusernames(String[] ppusernames) {
		this.ppusernames = ppusernames;
	}
	
	/**
	 * ��ȡ�����߻���ID
	 * @return �����߻���ID
	 */
	public String[] getPporgids() {
		return pporgids;
	}
	
	/**
	 * ���ò����߻���ID
	 * @param pporgids �����߻���ID
	 */
	public void setPporgids(String[] pporgids) {
		this.pporgids = pporgids;
	}
	
	/**
	 * ��ȡ�����߻�������
	 * @return �����߻�������
	 */
	public String[] getPporgnames() {
		return pporgnames;
	}
	
	/**
	 * ���ò����߻�������
	 * @param pporgnames �����߻�������
	 */
	public void setPporgnames(String[] pporgnames) {
		this.pporgnames = pporgnames;
	}

}
