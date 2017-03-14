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
 * Description: ��������_ȱʡ������FormBean
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGPRM0304Form extends BaseForm {
	
	/** ȱʡ��������Ϣ����ֽ��� */
	private static final int MAX_BYTE = 512;
	
	/**����ID*/
	protected String pdid;
	
	/**��������*/
	protected String prtype;

	/**����ʽ��0-ɾ����1-����*/
	protected String mode;
	
	/**�����߽�ɫID*/
	protected String[] roleids_one;
	
	/**�����߽�ɫ����*/
	protected String[] rolenames_one;
	
	/**�������û�ID*/
	protected String[] ppuserids_one;
	
	/**�������û�����*/
	protected String[] ppusernames_one;
	
	/**�����߻���ID*/
	protected String[] pporgids_one;
	
	/**�����߻�������*/
	protected String[] pporgnames_one;
	
	/**�����߽�ɫID*/
	protected String[] roleids_two;
	
	/**�����߽�ɫ����*/
	protected String[] rolenames_two;
	
	/**�������û�ID*/
	protected String[] ppuserids_two;
	
	/**�������û�����*/
	protected String[] ppusernames_two;
	
	/**�����߻���ID*/
	protected String[] pporgids_two;
	
	/**�����߻�������*/
	protected String[] pporgnames_two;
	
	/**�����߽�ɫID*/
	protected String[] roleids_three;

	/**�����߽�ɫ����*/
	protected String[] rolenames_three;

	/**�������û�ID*/
	protected String[] ppuserids_three;
	
	/**�������û�����*/
	protected String[] ppusernames_three;
	
	/**�����߻���ID*/
	protected String[] pporgids_three;
	
	/**�����߻�������*/
	protected String[] pporgnames_three;
	
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		super.reset(mapping, request);
		this.roleids_one = null;
		this.rolenames_one = null;
		this.ppuserids_one = null;
		this.ppusernames_one = null;
		this.pporgids_one = null;
		this.pporgnames_one = null;
		this.roleids_two = null;
		this.rolenames_two = null;
		this.ppuserids_two = null;
		this.ppusernames_two = null;
		this.pporgids_two = null;
		this.pporgnames_two = null;
		this.roleids_three = null;
		this.rolenames_three = null;
		this.ppuserids_three = null;
		this.ppusernames_three = null;
		this.pporgids_three = null;
		this.pporgnames_three = null;
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
	public String[] getRoleids_one() {
		return roleids_one;
	}
	
	/**
	 * ���ò����߽�ɫID
	 * @param roleids_one �����߽�ɫID
	 */
	public void setRoleids_one(String[] roleids_one) {
		this.roleids_one = roleids_one;
	}
	
	/**
	 * ��ȡ�����߽�ɫ����
	 * @return �����߽�ɫ����
	 */
	public String[] getRolenames_one() {
		return rolenames_one;
	}
	
	/**
	 * ���ò����߽�ɫ����
	 * @param rolenames_one �����߽�ɫ����
	 */
	public void setRolenames_one(String[] rolenames_one) {
		this.rolenames_one = rolenames_one;
	}
	
	/**
	 * ��ȡ�������û�ID
	 * @return �������û�ID
	 */
	public String[] getPpuserids_one() {
		return ppuserids_one;
	}
	
	/**
	 * ���ò������û�ID
	 * @param ppuserids_one �������û�ID
	 */
	public void setPpuserids_one(String[] ppuserids_one) {
		this.ppuserids_one = ppuserids_one;
	}
	
	/**
	 * ��ȡ�������û�����
	 * @return �������û�����
	 */
	public String[] getPpusernames_one() {
		return ppusernames_one;
	}
	
	/**
	 * ���ò������û�����
	 * @param ppusernames_one �������û�����
	 */
	public void setPpusernames_one(String[] ppusernames_one) {
		this.ppusernames_one = ppusernames_one;
	}
	
	/**
	 * ��ȡ�����߻���ID
	 * @return �����߻���ID
	 */
	public String[] getPporgids_one() {
		return pporgids_one;
	}
	
	/**
	 * ���ò����߻���ID
	 * @param pporgids_one �����߻���ID
	 */
	public void setPporgids_one(String[] pporgids_one) {
		this.pporgids_one = pporgids_one;
	}
	
	/**
	 * ��ȡ�����߻�������
	 * @return �����߻�������
	 */
	public String[] getPporgnames_one() {
		return pporgnames_one;
	}
	
	/**
	 * ���ò����߻�������
	 * @param pporgnames_one �����߻�������
	 */
	public void setPporgnames_one(String[] pporgnames_one) {
		this.pporgnames_one = pporgnames_one;
	}
	/**
	 * ��ȡ�����߽�ɫID
	 * @return �����߽�ɫID
	 */
	public String[] getRoleids_two() {
		return roleids_two;
	}
	
	/**
	 * ���ò����߽�ɫID
	 * @param roleids_two �����߽�ɫID
	 */
	public void setRoleids_two(String[] roleids_two) {
		this.roleids_two = roleids_two;
	}
	
	/**
	 * ��ȡ�����߽�ɫ����
	 * @return �����߽�ɫ����
	 */
	public String[] getRolenames_two() {
		return rolenames_two;
	}
	
	/**
	 * ���ò����߽�ɫ����
	 * @param rolenames_two �����߽�ɫ����
	 */
	public void setRolenames_two(String[] rolenames_two) {
		this.rolenames_two = rolenames_two;
	}
	
	/**
	 * ��ȡ�������û�ID
	 * @return �������û�ID
	 */
	public String[] getPpuserids_two() {
		return ppuserids_two;
	}
	
	/**
	 * ���ò������û�ID
	 * @param ppuserids_two �������û�ID
	 */
	public void setPpuserids_two(String[] ppuserids_two) {
		this.ppuserids_two = ppuserids_two;
	}
	
	/**
	 * ��ȡ�������û�����
	 * @return �������û�����
	 */
	public String[] getPpusernames_two() {
		return ppusernames_two;
	}
	
	/**
	 * ���ò������û�����
	 * @param ppusernames_two �������û�����
	 */
	public void setPpusernames_two(String[] ppusernames_two) {
		this.ppusernames_two= ppusernames_two;
	}
	
	/**
	 * ��ȡ�����߻���ID
	 * @return �����߻���ID
	 */
	public String[] getPporgids_two() {
		return pporgids_two;
	}
	
	/**
	 * ���ò����߻���ID
	 * @param pporgids_two �����߻���ID
	 */
	public void setPporgids_two(String[] pporgids_two) {
		this.pporgids_two = pporgids_two;
	}
	
	/**
	 * ��ȡ�����߻�������
	 * @return �����߻�������
	 */
	public String[] getPporgnames_two() {
		return pporgnames_two;
	}
	
	/**
	 * ���ò����߻�������
	 * @param pporgnames_two �����߻�������
	 */
	public void setPporgnames_two(String[] pporgnames_two) {
		this.pporgnames_two = pporgnames_two;
	}
	/**
	 * ��ȡ�����߽�ɫID
	 * @return �����߽�ɫID
	 */
	public String[] getRoleids_three() {
		return roleids_three;
	}

	/**
	 * ���ò����߽�ɫID
	 * @param roleids_three �����߽�ɫID
	 */
	public void setRoleids_three(String[] roleids_three) {
		this.roleids_three = roleids_three;
	}

	/**
	 * ��ȡ�����߽�ɫ����
	 * @return �����߽�ɫ����
	 */
	public String[] getRolenames_three() {
		return rolenames_three;
	}

	/**
	 * ���ò����߽�ɫ����
	 * @param rolenames_three �����߽�ɫ����
	 */
	public void setRolenames_three(String[] rolenames_three) {
		this.rolenames_three = rolenames_three;
	}

	/**
	 * ��ȡ�������û�ID
	 * @return �������û�ID
	 */
	public String[] getPpuserids_three() {
		return ppuserids_three;
	}

	/**
	 * ���ò������û�ID
	 * @param ppuserids �������û�ID
	 */
	public void setPpuserids_three(String[] ppuserids_three) {
		this.ppuserids_three = ppuserids_three;
	}

	/**
	 * ��ȡ�������û�����
	 * @return �������û�����
	 */
	public String[] getPpusernames_three() {
		return ppusernames_three;
	}

	/**
	 * ���ò������û�����
	 * @param ppusernames_three �������û�����
	 */
	public void setPpusernames_three(String[] ppusernames_three) {
		this.ppusernames_three = ppusernames_three;
	}

	/**
	 * ��ȡ�����߻���ID
	 * @return �����߻���ID
	 */
	public String[] getPporgids_three() {
		return pporgids_three;
	}
	
	/**
	 * ���ò����߻���ID
	 * @param pporgids_three �����߻���ID
	 */
	public void setPporgids_three(String[] pporgids_three) {
		this.pporgids_three = pporgids_three;
	}
	
	/**
	 * ��ȡ�����߻�������
	 * @return �����߻�������
	 */
	public String[] getPporgnames_three() {
		return pporgnames_three;
	}

	/**
	 * ���ò����߻�������
	 * @param pporgnames_three �����߻�������
	 */
	public void setPporgnames_three(String[] pporgnames_three) {
		this.pporgnames_three = pporgnames_three;
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
		if ( roleids_one != null ) {
			if (!IGStringUtils.isValidBytes(appendStr(roleids_one),MAX_BYTE)) {
				errors.add(Globals.ERROR_KEY, new ActionMessage("IGPRM0304.E001"));
			}
		}
		if ( rolenames_one != null ) {
			if (!IGStringUtils.isValidBytes(appendStr(rolenames_one),MAX_BYTE)) {
				errors.add(Globals.ERROR_KEY, new ActionMessage("IGPRM0304.E001"));
			}
		}
		if ( ppuserids_one != null ) {
			if (!IGStringUtils.isValidBytes(appendStr(ppuserids_one),MAX_BYTE)) {
				errors.add(Globals.ERROR_KEY, new ActionMessage("IGPRM0304.E001"));
			}
		}
		if ( ppusernames_one != null ) {
			if (!IGStringUtils.isValidBytes(appendStr(ppusernames_one),MAX_BYTE)) {
				errors.add(Globals.ERROR_KEY, new ActionMessage("IGPRM0304.E001"));
			}
		}
		if ( pporgids_one != null ) {
			if (!IGStringUtils.isValidBytes(appendStr(pporgids_one),MAX_BYTE)) {
				errors.add(Globals.ERROR_KEY, new ActionMessage("IGPRM0304.E001"));
			}
		}
		if ( pporgnames_one != null ) {
			if (!IGStringUtils.isValidBytes(appendStr(pporgnames_one),MAX_BYTE)) {
				errors.add(Globals.ERROR_KEY, new ActionMessage("IGPRM0304.E001"));
			}
		}
		
		if ( roleids_two != null ) {
			if (!IGStringUtils.isValidBytes(appendStr(roleids_two),MAX_BYTE)) {
				errors.add(Globals.ERROR_KEY, new ActionMessage("IGPRM0304.E002"));
			}
		}
		if ( rolenames_two != null ) {
			if (!IGStringUtils.isValidBytes(appendStr(rolenames_two),MAX_BYTE)) {
				errors.add(Globals.ERROR_KEY, new ActionMessage("IGPRM0304.E002"));
			}
		}
		if ( ppuserids_two != null ) {
			if (!IGStringUtils.isValidBytes(appendStr(ppuserids_two),MAX_BYTE)) {
				errors.add(Globals.ERROR_KEY, new ActionMessage("IGPRM0304.E002"));
			}
		}
		if ( ppusernames_two != null ) {
			if (!IGStringUtils.isValidBytes(appendStr(ppusernames_two),MAX_BYTE)) {
				errors.add(Globals.ERROR_KEY, new ActionMessage("IGPRM0304.E002"));
			}
		}
		if ( pporgids_two != null ) {
			if (!IGStringUtils.isValidBytes(appendStr(pporgids_two),MAX_BYTE)) {
				errors.add(Globals.ERROR_KEY, new ActionMessage("IGPRM0304.E002"));
			}
		}
		if ( pporgnames_two != null ) {
			if (!IGStringUtils.isValidBytes(appendStr(pporgnames_two),MAX_BYTE)) {
				errors.add(Globals.ERROR_KEY, new ActionMessage("IGPRM0304.E002"));
			}
		}
		
		
		if ( roleids_three != null ) {
			if (!IGStringUtils.isValidBytes(appendStr(roleids_three),MAX_BYTE)) {
				errors.add(Globals.ERROR_KEY, new ActionMessage("IGPRM0304.E003"));
			}
		}
		if ( rolenames_three != null ) {
			if (!IGStringUtils.isValidBytes(appendStr(rolenames_three),MAX_BYTE)) {
				errors.add(Globals.ERROR_KEY, new ActionMessage("IGPRM0304.E003"));
			}
		}
		if ( ppuserids_three != null ) {
			if (!IGStringUtils.isValidBytes(appendStr(ppuserids_three),MAX_BYTE)) {
				errors.add(Globals.ERROR_KEY, new ActionMessage("IGPRM0304.E003"));
			}
		}
		if ( ppusernames_three != null ) {
			if (!IGStringUtils.isValidBytes(appendStr(ppusernames_three),MAX_BYTE)) {
				errors.add(Globals.ERROR_KEY, new ActionMessage("IGPRM0304.E003"));
			}
		}
		if ( pporgids_three != null ) {
			if (!IGStringUtils.isValidBytes(appendStr(pporgids_three),MAX_BYTE)) {
				errors.add(Globals.ERROR_KEY, new ActionMessage("IGPRM0304.E003"));
			}
		}
		if ( pporgnames_three != null ) {
			if (!IGStringUtils.isValidBytes(appendStr(pporgnames_three),MAX_BYTE)) {
				errors.add(Globals.ERROR_KEY, new ActionMessage("IGPRM0304.E003"));
			}
		}
		return errors;
	}
	
	private String appendStr(String[] array) {
		StringBuffer sbf = new StringBuffer("");
		for(String str : array) {
			sbf.append(str).append(WorkFlowConstDefine.SPILT_APPROVORS);//���ÿ���null
		}
		return sbf.toString();
	}

	/**
	 * ��ȡ��������
	 * @return ��������
	 */
	public String getPrtype() {
		return prtype;
	}

	/**
	 * ������������
	 * @param prtype ��������
	 */
	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}
	
}
