/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.form;

import com.csebank.lom.model.condition.LunchCardSearchCond;
import com.deliverik.framework.base.BaseForm;

/**
 * 
 * 餐卡登记变更Form
 *
 */
public class IGLOM0519Form extends BaseForm  implements LunchCardSearchCond {


	private static final long serialVersionUID = 1L;

	/** 自增无意义主键 */
	protected Integer icid;

	/** 数据类型 */
	protected String selectid;
	
	/** 数据名称 */
	protected String selectname;
	
	/** 餐卡编号 */
	protected String typecode;
	
	/** 餐卡名称 */
	protected String typename;
	
	/** 无意义 */
	protected String type;
	
	/** 餐卷面值 */
	protected String prince;
	
	/** 补贴 */
	protected String allowance;
	
	/** 可用性 */
	protected String desc;
	
	/** 无意义 */
	protected String status;

	/**
	 * 页面标题显示标志0-新增,1-变更
	 */
	protected String mode = "0";	

	public String getFingerPrint() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 页面标题显示取得
	 * @return 页面标题显示
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * 页面标题显示设定
	 * @param mode 页面标题显示
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}

	public Integer getIcid() {
		return icid;
	}

	public void setIcid(Integer icid) {
		this.icid = icid;
	}

	public String getSelectid() {
		return selectid;
	}

	public void setSelectid(String selectid) {
		this.selectid = selectid;
	}

	public String getSelectname() {
		return selectname;
	}

	public void setSelectname(String selectname) {
		this.selectname = selectname;
	}

	public String getTypecode() {
		return typecode;
	}

	public void setTypecode(String typecode) {
		this.typecode = typecode;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPrince() {
		return prince;
	}

	public void setPrince(String prince) {
		this.prince = prince;
	}

	public String getAllowance() {
		return allowance;
	}

	public void setAllowance(String allowance) {
		this.allowance = allowance;
	}

}
