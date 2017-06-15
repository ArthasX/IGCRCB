package com.deliverik.infogovernor.asset.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.asset.model.IG800Info;
import com.deliverik.framework.asset.model.IG002Info;
import com.deliverik.framework.asset.model.IG887Info;
import com.deliverik.framework.asset.model.EiBelongRelationInfo;
import com.deliverik.framework.asset.model.IG313Info;
import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.asset.model.condition.IG688SearchCond;
import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.asset.form.IGASM0202Form;
import com.deliverik.infogovernor.asset.form.IGASM0204Form;
import com.deliverik.infogovernor.asset.form.IGASM0205Form;
import com.deliverik.infogovernor.asset.form.IGASM0206Form;
import com.deliverik.infogovernor.asset.form.IGASM0207Form;

/**
 * 资产配置管理业务用DTO
 * 
 */
@SuppressWarnings("serial")
public class IGASM02DTO extends BaseDTO implements Serializable{

	/** 资产项信息 */
	protected IGASM0202Form igasm0202Form;
	
	/** 资产项信息检索条件 */
	protected IG688SearchCond entityItemVWSearchCond;
	
	/** 检索最大件数 */
	protected int maxSearchCount;

	/** 翻页用DTO */
	protected PagingDTO pagingDto;

	/** 资产项检索结果 */
	protected List<IG688Info> entityItemVWInfoList;

	/** 资产项删除对象 */
	protected String[] deleteEntityItem;

	/** 资产项配置信息 */
	protected IGASM0204Form igasm0204Form;
	
	/** 资产项配置信息检索结果 */
	protected List<IG002Info> configItemVWInfoList;
	
	/** 资产项配置信息检索结果 */
	protected Map<String,List<IG002Info>> configItemVWInfoMap;
	
	/** 资产管理关系下拉列表 */
	protected List<LabelValueBean> relationList;

	/** 资产项配置信息画面资产项信息 */
	protected IG688Info entityItemVWInfo;

	/** 资产项配置信息历史记录检索条件 */
	protected IGASM0205Form igasm0205Form;
	
	/** 资产项配置信息历史记录检索结果 */
	protected List<IG800Info> configItemList;
	
	/** 资产项关系管理检索条件 */
	protected IGASM0206Form igasm0206Form;
	
	/** 资产项关系管理信息检索结果1 */
	protected List<IG313Info> parEntityItemRelationList;
	
	/** 资产项关系管理信息检索结果2 */
	protected List<IG313Info> cldEntityItemRelationList;
	
	/** 资产项关系编辑信息 */
	protected IGASM0207Form igasm0207Form;
	
	/** 资产项关系编辑后信息 */
	protected IG313Info entityItemRelation;

	/** 资产项关系删除对象 */
	protected String[] deleteEntityItemRelation;
	
	/** 资产项配置信息检索结果 */
	protected Map<String,List<IG800Info>> configItemMap;
	
	/** 用户对象 */
	private User user;
	
	/** 权限标识 */
	protected Boolean flag;
	
	/** 资产版本列表 */
	protected List<IG887Info> configItemVersionTime;
	/** 所属关系 */
	protected List<EiBelongRelationInfo> belongRelationList;
	
	public List<EiBelongRelationInfo> getBelongRelationList() {
		return belongRelationList;
	}

	public void setBelongRelationList(List<EiBelongRelationInfo> belongRelationList) {
		this.belongRelationList = belongRelationList;
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

	/**
	 * 资产项信息取得
	 * @return 资产项信息
	 */
	public IGASM0202Form getIgasm0202Form() {
		return igasm0202Form;
	}

	
	protected Map<String,List<IG313Info>> parEntityItemRelationMap;
	protected Map<String,List<IG313Info>> cldEntityItemRelationMap;
	protected int parCount;
	protected int cldCount;
	
	
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
	 * 资产项信息设定
	 *
	 * @param igasm0202Form 资产项信息
	 */
	public void setIgasm0202Form(IGASM0202Form igasm0202Form) {
		this.igasm0202Form = igasm0202Form;
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
	public IGASM0204Form getIgasm0204Form() {
		return igasm0204Form;
	}


	/**
	 * 资产项配置信息检索条件设定
	 *
	 * @param igasm0204Form 资产项配置信息检索条件
	 */
	public void setIgasm0204Form(IGASM0204Form igasm0204Form) {
		this.igasm0204Form = igasm0204Form;
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
	public IGASM0205Form getIgasm0205Form() {
		return igasm0205Form;
	}

	/**
	 * 资产项配置信息历史记录检索条件设定
	 *
	 * @param igasm0205Form 资产项配置信息历史记录检索条件
	 */
	public void setIgasm0205Form(IGASM0205Form igasm0205Form) {
		this.igasm0205Form = igasm0205Form;
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
	public IGASM0206Form getIgasm0206Form() {
		return igasm0206Form;
	}

	/**
	 * 资产项关系管理检索条件设定
	 *
	 * @param igasm0206Form 资产项关系管理检索条件
	 */
	public void setIgasm0206Form(IGASM0206Form igasm0206Form) {
		this.igasm0206Form = igasm0206Form;
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
	 * 资产项关系编辑信息取得
	 * @return 编辑信息
	 */
	public IGASM0207Form getIgasm0207Form() {
		return igasm0207Form;
	}

	/**
	 * 资产项关系编辑信息设定
	 *
	 * @param igasm0207Form 资产项关系编辑信息
	 */
	public void setIgasm0207Form(IGASM0207Form igasm0207Form) {
		this.igasm0207Form = igasm0207Form;
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
	 * 资产版本列表取得
	 * @return 资产版本列表
	 */
	public List<IG887Info> getConfigItemVersionTime() {
		return configItemVersionTime;
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

}


