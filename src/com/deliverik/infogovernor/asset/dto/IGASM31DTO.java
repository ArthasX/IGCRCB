package com.deliverik.infogovernor.asset.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.soc.asset.model.SOC0109Info;
import com.deliverik.framework.soc.asset.model.SOC0119Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.SOC0128Info;
import com.deliverik.framework.soc.asset.model.SOC0129Info;
import com.deliverik.framework.soc.asset.model.SOC0151Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.asset.form.IGASM3101Form;
import com.deliverik.infogovernor.asset.form.IGASM3102Form;
import com.deliverik.infogovernor.asset.form.IGASM3104Form;
import com.deliverik.infogovernor.asset.form.IGASM3105Form;
import com.deliverik.infogovernor.asset.form.IGASM3106Form;
import com.deliverik.infogovernor.asset.form.IGASM3107Form;
import com.deliverik.infogovernor.asset.form.IGASM3112Form;
import com.deliverik.infogovernor.asset.model.RiskIndexSearchVWInfo;
import com.deliverik.infogovernor.asset.form.IGASM3115Form;
import com.deliverik.infogovernor.asset.form.IGASM3116Form;
import com.deliverik.infogovernor.asset.model.MaintenanceInfo;
import com.deliverik.infogovernor.asset.model.RiskIndexContextVWInfo;
import com.deliverik.infogovernor.asset.model.RiskIndexShowVWInfo;
/**
 * 检查项配置管理业务用DTO
 * 
 */
@SuppressWarnings("serial")
public class IGASM31DTO extends BaseDTO implements Serializable{

	/** 检查项信息 */
	protected IGASM3102Form igasm3102Form;
	
	protected String hiddenmguserid;
	
	protected String identyFlag;

	/** 检查项信息检索条件 */
	protected SOC0124SearchCond entityItemVWSearchCond;
	
	/** 检索最大件数 */
	protected int maxSearchCount;

	/** 翻页用DTO */
	protected PagingDTO pagingDto;

	/** 检查项检索结果 */
	protected List<SOC0124Info> entityItemVWInfoList;

	/** 检查项删除对象 */
	protected String[] deleteEntityItem;

	/** 检查项配置信息 */
	protected IGASM3104Form igasm3104Form;
	
	/** 检查项配置信息检索结果 */
	protected List<SOC0129Info> configItemVWInfoList;

	/** 检查项配置信息画面检查项信息 */
	protected SOC0124Info entityItemVWInfo;

	/** 检查项配置信息历史记录检索条件 */
	protected IGASM3105Form igasm3105Form;
	
	/** 检查项配置信息历史记录检索结果 */
	protected List<SOC0107Info> configItemList;
	
	/** 检查项关系管理检索条件 */
	protected IGASM3106Form igasm3106Form;
	
	/** 资产项关系管理信息检索结果1 */
	protected List<SOC0119Info> parEntityItemRelationList;
	
	/** 资产项关系管理信息检索结果2 */
	protected List<SOC0119Info> cldEntityItemRelationList;
	
	/** 检查项关系编辑信息 */
	protected IGASM3107Form igasm3107Form;
	
	/** 检查项关系编辑后信息 */
	protected SOC0119Info entityItemRelation;

	/** 检查项关系删除对象 */
	protected String[] deleteEntityItemRelation;
	
	protected Map<Integer,Integer> checkVersionMap;
	
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
	/** 检查项所属机构名称 */
	protected String eiorgname;
	protected IGASM3112Form igasm3112Form;
	
	protected IGASM3115Form igasm3115Form;
	protected MaintenanceInfo searchMaintenanceByPK;
	
	/**
	 * searchMaintenanceByPK取得
	 * @return searchMaintenanceByPK searchMaintenanceByPK
	 */
	public MaintenanceInfo getSearchMaintenanceByPK() {
		return searchMaintenanceByPK;
	}

	/**
	 * searchMaintenanceByPK设定
	 * @param searchMaintenanceByPK searchMaintenanceByPK
	 */
	public void setSearchMaintenanceByPK(MaintenanceInfo searchMaintenanceByPK) {
		this.searchMaintenanceByPK = searchMaintenanceByPK;
	}

	/**风险指标左侧展示*/
	protected List<RiskIndexContextVWInfo> searchRiskIndexContextVW;
	
