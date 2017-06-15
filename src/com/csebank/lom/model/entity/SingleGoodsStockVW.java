/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.csebank.lom.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.csebank.lom.model.SingleGoodsStock;


/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 食堂管理_统计汇总_单一物品库存统计信息
 * </p>
 * 
 * @author wuzhenqiu@deliverik.com
 * @version 1.0
 */
@Table(name = "SingleGoodsStockVW")
@SuppressWarnings("serial")
@Entity
@IdClass(SingleGoodsStockVWPK.class)
//public class ChangeKpiVW extends BaseEntity implements Serializable, Cloneable, ChangeKpi {
public class SingleGoodsStockVW implements Serializable, Cloneable, SingleGoodsStock {

	@Id
	/**日期 */
	protected String giodtime;
	@Id
	/**出入库类型 */
	protected String giodtype;
	
	/**部门名*/
	//protected String orgname;
	
	/**出库数量*/
	protected Integer giodoutnum;

	/**入库数量*/
	protected Integer giodinnum;
	
	/**库存量*/
	protected Integer giodnum;
	
	/**接待ID*/
	protected Integer rid;
	
	/** 接待管理实体 */
	@OneToOne
	@JoinColumn(name="rid", referencedColumnName="rid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected RecptionTB recptionTB;
	
	public Serializable getPK() {
		return giodtime;
	}
	
	/**
	 * 日期
	 * @return 日期
	 */
	public String getGiodtime() {
		return giodtime;
	}
	
	/**
	 * 日期
	 * @param giodininnum 日期
	 */
	public void setGiodtime(String giodtime) {
		this.giodtime = giodtime;
	}
	
	/**
	 * 出入库类型
	 * @return 出入库类型
	 */
	public String getGiodtype() {
		return giodtype;
	}
	
	/**
	 * 出入库类型
	 * @param giodtype 出入库类型
	 */
	public void setGiodtype(String giodtype) {
		this.giodtype = giodtype;
	}
	
	/**
	 * 部门名
	 * @return 部门名

	public String getOrgname() {
		return orgname;
	}
	
	/**
	 * 部门名
	 * @param orgname 部门名
	 
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}
	*/
	/**
	 * 出库数量
	 * @return 出库数量
	 */
	public Integer getGiodoutnum() {
		return giodoutnum;
	}
	
	/**
	 * 出库数量
	 * @param orgname 出库数量
	 */
	public void setGiodoutnum(Integer giodoutnum) {
		this.giodoutnum = giodoutnum;
	}
	
	/**
	 * 入库数量
	 * @return 入库数量
	 */
	public Integer getGiodinnum() {
		return giodinnum;
	}
	
	/**
	 * 入库数量
	 * @param giodinnum 入库数量
	 */
	public void setGiodinnum(Integer giodinnum) {
		this.giodinnum = giodinnum;
	}
	
	/**
	 * 库存量
	 * @return 库存量
	 */
	public Integer getGiodnum() {
		return giodnum;
	}
	
	/**
	 * 库存量
	 * @param giodnum 库存量
	 */
	public void setGiodnum(Integer giodnum) {
		this.giodnum = giodnum;
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
}
