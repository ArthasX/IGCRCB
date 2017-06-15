/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */


package com.deliverik.infogovernor.sym.dto;

import java.io.Serializable;
import java.util.List;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.infogovernor.sym.form.IGSYM1402Form;
import com.deliverik.infogovernor.sym.form.IGSYM1407Form;
import com.deliverik.infogovernor.sym.model.ReportFileDefinition;
import com.deliverik.infogovernor.sym.model.ReportFileVersion;
import com.deliverik.infogovernor.sym.model.condition.ReportFileDefinitionSearchCond;
import com.deliverik.infogovernor.sym.model.condition.ReportFileVersionSearchCond;

/**
 * 报表信息业务DTO
 * 
 */
@SuppressWarnings("serial")
public class IGSYM14DTO extends BaseDTO implements Serializable{
	
	/** 报表信息检索条件 */
	protected ReportFileDefinitionSearchCond reportFileDefinitionSearchCond;
	
	/** 报表版本信息检索条件 */
	protected ReportFileVersionSearchCond reportFileVersionSearchCond;
	
	/** 报表信息Form */
	protected IGSYM1402Form igSYM1402Form;

	/** 报表信息检索结果集 */
	protected List<ReportFileDefinition> reportFileDefinitionList;
	
	/** 报表版本信息检索结果集 */
	protected List<ReportFileVersion> reportFileVersionList;
	
	/** 报表信息 */
	protected ReportFileDefinition reportFileDefinition;
	
	/** 用户信息 */
	protected User user;

	/** 分页用DTO */
	protected PagingDTO pagingDto;
	
	/** 允许查询的最大记录数 */
	protected int maxSearchCount;
	
	/** 报表删除主键 */
	protected String[] deleteRfdid;
	
	/** 报表主键 */
	protected Integer rfdid;
	
	/** 版本主键 */
	protected Integer rfvid;
	
	protected IGSYM1407Form	igsym1407Form;
	
	/** 对象名集合*/
	protected List<LabelValueBean> objectNameList;
	
	protected List<LabelValueBean> prtypeList;
	
	protected List<IG333Info> prstatusList;
	
	/** 报表模板数据集*/
	protected List<LabelValueBean> rfdFileNameList;

	public List<IG333Info> getPrstatusList() {
		return prstatusList;
	}

	public void setPrstatusList(List<IG333Info> prstatusList) {
		this.prstatusList = prstatusList;
	}

	public List<LabelValueBean> getPrtypeList() {
		return prtypeList;
	}

	public void setPrtypeList(List<LabelValueBean> prtypeList) {
		this.prtypeList = prtypeList;
	}

	public List<LabelValueBean> getObjectNameList() {
		return objectNameList;
	}

	public void setObjectNameList(List<LabelValueBean> objectNameList) {
		this.objectNameList = objectNameList;
	}

	public IGSYM1407Form getIgsym1407Form() {
		return igsym1407Form;
	}

	public void setIgsym1407Form(IGSYM1407Form igsym1407Form) {
		this.igsym1407Form = igsym1407Form;
	}

	/**
	 * 报表信息检索条件取得
	 * @return 报表信息检索条件
	 */
	public ReportFileDefinitionSearchCond getReportFileDefinitionSearchCond() {
		return reportFileDefinitionSearchCond;
	}

	/**
	 * 报表信息检索条件设定
	 * @param reportFileDefinitionSearchCond 报表信息检索条件
	 */
	public void setReportFileDefinitionSearchCond(
			ReportFileDefinitionSearchCond reportFileDefinitionSearchCond) {
		this.reportFileDefinitionSearchCond = reportFileDefinitionSearchCond;
	}

	/**
	 * 报表信息Form取得
	 * @return 报表信息Form
	 */
	public IGSYM1402Form getIgSYM1402Form() {
		return igSYM1402Form;
	}

