/*
 * 北京递蓝科软件技术有限公司版权所有,保留所有权利.
 */

package com.deliverik.infogovernor.dut.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.dut.bl.IGDUTCONSTANTS;
import com.deliverik.infogovernor.dut.model.condition.DutyPlanSearchCond;

/**
 * 值班交接查询Form
 *
 */
public class IGDUT0204Form extends BaseForm implements DutyPlanSearchCond{

	private static final long serialVersionUID = 1L;
	
	/** 值班计划状态 执行中*/
	protected String dpstatus = IGDUTCONSTANTS.PLAN_STATUS_EXECUTING;
	
	/** 值班类型 */
	protected String dadcategory;
	
	/** 值班日期 当前日期*/
	protected String dptime;
	
	/** 遗留问题 */
	protected String dpquestion;
	
	/** 总结 */
	protected String dpinfo;
	
	/** 值班日期（大于等于匹配） */
	protected String dptime_ge;
	
	/** 用户id */
	protected String[] userid;
	
	/** 密码 */
	protected String[] password;
	
	/** 交班计划ID */
	protected Integer dpid_executing;
	
	/** 接班计划ID */
	protected Integer dpid_unexecute;
	
	/**
	 * 值班计划状态取得
	 * @return 值班计划状态
	 */
	public String getDpstatus() {
		return dpstatus;
	}

	/**
	 * 值班计划状态设定
	 *
	 * @param dpstatus 值班计划状态
	 */
	public void setDpstatus(String dpstatus) {
		this.dpstatus = dpstatus;
	}

	/**
	 * 值班类型取得
	 * @return 值班类型
	 */
	public String getDadcategory() {
		return dadcategory;
	}

	/**
	 * 值班类型设定
	 *
	 * @param dadcategory 值班类型
	 */
	public void setDadcategory(String dadcategory) {
		this.dadcategory = dadcategory;
	}

	/**
	 * 值班日期取得
	 * @return 值班日期
	 */
	public String getDptime() {
		return dptime;
	}

	/**
	 * 值班日期设定
	 *
	 * @param dptime 值班日期
	 */
	public void setDptime(String dptime) {
		this.dptime = dptime;
	}

	/**
	 * 遗留问题取得
	 * @return 遗留问题
	 */
	public String getDpquestion() {
		return dpquestion;
	}

	/**
	 * 遗留问题设定
	 *
	 * @param dpquestion 遗留问题
	 */
	public void setDpquestion(String dpquestion) {
		this.dpquestion = dpquestion;
	}

	/**
	 * 总结取得
	 * @return 总结
	 */
	public String getDpinfo() {
		return dpinfo;
	}

	/**
	 * 总结设定
	 *
	 * @param dpinfo 总结
	 */
	public void setDpinfo(String dpinfo) {
		this.dpinfo = dpinfo;
	}
	
	/**
	 * 值班日期（大于等于匹配）取得
	 * @return 值班日期（大于等于匹配）
	 */
	public String getDptime_ge() {
		return dptime_ge;
	}

	/**
	 * 值班日期（大于等于匹配）设定
	 *
	 * @param dptime_ge 值班日期（大于等于匹配）
	 */
	public void setDptime_ge(String dptime_ge) {
		this.dptime_ge = dptime_ge;
	}
	
	/**
	 * 密码取得
	 * @return 密码
	 */
	public String[] getPassword() {
		return password;
	}

	/**
	 * 密码设定
	 *
	 * @param password 密码
	 */
	public void setPassword(String[] password) {
		this.password = password;
	}
	
	/**
	 * 用户id取得
	 * @return 用户id
	 */
	public String[] getUserid() {
		return userid;
	}

	/**
	 * 用户id设定
	 *
	 * @param userid 用户id
	 */
	public void setUserid(String[] userid) {
		this.userid = userid;
	}
	
	/**
	 * 交班计划ID取得
	 * @return 交班计划ID
	 */
	public Integer getDpid_executing() {
		return dpid_executing;
	}

	/**
	 * 交班计划ID设定
	 *
	 * @param dpid_unexecute 交班计划ID
	 */
	public void setDpid_executing(Integer dpid_executing) {
		this.dpid_executing = dpid_executing;
	}

	/**
	 * 接班计划ID取得
	 * @return 接班计划ID
	 */
	public Integer getDpid_unexecute() {
		return dpid_unexecute;
	}

	/**
	 * 接班计划ID设定
	 *
	 * @param dpid_unexecute 接班计划ID
	 */
	public void setDpid_unexecute(Integer dpid_unexecute) {
		this.dpid_unexecute = dpid_unexecute;
	}

	/**
	 * 初始化处理
	 *
	 * @param mapping 
	 * @param request 
	 */
	public void reset(ActionMapping mapping,HttpServletRequest request){
		super.reset(mapping, request);
		this.dptime = null;
		this.dptime_ge = null;
	}

	public String getDptype() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDptime_le() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getDpid() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
