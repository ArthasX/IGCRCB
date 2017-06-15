/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.smr.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.infogovernor.smr.model.ReportDetailVWInfo;


/**
  * 概述: 监控报表详细页视图
  * 功能描述: 监控报表详细页视图
  * 创建记录: 2013/09/04
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
public class ReportDetailVW implements Serializable,
		Cloneable, ReportDetailVWInfo {
	
	/** 主键ID */
	@Id
	protected Integer id;
	
	/** 用户ID */
	protected String userid;

	/** 用户姓名 */
	protected String username;

	/** 机构ID */
	protected String orgid;

	/** 名称(年报) */
	protected String name_y;

	/** 是否及时（年报）0-及时 1-不及时 */
	protected String ontime_y;
	
	/** 是否准确（年报）大于1不准确 */
	protected String con_y;
	
	/** 名称(季报) */
	protected String name_m;

	/** 是否及时（季报）0-及时 1-不及时 */
	protected String ontime_m;
	
	/** 是否准确（季报）大于1不准确 */
	protected String con_m;
	
	/** 名称(不定期) */
	protected String name_z;

	/** 是否及时（不定期）0-及时 1-不及时 */
	protected String ontime_z;
	
	/** 是否准确（不定期）大于1不准确 */
	protected String con_z;


	
	
	/**
	 * 主键ID取得
	 *
	 * @return 主键ID
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 主键ID设定
	 *
	 * @param id 主键ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 用户ID取得
	 *
	 * @return 用户ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * 用户ID设定
	 *
	 * @param userid 用户ID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * 用户姓名取得
	 *
	 * @return 用户姓名
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 用户姓名设定
	 *
	 * @param username 用户姓名
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 机构ID取得
	 *
	 * @return 机构ID
	 */
	public String getOrgid() {
		return orgid;
	}

	/**
	 * 机构ID设定
	 *
	 * @param orgid 机构ID
	 */
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	/**
	 * 名称（年报）取得
	 *
	 * @return 名称（年报）
	 */
	public String getName_y() {
		return name_y;
	}

	/**
	 * 名称（年报）设定
	 *
	 * @param name_y 名称（年报）
	 */
	public void setName_y(String name_y) {
		this.name_y = name_y;
	}

	/**
	 * 是否及时（年报）0-及时 1-不及时 取得
	 *
	 * @return 是否及时（年报）0-及时 1-不及时
	 */
	public String getOntime_y() {
		return ontime_y;
	}

	/**
	 * 是否及时（年报）0-及时 1-不及时 设定
	 *
	 * @param ontime_y 是否及时（年报）0-及时 1-不及时
	 */
	public void setOntime_y(String ontime_y) {
		this.ontime_y = ontime_y;
	}

	/**
	 * 是否准确（年报）大于1不准确 取得
	 *
	 * @return 是否准确（年报）大于1不准确
	 */
	public String getCon_y() {
		return con_y;
	}

	/**
	 * 是否准确（年报）大于1不准确 设定
	 *
	 * @param con_y 是否准确（年报）大于1不准确
	 */
	public void setCon_y(String con_y) {
		this.con_y = con_y;
	}

	/**
	 * 名称（季报）取得
	 *
	 * @return 名称（季报）
	 */
	public String getName_m() {
		return name_m;
	}

	/**
	 * 名称（季报）设定
	 *
	 * @param name_m 名称（季报）
	 */
	public void setName_m(String name_m) {
		this.name_m = name_m;
	}

	/**
	 * 是否及时（季报）0-及时 1-不及时 取得
	 *
	 * @return 是否及时（季报）0-及时 1-不及时
	 */
	public String getOntime_m() {
		return ontime_m;
	}

	/**
	 * 是否及时（季报）0-及时 1-不及时 设定
	 *
	 * @param ontime_m 是否及时（季报）0-及时 1-不及时
	 */
	public void setOntime_m(String ontime_m) {
		this.ontime_m = ontime_m;
	}

	/**
	 * 是否准确（季报）大于1不准确 取得
	 *
	 * @return 是否准确（季报）大于1不准确
	 */
	public String getCon_m() {
		return con_m;
	}

	/**
	 * 是否准确（季报）大于1不准确 设定
	 *
	 * @param con_m 是否准确（季报）大于1不准确
	 */
	public void setCon_m(String con_m) {
		this.con_m = con_m;
	}

	/**
	 * 名称（不定期）取得
	 *
	 * @return 名称（不定期）
	 */
	public String getName_z() {
		return name_z;
	}

	/**
	 * 名称（不定期）设定
	 *
	 * @param name_z 名称（不定期）
	 */
	public void setName_z(String name_z) {
		this.name_z = name_z;
	}

	/**
	 * 是否及时（不定期）0-及时 1-不及时 取得
	 *
	 * @return 是否及时（不定期）0-及时 1-不及时
	 */
	public String getOntime_z() {
		return ontime_z;
	}

	/**
	 * 是否及时（不定期）0-及时 1-不及时 设定
	 *
	 * @param ontime_z 是否及时（不定期）0-及时 1-不及时
	 */
	public void setOntime_z(String ontime_z) {
		this.ontime_z = ontime_z;
	}

	/**
	 * 是否准确（不定期）大于1不准确 取得
	 *
	 * @return 是否准确（不定期）大于1不准确
	 */
	public String getCon_z() {
		return con_z;
	}

	/**
	 * 是否准确（不定期）大于1不准确 设定
	 *
	 * @param con_z 是否准确（不定期）大于1不准确
	 */
	public void setCon_z(String con_z) {
		this.con_z = con_z;
	}

}
