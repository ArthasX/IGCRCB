/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.csebank.lom.form;

import com.csebank.lom.model.condition.GoodsStockSearchCond;
import com.deliverik.framework.base.BaseForm;
/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 食堂管理_食堂物品库存月汇总统计FormBean
 * </p>
 * 
 * @author wuzhenqiu@deliverik.com
 * @version 1.0
 */

public class IGLOM0514Form extends BaseForm implements GoodsStockSearchCond{
	private static final long serialVersionUID = 1L;
	
	/** 物品编号 */
	protected String goods;
	/** 物品名 */
	protected String goodsN;
	/** 食堂组织 */
	public String giodorg;
	
	/** 年 */
	protected String year;

	/** 月 */
	protected String month;
	protected String flag;
	
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
	 * 年
	 * @return 年
	 */
	public String getYear() {
		return year;
	}
	
	/**
	 * 年
	 * @param year 年
	 */
	public void setYear(String year) {
		this.year = year;
	}
	
	/**
	 * 月
	 * @return 月
	 */
	public String getMonth() {
		return month;
	}
	
	/**
	 * 月
	 * @param year 月
	 */
	public void setMonth(String month) {
		this.month = month;
	}
	
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

	public String getGiodorg() {
		return giodorg;
	}

	public void setGiodorg(String giodorg) {
		this.giodorg = giodorg;
	}

	public String getGiodcategory() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getGoodsN() {
		return goodsN;
	}

	public void setGoodsN(String goodsN) {
		this.goodsN = goodsN;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
}
