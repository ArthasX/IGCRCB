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
import com.deliverik.infogovernor.asset.form.IGASM0602Form;
import com.deliverik.infogovernor.asset.form.IGASM0604Form;
import com.deliverik.infogovernor.asset.form.IGASM0605Form;
import com.deliverik.infogovernor.asset.form.IGASM0606Form;
import com.deliverik.infogovernor.asset.form.IGASM0607Form;
import com.deliverik.infogovernor.asset.form.IGASM0612Form;

/**
 * 软件配置管理业务用DTO
 * 
 */
@SuppressWarnings("serial")
public class IGASM06DTO extends BaseDTO implements Serializable{

	/** 软件信息 */
	protected IGASM0602Form igasm0602Form;
	
	/** 软件信息检索条件 */
	protected SOC0124SearchCond entityItemVWSearchCond;
	
	/** 检索最大件数 */
	protected int maxSearchCount;

	/** 翻页用DTO */
	protected PagingDTO pagingDto;

	/** 软件检索结果 */
	protected List<SOC0124Info> entityItemVWInfoList;

	/** 软件删除对象 */
	protected String[] deleteEntityItem;

	/** 软件配置信息 */
	protected IGASM0604Form igasm0604Form;
	
	/** 软件配置信息检索结果 */
	protected List<SOC0129Info> configItemVWInfoList;

	/** 软件配置信息画面软件信息 */
	protected SOC0124Info entityItemVWInfo;

	/** 软件配置信息历史记录检索条件 */
	protected IGASM0605Form igasm0605Form;
	
	/** 软件配置信息历史记录检索结果 */
	protected List<SOC0107Info> configItemList;
	
	/** 软件关系管理检索条件 */
	protected IGASM0606Form igasm0606Form;
	
	/** 资产项关系管理信息检索结果1 */
	protected List<SOC0119Info> parEntityItemRelationList;
	
	/** 资产项关系管理信息检索结果2 */
	protected List<SOC0119Info> cldEntityItemRelationList;
	
	/** 软件关系编辑信息 */
	protected IGASM0607Form igasm0607Form;
	
	/** 软件关系编辑后信息 */
	protected SOC0119Info entityItemRelation;

	/** 软件关系删除对象 */
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
	
	/** 软件所属机构名称 */
	protected String eiorgname;
	/** 软件信息修改 */
	protected IGASM0612Form igasm0612Form;
	
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
	
	
	public IGASM0612Form getIgasm0612Form() {
		return igasm0612Form;
	}

