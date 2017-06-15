/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.cim.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.SOC0137Info;
import com.deliverik.framework.soc.asset.model.SOC0103Info;
import com.deliverik.framework.soc.asset.model.SOC0104Info;
import com.deliverik.framework.soc.asset.model.SOC0105Info;
import com.deliverik.framework.soc.asset.model.SOC0123Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.SOC0128Info;
import com.deliverik.framework.soc.asset.model.SOC0129Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0103SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0104SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0301Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0302Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0303Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0305Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0306Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0307Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0308Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0309Form;

/**
 * 概述: 资产审计业务用DTO
 * 功能描述: 资产审计业务用DTO
 * 创建记录: 2111/04/25
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGCIM03DTO extends BaseDTO implements Serializable {

	/**
	 * 国际化信息
	 */
	protected Locale locale;

	/** 审计控制台显示FORM */
	protected IGCIM0301Form igcim0301Form;

	/** 审计对比结果FORM */
	protected IGCIM0302Form igcim0302Form;
	
	/** 审计控制台任务查看FORM */
	protected IGCIM0303Form igcim0303Form;
	
	/** 审计任务登记/修改FORM */
	protected IGCIM0305Form igcim0305Form;
	
	/** 审计任务界面跳转FORM */
	protected IGCIM0306Form igcim0306Form;
	
	/** 审计任务检索FORM */
	protected IGCIM0307Form igcim0307Form;
	
	/** 设备信息FORM */
	protected IGCIM0308Form igcim0308Form;
	
	/** 设备详细信息FORM */
	protected IGCIM0309Form igcim0309Form;
	
	/** 审计任务信息 */
	protected SOC0104Info auditTaskInfo;
	
	/** 设备检索结果 */
	protected List<SOC0124Info> entityItemVWInfoList;
	
	/** 设备信息检索条件 */
	protected SOC0124SearchCond entityItemVWSearchCond;
	
	/** 设备信息 */
	protected SOC0124Info entityItemVWInfo;
	
	/** 被影响的设备信息 */
	protected Map<String,List<SOC0123Info>> entityItemVWInfoMap;
	
	/** 设备所属机构名称 */
	protected String eiorgname;
	
	/** 权限标识 */
	protected Boolean flag;
	
	/** 资产项配置信息检索结果 */
	protected Map<String,List<SOC0129Info>> configItemVWInfoMap;
	
	/** 资产版本列表 */
	protected List<SOC0128Info> configItemVersionTime;
	
	/** 检索最大件数 */
	protected int maxSearchCount;

	/** 翻页用DTO */
	protected PagingDTO pagingDto;
	
	/** 审计任务查询条件接口 */
	protected SOC0104SearchCond auditTaskSearchCond;
	
	/** 审计任务检索结果 */
	protected List<SOC0104Info> auditTaskInfoList;
	
	/** 审计控制台任务列表 */
	protected List<SOC0105Info> auditWaitTaskList;
	
	/** 审计控制台任务 */
	protected SOC0105Info auditWaitTask;
	
	/** 用户信息 */
	protected User user;
	
	/** 审计对比结果查询接口 */
	protected SOC0103SearchCond auditResultSearchCond;
	
	/** 审计对比结果检索结果 */
	protected List<SOC0103Info> auditResultList;
	
	/** 导入的顶级IC名称集合 */
	protected Map<Integer, String> ICNameMap;
	
	/** 审计对比结果检索结果 */
	protected List<SOC0137Info> auditResultOneInfoList;
	
	public List<SOC0137Info> getAuditResultOneInfoList() {
		return auditResultOneInfoList;
	}
	
	public void setAuditResultOneInfoList(
			List<SOC0137Info> auditResultOneInfoList) {
		this.auditResultOneInfoList = auditResultOneInfoList;
	}
	
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
	 * 国际化信息取得
	 * 
	 * @return 国际化信息
	 */
	public Locale getLocale() {
		return locale;
	}

	/**
	 * 国际化信息设置
	 * 
	 * @param locale国际化信息
	 */
	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	/**
	 * 审计控制台显示FORM取得
	 * 
	 * @return 审计控制台显示FORM
	 */
	public IGCIM0301Form getIgcim0301Form() {
		return igcim0301Form;
	}
	
	/**
	 * 审计控制台任务查看FORM取得
	 * 
	 * @return 审计控制台任务查看FORM
	 */
	public IGCIM0303Form getIgcim0303Form() {
		return igcim0303Form;
	}
	
	
	/**
	 * 审计控制台任务查看FORM设定
	 * 
	 * @param igcim0303Form 审计控制台任务查看FORM
	 */
	public void setIgcim0303Form(IGCIM0303Form igcim0303Form) {
		this.igcim0303Form = igcim0303Form;
	}
	/**
	 * 审计控制台显示FORM设定
	 * 
	 * @param igcim0301Form 审计控制台显示FORM
	 */
	public void setIgcim0301Form(IGCIM0301Form igcim0301Form) {
		this.igcim0301Form = igcim0301Form;
	}

	/**
	 * 审计控制台任务列表
	 * 
	 * @return 审计控制台任务列表取得
	 */
	public List<SOC0105Info> getAuditWaitTaskList() {
		return auditWaitTaskList;
	}

	/**
	 * 审计控制台任务列表设定
	 * 
	 * @param auditWaitTaskList 审计控制台任务列表
	 */
	public void setAuditWaitTaskList(List<SOC0105Info> auditWaitTaskList) {
		this.auditWaitTaskList = auditWaitTaskList;
	}
	
	/**
	 * 审计控制台任务取得
	 * 
	 * @return 审计控制台任务
	 */
	public SOC0105Info getAuditWaitTask() {
		return auditWaitTask;
	}

	/**
	 * 审计控制台任务设定
	 * 
	 * @param auditWaitTask 审计控制台任务
	 */
	public void setAuditWaitTask(SOC0105Info auditWaitTask) {
		this.auditWaitTask = auditWaitTask;
	}
	
	/**
	 * 审计对比结果查询接口取得
	 * @return 审计对比结果查询接口
	 */
	public SOC0103SearchCond getAuditResultSearchCond() {
		return auditResultSearchCond;
	}
	
	/**
	 * 审计对比结果查询接口设定
	 * @param auditResultSearchCond 审计对比结果查询接口
	 */
	public void setAuditResultSearchCond(SOC0103SearchCond auditResultSearchCond) {
		this.auditResultSearchCond = auditResultSearchCond;
	}

	/**
	 * 审计对比结果检索结果取得
	 * @return 审计对比结果检索结果
	 */
	public List<SOC0103Info> getAuditResultList() {
		return auditResultList;
	}

	/**
	 * 审计对比结果检索结果设置
	 * @param auditResultList 审计对比结果检索结果
	 */
	public void setAuditResultList(List<SOC0103Info> auditResultList) {
		this.auditResultList = auditResultList;
	}
	
	/**
	 * 审计对比结果FORM取得
	 * @return 审计对比结果FORM
	 */
	public IGCIM0302Form getIgcim0302Form() {
		return igcim0302Form;
	}
	
	/**
	 * 审计对比结果FORM设定
	 * @param igcim0302Form 审计对比结果FORM
	 */
	public void setIgcim0302Form(IGCIM0302Form igcim0302Form) {
		this.igcim0302Form = igcim0302Form;
	}
	/**
	 * 审计任务登记/修改FORM取得
	 * @return 审计任务登记/修改FORM
	 */
	public IGCIM0305Form getIgcim0305Form() {
		return igcim0305Form;
	}
	/**
	 * 审计任务登记/修改FORM设定
	 * @param igcim0305Form审计任务登记/修改FORM
	 */
	public void setIgcim0305Form(IGCIM0305Form igcim0305Form) {
		this.igcim0305Form = igcim0305Form;
	}
	/**
	 * 审计任务界面跳转FORM取得
	 * @return 审计任务界面跳转FORM
	 */
	public IGCIM0306Form getIgcim0306Form() {
		return igcim0306Form;
	}
	/**
	 *  审计任务界面跳转FORM设定
	 * @param igcim0306Form审计任务界面跳转FORM
	 */
	public void setIgcim0306Form(IGCIM0306Form igcim0306Form) {
		this.igcim0306Form = igcim0306Form;
	}
	/**
	 * 审计任务检索FORM取得
	 * @return 审计任务检索FORM
	 */
	public IGCIM0307Form getIgcim0307Form() {
		return igcim0307Form;
	}
	/**
	 * 审计任务检索FORM设定
	 * @param igcim0307Form审计任务检索FORM
	 */
	public void setIgcim0307Form(IGCIM0307Form igcim0307Form) {
		this.igcim0307Form = igcim0307Form;
	}
	/**
	 * 审计任务信息取得
	 * @return 审计任务信息
	 */
	public SOC0104Info getAuditTaskInfo() {
		return auditTaskInfo;
	}
	/**
	 * 审计任务信息设定
	 * @param auditTaskInfo审计任务信息
	 */
	public void setAuditTaskInfo(SOC0104Info auditTaskInfo) {
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
	public SOC0104SearchCond getAuditTaskSearchCond() {
		return auditTaskSearchCond;
	}
	/**
	 * 审计任务查询条件接口设定
	 * @param auditTaskSearchCond审计任务查询条件接口
	 */
	public void setAuditTaskSearchCond(SOC0104SearchCond auditTaskSearchCond) {
		this.auditTaskSearchCond = auditTaskSearchCond;
	}
	
	/**
	 * 审计任务检索结果取得
	 * @return 审计任务检索结果
	 */
	public List<SOC0104Info> getAuditTaskInfoList() {
		return auditTaskInfoList;
	}

	/**
	 * 审计任务检索结果设定
	 * @param auditTaskInfoList审计任务检索结果
	 */
	public void setAuditTaskInfoList(List<SOC0104Info> auditTaskInfoList) {
		this.auditTaskInfoList = auditTaskInfoList;
	}
	
	/**
	 * 设备检索结果取得
	 * @return 设备检索结果
	 */
	public List<SOC0124Info> getEntityItemVWInfoList() {
		return entityItemVWInfoList;
	}

	/**
	 * 设备检索结果设定
	 *
	 * @param entityItemVWInfoList 设备检索结果
	 */
	public void setEntityItemVWInfoList(List<SOC0124Info> entityItemVWInfoList) {
		this.entityItemVWInfoList = entityItemVWInfoList;
	}
	
	/**
	 * 设备信息检索条件取得
	 * @return 设备信息检索条件
	 */
	public SOC0124SearchCond getEntityItemVWSearchCond() {
		return entityItemVWSearchCond;
	}

	/**
	 * 设备信息检索条件设定
	 *
	 * @param entityItemVWSearchCond 设备信息检索条件
	 */
	public void setEntityItemVWSearchCond(
			SOC0124SearchCond entityItemVWSearchCond) {
		this.entityItemVWSearchCond = entityItemVWSearchCond;
	}
	/**
	 * 设备详细信息FORM取得
	 * @return 设备详细信息FORM
	 */
	public IGCIM0309Form getIgcim0309Form() {
		return igcim0309Form;
	}
	/**
	 * 设备详细信息FORM设定
	 * @param igcim0309Form设备详细信息FORM
	 */
	public void setIgcim0309Form(IGCIM0309Form igcim0309Form) {
		this.igcim0309Form = igcim0309Form;
	}
	
	/**
	 * 设备信息取得
	 * @return 设备信息
	 */
	public SOC0124Info getEntityItemVWInfo() {
		return entityItemVWInfo;
	}

	/**
	 * 设备信息设定
	 * @param 设备信息
	 */
	public void setEntityItemVWInfo(SOC0124Info entityItemVWInfo) {
		this.entityItemVWInfo = entityItemVWInfo;
	}

	/**
	 * 资产版本列表取得
	 * @return 资产版本列表
	 */
	public List<SOC0128Info> getConfigItemVersionTime() {
		return configItemVersionTime;
	}

	/**
	 * 资产版本列表设定
	 * @param configItemVersionTime资产版本列表
	 */
	public void setConfigItemVersionTime(
			List<SOC0128Info> configItemVersionTime) {
		this.configItemVersionTime = configItemVersionTime;
	}

	/**
	 * 资产项配置信息检索结果取得
	 * @return 资产项配置信息检索结果
	 */
	public Map<String, List<SOC0129Info>> getConfigItemVWInfoMap() {
		return configItemVWInfoMap;
	}

	/**
	 * 资产项配置信息检索结果设定
	 * @param configItemVWInfoMap资产项配置信息检索结果
	 */
	public void setConfigItemVWInfoMap(
			Map<String, List<SOC0129Info>> configItemVWInfoMap) {
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
	public IGCIM0308Form getIgcim0308Form() {
		return igcim0308Form;
	}
	/**
	 * 设备信息FORM设定
	 * @param igcim0308Form设备信息FORM
	 */
	public void setIgcim0308Form(IGCIM0308Form igcim0308Form) {
		this.igcim0308Form = igcim0308Form;
	}

	/**
	 * 被影响的设备信息取得
	 * @return 被影响的设备信息
	 */
	public Map<String, List<SOC0123Info>> getEntityItemVWInfoMap() {
		return entityItemVWInfoMap;
	}
	
	/**
	 * 被影响的设备信息设定
	 * @param 被影响的设备信息
	 */
	public void setEntityItemVWInfoMap(
			Map<String, List<SOC0123Info>> entityItemVWInfoMap) {
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
