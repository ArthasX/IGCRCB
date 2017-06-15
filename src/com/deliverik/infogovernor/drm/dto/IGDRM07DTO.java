/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.drm.dto;


import java.util.List;
import java.util.Map;

import com.deliverik.framework.asset.model.condition.IG688SearchCond;
import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.SOC0129Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserInfo;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.infogovernor.drm.form.IGDRM0701Form;
import com.deliverik.infogovernor.drm.form.IGDRM0702Form;
import com.deliverik.infogovernor.drm.form.IGDRM0710Form;

/**
 * 演练计划DTO
 *
 */
public class IGDRM07DTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	
	protected IGDRM0701Form igdrm0701Form;
	
	private List<IG333Info> iG333InfoList;
	protected IGDRM0702Form igdrm0702Form;
	
	protected IGDRM0710Form igdrm0710Form;
	
	protected  Map<String, List<SOC0129Info>>  soc0129InfoVWMap;
	
	protected List<SOC0118Info> soc0118InfoList;
	
	protected Map<String,Map<String,Object>> dataMap;

	/** 角色人员信息 */
	protected Map<String,List<UserInfo>> userRoleMap;
	/** 演练详细信息 */
	protected Map<String,Object> drillDetailMap;
	
	
	
	/**  
	 * 获取drillDetailMap  
	 * @return drillDetailMap 
	 */
	public Map<String, Object> getDrillDetailMap() {
		return drillDetailMap;
	}

	/**  
	 * 设置drillDetailMap  
	 * @param drillDetailMap
	 */
	
	public void setDrillDetailMap(Map<String, Object> drillDetailMap) {
		this.drillDetailMap = drillDetailMap;
	}

	protected String roleids;
	
    public String getRoleids() {
		return roleids;
	}

	public void setRoleids(String roleids) {
		this.roleids = roleids;
	}
	
	public Map<String, List<UserInfo>> getUserRoleMap() {
		return userRoleMap;
	}

	public void setUserRoleMap(Map<String, List<UserInfo>> userRoleMap) {
		this.userRoleMap = userRoleMap;
	}

	public Map<String, Map<String, Object>> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Map<String, Object>> dataMap) {
		this.dataMap = dataMap;
	}

	public List<SOC0118Info> getSoc0118InfoList() {
		return soc0118InfoList;
	}

	public void setSoc0118InfoList(List<SOC0118Info> soc0118InfoList) {
		this.soc0118InfoList = soc0118InfoList;
	}

	/**
	 * igdrm0702Form   取得
	 * @return igdrm0702Form igdrm0702Form
	 */
	public IGDRM0702Form getIgdrm0702Form() {
		return igdrm0702Form;
	}

	/**
	 * igdrm0702Form   设定
	 * @param igdrm0702Form igdrm0702Form
	 */
	public void setIgdrm0702Form(IGDRM0702Form igdrm0702Form) {
		this.igdrm0702Form = igdrm0702Form;
	}

	/**
	 * igdrm0701Form   取得
	 * @return igdrm0701Form igdrm0701Form
	 */
	public IGDRM0701Form getIgdrm0701Form() {
		return igdrm0701Form;
	}

	/**
	 * igdrm0701Form   设定
	 * @param igdrm0701Form igdrm0701Form
	 */
	public void setIgdrm0701Form(IGDRM0701Form igdrm0701Form) {
		this.igdrm0701Form = igdrm0701Form;
	}

	protected int maxSearchCount;
	
	protected String prtype;
	
	protected String prpdidLike;
	
	protected String prstatus;

	/**
	 * 流程类型(WD,WDP,WDC)   取得
	 * @return prtype prtype
	 */
	public String getPrtype() {
		return prtype;
	}

	/**
	 * 流程类型(WD,WDP,WDC)   设定
	 * @param prtype prtype
	 */
	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}

	/**
	 * 流程定义ID 前5位   取得
	 * @return prpdidLike prpdidLike
	 */
	public String getPrpdidLike() {
		return prpdidLike;
	}

	/**
	 * 流程定义ID 前5位   设定
	 * @param prpdidLike prpdidLike
	 */
	public void setPrpdidLike(String prpdidLike) {
		this.prpdidLike = prpdidLike;
	}

	/**
	 * 流程状态   取得
	 * @return prstatus prstatus
	 */
	public String getPrstatus() {
		return prstatus;
	}

	/**
	 * 流程状态   设定
	 * @param prstatus prstatus
	 */
	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}

	protected User user;
	
	/** 分页用DTO */
	protected PagingDTO pagingDto;
	
	/**演练方案定义阶段的流程*/
    protected List<IG500Info> ig500InfoList;
    /** 资产模型名称 */
	protected String ename;
	/** 资产模型层次码 */
	protected String esyscoding;
	/** 资产项信息检索条件 */
	protected SOC0124SearchCond soc0124SearchCond;
	protected SOC0124Info soc0124Info;
	
	
	/** 资产项信息检索条件 */
	protected IG688SearchCond entityItemVWSearchCond;
	/** 资产项检索结果 */
	protected List<SOC0124Info> soc0124List;
	/** special Plan专项预案eiid */
	protected String sp_eiid;
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	public List<IG500Info> getIg500InfoList() {
		return ig500InfoList;
	}

	public void setIg500InfoList(List<IG500Info> ig500InfoList) {
		this.ig500InfoList = ig500InfoList;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEsyscoding() {
		return esyscoding;
	}

	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	public SOC0124SearchCond getSoc0124SearchCond() {
		return soc0124SearchCond;
	}

	public void setSoc0124SearchCond(SOC0124SearchCond soc0124SearchCond) {
		this.soc0124SearchCond = soc0124SearchCond;
	}

	public IG688SearchCond getEntityItemVWSearchCond() {
		return entityItemVWSearchCond;
	}

	public void setEntityItemVWSearchCond(IG688SearchCond entityItemVWSearchCond) {
		this.entityItemVWSearchCond = entityItemVWSearchCond;
	}

	public List<SOC0124Info> getSoc0124List() {
		return soc0124List;
	}

	public void setSoc0124List(List<SOC0124Info> soc0124List) {
		this.soc0124List = soc0124List;
	}

	public String getSp_eiid() {
		return sp_eiid;
	}

	public void setSp_eiid(String sp_eiid) {
		this.sp_eiid = sp_eiid;
	}

	/**
	 * soc0124Info   取得
	 * @return soc0124Info soc0124Info
	 */
	public SOC0124Info getSoc0124Info() {
		return soc0124Info;
	}

	/**
	 * soc0124Info   设定
	 * @param soc0124Info soc0124Info
	 */
	public void setSoc0124Info(SOC0124Info soc0124Info) {
		this.soc0124Info = soc0124Info;
	}

	/**
	 * soc0129InfoVWMap   取得
	 * @return soc0129InfoVWMap soc0129InfoVWMap
	 */
	public Map<String, List<SOC0129Info>> getSoc0129InfoVWMap() {
		return soc0129InfoVWMap;
	}

	/**
	 * soc0129InfoVWMap   设定
	 * @param soc0129InfoVWMap soc0129InfoVWMap
	 */
	public void setSoc0129InfoVWMap(Map<String, List<SOC0129Info>> soc0129InfoVWMap) {
		this.soc0129InfoVWMap = soc0129InfoVWMap;
	}

	/**
	 * @return the iG333InfoList
	 */
	public List<IG333Info> getiG333InfoList() {
		return iG333InfoList;
	}

	/**
	 * @param iG333InfoList the iG333InfoList to set
	 */
	public void setiG333InfoList(List<IG333Info> iG333InfoList) {
		this.iG333InfoList = iG333InfoList;
	}

	/**  
	 * 获取igdrm0710Form  
	 * @return igdrm0710Form 
	 */
	public IGDRM0710Form getIgdrm0710Form() {
		return igdrm0710Form;
	}

	/**  
	 * 设置igdrm0710Form  
	 * @param igdrm0710Form
	 */
	
	public void setIgdrm0710Form(IGDRM0710Form igdrm0710Form) {
		this.igdrm0710Form = igdrm0710Form;
	}
    

}