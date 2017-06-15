/*
 * 北京递蓝科软件技术有限公司版权所有,保留所有权利.
 */

package com.deliverik.infogovernor.dut.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.infogovernor.dut.form.IGDUT0201Form;
import com.deliverik.infogovernor.dut.form.IGDUT0202Form;
import com.deliverik.infogovernor.dut.form.IGDUT0203Form;
import com.deliverik.infogovernor.dut.form.IGDUT0204Form;
import com.deliverik.infogovernor.dut.form.IGDUT0206Form;
import com.deliverik.infogovernor.dut.form.IGDUT0207Form;
import com.deliverik.infogovernor.dut.model.DutyPlan;
import com.deliverik.infogovernor.dut.model.DutyResult;
import com.deliverik.infogovernor.dut.model.DutyResultVWInfo;
import com.deliverik.infogovernor.dut.model.condition.DutyPlanSearchCond;
import com.deliverik.infogovernor.dut.model.entity.DutyPersonTB;

/**
 * 值班管理DTO
 * 
 */
public class IGDUT02DTO extends BaseDTO implements Serializable{
	
	private static final long serialVersionUID = -6214724454446012825L;

	/** 值班计划查询条件 */
	protected DutyPlanSearchCond dutyPlanSearchCond;
	
	/** 用户信息 */
	protected User user;
	
	/** 值班检查内容列表 */
	protected List<DutyResult> dutyResultList;
	
	/** 值班人列表 */
	protected List<DutyPersonTB> dutyPersonList;
	
	/** 值班人信息 */
	protected String usersinfo;
	
	/** 值班计划 */
	protected DutyPlan dutyPlan;
	
	/** 值班交接Form */
	protected IGDUT0204Form igDUT0204Form;
	
	/** 值班中止Form */
	protected IGDUT0207Form igDUT0207Form;
	
	/** 可选白班人员 */
	protected List<UserRoleInfo> dayShiftUsers;
	
	/** 可选夜班人员 */
	protected List<UserRoleInfo> nightShiftUsers;
	
	/** 白班值班人员 */
	protected List<UserRoleInfo> dayShiftDutyUsers;
	
	/** 夜班值班人员 */
	protected List<UserRoleInfo> nightShiftDutyUsers;
	
	/** 值班人员信息 */
	protected Map<String,String> dutyUserMap;
	
	protected IGDUT0202Form igdut0202Form;
	
	/** 值班计划画面 */
	protected IGDUT0201Form igdut0201Form;
	
	/** 值班日报Form */
	protected IGDUT0203Form igDUT0203Form;
	
	protected int calendarYear;
	
	protected int calendarMonth;
	
	protected boolean canChangeDuty = false;
	
	protected String todayYMD;
	
	/** 值班计划内容列表 */
	protected List<DutyPlan> dutyPlanList;
	
	/** 值班启动Form */
	protected IGDUT0206Form igDUT0206Form;

	/** 分页用DTO */
	protected PagingDTO pagingDto;

	/** 值班检查信息最大检索件数 */
	protected int maxSearchCount;
	
	/** 值班日报检索结果 */
	protected Map<String,List<DutyResultVWInfo>> typeMap;
	
	/** 值班时间 */
	protected String dptype;
	
	/** 值班日报ID集合 */
	protected List<Integer> dridList;

	/** igdut0203画面数组字段长度 */
	protected Integer  num;
	/** 是否含有未检查项,1含有 */
	protected String  hasNullDrcontent;
	
	/** 值班日报检查结果选择标识 0不可选 1可选 */
	protected List<String> showList;
	
	/** 值班计划备注 */
	protected String dpremarks;
	
	/** 结果说明是否可编辑 */
	protected List<String> showResultList;
	
	/** 夜班开始时间 */
	protected String nightStartTime;
	
	public String getNightStartTime() {
		return nightStartTime;
	}

	public void setNightStartTime(String nightStartTime) {
		this.nightStartTime = nightStartTime;
	}

	public List<String> getShowResultList() {
		return showResultList;
	}

	public void setShowResultList(List<String> showResultList) {
		this.showResultList = showResultList;
	}

	/**
	 * 值班日报检查结果选择标识取得
	 * @return the showList
	 */
	public List<String> getShowList() {
		return showList;
	}

	/**
	 *  值班日报检查结果选择标识设定
	 */
	public void setShowList(List<String> showList) {
		this.showList = showList;
	}

	/**
	 * igdut0203画面数组字段长度取得
	 * @return the num
	 */
	public Integer getNum() {
		return num;
	}

