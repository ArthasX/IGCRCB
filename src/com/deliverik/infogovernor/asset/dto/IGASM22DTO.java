/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.asset.model.CIResultInfo;
import com.deliverik.framework.asset.model.CITaskInfo;
import com.deliverik.framework.asset.model.CIWaitTaskInfo;
import com.deliverik.framework.asset.model.IG002Info;
import com.deliverik.framework.asset.model.IG887Info;
import com.deliverik.framework.asset.model.IG749Info;
import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.asset.model.condition.CIResultSearchCond;
import com.deliverik.framework.asset.model.condition.CITaskSearchCond;
import com.deliverik.framework.asset.model.condition.IG688SearchCond;
import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.asset.form.IGASM2201Form;
import com.deliverik.infogovernor.asset.form.IGASM2202Form;
import com.deliverik.infogovernor.asset.form.IGASM2203Form;
import com.deliverik.infogovernor.asset.form.IGASM2205Form;
import com.deliverik.infogovernor.asset.form.IGASM2206Form;
import com.deliverik.infogovernor.asset.form.IGASM2207Form;
import com.deliverik.infogovernor.asset.form.IGASM2208Form;
import com.deliverik.infogovernor.asset.form.IGASM2209Form;

/**
 * 概述: 资产CI变更业务用DTO
 * 功能描述: 资产CI变更业务用DTO
 * 创建记录: 2211/04/25
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGASM22DTO extends BaseDTO implements Serializable {


	/** CI变更控制台显示FORM */
	protected IGASM2201Form igasm2201Form;

	/** CI变更对比结果FORM */
	protected IGASM2202Form igasm2202Form;
	
	/** CI变更控制台任务查看FORM */
	protected IGASM2203Form igasm2203Form;
	
	/** CI变更任务登记/修改FORM */
	protected IGASM2205Form igasm2205Form;
	
	/** CI变更任务界面跳转FORM */
	protected IGASM2206Form igasm2206Form;
	
	/** CI变更任务检索FORM */
	protected IGASM2207Form igasm2207Form;
	
	/** 设备信息FORM */
	protected IGASM2208Form igasm2208Form;
	
	/** 设备详细信息FORM */
	protected IGASM2209Form igasm2209Form;
	
	/** CI变更任务信息 */
	protected CITaskInfo ciTaskInfo;
	
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
	
	/** CI变更任务查询条件接口 */
	protected CITaskSearchCond ciTaskSearchCond;
	
	/** CI变更任务检索结果 */
	protected List<CITaskInfo> ciTaskInfoList;
	
	/** CI变更控制台任务列表 */
	protected List<CIWaitTaskInfo> ciWaitTaskList;
	
	/** CI变更控制台任务 */
	protected CIWaitTaskInfo ciWaitTask;
	
	/** 用户信息 */
	protected User user;
	
	/** CI变更对比结果查询接口 */
	protected CIResultSearchCond ciResultSearchCond;
	
	/** CI变更对比结果检索结果 */
	protected List<CIResultInfo> ciResultList;
	
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
	 * CI变更控制台显示FORM取得
	 * 
	 * @return CI变更控制台显示FORM
	 */
	public IGASM2201Form getIgasm2201Form() {
		return igasm2201Form;
	}
	
	/**
	 * CI变更控制台任务查看FORM取得
	 * 
	 * @return CI变更控制台任务查看FORM
	 */
	public IGASM2203Form getIgasm2203Form() {
		return igasm2203Form;
	}
	
	
	/**
	 * CI变更控制台任务查看FORM设定
	 * 
	 * @param igasm2203Form CI变更控制台任务查看FORM
	 */
	public void setIgasm2203Form(IGASM2203Form igasm2203Form) {
		this.igasm2203Form = igasm2203Form;
	}
	/**
	 * CI变更控制台显示FORM设定
	 * 
	 * @param igasm2201Form CI变更控制台显示FORM
	 */
	public void setIgasm2201Form(IGASM2201Form igasm2201Form) {
		this.igasm2201Form = igasm2201Form;
	}

	/**
	 * CI变更控制台任务列表
	 * 
	 * @return CI变更控制台任务列表取得
	 */
	public List<CIWaitTaskInfo> getCiWaitTaskList() {
		return ciWaitTaskList;
	}

	/**
	 * CI变更控制台任务列表设定
	 * 
	 * @param ciWaitTaskList CI变更控制台任务列表
	 */
	public void setCiWaitTaskList(List<CIWaitTaskInfo> ciWaitTaskList) {
		this.ciWaitTaskList = ciWaitTaskList;
	}
	
	/**
	 * CI变更控制台任务取得
	 * 
	 * @return CI变更控制台任务
	 */
	public CIWaitTaskInfo getCiWaitTask() {
		return ciWaitTask;
	}

	/**
	 * CI变更控制台任务设定
	 * 
	 * @param ciWaitTask CI变更控制台任务
	 */
	public void setCiWaitTask(CIWaitTaskInfo ciWaitTask) {
		this.ciWaitTask = ciWaitTask;
	}
	
	/**
	 * CI变更对比结果查询接口取得
	 * @return CI变更对比结果查询接口
	 */
	public CIResultSearchCond getCiResultSearchCond() {
		return ciResultSearchCond;
	}
	
	/**
	 * CI变更对比结果查询接口设定
	 * @param ciResultSearchCond CI变更对比结果查询接口
	 */
	public void setCiResultSearchCond(CIResultSearchCond ciResultSearchCond) {
		this.ciResultSearchCond = ciResultSearchCond;
	}

	/**
	 * CI变更对比结果检索结果取得
	 * @return CI变更对比结果检索结果
	 */
	public List<CIResultInfo> getCiResultList() {
		return ciResultList;
	}

	/**
	 * CI变更对比结果检索结果设置
	 * @param ciResultList CI变更对比结果检索结果
	 */
	public void setCiResultList(List<CIResultInfo> ciResultList) {
		this.ciResultList = ciResultList;
	}
	
	/**
	 * CI变更对比结果FORM取得
	 * @return CI变更对比结果FORM
	 */
	public IGASM2202Form getIgasm2202Form() {
		return igasm2202Form;
	}
	
	/**
	 * CI变更对比结果FORM设定
	 * @param igasm2202Form CI变更对比结果FORM
	 */
	public void setIgasm2202Form(IGASM2202Form igasm2202Form) {
		this.igasm2202Form = igasm2202Form;
	}
	/**
	 * CI变更任务登记/修改FORM取得
	 * @return CI变更任务登记/修改FORM
	 */
	public IGASM2205Form getIgasm2205Form() {
		return igasm2205Form;
	}
	/**
	 * CI变更任务登记/修改FORM设定
	 * @param igasm2205FormCI变更任务登记/修改FORM
	 */
	public void setIgasm2205Form(IGASM2205Form igasm2205Form) {
		this.igasm2205Form = igasm2205Form;
	}
	/**
	 * CI变更任务界面跳转FORM取得
	 * @return CI变更任务界面跳转FORM
	 */
	public IGASM2206Form getIgasm2206Form() {
		return igasm2206Form;
	}
	/**
	 *  CI变更任务界面跳转FORM设定
	 * @param igasm2206FormCI变更任务界面跳转FORM
	 */
	public void setIgasm2206Form(IGASM2206Form igasm2206Form) {
		this.igasm2206Form = igasm2206Form;
	}
	/**
	 * CI变更任务检索FORM取得
	 * @return CI变更任务检索FORM
	 */
	public IGASM2207Form getIgasm2207Form() {
		return igasm2207Form;
	}
	/**
	 * CI变更任务检索FORM设定
	 * @param igasm2207FormCI变更任务检索FORM
	 */
	public void setIgasm2207Form(IGASM2207Form igasm2207Form) {
		this.igasm2207Form = igasm2207Form;
	}
	/**
	 * CI变更任务信息取得
	 * @return CI变更任务信息
	 */
	public CITaskInfo getCiTaskInfo() {
		return ciTaskInfo;
	}
	/**
	 * CI变更任务信息设定
	 * @param ciTaskInfoCI变更任务信息
	 */
	public void setCiTaskInfo(CITaskInfo ciTaskInfo) {
		this.ciTaskInfo = ciTaskInfo;
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
	 * CI变更任务查询条件接口取得
	 * @return CI变更任务查询条件接口
	 */
	public CITaskSearchCond getCiTaskSearchCond() {
		return ciTaskSearchCond;
	}
	/**
	 * CI变更任务查询条件接口设定
	 * @param ciTaskSearchCondCI变更任务查询条件接口
	 */
	public void setCiTaskSearchCond(CITaskSearchCond ciTaskSearchCond) {
		this.ciTaskSearchCond = ciTaskSearchCond;
	}
	
	/**
	 * CI变更任务检索结果取得
	 * @return CI变更任务检索结果
	 */
	public List<CITaskInfo> getCiTaskInfoList() {
		return ciTaskInfoList;
	}

	/**
	 * CI变更任务检索结果设定
	 * @param ciTaskInfoListCI变更任务检索结果
	 */
	public void setCiTaskInfoList(List<CITaskInfo> ciTaskInfoList) {
		this.ciTaskInfoList = ciTaskInfoList;
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
	public IGASM2209Form getIgasm2209Form() {
		return igasm2209Form;
	}
	/**
	 * 设备详细信息FORM设定
	 * @param igasm2209Form设备详细信息FORM
	 */
	public void setIgasm2209Form(IGASM2209Form igasm2209Form) {
		this.igasm2209Form = igasm2209Form;
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
	public IGASM2208Form getIgasm2208Form() {
		return igasm2208Form;
	}
	/**
	 * 设备信息FORM设定
	 * @param igasm2208Form设备信息FORM
	 */
	public void setIgasm2208Form(IGASM2208Form igasm2208Form) {
		this.igasm2208Form = igasm2208Form;
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
