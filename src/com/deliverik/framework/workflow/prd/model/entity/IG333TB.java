/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prd.model.IG333Info;

/**
 * 流程状态
 *
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="IG333")
public class IG333TB extends BaseEntity implements Serializable, Cloneable, IG333Info {
	
	/** 流程状态ID */
	@Id
	protected String psdid;
	
	/**
	 * 流程名称ID
	 */
	protected String pdid;

	/**
	 * 流程状态名称
	 */
	protected String psdname;
	
	/**
	 * 流程状态描述
	 */
	protected String psddesc;
	
	/**
	 * 流程状态标识
	 */
	protected String psdcode;
	
	/**
	 * 流程节点类型
	 */
	protected String psdtype;
	
	/**
	 * 流程节点模式
	 */
	protected String psdmode;
	
	protected String participantchange;
	
	/** 表单全集控制标识 */
	protected String formGlobalControl;
	
	/**
	 * 流程节点是否动态取参与者标识（0正常取参与者，1动态取参与者）
	 */
	protected String psdflag;
	
	/**
	 * 分派参与者类型（0人员，1角色）
	 */
	protected String psdassign;
	
	/**
	 * 是否机构过滤（0是，1否 ）
	 */
	protected String psdorg;
	
	/**
	 * 有无确认操作（0无，1有）
	 */
	protected String psdconfirm;
	
	/**
	 * 分派节点ID
	 */
	protected String assignpsdid;
	
	/**
	 * 分派按钮ID
	 */
	protected String assignpbdid;
	
	/**
	 * 是否必须分派标识
	 */
	protected String assignflag;
	
	/**
	 * 参与者具有的流程变量权限
	 */
	@Transient
	protected String isSelected;
	
    /**
     * 分派页面类型
     */
    protected String assignPageType;
    
    /** js方法 */
    protected String jsfunction;
    
	/**
	 * 排序
	 */
	protected String bysequence;

	/** 上级状态ID */
	protected String ppsdid;
	
	/** 子流程流程图 */
	protected String psdxml;
	
	/** 动态分支条件（0：按角色，1：按用户） */
	protected String branchcond;
	
	/** 是否可代替处理 */
	protected String replaceDispose;
	
	/**
	 * 流程节点动态参与者标识取得
	 * @return 流程节点动态参与者标识
	 */
	public String getPsdflag() {
		return psdflag;
	}

	/**
	 * 流程节点动态参与者标识设定
	 * @param psdflag 流程节点动态参与者标识
	 */
	public void setPsdflag(String psdflag) {
		this.psdflag = psdflag;
	}

	/**
	 * 主键取得
	 * @return 
	 */
	public Serializable getPK() {
		return psdid;
	}
	
	/**
	 * 流程状态ID取得
	 * @return 流程状态ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * 流程状态ID设定
	 * @param psdid 流程状态ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * 流程名称ID取得
	 * @return 流程名称ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * 流程名称ID设定
	 * @param pdid 流程名称ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * 流程状态名称取得
	 * @return 流程状态名称
	 */
	public String getPsdname() {
		return psdname;
	}

	/**
	 * 流程状态名称设定
	 * @param psdname 流程状态名称
	 */
	public void setPsdname(String psdname) {
		this.psdname = psdname;
	}
	
	/**
	 * 流程状态描述取得
	 * @return 流程状态描述
	 */
	public String getPsddesc() {
		return psddesc;
	}

	/**
	 * 流程状态描述设定
	 * @param psddesc 流程状态描述
	 */
	public void setPsddesc(String psddesc) {
		this.psddesc = psddesc;
	}

	/**
	 * 流程状态标识取得
	 * @return 流程状态标识
	 */
	public String getPsdcode() {
		return psdcode;
	}

	/**
	 * 流程状态标识设定
	 * @param psdcode 流程状态标识
	 */
	public void setPsdcode(String psdcode) {
		this.psdcode = psdcode;
	}

	/**
	 * 流程节点类型取得
	 * @return 流程节点类型
	 */
	public String getPsdtype() {
		return psdtype;
	}

	/**
	 * 流程节点类型设定
	 * @param psdtype 流程节点类型
	 */
	public void setPsdtype(String psdtype) {
		this.psdtype = psdtype;
	}
	
	/**
	 * 流程节点模式取得
	 * @return 流程节点模式
	 */
	public String getPsdmode() {
		return psdmode;
	}

	/**
	 * 流程节点模式设定
	 * @param psdmode流程节点模式
	 */
	public void setPsdmode(String psdmode) {
		this.psdmode = psdmode;
	}

	/**
	 * 分派参与者类型取得
	 * 
	 * @return 分派参与者类型
	 */
	public String getPsdassign() {
		return psdassign;
	}

	/**
	 * 分派参与者类型设定
	 * 
	 * @param psdassign 分派参与者类型
	 */
	public void setPsdassign(String psdassign) {
		this.psdassign = psdassign;
	}

	/**
	 * 是否机构过滤取得
	 * 
	 * @return 是否机构过滤
	 */
	public String getPsdorg() {
		return psdorg;
	}

	/**
	 * 是否机构过滤设定
	 * 
	 * @param psdorg 是否机构过滤
	 */
	public void setPsdorg(String psdorg) {
		this.psdorg = psdorg;
	}

	/**
	 * 有无确认操作取得
	 * 
	 * @return 有无确认操作
	 */
	public String getPsdconfirm() {
		return psdconfirm;
	}

	/**
	 * 有无确认操作设定
	 * 
	 * @param psdconfirm 有无确认操作
	 */
	public void setPsdconfirm(String psdconfirm) {
		this.psdconfirm = psdconfirm;
	}
	
	/**
	 * 分派节点ID取得
	 * 
	 * @return 分派节点ID
	 */
	public String getAssignpsdid() {
		return assignpsdid;
	}

	/**
	 * 分派节点ID设定
	 * 
	 * @param assignpsdid 分派节点ID
	 */
	public void setAssignpsdid(String assignpsdid) {
		this.assignpsdid = assignpsdid;
	}

	/**
	 * 分派按钮ID取得
	 * 
	 * @return 分派按钮ID
	 */
	public String getAssignpbdid() {
		return assignpbdid;
	}

	/**
	 * 分派按钮ID设定
	 * 
	 * @param assignpbdid 分派按钮ID
	 */
	public void setAssignpbdid(String assignpbdid) {
		this.assignpbdid = assignpbdid;
	}

	public String getParticipantchange() {
		return participantchange;
	}

	public void setParticipantchange(String participantchange) {
		this.participantchange = participantchange;
	}
	
	/**
	 * 是否必须分派标识取得
	 * 
	 * @return 是否必须分派标识
	 */
	public String getAssignflag() {
		return assignflag;
	}

	/**
	 * 是否必须分派标识设定
	 * 
	 * @param assignflag 是否必须分派标识
	 */
	public void setAssignflag(String assignflag) {
		this.assignflag = assignflag;
	}
	
	public String getIsSelected() {
		return isSelected;
	}

	public void setIsSelected(String isSelected) {
		this.isSelected = isSelected;
	}

    /**
     * @return the 分派页面类型
     */
    public String getAssignPageType() {
        return assignPageType;
    }

    /**
     * @param 分派页面类型 the assginPageType to set
     */
    public void setAssignPageType(String assignPageType) {
        this.assignPageType = assignPageType;
    }

    /**
     * 表单全局控制标识取得
     * @return 表单全局控制标识
     */
	public String getFormGlobalControl() {
		return formGlobalControl;
	}

	/**
	 * 表单全集控制标识设定
	 * @param formGlobalControl 表单全局控制标识
	 */
	public void setFormGlobalControl(String formGlobalControl) {
		this.formGlobalControl = formGlobalControl;
	}

	/**
	 * js方法取得
	 * @return jsfunction js方法
	 */
	public String getJsfunction() {
		return jsfunction;
	}

	/**
	 * js方法设定
	 * @param jsfunction js方法
	 */
	public void setJsfunction(String jsfunction) {
		this.jsfunction = jsfunction;
	}

	/**
	 * 排序取得
	 * 
	 * @return 排序
	 */
	public String getBysequence() {
		return bysequence;
	}

	/**
	 * 排序设定
	 * 
	 * @param bysequence
	 *            排序
	 */
	public void setBysequence(String bysequence) {
		this.bysequence = bysequence;
	}

	/**
	 * 上级状态ID取得
	 * @return 上级状态ID
	 */
	public String getPpsdid() {
		return ppsdid;
	}

	/**
	 * 上级状态ID设定
	 * @param ppsdid 上级状态ID
	 */
	public void setPpsdid(String ppsdid) {
		this.ppsdid = ppsdid;
	}

	/**
	 * 子流程流程图取得
	 * @return 子流程流程图
	 */
	public String getPsdxml() {
		return psdxml;
	}

	/**
	 * 子流程流程图设定
	 * @param psdxml 子流程流程图
	 */
	public void setPsdxml(String psdxml) {
		this.psdxml = psdxml;
	}

	/**
	 * 动态分支条件取得
	 * @return 动态分支条件
	 */
	public String getBranchcond() {
		return branchcond;
	}

	/**
	 * 动态分支条件设定
	 * @param branchcond 动态分支条件
	 */
	public void setBranchcond(String branchcond) {
		this.branchcond = branchcond;
	}

	/**
	 * 是否可代替处理取得
	 * @return replaceDispose 是否可代替处理
	 */
	public String getReplaceDispose() {
		return replaceDispose;
	}

	/**
	 * 是否可代替处理设定
	 * @param replaceDispose 是否可代替处理
	 */
	public void setReplaceDispose(String replaceDispose) {
		this.replaceDispose = replaceDispose;
	}
	
}
