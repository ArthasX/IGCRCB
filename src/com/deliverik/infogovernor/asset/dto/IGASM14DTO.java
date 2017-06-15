package com.deliverik.infogovernor.asset.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.asset.model.IG013Info;
import com.deliverik.framework.asset.model.condition.IG800SearchCond;
import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.SOC0119Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.SOC0128Info;
import com.deliverik.framework.soc.asset.model.SOC0129Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.asset.form.IGASM1402Form;
import com.deliverik.infogovernor.asset.form.IGASM1404Form;
import com.deliverik.infogovernor.asset.form.IGASM1405Form;
import com.deliverik.infogovernor.asset.form.IGASM1406Form;
import com.deliverik.infogovernor.asset.form.IGASM1407Form;
import com.deliverik.infogovernor.asset.form.IGASM1412Form;

/**
 * 服务记录配置管理业务用DTO
 * 
 */
@SuppressWarnings("serial")
public class IGASM14DTO extends BaseDTO implements Serializable{

	protected IG800SearchCond configItemSearchCond;
	public IG800SearchCond getConfigItemSearchCond() {
		return configItemSearchCond;
	}

	public void setConfigItemSearchCond(IG800SearchCond configItemSearchCond) {
		this.configItemSearchCond = configItemSearchCond;
	}

	/** 服务记录信息 */
	protected IGASM1402Form igasm1402Form;
	
	/** 服务记录信息检索条件 */
	protected SOC0124SearchCond entityItemVWSearchCond;
	
	/** 检索最大件数 */
	protected int maxSearchCount;

	/** 翻页用DTO */
	protected PagingDTO pagingDto;

	/** 服务记录检索结果 */
	protected List<SOC0124Info> entityItemVWInfoList;

	/** 服务记录删除对象 */
	protected String[] deleteEntityItem;

	/** 服务记录配置信息 */
	protected IGASM1404Form igasm1404Form;
	
	/** 服务记录配置信息检索结果 */
	protected List<SOC0129Info> configItemVWInfoList;

	/** 服务记录配置信息画面服务记录信息 */
	protected SOC0124Info entityItemVWInfo;

	/** 服务记录配置信息历史记录检索条件 */
	protected IGASM1405Form igasm1405Form;
	
	/** 服务记录配置信息历史记录检索结果 */
	protected List<SOC0107Info> configItemList;
	
	/** 服务记录关系管理检索条件 */
	protected IGASM1406Form igasm1406Form;
	
	/** 资产项关系管理信息检索结果1 */
	protected List<SOC0119Info> parEntityItemRelationList;
	
	/** 资产项关系管理信息检索结果2 */
	protected List<SOC0119Info> cldEntityItemRelationList;
	
	/** 服务记录关系编辑信息 */
	protected IGASM1407Form igasm1407Form;
	
	/** 服务记录关系编辑后信息 */
	protected SOC0119Info entityItemRelation;

	/** 服务记录关系删除对象 */
	protected String[] deleteEntityItemRelation;
	
	/** 资产项配置信息检索结果 */
	protected Map<String,List<SOC0129Info>> configItemVWInfoMap;
	
	/** 资产项配置信息检索结果 */
	protected Map<String,List<SOC0107Info>> configItemMap;
	
	/**操作人id*/
	protected String userid;
	
	/**操作人姓名*/
	protected String username;
	
	protected String reciveUser;
	protected Map<String,List<SOC0119Info>> parEntityItemRelationMap;
	protected Map<String,List<SOC0119Info>> cldEntityItemRelationMap;
	protected int parCount;
	protected int cldCount;
	
	/** 服务记录信息修改 */
	protected IGASM1412Form igasm1412Form;
	
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
	/** 服务记录检索结果 */
	protected List<SOC0118Info> entityItemList;
	
	/** 资产版本列表 */
	protected List<SOC0128Info> configItemVersionTime;

	public List<SOC0118Info> getEntityItemList() {
		return entityItemList;
	}

	public void setEntityItemList(List<SOC0118Info> entityItemList) {
		this.entityItemList = entityItemList;
	}

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
	
	
	public IGASM1412Form getIgasm1412Form() {
		return igasm1412Form;
	}

