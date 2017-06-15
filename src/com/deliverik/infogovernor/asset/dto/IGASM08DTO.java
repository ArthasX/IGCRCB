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
import com.deliverik.infogovernor.asset.form.IGASM0802Form;
import com.deliverik.infogovernor.asset.form.IGASM0804Form;
import com.deliverik.infogovernor.asset.form.IGASM0805Form;
import com.deliverik.infogovernor.asset.form.IGASM0806Form;
import com.deliverik.infogovernor.asset.form.IGASM0807Form;
import com.deliverik.infogovernor.asset.form.IGASM0812Form;

/**
 * 应用配置管理业务用DTO
 * 
 */
@SuppressWarnings("serial")
public class IGASM08DTO extends BaseDTO implements Serializable{

	/** 应用信息 */
	protected IGASM0802Form igasm0802Form;
	
	/** 应用信息检索条件 */
	protected SOC0124SearchCond entityItemVWSearchCond;
	
	/** 检索最大件数 */
	protected int maxSearchCount;

	/** 翻页用DTO */
	protected PagingDTO pagingDto;

	/** 应用检索结果 */
	protected List<SOC0124Info> entityItemVWInfoList;

	/** 应用删除对象 */
	protected String[] deleteEntityItem;

	/** 应用配置信息 */
	protected IGASM0804Form igasm0804Form;
	
	/** 应用配置信息检索结果 */
	protected List<SOC0129Info> configItemVWInfoList;

	/** 应用配置信息画面应用信息 */
	protected SOC0124Info entityItemVWInfo;

	/** 应用配置信息历史记录检索条件 */
	protected IGASM0805Form igasm0805Form;
	
	/** 应用配置信息历史记录检索结果 */
	protected List<SOC0107Info> configItemList;
	
	/** 应用关系管理检索条件 */
	protected IGASM0806Form igasm0806Form;
	
	/** 资产项关系管理信息检索结果1 */
	protected List<SOC0119Info> parEntityItemRelationList;
	
	/** 资产项关系管理信息检索结果2 */
	protected List<SOC0119Info> cldEntityItemRelationList;
	
	/** 应用关系编辑信息 */
	protected IGASM0807Form igasm0807Form;
	
	/** 应用关系编辑后信息 */
	protected SOC0119Info entityItemRelation;

	/** 应用关系删除对象 */
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
	/** 应用所属机构名称 */
	protected String eiorgname;
	protected IGASM0812Form igasm0812Form;
	
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
	
	
	public IGASM0812Form getIgasm0812Form() {
		return igasm0812Form;
	}

