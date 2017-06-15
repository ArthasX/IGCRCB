/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.form;

import com.csebank.lom.model.condition.RecptionGuestSearchCond;
import com.deliverik.framework.base.BaseForm;

/**
 * 
 * 接待工作管理Form
 *
 */
public class IGLOM0104Form extends BaseForm implements RecptionGuestSearchCond {
	
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 接待工作ID
	 */
	protected Integer rid;
	
	/** 删除接待客人对象 */
	protected String[] deleteRgid;
	
	/** 状态（1进行中，2结束） */
	protected String rstatus;
	
	protected String flag;
	

	/**
	 * 接待工作ID取得
	 * @return 接待工作ID
	 */
	public Integer getRid() {
		return rid;
	}

	/**
	 * 接待工作ID设定
	 * @param rid 接待工作ID
	 */
	public void setRid(Integer rid) {
		this.rid = rid;
	}

	/**
	 * 删除接待客人对象取得
	 * @return 删除接待客人对象
	 */
	public String[] getDeleteRgid() {
		return deleteRgid;
	}

	/**
	 * 删除接待客人对象设定
	 * @param deleteRgid 删除接待客人对象
	 */
	public void setDeleteRgid(String[] deleteRgid) {
		this.deleteRgid = deleteRgid;
	}

	/**
	 * 状态取得
	 * @return 状态
	 */
	public String getRstatus() {
		return rstatus;
	}

	/**
	 * 状态设定
	 * @param rstatus 状态
	 */
	public void setRstatus(String rstatus) {
		this.rstatus = rstatus;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

}