	public void setIgasm0612Form(IGASM0612Form igasm0612Form) {
		this.igasm0612Form = igasm0612Form;
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
	 * 软件信息取得
	 * @return 软件信息
	 */
	public IGASM0602Form getIgasm0602Form() {
		return igasm0602Form;
	}

	/**
	 * 软件信息设定
	 *
	 * @param igasm0602Form 软件信息
	 */
	public void setIgasm0602Form(IGASM0602Form igasm0602Form) {
		this.igasm0602Form = igasm0602Form;
	}

	/**
	 * 软件信息检索条件取得
	 * @return 软件信息检索条件
	 */
	public SOC0124SearchCond getEntityItemVWSearchCond() {
		return entityItemVWSearchCond;
	}

	/**
	 * 软件信息检索条件设定
	 *
	 * @param entityItemVWSearchCond 软件信息检索条件
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
	 * 软件检索结果取得
	 * @return 软件检索结果
	 */
	public List<SOC0124Info> getEntityItemVWInfoList() {
		return entityItemVWInfoList;
	}

	/**
	 * 软件检索结果设定
	 *
	 * @param entityItemVWInfoList 软件检索结果
	 */
	public void setEntityItemVWInfoList(List<SOC0124Info> entityItemVWInfoList) {
		this.entityItemVWInfoList = entityItemVWInfoList;
	}

	/**
	 * 软件删除对象取得
	 * @return 软件删除对象
	 */
	public String[] getDeleteEntityItem() {
		return deleteEntityItem;
	}

	/**
	 * 软件删除对象设定
	 *
	 * @param deleteEntityItem 软件删除对象
	 */
	public void setDeleteEntityItem(String[] deleteEntityItem) {
		this.deleteEntityItem = deleteEntityItem;
	}

	/**
	 * 软件配置信息取得
	 * @return 软件配置信息
	 */
	public IGASM0604Form getIgasm0604Form() {
		return igasm0604Form;
	}


	/**
	 * 软件配置信息检索条件设定
	 *
	 * @param igasm0604Form 软件配置信息检索条件
	 */
	public void setIgasm0604Form(IGASM0604Form igasm0604Form) {
		this.igasm0604Form = igasm0604Form;
	}

	/**
	 * 软件配置信息检索结果取得
	 * @return 软件配置信息检索结果
	 */
	public List<SOC0129Info> getConfigItemVWInfoList() {
		return configItemVWInfoList;
	}

	/**
	 * 软件配置信息检索结果设定
	 *
	 * @param configItemVWInfoList 软件配置信息检索结果
	 */
	public void setConfigItemVWInfoList(List<SOC0129Info> configItemVWInfoList) {
		this.configItemVWInfoList = configItemVWInfoList;
	}

	/**
	 * 软件配置信息画面软件信息取得
	 * @return 软件配置信息画面软件信息
	 */
	public SOC0124Info getEntityItemVWInfo() {
		return entityItemVWInfo;
	}

	/**
	 * 软件配置信息画面软件信息设定
	 *
	 * @param entityItemVWInfo 软件配置信息画面软件信息
	 */
	public void setEntityItemVWInfo(SOC0124Info entityItemVWInfo) {
		this.entityItemVWInfo = entityItemVWInfo;
	}

	/**
	 * 软件配置信息历史记录检索条件取得
	 * @return 软件配置信息历史记录检索条件
	 */
	public IGASM0605Form getIgasm0605Form() {
		return igasm0605Form;
	}

	/**
	 * 软件配置信息历史记录检索条件设定
	 *
	 * @param igasm0605Form 软件配置信息历史记录检索条件
	 */
	public void setIgasm0605Form(IGASM0605Form igasm0605Form) {
		this.igasm0605Form = igasm0605Form;
	}

	/**
	 * 软件配置信息历史记录检索结果取得
	 * @return 软件配置信息历史记录检索结果
	 */
	public List<SOC0107Info> getConfigItemList() {
		return configItemList;
	}

	/**
	 * 软件配置信息历史记录检索结果设定
	 *
	 * @param configItemList 软件配置信息历史记录检索结果
	 */
	public void setConfigItemList(List<SOC0107Info> configItemList) {
		this.configItemList = configItemList;
	}

	/**
	 * 软件关系管理检索条件取得
	 * @return 软件关系管理检索条件
	 */
	public IGASM0606Form getIgasm0606Form() {
		return igasm0606Form;
	}

	/**
	 * 软件关系管理检索条件设定
	 *
	 * @param igasm0606Form 软件关系管理检索条件
	 */
	public void setIgasm0606Form(IGASM0606Form igasm0606Form) {
		this.igasm0606Form = igasm0606Form;
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
	 * 软件关系编辑信息取得
	 * @return 编辑信息
	 */
	public IGASM0607Form getIgasm0607Form() {
		return igasm0607Form;
	}

	/**
	 * 软件关系编辑信息设定
	 *
	 * @param igasm0607Form 软件关系编辑信息
	 */
	public void setIgasm0607Form(IGASM0607Form igasm0607Form) {
		this.igasm0607Form = igasm0607Form;
	}

	/**
	 * 软件关系编辑后信息取得
	 * @return 软件关系编辑后信息
	 */
	public SOC0119Info getEntityItemRelation() {
		return entityItemRelation;
	}

	/**
	 * 软件关系编辑后信息设定
	 *
	 * @param entityItemRelation 软件关系编辑后信息
	 */
	public void setEntityItemRelation(SOC0119Info entityItemRelation) {
		this.entityItemRelation = entityItemRelation;
	}

	/**
	 * 软件关系删除对象取得
	 * @return 软件关系删除对象
	 */
	public String[] getDeleteEntityItemRelation() {
		return deleteEntityItemRelation;
	}

	/**
	 * 软件关系删除对象设定
	 *
	 * @param entityItemRelation 软件关系删除对象
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


