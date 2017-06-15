package com.deliverik.infogovernor.sta.dto;

import java.io.Serializable;
import java.util.List;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.asset.model.IG499Info;
import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.sta.form.IGSTA0102Form;
import com.deliverik.infogovernor.sta.form.IGSTA0103Form;
import com.deliverik.infogovernor.sta.form.IGSTA0105Form;
import com.deliverik.infogovernor.sta.model.Contract;
import com.deliverik.infogovernor.sta.model.ProjectStatistic;
import com.deliverik.infogovernor.sta.model.RiskCheckProblemSuperviseVWInfo;

/**
 * 工作监督DTO
 * 
 */
@SuppressWarnings("serial")
public class IGSTA01DTO extends BaseDTO implements Serializable{

	/** 允许查询的最大记录数 */
	protected int maxSearchCount;

	/**  分页Bean  */
	protected PagingDTO pagingDto;
	
	/**  合同模型  */
	protected List<LabelValueBean> contractType;
	
	/** 问题整改监督Form */
	protected IGSTA0102Form igsta0102Form;

	/** 问题整改信息取得 */
	List<RiskCheckProblemSuperviseVWInfo> riskCheckProblemSuperviseVWList;
			
	protected IGSTA0103Form igsta0103Form;
	
	protected IGSTA0105Form igsta0105Form;

	/**项目统计信息*/
	protected List<ProjectStatistic> projectInfo;
	
	/**合同统计信息*/
	protected List<Contract> contracts;
	
	/** 合同信息检索结果 */
    protected List<IG499Info> entityItemCompactVWInfoList;
	/**
	 * 允许查询的最大记录数取得
	 * @return maxSearchCount 允许查询的最大记录数
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * 允许查询的最大记录数设定
	 * @param maxSearchCount 允许查询的最大记录数
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * 分页Bean取得
	 * @return pagingDto 分页Bean
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * 分页Bean设定
	 * @param pagingDto 分页Bean
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * 问题整改监督Form取得
	 * @return igsta0102Form 问题整改监督Form
	 */
	public IGSTA0102Form getIgsta0102Form() {
		return igsta0102Form;
	}

	/**
	 * 问题整改监督Form设定
	 * @param igsta0102Form 问题整改监督Form
	 */
	public void setIgsta0102Form(IGSTA0102Form igsta0102Form) {
		this.igsta0102Form = igsta0102Form;
	}

	/**
	 * 问题整改信息取得取得
	 * @return riskCheckProblemSuperviseVWList 问题整改信息取得
	 */
	public List<RiskCheckProblemSuperviseVWInfo> getRiskCheckProblemSuperviseVWList() {
		return riskCheckProblemSuperviseVWList;
	}

	/**
	 * 问题整改信息取得设定
	 * @param riskCheckProblemSuperviseVWList 问题整改信息取得
	 */
	public void setRiskCheckProblemSuperviseVWList(
			List<RiskCheckProblemSuperviseVWInfo> riskCheckProblemSuperviseVWList) {
		this.riskCheckProblemSuperviseVWList = riskCheckProblemSuperviseVWList;
	}

    /**
     * igsta0103Form取得
     *
     * @return igsta0103Form igsta0103Form
     */
    public IGSTA0103Form getIgsta0103Form() {
        return igsta0103Form;
    }

    /**
     * 合同统计信息取得
     *
     * @return contracts 合同统计信息
     */
    public List<Contract> getContracts() {
        return contracts;
    }

    /**
     * igsta0103Form设定
     *
     * @param igsta0103Form igsta0103Form
     */
    public void setIgsta0103Form(IGSTA0103Form igsta0103Form) {
        this.igsta0103Form = igsta0103Form;
    }

    /**
     * 合同统计信息设定
     *
     * @param contracts 合同统计信息
     */
    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    /**
     * 合同模型取得
     *
     * @return contractType 合同模型
     */
    public List<LabelValueBean> getContractType() {
        return contractType;
    }

    /**
     * 合同模型设定
     *
     * @param contractType 合同模型
     */
    public void setContractType(List<LabelValueBean> contractType) {
        this.contractType = contractType;
    }

    /**
     * 合同信息检索结果取得
     *
     * @return entityItemCompactVWInfoList 合同信息检索结果
     */
    public List<IG499Info> getEntityItemCompactVWInfoList() {
        return entityItemCompactVWInfoList;
    }

    /**
     * 合同信息检索结果设定
     *
     * @param entityItemCompactVWInfoList 合同信息检索结果
     */
    public void setEntityItemCompactVWInfoList(List<IG499Info> entityItemCompactVWInfoList) {
        this.entityItemCompactVWInfoList = entityItemCompactVWInfoList;
    }

    /**
     * igsta0105Form取得
     *
     * @return igsta0105Form igsta0105Form
     */
    public IGSTA0105Form getIgsta0105Form() {
        return igsta0105Form;
    }

    /**
     * 项目统计信息取得
     *
     * @return projectInfo 项目统计信息
     */
    public List<ProjectStatistic> getProjectInfo() {
        return projectInfo;
    }

    /**
     * igsta0105Form设定
     *
     * @param igsta0105Form igsta0105Form
     */
    public void setIgsta0105Form(IGSTA0105Form igsta0105Form) {
        this.igsta0105Form = igsta0105Form;
    }

    /**
     * 项目统计信息设定
     *
     * @param projectInfo 项目统计信息
     */
    public void setProjectInfo(List<ProjectStatistic> projectInfo) {
        this.projectInfo = projectInfo;
    }
	
}


