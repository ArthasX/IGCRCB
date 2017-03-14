package com.deliverik.infogovernor.soc.cim.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.asset.model.IG002Info;
import com.deliverik.framework.asset.model.IG013Info;
import com.deliverik.framework.asset.model.IG887Info;
import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.soc.asset.model.SOC0119Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.SOC0129Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0107SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.soc.cim.form.IGCIM1402Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM1404Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM1405Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM1406Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM1407Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM1412Form;

/**
 * 人员配置管理业务用DTO
 * 
 */
@SuppressWarnings("serial")
public class IGCIM14DTO extends BaseDTO implements Serializable{

	protected SOC0107SearchCond configItemSearchCond;

	/** 人员信息 */
	protected IGCIM1402Form igcim1402Form;
	
	/** 人员信息检索条件 */
	protected SOC0124SearchCond entityItemVWSearchCond;
	
	/** 检索最大件数 */
	protected int maxSearchCount;

	/** 翻页用DTO */
	protected PagingDTO pagingDto;

	/** 人员检索结果 */
	protected List<SOC0124Info> entityItemVWInfoList;

	/** 人员删除对象 */
	protected String[] deleteEntityItem;

	/** 人员配置信息 */
	protected IGCIM1404Form igcim1404Form;
	
	/** 人员配置信息检索结果 */
	protected List<IG002Info> configItemVWInfoList;

	/** 人员配置信息画面人员信息 */
	protected SOC0124Info entityItemVWInfo;

	/** 人员配置信息历史记录检索条件 */
	protected IGCIM1405Form igcim1405Form;
	
	/** 人员配置信息历史记录检索结果 */
	protected List<SOC0107Info> configItemList;
	
	/** 人员关系管理检索条件 */
	protected IGCIM1406Form igcim1406Form;
	
	/** 资产项关系管理信息检索结果1 */
	protected List<SOC0119Info> parEntityItemRelationList;
	
	/** 资产项关系管理信息检索结果2 */
	protected List<SOC0119Info> cldEntityItemRelationList;
	
	/** 人员关系编辑信息 */
	protected IGCIM1407Form igcim1407Form;
	
	/** 人员关系编辑后信息 */
	protected SOC0119Info entityItemRelation;

	/** 人员关系删除对象 */
	protected String[] deleteEntityItemRelation;
	
	/** 资产项配置信息检索结果 */
	protected Map<String,List<SOC0129Info>> configItemVWInfoMap;
	
	/** 资产项配置信息检索结果 */
	protected Map<String,List<SOC0107Info>> configItemMap;
	
	/**操作人id*/
	protected String userid;
	
	/**操作人姓名*/
	protected String username;
	
	/** 资产管理关系下拉列表 */
	protected List<LabelValueBean> relationList;
	
	protected String reciveUser;
	protected Map<String,List<SOC0119Info>> parEntityItemRelationMap;
	protected Map<String,List<SOC0119Info>> cldEntityItemRelationMap;
	protected int parCount;
	protected int cldCount;
	
	/** 人员所属机构名称 */
	protected String eiorgname;
	/** 人员信息修改 */
	protected IGCIM1412Form igcim1412Form;
	
	/** 用户对象 */
	private User user;
	
	/** 权限标识 */
	protected Boolean flag;
	
	/** 机构层次码 */
	protected String orgsyscoding;
	
	/** 模型层次码 */
	protected String esyscoding;
	
	/** 模型名称 */
	protected String ename;
	
	/** 资产版本列表 */
	protected List<IG887Info> configItemVersionTime;
	
	public String getOrgsyscoding() {
		return orgsyscoding;
	}

