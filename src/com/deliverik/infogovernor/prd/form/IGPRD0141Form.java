/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.prd.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.workflow.prd.model.IG156Info;
import com.deliverik.framework.workflow.prd.model.entity.IG900TB;

/**
 * 表单信息查询画面Form
 * 
 * 
 */
@SuppressWarnings("serial")
public class IGPRD0141Form extends BaseForm implements IG156Info{
	
	/** 前处理变量值最大字节数 */
	protected static final int MAX_BYTE = 64;
	
	protected String mode = "0";

	protected String pseid;
	
	protected String psebuttonid;
	
	protected String pseactionid;

	/** 流程定义ID */
	protected String pdid;

	/** 状态ID */
	protected String psdid;

	/** 事件执行顺序 */
	protected Integer pseorder;
	
	/** 加入描述 */
	protected String psedec;
	
	/** 状态代码*/
	protected String psdcode;
	
	/** 按钮名称*/
	protected String psbdname;

	/** 上级状态ID */
	protected String ppsdid;

	public String getPsdcode() {
		return psdcode;
	}

	public void setPsdcode(String psdcode) {
		this.psdcode = psdcode;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}
	/** 查看模式 0最新：可编辑，1：历史：只查看 */
	protected String viewhistory;

	/**
	 * 查看模式
	 *
	 * @return 查看模式
	 */
	public String getViewhistory() {
		return viewhistory;
	}

	/**
	 * 查看模式
	 *
	 * @param viewHistory  0：最新，1历史
	 */
	public void setViewhistory(String viewhistory) {
		this.viewhistory = viewhistory;
	}

	

	public String getPseid() {
		return pseid;
	}

	public void setPseid(String pseid) {
		this.pseid = pseid;
	}

	public String getPsebuttonid() {
		return psebuttonid;
	}

	public void setPsebuttonid(String psebuttonid) {
		this.psebuttonid = psebuttonid;
	}

	public String getPseactionid() {
		return pseactionid;
	}

	public void setPseactionid(String pseactionid) {
		this.pseactionid = pseactionid;
	}

	public String getPdid() {
		return pdid;
	}

	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	public String getPsdid() {
		return psdid;
	}

	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	public Integer getPseorder() {
		return pseorder;
	}

	public void setPseorder(Integer pseorder) {
		this.pseorder = pseorder;
	}

	public String getPsedec() {
		return psedec;
	}

	public void setPsedec(String psedec) {
		this.psedec = psedec;
	}

	public String getFingerPrint() {
		// TODO Auto-generated method stub
		return null;
	}

	public IG900TB getProcessButtonDefTB() {
		// TODO Auto-generated method stub
		return null;
	}

    /**
     * @return the 按钮名称
     */
    public String getPsbdname() {
        return psbdname;
    }

    /**
     * @param 按钮名称 the psbdname to set
     */
    public void setPsbdname(String psbdname) {
        this.psbdname = psbdname;
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

}
