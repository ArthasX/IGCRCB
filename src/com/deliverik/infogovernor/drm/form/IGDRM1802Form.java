package com.deliverik.infogovernor.drm.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 应急管理
 * 预案统计钻取Form
 * 
 * @author zhangjian
 *
 */
@SuppressWarnings("serial")
public class IGDRM1802Form extends BaseForm {

	/**登记时间起始*/
	protected String eiinstimeFrom;
	/**登记时间终止*/
	protected String eiinstimeTo;
	
	/**资产层级码*/
	protected String esyscoding;
	
	/**查询标识*/
	protected String searchFlag;
	
	protected String einame;
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
	public String getEsyscoding() {
		return esyscoding;
	}
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}
	public String getSearchFlag() {
		return searchFlag;
	}
	public void setSearchFlag(String searchFlag) {
		this.searchFlag = searchFlag;
	}
	public String getEiname() {
		return einame;
	}
	public void setEiname(String einame) {
		this.einame = einame;
	}
	
	
}
