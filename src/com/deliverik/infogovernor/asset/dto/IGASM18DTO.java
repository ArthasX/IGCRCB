package com.deliverik.infogovernor.asset.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.soc.asset.model.SOC0119Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.SOC0128Info;
import com.deliverik.framework.soc.asset.model.SOC0129Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.asset.form.IGASM1802Form;
import com.deliverik.infogovernor.asset.form.IGASM1804Form;
import com.deliverik.infogovernor.asset.form.IGASM1805Form;
import com.deliverik.infogovernor.asset.form.IGASM1806Form;
import com.deliverik.infogovernor.asset.form.IGASM1807Form;
import com.deliverik.infogovernor.asset.form.IGASM1812Form;

/**
 * 系统配置管理业务用DTO
 * 
 */
@SuppressWarnings("serial")
public class IGASM18DTO extends BaseDTO implements Serializable{

	/** 系统信息 */
	protected IGASM1802Form igasm1802Form;
	
	/** 系统信息检索条件 */
	protected SOC0124SearchCond entityItemVWSearchCond;
	
	/** 检索最大件数 */
	protected int maxSearchCount;

	/** 翻页用DTO */
	protected PagingDTO pagingDto;

	/** 系统检索结果 */
	protected List<SOC0124Info> entityItemVWInfoList;

	/** 系统删除对象 */
	protected String[] deleteEntityItem;

	/** 系统配置信息 */
	protected IGASM1804Form igasm1804Form;
	
	/** 系统配置信息检索结果 */
	protected List<SOC0129Info> configItemVWInfoList;

	/** 系统配置信息画面系统信息 */
	protected SOC0124Info entityItemVWInfo;

	/** 系统配置信息历史记录检索条件 */
	protected IGASM1805Form igasm1805Form;
	
	/** 系统配置信息历史记录检索结果 */
	protected List<SOC0107Info> configItemList;
	
	/** 系统关系管理检索条件 */
	protected IGASM1806Form igasm1806Form;
	
	/** 资产项关系管理信息检索结果1 */
	protected List<SOC0119Info> parEntityItemRelationList;
	
	/** 资产项关系管理信息检索结果2 */
	protected List<SOC0119Info> cldEntityItemRelationList;
	
	/** 系统关系编辑信息 */
	protected IGASM1807Form igasm1807Form;
	
	/** 系统关系编辑后信息 */
	protected SOC0119Info entityItemRelation;

	/** 系统关系删除对象 */
	protected String[] deleteEntityItemRelation;
	
	/** 资产管理关系下拉列表 */
	protected List<LabelValueBean> relationList;
	
	/** 资产项配置信息检索结果 */
	protected Map<String,List<SOC0107Info>> configItemMap;
	
	/** 资产项配置信息检索结果 */
	protected Map<String,List<SOC0129Info>> configItemVWInfoMap;
	
	protected Map<String,List<SOC0119Info>> parEntityItemRelationMap;
	protected Map<String,List<SOC0119Info>> cldEntityItemRelationMap;
	protected int parCount;
	protected int cldCount;
	/** 系统所属机构名称 */
	protected String eiorgname;
	protected IGASM1812Form igasm1812Form;
	
	/** 用户对象 */
	private User user;
	
	/** 权限标识 */
	protected Boolean flag;
	
	/** 机构层次码 */
	protected String orgsyscoding;
	
	/** 机构名称 */
	protected String orgname;
	
	/** 模型层次码 */
	protected String esyscoding;
	
	/** 模型名称 */
	protected String ename;
	
	/** 资产版本列表 */
	protected List<SOC0128Info> configItemVersionTime;
	
	public String getOrgsyscoding() {
		return orgsyscoding;
	}

	public void setOrgsyscoding(String orgsyscoding) {
		this.orgsyscoding = orgsyscoding;
	}

	public String getOrgname() {
		return orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	public String getEsyscoding() {
		return esyscoding;
	}

	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}
	
	
	public IGASM1812Form getIgasm1812Form() {
		return igasm1812Form;
	}

	public void setIgasm1812Form(IGASM1812Form igasm1812Form) {
		this.igasm1812Form = igasm1812Form;
	}
	public String getEiorgname() {
		return eiorgname;
	}

	public void setEiorgname(String eiorgname) {
		this.eiorgname = eiorgname;
	}
	public Map<String, List<SOC0119Info>> getParEntityItemRelationMap() {
		return parEntityItemRelationMap;
	}

	public void setParEntityItemRelationMap(
			Map<String, List<SOC0119Info>> parEntityItemRelationMap) {
		this.parEntityItemRelationMap = parEntityItemRelationMap;
	}

	public Map<String, List<SOC0119Info>> getCldEntityItemRelationMap() {
		return cldEntityItemRelationMap;
	}

	public void setCldEntityItemRelationMap(
			Map<String, List<SOC0119Info>> cldEntityItemRelationMap) {
		this.cldEntityItemRelationMap = cldEntityItemRelationMap;
	}