	/**
	 * 风险指标左侧展示取得
	 * @return searchRiskIndexContextVW 风险指标左侧展示
	 */
	public List<RiskIndexContextVWInfo> getSearchRiskIndexContextVW() {
		return searchRiskIndexContextVW;
	}

	/**
	 * 风险指标左侧展示设定
	 * @param searchRiskIndexContextVW 风险指标左侧展示
	 */
	public void setSearchRiskIndexContextVW(
			List<RiskIndexContextVWInfo> searchRiskIndexContextVW) {
		this.searchRiskIndexContextVW = searchRiskIndexContextVW;
	}

	
	/**
	 * @return the hiddenmguserid
	 */
	public String getHiddenmguserid() {
		return hiddenmguserid;
	}

	/**
	 * @param hiddenmguserid the hiddenmguserid to set
	 */
	public void setHiddenmguserid(String hiddenmguserid) {
		this.hiddenmguserid = hiddenmguserid;
	}

	/**
	 * igasm3116form取得
	 * @return igasm3116form igasm3116form
	 */
	public IGASM3116Form getIgasm3116form() {
		return igasm3116form;
	}

	
	/**
	 * @return the identyFlag
	 */
	public String getIdentyFlag() {
		return identyFlag;
	}

	/**
	 * @param identyFlag the identyFlag to set
	 */
	public void setIdentyFlag(String identyFlag) {
		this.identyFlag = identyFlag;
	}

	/**
	 * igasm3116form设定
	 * @param igasm3116form igasm3116form
	 */
	public void setIgasm3116form(IGASM3116Form igasm3116form) {
		this.igasm3116form = igasm3116form;
	}

	protected IGASM3116Form igasm3116form;
	
	/**
	 * igasm3115Form取得
	 * @return igasm3115Form igasm3115Form
	 */
	public IGASM3115Form getIgasm3115Form() {
		return igasm3115Form;
	}

	/**
	 * igasm3115Form设定
	 * @param igasm3115Form igasm3115Form
	 */
	public void setIgasm3115Form(IGASM3115Form igasm3115Form) {
		this.igasm3115Form = igasm3115Form;
	}

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
	/**风险指标展示*/
	protected List<RiskIndexShowVWInfo> riskIndexShowList;
	
	/**
	 * 风险指标展示取得
	 * @return riskIndexShowList 风险指标展示
	 */
	public List<RiskIndexShowVWInfo> getRiskIndexShowList() {
		return riskIndexShowList;
	}

	/**
	 * 风险指标展示设定
	 * @param riskIndexShowList 风险指标展示
	 */
	public void setRiskIndexShowList(List<RiskIndexShowVWInfo> riskIndexShowList) {
		this.riskIndexShowList = riskIndexShowList;
	}

	/**风险指标--是否关键指标下拉*/
	protected List<SOC0151Info> keyIndexList;
	
	/**风险指标--指标模板下拉*/
	protected List<SOC0151Info> titList;
	
	/**风险指标--阀值下拉*/
	protected List<SOC0151Info> thresholdList;
	
	/**风险指标属性信息集合*/
	protected List<SOC0109Info> soc0109List;
	
	/**风险指标登记成功后返回页面所需值*/
	protected Integer eiid;
	
	/**风险指标查询返回集合*/
	protected List<RiskIndexSearchVWInfo> searchRiskIndexSearchVWList;
	
	/** 风险指标查询 */
	protected IGASM3101Form IGASM3101FORM;
	
	
	/**说明*/
	protected String fingerprint;
	
	/** 风险ID */
	protected Integer riid;

	/** 模板类型 */
	protected String rimtype;

	/** 计算方法 */
	protected String rimdesc;

	/** SQL语句 */
	protected String rimsql;
	
	
	
	
	public String getFingerprint() {
		return fingerprint;
	}

	public void setFingerprint(String fingerprint) {
		this.fingerprint = fingerprint;
	}

	public Integer getRiid() {
		return riid;
	}

	public void setRiid(Integer riid) {
		this.riid = riid;
	}

	public String getRimtype() {
		return rimtype;
	}

	public void setRimtype(String rimtype) {
		this.rimtype = rimtype;
	}

	public String getRimdesc() {
		return rimdesc;
	}

