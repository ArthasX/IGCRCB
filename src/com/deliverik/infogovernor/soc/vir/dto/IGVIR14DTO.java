/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.vir.dto;

import java.util.List;
import java.util.Map;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.infogovernor.soc.vir.form.IGVIR1401Form;
import com.deliverik.infogovernor.soc.vir.form.IGVIR1403Form;
import com.deliverik.infogovernor.soc.vir.vim.model.Host;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 统计分析管理DTO
 * </p>
 * 
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGVIR14DTO extends BaseDTO{
    
    /** 事件数量 */
    protected Integer incidentCount;
    
    /** 问题数量 */
    protected Integer problemCount;
    
    /** 变更数量 */
    protected Integer changeCount;
    
    /** 资源申请数量 */
    protected Integer resnewCount;
    
    /** 资源调整数量 */
    protected Integer resadjustCount;
    
    /** 资源回收数量 */
    protected Integer resrecoverCount;

    /** 未关闭的运维流程列表 */
    protected List<IG500Info> omprocessRecordList;
    
    /** 未关闭的资源申请列表 */
    protected List<IG500Info> resprocessRecordList;
    
    /**分页Bean*/
    protected PagingDTO pagingDto;
    
    /**允许查询的最大记录数*/
    protected int maxSearchCount;
    
    /** 主机下虚机数量列表 */
    protected String vmcountJson;
    
    /**  运行及运维情况Form */
    protected IGVIR1403Form igvir1403Form;
    
    /** vCenter连接ID */
    protected Integer vcid;

    /** 资源申请统计Form */
    protected IGVIR1401Form igvir1401Form;
    
    /** 资源申请统计Map */
    protected Map<String, Integer[]> vmApplyStatisticsDataMap;
    
    /** 下拉列表值域 */
    protected List<LabelValueBean> labelValueBeanList;
    
    /** Host信息集合 */
    protected Map<Integer, List<Host>> hostMap;
    
    /** 主机IP */
    protected String hostname;

    /**
     * 获取事件数量
     * @return 事件数量 
     */
    public Integer getIncidentCount() {
        return incidentCount;
    }

    /**
     * 设置事件数量
     * @param incidentCount 事件数量
     */
    public void setIncidentCount(Integer incidentCount) {
        this.incidentCount = incidentCount;
    }

    /**
     * 获取问题数量
     * @return 问题数量 
     */
    public Integer getProblemCount() {
        return problemCount;
    }

    /**
     * 设置问题数量
     * @param problemCount 问题数量
     */
    public void setProblemCount(Integer problemCount) {
        this.problemCount = problemCount;
    }

    /**
     * 获取变更数量
     * @return 变更数量 
     */
    public Integer getChangeCount() {
        return changeCount;
    }

    /**
     * 设置变更数量
     * @param changeCount 变更数量
     */
    public void setChangeCount(Integer changeCount) {
        this.changeCount = changeCount;
    }

    /**
     * 获取资源申请数量
     * @return 资源申请数量 
     */
    public Integer getResnewCount() {
        return resnewCount;
    }

    /**
     * 设置资源申请数量
     * @param resnewCount 资源申请数量
     */
    public void setResnewCount(Integer resnewCount) {
        this.resnewCount = resnewCount;
    }

    /**
     * 获取资源调整数量
     * @return 资源调整数量 
     */
    public Integer getResadjustCount() {
        return resadjustCount;
    }

    /**
     * 设置资源调整数量
     * @param resadjustCount 资源调整数量
     */
    public void setResadjustCount(Integer resadjustCount) {
        this.resadjustCount = resadjustCount;
    }

    /**
     * 获取资源回收数量
     * @return 资源回收数量 
     */
    public Integer getResrecoverCount() {
        return resrecoverCount;
    }

    /**
     * 设置资源回收数量
     * @param resrecoverCount 资源回收数量
     */
    public void setResrecoverCount(Integer resrecoverCount) {
        this.resrecoverCount = resrecoverCount;
    }

    /**
     * 获取未关闭的运维流程列表
     * @return 未关闭的运维流程列表 
     */
    public List<IG500Info> getOmprocessRecordList() {
        return omprocessRecordList;
    }

    /**
     * 设置未关闭的运维流程列表
     * @param omprocessRecordList 未关闭的运维流程列表
     */
    public void setOmprocessRecordList(List<IG500Info> omprocessRecordList) {
        this.omprocessRecordList = omprocessRecordList;
    }

    /**
     * 获取未关闭的资源申请列表
     * @return 未关闭的资源申请列表 
     */
    public List<IG500Info> getResprocessRecordList() {
        return resprocessRecordList;
    }

    /**
     * 设置未关闭的资源申请列表
     * @param resprocessRecordList 未关闭的资源申请列表
     */
    public void setResprocessRecordList(List<IG500Info> resprocessRecordList) {
        this.resprocessRecordList = resprocessRecordList;
    }

    /**
     * 获取分页Bean
     * @return 分页Bean 
     */
    public PagingDTO getPagingDto() {
        return pagingDto;
    }

    /**
     * 设置分页Bean
     * @param pagingDto 分页Bean
     */
    public void setPagingDto(PagingDTO pagingDto) {
        this.pagingDto = pagingDto;
    }

    /**
     * 获取允许查询的最大记录数
     * @return 允许查询的最大记录数 
     */
    public int getMaxSearchCount() {
        return maxSearchCount;
    }

    /**
     * 设置允许查询的最大记录数
     * @param maxSearchCount 允许查询的最大记录数
     */
    public void setMaxSearchCount(int maxSearchCount) {
        this.maxSearchCount = maxSearchCount;
    }

    /**
     * 获取主机下虚机数量列表
     * @return 主机下虚机数量列表 
     */
    public String getVmcountJson() {
        return vmcountJson;
    }

    /**
     * 设置主机下虚机数量列表
     * @param vmcountJson 主机下虚机数量列表
     */
    public void setVmcountJson(String vmcountJson) {
        this.vmcountJson = vmcountJson;
    }

    /**
     * 获取运行及运维情况Form
     * @return 运行及运维情况Form 
     */
    public IGVIR1403Form getIgvir1403Form() {
        return igvir1403Form;
    }

    /**
     * 设置运行及运维情况Form
     * @param igvir1403Form 运行及运维情况Form
     */
    public void setIgvir1403Form(IGVIR1403Form igvir1403Form) {
        this.igvir1403Form = igvir1403Form;
    }

    /**
     * 获取vCenter连接ID
     * @return vCenter连接ID 
     */
    public Integer getVcid() {
        return vcid;
    }

    /**
     * 设置vCenter连接ID
     * @param vcid vCenter连接ID
     */
    public void setVcid(Integer vcid) {
        this.vcid = vcid;
    }

    /**
     * 获取资源申请统计Form
     * @return 资源申请统计Form 
     */
    public IGVIR1401Form getIgvir1401Form() {
        return igvir1401Form;
    }

    /**
     * 设置资源申请统计Form
     * @param igvir1401Form 资源申请统计Form
     */
    public void setIgvir1401Form(IGVIR1401Form igvir1401Form) {
        this.igvir1401Form = igvir1401Form;
    }

    /**
     * 获取资源申请统计Map
     * @return 资源申请统计Map 
     */
    public Map<String, Integer[]> getVmApplyStatisticsDataMap() {
        return vmApplyStatisticsDataMap;
    }

    /**
     * 设置资源申请统计Map
     * @param vmApplyStatisticsDataMap 资源申请统计Map
     */
    public void setVmApplyStatisticsDataMap(Map<String, Integer[]> vmApplyStatisticsDataMap) {
        this.vmApplyStatisticsDataMap = vmApplyStatisticsDataMap;
    }

    /**
     * 获取下拉列表值域
     * @return 下拉列表值域 
     */
    public List<LabelValueBean> getLabelValueBeanList() {
        return labelValueBeanList;
    }

    /**
     * 设置下拉列表值域
     * @param labelValueBeanList 下拉列表值域
     */
    public void setLabelValueBeanList(List<LabelValueBean> labelValueBeanList) {
        this.labelValueBeanList = labelValueBeanList;
    }

	/**
	 * Host信息集合取得
	 * @return hostMap Host信息集合
	 */
	public Map<Integer, List<Host>> getHostMap() {
		return hostMap;
	}

	/**
	 * Host信息集合设定
	 * @param hostMap Host信息集合
	 */
	public void setHostMap(Map<Integer, List<Host>> hostMap) {
		this.hostMap = hostMap;
	}

	/**
	 * 主机IP取得
	 * @return hostname 主机IP
	 */
	public String getHostname() {
		return hostname;
	}

	/**
	 * 主机IP设定
	 * @param hostname 主机IP
	 */
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
}
