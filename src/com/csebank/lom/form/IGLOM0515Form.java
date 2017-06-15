/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.csebank.lom.form;

import com.csebank.lom.model.condition.SingleGoodsStockSearchCond;
import com.deliverik.framework.base.BaseForm;
/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 食堂管理_食堂单一物品库存统计FormBean
 * </p>
 * 
 * @author wuzhenqiu@deliverik.com
 * @version 1.0
 */

public class IGLOM0515Form extends BaseForm implements SingleGoodsStockSearchCond{
	private static final long serialVersionUID = 1L;
	
	/** 物品种类 */
	protected String giodcategory;
	
	/** 物品名称 */
	protected String goods;
	
	/** 物品编号 */
	protected String giodcode;
	
	/** 食堂组织 */
	public String giodorg;
	
	/**
	 * 统计开始时间查询
	 */
	public String etime_from;
	
	/**
	 * 统计结束时间查询
	 */
	public String etime_to;
	
	/**
	 * 日期
	 */
	public String edate;
	
	/**
	 * 统计开始时间查询
	 * @return 统计开始时间查询
	 */
	public String getEtime_from() {
		return etime_from;
	}
	
	/**
	 * 统计开始时间查询
	 * @param etime_from 统计开始时间查询
	 */
	public void setEtime_from(String etime_from) {
		this.etime_from = etime_from;
	}
	
	/**
	 * 统计结束时间查询
	 * @return 统计结束时间查询
	 */
	public String getEtime_to() {
		return etime_to;
	}
	
	/**
	 * 统计结束时间查询
	 * @param etime_to 统计结束时间查询
	 */
	public void setEtime_to(String etime_to) {
		this.etime_to = etime_to;
	}
	
	/**
	 * 日期
	 * @return 日期
	 */
	public String getEdate() {
		return edate;
	}
	
	/**
	 * 日期
	 * @param edate 日期
	 */
	public void setEdate(String edate) {
		this.edate = edate;
	}

	public String getGoods() {
		return goods;
	}

	public void setGoods(String goods) {
		this.goods = goods;
	}

	public String getGiodcategory() {
		return giodcategory;
	}

	public void setGiodcategory(String giodcategory) {
		this.giodcategory = giodcategory;
	}

	public String getGiodorg() {
		return giodorg;
	}

	public void setGiodorg(String giodorg) {
		this.giodorg = giodorg;
	}

	public String getGiodcode() {
		return giodcode;
	}

	public void setGiodcode(String giodcode) {
		this.giodcode = giodcode;
	}
}