	/**
	 *  igdut0203画面数组字段长度设定
	 */
	public void setNum(Integer num) {
		this.num = num;
	}


	/**
	 * 值班日报ID集合取得
	 * @return the dridList
	 */
	public List<Integer> getDridList() {
		return dridList;
	}

	

	/**
	 *  值班日报ID集合设定
	 */
	public void setDridList(List<Integer> dridList) {
		this.dridList = dridList;
	}

	/**
	 *  值班时间取得
	 * @return the dptype
	 */
	public String getDptype() {
		return dptype;
	}

	/**
	 *  值班时间设定
	 */
	public void setDptype(String dptype) {
		this.dptype = dptype;
	}

	/**
	 * 值班日报检索结果取得
	 * @return the typeMap
	 */
	public Map<String, List<DutyResultVWInfo>> getTypeMap() {
		return typeMap;
	}

	/**
	 * 值班日报检索结果设定
	 */
	public void setTypeMap(Map<String, List<DutyResultVWInfo>> typeMap) {
		this.typeMap = typeMap;
	}

	/**
	 * 值班日报Form取得
	 * @return the igDUT0203Form
	 */
	public IGDUT0203Form getIgDUT0203Form() {
		return igDUT0203Form;
	}

	/**
	 * 值班日报Form设定
	 */
	public void setIgDUT0203Form(IGDUT0203Form igDUT0203Form) {
		this.igDUT0203Form = igDUT0203Form;
	}

	
	
	
	
	public int getCalendarYear() {
		return calendarYear;
	}

	public void setCalendarYear(int calendarYear) {
		this.calendarYear = calendarYear;
	}

	public int getCalendarMonth() {
		return calendarMonth;
	}

	public void setCalendarMonth(int calendarMonth) {
		this.calendarMonth = calendarMonth;
	}

	/**
	 * 值班计划查询条件取得
	 * @return 值班计划查询条件
	 */
	public DutyPlanSearchCond getDutyPlanSearchCond() {
		return dutyPlanSearchCond;
	}

	/**
	 * 值班计划设定查询条件
	 *
	 * @param dutyPlanSearchCond 值班计划查询条件
	 */
	public void setDutyPlanSearchCond(DutyPlanSearchCond dutyPlanSearchCond) {
		this.dutyPlanSearchCond = dutyPlanSearchCond;
	}

	/**
	 * 用户信息取得
	 * @return 用户信息
	 */
	public User getUser() {
		return user;
	}

	/**
	 * 值班计划设定查询条件
	 *
	 * @param user 用户信息
	 */
	public void setUser(User user) {
		this.user = user;
	}

/**
	 * 值班检查内容列表取得
	 * @return 值班检查内容列表
	 */
	public List<DutyResult> getDutyResultList() {
		return dutyResultList;
	}

	/**
	 * 值班检查内容列表
	 *
	 * @param dutyResultList 值班检查内容列表
	 */
	public void setDutyResultList(List<DutyResult> dutyResultList) {
		this.dutyResultList = dutyResultList;
	}
	
	/**
	 * 值班人信息取得
	 * @return 值班人信息
	 */
	public String getUsersinfo() {
		return usersinfo;
	}

	/**
	 * 值班人信息设定
	 *
	 * @param usersinfo 值班人信息
	 */
	public void setUsersinfo(String usersinfo) {
		this.usersinfo = usersinfo;
	}

	/**
	 * 值班计划取得
	 * @return 值班计划
	 */
	public DutyPlan getDutyPlan() {
		return dutyPlan;
	}

	/**
	 * 值班计划设定
	 *
	 * @param dutyPlan 值班计划
	 */
	public void setDutyPlan(DutyPlan dutyPlan) {
		this.dutyPlan = dutyPlan;
	}

	/**
	 * 值班交接Form取得
	 * @return 值班交接Form
	 */
	public IGDUT0204Form getIgDUT0204Form() {
		return igDUT0204Form;
	}
	
	/**
	 * 值班交接Form设定
	 *
	 * @param igDUT0204Form 值班交接Form
	 */
	public void setIgDUT0204Form(IGDUT0204Form igDUT0204Form) {
		this.igDUT0204Form = igDUT0204Form;
	}
	
	/**
	 * 值班中止Form取得
	 * @return 值班中止Form
	 */
	public IGDUT0207Form getIgDUT0207Form() {
		return igDUT0207Form;
	}

	/**
	 * 值班中止Form设定
	 *
	 * @param igDUT0207Form 值班中止Form
	 */
	public void setIgDUT0207Form(IGDUT0207Form igDUT0207Form) {
		this.igDUT0207Form = igDUT0207Form;
	}

