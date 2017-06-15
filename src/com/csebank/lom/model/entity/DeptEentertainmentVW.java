/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.csebank.lom.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.csebank.lom.model.DeptEentertainment;


/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 食堂管理_统计汇总_招待统计信息
 * </p>
 * 
 * @author wuzhenqiu@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
@Entity
//public class ChangeKpiVW extends BaseEntity implements Serializable, Cloneable, ChangeKpi {
public class DeptEentertainmentVW implements Serializable, Cloneable, DeptEentertainment {

	@Id
	/**日期 */
	protected Integer rid;
	protected String edept;
	
	/** 招待次数*/
	protected BigDecimal enumber;
	
	/** 菜价*/
	protected BigDecimal eefoodprice;

	/**酒价*/
	protected BigDecimal eedrinkprice;
	
	/**烟价*/
	protected BigDecimal eesmokeprice;
	
	protected BigDecimal eeotherprice;
	
	/**合计 */
	protected BigDecimal etotal;
	
	/** 接待管理实体 */
	@OneToOne
	@JoinColumn(name="rid", referencedColumnName="rid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected RecptionTB recptionTB;
	
	public Serializable getPK() {
		return edept;
	}
	
	/**
	 * 日期
	 * @return 日期
	 */
	public String getEdept() {
		return edept;
	}
	
	/**
	 * 日期
	 * @param edept 日期
	 */
	public void setEdept(String edept) {
		this.edept = edept;
	}
	
	/**
	 * 招待次数
	 * @return 招待次数
	 */
	public BigDecimal getEnumber() {
		return enumber;
	}
	
	/**
	 * 招待次数
	 * @param enumber 招待次数
	 */
	public void setEnumber(BigDecimal enumber) {
		this.enumber = enumber;
	}
	
	/**
	 * 菜价
	 * @return 菜价
	 */
	public BigDecimal getEefoodprice() {
		return eefoodprice;
	}
	
	/**
	 * 菜价
	 * @param eefoodprice 菜价
	 */
	public void setEefoodprice(BigDecimal eefoodprice) {
		this.eefoodprice = eefoodprice;
	}
	
	/**
	 * 酒价
	 * @return 酒价
	 */
	public BigDecimal getEedrinkprice() {
		return eedrinkprice;
	}
	
	/**
	 * 酒价
	 * @param eedrinkprice 酒价
	 */
	public void setEedrinkprice(BigDecimal eedrinkprice) {
		this.eedrinkprice = eedrinkprice;
	}
	
	/**
	 * 烟价
	 * @return 烟价
	 */
	public BigDecimal getEesmokeprice() {
		return eesmokeprice;
	}
	
	/**
	 * 烟价
	 * @param eesmokeprice 烟价
	 */
	public void setEesmokeprice(BigDecimal eesmokeprice) {
		this.eesmokeprice = eesmokeprice;
	}
	
	/**
	 * 合计
	 * @return 合计
	 */
	public BigDecimal getEtotal() {
		return etotal;
	}
	
	/**
	 * 合计
	 * @param etotal 合计
	 */
	public void setEtotal(BigDecimal etotal) {
		this.etotal = etotal;
	}

	public RecptionTB getRecptionTB() {
		return recptionTB;
	}

	public void setRecptionTB(RecptionTB recptionTB) {
		this.recptionTB = recptionTB;
	}

	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public BigDecimal getEeotherprice() {
		return eeotherprice;
	}

	public void setEeotherprice(BigDecimal eeotherprice) {
		this.eeotherprice = eeotherprice;
	}

}
