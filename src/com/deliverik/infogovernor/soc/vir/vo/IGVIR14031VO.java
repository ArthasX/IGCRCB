/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.vir.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.infogovernor.soc.vir.model.VIM03Info;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 虚机资源管理VO
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGVIR14031VO extends BaseVO{

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
    protected List<String[]> vmcountList;

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
    public List<String[]> getVmcountList() {
        return vmcountList;
    }

    /**
     * 设置主机下虚机数量列表
     * @param vmcountList 主机下虚机数量列表
     */
    public void setVmcountList(List<String[]> vmcountList) {
        this.vmcountList = vmcountList;
    }
    
    
}
