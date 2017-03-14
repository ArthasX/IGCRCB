package com.deliverik.infogovernor.svc.dto;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.workflow.prr.model.IG160Info;
import com.deliverik.framework.workflow.prr.model.IG359Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.condition.IG359SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCond;
import com.deliverik.infogovernor.svc.form.IGSVC0601Form;
import com.deliverik.infogovernor.svc.form.IGSVC0602Form;
import com.deliverik.infogovernor.svc.form.IGSVC0635Form;
import com.deliverik.infogovernor.svc.form.IGSVC0636Form;
import com.deliverik.infogovernor.svc.form.IGSVC0639Form;
import com.deliverik.infogovernor.svc.form.IGSVC0637Form;
import com.deliverik.infogovernor.svc.form.IGSVC0638Form;
import com.deliverik.infogovernor.svc.form.IGSVC0640Form;
import com.deliverik.infogovernor.svc.form.IGSVC0642Form;
import com.deliverik.infogovernor.svc.model.IncidentAveSolveTimeVWInfo;
import com.deliverik.infogovernor.svc.model.IncidentTypeVWInfo;
import com.deliverik.infogovernor.svc.model.OrganizationServiceVWInfo;
import com.deliverik.infogovernor.svc.model.ServiceTopFiveVWInfo;
import com.deliverik.infogovernor.svc.vo.IGSVC06421VO;

