/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.wim.form;

import org.apache.struts.upload.FormFile;

import com.deliverik.framework.base.BaseForm;

/**
 * 
 * @Description 工作项查询/删除Form
 *
 * @date 2017年6月14日
 *
 * @author wangliang@deliverik.com
 *
 * @version 1.0
 *
 */
@SuppressWarnings("serial")
public class IGWIM0102Form extends BaseForm{
	
	/** 主键 */
	protected Integer wdid;
	
	/** 工作项名称 */
	protected String wdname;

	/** 发起人（userid） */
	protected String initiatorId;
	
	/** 发起人名称 */
	protected String initiatorName;

	/** 周期/频率 */
	protected String cycle;

	/** 发起时间  */
	protected String wdcreateTime;

	/** 工作项描述 */
	protected String description;

	/** 开始日期 */
	protected String beginDate;
	
	/** 开始日期从 */
	protected String beginDateStart;
	
	/** 开始日期到 */
	protected String beginDateOver;

	/** 结束日期 */
	protected String endDate;

	/** 预计完成日期 */
	protected String estimateFinishDate;

	/** 实际完成日期 */
	protected String actualFinishDate;

	/** 超时提醒时间（天） */
	protected String overtimeTipsTime;

	/** 负责人（userid） */
	protected String leaderId;
	
	/** 负责人名称  */
	protected String leaderName;

	/** 执行人（userid,userid,userid,...） */
	protected String excutorId;
	
	/** 执行人名称 */
	protected String excutorName;

	/** 启用状态（0，未启用；1，已启用） */
	protected String wdstatus;

	/** 月 */
	protected String wdmonth;

	/** 每月最后一天发起（Y，是；N；否） */
	protected String monthLastDay;

	/** 周 */
	protected String wdweek;

	/** 时 */
	protected String wdhour;

	/** 分 */
	protected String wdminute;

	/** 是否短信通知（Y,是；N，否） */
	protected String isMsgNotice;

	/** 备注 */
	protected String remarks;

	/** 表记录创建日期 */
	protected String crtDate;
	
	/** 预留字段 */
	protected String reservedFiled;
	
	/** 0为新增 1为变更 */
	protected String mode = "0";
	
	/** 删除工作项对象 */
	protected String[] deleteEiid;

	 /** 附件 */
    protected FormFile fileMap = null;
    
    /**导入信息*/
    protected String result;
    
    /** 是否是普通用户（1：是，0：否） */
    protected String isNormalUser;
    
	/**
	 * wdid取得
	 *
	 * @return wdid
	 */
	public Integer getWdid() {
		return wdid;
	}

	/**
	 * wdid设定
	 *
	 * @param wdid wdid
	 */
	public void setWdid(Integer wdid) {
		this.wdid = wdid;
	}

	/**
	 * 工作项名称取得
	 *
	 * @return 工作项名称
	 */
	public String getWdname() {
		return wdname;
	}

	/**
	 * 工作项名称设定
	 *
	 * @param 工作项名称
	 */
	public void setWdname(String wdname) {
		this.wdname = wdname;
	}

	/**
	 * 发起人（userid）取得
	 *
	 * @return 发起人（userid）
	 */
	public String getInitiatorId() {
		return initiatorId;
	}

	/**
	 * 发起人（userid）设定
	 *
	 * @param 发起人（userid）
	 */
	public void setInitiatorId(String initiatorId) {
		this.initiatorId = initiatorId;
	}
	
	/**
	 * 发起人名称取得
	 * @return 发起人名称
	 */
	public String getInitiatorName() {
		return initiatorName;
	}

	/**
	 * 发起人名称设定
	 * @param 发起人名称
	 */
	public void setInitiatorName(String initiatorName) {
		this.initiatorName = initiatorName;
	}

	/**
	 * 周期/频率取得
	 *
	 * @return 周期/频率
	 */
	public String getCycle() {
		return cycle;
	}

	/**
	 * 周期/频率设定
	 *
	 * @param 周期/频率
	 */
	public void setCycle(String cycle) {
		this.cycle = cycle;
	}

	/**
	 * 发起时间取得
	 *
	 * @return 发起时间
	 */
	public String getWdcreateTime() {
		return wdcreateTime;
	}