	public void setRimdesc(String rimdesc) {
		this.rimdesc = rimdesc;
	}

	public String getRimsql() {
		return rimsql;
	}

	public void setRimsql(String rimsql) {
		this.rimsql = rimsql;
	}

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

	public Map<Integer, Integer> getCheckVersionMap() {
		return checkVersionMap;
	}

	public void setCheckVersionMap(Map<Integer, Integer> checkVersionMap) {
		this.checkVersionMap = checkVersionMap;
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
	
	
	public IGASM3112Form getIgasm3112Form() {
		return igasm3112Form;
	}

	public void setIgasm3112Form(IGASM3112Form igasm3112Form) {
		this.igasm3112Form = igasm3112Form;
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
	 * 检查项信息取得
	 * @return 检查项信息
	 */
	public IGASM3102Form getIgasm3102Form() {
		return igasm3102Form;
	}

	/**
	 * 检查项信息设定
	 *
	 * @param igasm3102Form 检查项信息
	 */
	public void setIgasm3102Form(IGASM3102Form igasm3102Form) {
		this.igasm3102Form = igasm3102Form;
	}

	/**
	 * 检查项信息检索条件取得
	 * @return 检查项信息检索条件
	 */
	public SOC0124SearchCond getEntityItemVWSearchCond() {
		return entityItemVWSearchCond;
	}

	/**
	 * 检查项信息检索条件设定
	 *
	 * @param entityItemVWSearchCond 检查项信息检索条件
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
	 * 检查项检索结果取得
	 * @return 检查项检索结果
	 */
	public List<SOC0124Info> getEntityItemVWInfoList() {
		return entityItemVWInfoList;
	}

	/**
	 * 检查项检索结果设定
	 *
	 * @param entityItemVWInfoList 检查项检索结果
	 */
	public void setEntityItemVWInfoList(List<SOC0124Info> entityItemVWInfoList) {
		this.entityItemVWInfoList = entityItemVWInfoList;
	}

	/**
	 * 检查项删除对象取得
	 * @return 检查项删除对象
	 */
	public String[] getDeleteEntityItem() {
		return deleteEntityItem;
	}

	/**
	 * 检查项删除对象设定
	 *
	 * @param deleteEntityItem 检查项删除对象
	 */
	public void setDeleteEntityItem(String[] deleteEntityItem) {
		this.deleteEntityItem = deleteEntityItem;
	}

	/**
	 * 检查项配置信息取得
	 * @return 检查项配置信息
	 */
	public IGASM3104Form getIgasm3104Form() {
		return igasm3104Form;
	}


	/**
	 * 检查项配置信息检索条件设定
	 *
	 * @param igasm3104Form 检查项配置信息检索条件
	 */
	public void setIgasm3104Form(IGASM3104Form igasm3104Form) {
		this.igasm3104Form = igasm3104Form;
	}

	/**
	 * 检查项配置信息检索结果取得
	 * @return 检查项配置信息检索结果
	 */
	public List<SOC0129Info> getConfigItemVWInfoList() {
		return configItemVWInfoList;
	}

	/**
	 * 检查项配置信息检索结果设定
	 *
	 * @param configItemVWInfoList 检查项配置信息检索结果
	 */
	public void setConfigItemVWInfoList(List<SOC0129Info> configItemVWInfoList) {
		this.configItemVWInfoList = configItemVWInfoList;
	}

	/**
	 * 检查项配置信息画面检查项信息取得
	 * @return 检查项配置信息画面检查项信息
	 */
	public SOC0124Info getEntityItemVWInfo() {
		return entityItemVWInfo;
	}

	/**
	 * 检查项配置信息画面检查项信息设定
	 *
	 * @param entityItemVWInfo 检查项配置信息画面检查项信息
	 */
	public void setEntityItemVWInfo(SOC0124Info entityItemVWInfo) {
		this.entityItemVWInfo = entityItemVWInfo;
	}

	/**
	 * 检查项配置信息历史记录检索条件取得
	 * @return 检查项配置信息历史记录检索条件
	 */
	public IGASM3105Form getIgasm3105Form() {
		return igasm3105Form;
	}

	/**
	 * 检查项配置信息历史记录检索条件设定
	 *
	 * @param igasm3105Form 检查项配置信息历史记录检索条件
	 */
	public void setIgasm3105Form(IGASM3105Form igasm3105Form) {
		this.igasm3105Form = igasm3105Form;
	}

	/**
	 * 检查项配置信息历史记录检索结果取得
	 * @return 检查项配置信息历史记录检索结果
	 */
	public List<SOC0107Info> getConfigItemList() {
		return configItemList;
	}

	/**
	 * 检查项配置信息历史记录检索结果设定
	 *
	 * @param configItemList 检查项配置信息历史记录检索结果
	 */
	public void setConfigItemList(List<SOC0107Info> configItemList) {
		this.configItemList = configItemList;
	}

	/**
	 * 检查项关系管理检索条件取得
	 * @return 检查项关系管理检索条件
	 */
	public IGASM3106Form getIgasm3106Form() {
		return igasm3106Form;
	}

	/**
	 * 检查项关系管理检索条件设定
	 *
	 * @param igasm3106Form 检查项关系管理检索条件
	 */
	public void setIgasm3106Form(IGASM3106Form igasm3106Form) {
		this.igasm3106Form = igasm3106Form;
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
	 * 检查项关系编辑信息取得
	 * @return 编辑信息
	 */
	public IGASM3107Form getIgasm3107Form() {
		return igasm3107Form;
	}

	/**
	 * 检查项关系编辑信息设定
	 *
	 * @param igasm3107Form 检查项关系编辑信息
	 */
	public void setIgasm3107Form(IGASM3107Form igasm3107Form) {
		this.igasm3107Form = igasm3107Form;
	}

	/**
	 * 检查项关系编辑后信息取得
	 * @return 检查项关系编辑后信息
	 */
	public SOC0119Info getEntityItemRelation() {
		return entityItemRelation;
	}

	/**
	 * 检查项关系编辑后信息设定
	 *
	 * @param entityItemRelation 检查项关系编辑后信息
	 */
	public void setEntityItemRelation(SOC0119Info entityItemRelation) {
		this.entityItemRelation = entityItemRelation;
	}

	/**
	 * 检查项关系删除对象取得
	 * @return 检查项关系删除对象
	 */
	public String[] getDeleteEntityItemRelation() {
		return deleteEntityItemRelation;
	}

	/**
	 * 检查项关系删除对象设定
	 *
	 * @param entityItemRelation 检查项关系删除对象
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

	/**
	 * 风险指标--是否关键指标下拉取得
	 * @return list集合
	 */
	public List<SOC0151Info> getKeyIndexList() {
		return keyIndexList;
	}
	/**
	 * 风险指标--是否关键指标下拉设定
	 */
	public void setKeyIndexList(List<SOC0151Info> keyIndexList) {
		this.keyIndexList = keyIndexList;
	}
	/**
	 * 风险指标--指标模板下拉取得
	 * @return list集合
	 */
	public List<SOC0151Info> getTitList() {
		return titList;
	}
	/**
	 * 风险指标--指标模板下拉设定
	 */
	public void setTitList(List<SOC0151Info> titList) {
		this.titList = titList;
	}
	/**
	 * 风险指标--阀值下拉取得
	 * @return list集合
	 */
	public List<SOC0151Info> getThresholdList() {
		return thresholdList;
	}
	/**
	 * 风险指标--阀值下拉设定
	 */
	public void setThresholdList(List<SOC0151Info> thresholdList) {
		this.thresholdList = thresholdList;
	}

	public List<SOC0109Info> getSoc0109List() {
		return soc0109List;
	}

	public void setSoc0109List(List<SOC0109Info> soc0109List) {
		this.soc0109List = soc0109List;
	}

	public Integer getEiid() {
		return eiid;
	}

	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	public List<RiskIndexSearchVWInfo> getSearchRiskIndexSearchVWList() {
		return searchRiskIndexSearchVWList;
	}

	public void setSearchRiskIndexSearchVWList(
			List<RiskIndexSearchVWInfo> searchRiskIndexSearchVWList) {
		this.searchRiskIndexSearchVWList = searchRiskIndexSearchVWList;
	}

	public IGASM3101Form getIGASM3101FORM() {
		return IGASM3101FORM;
	}

	public void setIGASM3101FORM(IGASM3101Form iGASM3101FORM) {
		IGASM3101FORM = iGASM3101FORM;
	}

}


