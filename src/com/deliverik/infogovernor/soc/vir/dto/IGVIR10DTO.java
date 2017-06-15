package com.deliverik.infogovernor.soc.vir.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG677Info;
import com.deliverik.infogovernor.com.model.ProcessInHandVWInfo;
import com.deliverik.infogovernor.soc.vir.form.IGVIR1001Form;
import com.deliverik.infogovernor.soc.vir.model.VIM03CountByOrgVWInfo;
import com.deliverik.infogovernor.soc.vir.model.VIM03Info;
import com.deliverik.infogovernor.soc.vir.vim.model.Host;
import com.deliverik.infogovernor.soc.vir.vim.model.Template;
import com.deliverik.infogovernor.soc.vir.vim.model.VMachine;
import com.deliverik.infogovernor.soc.vir.vo.IGVIR10051VO;

/**
 * 首页业务DTO
 * 
 */
@SuppressWarnings("serial")
public class IGVIR10DTO extends BaseDTO implements Serializable{
	
	/**form*/
	private IGVIR1001Form igvir1001Form;
	
	/**申请信息*/
	private List<IG500Info> lstProcessRecord;

	/**用户信息*/
	private User user;
	
	/**用户到期资源数量 */
	private Integer userExpireCount;
	
	/**用户资源总数量 */
	private Integer userCount;
	
	/**部门到期资源数量 */
	private Integer orgExpireCount;
	
	/**部门资源总数量 */
	private Integer orgCount;
	
	/**资源概况信息*/
	private Map<String, Integer> resourceSurveyMap;
	/**部门资源使用情况*/
	private List<VIM03CountByOrgVWInfo> orgResList;
	
	/**部门即将到期资源情况*/
	private List<VIM03CountByOrgVWInfo> orgExpiryResList;
	
	/**待处理工作*/
	protected List<ProcessInHandVWInfo> pihList;
	
	/** 个人金额结算 */
	private Integer usercost;
	
	/** 部门金额结算 */
	private Integer orgcost;
	
	/** 总金额结算 */
	private Integer totalcost;
	
	/**模板集合*/
	private List<Template> templateList;
	
	/**个人VM列表*/
	private List<VIM03Info> ownVMList ;
	
	/**月份统计信息*/
	private List<Object[]> monthCountData;
	
	/** 月份统计信息Json */
	protected String monthCountJson ;
	
	/** 月份信息Json */
	protected String monthJson ;
	
	/** 虚拟化管理首页VO */
	protected IGVIR10051VO igvir10051VO;
	
	/** 我发起的流程信息 */
	protected List<IG677Info> myOpenProcessList;
	
	/** 虚机信息 */
	protected List<VMachine> vmList;
	
	/** 虚机名称 */
	protected String vmname;
	
	/** 虚机状态 */
	protected String powerState;
	
	/** Host信息集合 */
	protected Map<Integer, List<Host>> hostMap;
	
	/** 申请趋势统计Map */
	protected Map<String, Integer> vmReportMap;
	
	/** 运维流程趋势Map */
	protected Map<String, Map<String, Integer>> prRecportMap;
	
    /** vcenter主键 */
    protected Integer vcid;
    
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public IGVIR1001Form getIgvir1001Form() {
		return igvir1001Form;
	}

	
	public void setIgvir1001Form(IGVIR1001Form igvir1001Form) {
		this.igvir1001Form = igvir1001Form;
	}

	public List<IG500Info> getLstProcessRecord() {
		return lstProcessRecord;
	}

	public void setLstProcessRecord(List<IG500Info> lstProcessRecord) {
		this.lstProcessRecord = lstProcessRecord;
	}


	/**
	 * 用户到期资源数量取得
	 * @return userExpireCount 用户到期资源数量
	 */
	public Integer getUserExpireCount() {
		return userExpireCount;
	}


	/**
	 * 用户到期资源数量设定
	 * @param userExpireCount 用户到期资源数量
	 */
	public void setUserExpireCount(Integer userExpireCount) {
		this.userExpireCount = userExpireCount;
	}


	/**
	 * 用户资源总数量取得
	 * @return userCount 用户资源总数量
	 */
	public Integer getUserCount() {
		return userCount;
	}


	/**
	 * 用户资源总数量设定
	 * @param userCount 用户资源总数量
	 */
	public void setUserCount(Integer userCount) {
		this.userCount = userCount;
	}


	/**
	 * 部门到期资源数量取得
	 * @return orgExpireCount 部门到期资源数量
	 */
	public Integer getOrgExpireCount() {
		return orgExpireCount;
	}


	/**
	 * 部门到期资源数量设定
	 * @param orgExpireCount 部门到期资源数量
	 */
	public void setOrgExpireCount(Integer orgExpireCount) {
		this.orgExpireCount = orgExpireCount;
	}


	/**
	 * 部门资源总数量取得
	 * @return orgCount 部门资源总数量
	 */
	public Integer getOrgCount() {
		return orgCount;
	}


	/**
	 * 部门资源总数量设定
	 * @param orgCount 部门资源总数量
	 */
	public void setOrgCount(Integer orgCount) {
		this.orgCount = orgCount;
	}


	/**
	 * 资源概况信息取得
	 * @return resourceSurveyMap 资源概况信息
	 */
	public Map<String, Integer> getResourceSurveyMap() {
		return resourceSurveyMap;
	}


	/**
	 * 资源概况信息设定
	 * @param resourceSurveyMap 资源概况信息
	 */
	public void setResourceSurveyMap(Map<String, Integer> resourceSurveyMap) {
		this.resourceSurveyMap = resourceSurveyMap;
	}

	/**
	 * 部门资源使用情况获取
	 * @return
	 */
	public List<VIM03CountByOrgVWInfo> getOrgResList() {
		return orgResList;
	}


