/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.sym.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.sym.model.CustomReport;

/**
 * 
 * @Description:订制报表实体TB类
 * @Author
 * @History
 * @Version V1.0
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "CUSTOMREPORT")
public class CustomReportTB extends BaseEntity implements Serializable,
		Cloneable, CustomReport {
	/** 主键ID */
	@Id
	@TableGenerator(name = "CUSTOMREPORT_TABLE_GENERATOR", table = "SEQUENCE_GENERATOR_TABLE", 
					pkColumnName = "SEQUENCE_NAME", valueColumnName = "SEQUENCE_VALUE", 
					pkColumnValue = "CUSTOMREPORT_SEQUENCE", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "CUSTOMREPORT_TABLE_GENERATOR")
	protected Integer crid;

	/**
	 *主键ID取得
	 * 
	 * @return 主键ID
	 */
	public Integer getCrid() {
		return crid;
	}

	/**
	 *主键ID设定
	 * 
	 * @param crid主键ID
	 */
	public void setCrid(Integer crid) {
		this.crid = crid;
	}

	/**
	 *用户名ID
	 */
	protected String userid;

	/**
	 *用户名ID取得
	 * 
	 * @return 用户名ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 *用户名ID设定
	 * 
	 * @param userid用户名ID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 *报表ID
	 */
	protected Integer rfdid;

	/**
	 *报表ID取得
	 * 
	 * @return 报表ID
	 */
	public Integer getRfdid() {
		return rfdid;
	}

	/**
	 *报表ID设定
	 * 
	 * @param rfdid报表ID
	 */
	public void setRfdid(Integer rfdid) {
		this.rfdid = rfdid;
	}

	/**
	 *排序编号
	 */
	protected Integer ordernum;

	/**
	 *排序编号取得
	 * 
	 * @return 排序编号
	 */
	public Integer getOrdernum() {
		return ordernum;
	}

	/**
	 *排序编号设定
	 * 
	 * @param ordernum排序编号
	 */
	public void setOrdernum(Integer ordernum) {
		this.ordernum = ordernum;
	}

	@Override
	public Serializable getPK() {
		// TODO Auto-generated method stub
		return crid;
	}
}
