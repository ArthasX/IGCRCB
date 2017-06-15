/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.asset.model.AuditResultInfo;
import com.deliverik.framework.asset.model.AuditTaskInfo;
import com.deliverik.framework.asset.model.AuditWaitTaskInfo;
import com.deliverik.framework.asset.model.IG002Info;
import com.deliverik.framework.asset.model.IG887Info;
import com.deliverik.framework.asset.model.IG749Info;
import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.asset.model.condition.AuditResultSearchCond;
import com.deliverik.framework.asset.model.condition.AuditTaskSearchCond;
import com.deliverik.framework.asset.model.condition.IG688SearchCond;
import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.asset.form.IGASM2101Form;
import com.deliverik.infogovernor.asset.form.IGASM2102Form;
import com.deliverik.infogovernor.asset.form.IGASM2103Form;
import com.deliverik.infogovernor.asset.form.IGASM2105Form;
import com.deliverik.infogovernor.asset.form.IGASM2106Form;
import com.deliverik.infogovernor.asset.form.IGASM2107Form;
import com.deliverik.infogovernor.asset.form.IGASM2108Form;
import com.deliverik.infogovernor.asset.form.IGASM2109Form;

/**
 * 概述: 资产审计业务用DTO
 * 功能描述: 资产审计业务用DTO
 * 创建记录: 2111/04/25
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGASM21DTO extends BaseDTO implements Serializable {

	/** 审计控制台显示FORM */
	protected IGASM2101Form igasm2101Form;

	/** 审计对比结果FORM */
	protected IGASM2102Form igasm2102Form;
	
	/** 审计控制台任务查看FORM */
	protected IGASM2103Form igasm2103Form;
	
	/** 审计任务登记/修改FORM */
	protected IGASM2105Form igasm2105Form;
	
	/** 审计任务界面跳转FORM */
	protected IGASM2106Form igasm2106Form;
	
	/** 审计任务检索FORM */
	protected IGASM2107Form igasm2107Form;
	
	/** 设备信息FORM */
	protected IGASM2108Form igasm2108Form;
	
	/** 设备详细信息FORM */
	protected IGASM2109Form igasm2109Form;
	
	/** 审计任务信息 */
	protected AuditTaskInfo auditTaskInfo;
	
	/** 设备检索结果 */
	protected List<IG688Info> entityItemVWInfoList;
	
	/** 设备信息检索条件 */
	protected IG688SearchCond entityItemVWSearchCond;
	
	/** 设备信息 */
	protected IG688Info entityItemVWInfo;
	
	/** 被影响的设备信息 */
	protected Map<String,List<IG749Info>> entityItemVWInfoMap;
	
	/** 设备所属机构名称 */
	protected String eiorgname;
	
	/** 权限标识 */
	protected Boolean flag;
	
	/** 资产项配置信息检索结果 */
	protected Map<String,List<IG002Info>> configItemVWInfoMap;
	
	/** 资产版本列表 */
	protected List<IG887Info> configItemVersionTime;
	
	/** 检索最大件数 */
	protected int maxSearchCount;

	/** 翻页用DTO */
	protected PagingDTO pagingDto;
	
	/** 审计任务查询条件接口 */
	protected AuditTaskSearchCond auditTaskSearchCond;
	
	/** 审计任务检索结果 */
	protected List<AuditTaskInfo> auditTaskInfoList;
	
	/** 审计控制台任务列表 */
	protected List<AuditWaitTaskInfo> auditWaitTaskList;
	
	/** 审计控制台任务 */
	protected AuditWaitTaskInfo auditWaitTask;
	
	/** 用户信息 */
	protected User user;
	
	/** 审计对比结果查询接口 */
	protected AuditResultSearchCond auditResultSearchCond;
	
	/** 审计对比结果检索结果 */
	protected List<AuditResultInfo> auditResultList;
	
	/** 导入的顶级IC名称集合 */
	protected Map<Integer, String> ICNameMap;
	
	/**
	 * 用户信息取得
	 * 
	 * @return 用户信息
	 */
	public User getUser() {
		return user;
	}
	/**
	 * 用户信息设置
	 * 
	 * @param User 用户信息 
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * 审计控制台显示FORM取得
	 * 
	 * @return 审计控制台显示FORM
	 */
	public IGASM2101Form getIgasm2101Form() {
		return igasm2101Form;
	}
	
	/**
	 * 审计控制台任务查看FORM取得
	 * 
	 * @return 审计控制台任务查看FORM
	 */
	public IGASM2103Form getIgasm2103Form() {
		return igasm2103Form;
	}
	
	
	/**
	 * 审计控制台任务查看FORM设定
	 * 
	 * @param igasm2103Form 审计控制台任务查看FORM
	 */
	public void setIgasm2103Form(IGASM2103Form igasm2103Form) {
		this.igasm2103Form = igasm2103Form;
	}
	/**
	 * 审计控制台显示FORM设定
	 * 
	 * @param igasm2101Form 审计控制台显示FORM
	 */
	public void setIgasm2101Form(IGASM2101Form igasm2101Form) {
		this.igasm2101Form = igasm2101Form;
	}

	/**
	 * 审计控制台任务列表
	 * 
	 * @return 审计控制台任务列表取得
	 */
	public List<AuditWaitTaskInfo> getAuditWaitTaskList() {
		return auditWaitTaskList;
	}

	/**
	 * 审计控制台任务列表设定
	 * 
	 * @param auditWaitTaskList 审计控制台任务列表
	 */
	public void setAuditWaitTaskList(List<AuditWaitTaskInfo> auditWaitTaskList) {
		this.auditWaitTaskList = auditWaitTaskList;
	}
	
	/**
	 * 审计控制台任务取得
	 * 
	 * @return 审计控制台任务
	 */
	public AuditWaitTaskInfo getAuditWaitTask() {
		return auditWaitTask;
	}

	/**
	 * 审计控制台任务设定
	 * 
	 * @param auditWaitTask 审计控制台任务
	 */
	public void setAuditWaitTask(AuditWaitTaskInfo auditWaitTask) {
		this.auditWaitTask = auditWaitTask;
	}
	
	/**
	 * 审计对比结果查询接口取得
	 * @return 审计对比结果查询接口
	 */
	public AuditResultSearchCond getAuditResultSearchCond() {
		return auditResultSearchCond;
	}
	
	/**
	 * 审计对比结果查询接口设定
	 * @param auditResultSearchCond 审计对比结果查询接口
	 */
	public void setAuditResultSearchCond(AuditResultSearchCond auditResultSearchCond) {
		this.auditResultSearchCond = auditResultSearchCond;
	}

	/**
	 * 审计对比结果检索结果取得
	 * @return 审计对比结果检索结果
	 */
	public List<AuditResultInfo> getAuditResultList() {
		return auditResultList;
	}

	/**
	 * 审计对比结果检索结果设置
	 * @param auditResultList 审计对比结果检索结果
	 */
	public void setAuditResultList(List<AuditResultInfo> auditResultList) {
		this.auditResultList = auditResultList;
	}
	
	/**
	 * 审计对比结果FORM取得
	 * @return 审计对比结果FORM
	 */
	public IGASM2102Form getIgasm2102Form() {
		return igasm2102Form;
	}
	
	/**
	 * 审计对比结果FORM设定
	 * @param igasm2102Form 审计对比结果FORM
	 */
	public void setIgasm2102Form(IGASM2102Form igasm2102Form) {
		this.igasm2102Form = igasm2102Form;
	}
	/**
	 * 审计任务登记/修改FORM取得
	 * @return 审计任务登记/修改FORM
	 */
	public IGASM2105Form getIgasm2105Form() {
		return igasm2105Form;
	}
	/**
	 * 审计任务登记/修改FORM设定
	 * @param igasm2105Form审计任务登记/修改FORM
	 */
	public void setIgasm2105Form(IGASM2105Form igasm2105Form) {
		this.igasm2105Form = igasm2105Form;
	}
	/**
	 * 审计任务界面跳转FORM取得
	 * @return 审计任务界面跳转FORM
	 */
	public IGASM2106Form getIgasm2106Form() {
		return igasm2106Form;
	}
	/**
	 *  审计任务界面跳转FORM设定
	 * @param igasm2106Form审计任务界面跳转FORM
	 */
	public void setIgasm2106Form(IGASM2106Form igasm2106Form) {
		this.igasm2106Form = igasm2106Form;
	}
	/**
	 * 审计任务检索FORM取得
	 * @return 审计任务检索FORM
	 */
	public IGASM2107Form getIgasm2107Form() {
		return igasm2107Form;
	}
	/**
	 * 审计任务检索FORM设定
	 * @param igasm2107Form审计任务检索FORM
	 */
	public void setIgasm2107Form(IGASM2107Form igasm2107Form) {
		this.igasm2107Form = igasm2107Form;
	}
	/**
	 * 审计任务信息取得
	 * @return 审计任务信息
	 */
	public AuditTaskInfo getAuditTaskInfo() {
		return auditTaskInfo;
	}
	/**
	 * 审计任务信息设定
	 * @param auditTaskInfo审计任务信息
	 */
	public void setAuditTaskInfo(AuditTaskInfo auditTaskInfo) {
		this.auditTaskInfo = auditTaskInfo;
	}
	
	/**
	 * 检索最大件数取得
	 * 
	 * @return 检索最大件数
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * 检索最大件数设定
	 * 
	 * @param maxSearchCount检索最大件数
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * 翻页用DTO取得
	 * 
	 * @return 翻页用DTO
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * 翻页用DTO设定
	 * 
	 * @param pagingDto翻页用DTO
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}
	/**
	 * 审计任务查询条件接口取得
	 * @return 审计任务查询条件接口
	 */
	public AuditTaskSearchCond getAuditTaskSearchCond() {
		return auditTaskSearchCond;
	}
	/**
	 * 审计任务查询条件接口设定
	 * @param auditTaskSearchCond审计任务查询条件接口
	 */
	public void setAuditTaskSearchCond(AuditTaskSearchCond auditTaskSearchCond) {
		this.auditTaskSearchCond = auditTaskSearchCond;
	}
	
	/**
	 * 审计任务检索结果取得
	 * @return 审计任务检索结果
	 */
	public List<AuditTaskInfo> getAuditTaskInfoList() {
		return auditTaskInfoList;
	}

	/**
	 * 审计任务检索结果设定
	 * @param auditTaskInfoList审计任务检索结果
	 */
	public void setAuditTaskInfoList(List<AuditTaskInfo> auditTaskInfoList) {
		this.auditTaskInfoList = auditTaskInfoList;
	}
	
	/**
	 * 设备检索结果取得
	 * @return 设备检索结果
	 */
	public List<IG688Info> getEntityItemVWInfoList() {
		return entityItemVWInfoList;
	}

	/**
	 * 设备检索结果设定
	 *
	 * @param entityItemVWInfoList 设备检索结果
	 */
	public void setEntityItemVWInfoList(List<IG688Info> entityItemVWInfoList) {
		this.entityItemVWInfoList = entityItemVWInfoList;
	}
	
	/**
	 * 设备信息检索条件取得
	 * @return 设备信息检索条件
	 */
	public IG688SearchCond getEntityItemVWSearchCond() {
		return entityItemVWSearchCond;
	}

	/**
	 * 设备信息检索条件设定
	 *
	 * @param entityItemVWSearchCond 设备信息检索条件
	 */
	public void setEntityItemVWSearchCond(
			IG688SearchCond entityItemVWSearchCond) {
		this.entityItemVWSearchCond = entityItemVWSearchCond;
	}
	/**
	 * 设备详细信息FORM取得
	 * @return 设备详细信息FORM
	 */
	public IGASM2109Form getIgasm2109Form() {
		return igasm2109Form;
	}
	/**
	 * 设备详细信息FORM设定
	 * @param igasm2109Form设备详细信息FORM
	 */
	public void setIgasm2109Form(IGASM2109Form igasm2109Form) {
		this.igasm2109Form = igasm2109Form;
	}
	
	/**
	 * 设备信息取得
	 * @return 设备信息
	 */
	public IG688Info getEntityItemVWInfo() {
		return entityItemVWInfo;
	}

	/**
	 * 设备信息设定
	 * @param 设备信息
	 */
	public void setEntityItemVWInfo(IG688Info entityItemVWInfo) {
		this.entityItemVWInfo = entityItemVWInfo;
	}

	/**
	 * 资产版本列表取得
	 * @return 资产版本列表
	 */
	public List<IG887Info> getConfigItemVersionTime() {
		return configItemVersionTime;
	}

	/**
	 * 资产版本列表设定
	 * @param configItemVersionTime资产版本列表
	 */
	public void setConfigItemVersionTime(
			List<IG887Info> configItemVersionTime) {
		this.configItemVersionTime = configItemVersionTime;
	}

	/**
	 * 资产项配置信息检索结果取得
	 * @return 资产项配置信息检索结果
	 */
	public Map<String, List<IG002Info>> getConfigItemVWInfoMap() {
		return configItemVWInfoMap;
	}

	/**
	 * 资产项配置信息检索结果设定
	 * @param configItemVWInfoMap资产项配置信息检索结果
	 */
	public void setConfigItemVWInfoMap(
			Map<String, List<IG002Info>> configItemVWInfoMap) {
		this.configItemVWInfoMap = configItemVWInfoMap;
	}

	/**
	 * 设备所属机构名称取得
	 * @return 设备所属机构名称
	 */
	public String getEiorgname() {
		return eiorgname;
	}

	/**
	 * 设备所属机构名称设定
	 * @param eiorgname设备所属机构名称
	 */
	public void setEiorgname(String eiorgname) {
		this.eiorgname = eiorgname;
	}

	/**
	 * 权限标识取得
	 * @return 权限标识
	 */
	public Boolean getFlag() {
		return flag;
	}

	/**
	 * 权限标识设定
	 * @param flag权限标识
	 */
	public void setFlag(Boolean flag) {
		this.flag = flag;
	}
	/**
	 * 设备信息FORM取得
	 * @return 设备信息FORM
	 */
	public IGASM2108Form getIgasm2108Form() {
		return igasm2108Form;
	}
	/**
	 * 设备信息FORM设定
	 * @param igasm2108Form设备信息FORM
	 */
	public void setIgasm2108Form(IGASM2108Form igasm2108Form) {
		this.igasm2108Form = igasm2108Form;
	}

	/**
	 * 被影响的设备信息取得
	 * @return 被影响的设备信息
	 */
	public Map<String, List<IG749Info>> getEntityItemVWInfoMap() {
		return entityItemVWInfoMap;
	}
	
	/**
	 * 被影响的设备信息设定
	 * @param 被影响的设备信息
	 */
	public void setEntityItemVWInfoMap(
			Map<String, List<IG749Info>> entityItemVWInfoMap) {
		this.entityItemVWInfoMap = entityItemVWInfoMap;
	}
	
	/**
	 * 导入的顶级IC名称集合取得
	 * @return 导入的顶级IC名称集合
	 */
	public Map<Integer, String> getICNameMap() {
		return ICNameMap;
	}
	
	/**
	 * 导入的顶级IC名称集合设定
	 * @param nameMap 导入的顶级IC名称集合
	 */
	public void setICNameMap(Map<Integer, String> nameMap) {
		ICNameMap = nameMap;
	}
	
	
}
