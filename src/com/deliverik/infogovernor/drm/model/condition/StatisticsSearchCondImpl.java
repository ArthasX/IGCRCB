package com.deliverik.infogovernor.drm.model.condition;
/**
 * 概述: 应急管理模块-统计分析查询条件接口
 * 功能描述: 应急管理模块-统计分析查询条件接口
 * 创建记录: 2015/02/28
 * 修改记录: 
 */
public class StatisticsSearchCondImpl implements StatisticsSearchCond {
	
	/**登记时间起始*/
	protected String eiinstimeFrom;
	/**登记时间终止*/
	protected String eiinstimeTo;
	/**演练统计时间条件开始*/
	protected String drillTimeFrom;
	/**演练统计时间条件终止*/
	protected String drillTimeTo;
	/**专项预案名称*/
	protected String einame;
	/**资产码*/
	protected String esyscoding;
	
	/**
	 *  eiinstimeFrom获取
	 * @return  eiinstimeFrom
	 */
	public String getEiinstimeFrom() {
		return eiinstimeFrom;
	}
	/**
	 * eiinstimeFrom设定
	 * @param eiinstimeFrom 
	 */
	public void setEiinstimeFrom(String eiinstimeFrom) {
		this.eiinstimeFrom = eiinstimeFrom;
	}
	/**
	 *  eiinstimeTo获取
	 * @return  eiinstimeTo
	 */
	public String getEiinstimeTo() {
		return eiinstimeTo;
	}
	/**
	 * eiinstimeTo设定
	 * @param eiinstimeTo 
	 */
	public void setEiinstimeTo(String eiinstimeTo) {
		this.eiinstimeTo = eiinstimeTo;
	}
	public String getDrillTimeFrom() {
		return drillTimeFrom;
	}
	public void setDrillTimeFrom(String drillTimeFrom) {
		this.drillTimeFrom = drillTimeFrom;
	}
	public String getDrillTimeTo() {
		return drillTimeTo;
	}
	public void setDrillTimeTo(String drillTimeTo) {
		this.drillTimeTo = drillTimeTo;
	}
	/**
	 * @return the 专项预案名称
	 */
	public String getEiname() {
		return einame;
	}
	/**
	 * @param 专项预案名称 the einame to set
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}
	/**
	 * @return the 资产码
	 */
	public String getEsyscoding() {
		return esyscoding;
	}
	/**
	 * @param 资产码 the esyscoding to set
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

}
