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
import com.deliverik.infogovernor.asset.form.IGASM2702Form;
import com.deliverik.infogovernor.asset.form.IGASM2704Form;
import com.deliverik.infogovernor.asset.form.IGASM2705Form;
import com.deliverik.infogovernor.asset.form.IGASM2706Form;
import com.deliverik.infogovernor.asset.form.IGASM2707Form;
import com.deliverik.infogovernor.asset.form.IGASM2712Form;
import com.deliverik.infogovernor.asset.form.IGASM2713Form;
import com.deliverik.infogovernor.asset.model.RiskCheckVWInfo;
import com.deliverik.infogovernor.asset.model.RiskPointVMInfo;
import com.deliverik.infogovernor.asset.model.RiskToZhRelateVWInfo;

/**
 * 风险点配置管理业务用DTO
 * 
 */
@SuppressWarnings("serial")
public class IGASM27DTO extends BaseDTO implements Serializable{

	/** 风险点信息 */
	protected IGASM2702Form igasm2702Form;
	
	/**风险点查询*/
	protected IGASM2713Form igasm2713Form;
	
	/** 风险点信息检索条件 */
	protected SOC0124SearchCond entityItemVWSearchCond;
	
	/** 检索最大件数 */
	protected int maxSearchCount;

	/** 翻页用DTO */
	protected PagingDTO pagingDto;

	/** 风险点检索结果 */
	protected List<SOC0124Info> entityItemVWInfoList;

	/** 风险点删除对象 */
	protected String[] deleteEntityItem;

	/** 风险点配置信息 */
	protected IGASM2704Form igasm2704Form;
	
	/** 风险点配置信息检索结果 */
	protected List<SOC0129Info> configItemVWInfoList;

	/** 风险点配置信息画面风险点信息 */
	protected SOC0124Info entityItemVWInfo;

	/** 风险点配置信息历史记录检索条件 */
	protected IGASM2705Form igasm2705Form;
	
	/** 风险点配置信息历史记录检索结果 */
	protected List<SOC0107Info> configItemList;
	
	/** 风险点关系管理检索条件 */
	protected IGASM2706Form igasm2706Form;
	
	/** 资产项关系管理信息检索结果1 */
	protected List<SOC0119Info> parEntityItemRelationList;
	
	/** 资产项关系管理信息检索结果2 */
	protected List<SOC0119Info> cldEntityItemRelationList;
	
	/** 风险点关系编辑信息 */
	protected IGASM2707Form igasm2707Form;
	
	/** 风险点关系编辑后信息 */
	protected SOC0119Info entityItemRelation;

	/** 风险点关系删除对象 */
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
	/** 风险点所属机构名称 */
	protected String eiorgname;
	protected IGASM2712Form igasm2712Form;
	
	/**风险点查询 */
	protected List<RiskPointVMInfo> riskPointList;
	/**版本集合*/
	protected Map<Integer,Integer> checkVersionMap;
	
	/**风险---检查项*/
	protected List<RiskCheckVWInfo> searchRiskCheckList;
	
	/**风险---指标关系*/
	protected List<RiskToZhRelateVWInfo> riskToZhRelateList;
	
	/**
	 * 风险---指标关系取得
	 * @return riskToZhRelateList 风险---指标关系
	 */
	public List<RiskToZhRelateVWInfo> getRiskToZhRelateList() {
		return riskToZhRelateList;
	}

	/**
	 * 风险---指标关系设定
	 * @param riskToZhRelateList 风险---指标关系
	 */
	public void setRiskToZhRelateList(List<RiskToZhRelateVWInfo> riskToZhRelateList) {
		this.riskToZhRelateList = riskToZhRelateList;
	}

	/**
	 * 风险---检查项取得
	 * @return searchRiskCheckList 风险---检查项
	 */
	public List<RiskCheckVWInfo> getSearchRiskCheckList() {
		return searchRiskCheckList;
	}

