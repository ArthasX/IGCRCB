/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.csebank.lom.model.Eentertainment;
import com.deliverik.framework.base.BaseEntity;

/**
 * 
 * 食堂招待信息实体
 *
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="Eentertainment")
public class EentertainmentTB extends BaseEntity implements Serializable, Cloneable, Eentertainment {
	
	/** 自增无意义主键 */
	
	@TableGenerator(
		    name="EENTERTAINMENT_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="EENTERTAINMENT_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="EENTERTAINMENT_TABLE_GENERATOR")
	@Id
	protected Integer eeid;

	/** 接待工作ID */
	protected Integer rid;
	
	/** 主陪人 */
	protected String eeuser;
	
	/** 每桌菜价格 */
	protected BigDecimal eetableprice;

	/** 桌数 */
	protected Integer eetablenum;
	
	/** 酒价 */
	protected BigDecimal eedrinkprice;
	
	/** 烟价 */
	protected BigDecimal eesmokeprice;
	
	/** 其他用品价格 */
	protected BigDecimal eeotherprice;
	
	/** 日期 */
	protected String eedate;
	
	/** 接待管理实体 */
	@OneToOne
	@JoinColumn(name="rid", referencedColumnName="rid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected RecptionTB recptionTB;
	
	
	
	
	/**
	 * 主键取得
	 * @return 
	 */
	public Serializable getPK() {
		return eeid;
	}
	
	/**
	 * 自增无意义主键
	 * @return 自增无意义主键
	 */
	public Integer getEeid() {
		return eeid;
	}
	
	/**
	 * 自增无意义主键
	 * @param eid 自增无意义主键
	 */
	public void setEeid(Integer eeid) {
		this.eeid = eeid;
	}
	
	/**
	 * 接待工作ID
	 * @return 接待工作ID
	 */
	public Integer getRid() {
		return rid;
	}
	
	/**
	 * 接待工作ID
	 * @param rid 接待工作ID
	 */
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	
	/**
	 * 主陪人
	 * @return 主陪人
	 */
	public String getEeuser() {
		return eeuser;
	}
	
	/**
	 * 主陪人
	 * @param eeuser 主陪人
	 */
	public void setEeuser(String eeuser) {
		this.eeuser = eeuser;
	}
	
	/**
	 * 每桌菜价格
	 * @return 每桌菜价格
	 */
	public BigDecimal getEetableprice() {
		return eetableprice;
	}
	
	/**
	 * 每桌菜价格
	 * @param eetableprice 每桌菜价格
	 */
	public void setEetableprice(BigDecimal eetableprice) {
		this.eetableprice = eetableprice;
	}
	
	/**
	 * 桌数
	 * @return 桌数
	 */
	public Integer getEetablenum() {
		return eetablenum;
	}
	
	/**
	 * 桌数
	 * @param eetablenum 桌数
	 */
	public void setEetablenum(Integer eetablenum) {
		this.eetablenum = eetablenum;
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
	 * 其他用品价格
	 * @return 其他用品价格
	 */
	public BigDecimal getEeotherprice() {
		return eeotherprice;
	}
	
	/**
	 * 其他用品价格
	 * @param eeotherprice 其他用品价格
	 */
	public void setEeotherprice(BigDecimal eeotherprice) {
		this.eeotherprice = eeotherprice;
	}
	
	/**
	 * 日期
	 * @return 日期
	 */
	public String getEedate() {
		return eedate;
	}
	
	/**
	 * 日期
	 * @param eedate 日期
	 */
	public void setEedate(String eedate) {
		this.eedate = eedate;
	}

	public RecptionTB getRecptionTB() {
		return recptionTB;
	}
	
}