	public int getParCount() {
		return parCount;
	}

	public void setParCount(int parCount) {
		this.parCount = parCount;
	}

	public int getCldCount() {
		return cldCount;
	}

	public void setCldCount(int cldCount) {
		this.cldCount = cldCount;
	}
	/**
	 * 系统信息取得
	 * @return 系统信息
	 */
	public IGASM1802Form getIgasm1802Form() {
		return igasm1802Form;
	}

	/**
	 * 系统信息设定
	 *
	 * @param igasm1802Form 系统信息
	 */
	public void setIgasm1802Form(IGASM1802Form igasm1802Form) {
		this.igasm1802Form = igasm1802Form;
	}

	/**
	 * 系统信息检索条件取得
	 * @return 系统信息检索条件
	 */
	public SOC0124SearchCond getEntityItemVWSearchCond() {
		return entityItemVWSearchCond;
	}

	/**
	 * 系统信息检索条件设定
	 *
	 * @param entityItemVWSearchCond 系统信息检索条件
	 */
	public void setEntityItemVWSearchCond(
			SOC0124SearchCond entityItemVWSearchCond) {
		this.entityItemVWSearchCond = entityItemVWSearchCond;
	}

	/**
	 * 检索最大件数取得
	 * @return 检索最大件数
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * 检索最大件数设定
	 *
	 * @param maxSearchCount 检索最大件数
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * 翻页用DTO取得
	 * @return 翻页用DTO
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * 翻页用DTO设定
	 *
	 * @param pagingDto 翻页用DTO
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * 系统检索结果取得
	 * @return 系统检索结果
	 */
	public List<SOC0124Info> getEntityItemVWInfoList() {
		return entityItemVWInfoList;
	}

	/**
	 * 系统检索结果设定
	 *
	 * @param entityItemVWInfoList 系统检索结果
	 */
	public void setEntityItemVWInfoList(List<SOC0124Info> entityItemVWInfoList) {
		this.entityItemVWInfoList = entityItemVWInfoList;
	}

	/**
	 * 系统删除对象取得
	 * @return 系统删除对象
	 */
	public String[] getDeleteEntityItem() {
		return deleteEntityItem;
	}

	/**
	 * 系统删除对象设定
	 *
	 * @param deleteEntityItem 系统删除对象
	 */
	public void setDeleteEntityItem(String[] deleteEntityItem) {
		this.deleteEntityItem = deleteEntityItem;
	}

	/**
	 * 系统配置信息取得
	 * @return 系统配置信息
	 */
	public IGASM1804Form getIgasm1804Form() {
		return igasm1804Form;
	}


	/**
	 * 系统配置信息检索条件设定
	 *
	 * @param igasm1804Form 系统配置信息检索条件
	 */
	public void setIgasm1804Form(IGASM1804Form igasm1804Form) {
		this.igasm1804Form = igasm1804Form;
	}

	/**
	 * 系统配置信息检索结果取得
	 * @return 系统配置信息检索结果
	 */
	public List<SOC0129Info> getConfigItemVWInfoList() {
		return configItemVWInfoList;
	}

	/**
	 * 系统配置信息检索结果设定
	 *
	 * @param configItemVWInfoList 系统配置信息检索结果
	 */
	public void setConfigItemVWInfoList(List<SOC0129Info> configItemVWInfoList) {
		this.configItemVWInfoList = configItemVWInfoList;
	}

	/**
	 * 系统配置信息画面系统信息取得
	 * @return 系统配置信息画面系统信息
	 */
	public SOC0124Info getEntityItemVWInfo() {
		return entityItemVWInfo;
	}

	/**
	 * 系统配置信息画面系统信息设定
	 *
	 * @param entityItemVWInfo 系统配置信息画面系统信息
	 */
	public void setEntityItemVWInfo(SOC0124Info entityItemVWInfo) {
		this.entityItemVWInfo = entityItemVWInfo;
	}

	/**
	 * 系统配置信息历史记录检索条件取得
	 * @return 系统配置信息历史记录检索条件
	 */
	public IGASM1805Form getIgasm1805Form() {
		return igasm1805Form;
	}

	/**
	 * 系统配置信息历史记录检索条件设定
	 *
	 * @param igasm1805Form 系统配置信息历史记录检索条件
	 */
	public void setIgasm1805Form(IGASM1805Form igasm1805Form) {
		this.igasm1805Form = igasm1805Form;
	}

	/**
	 * 系统配置信息历史记录检索结果取得
	 * @return 系统配置信息历史记录检索结果
	 */
	public List<SOC0107Info> getConfigItemList() {
		return configItemList;
	}

	/**
	 * 系统配置信息历史记录检索结果设定
	 *
	 * @param configItemList 系统配置信息历史记录检索结果
	 */
	public void setConfigItemList(List<SOC0107Info> configItemList) {
		this.configItemList = configItemList;
	}

