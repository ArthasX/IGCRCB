package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.asset.model.condition.CIResultSearchCond;
import com.deliverik.framework.base.BaseForm;

/**
 * CI变更对比结果查询画面FORM
 * 
 */
public class IGASM2202Form extends BaseForm implements CIResultSearchCond{
	
	private static final long serialVersionUID = 1L;

	
	/** CI变更时间戳 开始 */
	protected String citime_from;
	
	/** CI变更时间戳 结束 */
	protected String citime_to;
	
	/** CI变更任务描述 */
	protected String citdesc;
	
	/** 资产层次码 */
	protected String esyscoding;
	
	/** 资产名称 */
	protected String ename;
	
	/** 合理标识 */
	protected Integer[] checkbox;
	
	/** CI变更ID */
	protected Integer[] cirids;
	
	/** CI变更结果说明 */
	protected String[] ciresultdesces;



	/**
	 * CI变更任务描述取得
	 * @return CI变更任务描述
	 */
	public String getCitdesc() {
		return citdesc;
	}

	/**
	 * CI变更任务描述设定
	 * @param citdesc CI变更任务描述
	 */
	public void setCitdesc(String citdesc) {
		this.citdesc = citdesc;
	}

	/**
	 * CI变更时间戳 开始取得
	 * @return CI变更时间戳 开始
	 */
	public String getCitime_from() {
		return citime_from;
	}

	/**
	 * CI变更时间戳 开始设定
	 * @param citime_from CI变更时间戳 开始
	 */
	public void setCitime_from(String citime_from) {
		this.citime_from = citime_from;
	}

	/**
	 * CI变更时间戳 结束取得
	 * @return CI变更时间戳 结束
	 */
	public String getCitime_to() {
		return citime_to;
	}

	/**
	 * CI变更时间戳 结束设定
	 * @param citime_to CI变更时间戳 结束
	 */
	public void setCitime_to(String citime_to) {
		this.citime_to = citime_to;
	}

	/**
	 * 资产层次码取得
	 * @return 资产层次码
	 */
	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * 资产层次码设定
	 * @param esyscoding 资产层次码
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	/**
	 * 资产名称取得
	 * @return 资产名称
	 */
	public String getEname() {
		return ename;
	}

	/**
	 * 资产名称设定
	 * @param einame 资产名称
	 */
	public void setEname(String ename) {
		this.ename = ename;
	}

	/**
	 * 合理标识取得
	 * @return 合理标识
	 */
	public Integer[] getCheckbox() {
		return checkbox;
	}

	/**
	 * 合理标识设定
	 * @param checkbox 合理标识
	 */
	public void setCheckbox(Integer[] checkbox) {
		this.checkbox = checkbox;
	}

	/**
	 * CI变更结果说明取得
	 * @return CI变更结果说明
	 */
	public String[] getCiresultdesces() {
		return ciresultdesces;
	}

	/**
	 * CI变更结果说明设定 
	 * @param ciresultdesces CI变更结果说明
	 */
	public void setCiresultdesces(String[] ciresultdesces) {
		this.ciresultdesces = ciresultdesces;
	}

	/**
	 * CI变更ID取得
	 * @return CI变更ID
	 */
	public Integer[] getCirids() {
		return cirids;
	}

	/**
	 * CI变更ID设定
	 * @param cirids CI变更ID
	 */
	public void setCirids(Integer[] cirids) {
		this.cirids = cirids;
	}
	

}