	public void setIgasm1412Form(IGASM1412Form igasm1412Form) {
		this.igasm1412Form = igasm1412Form;
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
	
	/** 服务记录所属机构id */
	protected String orgid;
	
	/** 服务记录所属机构name */
	protected String orgname;
	
	/** 服务记录下发时间 */
	protected String issuetime;
	
	/** 服务记录领用人 */
	protected String recivename;
	
	/** 服务记录当前版本号 */
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
	
	/** 服务记录信息画面服务记录信息 */
	protected IG013Info entityItem;
	
	public IG013Info getEntityItem() {
		return entityItem;
	}

	public void setEntityItem(IG013Info entityItem) {
		this.entityItem = entityItem;
	}
	/**
	 * 服务记录信息取得
	 * @return 服务记录信息
	 */
	public IGASM1402Form getIgasm1402Form() {
		return igasm1402Form;
	}

	/**
	 * 服务记录信息设定
	 *
	 * @param igasm1402Form 服务记录信息
	 */
	public void setIgasm1402Form(IGASM1402Form igasm1402Form) {
		this.igasm1402Form = igasm1402Form;
	}


	/**
	 * 服务记录信息检索条件取得
	 * @return 服务记录信息检索条件
	 */
	public SOC0124SearchCond getEntityItemVWSearchCond() {
		return entityItemVWSearchCond;
	}

	/**
	 * 服务记录信息检索条件设定
	 *
	 * @param entityItemVWSearchCond 服务记录信息检索条件
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
	 * 服务记录检索结果取得
	 * @return 服务记录检索结果
	 */
	public List<SOC0124Info> getEntityItemVWInfoList() {
		return entityItemVWInfoList;
	}

	/**
	 * 服务记录检索结果设定
	 *
	 * @param entityItemVWInfoList 服务记录检索结果
	 */
	public void setEntityItemVWInfoList(List<SOC0124Info> entityItemVWInfoList) {
		this.entityItemVWInfoList = entityItemVWInfoList;
	}

	/**
	 * 服务记录删除对象取得
	 * @return 服务记录删除对象
	 */
	public String[] getDeleteEntityItem() {
		return deleteEntityItem;
	}

	/**
	 * 服务记录删除对象设定
	 *
	 * @param deleteEntityItem 服务记录删除对象
	 */
	public void setDeleteEntityItem(String[] deleteEntityItem) {
		this.deleteEntityItem = deleteEntityItem;
	}

	/**
	 * 服务记录配置信息取得
	 * @return 服务记录配置信息
	 */
	public IGASM1404Form getIgasm1404Form() {
		return igasm1404Form;
	}


	/**
	 * 服务记录配置信息检索条件设定
	 *
	 * @param igasm1404Form 服务记录配置信息检索条件
	 */
	public void setIgasm1404Form(IGASM1404Form igasm1404Form) {
		this.igasm1404Form = igasm1404Form;
	}

	/**
	 * 服务记录配置信息检索结果取得
	 * @return 服务记录配置信息检索结果
	 */
	public List<SOC0129Info> getConfigItemVWInfoList() {
		return configItemVWInfoList;
	}

	/**
	 * 服务记录配置信息检索结果设定
	 *
	 * @param configItemVWInfoList 服务记录配置信息检索结果
	 */
	public void setConfigItemVWInfoList(List<SOC0129Info> configItemVWInfoList) {
		this.configItemVWInfoList = configItemVWInfoList;
	}

	/**
	 * 服务记录配置信息画面服务记录信息取得
	 * @return 服务记录配置信息画面服务记录信息
	 */
	public SOC0124Info getEntityItemVWInfo() {
		return entityItemVWInfo;
	}

	/**
	 * 服务记录配置信息画面服务记录信息设定
	 *
	 * @param entityItemVWInfo 服务记录配置信息画面服务记录信息
	 */
	public void setEntityItemVWInfo(SOC0124Info entityItemVWInfo) {
		this.entityItemVWInfo = entityItemVWInfo;
	}

	/**
	 * 服务记录配置信息历史记录检索条件取得
	 * @return 服务记录配置信息历史记录检索条件
	 */
	public IGASM1405Form getIgasm1405Form() {
		return igasm1405Form;
	}

	/**
	 * 服务记录配置信息历史记录检索条件设定
	 *
	 * @param igasm1405Form 服务记录配置信息历史记录检索条件
	 */
	public void setIgasm1405Form(IGASM1405Form igasm1405Form) {
		this.igasm1405Form = igasm1405Form;
	}

	/**
	 * 服务记录配置信息历史记录检索结果取得
	 * @return 服务记录配置信息历史记录检索结果
	 */
	public List<SOC0107Info> getConfigItemList() {
		return configItemList;
	}

	/**
	 * 服务记录配置信息历史记录检索结果设定
	 *
	 * @param configItemList 服务记录配置信息历史记录检索结果
	 */
	public void setConfigItemList(List<SOC0107Info> configItemList) {
		this.configItemList = configItemList;
	}

	/**
	 * 服务记录关系管理检索条件取得
	 * @return 服务记录关系管理检索条件
	 */
	public IGASM1406Form getIgasm1406Form() {
		return igasm1406Form;
	}

	/**
	 * 服务记录关系管理检索条件设定
	 *
	 * @param igasm1406Form 服务记录关系管理检索条件
	 */
	public void setIgasm1406Form(IGASM1406Form igasm1406Form) {
		this.igasm1406Form = igasm1406Form;
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
	 * 服务记录关系编辑信息取得
	 * @return 编辑信息
	 */
	public IGASM1407Form getIgasm1407Form() {
		return igasm1407Form;
	}

	/**
	 * 服务记录关系编辑信息设定
	 *
	 * @param igasm1407Form 服务记录关系编辑信息
	 */
	public void setIgasm1407Form(IGASM1407Form igasm1407Form) {
		this.igasm1407Form = igasm1407Form;
	}

	/**
	 * 服务记录关系编辑后信息取得
	 * @return 服务记录关系编辑后信息
	 */
	public SOC0119Info getEntityItemRelation() {
		return entityItemRelation;
	}

	/**
	 * 服务记录关系编辑后信息设定
	 *
	 * @param entityItemRelation 服务记录关系编辑后信息
	 */
	public void setEntityItemRelation(SOC0119Info entityItemRelation) {
		this.entityItemRelation = entityItemRelation;
	}

	/**
	 * 服务记录关系删除对象取得
	 * @return 服务记录关系删除对象
	 */
	public String[] getDeleteEntityItemRelation() {
		return deleteEntityItemRelation;
	}

	/**
	 * 服务记录关系删除对象设定
	 *
	 * @param entityItemRelation 服务记录关系删除对象
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


