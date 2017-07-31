/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.wim.dto;

import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.wim.form.IGWIM0101Form;
import com.deliverik.infogovernor.wim.form.IGWIM0102Form;
import com.deliverik.infogovernor.wim.model.WorkDefinitionInfo;
import com.deliverik.infogovernor.wim.model.WorkInstanceInfo;
import com.deliverik.infogovernor.wim.vo.IGWIM01011VO;

/**
 * @Description 工作项管理DTO
 * 
 * @date 2017年6月9日15:54:29
 * 
 * @author WangLiang
 *
 */
@SuppressWarnings("serial")
public class IGWIM01DTO extends BaseDTO{

	/** 工作项管理Form */
	protected IGWIM0101Form igwim0101Form;
	
	/** 工作项查询Form */
	protected IGWIM0102Form igwim0102Form;
	
	/** 当前登录用户 */
	protected User user;
	
	/** 工作定义主键ID */
	protected Integer wdid;
	
	/** 工作项定时任务添加/移除标识（1，添加；2，移除） */
	protected String addOrRemoveFlag;
	
	/** 工作项删除对象 */
	protected String[] deleteEntityItem;
	
	/** 检索最大件数 */
	protected int maxSearchCount;

	/** 翻页用DTO */
	protected PagingDTO pagingDto;
	
	/** 工作项定义信息 */
	protected WorkDefinitionInfo workDefinitionInfo;
	
	/** 工作项实例信息 */
	protected WorkInstanceInfo workInstanceInfo;
	
	/** 频率周星期集合 */
	protected List<IGWIM01011VO> weekList;
	
	/** 频率月天数集合 */
	protected List<IGWIM01011VO> monthList;
	
	/** 频率小时集合 */
	protected List<IGWIM01011VO> hourList;
	
	/** 频率分集合 */
	protected List<IGWIM01011VO> minutesList;
	
	/** 工作项定义集合  */
	protected List<WorkDefinitionInfo> definitionInfos;
	
	/** 手动发起标识:值不为空代表手动发起 */
	protected String launchFlag;
	
	/** 提示信息 */
	protected String msg;
	
	/** 是否是中心负责人以上岗位（1：是，0，否） */
	protected String isLeader;
	
	/** 无效标识 1：无效，0：有效 */
	protected String isInvalid;
	
	/**
	 * 工作项管理Form取得
	 * @return 工作项管理Form
	 */
	public IGWIM0101Form getIgwim0101Form() {
		return igwim0101Form;
	}

	/**
	 * 工作项管理Form设定
	 * @param 工作项管理Form
	 */
	public void setIgwim0101Form(IGWIM0101Form igwim0101Form) {
		this.igwim0101Form = igwim0101Form;
	}

	/**
	 * 工作项查询Form取得
	 * @return 工作项查询Form
	 */
	public IGWIM0102Form getIgwim0102Form() {
		return igwim0102Form;
	}

