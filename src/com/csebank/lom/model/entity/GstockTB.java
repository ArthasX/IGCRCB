/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.csebank.lom.model.Gstock;
import com.deliverik.framework.base.BaseEntity;

/**
 * 
 * 物品实体
 * 
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name = "Gstock")
public class GstockTB extends BaseEntity implements Serializable, Cloneable,
		Gstock {

	/** GStock主键 */
	@Id
	@TableGenerator(name = "GSTOCK_TABLE_GENERATOR", table = "SEQUENCE_GENERATOR_TABLE", 
					pkColumnName = "SEQUENCE_NAME", valueColumnName = "SEQUENCE_VALUE", 
					pkColumnValue = "GSTOCK_SEQUENCE", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "GSTOCK_TABLE_GENERATOR")
	protected Integer gsid;
	/** 物品种类 */
	protected String gscategory;
	/** 物品名称 */
	protected String gsname;
	/** 物品编号 */
	protected String gscode;
	/** 总数量 */
	protected Integer gsnum;
	/** 所属机构层次码 */
	protected String gsorg;
	/** 采购平均价 */
	protected BigDecimal gsavgprice;
	/** 冻结数量 */
	protected Integer gsfreezenum;
	/** 最后一次更新人ID */
	protected String gsuserid;
	/** 最后一次更新人姓名 */
	protected String gsusername;
	/** 最后一次更新时间 */
	protected String gsdate;

	/**
	 * 主键ID取得
	 * @return 主键ID
	 */
	public Integer getGsid() {
		return gsid;
	}
	/**
	 * 主键ID
	 * @param gsid 主键ID
	 */
	public void setGsid(Integer gsid) {
		this.gsid = gsid;
	}
	/**
	 * 物品种类取得
	 * @return 物品种类
	 */
	public String getGscategory() {
		return gscategory;
	}
	/**
	 * 物品种类
	 * @param 物品种类
	 */
	public void setGscategory(String gscategory) {
		this.gscategory = gscategory;
	}
	/**
	 * 物品名称取得
	 * @return 物品名称
	 */
	public String getGsname() {
		return gsname;
	}
	/**
	 * 物品名称
	 * @param 物品名称
	 */
	public void setGsname(String gsname) {
		this.gsname = gsname;
	}
	/**
	 * 物品编号取得
	 * @return 物品编号
	 */
	public String getGscode() {
		return gscode;
	}
	/**
	 * 物品编号
	 * @param 物品编号
	 */
	public void setGscode(String gscode) {
		this.gscode = gscode;
	}
	/**
	 * 总数量取得
	 * @return 总数量
	 */
	public Integer getGsnum() {
		return gsnum;
	}
	/**
	 * 总数量
	 * @param 总数量
	 */
	public void setGsnum(Integer gsnum) {
		this.gsnum = gsnum;
	}
	/**
	 * 所属机构层次码取得
	 * @return 所属机构层次码
	 */
	public String getGsorg() {
		return gsorg;
	}
	/**
	 * 所属机构层次码
	 * @param 所属机构层次码
	 */
	public void setGsorg(String gsorg) {
		this.gsorg = gsorg;
	}
	/**
	 * 采购平均价取得
	 * @return 采购平均价
	 */
	public BigDecimal getGsavgprice() {
		return gsavgprice;
	}
	/**
	 * 采购平均价
	 * @param 主采购平均价
	 */
	public void setGsavgprice(BigDecimal gsavgprice) {
		this.gsavgprice = gsavgprice;
	}
	/**
	 * 冻结数量取得
	 * @return 冻结数量
	 */
	public Integer getGsfreezenum() {
		return gsfreezenum;
	}
	/**
	 * 冻结数量
	 * @param 冻结数量
	 */
	public void setGsfreezenum(Integer gsfreezenum) {
		this.gsfreezenum = gsfreezenum;
	}

	public String getGsuserid() {
		return gsuserid;
	}
	public void setGsuserid(String gsuserid) {
		this.gsuserid = gsuserid;
	}
	public String getGsusername() {
		return gsusername;
	}
	public void setGsusername(String gsusername) {
		this.gsusername = gsusername;
	}
	public String getGsdate() {
		return gsdate;
	}
	public void setGsdate(String gsdate) {
		this.gsdate = gsdate;
	}
	@Override
	public Serializable getPK() {
		return gsid;
	}

}