	/**
	 * 发起时间设定
	 *
	 * @param 发起时间
	 */
	public void setWdcreateTime(String wdcreateTime) {
		this.wdcreateTime = wdcreateTime;
	}

	/**
	 * 工作项描述取得
	 *
	 * @return 工作项描述
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 工作项描述设定
	 *
	 * @param 工作项描述
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 开始日期取得
	 *
	 * @return 开始日期
	 */
	public String getBeginDate() {
		return beginDate;
	}

	/**
	 * 开始日期设定
	 *
	 * @param 开始日期
	 */
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}
	
	/**
	 * 开始日期从取得
	 * @return 开始日期从
	 */
	public String getBeginDateStart() {
		return beginDateStart;
	}

	/**
	 * 开始日期从设定
	 * @param 开始日期从
	 */
	public void setBeginDateStart(String beginDateStart) {
		this.beginDateStart = beginDateStart;
	}

	/**
	 * 开始日期到取得
	 * @return 开始日期到
	 */
	public String getBeginDateOver() {
		return beginDateOver;
	}

	/**
	 * 开始日期到设定
	 * @param 开始日期到
	 */
	public void setBeginDateOver(String beginDateOver) {
		this.beginDateOver = beginDateOver;
	}

	/**
	 * 结束日期取得
	 *
	 * @return 结束日期
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * 结束日期设定
	 *
	 * @param 结束日期
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	/**
	 * 预计完成日期取得
	 *
	 * @return 预计完成日期
	 */
	public String getEstimateFinishDate() {
		return estimateFinishDate;
	}

	/**
	 * 预计完成日期设定
	 *
	 * @param 预计完成日期
	 */
	public void setEstimateFinishDate(String estimateFinishDate) {
		this.estimateFinishDate = estimateFinishDate;
	}

	/**
	 * 实际完成日期取得
	 *
	 * @return 实际完成日期
	 */
	public String getActualFinishDate() {
		return actualFinishDate;
	}

	/**
	 * 实际完成日期设定
	 *
	 * @param 实际完成日期
	 */
	public void setActualFinishDate(String actualFinishDate) {
		this.actualFinishDate = actualFinishDate;
	}

	/**
	 * 超时提醒时间（天）取得
	 *
	 * @return 超时提醒时间（天）
	 */
	public String getOvertimeTipsTime() {
		return overtimeTipsTime;
	}

	/**
	 * 超时提醒时间（天）设定
	 *
	 * @param 超时提醒时间（天）
	 */
	public void setOvertimeTipsTime(String overtimeTipsTime) {
		this.overtimeTipsTime = overtimeTipsTime;
	}
	
	/**
	 * 负责人（userid）取得
	 * 
	 * @return 负责人（userid）
	 */
	public String getLeaderId() {
		return leaderId;
	}

	/**
	 * 负责人（userid）设定
	 * @param 负责人（userid）
	 */
	public void setLeaderId(String leaderId) {
		this.leaderId = leaderId;
	}
	
	/**
	 * 负责人名称 取得
	 * @return 负责人名称 
	 */
	public String getLeaderName() {
		return leaderName;
	}

	/**
	 * 负责人名称 设定
	 * @param 负责人名称 
	 */
	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
	}

	/**
	 * 执行人（userid,userid,userid,...）取得
	 *
	 * @return 执行人（userid,userid,userid,...）
	 */
	public String getExcutorId() {
		return excutorId;
	}

	/**
	 * 执行人（userid,userid,userid,...）设定
	 *
	 * @param 执行人（userid,userid,userid,...）
	 */
	public void setExcutorId(String excutorId) {
		this.excutorId = excutorId;
	}
	
	/**
	 * 执行人名称取得
	 * @return 执行人名称
	 */
	public String getExcutorName() {
		return excutorName;
	}

	/**
	 * 执行人名称设定
	 * @param 执行人名称
	 */
	public void setExcutorName(String excutorName) {
		this.excutorName = excutorName;
	}

	/**
	 * 启用状态（0，未启用；1，已启用）取得
	 *
	 * @return 启用状态（0，未启用；1，已启用）
	 */
	public String getWdstatus() {
		return wdstatus;
	}

	/**
	 * 启用状态（0，未启用；1，已启用）设定
	 *
	 * @param 启用状态（0，未启用；1，已启用）
	 */
	public void setWdstatus(String wdstatus) {
		this.wdstatus = wdstatus;
	}
	
	/**
	 * 月取得
	 * @return the 月
	 */
	public String getWdmonth() {
		return wdmonth;
	}

	/**
	 * 月设定
	 * @param 月
	 */
	public void setWdmonth(String wdmonth) {
		this.wdmonth = wdmonth;
	}

	/**
	 * 每月最后一天发起（Y，是；N；否）取得
	 *
	 * @return 每月最后一天发起（Y，是；N；否）
	 */
	public String getMonthLastDay() {
		return monthLastDay;
	}

	/**
	 * 每月最后一天发起（Y，是；N；否）设定
	 *
	 * @param 每月最后一天发起（Y，是；N；否）
	 */
	public void setMonthLastDay(String monthLastDay) {
		this.monthLastDay = monthLastDay;
	}

	/**
	 * @return the wdweek
	 */
	public String getWdweek() {
		return wdweek;
	}

	/**
	 * @param wdweek the wdweek to set
	 */
	public void setWdweek(String wdweek) {
		this.wdweek = wdweek;
	}

	/**
	 * 时取得
	 *
	 * @return 时
	 */
	public String getWdhour() {
		return wdhour;
	}

	/**
	 * 时设定
	 *
	 * @param 时
	 */
	public void setWdhour(String wdhour) {
		this.wdhour = wdhour;
	}

	/**
	 * 分取得
	 *
	 * @return 分
	 */
	public String getWdminute() {
		return wdminute;
	}

	/**
	 * 分设定
	 *
	 * @param 分
	 */
	public void setWdminute(String wdminute) {
		this.wdminute = wdminute;
	}

	/**
	 * 是否短信通知（Y,是；N，否）取得
	 *
	 * @return 是否短信通知（Y,是；N，否）
	 */
	public String getIsMsgNotice() {
		return isMsgNotice;
	}

	/**
	 * 是否短信通知（Y,是；N，否）设定
	 *
	 * @param 是否短信通知（Y,是；N，否）
	 */
	public void setIsMsgNotice(String isMsgNotice) {
		this.isMsgNotice = isMsgNotice;
	}

	/**
	 * 备注取得
	 *
	 * @return remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * 备注设定
	 *
	 * @param 备注
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * 表记录创建日期取得
	 *
	 * @return 表记录创建日期
	 */
	public String getCrtDate() {
		return crtDate;
	}

	/**
	 * 表记录创建日期设定
	 *
	 * @param 表记录创建日期
	 */
	public void setCrtDate(String crtDate) {
		this.crtDate = crtDate;
	}
	
	/**
	 * 预留字段取得
	 * @return 预留字段
	 */
	public String getReservedFiled() {
		return reservedFiled;
	}

	/**
	 * 预留字段设定
	 * @param 预留字段
	 */
	public void setReservedFiled(String reservedFiled) {
		this.reservedFiled = reservedFiled;
	}
	
	/**
	 * 0为新增 1为变更取得
	 * @return 0为新增 1为变更
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * 0为新增 1为变更设定
	 * @param 0为新增 1为变更
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}

	/**
	 * 删除工作项对象取得
	 * @return 删除工作项对象
	 */
	public String[] getDeleteEiid() {
		return deleteEiid;
	}

	/**
	 * 删除工作项对象设定
	 * @param 删除工作项对象
	 */
	public void setDeleteEiid(String[] deleteEiid) {
		this.deleteEiid = deleteEiid;
	}

	/**
	 * @return the 附件
	 */
	public FormFile getFileMap() {
		return fileMap;
	}
	

	/**
	 * @param 附件 the fileMap to set
	 */
	public void setFileMap(FormFile fileMap) {
		this.fileMap = fileMap;
	}
	

	/**
	 * @return the 导入信息
	 */
	public String getResult() {
		return result;
	}
	

	/**
	 * @param 导入信息 the result to set
	 */
	public void setResult(String result) {
		this.result = result;
	}

	/**
	 * 是否是普通用户（1：是，0：否）取得
	 * @return 是否是普通用户（1：是，0：否）
	 */
	public String getIsNormalUser() {
		return isNormalUser;
	}

	/**
	 * 是否是普通用户（1：是，0：否）设定
	 * @param isNormalUser the isNormalUser to set
	 */
	public void setIsNormalUser(String isNormalUser) {
		this.isNormalUser = isNormalUser;
	}
}
