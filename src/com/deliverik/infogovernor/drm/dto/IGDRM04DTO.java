/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.drm.dto;


import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.asset.model.IG612Info;
import com.deliverik.framework.asset.model.condition.IG545SearchCond;
import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.model.ConfigurationCodeDetailBean;
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.soc.asset.model.SOC0109Info;
import com.deliverik.framework.soc.asset.model.SOC0109VWInfo;
import com.deliverik.framework.soc.asset.model.SOC0117Info;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.SOC0118VWInfo;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.SOC0128Info;
import com.deliverik.framework.soc.asset.model.SOC0129Info;
import com.deliverik.framework.soc.asset.model.SOC0151Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0109SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0117SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.drm.form.IGDRM0401Form;
import com.deliverik.infogovernor.drm.form.IGDRM0402Form;
import com.deliverik.infogovernor.drm.form.IGDRM0404Form;
import com.deliverik.infogovernor.drm.form.IGDRM0411Form;
import com.deliverik.infogovernor.drm.form.IGDRM0412Form;
import com.deliverik.infogovernor.drm.form.IGDRM0414Form;
import com.deliverik.infogovernor.drm.form.IGDRM0418Form;
import com.deliverik.infogovernor.drm.form.IGDRM0419Form;
import com.deliverik.infogovernor.drm.form.IGDRM0420Form;
import com.deliverik.infogovernor.drm.form.IGDRM0421Form;
import com.deliverik.infogovernor.drm.form.IGDRM0424Form;
import com.deliverik.infogovernor.drm.form.IGDRM0430Form;
import com.deliverik.infogovernor.drm.model.EmergencyResourceInfo;


/**
 * 应急资源管理DTO
 * @author 张剑
 *
 * 2015-2-11 下午3:27:58
 */
