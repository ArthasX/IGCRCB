/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.prd.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.workflow.prd.model.IG413Info;

/**
 * 表单信息查询画面Form
 * 
 * @author liupeng@deliverik.com
 */
@SuppressWarnings("serial")
public class IGPRD0126Form extends BaseForm implements IG413Info{
	
	/** 前处理变量值最大字节数 */
	protected static final int MAX_BYTE = 64;
	
	protected String mode = "0";

	protected String pedid;

	/** 流程定义ID */
	protected String pdid;

	/** 状态ID */
	protected String psdid;

	/** 动作ID */
	protected String pedactionid;

	/** 事件类型 */
	protected String pedtype;

	/** 自定义BL名称 */
	protected String pedblid;

	/** 事件执行顺序 */
	protected Integer pedorder;
	
	/** 加入描述 */
	protected String pedec;

	/** 上级状态ID */
	protected String ppsdid;

	public String getPedec() {
		return pedec;
	}

	public void setPedec(String pedec) {
		this.pedec = pedec;
	}

	public String getPedid() {
		return pedid;
	}

	public void setPedid(String pedid) {
		this.pedid = pedid;
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

	public String getPedactionid() {
		return pedactionid;
	}

	public void setPedactionid(String pedactionid) {
		this.pedactionid = pedactionid;
	}

	public String getPedtype() {
		return pedtype;
	}

	public void setPedtype(String pedtype) {
		this.pedtype = pedtype;
	}

	public String getPedblid() {
		return pedblid;
	}

	public void setPedblid(String pedblid) {
		this.pedblid = pedblid;
	}

	public Integer getPedorder() {
		return pedorder;
	}

	public void setPedorder(Integer pedorder) {
		this.pedorder = pedorder;
	}

	public String getFingerPrint() {
		
		return null;
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
