/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.smr.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.infogovernor.smr.model.FillInQualityAssessInfo;

/**
 * 概述:填报质量考核 
 * 功能描述：填报质量考核
 * 创建人：赵梓廷
 * 创建记录： 2012-12-21
 * 修改记录：
 */
@Entity
public class FillInQualityAssessVW implements FillInQualityAssessInfo{

	@Id
	protected Integer id;
	
	/** 部门机构码 */
	protected String pporgid;
	
	/** 部门机构名 */
	protected String pporgname;
	
	/** 用户id */
	protected String ppuserid;
	
	/** 用户名 */
	protected String username;
	
	/** 年报填报人id或填报部门id */
	protected String ppuserid1;
	
	/** 季报填报人id或填报部门id */
	protected String ppuserid2;
	
	/** 不定期报填报人id或填报部门id */
	protected String ppuserid3;
	
	/** 年报是否及时 */
	protected String timely1;
	
	/** 季报是否及时 */
	protected String timely2;
	
	/** 不定期报是否及时 */
	protected String timely3;
	
	/** 年报填报是否准确 */
	protected String truely1;
	
	/** 季报报填报是否准确 */
	protected String truely2;
	
	/** 不定期报表填报是否准确 */
	protected String truely3;
	
	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 主键设定
	 *
	 * @param prid 主键
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * 用户id或者部门机构码 取得
	 *
	 * @return 用户id或者部门机构码
	 */
	public String getPpuserid() {
		return ppuserid;
	}
	
	/**
	 * 用户id或者部门机构码 设定
	 *
	 * @param ppuserid 用户id或者部门机构码 
	 */
	public void setPpuserid(String ppuserid) {
		this.ppuserid = ppuserid;
	}
	/**
	 * 用户名或者部门名 取得
	 *
	 * @return 用户名或者部门名
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * 用户名或者部门名 设定
	 *
	 * @param username 用户名或者部门名
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 年报填报人id或填报部门id取得
	 *
	 * @return 年报填报人id或填报部门id
	 */
	public String getPpuserid1() {
		return ppuserid1;
	}
	/**
	 * 年报填报人id或填报部门id 设定
	 *
	 * @param ppuserid1 年报填报人id或填报部门id
	 */
	public void setPpuserid1(String ppuserid1) {
		this.ppuserid1 = ppuserid1;
	}
	/**
	 * 季报填报人id或填报部门id 取得
	 *
	 * @return 季报填报人id或填报部门id 
	 */
	public String getPpuserid2() {
		return ppuserid2;
	}
	/**
	 * 季报填报人id或填报部门id  设定
	 *
	 * @param ppuserid2 季报填报人id或填报部门id 
	 */
	public void setPpuserid2(String ppuserid2) {
		this.ppuserid2 = ppuserid2;
	}
	/**
	 *不定期报填报人id或填报部门id 取得
	 *
	 * @return 不定期报填报人id或填报部门id
	 */
	public String getPpuserid3() {
		return ppuserid3;
	}
	/**
	 * 不定期报填报人id或填报部门id  设定
	 *
	 * @param ppuserid3 不定期报填报人id或填报部门id
	 */
	public void setPpuserid3(String ppuserid3) {
		this.ppuserid3 = ppuserid3;
	}
	/**
	 *年报是否及时 取得
	 *
	 * @return 年报是否及时
	 */
	public String getTimely1() {
		return timely1;
	}
	/**
	 * 年报是否及时  设定
	 *
	 * @param timely1 年报是否及时
	 */
	public void setTimely1(String timely1) {
		this.timely1 = timely1;
	}
	/**
	 *季报是否及时 取得
	 *
	 * @return 季报是否及时
	 */
	public String getTimely2() {
		return timely2;
	}
	/**
	 * 季报是否及时  设定
	 *
	 * @param timely2 季报是否及时
	 */
	public void setTimely2(String timely2) {
		this.timely2 = timely2;
	}
	/**
	 *不定期报是否及时 取得
	 *
	 * @return 不定期报是否及时
	 */
	public String getTimely3() {
		return timely3;
	}
	/**
	 * 不定期报是否及时  设定
	 *
	 * @param timely3不定期报是否及时
	 */
	public void setTimely3(String timely3) {
		this.timely3 = timely3;
	}
	public String getPporgid() {
		return pporgid;
	}
	public void setPporgid(String pporgid) {
		this.pporgid = pporgid;
	}
	public String getPporgname() {
		return pporgname;
	}
	public void setPporgname(String pporgname) {
		this.pporgname = pporgname;
	}
	public String getTruely1() {
		return truely1;
	}
	public void setTruely1(String truely1) {
		this.truely1 = truely1;
	}
	public String getTruely2() {
		return truely2;
	}
	public void setTruely2(String truely2) {
		this.truely2 = truely2;
	}
	public String getTruely3() {
		return truely3;
	}
	public void setTruely3(String truely3) {
		this.truely3 = truely3;
	}
	
	
}
