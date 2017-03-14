package com.deliverik.infogovernor.soc.cim.dto;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.asset.model.IG545Bean;
import com.deliverik.framework.asset.model.IG545Info;
import com.deliverik.framework.asset.model.IG612Info;
import com.deliverik.framework.asset.model.condition.IG545SearchCond;
import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.soc.asset.model.SOC0109Info;
import com.deliverik.framework.soc.asset.model.SOC0117Info;
import com.deliverik.framework.soc.asset.model.SOC0151Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0109SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0117SearchCond;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.asset.form.IGASM0114Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0401Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0402Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0404Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0408Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0409Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0410Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0411Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM1202Form;

/**
 * 资产配置模型管理业务用DTO
 * 
 */
@SuppressWarnings("serial")
public class IGCIM04DTO extends BaseDTO implements Serializable{

	/** 资产信息检索条件 */
	protected SOC0117SearchCond entitySearchCond;
	
	/** 取值范围信息检索结果集 */
	protected List<SOC0151Info> ccdList;
	
	/** 机构信息检索结果集 */
	protected List<Organization> orglist;
	
	/** 用户信息检索结果集 */
	protected List<User> userlist;

	/** 资产一级模型信息检索结果集 */
	protected List<SOC0117Info> topEntityList;
	
	/** 资产信息检索结果集 */
	protected List<SOC0117Info> entityList;

	/** 资产信息最大检索件数 */
	protected int maxSearchCount;

	/** 分页用DTO */
	protected PagingDTO pagingDto;

	/** 登记资产信息 */
	protected SOC0117Info entity;

	/** 登记资产配置信息 */
	protected SOC0109Info configuration;

	/** 资产配置信息检索条件 */
	protected SOC0109SearchCond configurationSearchCond;
	
	/** 资产配置信息检索结果集 */
	protected List<SOC0109Info> configurationList;
	
	/** 资产配置信息检索结果集 */
	Map<String,List<SOC0109Info>> configurationMap;
	
	/** 资产信息删除对象 */
	protected String[] deleteEntity;

	/** 资产配置信息删除对象 */
	protected String[] deleteConfiguration;
	
	/** 变更用资产配置信息 */
	protected IGCIM0404Form igcim0404Form;

	/** 变更用资产基本信息 */
	protected IGCIM0402Form igcim0402Form;
	
	protected IGCIM0410Form igcim0410Form;
	
	protected IGCIM0411Form igcim0411Form;
	
	protected IGCIM0409Form igcim0409Form;

	protected String flag;
	
	/** 查询用资产基本信息 */
	protected IGCIM0401Form igcim0401Form;
	
	protected IGCIM1202Form igcim1202Form;
	
	/** 资产模型状态 1启用 0停用 */
	protected String estatus;

	/** 资产下拉数据标识列表 */
	protected List<IG545Bean> configurationCodeDetailBeanList;
	
	protected List<IG545Info> ConfigurationCodeDetailList;
	
	protected String esyscoding;
	
	/** 资产属性默认值编辑Form */
	protected IGASM0114Form igASM0114Form;
	
	/** 资产配置信息检索结果集 */
	protected List<Map<String,List<SOC0109Info>>> configurationMapList;
	
	/** 资产属性默认值集合 */
	protected Map<String,List<IG612Info>> map_IG612Info;
	
	/** 资产大类别标识集合 */
	protected List<CodeDetail> types1;
	
	/** 资产小类别标识集合 */
	protected List<CodeDetail> types2;
	
	protected String stopFlag;
	
	protected String startFlag;
	
	public String getStopFlag() {
		return stopFlag;
	}

	public void setStopFlag(String stopFlag) {
		this.stopFlag = stopFlag;
	}

	public String getStartFlag() {
		return startFlag;
	}

	public void setStartFlag(String startFlag) {
		this.startFlag = startFlag;
	}


	/**数据信息树*/
	protected Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
	
	
	public Map<String, TreeNode> getTreeNodeMap() {
		return treeNodeMap;
	}

	public void setTreeNodeMap(Map<String, TreeNode> treeNodeMap) {
		this.treeNodeMap = treeNodeMap;
	}

