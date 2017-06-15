package com.deliverik.infogovernor.asset.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.asset.model.IG800Info;
import com.deliverik.framework.asset.model.IG002Info;
import com.deliverik.framework.asset.model.IG887Info;
import com.deliverik.framework.asset.model.IG313Info;
import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.asset.model.condition.IG688SearchCond;
import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.asset.form.IGASM1702Form;
import com.deliverik.infogovernor.asset.form.IGASM1704Form;
import com.deliverik.infogovernor.asset.form.IGASM1705Form;
import com.deliverik.infogovernor.asset.form.IGASM1706Form;
import com.deliverik.infogovernor.asset.form.IGASM1707Form;
import com.deliverik.infogovernor.asset.form.IGASM1712Form;

/**
 * 组件配置管理业务用DTO
 * 
 */
@SuppressWarnings("serial")
public class IGASM17DTO extends BaseDTO implements Serializable{

	/** 组件信息 */
	protected IGASM1702Form igasm1702Form;
	
	/** 组件信息检索条件 */
	protected IG688SearchCond entityItemVWSearchCond;
	
	/** 检索最大件数 */
	protected int maxSearchCount;

	/** 翻页用DTO */
	protected PagingDTO pagingDto;

	/** 组件检索结果 */
	protected List<IG688Info> entityItemVWInfoList;

	/** 组件删除对象 */
	protected String[] deleteEntityItem;

	/** 组件配置信息 */
	protected IGASM1704Form igasm1704Form;
	
	/** 组件配置信息检索结果 */
	protected List<IG002Info> configItemVWInfoList;

	/** 组件配置信息画面组件信息 */
	protected IG688Info entityItemVWInfo;

	/** 组件配置信息历史记录检索条件 */
	protected IGASM1705Form igasm1705Form;
	
	/** 组件配置信息历史记录检索结果 */
	protected List<IG800Info> configItemList;
	
	/** 组件关系管理检索条件 */
	protected IGASM1706Form igasm1706Form;
	
	/** 资产项关系管理信息检索结果1 */
	protected List<IG313Info> parEntityItemRelationList;
	
	/** 资产项关系管理信息检索结果2 */
	protected List<IG313Info> cldEntityItemRelationList;
	
	/** 组件关系编辑信息 */
	protected IGASM1707Form igasm1707Form;
	
	/** 组件关系编辑后信息 */
	protected IG313Info entityItemRelation;
	
	/** 资产管理关系下拉列表 */
	protected List<LabelValueBean> relationList;

	/** 组件关系删除对象 */
	protected String[] deleteEntityItemRelation;
	
	/** 资产项配置信息检索结果 */
	protected Map<String,List<IG002Info>> configItemVWInfoMap;
	
	protected Map<String,List<IG313Info>> parEntityItemRelationMap;
	protected Map<String,List<IG313Info>> cldEntityItemRelationMap;
	protected int parCount;
	protected int cldCount;
	
	/** 资产版本列表 */
	protected List<IG887Info> configItemVersionTime;
	
	/** 资产项配置信息检索结果 */
	protected Map<String,List<IG800Info>> configItemMap;
	/** 软件信息修改 */
	protected IGASM1712Form igasm1712Form;
	
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
	
	
	public IGASM1712Form getIgasm1712Form() {
		return igasm1712Form;
	}

