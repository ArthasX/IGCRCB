/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.sym.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.infogovernor.sym.form.IGSYM1701Form;
import com.deliverik.infogovernor.sym.form.IGSYM1702Form;

/**
 * 概述: 流程策略设定业务DTO
 * 功能描述：流程策略设定业务DTO
 * 创建记录：刘鹏    2010/11/26
 * 修改记录：
 */
@SuppressWarnings("serial")
public class IGSYM17DTO extends BaseDTO implements Serializable{
	
	/** 流程定义查询Form */
	protected IGSYM1701Form igSYM1701Form;
	
	/** 流程策略设定Form */
	protected IGSYM1702Form igSYM1702Form;

	/** 流程定义信息检索结果集 */
	protected List<IG380Info> processDefinitionList;
	
	/** 允许查询的最大记录数 */
	protected int maxSearchCount;

	/** 分页Bean */
	protected PagingDTO pagingDto;
	
	/** 流程策略 */
	protected Map<String, String> strategyMap;
	
	/** 紧急程度集合 */
	protected List<LabelValueBean> prurgencyList;
	
	/** 流程状态集合 */
	protected List<LabelValueBean> prstatusList;
	
	/** 流程定义信息 */
	protected IG380Info processDefinition;
	
	/** 流程策略版本号 */
	protected Integer psdversion;
	
	/** 流程策略最大版本号 */
	protected Integer maxPsdversion;

	/**
	 * 流程定义查询Form取得
	 * @return 流程定义查询Form
	 */
	public IGSYM1701Form getIgSYM1701Form() {
		return igSYM1701Form;
	}
	
	/**
	 * 流程定义查询Form设定
	 * @param igSYM1701Form流程定义查询Form
	 */
	public void setIgSYM1701Form(IGSYM1701Form igSYM1701Form) {
		this.igSYM1701Form = igSYM1701Form;
	}
	
	/**
	 * 流程策略设定Form取得
	 * @return 流程策略设定Form
	 */
	public IGSYM1702Form getIgSYM1702Form() {
		return igSYM1702Form;
	}

	/**
	 * 流程策略设定Form设定
	 * @param igSYM1702Form流程策略设定Form
	 */
	public void setIgSYM1702Form(IGSYM1702Form igSYM1702Form) {
		this.igSYM1702Form = igSYM1702Form;
	}

	/**
	 * 流程定义信息检索结果集取得
	 * @return 流程定义信息检索结果集
	 */
	public List<IG380Info> getProcessDefinitionList() {
		return processDefinitionList;
	}

	/**
	 * 流程定义信息检索结果集设定
	 * @param processDefinitionList流程定义信息检索结果集
	 */
	public void setProcessDefinitionList(
			List<IG380Info> processDefinitionList) {
		this.processDefinitionList = processDefinitionList;
	}

	/**
	 * 允许查询的最大记录数取得
	 * @return 允许查询的最大记录数
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * 允许查询的最大记录数设定
	 * @param processDefinitionList允许查询的最大记录数
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * 分页Bean取得
	 * @return 分页Bean
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * 分页Bean设定
	 * @param processDefinitionList分页Bean
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}
	
	/**
	 * 流程策略Map设定
	 * @param strategyMap流程策略Map
	 */
	public void setStrategyMap(Map<String, String> strategyMap) {
		this.strategyMap = strategyMap;
	}

	/**
	 * 流程策略Map取得
	 * @return 流程策略Map
	 */
	public Map<String, String> getStrategyMap() {
		return strategyMap;
	}

	/**
	 * 紧急程度集合设定
	 * @param prurgencyList紧急程度集合
	 */
	public List<LabelValueBean> getPrurgencyList() {
		return prurgencyList;
	}

	/**
	 * 紧急程度集合取得
	 * @return 紧急程度集合
	 */
	public void setPrurgencyList(List<LabelValueBean> prurgencyList) {
		this.prurgencyList = prurgencyList;
	}

	/**
	 * 流程状态集合设定
	 * @param prstatusList流程状态集合
	 */
	public List<LabelValueBean> getPrstatusList() {
		return prstatusList;
	}

	/**
	 * 流程状态集合取得
	 * @return 流程状态集合
	 */
	public void setPrstatusList(List<LabelValueBean> prstatusList) {
		this.prstatusList = prstatusList;
	}

	/**
	 * 流程定义信息设定
	 * @param processDefinition流程定义信息
	 */
	public IG380Info getProcessDefinition() {
		return processDefinition;
	}

	/**
	 * 流程定义信息取得
	 * @return 流程定义信息
	 */
	public void setProcessDefinition(IG380Info processDefinition) {
		this.processDefinition = processDefinition;
	}

	/**
	 * 流程策略版本号取得
	 * @return 流程策略版本号
	 */
	public Integer getPsdversion() {
		return psdversion;
	}

	/**
	 * 流程策略版本号设定
	 * @param psdversion流程策略版本号
	 */
	public void setPsdversion(Integer psdversion) {
		this.psdversion = psdversion;
	}

	/**
	 * 流程策略最大版本号取得
	 * @return 流程策略最大版本号
	 */
	public Integer getMaxPsdversion() {
		return maxPsdversion;
	}

	/**
	 * 流程策略最大版本号设定
	 * @param maxPsdversion流程策略最大版本号
	 */
	public void setMaxPsdversion(Integer maxPsdversion) {
		this.maxPsdversion = maxPsdversion;
	}
	
}