	/**
	 * 报表信息Form设定
	 * @param igSYM1402Form 报表信息Form
	 */
	public void setIgSYM1402Form(IGSYM1402Form igSYM1402Form) {
		this.igSYM1402Form = igSYM1402Form;
	}

	/**
	 * 报表信息检索结果集取得
	 * @return 报表信息检索结果集
	 */
	public List<ReportFileDefinition> getReportFileDefinitionList() {
		return reportFileDefinitionList;
	}

	/**
	 * 报表信息检索结果集设定
	 * @param reportFileDefinitionList 报表信息检索结果集
	 */
	public void setReportFileDefinitionList(
			List<ReportFileDefinition> reportFileDefinitionList) {
		this.reportFileDefinitionList = reportFileDefinitionList;
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
	 * 允许查询的最大记录数取得
	 * @return 允许查询的最大记录数
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
	 * 用户信息取得
	 * @return 用户信息
	 */
	public User getUser() {
		return user;
	}

	/**
	 * 用户信息设定
	 * @param user 用户信息
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * 报表删除主键取得
	 * @return 报表删除主键
	 */
	public String[] getDeleteRfdid() {
		return deleteRfdid;
	}

	/**
	 * 报表删除主键设定
	 * @param deleteRfdid 报表删除主键
	 */
	public void setDeleteRfdid(String[] deleteRfdid) {
		this.deleteRfdid = deleteRfdid;
	}
	
	/**
	 * 报表主键取得
	 * @return 报表主键
	 */
	public Integer getRfdid() {
		return rfdid;
	}
	
	/**
	 * 报表主键设定
	 * @param rfdid 报表主键
	 */
	public void setRfdid(Integer rfdid) {
		this.rfdid = rfdid;
	}

	/**
	 * 报表版本信息检索条件取得
	 * @return 报表版本信息检索条件
	 */
	public ReportFileVersionSearchCond getReportFileVersionSearchCond() {
		return reportFileVersionSearchCond;
	}

	/**
	 * 报表版本信息检索条件设定
	 * @param reportFileVersionSearchCond 报表版本信息检索条件
	 */
	public void setReportFileVersionSearchCond(
			ReportFileVersionSearchCond reportFileVersionSearchCond) {
		this.reportFileVersionSearchCond = reportFileVersionSearchCond;
	}

	/**
	 * 报表版本信息检索结果集取得
	 * @return 报表版本信息检索结果集
	 */
	public List<ReportFileVersion> getReportFileVersionList() {
		return reportFileVersionList;
	}

	/**
	 * 报表版本信息检索结果集设定
	 * @param reportFileVersionList 报表版本信息检索结果集
	 */
	public void setReportFileVersionList(
			List<ReportFileVersion> reportFileVersionList) {
		this.reportFileVersionList = reportFileVersionList;
	}

	/**
	 * 报表信息取得
	 * @return 报表信息
	 */
	public ReportFileDefinition getReportFileDefinition() {
		return reportFileDefinition;
	}

	/**
	 * 报表信息设定
	 * @param reportFileDefinition 报表信息
	 */
	public void setReportFileDefinition(ReportFileDefinition reportFileDefinition) {
		this.reportFileDefinition = reportFileDefinition;
	}
	
	/**
	 * 版本主键取得
	 * @return 版本主键
	 */
	public Integer getRfvid() {
		return rfvid;
	}
	
	/**
	 * 版本主键设定
	 * @param rfvid 版本主键
	 */
	public void setRfvid(Integer rfvid) {
		this.rfvid = rfvid;
	}

    /**
     * @return the rfdFileNameList
     */
    public List<LabelValueBean> getRfdFileNameList() {
        return rfdFileNameList;
    }

    /**
     * @param rfdFileNameList the rfdFileNameList to set
     */
    public void setRfdFileNameList(List<LabelValueBean> rfdFileNameList) {
        this.rfdFileNameList = rfdFileNameList;
    }
	
}


