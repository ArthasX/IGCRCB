/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程类型_缺省审批人FormBean
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGPRM0304Form extends BaseForm {
	
	/** 缺省审批人信息最大字节数 */
	private static final int MAX_BYTE = 512;
	
	/**类型ID*/
	protected String pdid;
	
	/**流程类型*/
	protected String prtype;

	/**处理方式：0-删除，1-增加*/
	protected String mode;
	
	/**参与者角色ID*/
	protected String[] roleids_one;
	
	/**参与者角色名称*/
	protected String[] rolenames_one;
	
	/**参与者用户ID*/
	protected String[] ppuserids_one;
	
	/**参与者用户名称*/
	protected String[] ppusernames_one;
	
	/**参与者机构ID*/
	protected String[] pporgids_one;
	
	/**参与者机构名称*/
	protected String[] pporgnames_one;
	
	/**参与者角色ID*/
	protected String[] roleids_two;
	
	/**参与者角色名称*/
	protected String[] rolenames_two;
	
	/**参与者用户ID*/
	protected String[] ppuserids_two;
	
	/**参与者用户名称*/
	protected String[] ppusernames_two;
	
	/**参与者机构ID*/
	protected String[] pporgids_two;
	
	/**参与者机构名称*/
	protected String[] pporgnames_two;
	
	/**参与者角色ID*/
	protected String[] roleids_three;

	/**参与者角色名称*/
	protected String[] rolenames_three;

	/**参与者用户ID*/
	protected String[] ppuserids_three;
	
	/**参与者用户名称*/
	protected String[] ppusernames_three;
	
	/**参与者机构ID*/
	protected String[] pporgids_three;
	
	/**参与者机构名称*/
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
	 * 获取流程类型ID
	 * @return 流程类型ID
	 */
	public String getPdid() {
		return pdid;
	}
	
	/**
	 * 设置流程类型ID
	 * @param pdid 流程类型ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}
	
	/**
	 * 获取处理方式
	 * @return 处理方式
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * 设置处理方式
	 * @param mode 处理方式
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}
	
	/**
	 * 获取参与者角色ID
	 * @return 参与者角色ID
	 */
	public String[] getRoleids_one() {
		return roleids_one;
	}
	
	/**
	 * 设置参与者角色ID
	 * @param roleids_one 参与者角色ID
	 */
	public void setRoleids_one(String[] roleids_one) {
		this.roleids_one = roleids_one;
	}
	
	/**
	 * 获取参与者角色名称
	 * @return 参与者角色名称
	 */
	public String[] getRolenames_one() {
		return rolenames_one;
	}
	
	/**
	 * 设置参与者角色名称
	 * @param rolenames_one 参与者角色名称
	 */
	public void setRolenames_one(String[] rolenames_one) {
		this.rolenames_one = rolenames_one;
	}
	
	/**
	 * 获取参与者用户ID
	 * @return 参与者用户ID
	 */
	public String[] getPpuserids_one() {
		return ppuserids_one;
	}
	
	/**
	 * 设置参与者用户ID
	 * @param ppuserids_one 参与者用户ID
	 */
	public void setPpuserids_one(String[] ppuserids_one) {
		this.ppuserids_one = ppuserids_one;
	}
	
	/**
	 * 获取参与者用户名称
	 * @return 参与者用户名称
	 */
	public String[] getPpusernames_one() {
		return ppusernames_one;
	}
	
	/**
	 * 设置参与者用户名称
	 * @param ppusernames_one 参与者用户名称
	 */
	public void setPpusernames_one(String[] ppusernames_one) {
		this.ppusernames_one = ppusernames_one;
	}
	
	/**
	 * 获取参与者机构ID
	 * @return 参与者机构ID
	 */
	public String[] getPporgids_one() {
		return pporgids_one;
	}
	
	/**
	 * 设置参与者机构ID
	 * @param pporgids_one 参与者机构ID
	 */
	public void setPporgids_one(String[] pporgids_one) {
		this.pporgids_one = pporgids_one;
	}
	
	/**
	 * 获取参与者机构名称
	 * @return 参与者机构名称
	 */
	public String[] getPporgnames_one() {
		return pporgnames_one;
	}
	
	/**
	 * 设置参与者机构名称
	 * @param pporgnames_one 参与者机构名称
	 */
	public void setPporgnames_one(String[] pporgnames_one) {
		this.pporgnames_one = pporgnames_one;
	}
	/**
	 * 获取参与者角色ID
	 * @return 参与者角色ID
	 */
	public String[] getRoleids_two() {
		return roleids_two;
	}
	
	/**
	 * 设置参与者角色ID
	 * @param roleids_two 参与者角色ID
	 */
	public void setRoleids_two(String[] roleids_two) {
		this.roleids_two = roleids_two;
	}
	
	/**
	 * 获取参与者角色名称
	 * @return 参与者角色名称
	 */
	public String[] getRolenames_two() {
		return rolenames_two;
	}
	
	/**
	 * 设置参与者角色名称
	 * @param rolenames_two 参与者角色名称
	 */
	public void setRolenames_two(String[] rolenames_two) {
		this.rolenames_two = rolenames_two;
	}
	
	/**
	 * 获取参与者用户ID
	 * @return 参与者用户ID
	 */
	public String[] getPpuserids_two() {
		return ppuserids_two;
	}
	
	/**
	 * 设置参与者用户ID
	 * @param ppuserids_two 参与者用户ID
	 */
	public void setPpuserids_two(String[] ppuserids_two) {
		this.ppuserids_two = ppuserids_two;
	}
	
	/**
	 * 获取参与者用户名称
	 * @return 参与者用户名称
	 */
	public String[] getPpusernames_two() {
		return ppusernames_two;
	}
	
	/**
	 * 设置参与者用户名称
	 * @param ppusernames_two 参与者用户名称
	 */
	public void setPpusernames_two(String[] ppusernames_two) {
		this.ppusernames_two= ppusernames_two;
	}
	
	/**
	 * 获取参与者机构ID
	 * @return 参与者机构ID
	 */
	public String[] getPporgids_two() {
		return pporgids_two;
	}
	
	/**
	 * 设置参与者机构ID
	 * @param pporgids_two 参与者机构ID
	 */
	public void setPporgids_two(String[] pporgids_two) {
		this.pporgids_two = pporgids_two;
	}
	
	/**
	 * 获取参与者机构名称
	 * @return 参与者机构名称
	 */
	public String[] getPporgnames_two() {
		return pporgnames_two;
	}
	
	/**
	 * 设置参与者机构名称
	 * @param pporgnames_two 参与者机构名称
	 */
	public void setPporgnames_two(String[] pporgnames_two) {
		this.pporgnames_two = pporgnames_two;
	}
	/**
	 * 获取参与者角色ID
	 * @return 参与者角色ID
	 */
	public String[] getRoleids_three() {
		return roleids_three;
	}

	/**
	 * 设置参与者角色ID
	 * @param roleids_three 参与者角色ID
	 */
	public void setRoleids_three(String[] roleids_three) {
		this.roleids_three = roleids_three;
	}

	/**
	 * 获取参与者角色名称
	 * @return 参与者角色名称
	 */
	public String[] getRolenames_three() {
		return rolenames_three;
	}

	/**
	 * 设置参与者角色名称
	 * @param rolenames_three 参与者角色名称
	 */
	public void setRolenames_three(String[] rolenames_three) {
		this.rolenames_three = rolenames_three;
	}

	/**
	 * 获取参与者用户ID
	 * @return 参与者用户ID
	 */
	public String[] getPpuserids_three() {
		return ppuserids_three;
	}

	/**
	 * 设置参与者用户ID
	 * @param ppuserids 参与者用户ID
	 */
	public void setPpuserids_three(String[] ppuserids_three) {
		this.ppuserids_three = ppuserids_three;
	}

	/**
	 * 获取参与者用户名称
	 * @return 参与者用户名称
	 */
	public String[] getPpusernames_three() {
		return ppusernames_three;
	}

	/**
	 * 设置参与者用户名称
	 * @param ppusernames_three 参与者用户名称
	 */
	public void setPpusernames_three(String[] ppusernames_three) {
		this.ppusernames_three = ppusernames_three;
	}

	/**
	 * 获取参与者机构ID
	 * @return 参与者机构ID
	 */
	public String[] getPporgids_three() {
		return pporgids_three;
	}
	
	/**
	 * 设置参与者机构ID
	 * @param pporgids_three 参与者机构ID
	 */
	public void setPporgids_three(String[] pporgids_three) {
		this.pporgids_three = pporgids_three;
	}
	
	/**
	 * 获取参与者机构名称
	 * @return 参与者机构名称
	 */
	public String[] getPporgnames_three() {
		return pporgnames_three;
	}

	/**
	 * 设置参与者机构名称
	 * @param pporgnames_three 参与者机构名称
	 */
	public void setPporgnames_three(String[] pporgnames_three) {
		this.pporgnames_three = pporgnames_three;
	}
	
	/**
	 * 缺少审批人个数检测
	 *
	 * @param mapping
	 * @param request
	 * @return 检测错误信息
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
			sbf.append(str).append(WorkFlowConstDefine.SPILT_APPROVORS);//不用考虑null
		}
		return sbf.toString();
	}

	/**
	 * 获取流程类型
	 * @return 流程类型
	 */
	public String getPrtype() {
		return prtype;
	}

	/**
	 * 设置流程类型
	 * @param prtype 流程类型
	 */
	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}
	
}