	public List<CodeDetail> getTypes1() {
		return types1;
	}

	public void setTypes1(List<CodeDetail> types1) {
		this.types1 = types1;
	}

	public List<CodeDetail> getTypes2() {
		return types2;
	}

	public void setTypes2(List<CodeDetail> types2) {
		this.types2 = types2;
	}

	public List<Map<String, List<SOC0109Info>>> getConfigurationMapList() {
		return configurationMapList;
	}

	public void setConfigurationMapList(
			List<Map<String, List<SOC0109Info>>> configurationMapList) {
		this.configurationMapList = configurationMapList;
	}

	public List<User> getUserlist() {
		return userlist;
	}

	public void setUserlist(List<User> userlist) {
		this.userlist = userlist;
	}

	/**
	 * @return the ccdList
	 */
	public List<SOC0151Info> getCcdList() {
		return ccdList;
	}

	/**
	 * @param ccdList the ccdList to set
	 */
	public void setCcdList(List<SOC0151Info> ccdList) {
		this.ccdList = ccdList;
	}

	/**
	 * @return the orglist
	 */
	public List<Organization> getOrglist() {
		return orglist;
	}

	/**
	 * @param orglist the orglist to set
	 */
	public void setOrglist(List<Organization> orglist) {
		this.orglist = orglist;
	}

	/**
	 * @return the topEntityList
	 */
	public List<SOC0117Info> getTopEntityList() {
		return topEntityList;
	}

	/**
	 * @param topEntityList the topEntityList to set
	 */
	public void setTopEntityList(List<SOC0117Info> topEntityList) {
		this.topEntityList = topEntityList;
	}

	public String getEsyscoding() {
		return esyscoding;
	}

	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	public List<IG545Info> getConfigurationCodeDetailList() {
		return ConfigurationCodeDetailList;
	}

	public IGCIM0409Form getIgcim0409Form() {
		return igcim0409Form;
	}

	public void setIgcim0409Form(IGCIM0409Form igcim0409Form) {
		this.igcim0409Form = igcim0409Form;
	}

	public String getFlag() {
		return flag;
	}

	
	public IGCIM0411Form getIgcim0411Form() {
		return igcim0411Form;
	}