	/**
	 * 风险---检查项设定
	 * @param searchRiskCheckList 风险---检查项
	 */
	public void setSearchRiskCheckList(List<RiskCheckVWInfo> searchRiskCheckList) {
		this.searchRiskCheckList = searchRiskCheckList;
	}

	/**管理人ID*/
	protected String  hiddenmguserid;
	
	/**
	 * 管理人ID取得
	 * @return hiddenmguserid 管理人ID
	 */
	public String getHiddenmguserid() {
		return hiddenmguserid;
	}

	/**
	 * 管理人ID设定
	 * @param hiddenmguserid 管理人ID
	 */
	public void setHiddenmguserid(String hiddenmguserid) {
		this.hiddenmguserid = hiddenmguserid;
	}

	/**标识 能看见不*/
	protected String identyFlag;
	
	/**
	 * 版本集合取得
	 * @return checkVersionMap 版本集合
	 */
	public Map<Integer, Integer> getCheckVersionMap() {
		return checkVersionMap;
	}

	/**
	 * 版本集合设定
	 * @param checkVersionMap 版本集合
	 */
	public void setCheckVersionMap(Map<Integer, Integer> checkVersionMap) {
		this.checkVersionMap = checkVersionMap;
	}

	/**
	 * 风险点查询取得
	 * @return riskPointList 风险点查询
	 */
	public List<RiskPointVMInfo> getRiskPointList() {
		return riskPointList;
	}

	/**
	 * 风险点查询设定
	 * @param riskPointList 风险点查询
	 */
	public void setRiskPointList(List<RiskPointVMInfo> riskPointList) {
		this.riskPointList = riskPointList;
	}

	/**风险点主键*/
	protected Integer eiid;
	
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
	
	/**风险严重等级集合获取*/
	protected List<SOC0151Info> gradeList;
	
	/**风险级别集合获取*/
	protected List<SOC0151Info> levelList;
	
	/**风险点可能性*/
	protected List<SOC0151Info> possibleList;
	
	/**风险标识集合*/
	protected List<SOC0151Info> signList;
	
	/**检查项属性信息集合*/
	protected List<SOC0109Info> soc0109List;
	
	/**风险点 查询 集合*/
	protected List<RiskPointVMInfo> riskList;
	
	/**
	 * 检查项属性信息集合取得
	 * @return soc0109List 检查项属性信息集合
	 */
	public List<SOC0109Info> getSoc0109List() {
		return soc0109List;
	}

