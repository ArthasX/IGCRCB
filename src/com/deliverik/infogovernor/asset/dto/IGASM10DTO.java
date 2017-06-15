package com.deliverik.infogovernor.asset.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.asset.model.IG002Info;
import com.deliverik.framework.asset.model.IG313Info;
import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.asset.model.IG800Info;
import com.deliverik.framework.asset.model.IG887Info;
import com.deliverik.framework.asset.model.condition.IG688SearchCond;
import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.model.SOC0119Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.SOC0128Info;
import com.deliverik.framework.soc.asset.model.SOC0129Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.asset.form.IGASM1004Form;
import com.deliverik.infogovernor.asset.form.IGASM1005Form;
import com.deliverik.infogovernor.asset.form.IGASM1006Form;

/**
 * 资产配置管理业务用DTO
 * 
 */
@SuppressWarnings("serial")
public class IGASM10DTO extends BaseDTO implements Serializable{

	/** 资产项信息检索条件 */
	protected IG688SearchCond entityItemVWSearchCond;
	protected SOC0124SearchCond socEntityItemVWSearchCond;
	protected List<SOC0124Info> socEntityItemVWInfoList;
	protected SOC0124Info socEntityItemVWInfo;
	/** 资产项配置信息检索结果 */
	protected Map<String,List<SOC0129Info>> socConfigItemVWInfoMap;
	
	/** 检索最大件数 */
	protected int maxSearchCount;

	/** 翻页用DTO */
	protected PagingDTO pagingDto;

	/** 资产项检索结果 */
	protected List<IG688Info> entityItemVWInfoList;

	/** 资产项删除对象 */
	protected String[] deleteEntityItem;

	/** 资产项配置信息 */
	protected IGASM1004Form igasm1004Form;
	
	/** 资产项配置信息检索结果 */
	protected List<IG002Info> configItemVWInfoList;

	/** 资产项配置信息画面资产项信息 */
	protected IG688Info entityItemVWInfo;

	/** 资产项配置信息历史记录检索条件 */
	protected IGASM1005Form igasm1005Form;
	
	/** 资产项配置信息历史记录检索结果 */
	protected List<IG800Info> configItemList;
	
	/** 资产项关系管理检索条件 */
	protected IGASM1006Form igasm1006Form;
	
	/** 资产项关系管理信息检索结果1 */
	protected List<IG313Info> parEntityItemRelationList;
	/** soc资产项关系管理信息检索结果1 */
	protected List<SOC0119Info> socParEntityItemRelationList;
	
	/** 资产项关系管理信息检索结果2 */
	protected List<IG313Info> cldEntityItemRelationList;
	
	/** 资产项关系编辑后信息 */
	protected IG313Info entityItemRelation;
	
	/** 资产项配置信息检索结果 */
	protected Map<String,List<IG800Info>> configItemMap;

	/** 资产项关系删除对象 */
	protected String[] deleteEntityItemRelation;
	protected Map<String,List<IG313Info>> parEntityItemRelationMap;
	protected Map<String,List<SOC0119Info>> socParEntityItemRelationMap;
	protected Map<String,List<IG313Info>> cldEntityItemRelationMap;
	protected Map<String,List<SOC0119Info>> socCldEntityItemRelationMap;
	protected int parCount;
	protected int cldCount;
	
	/** 资产项配置信息检索结果 */
	protected Map<String,List<IG002Info>> configItemVWInfoMap;

	
	/** 用户对象 */
	private User user;
	
	/** 权限标识 */
	protected Boolean flag;
	
	/** 资产版本列表 */
	protected List<IG887Info> configItemVersionTime;
	/** 资产版本列表 */
	protected List<SOC0128Info> socConfigItemVersionTime;
	
	
	
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
	
	public Map<String, List<IG313Info>> getParEntityItemRelationMap() {
		return parEntityItemRelationMap;
	}

	public void setParEntityItemRelationMap(
			Map<String, List<IG313Info>> parEntityItemRelationMap) {
		this.parEntityItemRelationMap = parEntityItemRelationMap;
	}

	public Map<String, List<IG313Info>> getCldEntityItemRelationMap() {
		return cldEntityItemRelationMap;
	}

