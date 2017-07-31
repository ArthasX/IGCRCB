/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.wim.vo;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.wim.form.IGWIM0201Form;
import com.deliverik.infogovernor.wim.model.WorkInstanceInfo;
import com.deliverik.infogovernor.wim.model.WorkLogInfo;

/**
 * @Description 工作项管理VO
 * 
 * @date 2017年6月9日16:09:40
 * 
 * @author WangLiang
 *
 */
@SuppressWarnings("serial")
public class IGWIM02011VO extends BaseVO{

	/** 工作管理Form */
	protected IGWIM0201Form igwim0201Form;
	
	/** 当前登录用户 */
	protected User user;
	
	/** 机构集合 */
	protected Map<String,String> orgMap;
	
	/** 用户机构集合 */
	List<Map<String,String>> userOrgList;
	
	/** 工作实例信息 */
	WorkInstanceInfo wiInfo;
	
	/** 工作处理日志集合 */
	List<WorkLogInfo> wlogList;
	
	/** 检索最大件数 */
	protected int maxSearchCount;

	/** 翻页用DTO */
	protected PagingDTO pagingDto;
	
	/** 工作信息 */
	List<Map<String, String>> wiList;
	
	/** 日期栏信息 */
	List<String> dateList;

	/** 日期栏(年)信息 */
	List<String> dateToWeekYearList;
	
	/** 工作是否超时未处理标识（0：未超时，1：已超时） */
	protected String isOverTime;
	
	/** 工作描述 */
	protected String desc;
	
	/**
	 * 取得 日期栏(年)信息
	 * 
	 * @return dateToWeekYearList 日期栏(年)信息
	 */
	public List<String> getDateToWeekYearList() {
		return dateToWeekYearList;
	}

	/**
	 * 设定 日期栏(年)信息
	 * 
	 * @param dateToWeekYearList 日期栏(年)信息
	 */
	public void setDateToWeekYearList(List<String> dateToWeekYearList) {
		this.dateToWeekYearList = dateToWeekYearList;
	}

	
	/**
	 * 取得 日期栏信息
	 * 
	 * @return dateList 日期栏信息
	 */
	public List<String> getDateList() {
		return dateList;
	}

	/**
	 * 设定 日期栏信息
	 * 
	 * @param dateList 日期栏信息
	 */
	public void setDateList(List<String> dateList) {
		this.dateList = dateList;
	}
	/**
	 * 取得 工作信息 
	 * 
	 * @return wiList 工作信息 
	 */
	public List<Map<String, String>> getWiList() {
		return wiList;
	}

	/**
	 * 设定 工作信息 
	 * 
	 * @param wiList 工作信息 
	 */
	public void setWiList(List<Map<String, String>> wiList) {
		this.wiList = wiList;
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
	 * @param 检索最大件数
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
	 * @param 翻页用DTO
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}
	/**
	 * 取得 工作实例信息
	 * 
	 * @return wiInfo 工作实例信息
	 */
	public WorkInstanceInfo getWiInfo() {
		return wiInfo;
	}
	/**
	 * 设定 工作实例信息
	 * 
	 * @param wiInfo 工作实例信息
	 */
	public void setWiInfo(WorkInstanceInfo wiInfo) {
		this.wiInfo = wiInfo;
	}
	/**
	 * 取得 工作处理日志集合 
	 * 
	 * @return wlogList 工作处理日志集合 
	 */
	public List<WorkLogInfo> getWlogList() {
		return wlogList;
	}
	/**
	 * 设定 工作处理日志集合 
	 * 
	 * @param wlogList 工作处理日志集合 
	 */
	public void setWlogList(List<WorkLogInfo> wlogList) {
		this.wlogList = wlogList;
	}
	/**
	 * 用户机构集合  取得
	 * @return 用户机构集合  
	 */
	public List<Map<String, String>> getUserOrgList() {
		return userOrgList;
	}
	/**
	 * 用户机构集合 设定
	 * @param 用户机构集合 
	 */
	public void setUserOrgList(List<Map<String, String>> userOrgList) {
		this.userOrgList = userOrgList;
	}

	/**
	 * 机构集合设定
	 * @param 机构集合
	 */
	public void setOrgMap(Map<String, String> orgMap) {
		this.orgMap = orgMap;
	}

	/**
	 * 机构集合 取得
	 * @return 机构集合 
	 */
	public Map<String, String> getOrgMap() {
		return orgMap;
	}

	/**
	 * 工作管理Form取得
	 * @return 工作管理Form
	 */
	public IGWIM0201Form getIgwim0201Form() {
		return igwim0201Form;
	}

	/**
	 * 工作管理Form设定
	 * @param 工作管理Form
	 */
	public void setIgwim0201Form(IGWIM0201Form igwim0201Form) {
		this.igwim0201Form = igwim0201Form;
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
	 * @param 当前登录用户
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * 工作是否超时未处理标识（0：未超时，1：已超时）取得
	 * @return 工作是否超时未处理标识（0：未超时，1：已超时）
	 */
	public String getIsOverTime() {
		return isOverTime;
	}

	/**
	 * 工作是否超时未处理标识（0：未超时，1：已超时）设定
	 * @param 工作是否超时未处理标识（0：未超时，1：已超时）
	 */
	public void setIsOverTime(String isOverTime) {
		this.isOverTime = isOverTime;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
	
}
