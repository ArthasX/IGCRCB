package com.deliverik.infogovernor.asset.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.asset.model.IG013Info;
import com.deliverik.framework.asset.model.condition.IG800SearchCond;
import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.soc.asset.model.SOC0119Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.SOC0128Info;
import com.deliverik.framework.soc.asset.model.SOC0129Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.asset.form.IGASM0902Form;
import com.deliverik.infogovernor.asset.form.IGASM0904Form;
import com.deliverik.infogovernor.asset.form.IGASM0905Form;
import com.deliverik.infogovernor.asset.form.IGASM0906Form;
import com.deliverik.infogovernor.asset.form.IGASM0907Form;
import com.deliverik.infogovernor.asset.form.IGASM0912Form;
import com.deliverik.infogovernor.asset.model.EntityItemFacilitatorVWInfo;
import com.deliverik.infogovernor.asset.model.condition.EntityItemFacilitatorVWSearchCond;

/**
 * 服务商配置管理业务用DTO
 * 修改记录: 2012/11/27 LuJiayuan 增加标识判断是否显示图像按钮
 */
@SuppressWarnings("serial")
public class IGASM09DTO extends BaseDTO implements Serializable{

	protected IG800SearchCond configItemSearchCond;
	public IG800SearchCond getConfigItemSearchCond() {
		return configItemSearchCond;
	}

	public void setConfigItemSearchCond(IG800SearchCond configItemSearchCond) {
		this.configItemSearchCond = configItemSearchCond;
	}
	/** 服务商信息视图检索条件 */
	protected EntityItemFacilitatorVWSearchCond entityItemFacilitatorVWSearchCond;
	
	/** 服务商信息视图检索结果 */
	protected List<EntityItemFacilitatorVWInfo> entityItemFacilitatorList;
	
	/** 服务商信息 */
	protected IGASM0902Form igasm0902Form;
	
	/** 服务商信息检索条件 */
	protected SOC0124SearchCond entityItemVWSearchCond;
	
	/** 检索最大件数 */
	protected int maxSearchCount;

	/** 翻页用DTO */
	protected PagingDTO pagingDto;

	/** 服务商检索结果 */
	protected List<SOC0124Info> entityItemVWInfoList;

	/** 服务商删除对象 */
	protected String[] deleteEntityItem;

	/** 服务商配置信息 */
	protected IGASM0904Form igasm0904Form;
	
	/** 服务商配置信息检索结果 */
	protected List<SOC0129Info> configItemVWInfoList;

	/** 服务商配置信息画面服务商信息 */
	protected SOC0124Info entityItemVWInfo;

	/** 服务商配置信息历史记录检索条件 */
	protected IGASM0905Form igasm0905Form;
	
	/** 服务商配置信息历史记录检索结果 */
	protected List<SOC0107Info> configItemList;
	
	/** 服务商关系管理检索条件 */
	protected IGASM0906Form igasm0906Form;
	
	
	/** 资产项关系管理信息检索结果1 */
	protected List<SOC0119Info> parEntityItemRelationList;
	
	/** 资产项关系管理信息检索结果2 */
	protected List<SOC0119Info> cldEntityItemRelationList;
	
	/** 服务商关系编辑信息 */
	protected IGASM0907Form igasm0907Form;
	
	/** 服务商关系编辑后信息 */
	protected SOC0119Info entityItemRelation;

	/** 服务商关系删除对象 */
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
	
	/** 服务商所属机构名称 */
	protected String eiorgname;
	/** 服务商信息修改 */
	protected IGASM0912Form igasm0912Form;
	
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
	protected List<SOC0128Info> configItemVersionTime;
	
	/** 图像扫描XML */
	protected String picuXml;
	
	/** 图像查看XML */
	protected String picsXml;
	
	/** 是否显示图像按钮标识 */
	protected Boolean image_flag;
	
	public String getPicuXml() {
		return picuXml;
	}

	public void setPicuXml(String picuXml) {
		this.picuXml = picuXml;
	}

	public String getPicsXml() {
		return picsXml;
	}

