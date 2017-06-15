/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prd.dto;

import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.infogovernor.prd.form.IGPRD0201Form;
import com.deliverik.infogovernor.prd.vo.IGPRD02022VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description:流程定义工具dto 
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRD02DTO extends BaseDTO{
	
	/** 流程定义ID */
	protected String pdid;
	
	/** 流程定义信息 */
	protected IG380Info processDefinition;
	
	/** 流程图XML */
	protected String flowChartXML;
	
	/** 流程图高度 */
	protected Integer flowChartHeight;
	
	/** 允许查询的最大记录数 */
	protected int maxSearchCount;

	/** 分页Bean */
	protected PagingDTO pagingDto;
	
	/** 用户查询form */
	protected IGPRD0201Form igprd0201Form;
	
	/** 用户角色信息集合 */
	protected List<UserRoleInfo> userroleList;
	
	/** 节点简略信息集合 */
	protected List<IGPRD02022VO> voList;

	/**
	 * 流程定义ID取得
	 * @return pdid 流程定义ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * 流程定义ID设定
	 * @param pdid 流程定义ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * 流程定义信息取得
	 * @return processDefinition 流程定义信息
	 */
	public IG380Info getProcessDefinition() {
		return processDefinition;
	}

	/**
	 * 流程定义信息设定
	 * @param processDefinition 流程定义信息
	 */
	public void setProcessDefinition(IG380Info processDefinition) {
		this.processDefinition = processDefinition;
	}

	/**
	 * 流程图XML取得
	 * @return flowChartXML 流程图XML
	 */
	public String getFlowChartXML() {
		return flowChartXML;
	}

	/**
	 * 流程图XML设定
	 * @param flowChartXML 流程图XML
	 */
	public void setFlowChartXML(String flowChartXML) {
		this.flowChartXML = flowChartXML;
	}

	/**
	 * 流程图高度取得
	 * @return flowChartHeight 流程图高度
	 */
	public Integer getFlowChartHeight() {
		return flowChartHeight;
	}

	/**
	 * 流程图高度设定
	 * @param flowChartHeight 流程图高度
	 */
	public void setFlowChartHeight(Integer flowChartHeight) {
		this.flowChartHeight = flowChartHeight;
	}

	/**
	 * 允许查询的最大记录数取得
	 * @return 允许查询的最大记录数
	 */
	public final int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * 允许查询的最大记录数设定
	 * @param maxSearchCount 允许查询的最大记录数
	 */
	public final void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * 分页bean取得
	 * @return 分页bean
	 */
	public final PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * 分页bean设定
	 * @param pagingDto 分页bean
	 */
	public final void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * 用户查询form取得
	 * @return 用户查询form
	 */
	public IGPRD0201Form getIgprd0201Form() {
		return igprd0201Form;
	}

	/**
	 * 用户查询form设定
	 * @param igprd0201Form 用户查询form
	 */
	public void setIgprd0201Form(IGPRD0201Form igprd0201Form) {
		this.igprd0201Form = igprd0201Form;
	}

	/**
	 * 用户角色信息集合取得
	 * @return 用户角色信息集合
	 */
	public List<UserRoleInfo> getUserroleList() {
		return userroleList;
	}

	/**
	 * 用户角色信息集合设定
	 * @param userroleList 用户角色信息集合
	 */
	public void setUserroleList(List<UserRoleInfo> userroleList) {
		this.userroleList = userroleList;
	}

	/**
	 * 节点简略信息集合取得
	 * @return voList 节点简略信息集合
	 */
	public List<IGPRD02022VO> getVoList() {
		return voList;
	}

	/**
	 * 节点简略信息集合设定
	 * @param voList 节点简略信息集合
	 */
	public void setVoList(List<IGPRD02022VO> voList) {
		this.voList = voList;
	}
}