	/**
	 * 工作项查询Form设定
	 * @param 工作项查询Form
	 */
	public void setIgwim0102Form(IGWIM0102Form igwim0102Form) {
		this.igwim0102Form = igwim0102Form;
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
	 * 工作定义主键ID取得
	 * @return 工作定义主键ID
	 */
	public Integer getWdid() {
		return wdid;
	}

	/**
	 * 工作定义主键ID设定
	 * @param 工作定义主键ID
	 */
	public void setWdid(Integer wdid) {
		this.wdid = wdid;
	}

	/**
	 * 工作项定时任务添加/移除标识（1，添加；2，移除）取得
	 * @return 工作项定时任务添加/移除标识（1，添加；2，移除）
	 */
	public String getAddOrRemoveFlag() {
		return addOrRemoveFlag;
	}

	/**
	 * 工作项定时任务添加/移除标识（1，添加；2，移除）设定
	 * @param 工作项定时任务添加/移除标识（1，添加；2，移除）
	 */
	public void setAddOrRemoveFlag(String addOrRemoveFlag) {
		this.addOrRemoveFlag = addOrRemoveFlag;
	}

	/**
	 * 工作项删除对象取得
	 * @return 工作项删除对象
	 */
	public String[] getDeleteEntityItem() {
		return deleteEntityItem;
	}

	/**
	 * 工作项删除对象设定
	 * @param 工作项删除对象
	 */
	public void setDeleteEntityItem(String[] deleteEntityItem) {
		this.deleteEntityItem = deleteEntityItem;
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
	 * 工作项定义信息取得
	 * @return 工作项定义信息
	 */
	public WorkDefinitionInfo getWorkDefinitionInfo() {
		return workDefinitionInfo;
	}

	/**
	 * 工作项定义信息设定
	 * @param 工作项定义信息
	 */
	public void setWorkDefinitionInfo(WorkDefinitionInfo workDefinitionInfo) {
		this.workDefinitionInfo = workDefinitionInfo;
	}

	/**
	 * 工作项实例信息取得
	 * @return 工作项实例信息
	 */
	public WorkInstanceInfo getWorkInstanceInfo() {
		return workInstanceInfo;
	}

	/**
	 * 工作项实例信息设定
	 * @param 工作项实例信息
	 */
	public void setWorkInstanceInfo(WorkInstanceInfo workInstanceInfo) {
		this.workInstanceInfo = workInstanceInfo;
	}

	/**
	 * 频率周星期集合取得
	 * @return 频率周星期集合
	 */
	public List<IGWIM01011VO> getWeekList() {
		return weekList;
	}

	/**
	 * 频率周星期集合设定
	 * @param 频率周星期集合
	 */
	public void setWeekList(List<IGWIM01011VO> weekList) {
		this.weekList = weekList;
	}

	/**
	 * 频率月天数集合取得
	 * @return 频率月天数集合
	 */
	public List<IGWIM01011VO> getMonthList() {
		return monthList;
	}

	/**
	 * 频率月天数集合设定
	 * @param 频率月天数集合
	 */
	public void setMonthList(List<IGWIM01011VO> monthList) {
		this.monthList = monthList;
	}

	/**
	 * 频率小时集合取得
	 * @return 频率小时集合
	 */
	public List<IGWIM01011VO> getHourList() {
		return hourList;
	}

	/**
	 * 频率小时集合设定
	 * @param 频率小时集合
	 */
	public void setHourList(List<IGWIM01011VO> hourList) {
		this.hourList = hourList;
	}

	/**
	 * 频率分集合取得
	 * @return 频率分集合
	 */
	public List<IGWIM01011VO> getMinutesList() {
		return minutesList;
	}

	/**
	 * 频率分集合设定
	 * @param 频率分集合
	 */
	public void setMinutesList(List<IGWIM01011VO> minutesList) {
		this.minutesList = minutesList;
	}

	/**
	 * 工作项定义集合取得
	 * @return 工作项定义集合
	 */
	public List<WorkDefinitionInfo> getDefinitionInfos() {
		return definitionInfos;
	}

	/**
	 * 工作项定义集合设定
	 * @param 工作项定义集合
	 */
	public void setDefinitionInfos(List<WorkDefinitionInfo> definitionInfos) {
		this.definitionInfos = definitionInfos;
	}

	/**
	 * 手动发起标识:值不为空代表手动发起取得
	 * @return 手动发起标识:值不为空代表手动发起
	 */
	public String getLaunchFlag() {
		return launchFlag;
	}

	/**
	 * 手动发起标识:值不为空代表手动发起设定
	 * @param 手动发起标识:值不为空代表手动发起
	 */
	public void setLaunchFlag(String launchFlag) {
		this.launchFlag = launchFlag;
	}

	/**
	 * 提示信息取得
	 * @return 提示信息
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * 提示信息设定
	 * @param 提示信息
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	/**
	 * 是否是中心负责人以上岗位（1：是，0，否）取得
	 * @return 是否是中心负责人以上岗位（1：是，0，否）
	 */
	public String getIsLeader() {
		return isLeader;
	}

	/**
	 * 是否是中心负责人以上岗位（1：是，0，否）设定
	 * @param 是否是中心负责人以上岗位（1：是，0，否）
	 */
	public void setIsLeader(String isLeader) {
		this.isLeader = isLeader;
	}

	/**
	 * 无效标识 1：无效，0：有效 取得
	 * @return 无效标识 1：无效，0：有效 
	 */
	public String getIsInvalid() {
		return isInvalid;
	}

	/**
	 * 无效标识 1：无效，0：有效 设定
	 * @param 无效标识 1：无效，0：有效 
	 */
	public void setIsInvalid(String isInvalid) {
		this.isInvalid = isInvalid;
	}

	
	
}
