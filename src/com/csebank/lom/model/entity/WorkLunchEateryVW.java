/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.csebank.lom.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import com.csebank.lom.model.WorkLunchEatery;


/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 食堂管理_统计汇总_工作餐收益统计信息
 * </p>
 * 
 * @author wuzhenqiu@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
@IdClass(WorkLunchEateryVWPK.class)
@Entity
//public class ChangeKpiVW extends BaseEntity implements Serializable, Cloneable, ChangeKpi {
public class WorkLunchEateryVW implements Serializable, Cloneable, WorkLunchEatery {

	@Id

	/**日期 */
	protected String wldate;
	
	/** 成本合计*/
	protected String allcost;
	
	/** 调味品成本*/
	protected String eflavouringcost;

	/**采购原料成本*/
	protected String estaplecost;
	
	/**其他成本*/
	protected String eothercost;
	
	@Id
	protected String lunchcardname;
	
	protected String lunchcardnum;
	
	protected String lunchcardprice;
	
	/** 收益合计 */
	protected String incost;
	
	/** 损益合计 */
	protected String outcost;
	
	/**
	 * 日期
	 * @return 日期
	 */
	public String getWldate() {
		return wldate;
	}
	
	/**
	 * 日期
	 * @param wldate 日期
	 */
	public void setWldate(String wldate) {
		this.wldate = wldate;
	}
	
	/**
	 * 成本合计
	 * @return 成本合计
	 */
	public String getAllcost() {
		return allcost;
	}
	
	/**
	 * 成本合计
	 * @param allcost成本合计
	 */
	public void setAllcost(String allcost) {
		this.allcost = allcost;
	}
	
	/**
	 * 调味品成本
	 * @return eflavouringcost 调味品成本
	 */
	public String getEflavouringcost() {
		return eflavouringcost;
	}
	
	/**
	 * 调味品成本
	 * @param eflavouringcost 调味品成本
	 */
	public void setEflavouringcost(String eflavouringcost) {
		this.eflavouringcost = eflavouringcost;
	}
	
	/**
	 * 采购原料成本
	 * @return 采购原料成本
	 */
	public String getEstaplecost() {
		return estaplecost;
	}
	
	/**
	 * 采购原料成本
	 * @param estaplecost 采购原料成本
	 */
	public void setEstaplecost(String estaplecost) {
		this.estaplecost = estaplecost;
	}
	
	/**
	 * 其他成本
	 * @return 其他成本
	 */
	public String getEothercost() {
		return eothercost;
	}
	
	/**
	 * 其他成本
	 * @param eothercost 其他成本
	 */
	public void setEothercost(String eothercost) {
		this.eothercost = eothercost;
	}

	public String getIncost() {
		return incost;
	}

	public void setIncost(String incost) {
		this.incost = incost;
	}

	public String getOutcost() {
		return outcost;
	}

	public void setOutcost(String outcost) {
		this.outcost = outcost;
	}

	public String getLunchcardname() {
		return lunchcardname;
	}

	public void setLunchcardname(String lunchcardname) {
		this.lunchcardname = lunchcardname;
	}

	public String getLunchcardnum() {
		return lunchcardnum;
	}

	public void setLunchcardnum(String lunchcardnum) {
		this.lunchcardnum = lunchcardnum;
	}

	public String getLunchcardprice() {
		return lunchcardprice;
	}

	public void setLunchcardprice(String lunchcardprice) {
		this.lunchcardprice = lunchcardprice;
	}
}