	public void setIgasm0812Form(IGASM0812Form igasm0812Form) {
		this.igasm0812Form = igasm0812Form;
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
	 * 应用信息取得
	 * @return 应用信息
	 */
	public IGASM0802Form getIgasm0802Form() {
		return igasm0802Form;
	}

	/**
	 * 应用信息设定
	 *
	 * @param igasm0802Form 应用信息
	 */
	public void setIgasm0802Form(IGASM0802Form igasm0802Form) {
		this.igasm0802Form = igasm0802Form;
	}

	/**
	 * 应用信息检索条件取得
	 * @return 应用信息检索条件
	 */
	public SOC0124SearchCond getEntityItemVWSearchCond() {
		return entityItemVWSearchCond;
	}

	/**
	 * 应用信息检索条件设定
	 *
	 * @param entityItemVWSearchCond 应用信息检索条件
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
	 * 应用检索结果取得
	 * @return 应用检索结果
	 */
	public List<SOC0124Info> getEntityItemVWInfoList() {
		return entityItemVWInfoList;
	}

	/**
	 * 应用检索结果设定
	 *
	 * @param entityItemVWInfoList 应用检索结果
	 */
	public void setEntityItemVWInfoList(List<SOC0124Info> entityItemVWInfoList) {
		this.entityItemVWInfoList = entityItemVWInfoList;
	}

	/**
	 * 应用删除对象取得
	 * @return 应用删除对象
	 */
	public String[] getDeleteEntityItem() {
		return deleteEntityItem;
	}

	/**
	 * 应用删除对象设定
	 *
	 * @param deleteEntityItem 应用删除对象
	 */
	public void setDeleteEntityItem(String[] deleteEntityItem) {
		this.deleteEntityItem = deleteEntityItem;
	}

	/**
	 * 应用配置信息取得
	 * @return 应用配置信息
	 */
	public IGASM0804Form getIgasm0804Form() {
		return igasm0804Form;
	}


	/**
	 * 应用配置信息检索条件设定
	 *
	 * @param igasm0804Form 应用配置信息检索条件
	 */
	public void setIgasm0804Form(IGASM0804Form igasm0804Form) {
		this.igasm0804Form = igasm0804Form;
	}

	/**
	 * 应用配置信息检索结果取得
	 * @return 应用配置信息检索结果
	 */
	public List<SOC0129Info> getConfigItemVWInfoList() {
		return configItemVWInfoList;
	}

	/**
	 * 应用配置信息检索结果设定
	 *
	 * @param configItemVWInfoList 应用配置信息检索结果
	 */
	public void setConfigItemVWInfoList(List<SOC0129Info> configItemVWInfoList) {
		this.configItemVWInfoList = configItemVWInfoList;
	}

	/**
	 * 应用配置信息画面应用信息取得
	 * @return 应用配置信息画面应用信息
	 */
	public SOC0124Info getEntityItemVWInfo() {
		return entityItemVWInfo;
	}

	/**
	 * 应用配置信息画面应用信息设定
	 *
	 * @param entityItemVWInfo 应用配置信息画面应用信息
	 */
	public void setEntityItemVWInfo(SOC0124Info entityItemVWInfo) {
		this.entityItemVWInfo = entityItemVWInfo;
	}

	/**
	 * 应用配置信息历史记录检索条件取得
	 * @return 应用配置信息历史记录检索条件
	 */
	public IGASM0805Form getIgasm0805Form() {
		return igasm0805Form;
	}

	/**
	 * 应用配置信息历史记录检索条件设定
	 *
	 * @param igasm0805Form 应用配置信息历史记录检索条件
	 */
	public void setIgasm0805Form(IGASM0805Form igasm0805Form) {
		this.igasm0805Form = igasm0805Form;
	}

	/**
	 * 应用配置信息历史记录检索结果取得
	 * @return 应用配置信息历史记录检索结果
	 */
	public List<SOC0107Info> getConfigItemList() {
		return configItemList;
	}

	/**
	 * 应用配置信息历史记录检索结果设定
	 *
	 * @param configItemList 应用配置信息历史记录检索结果
	 */
	public void setConfigItemList(List<SOC0107Info> configItemList) {
		this.configItemList = configItemList;
	}

	/**
	 * 应用关系管理检索条件取得
	 * @return 应用关系管理检索条件
	 */
	public IGASM0806Form getIgasm0806Form() {
		return igasm0806Form;
	}

	/**
	 * 应用关系管理检索条件设定
	 *
	 * @param igasm0806Form 应用关系管理检索条件
	 */
	public void setIgasm0806Form(IGASM0806Form igasm0806Form) {
		this.igasm0806Form = igasm0806Form;
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
	 * @param cldEntityItemRelationList 资产项关系管理信息检索结果
	 */
	public void setCldEntityItemRelationList(
			List<SOC0119Info> cldEntityItemRelationList) {
		this.cldEntityItemRelationList = cldEntityItemRelationList;
	}

	/**
	 * 应用关系编辑信息取得
	 * @return 编辑信息
	 */
	public IGASM0807Form getIgasm0807Form() {
		return igasm0807Form;
	}

	/**
	 * 应用关系编辑信息设定
	 *
	 * @param igasm0807Form 应用关系编辑信息
	 */
	public void setIgasm0807Form(IGASM0807Form igasm0807Form) {
		this.igasm0807Form = igasm0807Form;
	}

	/**
	 * 应用关系编辑后信息取得
	 * @return 应用关系编辑后信息
	 */
	public SOC0119Info getEntityItemRelation() {
		return entityItemRelation;
	}

	/**
	 * 应用关系编辑后信息设定
	 *
	 * @param entityItemRelation 应用关系编辑后信息
	 */
	public void setEntityItemRelation(SOC0119Info entityItemRelation) {
		this.entityItemRelation = entityItemRelation;
	}

	/**
	 * 应用关系删除对象取得
	 * @return 应用关系删除对象
	 */
	public String[] getDeleteEntityItemRelation() {
		return deleteEntityItemRelation;
	}

	/**
	 * 应用关系删除对象设定
	 *
	 * @param entityItemRelation 应用关系删除对象
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