	/**
	 * 部门资源使用情况设定
	 * @param orgResList
	 */
	public void setOrgResList(List<VIM03CountByOrgVWInfo> orgResList) {
		this.orgResList = orgResList;
	}

	/**
	 * 部门即将到期资源情况获取
	 * @return
	 */
	public List<VIM03CountByOrgVWInfo> getOrgExpiryResList() {
		return orgExpiryResList;
	}

	/**
	 * 部门即将到期资源情况设定
	 * @param orgExpiryResList
	 */
	public void setOrgExpiryResList(List<VIM03CountByOrgVWInfo> orgExpiryResList) {
		this.orgExpiryResList = orgExpiryResList;
	}


	public Integer getUsercost() {
		return usercost;
	}


	public void setUsercost(Integer usercost) {
		this.usercost = usercost;
	}


	public Integer getOrgcost() {
		return orgcost;
	}


	public void setOrgcost(Integer orgcost) {
		this.orgcost = orgcost;
	}


	public Integer getTotalcost() {
		return totalcost;
	}


	public void setTotalcost(Integer totalcost) {
		this.totalcost = totalcost;
	}


	public List<ProcessInHandVWInfo> getPihList() {
		return pihList;
	}


	public void setPihList(List<ProcessInHandVWInfo> pihList) {
		this.pihList = pihList;
	}


	public List<Template> getTemplateList() {
		return templateList;
	}


	public void setTemplateList(List<Template> templateList) {
		this.templateList = templateList;
	}


	public List<VIM03Info> getOwnVMList() {
		return ownVMList;
	}


	public void setOwnVMList(List<VIM03Info> ownVMList) {
		this.ownVMList = ownVMList;
	}


	public List<Object[]> getMonthCountData() {
		return monthCountData;
	}


	public void setMonthCountData(List<Object[]> monthCountData) {
		this.monthCountData = monthCountData;
	}


    /**
     * 获取月份统计信息Json
     * @return 月份统计信息Json 
     */
    public String getMonthCountJson() {
        return monthCountJson;
    }


    /**
     * 设置月份统计信息Json
     * @param monthCountJson 月份统计信息Json
     */
    public void setMonthCountJson(String monthCountJson) {
        this.monthCountJson = monthCountJson;
    }


    /**
     * 获取月份信息Json
     * @return 月份信息Json 
     */
    public String getMonthJson() {
        return monthJson;
    }


    /**
     * 设置月份信息Json
     * @param monthJson 月份信息Json
     */
    public void setMonthJson(String monthJson) {
        this.monthJson = monthJson;
    }


	/**
	 * 虚拟化管理首页VO取得
	 * @return igvir10051VO 虚拟化管理首页VO
	 */
	public IGVIR10051VO getIgvir10051VO() {
		return igvir10051VO;
	}


	/**
	 * 虚拟化管理首页VO设定
	 * @param igvir10051VO 虚拟化管理首页VO
	 */
	public void setIgvir10051VO(IGVIR10051VO igvir10051vo) {
		igvir10051VO = igvir10051vo;
	}


	/**
	 * 我发起的流程信息取得
	 * @return myOpenProcessList 我发起的流程信息
	 */
	public List<IG677Info> getMyOpenProcessList() {
		return myOpenProcessList;
	}


	/**
	 * 我发起的流程信息设定
	 * @param myOpenProcessList 我发起的流程信息
	 */
	public void setMyOpenProcessList(List<IG677Info> myOpenProcessList) {
		this.myOpenProcessList = myOpenProcessList;
	}


	/**
	 * 虚机信息取得
	 * @return vmList 虚机信息
	 */
	public List<VMachine> getVmList() {
		return vmList;
	}


	/**
	 * 虚机信息设定
	 * @param vmList 虚机信息
	 */
	public void setVmList(List<VMachine> vmList) {
		this.vmList = vmList;
	}


	/**
	 * 虚机名称取得
	 * @return vmname 虚机名称
	 */
	public String getVmname() {
		return vmname;
	}


	/**
	 * 虚机名称设定
	 * @param vmname 虚机名称
	 */
	public void setVmname(String vmname) {
		this.vmname = vmname;
	}


	/**
	 * 虚机状态取得
	 * @return powerState 虚机状态
	 */
	public String getPowerState() {
		return powerState;
	}


	/**
	 * 虚机状态设定
	 * @param powerState 虚机状态
	 */
	public void setPowerState(String powerState) {
		this.powerState = powerState;
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
	 * 申请趋势统计Map取得
	 * @return vmReportMap 申请趋势统计Map
	 */
	public Map<String, Integer> getVmReportMap() {
		return vmReportMap;
	}


	/**
	 * 申请趋势统计Map设定
	 * @param vmReportMap 申请趋势统计Map
	 */
	public void setVmReportMap(Map<String, Integer> vmReportMap) {
		this.vmReportMap = vmReportMap;
	}


	/**
	 * 运维流程趋势Map取得
	 * @return prRecportMap 运维流程趋势Map
	 */
	public Map<String, Map<String, Integer>> getPrRecportMap() {
		return prRecportMap;
	}


	/**
	 * 运维流程趋势Map设定
	 * @param prRecportMap 运维流程趋势Map
	 */
	public void setPrRecportMap(Map<String, Map<String, Integer>> prRecportMap) {
		this.prRecportMap = prRecportMap;
	}


    /**
     * 获取vcenter主键
     * @return vcenter主键 
     */
    public Integer getVcid() {
        return vcid;
    }


    /**
     * 设置vcenter主键
     * @param vcid vcenter主键
     */
    public void setVcid(Integer vcid) {
        this.vcid = vcid;
    }
}


