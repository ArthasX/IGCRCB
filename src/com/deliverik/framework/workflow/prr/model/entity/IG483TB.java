/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prr.model.IG483Info;

/**
  * 概述: 流程组实例表实体
  * 功能描述: 流程组实例表实体
  * 创建记录: 2015/02/03
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="IG483")
public class IG483TB extends BaseEntity implements Serializable,
		Cloneable, IG483Info {

	/** 主键 */
	@Id
	@TableGenerator(
		name="IG483_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="IG483_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="IG483_TABLE_GENERATOR")
	protected Integer pgrid;

	/** 流程组发起人id */
	protected String pgruserid;

	/** 流程组发起人名称 */
	protected String pgrusername;

	/** 流程组发起时间 */
	protected String pgropentime;

	/** 流程组关闭时间 */
	protected String pgrclosetime;

	/** 发起流程数量 */
	protected Integer ocount;

	/** 关闭流程数量 */
	protected Integer ccount;

	/** 流程组序列号 */
	protected String pgrserialnum;

	/** 流程组标题 */
	protected String pgrtitle;

	/** 流程组发起人机构码 */
	protected String pgrorgid;

	/** 流程组发起人机构名称 */
	protected String pgrorgname;

	/** 流程组定义id */
	protected String pgdid;

	/** 流程组定义名称 */
	protected String pgdname;

	/** 流程模版类型 */
	protected String pttype;
	
	/** 是否测试数据 */
	protected String istest;

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getPgrid() {
		return pgrid;
	}

	/**
	 * 主键设定
	 *
	 * @param pgrid 主键
	 */
	public void setPgrid(Integer pgrid) {
		this.pgrid = pgrid;
	}

	/**
	 * 流程组发起人id取得
	 *
	 * @return 流程组发起人id
	 */
	public String getPgruserid() {
		return pgruserid;
	}

	/**
	 * 流程组发起人id设定
	 *
	 * @param pgruserid 流程组发起人id
	 */
	public void setPgruserid(String pgruserid) {
		this.pgruserid = pgruserid;
	}

	/**
	 * 流程组发起人名称取得
	 *
	 * @return 流程组发起人名称
	 */
	public String getPgrusername() {
		return pgrusername;
	}

	/**
	 * 流程组发起人名称设定
	 *
	 * @param pgrusername 流程组发起人名称
	 */
	public void setPgrusername(String pgrusername) {
		this.pgrusername = pgrusername;
	}

	/**
	 * 流程组发起时间取得
	 *
	 * @return 流程组发起时间
	 */
	public String getPgropentime() {
		return pgropentime;
	}

	/**
	 * 流程组发起时间设定
	 *
	 * @param pgropentime 流程组发起时间
	 */
	public void setPgropentime(String pgropentime) {
		this.pgropentime = pgropentime;
	}

	/**
	 * 流程组关闭时间取得
	 *
	 * @return 流程组关闭时间
	 */
	public String getPgrclosetime() {
		return pgrclosetime;
	}

	/**
	 * 流程组关闭时间设定
	 *
	 * @param pgrclosetime 流程组关闭时间
	 */
	public void setPgrclosetime(String pgrclosetime) {
		this.pgrclosetime = pgrclosetime;
	}

	/**
	 * 发起流程数量取得
	 *
	 * @return 发起流程数量
	 */
	public Integer getOcount() {
		return ocount;
	}

	/**
	 * 发起流程数量设定
	 *
	 * @param ocount 发起流程数量
	 */
	public void setOcount(Integer ocount) {
		this.ocount = ocount;
	}

	/**
	 * 关闭流程数量取得
	 *
	 * @return 关闭流程数量
	 */
	public Integer getCcount() {
		return ccount;
	}

	/**
	 * 关闭流程数量设定
	 *
	 * @param ccount 关闭流程数量
	 */
	public void setCcount(Integer ccount) {
		this.ccount = ccount;
	}

	/**
	 * 流程组序列号取得
	 *
	 * @return 流程组序列号
	 */
	public String getPgrserialnum() {
		return pgrserialnum;
	}

	/**
	 * 流程组序列号设定
	 *
	 * @param pgrserialnum 流程组序列号
	 */
	public void setPgrserialnum(String pgrserialnum) {
		this.pgrserialnum = pgrserialnum;
	}

	/**
	 * 流程组标题取得
	 *
	 * @return 流程组标题
	 */
	public String getPgrtitle() {
		return pgrtitle;
	}

	/**
	 * 流程组标题设定
	 *
	 * @param pgrtitle 流程组标题
	 */
	public void setPgrtitle(String pgrtitle) {
		this.pgrtitle = pgrtitle;
	}

	/**
	 * 流程组发起人机构码取得
	 *
	 * @return 流程组发起人机构码
	 */
	public String getPgrorgid() {
		return pgrorgid;
	}

	/**
	 * 流程组发起人机构码设定
	 *
	 * @param pgrorgid 流程组发起人机构码
	 */
	public void setPgrorgid(String pgrorgid) {
		this.pgrorgid = pgrorgid;
	}

	/**
	 * 流程组发起人机构名称取得
	 *
	 * @return 流程组发起人机构名称
	 */
	public String getPgrorgname() {
		return pgrorgname;
	}

	/**
	 * 流程组发起人机构名称设定
	 *
	 * @param pgrorgname 流程组发起人机构名称
	 */
	public void setPgrorgname(String pgrorgname) {
		this.pgrorgname = pgrorgname;
	}

	/**
	 * 流程组定义id取得
	 *
	 * @return 流程组定义id
	 */
	public String getPgdid() {
		return pgdid;
	}

	/**
	 * 流程组定义id设定
	 *
	 * @param pgdid 流程组定义id
	 */
	public void setPgdid(String pgdid) {
		this.pgdid = pgdid;
	}

	/**
	 * 流程组定义名称取得
	 *
	 * @return 流程组定义名称
	 */
	public String getPgdname() {
		return pgdname;
	}

	/**
	 * 流程组定义名称设定
	 *
	 * @param pgdname 流程组定义名称
	 */
	public void setPgdname(String pgdname) {
		this.pgdname = pgdname;
	}
	
	/**
	 * 流程模版类型取得
	 * 
	 * @return 流程模版类型
	 */
	public String getPttype() {
		return pttype;
	}

	/**
	 * 流程模版类型设定
	 * 
	 * @param pttype 流程模版类型
	 */
	public void setPttype(String pttype) {
		this.pttype = pttype;
	}
	
	/**
	 * 是否测试数据设定
	 * @return 是否测试数据
	 */
	public String getIstest() {
		return istest;
	}

	/**
	 * 是否测试数据取得
	 * @param istest 是否测试数据
	 */
	public void setIstest(String istest) {
		this.istest = istest;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return pgrid;
	}

}