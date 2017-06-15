/*
 * 北京递蓝科软件股份有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.wki.model.condition;

/**
  * 概述: 工作信息检索条件实现
  * 功能描述: 工作信息检索条件实现
  * 创建记录: 2017/03/02
  * 修改记录: 
  */
public class WorkinfoSearchCondImpl implements
		WorkinfoSearchCond {
	
	protected Integer workInfoId;
	//工作名称
	protected String workName;
	//发起人ID
	protected Integer initId;
	//发起人姓名
	protected String initName;
	//执行人id
	protected Integer execId;
	//执行人姓名
	protected String execName;
	public Integer getWorkInfoId() {
		return workInfoId;
	}
	public void setWorkInfoId(Integer workInfoId) {
		this.workInfoId = workInfoId;
	}
	public String getWorkName() {
		return workName;
	}
	public void setWorkName(String workName) {
		this.workName = workName;
	}
	public Integer getInitId() {
		return initId;
	}
	public void setInitId(Integer initId) {
		this.initId = initId;
	}
	public String getInitName() {
		return initName;
	}
	public void setInitName(String initName) {
		this.initName = initName;
	}
	public Integer getExecId() {
		return execId;
	}
	public void setExecId(Integer execId) {
		this.execId = execId;
	}
	public String getExecName() {
		return execName;
	}
	public void setExecName(String execName) {
		this.execName = execName;
	}
	
	
}