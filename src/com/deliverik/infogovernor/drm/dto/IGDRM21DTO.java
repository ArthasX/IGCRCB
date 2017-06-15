package com.deliverik.infogovernor.drm.dto;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.SOC0118VWInfo;
import com.deliverik.framework.soc.asset.model.SOC0119Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.drm.model.PlanInfo;
import com.deliverik.infogovernor.drm.model.SOC0507Info;
import com.deliverik.infogovernor.drm.model.SOC0509Info;

/**
 * 概述: 功能描述: 创建记录: 修改记录:
 */
@SuppressWarnings("serial")
public class IGDRM21DTO extends BaseDTO {

	private Boolean flag;
	private String eiorgname;
	private SOC0124Info entityItemVWInfo;
	private User user;
	private List<SOC0509Info> planSectionTree;
	private int maxSearchCount;
	private PagingDTO pagingDto;
	private List<PlanInfo> planList;
	private String content;
	private SOC0507Info soc0507Info;
	private Integer ciid;
	private List<SOC0118VWInfo> entityItemVWInfoList;
	private List<SOC0118VWInfo> soc0118VWList;

	private List<SOC0119Info> soc0119List;
	private List<String> soc0119ListNames;
	
	private Map<String, SOC0509Info> treeMap;
	private String esyscoding;
	
	/** 响应对象 */
	protected HttpServletResponse response;

	/** 返回结果HTML格式 */
	private String resultHTML;

	private List<SOC0118Info> soc0118List;

	public String getResultHTML() {
		return resultHTML;
	}

	public void setResultHTML(String resultHTML) {
		this.resultHTML = resultHTML;
	}

	public List<SOC0118Info> getSoc0118List() {
		return soc0118List;
	}

	public void setSoc0118List(List<SOC0118Info> soc0118List) {
		this.soc0118List = soc0118List;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	public Boolean getFlag() {
		return flag;
	}

	public void setEiorgname(String eiorgname) {
		this.eiorgname = eiorgname;
	}

	public String getEiorgname() {
		return eiorgname;
	}

	public void setEntityItemVWInfo(SOC0124Info entityItemVWInfo) {
		this.entityItemVWInfo = entityItemVWInfo;
	}

	public SOC0124Info getEntityItemVWInfo() {
		return entityItemVWInfo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setPlanSectionTree(List<SOC0509Info> planSectionTree) {
		this.planSectionTree = planSectionTree;
	}

	public List<SOC0509Info> getPlanSectionTree() {
		return planSectionTree;
	}

	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	public void setPlanList(List<PlanInfo> planList) {
		this.planList = planList;
	}

	public List<PlanInfo> getPlanList() {
		return planList;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setSoc0507Info(SOC0507Info soc0507Info) {
		this.soc0507Info = soc0507Info;
	}

	public SOC0507Info getSoc0507Info() {
		return soc0507Info;
	}

	public void setCiid(Integer ciid) {
		this.ciid = ciid;
	}

	public Integer getCiid() {
		return ciid;
	}

	public void setEntityItemVWInfoList(List<SOC0118VWInfo> entityItemVWInfoList) {
		this.entityItemVWInfoList = entityItemVWInfoList;
	}

	public List<SOC0118VWInfo> getEntityItemVWInfoList() {
		return entityItemVWInfoList;
	}

	public List<SOC0119Info> getSoc0119List() {
		return soc0119List;
	}

	public void setSoc0119List(List<SOC0119Info> soc0119List) {
		this.soc0119List = soc0119List;
	}

	public List<String> getSoc0119ListNames() {
		return soc0119ListNames;
	}

	public void setSoc0119ListNames(List<String> soc0119ListNames) {
		this.soc0119ListNames = soc0119ListNames;
	}

	public List<SOC0118VWInfo> getSoc0118VWList() {
		return soc0118VWList;
	}

	public void setSoc0118VWList(List<SOC0118VWInfo> soc0118vwList) {
		soc0118VWList = soc0118vwList;
	}
	
	public void setTreeMap(Map<String, SOC0509Info> treeMap) {
		this.treeMap = treeMap;
	}

	public Map<String, SOC0509Info> getTreeMap() {
		return treeMap;
	}

	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * 响应对象取得
	 * @return response 响应对象
	 */
	public HttpServletResponse getResponse() {
		return response;
	}

	/**
	 * 响应对象设定
	 * @param response 响应对象
	 */
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

}
