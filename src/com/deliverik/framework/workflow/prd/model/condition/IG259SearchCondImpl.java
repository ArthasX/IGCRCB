package com.deliverik.framework.workflow.prd.model.condition;

/**
 * 流程模板信息检索条件实现
 */
public class IG259SearchCondImpl implements IG259SearchCond{
	
	/**
	 * 流程模板ID
	 */
	protected Integer ptid;

	/**
	 * 流程模板名称
	 */
	protected String ptname;

	/**
	 * 流程模板类型
	 */
	protected String pttype;

	/**
	 * 流程模板状态（a启用，i停用）
	 */
	protected String ptstatus;
	
	/**
	 * 流程模板使用位置标识（平台保留）
	 */
	protected String ptqrtzflag;
	
	/**
	 * 流程模板类型是否为工作（平台保留）
	 */
	protected int isWorkPt;

	/**
	 * 流程模板状态（a启用，i停用，t测试）
	 */
	protected String[] ptstatuses;

	
	
	/**
	 * 流程模板ID取得
	 * @return 流程模板ID
	 */
	public Integer getPtid() {
		return ptid;
	}

	/**
	 * 流程模板ID设定
	  * @param ptid 流程模板ID
	 */
	public void setPtid(Integer ptid) {
		this.ptid = ptid;
	}

	/**
	 * 流程模板名称取得
	 * @return 流程模板名称
	 */
	public String getPtname() {
		return ptname;
	}

	/**
	 * 流程模板名称设定
	  * @param ptname 流程模板名称
	 */
	public void setPtname(String ptname) {
		this.ptname = ptname;
	}

	/**
	 * 流程模板类型取得
	 * @return 流程模板类型
	 */
	public String getPttype() {
		return pttype;
	}

	/**
	 * 流程模板类型设定
	  * @param pttype 流程模板类型
	 */
	public void setPttype(String pttype) {
		this.pttype = pttype;
	}

	/**
	 * 流程模板状态（a启用，i停用）取得
	 * @return 流程模板状态
	 */
	public String getPtstatus() {
		return ptstatus;
	}

	/**
	 * 流程模板状态设定
	  * @param ptstatus 流程模板状态
	 */
	public void setPtstatus(String ptstatus) {
		this.ptstatus = ptstatus;
	}

	/**
	 * 流程模板使用位置标识（平台保留）取得
	 * @return 流程模板使用位置标识
	 */
	public String getPtqrtzflag() {
		return ptqrtzflag;
	}

	/**
	 * 流程模板使用位置标识设定
	  * @param ptqrtzflag 流程模板使用位置标识
	 */
	public void setPtqrtzflag(String ptqrtzflag) {
		this.ptqrtzflag = ptqrtzflag;
	}
	
	/**
	 * 流程模板类型是否为工作（平台保留）取得
	 * @return 流程模板类型是否为工作
	 */
	public int getIsWorkPt() {
		return isWorkPt;
	}

	/**
	 * 流程模板类型是否为工作设定
	  * @param isWorkPt 流程模板类型是否为工作
	 */
	public void setIsWorkPt(int isWorkPt) {
		this.isWorkPt = isWorkPt;
	}

	/**
	 * 流程模板状态（a启用，i停用，t测试）取得
	 * @return 流程模板状态（a启用，i停用，t测试）
	 */
	public String[] getPtstatuses() {
		return ptstatuses;
	}

	/**
	 * 流程模板状态（a启用，i停用，t测试）设定
	 * @param ptstatuses 流程模板状态（a启用，i停用，t测试）
	 */
	public void setPtstatuses(String[] ptstatuses) {
		this.ptstatuses = ptstatuses;
	}

	
	
}