	public void setPicsXml(String picsXml) {
		this.picsXml = picsXml;
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
	
	
	public IGASM0912Form getIgasm0912Form() {
		return igasm0912Form;
	}

	public void setIgasm0912Form(IGASM0912Form igasm0912Form) {
		this.igasm0912Form = igasm0912Form;
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
	
	/** 服务商所属机构id */
	protected String orgid;
	
	/** 服务商所属机构name */
	protected String orgname;
	
	/** 服务商下发时间 */
	protected String issuetime;
	
	/** 服务商领用人 */
	protected String recivename;
	
	/** 服务商当前版本号 */
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

	
	/** 服务商信息画面服务商信息 */
	protected IG013Info entityItem;

	public IG013Info getEntityItem() {
		return entityItem;
	}

	public void setEntityItem(IG013Info entityItem) {
		this.entityItem = entityItem;
	}

	/**
	 * 服务商信息取得
	 * @return 服务商信息
	 */
	public IGASM0902Form getIgasm0902Form() {
		return igasm0902Form;
	}

	/**
	 * 服务商信息设定
	 *
	 * @param igasm0902Form 服务商信息
	 */
	public void setIgasm0902Form(IGASM0902Form igasm0902Form) {
		this.igasm0902Form = igasm0902Form;
	}
	

	/**
	 * 服务商信息检索条件取得
	 * @return 服务商信息检索条件
	 */
	public SOC0124SearchCond getEntityItemVWSearchCond() {
		return entityItemVWSearchCond;
	}

	/**
	 * 服务商信息检索条件设定
	 *
	 * @param entityItemVWSearchCond 服务商信息检索条件
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
	 * 服务商检索结果取得
	 * @return 服务商检索结果
	 */
	public List<SOC0124Info> getEntityItemVWInfoList() {
		return entityItemVWInfoList;
	}

	/**
	 * 服务商检索结果设定
	 *
	 * @param entityItemVWInfoList 服务商检索结果
	 */
	public void setEntityItemVWInfoList(List<SOC0124Info> entityItemVWInfoList) {
		this.entityItemVWInfoList = entityItemVWInfoList;
	}

	/**
	 * 服务商删除对象取得
	 * @return 服务商删除对象
	 */
	public String[] getDeleteEntityItem() {
		return deleteEntityItem;
	}

	/**
	 * 服务商删除对象设定
	 *
	 * @param deleteEntityItem 服务商删除对象
	 */
	public void setDeleteEntityItem(String[] deleteEntityItem) {
		this.deleteEntityItem = deleteEntityItem;
	}

	/**
	 * 服务商配置信息取得
	 * @return 服务商配置信息
	 */
	public IGASM0904Form getIgasm0904Form() {
		return igasm0904Form;
	}


	/**
	 * 服务商配置信息检索条件设定
	 *
	 * @param igasm0904Form 服务商配置信息检索条件
	 */
	public void setIgasm0904Form(IGASM0904Form igasm0904Form) {
		this.igasm0904Form = igasm0904Form;
	}

	/**
	 * 服务商配置信息检索结果取得
	 * @return 服务商配置信息检索结果
	 */
	public List<SOC0129Info> getConfigItemVWInfoList() {
		return configItemVWInfoList;
	}

	/**
	 * 服务商配置信息检索结果设定
	 *
	 * @param configItemVWInfoList 服务商配置信息检索结果
	 */
	public void setConfigItemVWInfoList(List<SOC0129Info> configItemVWInfoList) {
		this.configItemVWInfoList = configItemVWInfoList;
	}

	/**
	 * 服务商配置信息画面服务商信息取得
	 * @return 服务商配置信息画面服务商信息
	 */
	public SOC0124Info getEntityItemVWInfo() {
		return entityItemVWInfo;
	}

	/**
	 * 服务商配置信息画面服务商信息设定
	 *
	 * @param entityItemVWInfo 服务商配置信息画面服务商信息
	 */
	public void setEntityItemVWInfo(SOC0124Info entityItemVWInfo) {
		this.entityItemVWInfo = entityItemVWInfo;
	}

	/**
	 * 服务商配置信息历史记录检索条件取得
	 * @return 服务商配置信息历史记录检索条件
	 */
	public IGASM0905Form getIgasm0905Form() {
		return igasm0905Form;
	}

	/**
	 * 服务商配置信息历史记录检索条件设定
	 *
	 * @param igasm0905Form 服务商配置信息历史记录检索条件
	 */
	public void setIgasm0905Form(IGASM0905Form igasm0905Form) {
		this.igasm0905Form = igasm0905Form;
	}

	/**
	 * 服务商配置信息历史记录检索结果取得
	 * @return 服务商配置信息历史记录检索结果
	 */
	public List<SOC0107Info> getConfigItemList() {
		return configItemList;
	}

	/**
	 * 服务商配置信息历史记录检索结果设定
	 *
	 * @param configItemList 服务商配置信息历史记录检索结果
	 */
	public void setConfigItemList(List<SOC0107Info> configItemList) {
		this.configItemList = configItemList;
	}

	/**
	 * 服务商关系管理检索条件取得
	 * @return 服务商关系管理检索条件
	 */
	public IGASM0906Form getIgasm0906Form() {
		return igasm0906Form;
	}

	/**
	 * 服务商关系管理检索条件设定
	 *
	 * @param igasm0906Form 服务商关系管理检索条件
	 */
	public void setIgasm0906Form(IGASM0906Form igasm0906Form) {
		this.igasm0906Form = igasm0906Form;
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
	 * 服务商关系编辑信息取得
	 * @return 编辑信息
	 */
	public IGASM0907Form getIgasm0907Form() {
		return igasm0907Form;
	}

	/**
	 * 服务商关系编辑信息设定
	 *
	 * @param igasm0907Form 服务商关系编辑信息
	 */
	public void setIgasm0907Form(IGASM0907Form igasm0907Form) {
		this.igasm0907Form = igasm0907Form;
	}

	/**
	 * 服务商关系编辑后信息取得
	 * @return 服务商关系编辑后信息
	 */
	public SOC0119Info getEntityItemRelation() {
		return entityItemRelation;
	}

	/**
	 * 服务商关系编辑后信息设定
	 *
	 * @param entityItemRelation 服务商关系编辑后信息
	 */
	public void setEntityItemRelation(SOC0119Info entityItemRelation) {
		this.entityItemRelation = entityItemRelation;
	}

	/**
	 * 服务商关系删除对象取得
	 * @return 服务商关系删除对象
	 */
	public String[] getDeleteEntityItemRelation() {
		return deleteEntityItemRelation;
	}

	/**
	 * 服务商关系删除对象设定
	 *
	 * @param entityItemRelation 服务商关系删除对象
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
	
	/**
	 * image_flag取得
	 *
	 * @return image_flag image_flag
	 */
	public Boolean getImage_flag() {
		return image_flag;
	}
	/**
	 * image_flag设定
	 *
	 * @param image_flag image_flag
	 */
	public void setImage_flag(Boolean image_flag) {
		this.image_flag = image_flag;
	}
	
	/**
	 * 服务商信息视图检索条件 取得
	 *
	 * @return entityItemFacilitatorVWSearchCond
	 */
	public EntityItemFacilitatorVWSearchCond getEntityItemFacilitatorVWSearchCond() {
		return entityItemFacilitatorVWSearchCond;
	}
	
	/**
	 * 服务商信息视图检索条件 设定
	 *
	 * @param entityItemFacilitatorVWSearchCond
	 */
	public void setEntityItemFacilitatorVWSearchCond(
			EntityItemFacilitatorVWSearchCond entityItemFacilitatorVWSearchCond) {
		this.entityItemFacilitatorVWSearchCond = entityItemFacilitatorVWSearchCond;
	}
	/**
	 * 服务商信息视图检索结果 取得
	 *
	 * @return entityItemFacilitatorList
	 */
	public List<EntityItemFacilitatorVWInfo> getEntityItemFacilitatorList() {
		return entityItemFacilitatorList;
	}
	/**
	 * 服务商信息视图检索结果 设定
	 *
	 * @param entityItemFacilitatorList
	 */
	public void setEntityItemFacilitatorList(
			List<EntityItemFacilitatorVWInfo> entityItemFacilitatorList) {
		this.entityItemFacilitatorList = entityItemFacilitatorList;
	}

}