	/**
	 * 检查项属性信息集合设定
	 * @param soc0109List 检查项属性信息集合
	 */
	public void setSoc0109List(List<SOC0109Info> soc0109List) {
		this.soc0109List = soc0109List;
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
	
	
	public IGASM2712Form getIgasm2712Form() {
		return igasm2712Form;
	}

	public void setIgasm2712Form(IGASM2712Form igasm2712Form) {
		this.igasm2712Form = igasm2712Form;
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
	 * 风险点信息取得
	 * @return 风险点信息
	 */
	public IGASM2702Form getIgasm2702Form() {
		return igasm2702Form;
	}

	/**
	 * 风险点信息设定
	 *
	 * @param igasm2702Form 风险点信息
	 */
	public void setIgasm2702Form(IGASM2702Form igasm2702Form) {
		this.igasm2702Form = igasm2702Form;
	}

	/**
	 * 风险点信息检索条件取得
	 * @return 风险点信息检索条件
	 */
	public SOC0124SearchCond getEntityItemVWSearchCond() {
		return entityItemVWSearchCond;
	}

	/**
	 * 风险点信息检索条件设定
	 *
	 * @param entityItemVWSearchCond 风险点信息检索条件
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
	 * 风险点检索结果取得
	 * @return 风险点检索结果
	 */
	public List<SOC0124Info> getEntityItemVWInfoList() {
		return entityItemVWInfoList;
	}

	/**
	 * 风险点检索结果设定
	 *
	 * @param entityItemVWInfoList 风险点检索结果
	 */
	public void setEntityItemVWInfoList(List<SOC0124Info> entityItemVWInfoList) {
		this.entityItemVWInfoList = entityItemVWInfoList;
	}

	/**
	 * 风险点删除对象取得
	 * @return 风险点删除对象
	 */
	public String[] getDeleteEntityItem() {
		return deleteEntityItem;
	}

	/**
	 * 风险点删除对象设定
	 *
	 * @param deleteEntityItem 风险点删除对象
	 */
	public void setDeleteEntityItem(String[] deleteEntityItem) {
		this.deleteEntityItem = deleteEntityItem;
	}

	/**
	 * 风险点配置信息取得
	 * @return 风险点配置信息
	 */
	public IGASM2704Form getIgasm2704Form() {
		return igasm2704Form;
	}


	/**
	 * 风险点配置信息检索条件设定
	 *
	 * @param igasm2704Form 风险点配置信息检索条件
	 */
	public void setIgasm2704Form(IGASM2704Form igasm2704Form) {
		this.igasm2704Form = igasm2704Form;
	}

	/**
	 * 风险点配置信息检索结果取得
	 * @return 风险点配置信息检索结果
	 */
	public List<SOC0129Info> getConfigItemVWInfoList() {
		return configItemVWInfoList;
	}

	/**
	 * 风险点配置信息检索结果设定
	 *
	 * @param configItemVWInfoList 风险点配置信息检索结果
	 */
	public void setConfigItemVWInfoList(List<SOC0129Info> configItemVWInfoList) {
		this.configItemVWInfoList = configItemVWInfoList;
	}

	/**
	 * 风险点配置信息画面风险点信息取得
	 * @return 风险点配置信息画面风险点信息
	 */
	public SOC0124Info getEntityItemVWInfo() {
		return entityItemVWInfo;
	}

	/**
	 * 风险点配置信息画面风险点信息设定
	 *
	 * @param entityItemVWInfo 风险点配置信息画面风险点信息
	 */
	public void setEntityItemVWInfo(SOC0124Info entityItemVWInfo) {
		this.entityItemVWInfo = entityItemVWInfo;
	}

	/**
	 * 风险点配置信息历史记录检索条件取得
	 * @return 风险点配置信息历史记录检索条件
	 */
	public IGASM2705Form getIgasm2705Form() {
		return igasm2705Form;
	}

	/**
	 * 风险点配置信息历史记录检索条件设定
	 *
	 * @param igasm2705Form 风险点配置信息历史记录检索条件
	 */
	public void setIgasm2705Form(IGASM2705Form igasm2705Form) {
		this.igasm2705Form = igasm2705Form;
	}

	/**
	 * 风险点配置信息历史记录检索结果取得
	 * @return 风险点配置信息历史记录检索结果
	 */
	public List<SOC0107Info> getConfigItemList() {
		return configItemList;
	}

	/**
	 * 风险点配置信息历史记录检索结果设定
	 *
	 * @param configItemList 风险点配置信息历史记录检索结果
	 */
	public void setConfigItemList(List<SOC0107Info> configItemList) {
		this.configItemList = configItemList;
	}

	/**
	 * 风险点关系管理检索条件取得
	 * @return 风险点关系管理检索条件
	 */
	public IGASM2706Form getIgasm2706Form() {
		return igasm2706Form;
	}

	/**
	 * 风险点关系管理检索条件设定
	 *
	 * @param igasm2706Form 风险点关系管理检索条件
	 */
	public void setIgasm2706Form(IGASM2706Form igasm2706Form) {
		this.igasm2706Form = igasm2706Form;
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
	 * 风险点关系编辑信息取得
	 * @return 编辑信息
	 */
	public IGASM2707Form getIgasm2707Form() {
		return igasm2707Form;
	}

	/**
	 * 风险点关系编辑信息设定
	 *
	 * @param igasm2707Form 风险点关系编辑信息
	 */
	public void setIgasm2707Form(IGASM2707Form igasm2707Form) {
		this.igasm2707Form = igasm2707Form;
	}

	/**
	 * 风险点关系编辑后信息取得
	 * @return 风险点关系编辑后信息
	 */
	public SOC0119Info getEntityItemRelation() {
		return entityItemRelation;
	}

	/**
	 * 风险点关系编辑后信息设定
	 *
	 * @param entityItemRelation 风险点关系编辑后信息
	 */
	public void setEntityItemRelation(SOC0119Info entityItemRelation) {
		this.entityItemRelation = entityItemRelation;
	}

	/**
	 * 风险点关系删除对象取得
	 * @return 风险点关系删除对象
	 */
	public String[] getDeleteEntityItemRelation() {
		return deleteEntityItemRelation;
	}

	/**
	 * 风险点关系删除对象设定
	 *
	 * @param entityItemRelation 风险点关系删除对象
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
	 * 风险严重等级集合获取取得
	 * @return gradeList 风险严重等级集合获取
	 */
	public List<SOC0151Info> getGradeList() {
		return gradeList;
	}

	/**
	 * 风险严重等级集合获取设定
	 * @param gradeList 风险严重等级集合获取
	 */
	public void setGradeList(List<SOC0151Info> gradeList) {
		this.gradeList = gradeList;
	}

	/**
	 * 风险级别集合获取取得
	 * @return levelList 风险级别集合获取
	 */
	public List<SOC0151Info> getLevelList() {
		return levelList;
	}

	/**
	 * 标识能看见不取得
	 * @return identyFlag 标识能看见不
	 */
	public String getIdentyFlag() {
		return identyFlag;
	}

	/**
	 * 标识能看见不设定
	 * @param identyFlag 标识能看见不
	 */
	public void setIdentyFlag(String identyFlag) {
		this.identyFlag = identyFlag;
	}

	/**
	 * 风险级别集合获取设定
	 * @param levelList 风险级别集合获取
	 */
	public void setLevelList(List<SOC0151Info> levelList) {
		this.levelList = levelList;
	}

	/**
	 * 风险点可能性取得
	 * @return possibleList 风险点可能性
	 */
	public List<SOC0151Info> getPossibleList() {
		return possibleList;
	}

	/**
	 * 风险点可能性设定
	 * @param possibleList 风险点可能性
	 */
	public void setPossibleList(List<SOC0151Info> possibleList) {
		this.possibleList = possibleList;
	}

	/**
	 * 风险标识集合取得
	 * @return signList 风险标识集合
	 */
	public List<SOC0151Info> getSignList() {
		return signList;
	}

	/**
	 * 风险标识集合设定
	 * @param signList 风险标识集合
	 */
	public void setSignList(List<SOC0151Info> signList) {
		this.signList = signList;
	}

	/**
	 * 风险点查询集合取得
	 * @return riskList 风险点查询集合
	 */
	public List<RiskPointVMInfo> getRiskList() {
		return riskList;
	}

	/**
	 * 风险点查询集合设定
	 * @param riskList 风险点查询集合
	 */
	public void setRiskList(List<RiskPointVMInfo> riskList) {
		this.riskList = riskList;
	}

	/**
	 * 风险点主键取得
	 * @return eiid 风险点主键
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * 风险点主键设定
	 * @param eiid 风险点主键
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * 风险点查询取得
	 * @return igasm2713Form 风险点查询
	 */
	public IGASM2713Form getIgasm2713Form() {
		return igasm2713Form;
	}

	/**
	 * 风险点查询设定
	 * @param igasm2713Form 风险点查询
	 */
	public void setIgasm2713Form(IGASM2713Form igasm2713Form) {
		this.igasm2713Form = igasm2713Form;
	}

}