public class IGSVC06DTO extends BaseDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private IGSVC0601Form igsvc0601Form;

	private IG500Info processRecord;
	
	private IG500SearchCond processRecordSearchCond;
	
	private IGSVC0602Form igsvc0602Form;
	
	/**人员工作量统计form*/
	private IGSVC0639Form igsvc0639Form;
	
	/** 故障类型统计form */
	private IGSVC0635Form igsvc0635Form;
	
	/** 部门服务统计form */
	protected IGSVC0636Form igsvc0636Form;
	
	/** 部门服务top5统计 */
	protected IGSVC0637Form igsvc0637Form;
	
	/** 故障类型平均解决时间统计form */
	protected IGSVC0638Form igsvc0638Form;
	
	/** 流程数量统计Form */
	protected IGSVC0642Form igsvc0642Form;
	
	private String prassetcategory;
	
	/** 故障类型统计信息 */
	private IncidentTypeVWInfo incidentType;
	
	/**人员工作量统计信息*/
	private List<IG160Info> summartyCountList;
	
	/**
	 * 流程汇总信息列表
	 */
	private List<IG359Info> processCountList;
	
	/** 部门服务统计数据集合 */
	private List<OrganizationServiceVWInfo> organizationServiceList;
	
	/** 事件总数 */
	private Integer icount;
	
	/** 服务请求总数 */
	private Integer scount;
	
	/** 工单数 */
	private Integer gcount;
	
	/** 总数 */
	private Integer totalCount;
	
	/** 部门服务top5统计数据 */
	protected List<ServiceTopFiveVWInfo> serviceTopFiveList;
	
	/** 时间平均解决时间统计数据 */
	protected List<IncidentAveSolveTimeVWInfo> incidentAveSolveTimeDate;

	/**人员工作来那个统计Json格式  人员信息 */
	private String presonsJson;
	/**人员工作量统计 Json 格式统计数据*/
	private String acountJson;
	
	/** 年度工作趋势统计Form */
	private IGSVC0640Form igsvc0640Form;
	
	/** 流程数量统计VO */
	protected IGSVC06421VO igsvc06421VO;
	
	/** 事件统计数量 */
	private String incidentnum;
	/** 问题统计数量 */
	private String problemnum;
	/** 变更统计数量 */
	private String changenum;
	/** 服务请求统计数量 */
	private String servicenum;
	/** 服务工单统计数量 */
	private String sfnum;

	public IG500SearchCond getProcessRecordSearchCond() {
		return processRecordSearchCond;
	}

	public void setProcessRecordSearchCond(
			IG500SearchCond processRecordSearchCond) {
		this.processRecordSearchCond = processRecordSearchCond;
	}

	public String getPrassetcategory() {
		return prassetcategory;
	}

	public void setPrassetcategory(String prassetcategory) {
		this.prassetcategory = prassetcategory;
	}

	protected IG359SearchCond processcountsearchcond;
	
	public IG359SearchCond getProcesscountsearchcond() {
		return processcountsearchcond;
	}

	public void setProcesscountsearchcond(
			IG359SearchCond processcountsearchcond) {
		this.processcountsearchcond = processcountsearchcond;
	}

	
	public IGSVC0602Form getIgsvc0602Form() {
		return igsvc0602Form;
	}

	public void setIgsvc0602Form(IGSVC0602Form igsvc0602Form) {
		this.igsvc0602Form = igsvc0602Form;
	}

	public IGSVC0601Form getIgsvc0601Form() {
		return igsvc0601Form;
	}

	public void setIgsvc0601Form(IGSVC0601Form igsvc0601Form) {
		this.igsvc0601Form = igsvc0601Form;
	}

	public IG500Info getProcessRecord() {
		return processRecord;
	}

	public void setProcessRecord(IG500Info processRecord) {
		this.processRecord = processRecord;
	}

	public List<IG359Info> getProcessCountList() {
		return processCountList;
	}

	public void setProcessCountList(List<IG359Info> processCountList) {
		this.processCountList = processCountList;
	}

	/**
	 * 故障类型统计form取得
	 * @return igsvc0635Form 故障类型统计form
	 */
	public IGSVC0635Form getIgsvc0635Form() {
		return igsvc0635Form;
	}

	/**
	 * 故障类型统计form设定
	 * @param igsvc0635Form 故障类型统计form
	 */
	public void setIgsvc0635Form(IGSVC0635Form igsvc0635Form) {
		this.igsvc0635Form = igsvc0635Form;
	}

	/**
	 * 部门服务统计form取得
	 * @return igsvc0636Form 部门服务统计form
	 */
	public IGSVC0636Form getIgsvc0636Form() {
		return igsvc0636Form;
	}

	/**
	 * 部门服务统计form设定
	 * @param igsvc0636Form 部门服务统计form
	 */
	public void setIgsvc0636Form(IGSVC0636Form igsvc0636Form) {
		this.igsvc0636Form = igsvc0636Form;
	}

	/**
	 * 部门服务top5统计取得
	 * @return igsvc0637Form 部门服务top5统计
	 */
	public IGSVC0637Form getIgsvc0637Form() {
		return igsvc0637Form;
	}

	/**
	 * 部门服务top5统计设定
	 * @param igsvc0637Form 部门服务top5统计
	 */
	public void setIgsvc0637Form(IGSVC0637Form igsvc0637Form) {
		this.igsvc0637Form = igsvc0637Form;
	}

	/**
	 * 故障类型平均解决时间统计form取得
	 * @return igsvc0638Form 故障类型平均解决时间统计form
	 */
	public IGSVC0638Form getIgsvc0638Form() {
		return igsvc0638Form;
	}

	/**
	 * 故障类型平均解决时间统计form设定
	 * @param igsvc0638Form 故障类型平均解决时间统计form
	 */
	public void setIgsvc0638Form(IGSVC0638Form igsvc0638Form) {
		this.igsvc0638Form = igsvc0638Form;
	}

	/**
	 * 流程数量统计Form取得
	 * @return igsvc0642Form 流程数量统计Form
	 */
	public IGSVC0642Form getIgsvc0642Form() {
		return igsvc0642Form;
	}

	/**
	 * 流程数量统计Form设定
	 * @param igsvc0642Form 流程数量统计Form
	 */
	public void setIgsvc0642Form(IGSVC0642Form igsvc0642Form) {
		this.igsvc0642Form = igsvc0642Form;
	}

	/**
	 * 故障类型统计信息取得
	 * @return incidentType 故障类型统计信息
	 */
	public IncidentTypeVWInfo getIncidentType() {
		return incidentType;
	}

	/**
	 * 故障类型统计信息设定
	 * @param incidentType 故障类型统计信息
	 */
	public void setIncidentType(IncidentTypeVWInfo incidentType) {
		this.incidentType = incidentType;
	}

	/**
	 * 部门服务统计数据集合取得
	 * @return organizationServiceList 部门服务统计数据集合
	 */
	public List<OrganizationServiceVWInfo> getOrganizationServiceList() {
		return organizationServiceList;
	}

	/**
	 * 部门服务统计数据集合设定
	 * @param organizationServiceList 部门服务统计数据集合
	 */
	public void setOrganizationServiceList(
			List<OrganizationServiceVWInfo> organizationServiceList) {
		this.organizationServiceList = organizationServiceList;
	}

	/**
	 * 事件总数取得
	 * @return icount 事件总数
	 */
	public Integer getIcount() {
		return icount;
	}

	/**
	 * 事件总数设定
	 * @param icount 事件总数
	 */
	public void setIcount(Integer icount) {
		this.icount = icount;
	}

	/**
	 * 服务请求总数取得
	 * @return scount 服务请求总数
	 */
	public Integer getScount() {
		return scount;
	}

	/**
	 * 服务请求总数设定
	 * @param scount 服务请求总数
	 */
	public void setScount(Integer scount) {
		this.scount = scount;
	}

	/**
	 * 总数取得
	 * @return totalCount 总数
	 */
	public Integer getTotalCount() {
		return totalCount;
	}

	/**
	 * 总数设定
	 * @param totalCount 总数
	 */
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public IGSVC0639Form getIgsvc0639Form() {
		return igsvc0639Form;
	}

	public void setIgsvc0639Form(IGSVC0639Form igsvc0639Form) {
		this.igsvc0639Form = igsvc0639Form;
	}

	public List<IG160Info> getSummartyCountList() {
		return summartyCountList;
	}

	public void setSummartyCountList(List<IG160Info> summartyCountList) {
		this.summartyCountList = summartyCountList;
	}

	public String getPresonsJson() {
		return presonsJson;
	}

	public void setPresonsJson(String presonsJson) {
		this.presonsJson = presonsJson;
	}

	public String getAcountJson() {
		return acountJson;
	}

	public void setAcountJson(String acountJson) {
		this.acountJson = acountJson;
	}

	
	/**
	 * 部门服务top5统计数据取得
	 * @return serviceTopFiveList 部门服务top5统计数据
	 */
	public List<ServiceTopFiveVWInfo> getServiceTopFiveList() {
		return serviceTopFiveList;
	}

	/**
	 * 部门服务top5统计数据设定
	 * @param serviceTopFiveList 部门服务top5统计数据
	 */
	public void setServiceTopFiveList(List<ServiceTopFiveVWInfo> serviceTopFiveList) {
		this.serviceTopFiveList = serviceTopFiveList;
	}

	/**
	 * 时间平均解决时间统计数据取得
	 * @return incidentAveSolveTimeDate 时间平均解决时间统计数据
	 */
	public List<IncidentAveSolveTimeVWInfo> getIncidentAveSolveTimeDate() {
		return incidentAveSolveTimeDate;
	}

	/**
	 * 时间平均解决时间统计数据设定
	 * @param incidentAveSolveTimeDate 时间平均解决时间统计数据
	 */
	public void setIncidentAveSolveTimeDate(
			List<IncidentAveSolveTimeVWInfo> incidentAveSolveTimeDate) {
		this.incidentAveSolveTimeDate = incidentAveSolveTimeDate;
	}
	public Integer getGcount() {
		return gcount;
	}

	public void setGcount(Integer gcount) {
		this.gcount = gcount;
	}

	/**
	 * 年度工作趋势统计Form取得
	 * @return igsvc0640Form 年度工作趋势统计Form
	 */
	public IGSVC0640Form getIgsvc0640Form() {
		return igsvc0640Form;
	}

	/**
	 * 年度工作趋势统计Form设定
	 * @param igsvc0640Form 年度工作趋势统计Form
	 */
	public void setIgsvc0640Form(IGSVC0640Form igsvc0640Form) {
		this.igsvc0640Form = igsvc0640Form;
	}
	/**
	 * 流程数量统计VO取得
	 * @return igsvc06421VO 流程数量统计VO
	 */
	public IGSVC06421VO getIgsvc06421VO() {
		return igsvc06421VO;
	}

	/**
	 * 流程数量统计VO设定
	 * @param igsvc06421VO 流程数量统计VO
	 */
	public void setIgsvc06421VO(IGSVC06421VO igsvc06421vo) {
		igsvc06421VO = igsvc06421vo;
	}

	/**
	 * 事件统计数量取得
	 * @return incidentnum 事件统计数量
	 */
	public String getIncidentnum() {
		return incidentnum;
	}
	
	/**
	 * 事件统计数量设定
	 * @param incidentnum 事件统计数量
	 */
	public void setIncidentnum(String incidentnum) {
		this.incidentnum = incidentnum;
	}

	/**
	 * 问题统计数量取得
	 * @return problemnum 问题统计数量
	 */
	public String getProblemnum() {
		return problemnum;
	}

	/**
	 * 问题统计数量设定
	 * @param problemnum 问题统计数量
	 */
	public void setProblemnum(String problemnum) {
		this.problemnum = problemnum;
	}

	/**
	 * 变更统计数量取得
	 * @return changenum 变更统计数量
	 */
	public String getChangenum() {
		return changenum;
	}

	/**
	 * 变更统计数量设定
	 * @param changenum 变更统计数量
	 */
	public void setChangenum(String changenum) {
		this.changenum = changenum;
	}

	/**
	 * 服务请求统计数量取得
	 * @return servicenum 服务请求统计数量
	 */
	public String getServicenum() {
		return servicenum;
	}
	
	/**
	 * 服务请求统计数量设定
	 * @param servicenum 服务请求统计数量
	 */
	public void setServicenum(String servicenum) {
		this.servicenum = servicenum;
	}

	/**
	 * 服务工单统计数量取得
	 * @return sfnum 服务工单统计数量
	 */
	public String getSfnum() {
		return sfnum;
	}
	
	/**
	 * 服务工单统计数量设定
	 * @param sfnum 服务工单统计数量
	 */
	public void setSfnum(String sfnum) {
		this.sfnum = sfnum;
	}
	
}