	public void setIgasm1712Form(IGASM1712Form igasm1712Form) {
		this.igasm1712Form = igasm1712Form;
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
	 * 组件信息取得
	 * @return 组件信息
	 */
	public IGASM1702Form getIgasm1702Form() {
		return igasm1702Form;
	}

	/**
	 * 组件信息设定
	 *
	 * @param igasm1702Form 组件信息
	 */
	public void setIgasm1702Form(IGASM1702Form igasm1702Form) {
		this.igasm1702Form = igasm1702Form;
	}

	/**
	 * 组件信息检索条件取得
	 * @return 组件信息检索条件
	 */
	public IG688SearchCond getEntityItemVWSearchCond() {
		return entityItemVWSearchCond;
	}

	/**
	 * 组件信息检索条件设定
	 *
	 * @param entityItemVWSearchCond 组件信息检索条件
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
	 * 组件检索结果取得
	 * @return 组件检索结果
	 */
	public List<IG688Info> getEntityItemVWInfoList() {
		return entityItemVWInfoList;
	}

	/**
	 * 组件检索结果设定
	 *
	 * @param entityItemVWInfoList 组件检索结果
	 */
	public void setEntityItemVWInfoList(List<IG688Info> entityItemVWInfoList) {
		this.entityItemVWInfoList = entityItemVWInfoList;
	}

	/**
	 * 组件删除对象取得
	 * @return 组件删除对象
	 */
	public String[] getDeleteEntityItem() {
		return deleteEntityItem;
	}

	/**
	 * 组件删除对象设定
	 *
	 * @param deleteEntityItem 组件删除对象
	 */
	public void setDeleteEntityItem(String[] deleteEntityItem) {
		this.deleteEntityItem = deleteEntityItem;
	}

	/**
	 * 组件配置信息取得
	 * @return 组件配置信息
	 */
	public IGASM1704Form getIgasm1704Form() {
		return igasm1704Form;
	}


	/**
	 * 组件配置信息检索条件设定
	 *
	 * @param igasm1704Form 组件配置信息检索条件
	 */
	public void setIgasm1704Form(IGASM1704Form igasm1704Form) {
		this.igasm1704Form = igasm1704Form;
	}

	/**
	 * 组件配置信息检索结果取得
	 * @return 组件配置信息检索结果
	 */
	public List<IG002Info> getConfigItemVWInfoList() {
		return configItemVWInfoList;
	}

	/**
	 * 组件配置信息检索结果设定
	 *
	 * @param configItemVWInfoList 组件配置信息检索结果
	 */
	public void setConfigItemVWInfoList(List<IG002Info> configItemVWInfoList) {
		this.configItemVWInfoList = configItemVWInfoList;
	}

	/**
	 * 组件配置信息画面组件信息取得
	 * @return 组件配置信息画面组件信息
	 */
	public IG688Info getEntityItemVWInfo() {
		return entityItemVWInfo;
	}

	/**
	 * 组件配置信息画面组件信息设定
	 *
	 * @param entityItemVWInfo 组件配置信息画面组件信息
	 */
	public void setEntityItemVWInfo(IG688Info entityItemVWInfo) {
		this.entityItemVWInfo = entityItemVWInfo;
	}

	/**
	 * 组件配置信息历史记录检索条件取得
	 * @return 组件配置信息历史记录检索条件
	 */
	public IGASM1705Form getIgasm1705Form() {
		return igasm1705Form;
	}

	/**
	 * 组件配置信息历史记录检索条件设定
	 *
	 * @param igasm1705Form 组件配置信息历史记录检索条件
	 */
	public void setIgasm1705Form(IGASM1705Form igasm1705Form) {
		this.igasm1705Form = igasm1705Form;
	}

	/**
	 * 组件配置信息历史记录检索结果取得
	 * @return 组件配置信息历史记录检索结果
	 */
	public List<IG800Info> getConfigItemList() {
		return configItemList;
	}

	/**
	 * 组件配置信息历史记录检索结果设定
	 *
	 * @param configItemList 组件配置信息历史记录检索结果
	 */
	public void setConfigItemList(List<IG800Info> configItemList) {
		this.configItemList = configItemList;
	}

	/**
	 * 组件关系管理检索条件取得
	 * @return 组件关系管理检索条件
	 */
	public IGASM1706Form getIgasm1706Form() {
		return igasm1706Form;
	}

	/**
	 * 组件关系管理检索条件设定
	 *
	 * @param igasm1706Form 组件关系管理检索条件
	 */
	public void setIgasm1706Form(IGASM1706Form igasm1706Form) {
		this.igasm1706Form = igasm1706Form;
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
	 * 组件关系编辑信息取得
	 * @return 编辑信息
	 */
	public IGASM1707Form getIgasm1707Form() {
		return igasm1707Form;
	}

	/**
	 * 组件关系编辑信息设定
	 *
	 * @param igasm1707Form 组件关系编辑信息
	 */
	public void setIgasm1707Form(IGASM1707Form igasm1707Form) {
		this.igasm1707Form = igasm1707Form;
	}

	/**
	 * 组件关系编辑后信息取得
	 * @return 组件关系编辑后信息
	 */
	public IG313Info getEntityItemRelation() {
		return entityItemRelation;
	}

	/**
	 * 组件关系编辑后信息设定
	 *
	 * @param entityItemRelation 组件关系编辑后信息
	 */
	public void setEntityItemRelation(IG313Info entityItemRelation) {
		this.entityItemRelation = entityItemRelation;
	}

	/**
	 * 组件关系删除对象取得
	 * @return 组件关系删除对象
	 */
	public String[] getDeleteEntityItemRelation() {
		return deleteEntityItemRelation;
	}

	/**
	 * 组件关系删除对象设定
	 *
	 * @param entityItemRelation 组件关系删除对象
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


