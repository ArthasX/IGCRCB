/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prr.dto;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.infogovernor.prr.form.IGPRR0114Form;
import com.deliverik.infogovernor.prr.model.CopyReadUserInfo;

/**
 * 概述:抄阅人 
 * 功能描述：抄阅人
 * 创建人：赵梓廷
 * 创建记录： 2013-02-25
 * 修改记录：
 */
@SuppressWarnings("serial")
public class IGPRR02DTO extends BaseDTO {
	
	
	/**抄阅人form*/
	protected IGPRR0114Form igprr0114form;
	
	/**页面map集合*/	
	protected Map<String,List<UserRoleInfo>> map_cru;
	
	/**流程id*/	
	protected String prid;
	
	/** 检索最大件数 */
	protected int maxSearchCount;

	/** 翻页用DTO */
	protected PagingDTO pagingDto;

	/** 当前登录用户 */
	protected User user;
	
	/**查询结果*/
	protected List<CopyReadUserInfo> list;
	
	/**流程信息*/
	protected IG500Info ig500;
	/** 图像扫描XML */
	protected String picuXml;
	
	/** 图像查看XML */
	protected String picsXml;
   
	/**
	 * 抄阅人form取得
	 * @return 抄阅人form
	 */
	public IGPRR0114Form getIgprr0114form() {
		return igprr0114form;
	}
	/**
	 * 抄阅人form设定
	 *
	 * @param igprr0114form 抄阅人form
	 */
	public void setIgprr0114form(IGPRR0114Form igprr0114form) {
		this.igprr0114form = igprr0114form;
	}
	/**
	 * 页面map集合取得
	 * @return 页面map集合
	 */
	public Map<String, List<UserRoleInfo>> getMap_cru() {
		return map_cru;
	}
	/**
	 * 页面map集合设定
	 *
	 * @param map_cru 页面map集合
	 */
	public void setMap_cru(Map<String, List<UserRoleInfo>> map_cru) {
		this.map_cru = map_cru;
	}

	/**
	 * 流程id取得
	 * @return 流程id
	 */
	public String getPrid() {
		return prid;
	}
	/**
	 * 流程id设定
	 *
	 * @param prid 流程id
	 */
	public void setPrid(String prid) {
		this.prid = prid;
	}
	/**
	 * 检索最大件数取得
	 * @return 检索最大件数
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * 检索最大件数设定
	 *
	 * @param maxSearchCount 检索最大件数
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * 翻页用DTO取得
	 * @return 翻页用DTO
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * 翻页用DTO设定
	 *
	 * @param pagingDto 翻页用DTO
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}
	/**
	 * 当前登录用户取得
	 * @return 当前登录用户
	 */
	public User getUser() {
		return user;
	}
	/**
	 * 当前登录用户设定
	 *
	 * @param user 当前登录用户
	 */
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * 查询结果取得
	 * @return 查询结果
	 */
	public List<CopyReadUserInfo> getList() {
		return list;
	}
	/**
	 * 查询结果设定
	 *
	 * @param user 查询结果
	 */
	public void setList(List<CopyReadUserInfo> list) {
		this.list = list;
	}
	public IG500Info getIg500() {
		return ig500;
	}
	public void setIg500(IG500Info ig500) {
		this.ig500 = ig500;
	}
	public String getPicuXml() {
		return picuXml;
	}

	public void setPicuXml(String picuXml) {
		this.picuXml = picuXml;
	}

	public String getPicsXml() {
		return picsXml;
	}

	public void setPicsXml(String picsXml) {
		this.picsXml = picsXml;
	}


	
}
