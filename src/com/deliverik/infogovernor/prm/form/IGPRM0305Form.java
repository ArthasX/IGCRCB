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
 * Description: 流程类型_缺省审批分派人FormBean
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGPRM0305Form extends BaseForm {
	
	/** 缺省审批分派人信息最大字节数 */
	private static final int MAX_BYTE = 512;
	
	/**类型ID*/
	protected String pdid;

	/**处理方式：0-删除，1-增加*/
	protected String mode;
	
	/**参与者角色ID*/
	protected String[] roleids;
	
	/**参与者角色名称*/
	protected String[] rolenames;
	
	/**参与者用户ID*/
	protected String[] ppuserids;
	
	/**参与者用户名称*/
	protected String[] ppusernames;
	
	/**参与者机构ID*/
	protected String[] pporgids;
	
	/**参与者机构名称*/
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
	 * 缺少审批人个数检测
	 *
	 * @param mapping
	 * @param request
	 * @return 检测错误信息
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
			sbf.append(str).append(WorkFlowConstDefine.SPILT_APPROVORS);//不用考虑null
		}
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
	public String[] getRoleids() {
		return roleids;
	}
	
	/**
	 * 设置参与者角色ID
	 * @param roleids 参与者角色ID
	 */
	public void setRoleids(String[] roleids) {
		this.roleids = roleids;
	}
	
	/**
	 * 获取参与者角色名称
	 * @return 参与者角色名称
	 */
	public String[] getRolenames() {
		return rolenames;
	}
	
	/**
	 * 设置参与者角色名称
	 * @param rolenames 参与者角色名称
	 */
	public void setRolenames(String[] rolenames) {
		this.rolenames = rolenames;
	}
	
	/**
	 * 获取参与者用户ID
	 * @return 参与者用户ID
	 */
	public String[] getPpuserids() {
		return ppuserids;
	}
	
	/**
	 * 设置参与者用户ID
	 * @param ppuserids 参与者用户ID
	 */
	public void setPpuserids(String[] ppuserids) {
		this.ppuserids = ppuserids;
	}
	
	/**
	 * 获取参与者用户名称
	 * @return 参与者用户名称
	 */
	public String[] getPpusernames() {
		return ppusernames;
	}
	
	/**
	 * 设置参与者用户名称
	 * @param ppusernames 参与者用户名称
	 */
	public void setPpusernames(String[] ppusernames) {
		this.ppusernames = ppusernames;
	}
	
	/**
	 * 获取参与者机构ID
	 * @return 参与者机构ID
	 */
	public String[] getPporgids() {
		return pporgids;
	}
	
	/**
	 * 设置参与者机构ID
	 * @param pporgids 参与者机构ID
	 */
	public void setPporgids(String[] pporgids) {
		this.pporgids = pporgids;
	}
	
	/**
	 * 获取参与者机构名称
	 * @return 参与者机构名称
	 */
	public String[] getPporgnames() {
		return pporgnames;
	}
	
	/**
	 * 设置参与者机构名称
	 * @param pporgnames 参与者机构名称
	 */
	public void setPporgnames(String[] pporgnames) {
		this.pporgnames = pporgnames;
	}

}