	public void setIgcim0411Form(IGCIM0411Form igcim0411Form) {
		this.igcim0411Form = igcim0411Form;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public void setConfigurationCodeDetailList(
			List<IG545Info> configurationCodeDetailList) {
		ConfigurationCodeDetailList = configurationCodeDetailList;
	}

	
	public IGCIM0410Form getIgcim0410Form() {
		return igcim0410Form;
	}

	public void setIgcim0410Form(IGCIM0410Form igcim0410Form) {
		this.igcim0410Form = igcim0410Form;
	}


	/** 资产下拉数据基本信息 */
	protected IGCIM0408Form igcim0408Form;
	
	/** 资产下拉数据信息 */
	protected IG545Info configurationcodedetail;
	
	/** 资产下拉数据信息 */
	protected IG545SearchCond configurationcodedetailsearchcond;
	/**
	 * 每级模型是否显示停用按钮
	 */
	
	protected  Map<String,String> stopbuttonMap;
	
	/**
	 * 每级模型是否显示启用按钮
	 */
	
	protected  Map<String,String> startbuttonMap;
	
	/** 资产模型属性状态 1启用 2停用 */
	protected String cstatus;
	
	/** 资产模型属性id */
	protected String cid;
	
	/** 资产模型id */
	protected String eid;
	
	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	public IG545SearchCond getConfigurationcodedetailsearchcond() {
		return configurationcodedetailsearchcond;
	}

	public void setConfigurationcodedetailsearchcond(
			IG545SearchCond configurationcodedetailsearchcond) {
		this.configurationcodedetailsearchcond = configurationcodedetailsearchcond;
	}

	public IG545Info getConfigurationcodedetail() {
		return configurationcodedetail;
	}

	public void setConfigurationcodedetail(
			IG545Info configurationcodedetail) {
		this.configurationcodedetail = configurationcodedetail;
	}

	
	public IGCIM0408Form getIgcim0408Form() {
		return igcim0408Form;
	}

	public void setIgcim0408Form(IGCIM0408Form igcim0408Form) {
		this.igcim0408Form = igcim0408Form;
	}

	public String getCstatus() {
		return cstatus;
	}

	public void setCstatus(String cstatus) {
		this.cstatus = cstatus;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public Map<String, String> getStopbuttonMap() {
		return stopbuttonMap;
	}

	public void setStopbuttonMap(Map<String, String> stopbuttonMap) {
		this.stopbuttonMap = stopbuttonMap;
	}

	public Map<String, String> getStartbuttonMap() {
		return startbuttonMap;
	}

	public void setStartbuttonMap(Map<String, String> startbuttonMap) {
		this.startbuttonMap = startbuttonMap;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	
	public IGCIM0401Form getIgcim0401Form() {
		return igcim0401Form;
	}

	public void setIgcim0401Form(IGCIM0401Form igcim0401Form) {
		this.igcim0401Form = igcim0401Form;
	}

	/**
	 * 资产信息检索条件取得
	 * @return 资产信息检索条件
	 */
	public SOC0117SearchCond getEntitySearchCond() {
	    return this.entitySearchCond;
	}

	/**
	 * 资产信息检索条件设定
	 *
	 * @param entitySearchCond 资产信息检索条件
	 */
	public void setEntitySearchCond(SOC0117SearchCond entitySearchCond) {
	    this.entitySearchCond = entitySearchCond;
	}

	/**
	 * 资产信息检索结果集取得
	 * @return 资产信息检索结果集
	 */
	public List<SOC0117Info> getEntityList() {
		return entityList;
	}

	/**
	 * 资产信息检索结果集设定
	 *
	 * @param entityList 资产信息检索结果集
	 */
	public void setEntityList(List<SOC0117Info> entityList) {
		this.entityList = entityList;
	}

	/**
	 * 资产信息最大检索件数取得
	 * @return 资产信息最大检索件数
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * 资产信息最大检索件数设定
	 * 
	 * @param maxSearchCount 资产信息最大检索件数
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * 分页用DTO取得
	 * @return 分页用DTO
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}


	/**
	 * 分页用DTO设定
	 * 
	 * @param pagingDto 分页用DTO
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * 登记资产信息取得
	 * @return 登记资产信息
	 */
	public SOC0117Info getEntity() {
		return entity;
	}

	/**
	 * 登记资产信息设定
	 * 
	 * @param entity 登记资产信息
	 */
	public void setEntity(SOC0117Info entity) {
		this.entity = entity;
	}

	/**
	 * 登记资产配置信息取得
	 * @return 登记资产配置信息
	 */
	public SOC0109Info getConfiguration() {
		return configuration;
	}

	/**
	 * 登记资产配置信息设定
	 * 
	 * @param configuration 登记资产配置信息
	 */
	public void setConfiguration(SOC0109Info configuration) {
		this.configuration = configuration;
	}

	/**
	 * 资产配置信息检索条件取得
	 * @return 资产配置信息检索条件
	 */
	public SOC0109SearchCond getConfigurationSearchCond() {
		return configurationSearchCond;
	}

	/**
	 * 资产配置信息检索条件设定
	 * 
	 * @param configurationSearchCond 资产配置信息检索条件
	 */
	public void setConfigurationSearchCond(
			SOC0109SearchCond configurationSearchCond) {
		this.configurationSearchCond = configurationSearchCond;
	}

	/**
	 * 资产配置信息检索结果集取得
	 * @return 资产配置信息检索结果集
	 */
	public List<SOC0109Info> getConfigurationList() {
		return configurationList;
	}

	/**
	 * 资产配置信息检索结果集设定
	 * 
	 * @param configurationList 资产配置信息检索结果集
	 */
	public void setConfigurationList(List<SOC0109Info> configurationList) {
		this.configurationList = configurationList;
	}

	/**
	 * 资产信息删除对象取得
	 * @return 资产信息删除对象
	 */
	public String[] getDeleteEntity() {
		return deleteEntity;
	}

	/**
	 * 资产信息删除对象设定
	 * 
	 * @param deleteEntity 资产信息删除对象
	 */
	public void setDeleteEntity(String[] deleteEntity) {
		this.deleteEntity = deleteEntity;
	}

	/**
	 * 资产配置信息删除对象取得
	 * @return 资产配置信息删除对象
	 */
	public String[] getDeleteConfiguration() {
		return deleteConfiguration;
	}

	/**
	 * 资产配置信息删除对象设定
	 * 
	 * @param deleteConfiguration 资产配置信息删除对象
	 */
	public void setDeleteConfiguration(String[] deleteConfiguration) {
		this.deleteConfiguration = deleteConfiguration;
	}

	/**
	 * 变更用资产配置信息取得
	 * @return 变更用资产配置信息
	 */
	public IGCIM0404Form getIgcim0404Form() {
		return igcim0404Form;
	}
	
	/**
	 * 变更用资产配置信息设定
	 * 
	 * @param igasm0104Form 变更用资产配置信息
	 */
	public void setIgcim0404Form(IGCIM0404Form igcim0404Form) {
		this.igcim0404Form = igcim0404Form;
	}
	
	
	/**
	 * 变更用资产基本信息取得
	 * @return 变更用资产基本信息
	 */
	public IGCIM0402Form getIgcim0402Form() {
		return igcim0402Form;
	}

	/**
	 * 变更用资产基本信息设定
	 * 
	 * @param igasm0102Form 变更用资产基本信息
	 */
	public void setIgcim0402Form(IGCIM0402Form igcim0402Form) {
		this.igcim0402Form = igcim0402Form;
	}
	
	/**
	 * 资产配置信息检索结果集取得
	 * @return 资产配置信息检索结果集
	 */
	public Map<String, List<SOC0109Info>> getConfigurationMap() {
		return configurationMap;
	}

	/**
	 * 资产配置信息检索结果集设定
	 * 
	 * @param configurationMap 资产配置信息检索结果集
	 */
	public void setConfigurationMap(
			Map<String, List<SOC0109Info>> configurationMap) {
		this.configurationMap = configurationMap;
	}

	/**
	 * 资产下拉数据标识列表取得
	 * @return 资产下拉数据标识列表结果集
	 */
	public List<IG545Bean> getConfigurationCodeDetailBeanList() {
		return configurationCodeDetailBeanList;
	}

	/**
	 * 资产下拉数据标识列表设定
	 * 
	 * @param configurationCodeDetailBeanList 资产下拉数据标识列表
	 */
	public void setConfigurationCodeDetailBeanList(
			List<IG545Bean> configurationCodeDetailBeanList) {
		this.configurationCodeDetailBeanList = configurationCodeDetailBeanList;
	}

	/**
	 * 资产属性默认值编辑Form取得
	 * 
	 * @return 资产属性默认值编辑Form
	 */
	public IGASM0114Form getIgASM0114Form() {
		return igASM0114Form;
	}

	/**
	 * 资产属性默认值编辑Form设定
	 * 
	 * @param igASM0114Form 资产属性默认值编辑Form
	 */
	public void setIgASM0114Form(IGASM0114Form igASM0114Form) {
		this.igASM0114Form = igASM0114Form;
	}

	/**
	 * 资产属性默认值集合取得
	 * 
	 * @return 资产属性默认值集合
	 */
	public Map<String, List<IG612Info>> getMap_IG612Info() {
		return map_IG612Info;
	}

	/**
	 * 资产属性默认值集合设定
	 * 
	 * @param map_IG612Info 资产属性默认值集合
	 */
	public void setMap_IG612Info(Map<String, List<IG612Info>> map_IG612Info) {
		this.map_IG612Info = map_IG612Info;
	}

	public IGCIM1202Form getIgcim1202Form() {
		return igcim1202Form;
	}

	public void setIgcim1202Form(IGCIM1202Form igcim1202Form) {
		this.igcim1202Form = igcim1202Form;
	}
	
}


