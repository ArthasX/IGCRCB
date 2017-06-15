package com.deliverik.infogovernor.soc.vir.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.infogovernor.com.model.ProcessInHandVWInfo;
import com.deliverik.infogovernor.soc.vir.model.VIM03CountByOrgVWInfo;
import com.deliverik.infogovernor.soc.vir.model.VIM03Info;
import com.deliverik.infogovernor.soc.vir.vim.model.Template;
import com.google.gson.Gson;

/**
 * 首页	VO
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGVIR10011VO extends BaseVO implements Serializable{
	
	private List<IG500Info> lstProcessRecord ;
	
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
	
	/**待处理工作*/
	protected List<ProcessInHandVWInfo> pihList;
	
	
	/**部门资源使用情况*/
	private List<VIM03CountByOrgVWInfo> orgResList;
	
	/**部门即将到期资源情况*/
	private List<VIM03CountByOrgVWInfo> orgExpiryResList;
	
	/** 个人金额结算 */
	private Integer usercost;
	
	/** 部门金额结算 */
	private Integer orgcost;
	
	/** 总金额结算 */
	private Integer totalcost;
	
	/**跟人VM列表*/
	private List<VIM03Info> ownVMlist;

	/**模板集合*/
	private List<Template> templateList;
	
	/**月份统计信息*/
	private List<Object[]> monthCountData;
	
	/** 月份统计信息Json */
    protected String monthCountJson ;
    
    /** 月份信息Json */
    protected String monthJson ;
	
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
		
		Gson gson = new Gson();
		
		return orgExpiryResList;
	}

	/**
	 * 部门即将到期资源情况设定
	 * @param orgExpiryResList
	 */
	public void setOrgExpiryResList(List<VIM03CountByOrgVWInfo> orgExpiryResList) {
		this.orgExpiryResList = orgExpiryResList;
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

	public List<VIM03Info> getOwnVMlist() {
		return ownVMlist;
	}

	public void setOwnVMlist(List<VIM03Info> ownVMlist) {
		this.ownVMlist = ownVMlist;
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
	
	
}