	public void setOrgsyscoding(String orgsyscoding) {
		this.orgsyscoding = orgsyscoding;
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
	public String getReciveUser() {
		return reciveUser;
	}

	public void setReciveUser(String reciveUser) {
		this.reciveUser = reciveUser;
	}
	
	/** 人员所属机构id */
	protected String orgid;
	
	/** 人员所属机构name */
	protected String orgname;
	
	/** 人员下发时间 */
	protected String issuetime;
	
	/** 人员领用人 */
	protected String recivename;
	
	/** 人员当前版本号 */
	protected String eiversion;
	
	public String getOrgname() {
		return orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	public String getIssuetime() {
		return issuetime;
	}

	public void setIssuetime(String issuetime) {
		this.issuetime = issuetime;
	}

	public String getRecivename() {
		return recivename;
	}

	public void setRecivename(String recivename) {
		this.recivename = recivename;
	}

	public String getEiversion() {
		return eiversion;
	}

	public void setEiversion(String eiversion) {
		this.eiversion = eiversion;
	}

	public String getOrgid() {
		return orgid;
	}

	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}
	
	/** 人员信息画面人员信息 */
	protected IG013Info entityItem;
	
	public IG013Info getEntityItem() {
		return entityItem;
	}

	public void setEntityItem(IG013Info entityItem) {
		this.entityItem = entityItem;
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
	 * 人员删除对象取得
	 * @return 人员删除对象
	 */
	public String[] getDeleteEntityItem() {
		return deleteEntityItem;
	}

	/**
	 * 人员删除对象设定
	 *
	 * @param deleteEntityItem 人员删除对象
	 */
	public void setDeleteEntityItem(String[] deleteEntityItem) {
		this.deleteEntityItem = deleteEntityItem;
	}


	/**
	 * 人员配置信息检索结果取得
	 * @return 人员配置信息检索结果
	 */
	public List<IG002Info> getConfigItemVWInfoList() {
		return configItemVWInfoList;
	}

	/**
	 * 人员配置信息检索结果设定
	 *
	 * @param configItemVWInfoList 人员配置信息检索结果
	 */
	public void setConfigItemVWInfoList(List<IG002Info> configItemVWInfoList) {
		this.configItemVWInfoList = configItemVWInfoList;
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
	 * 人员关系编辑后信息取得
	 * @return 人员关系编辑后信息
	 */
	public SOC0119Info getEntityItemRelation() {
		return entityItemRelation;
	}

	/**
	 * 人员关系编辑后信息设定
	 *
	 * @param entityItemRelation 人员关系编辑后信息
	 */
	public void setEntityItemRelation(SOC0119Info entityItemRelation) {
		this.entityItemRelation = entityItemRelation;
	}

	/**
	 * 人员关系删除对象取得
	 * @return 人员关系删除对象
	 */
	public String[] getDeleteEntityItemRelation() {
		return deleteEntityItemRelation;
	}

	/**
	 * 人员关系删除对象设定
	 *
	 * @param entityItemRelation 人员关系删除对象
	 */
	public void setDeleteEntityItemRelation(String[] deleteEntityItemRelation) {
		this.deleteEntityItemRelation = deleteEntityItemRelation;
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
	 * 操作人id取得
	 * @return 操作人id
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * 操作人id设定
	 *
	 * @param userid 操作人id
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * 操作人姓名取得
	 * @return 操作人姓名
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 操作人姓名设定
	 *
	 * @param username 操作人姓名
	 */
	public void setUsername(String username) {
		this.username = username;
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

	public SOC0107SearchCond getConfigItemSearchCond() {
		return configItemSearchCond;
	}

	public void setConfigItemSearchCond(SOC0107SearchCond configItemSearchCond) {
		this.configItemSearchCond = configItemSearchCond;
	}

	public SOC0124SearchCond getEntityItemVWSearchCond() {
		return entityItemVWSearchCond;
	}

	public void setEntityItemVWSearchCond(SOC0124SearchCond entityItemVWSearchCond) {
		this.entityItemVWSearchCond = entityItemVWSearchCond;
	}

	public List<SOC0124Info> getEntityItemVWInfoList() {
		return entityItemVWInfoList;
	}

	public void setEntityItemVWInfoList(List<SOC0124Info> entityItemVWInfoList) {
		this.entityItemVWInfoList = entityItemVWInfoList;
	}

	public IGCIM1402Form getIgcim1402Form() {
		return igcim1402Form;
	}

	public void setIgcim1402Form(IGCIM1402Form igcim1402Form) {
		this.igcim1402Form = igcim1402Form;
	}

	public IGCIM1404Form getIgcim1404Form() {
		return igcim1404Form;
	}

	public void setIgcim1404Form(IGCIM1404Form igcim1404Form) {
		this.igcim1404Form = igcim1404Form;
	}

	public IGCIM1405Form getIgcim1405Form() {
		return igcim1405Form;
	}

	public void setIgcim1405Form(IGCIM1405Form igcim1405Form) {
		this.igcim1405Form = igcim1405Form;
	}

	public IGCIM1406Form getIgcim1406Form() {
		return igcim1406Form;
	}

	public void setIgcim1406Form(IGCIM1406Form igcim1406Form) {
		this.igcim1406Form = igcim1406Form;
	}

	public IGCIM1407Form getIgcim1407Form() {
		return igcim1407Form;
	}

	public void setIgcim1407Form(IGCIM1407Form igcim1407Form) {
		this.igcim1407Form = igcim1407Form;
	}

	public IGCIM1412Form getIgcim1412Form() {
		return igcim1412Form;
	}

	public void setIgcim1412Form(IGCIM1412Form igcim1412Form) {
		this.igcim1412Form = igcim1412Form;
	}

	public SOC0124Info getEntityItemVWInfo() {
		return entityItemVWInfo;
	}

	public void setEntityItemVWInfo(SOC0124Info entityItemVWInfo) {
		this.entityItemVWInfo = entityItemVWInfo;
	}

	public List<SOC0107Info> getConfigItemList() {
		return configItemList;
	}

	public void setConfigItemList(List<SOC0107Info> configItemList) {
		this.configItemList = configItemList;
	}
	
}