	/**
	 * 值班人取得
	 * @return 值班人
	 */
	public List<DutyPersonTB> getDutyPersonList() {
		return dutyPersonList;
	}

	/**
	 * 值班人设定
	 *
	 * @param dutyPersonList 值班人
	 */
	public void setDutyPersonList(List<DutyPersonTB> dutyPersonList) {
		this.dutyPersonList = dutyPersonList;
	}

	public List<UserRoleInfo> getDayShiftUsers() {
		return dayShiftUsers;
	}

	public void setDayShiftUsers(List<UserRoleInfo> dayShiftUsers) {
		this.dayShiftUsers = dayShiftUsers;
	}

	public List<UserRoleInfo> getNightShiftUsers() {
		return nightShiftUsers;
	}

	public void setNightShiftUsers(List<UserRoleInfo> nightShiftUsers) {
		this.nightShiftUsers = nightShiftUsers;
	}

	public List<UserRoleInfo> getDayShiftDutyUsers() {
		return dayShiftDutyUsers;
	}

	public void setDayShiftDutyUsers(List<UserRoleInfo> dayShiftDutyUsers) {
		this.dayShiftDutyUsers = dayShiftDutyUsers;
	}

	public List<UserRoleInfo> getNightShiftDutyUsers() {
		return nightShiftDutyUsers;
	}

	public void setNightShiftDutyUsers(List<UserRoleInfo> nightShiftDutyUsers) {
		this.nightShiftDutyUsers = nightShiftDutyUsers;
	}

	public IGDUT0202Form getIgdut0202Form() {
		return igdut0202Form;
	}

	public void setIgdut0202Form(IGDUT0202Form igdut0202Form) {
		this.igdut0202Form = igdut0202Form;
	}

	public Map<String, String> getDutyUserMap() {
		return dutyUserMap;
	}

	public void setDutyUserMap(Map<String, String> dutyUserMap) {
		this.dutyUserMap = dutyUserMap;
	}

	public IGDUT0201Form getIgdut0201Form() {
		return igdut0201Form;
	}

	public void setIgdut0201Form(IGDUT0201Form igdut0201Form) {
		this.igdut0201Form = igdut0201Form;
	}

	public boolean isCanChangeDuty() {
		return canChangeDuty;
	}

	public void setCanChangeDuty(boolean canChangeDuty) {
		this.canChangeDuty = canChangeDuty;
	}

	public String getTodayYMD() {
		return todayYMD;
	}

	public void setTodayYMD(String todayYMD) {
		this.todayYMD = todayYMD;
	}

	/**
	 * 值班启动Form取得
	 * @return 值班启动Form
	 */
	public IGDUT0206Form getIgDUT0206Form() {
		return igDUT0206Form;
	}

	/**
	 * 值班启动Form设定
	 * @param igDUT0206Form 值班启动Form
	 */
	public void setIgDUT0206Form(IGDUT0206Form igDUT0206Form) {
		this.igDUT0206Form = igDUT0206Form;
	}

	/**
	 * 分页用DTO取得
	 * @return 分页用DTO
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * 分页用DTO设定
	 * @param pagingDto 分页用DTO
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * 值班检查信息最大检索件数取得
	 * @return 值班检查信息最大检索件数
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * 值班检查信息最大检索件数设定
	 * @param maxSearchCount 值班检查信息最大检索件数
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * 值班计划内容列表取得
	 * @return 值班计划
	 */
	public List<DutyPlan> getDutyPlanList() {
		return dutyPlanList;
	}

	/**
	 * 值班计划设定
	 * @param dutyPlanList 值班计划
	 */
	public void setDutyPlanList(List<DutyPlan> dutyPlanList) {
		this.dutyPlanList = dutyPlanList;
	}

	/**
	 * 是否含有未检查项取得
	 * @return 是否含有未检查项
	 */
	public String getHasNullDrcontent() {
		return hasNullDrcontent;
	}

	/**
	 * 是否含有未检查项
	 * @param hasNullDrcontent 是否含有未检查项
	 */
	public void setHasNullDrcontent(String hasNullDrcontent) {
		this.hasNullDrcontent = hasNullDrcontent;
	}

	/**
	 * 值班计划备注取得
	 *
	 * @return dpremarks 值班计划备注
	 */
	public String getDpremarks() {
		return dpremarks;
	}

	/**
	 * 值班计划备注设定
	 *
	 * @param dpremarks 值班计划备注
	 */
	public void setDpremarks(String dpremarks) {
		this.dpremarks = dpremarks;
	}
	
}