	/**
	 * 系统关系管理检索条件取得
	 * @return 系统关系管理检索条件
	 */
	public IGASM1806Form getIgasm1806Form() {
		return igasm1806Form;
	}

	/**
	 * 系统关系管理检索条件设定
	 *
	 * @param igasm1806Form 系统关系管理检索条件
	 */
	public void setIgasm1806Form(IGASM1806Form igasm1806Form) {
		this.igasm1806Form = igasm1806Form;
	}

	/**
	 * 资产项关系管理信息检索结果1取得
	 * @return 资产项关系管理信息检索结果1
	 */
	public List<SOC0119Info> getParEntityItemRelationList() {
		return parEntityItemRelationList;
	}

	/**
	 * 资产项关系管理信息检索结果1设定
	 *
	 * @param parEntityItemRelationList 资产项关系管理信息检索结果1
	 */
	public void setParEntityItemRelationList(
			List<SOC0119Info> parEntityItemRelationList) {
		this.parEntityItemRelationList = parEntityItemRelationList;
	}

	/**
	 * 资产项关系管理信息检索结果2取得
	 * @return 资产项关系管理信息检索结果2
	 */
	public List<SOC0119Info> getCldEntityItemRelationList() {
		return cldEntityItemRelationList;
	}

	/**
	 * 资产项关系管理信息检索结果2设定
	 *
	 * @param cldEntityItemRelationList 资产项关系管理信息检索结果2
	 */
	public void setCldEntityItemRelationList(
			List<SOC0119Info> cldEntityItemRelationList) {
		this.cldEntityItemRelationList = cldEntityItemRelationList;
	}

	/**
	 * 系统关系编辑信息取得
	 * @return 编辑信息
	 */
	public IGASM1807Form getIgasm1807Form() {
		return igasm1807Form;
	}

	/**
	 * 系统关系编辑信息设定
	 *
	 * @param igasm1807Form 系统关系编辑信息
	 */
	public void setIgasm1807Form(IGASM1807Form igasm1807Form) {
		this.igasm1807Form = igasm1807Form;
	}

	/**
	 * 系统关系编辑后信息取得
	 * @return 系统关系编辑后信息
	 */
	public SOC0119Info getEntityItemRelation() {
		return entityItemRelation;
	}

	/**
	 * 系统关系编辑后信息设定
	 *
	 * @param entityItemRelation 系统关系编辑后信息
	 */
	public void setEntityItemRelation(SOC0119Info entityItemRelation) {
		this.entityItemRelation = entityItemRelation;
	}

	/**
	 * 系统关系删除对象取得
	 * @return 系统关系删除对象
	 */
	public String[] getDeleteEntityItemRelation() {
		return deleteEntityItemRelation;
	}

	/**
	 * 系统关系删除对象设定
	 *
	 * @param entityItemRelation 系统关系删除对象
	 */
	public void setDeleteEntityItemRelation(String[] deleteEntityItemRelation) {
		this.deleteEntityItemRelation = deleteEntityItemRelation;
	}
	
	/**
	 * 资产管理关系下拉列表取得
	 * @return 资产管理关系下拉列表
	 */
	public List<LabelValueBean> getRelationList() {
		return relationList;
	}
	
	/**
	 * 资产管理关系下拉列表设定
	 *
	 * @param username 资产管理关系下拉列表
	 */
	public void setRelationList(List<LabelValueBean> relationList) {
		this.relationList = relationList;
	}
	
	/**
	 * 资产项配置信息检索结果取得
	 * @return 资产项配置信息检索结果
	 */
	public Map<String, List<SOC0107Info>> getConfigItemMap() {
		return configItemMap;
	}
	/**
	 * 资产项配置信息检索结果设定
	 *
	 * @param configItemMap 资产项配置信息检索结果
	 */
	public void setConfigItemMap(
			Map<String, List<SOC0107Info>> configItemMap) {
		this.configItemMap = configItemMap;
	}
	
	/**
	 * 资产项配置信息检索结果取得
	 * @return 资产项配置信息检索结果
	 */
	public Map<String, List<SOC0129Info>> getConfigItemVWInfoMap() {
		return configItemVWInfoMap;
	}
	
	/**
	 * 资产项配置信息检索结果设定
	 *
	 * @param configItemVWInfoMap 资产项配置信息检索结果
	 */
	public void setConfigItemVWInfoMap(
			Map<String, List<SOC0129Info>> configItemVWInfoMap) {
		this.configItemVWInfoMap = configItemVWInfoMap;
	}

	/**
	 * 资产版本列表取得
	 * @return 资产版本列表
	 */
	public List<SOC0128Info> getConfigItemVersionTime() {
		return configItemVersionTime;
	}

	/**
	 * 资产版本列表设定
	 *
	 * @param configItemVersionTime 资产版本列表
	 */
	public void setConfigItemVersionTime(
			List<SOC0128Info> configItemVersionTime) {
		this.configItemVersionTime = configItemVersionTime;
	}
	
}