	public void setCldEntityItemRelationMap(
			Map<String, List<IG313Info>> cldEntityItemRelationMap) {
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
	 * 资产项信息检索条件取得
	 * @return 资产项信息检索条件
	 */
	public IG688SearchCond getEntityItemVWSearchCond() {
		return entityItemVWSearchCond;
	}

	/**
	 * 资产项信息检索条件设定
	 *
	 * @param entityItemVWSearchCond 资产项信息检索条件
	 */
	public void setEntityItemVWSearchCond(
			IG688SearchCond entityItemVWSearchCond) {
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
	 * 资产项检索结果取得
	 * @return 资产项检索结果
	 */
	public List<IG688Info> getEntityItemVWInfoList() {
		return entityItemVWInfoList;
	}

	/**
	 * 资产项检索结果设定
	 *
	 * @param entityItemVWInfoList 资产项检索结果
	 */
	public void setEntityItemVWInfoList(List<IG688Info> entityItemVWInfoList) {
		this.entityItemVWInfoList = entityItemVWInfoList;
	}

	/**
	 * 资产项删除对象取得
	 * @return 资产项删除对象
	 */
	public String[] getDeleteEntityItem() {
		return deleteEntityItem;
	}

	/**
	 * 资产项删除对象设定
	 *
	 * @param deleteEntityItem 资产项删除对象
	 */
	public void setDeleteEntityItem(String[] deleteEntityItem) {
		this.deleteEntityItem = deleteEntityItem;
	}

	/**
	 * 资产项配置信息取得
	 * @return 资产项配置信息
	 */
	public IGASM1004Form getIgasm1004Form() {
		return igasm1004Form;
	}


	/**
	 * 资产项配置信息检索条件设定
	 *
	 * @param igasm1004Form 资产项配置信息检索条件
	 */
	public void setIgasm1004Form(IGASM1004Form igasm1004Form) {
		this.igasm1004Form = igasm1004Form;
	}

	/**
	 * 资产项配置信息检索结果取得
	 * @return 资产项配置信息检索结果
	 */
	public List<IG002Info> getConfigItemVWInfoList() {
		return configItemVWInfoList;
	}

	/**
	 * 资产项配置信息检索结果设定
	 *
	 * @param configItemVWInfoList 资产项配置信息检索结果
	 */
	public void setConfigItemVWInfoList(List<IG002Info> configItemVWInfoList) {
		this.configItemVWInfoList = configItemVWInfoList;
	}

	/**
	 * 资产项配置信息画面资产项信息取得
	 * @return 资产项配置信息画面资产项信息
	 */
	public IG688Info getEntityItemVWInfo() {
		return entityItemVWInfo;
	}

	/**
	 * 资产项配置信息画面资产项信息设定
	 *
	 * @param entityItemVWInfo 资产项配置信息画面资产项信息
	 */
	public void setEntityItemVWInfo(IG688Info entityItemVWInfo) {
		this.entityItemVWInfo = entityItemVWInfo;
	}

	/**
	 * 资产项配置信息历史记录检索条件取得
	 * @return 资产项配置信息历史记录检索条件
	 */
	public IGASM1005Form getIgasm1005Form() {
		return igasm1005Form;
	}

	/**
	 * 资产项配置信息历史记录检索条件设定
	 *
	 * @param igasm1005Form 资产项配置信息历史记录检索条件
	 */
	public void setIgasm1005Form(IGASM1005Form igasm1005Form) {
		this.igasm1005Form = igasm1005Form;
	}

	/**
	 * 资产项配置信息历史记录检索结果取得
	 * @return 资产项配置信息历史记录检索结果
	 */
	public List<IG800Info> getConfigItemList() {
		return configItemList;
	}

	/**
	 * 资产项配置信息历史记录检索结果设定
	 *
	 * @param configItemList 资产项配置信息历史记录检索结果
	 */
	public void setConfigItemList(List<IG800Info> configItemList) {
		this.configItemList = configItemList;
	}

	/**
	 * 资产项关系管理检索条件取得
	 * @return 资产项关系管理检索条件
	 */
	public IGASM1006Form getIgasm1006Form() {
		return igasm1006Form;
	}

	/**
	 * 资产项关系管理检索条件设定
	 *
	 * @param igasm1006Form 资产项关系管理检索条件
	 */
	public void setIgasm1006Form(IGASM1006Form igasm1006Form) {
		this.igasm1006Form = igasm1006Form;
	}

	/**
	 * 资产项关系管理信息检索结果1取得
	 * @return 资产项关系管理信息检索结果1
	 */
	public List<IG313Info> getParEntityItemRelationList() {
		return parEntityItemRelationList;
	}

	/**
	 * 资产项关系管理信息检索结果1设定
	 *
	 * @param parEntityItemRelationList 资产项关系管理信息检索结果1
	 */
	public void setParEntityItemRelationList(
			List<IG313Info> parEntityItemRelationList) {
		this.parEntityItemRelationList = parEntityItemRelationList;
	}

	/**
	 * 资产项关系管理信息检索结果2取得
	 * @return 资产项关系管理信息检索结果2
	 */
	public List<IG313Info> getCldEntityItemRelationList() {
		return cldEntityItemRelationList;
	}

	/**
	 * 资产项关系管理信息检索结果2设定
	 *
	 * @param cldEntityItemRelationList 资产项关系管理信息检索结果2
	 */
	public void setCldEntityItemRelationList(
			List<IG313Info> cldEntityItemRelationList) {
		this.cldEntityItemRelationList = cldEntityItemRelationList;
	}

	/**
	 * 资产项关系编辑后信息取得
	 * @return 资产项关系编辑后信息
	 */
	public IG313Info getEntityItemRelation() {
		return entityItemRelation;
	}

	/**
	 * 资产项关系编辑后信息设定
	 *
	 * @param entityItemRelation 资产项关系编辑后信息
	 */
	public void setEntityItemRelation(IG313Info entityItemRelation) {
		this.entityItemRelation = entityItemRelation;
	}

	/**
	 * 资产项关系删除对象取得
	 * @return 资产项关系删除对象
	 */
	public String[] getDeleteEntityItemRelation() {
		return deleteEntityItemRelation;
	}

	/**
	 * 资产项关系删除对象设定
	 *
	 * @param entityItemRelation 资产项关系删除对象
	 */
	public void setDeleteEntityItemRelation(String[] deleteEntityItemRelation) {
		this.deleteEntityItemRelation = deleteEntityItemRelation;
	}
	
	/**
	 * 资产项配置信息检索结果取得
	 * @return 资产项配置信息检索结果
	 */
	public Map<String, List<IG800Info>> getConfigItemMap() {
		return configItemMap;
	}
	/**
	 * 资产项配置信息检索结果设定
	 *
	 * @param configItemMap 资产项配置信息检索结果
	 */
	public void setConfigItemMap(
			Map<String, List<IG800Info>> configItemMap) {
		this.configItemMap = configItemMap;
	}
	
	/**
	 * 资产项配置信息检索结果取得
	 * @return 资产项配置信息检索结果
	 */
	public Map<String, List<IG002Info>> getConfigItemVWInfoMap() {
		return configItemVWInfoMap;
	}
	/**
	 * 资产项配置信息检索结果设定
	 *
	 * @param configItemVWInfoMap 资产项配置信息检索结果
	 */
	public void setConfigItemVWInfoMap(
			Map<String, List<IG002Info>> configItemVWInfoMap) {
		this.configItemVWInfoMap = configItemVWInfoMap;
	}
	
	/**
	 * 资产版本列表取得
	 * @return 资产版本列表
	 */
	public List<IG887Info> getConfigItemVersionTime() {
		return configItemVersionTime;
	}
	
	

	public SOC0124Info getSocEntityItemVWInfo() {
		return socEntityItemVWInfo;
	}

	public void setSocEntityItemVWInfo(SOC0124Info socEntityItemVWInfo) {
		this.socEntityItemVWInfo = socEntityItemVWInfo;
	}

	/**
	 * 资产版本列表设定
	 *
	 * @param configItemVersionTime 资产版本列表
	 */
	public void setConfigItemVersionTime(
			List<IG887Info> configItemVersionTime) {
		this.configItemVersionTime = configItemVersionTime;
	}

	public SOC0124SearchCond getSocEntityItemVWSearchCond() {
		return socEntityItemVWSearchCond;
	}

	public void setSocEntityItemVWSearchCond(
			SOC0124SearchCond socEntityItemVWSearchCond) {
		this.socEntityItemVWSearchCond = socEntityItemVWSearchCond;
	}

	public List<SOC0124Info> getSocEntityItemVWInfoList() {
		return socEntityItemVWInfoList;
	}

	public void setSocEntityItemVWInfoList(List<SOC0124Info> socEntityItemVWInfoList) {
		this.socEntityItemVWInfoList = socEntityItemVWInfoList;
	}

	public Map<String, List<SOC0129Info>> getSocConfigItemVWInfoMap() {
		return socConfigItemVWInfoMap;
	}

	public void setSocConfigItemVWInfoMap(
			Map<String, List<SOC0129Info>> socConfigItemVWInfoMap) {
		this.socConfigItemVWInfoMap = socConfigItemVWInfoMap;
	}

	public List<SOC0119Info> getSocParEntityItemRelationList() {
		return socParEntityItemRelationList;
	}

	public void setSocParEntityItemRelationList(
			List<SOC0119Info> socParEntityItemRelationList) {
		this.socParEntityItemRelationList = socParEntityItemRelationList;
	}

	public Map<String, List<SOC0119Info>> getSocParEntityItemRelationMap() {
		return socParEntityItemRelationMap;
	}

	public void setSocParEntityItemRelationMap(
			Map<String, List<SOC0119Info>> socParEntityItemRelationMap) {
		this.socParEntityItemRelationMap = socParEntityItemRelationMap;
	}

	public Map<String, List<SOC0119Info>> getSocCldEntityItemRelationMap() {
		return socCldEntityItemRelationMap;
	}

	public void setSocCldEntityItemRelationMap(
			Map<String, List<SOC0119Info>> socCldEntityItemRelationMap) {
		this.socCldEntityItemRelationMap = socCldEntityItemRelationMap;
	}

	public List<SOC0128Info> getSocConfigItemVersionTime() {
		return socConfigItemVersionTime;
	}

	public void setSocConfigItemVersionTime(
			List<SOC0128Info> socConfigItemVersionTime) {
		this.socConfigItemVersionTime = socConfigItemVersionTime;
	}
	
	
	
	

}