public class IGDRM04DTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	
	/**
	 * */
	protected IGDRM0401Form igdrm0401Form ;
	protected IGDRM0402Form igdrm0402Form ;
	protected IGDRM0404Form igdrm0404Form;
	/** 应急资源属性查看Form */
	protected IGDRM0430Form igdrm0430Form;
	
	protected Integer eiid;
	protected Integer eiversion;
	protected Integer ciid;
	
	protected int maxSearchCount;

	protected User user;
	
	protected List<SOC0109VWInfo> configurationList;
	
	protected SOC0118VWInfo entityItemInfo;
	
	protected List<SOC0118VWInfo> entityVWItemList;
	
	protected String inJiguiFlg;  //设备是否已上架标志位
	
	/** ajax返回结果 */
	protected String ajaxResult;
	
	/**
	 * @return the igdrm0430Form
	 */
	public IGDRM0430Form getIgdrm0430Form() {
		return igdrm0430Form;
	}


	/**
	 * @param igdrm0430Form the igdrm0430Form to set
	 */
	public void setIgdrm0430Form(IGDRM0430Form igdrm0430Form) {
		this.igdrm0430Form = igdrm0430Form;
	}


	/**
	 * @param entityVWItemList the entityVWItemList to set
	 */
	public void setEntityVWItemList(List<SOC0118VWInfo> entityVWItemList) {
		this.entityVWItemList = entityVWItemList;
	}


	/**
	 * @return the entityVWItemList
	 */
	public List<SOC0118VWInfo> getEntityVWItemList() {
		return entityVWItemList;
	}


	protected List<SOC0118Info> entityItemList;
	
	protected List<SOC0107Info> entityItemConfigurations;
	
	protected SOC0118VWInfo entityItemVW;
	
	protected List<SOC0129Info> configItemList;
	
	protected String eilabel;
	
	protected String rootEsyscoding;
	
	/** 页面显示树Map */
	protected Hashtable<String, TreeNode> nodeMap;
	/** 分页用DTO */
	protected PagingDTO pagingDto;
	
	protected String eiorgname;
	
	protected boolean flag;
	
	protected Map<String,List<SOC0129Info>> configItemVWInfoMap;
	
	protected String esyscoding;
	
	/** 资产版本列表 */
	protected List<SOC0128Info> configItemVersionTime;
	
	/** 应急资产删除对象 */
	protected String[] deleteEntityItem;
	
	/** 设备资产所属区域*/
	protected String area;

	/** 设备配置信息画面设备信息 */
	protected SOC0118VWInfo entityItemVWInfo;
	
	/**
	 * @return the entityItemVWInfo
	 */
	public SOC0118VWInfo getEntityItemVWInfo() {
		return entityItemVWInfo;
	}


	/**
	 * @param entityItemVWInfo the entityItemVWInfo to set
	 */
	public void setEntityItemVWInfo(SOC0118VWInfo entityItemVWInfo) {
		this.entityItemVWInfo = entityItemVWInfo;
	}


	/**
	 * @return the configItemVersionTime
	 */
	public List<SOC0128Info> getConfigItemVersionTime() {
		return configItemVersionTime;
	}


	/**
	 * @param configItemVersionTime the configItemVersionTime to set
	 */
	public void setConfigItemVersionTime(List<SOC0128Info> configItemVersionTime) {
		this.configItemVersionTime = configItemVersionTime;
	}


	/**
	 * @return the inJiguiFlg
	 */
	public String getInJiguiFlg() {
		return inJiguiFlg;
	}


	/**
	 * @param inJiguiFlg the inJiguiFlg to set
	 */
	public void setInJiguiFlg(String inJiguiFlg) {
		this.inJiguiFlg = inJiguiFlg;
	}


	/** 关联设备对象 */
	protected String[] relationEiid;
	
	
	/**
	 * @return the relationEiid
	 */
	public String[] getRelationEiid() {
		return relationEiid;
	}
	/**
	 * @param relationEiid the relationEiid to set
	 */
	public void setRelationEiid(String[] relationEiid) {
		this.relationEiid = relationEiid;
	}


	/**
	 * 应急资源
	 */
	protected SOC0124Info soc0124Info;
	
	protected List<SOC0124Info> soc0124List;
	
	protected String ename;
	
	protected String Sp_eiid;
	/**
	 * 属性名称Map
	 */
	protected  Map<String, List<SOC0129Info>>  soc0129InfoVWMap;
	
	/** 取值范围下拉数据 */
	protected Map<Integer, List<LabelValueBean>> selectedListMap = new HashMap<Integer, List<LabelValueBean>>();
	

	/** 设备信息检索条件 */
	protected SOC0124SearchCond entityItemVWSearchCond;

	/** 设备检索结果 */
	protected List<SOC0118VWInfo> entityItemVWInfoList;
	
	/**
	 * 取值范围下拉数据取得
	 * @return 取值范围下拉数据
	 */
	public List<LabelValueBean> getSelectedListMap(int index) {
		return (List<LabelValueBean>) selectedListMap.get( new Integer( index ) );
	}
	/**
	 * 取值范围下拉数据取得
	 * @return 取值范围下拉数据
	 */
	public Map<Integer, List<LabelValueBean>> getSelectedListMap() {
		return selectedListMap;
	}
	/**
	 * 取值范围下拉数据设定
	 *
	 * @param selectedList 取值范围下拉数据
	 */
	public void setSelectedListMap(int index,List<LabelValueBean> selectedList) {
		selectedListMap.put(new Integer(index), selectedList);
	}
	/**
	 * pagingDto   取得
	 * @return pagingDto pagingDto
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * pagingDto   设定
	 * @param pagingDto pagingDto
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * igdrm0401Form   取得
	 * @return igdrm0401Form igdrm0401Form
	 */
	public IGDRM0401Form getIgdrm0401Form() {
		return igdrm0401Form;
	}

	/**
	 * igdrm0401Form   设定
	 * @param igdrm0401Form igdrm0401Form
	 */
	public void setIgdrm0401Form(IGDRM0401Form igdrm0401Form) {
		this.igdrm0401Form = igdrm0401Form;
	}

	/**
	 * maxSearchCount   取得
	 * @return maxSearchCount maxSearchCount
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * maxSearchCount   设定
	 * @param maxSearchCount maxSearchCount
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * user   取得
	 * @return user user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * user   设定
	 * @param user user
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * configurationList   取得
	 * @return configurationList configurationList
	 */
	public List<SOC0109VWInfo> getConfigurationList() {
		return configurationList;
	}

	/**
	 * configurationList   设定
	 * @param configurationList configurationList
	 */
	public void setConfigurationList(List<SOC0109VWInfo> configurationList) {
		this.configurationList = configurationList;
	}

	/**
	 * entityItemInfo   取得
	 * @return entityItemInfo entityItemInfo
	 */
	public SOC0118VWInfo getEntityItemInfo() {
		return entityItemInfo;
	}

	/**
	 * entityItemInfo   设定
	 * @param entityItemInfo entityItemInfo
	 */
	public void setEntityItemInfo(SOC0118VWInfo entityItemInfo) {
		this.entityItemInfo = entityItemInfo;
	}

	/**
	 * entityItemConfigurations   取得
	 * @return entityItemConfigurations entityItemConfigurations
	 */
	public List<SOC0107Info> getEntityItemConfigurations() {
		return entityItemConfigurations;
	}

	/**
	 * eilabel   取得
	 * @return eilabel eilabel
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * eilabel   设定
	 * @param eilabel eilabel
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * entityItemConfigurations   设定
	 * @param entityItemConfigurations entityItemConfigurations
	 */
	public void setEntityItemConfigurations(
			List<SOC0107Info> entityItemConfigurations) {
		this.entityItemConfigurations = entityItemConfigurations;
	}

	/**
	 * igdrm0402Form   取得
	 * @return igdrm0402Form igdrm0402Form
	 */
	public IGDRM0402Form getIgdrm0402Form() {
		return igdrm0402Form;
	}

	/**
	 * igdrm0402Form   设定
	 * @param igdrm0402Form igdrm0402Form
	 */
	public void setIgdrm0402Form(IGDRM0402Form igdrm0402Form) {
		this.igdrm0402Form = igdrm0402Form;
	}

	/**
	 * entityItemList   取得
	 * @return entityItemList entityItemList
	 */
	public List<SOC0118Info> getEntityItemList() {
		return entityItemList;
	}

	/**
	 * entityItemList   设定
	 * @param entityItemList entityItemList
	 */
	public void setEntityItemList(List<SOC0118Info> entityItemList) {
		this.entityItemList = entityItemList;
	}

	/**
	 * nodeMap   取得
	 * @return nodeMap nodeMap
	 */
	public Hashtable<String, TreeNode> getNodeMap() {
		return nodeMap;
	}

	/**
	 * nodeMap   设定
	 * @param nodeMap nodeMap
	 */
	public void setNodeMap(Hashtable<String, TreeNode> nodeMap) {
		this.nodeMap = nodeMap;
	}

	/**
	 * rootEsyscoding   取得
	 * @return rootEsyscoding rootEsyscoding
	 */
	public String getRootEsyscoding() {
		return rootEsyscoding;
	}

	/**
	 * rootEsyscoding   设定
	 * @param rootEsyscoding rootEsyscoding
	 */
	public void setRootEsyscoding(String rootEsyscoding) {
		this.rootEsyscoding = rootEsyscoding;
	}

	/**
	 * entityItemVW   取得
	 * @return entityItemVW entityItemVW
	 */
	public SOC0118VWInfo getEntityItemVW() {
		return entityItemVW;
	}

	/**
	 * entityItemVW   设定
	 * @param entityItemVW entityItemVW
	 */
	public void setEntityItemVW(SOC0118VWInfo entityItemVW) {
		this.entityItemVW = entityItemVW;
	}

	/**
	 * configItemList   取得
	 * @return configItemList configItemList
	 */
	public List<SOC0129Info> getConfigItemList() {
		return configItemList;
	}

	/**
	 * configItemList   设定
	 * @param configItemList configItemList
	 */
	public void setConfigItemList(List<SOC0129Info> configItemList) {
		this.configItemList = configItemList;
	}

	/**
	 * igdrm0404Form   取得
	 * @return igdrm0404Form igdrm0404Form
	 */
	public IGDRM0404Form getIgdrm0404Form() {
		return igdrm0404Form;
	}

	/**
	 * igdrm0404Form   设定
	 * @param igdrm0404Form igdrm0404Form
	 */
	public void setIgdrm0404Form(IGDRM0404Form igdrm0404Form) {
		this.igdrm0404Form = igdrm0404Form;
	}

	/**
	 * eiorgname   取得
	 * @return eiorgname eiorgname
	 */
	public String getEiorgname() {
		return eiorgname;
	}

	/**
	 * eiorgname   设定
	 * @param eiorgname eiorgname
	 */
	public void setEiorgname(String eiorgname) {
		this.eiorgname = eiorgname;
	}

	/**
	 * @return the area
	 */
	public String getArea() {
		return area;
	}


	/**
	 * @param area the area to set
	 */
	public void setArea(String area) {
		this.area = area;
	}


	/**
	 * flag   取得
	 * @return flag flag
	 */
	public boolean getFlag() {
		return flag;
	}

	/**
	 * flag   设定
	 * @param flag flag
	 */
	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	/**
	 * configItemVWInfoMap   取得
	 * @return configItemVWInfoMap configItemVWInfoMap
	 */
	public Map<String, List<SOC0129Info>> getConfigItemVWInfoMap() {
		return configItemVWInfoMap;
	}

	/**
	 * configItemVWInfoMap   设定
	 * @param configItemVWInfoMap configItemVWInfoMap
	 */
	public void setConfigItemVWInfoMap(
			Map<String, List<SOC0129Info>> configItemVWInfoMap) {
		this.configItemVWInfoMap = configItemVWInfoMap;
	}

	/**
	 * esyscoding   取得
	 * @return esyscoding esyscoding
	 */
	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * esyscoding   设定
	 * @param esyscoding esyscoding
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	/**
	 * deleteEntityItem   取得
	 * @return deleteEntityItem deleteEntityItem
	 */
	public String[] getDeleteEntityItem() {
		return deleteEntityItem;
	}

	/**
	 * deleteEntityItem   设定
	 * @param deleteEntityItem deleteEntityItem
	 */
	public void setDeleteEntityItem(String[] deleteEntityItem) {
		this.deleteEntityItem = deleteEntityItem;
	}

	/**
	 * eiid   取得
	 * @return eiid eiid
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * eiid   设定
	 * @param eiid eiid
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * eiversion   取得
	 * @return eiversion eiversion
	 */
	public Integer getEiversion() {
		return eiversion;
	}

	/**
	 * eiversion   设定
	 * @param eiversion eiversion
	 */
	public void setEiversion(Integer eiversion) {
		this.eiversion = eiversion;
	}

	/**
	 * ciid   取得
	 * @return ciid ciid
	 */
	public Integer getCiid() {
		return ciid;
	}

	/**
	 * ciid   设定
	 * @param ciid ciid
	 */
	public void setCiid(Integer ciid) {
		this.ciid = ciid;
	}
	
	
	//资产分类维护
	/** 资产信息检索条件 */
	protected SOC0117SearchCond entitySearchCond;
	
	/** 取值范围信息检索结果集 */
	protected List<SOC0151Info> ccdList;
	
	/** 机构信息检索结果集 */
	protected List<Organization> orglist;
	
	/** 用户信息检索结果集 */
	protected List<User> userlist;

	/** 资产一级分类信息检索结果集 */
	protected List<SOC0117Info> topEntityList;
	
	/** 资产信息检索结果集 */
	protected List<SOC0117Info> entityList;

	/** 登记资产信息 */
	protected SOC0117Info entity;

	/** 登记资产配置信息 */
	protected SOC0109Info configuration;

	/** 资产配置信息检索条件 */
	protected SOC0109SearchCond configurationSearchCond;
	
	/** 资产配置信息检索结果集 */
	Map<String,List<SOC0109Info>> configurationMap;
	
	/** 资产信息删除对象 */
	protected String[] deleteEntity;

	/** 资产配置信息删除对象 */
	protected String[] deleteConfiguration;
	
	/** 变更用资产配置信息 */
	protected IGDRM0414Form igdrm0414Form;
	/** 变更用资产基本信息 */
	protected IGDRM0412Form igdrm0412Form;
	
	protected IGDRM0420Form igdrm0420Form;
	
	protected IGDRM0421Form igdrm0421Form;
	
	protected IGDRM0419Form igdrm0419Form;
	
	/** 查询用资产基本信息 */
	protected IGDRM0411Form igdrm0411Form;
	
	/** 资产分类状态 1启用 0停用 */
	protected String estatus;

	/** 资产下拉数据标识列表 */
	protected List<ConfigurationCodeDetailBean> configurationCodeDetailBeanList;
	
	protected List<SOC0151Info> ConfigurationCodeDetailList;
	
	/** 资产属性默认值编辑Form */
	protected IGDRM0424Form igDRM0424Form;
	
	/** 资产配置信息检索结果集 */
	protected List<Map<String,List<SOC0109Info>>> configurationMapList;
	
	/** 资产属性默认值集合 */
	protected Map<String,List<IG612Info>> map_IG612Info;
	
	protected String strflag;
	
	/** 应急资源信息检索结果集 */
	protected List<EmergencyResourceInfo> erEntityList;
	 

	/** 资产下拉数据基本信息 */
	protected IGDRM0418Form igdrm0418Form;
	
	/** 资产下拉数据信息 */
	protected SOC0151Info configurationcodedetail;
	
	/** 资产下拉数据信息 */
	protected IG545SearchCond configurationcodedetailsearchcond;
	/**
	 * 每级分类是否显示停用按钮
	 */
	
	protected  Map<String,String> stopbuttonMap;
	
	/**
	 * 每级分类是否显示启用按钮
	 */
	
	protected  Map<String,String> startbuttonMap;
	
	/** 资产分类属性状态 1启用 2停用 */
	protected String cstatus;
	
	/** 资产分类属性id */
	protected String cid;

	/**
	 * @return the soc0124Info
	 */
	public SOC0124Info getSoc0124Info() {
		return soc0124Info;
	}


	/**
	 * @param soc0124Info the soc0124Info to set
	 */
	public void setSoc0124Info(SOC0124Info soc0124Info) {
		this.soc0124Info = soc0124Info;
	}


	/**
	 * @return the soc0124List
	 */
	public List<SOC0124Info> getSoc0124List() {
		return soc0124List;
	}


	/**
	 * @param soc0124List the soc0124List to set
	 */
	public void setSoc0124List(List<SOC0124Info> soc0124List) {
		this.soc0124List = soc0124List;
	}


	/**
	 * @return the ename
	 */
	public String getEname() {
		return ename;
	}


	/**
	 * @param ename the ename to set
	 */
	public void setEname(String ename) {
		this.ename = ename;
	}


	/**
	 * @return the sp_eiid
	 */
	public String getSp_eiid() {
		return Sp_eiid;
	}


	/**
	 * @param sp_eiid the sp_eiid to set
	 */
	public void setSp_eiid(String sp_eiid) {
		Sp_eiid = sp_eiid;
	}


	/**
	 * @return the soc0129InfoVWMap
	 */
	public Map<String, List<SOC0129Info>> getSoc0129InfoVWMap() {
		return soc0129InfoVWMap;
	}


	/**
	 * @param soc0129InfoVWMap the soc0129InfoVWMap to set
	 */
	public void setSoc0129InfoVWMap(Map<String, List<SOC0129Info>> soc0129InfoVWMap) {
		this.soc0129InfoVWMap = soc0129InfoVWMap;
	}


	/**
	 * @return the entityItemVWSearchCond
	 */
	public SOC0124SearchCond getEntityItemVWSearchCond() {
		return entityItemVWSearchCond;
	}


	/**
	 * @param entityItemVWSearchCond the entityItemVWSearchCond to set
	 */
	public void setEntityItemVWSearchCond(SOC0124SearchCond entityItemVWSearchCond) {
		this.entityItemVWSearchCond = entityItemVWSearchCond;
	}


	/**
	 * @return the entityItemVWInfoList
	 */
	public List<SOC0118VWInfo> getEntityItemVWInfoList() {
		return entityItemVWInfoList;
	}


	/**
	 * @param entityItemVWInfoList the entityItemVWInfoList to set
	 */
	public void setEntityItemVWInfoList(List<SOC0118VWInfo> entityItemVWInfoList) {
		this.entityItemVWInfoList = entityItemVWInfoList;
	}


	/**
	 * @return the entitySearchCond
	 */
	public SOC0117SearchCond getEntitySearchCond() {
		return entitySearchCond;
	}


	/**
	 * @param entitySearchCond the entitySearchCond to set
	 */
	public void setEntitySearchCond(SOC0117SearchCond entitySearchCond) {
		this.entitySearchCond = entitySearchCond;
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
	 * @return the userlist
	 */
	public List<User> getUserlist() {
		return userlist;
	}


	/**
	 * @param userlist the userlist to set
	 */
	public void setUserlist(List<User> userlist) {
		this.userlist = userlist;
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


	/**
	 * @return the entityList
	 */
	public List<SOC0117Info> getEntityList() {
		return entityList;
	}


	/**
	 * @param entityList the entityList to set
	 */
	public void setEntityList(List<SOC0117Info> entityList) {
		this.entityList = entityList;
	}


	/**
	 * @return the entity
	 */
	public SOC0117Info getEntity() {
		return entity;
	}


	/**
	 * @param entity the entity to set
	 */
	public void setEntity(SOC0117Info entity) {
		this.entity = entity;
	}


	/**
	 * @return the configuration
	 */
	public SOC0109Info getConfiguration() {
		return configuration;
	}


	/**
	 * @param configuration the configuration to set
	 */
	public void setConfiguration(SOC0109Info configuration) {
		this.configuration = configuration;
	}


	/**
	 * @return the configurationSearchCond
	 */
	public SOC0109SearchCond getConfigurationSearchCond() {
		return configurationSearchCond;
	}


	/**
	 * @param configurationSearchCond the configurationSearchCond to set
	 */
	public void setConfigurationSearchCond(SOC0109SearchCond configurationSearchCond) {
		this.configurationSearchCond = configurationSearchCond;
	}


	/**
	 * @return the configurationMap
	 */
	public Map<String, List<SOC0109Info>> getConfigurationMap() {
		return configurationMap;
	}


	/**
	 * @param configurationMap the configurationMap to set
	 */
	public void setConfigurationMap(Map<String, List<SOC0109Info>> configurationMap) {
		this.configurationMap = configurationMap;
	}


	/**
	 * @return the deleteEntity
	 */
	public String[] getDeleteEntity() {
		return deleteEntity;
	}


	/**
	 * @param deleteEntity the deleteEntity to set
	 */
	public void setDeleteEntity(String[] deleteEntity) {
		this.deleteEntity = deleteEntity;
	}


	/**
	 * @return the deleteConfiguration
	 */
	public String[] getDeleteConfiguration() {
		return deleteConfiguration;
	}


	/**
	 * @param deleteConfiguration the deleteConfiguration to set
	 */
	public void setDeleteConfiguration(String[] deleteConfiguration) {
		this.deleteConfiguration = deleteConfiguration;
	}


	/**
	 * @return the igdrm0414Form
	 */
	public IGDRM0414Form getIgdrm0414Form() {
		return igdrm0414Form;
	}


	/**
	 * @param igdrm0414Form the igdrm0414Form to set
	 */
	public void setIgdrm0414Form(IGDRM0414Form igdrm0414Form) {
		this.igdrm0414Form = igdrm0414Form;
	}


	/**
	 * @return the igdrm0412Form
	 */
	public IGDRM0412Form getIgdrm0412Form() {
		return igdrm0412Form;
	}


	/**
	 * @param igdrm0412Form the igdrm0412Form to set
	 */
	public void setIgdrm0412Form(IGDRM0412Form igdrm0412Form) {
		this.igdrm0412Form = igdrm0412Form;
	}


	/**
	 * @return the igdrm0420Form
	 */
	public IGDRM0420Form getIgdrm0420Form() {
		return igdrm0420Form;
	}


	/**
	 * @param igdrm0420Form the igdrm0420Form to set
	 */
	public void setIgdrm0420Form(IGDRM0420Form igdrm0420Form) {
		this.igdrm0420Form = igdrm0420Form;
	}


	/**
	 * @return the igdrm0421Form
	 */
	public IGDRM0421Form getIgdrm0421Form() {
		return igdrm0421Form;
	}


	/**
	 * @param igdrm0421Form the igdrm0421Form to set
	 */
	public void setIgdrm0421Form(IGDRM0421Form igdrm0421Form) {
		this.igdrm0421Form = igdrm0421Form;
	}


	/**
	 * @return the igdrm0419Form
	 */
	public IGDRM0419Form getIgdrm0419Form() {
		return igdrm0419Form;
	}


	/**
	 * @param igdrm0419Form the igdrm0419Form to set
	 */
	public void setIgdrm0419Form(IGDRM0419Form igdrm0419Form) {
		this.igdrm0419Form = igdrm0419Form;
	}


	/**
	 * @return the igdrm0411Form
	 */
	public IGDRM0411Form getIgdrm0411Form() {
		return igdrm0411Form;
	}


	/**
	 * @param igdrm0411Form the igdrm0411Form to set
	 */
	public void setIgdrm0411Form(IGDRM0411Form igdrm0411Form) {
		this.igdrm0411Form = igdrm0411Form;
	}


	/**
	 * @return the estatus
	 */
	public String getEstatus() {
		return estatus;
	}


	/**
	 * @param estatus the estatus to set
	 */
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}


	/**
	 * @return the configurationCodeDetailBeanList
	 */
	public List<ConfigurationCodeDetailBean> getConfigurationCodeDetailBeanList() {
		return configurationCodeDetailBeanList;
	}


	/**
	 * @param configurationCodeDetailBeanList the configurationCodeDetailBeanList to set
	 */
	public void setConfigurationCodeDetailBeanList(
			List<ConfigurationCodeDetailBean> configurationCodeDetailBeanList) {
		this.configurationCodeDetailBeanList = configurationCodeDetailBeanList;
	}


	/**
	 * @return the configurationCodeDetailList
	 */
	public List<SOC0151Info> getConfigurationCodeDetailList() {
		return ConfigurationCodeDetailList;
	}


	/**
	 * @param configurationCodeDetailList the configurationCodeDetailList to set
	 */
	public void setConfigurationCodeDetailList(
			List<SOC0151Info> configurationCodeDetailList) {
		ConfigurationCodeDetailList = configurationCodeDetailList;
	}


	/**
	 * @return the igDRM0424Form
	 */
	public IGDRM0424Form getIgDRM0424Form() {
		return igDRM0424Form;
	}


	/**
	 * @param igDRM0424Form the igDRM0424Form to set
	 */
	public void setIgDRM0424Form(IGDRM0424Form igDRM0424Form) {
		this.igDRM0424Form = igDRM0424Form;
	}


	/**
	 * @return the configurationMapList
	 */
	public List<Map<String, List<SOC0109Info>>> getConfigurationMapList() {
		return configurationMapList;
	}


	/**
	 * @param configurationMapList the configurationMapList to set
	 */
	public void setConfigurationMapList(
			List<Map<String, List<SOC0109Info>>> configurationMapList) {
		this.configurationMapList = configurationMapList;
	}


	/**
	 * @return the map_IG612Info
	 */
	public Map<String, List<IG612Info>> getMap_IG612Info() {
		return map_IG612Info;
	}


	/**
	 * @param map_IG612Info the map_IG612Info to set
	 */
	public void setMap_IG612Info(Map<String, List<IG612Info>> map_IG612Info) {
		this.map_IG612Info = map_IG612Info;
	}


	/**
	 * @return the strflag
	 */
	public String getStrflag() {
		return strflag;
	}


	/**
	 * @param strflag the strflag to set
	 */
	public void setStrflag(String strflag) {
		this.strflag = strflag;
	}


	/**
	 * @return the erEntityList
	 */
	public List<EmergencyResourceInfo> getErEntityList() {
		return erEntityList;
	}


	/**
	 * @param erEntityList the erEntityList to set
	 */
	public void setErEntityList(List<EmergencyResourceInfo> erEntityList) {
		this.erEntityList = erEntityList;
	}


	/**
	 * @return the igdrm0418Form
	 */
	public IGDRM0418Form getIgdrm0418Form() {
		return igdrm0418Form;
	}


	/**
	 * @param igdrm0418Form the igdrm0418Form to set
	 */
	public void setIgdrm0418Form(IGDRM0418Form igdrm0418Form) {
		this.igdrm0418Form = igdrm0418Form;
	}


	/**
	 * @return the configurationcodedetail
	 */
	public SOC0151Info getConfigurationcodedetail() {
		return configurationcodedetail;
	}


	/**
	 * @param configurationcodedetail the configurationcodedetail to set
	 */
	public void setConfigurationcodedetail(SOC0151Info configurationcodedetail) {
		this.configurationcodedetail = configurationcodedetail;
	}


	/**
	 * @return the configurationcodedetailsearchcond
	 */
	public IG545SearchCond getConfigurationcodedetailsearchcond() {
		return configurationcodedetailsearchcond;
	}


	/**
	 * @param configurationcodedetailsearchcond the configurationcodedetailsearchcond to set
	 */
	public void setConfigurationcodedetailsearchcond(
			IG545SearchCond configurationcodedetailsearchcond) {
		this.configurationcodedetailsearchcond = configurationcodedetailsearchcond;
	}


	/**
	 * @return the stopbuttonMap
	 */
	public Map<String, String> getStopbuttonMap() {
		return stopbuttonMap;
	}


	/**
	 * @param stopbuttonMap the stopbuttonMap to set
	 */
	public void setStopbuttonMap(Map<String, String> stopbuttonMap) {
		this.stopbuttonMap = stopbuttonMap;
	}


	/**
	 * @return the startbuttonMap
	 */
	public Map<String, String> getStartbuttonMap() {
		return startbuttonMap;
	}


	/**
	 * @param startbuttonMap the startbuttonMap to set
	 */
	public void setStartbuttonMap(Map<String, String> startbuttonMap) {
		this.startbuttonMap = startbuttonMap;
	}


	/**
	 * @return the cstatus
	 */
	public String getCstatus() {
		return cstatus;
	}


	/**
	 * @param cstatus the cstatus to set
	 */
	public void setCstatus(String cstatus) {
		this.cstatus = cstatus;
	}


	/**
	 * @return the cid
	 */
	public String getCid() {
		return cid;
	}


	/**
	 * @param cid the cid to set
	 */
	public void setCid(String cid) {
		this.cid = cid;
	}


	/**
	 * @param selectedListMap the selectedListMap to set
	 */
	public void setSelectedListMap(
			Map<Integer, List<LabelValueBean>> selectedListMap) {
		this.selectedListMap = selectedListMap;
	}


	/**
	 * ajax返回结果取得
	 * @return ajaxResult ajax返回结果
	 */
	public String getAjaxResult() {
		return ajaxResult;
	}


	/**
	 * ajax返回结果设定
	 * @param ajaxResult ajax返回结果
	 */
	public void setAjaxResult(String ajaxResult) {
		this.ajaxResult = ajaxResult;
	}

}