package com.deliverik.infogovernor.asset.dto;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.asset.model.EiBelongRelationInfo;
import com.deliverik.framework.asset.model.IG002Info;
import com.deliverik.framework.asset.model.IG013Info;
import com.deliverik.framework.asset.model.IG800Info;
import com.deliverik.framework.asset.model.condition.IG800SearchCond;
import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.soc.asset.model.SOC0119Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.SOC0128Info;
import com.deliverik.framework.soc.asset.model.SOC0129Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.asset.form.IGASM0301Form;
import com.deliverik.infogovernor.asset.form.IGASM0302Form;
import com.deliverik.infogovernor.asset.form.IGASM0304Form;
import com.deliverik.infogovernor.asset.form.IGASM0305Form;
import com.deliverik.infogovernor.asset.form.IGASM0306Form;
import com.deliverik.infogovernor.asset.form.IGASM0307Form;
import com.deliverik.infogovernor.asset.form.IGASM0309Form;
import com.deliverik.infogovernor.asset.form.IGASM0311Form;
import com.deliverik.infogovernor.asset.form.IGASM0312Form;
import com.deliverik.infogovernor.asset.form.IGASM0313Form;
import com.deliverik.infogovernor.asset.form.IGASM0314Form;
import com.deliverik.infogovernor.asset.form.IGASM0315Form;
import com.deliverik.infogovernor.asset.form.IGASM0316Form;
import com.deliverik.infogovernor.asset.form.IGASM0317Form;
import com.deliverik.infogovernor.asset.form.IGASM0320Form;
import com.deliverik.infogovernor.asset.form.IGASM0321Form;
import com.deliverik.infogovernor.asset.form.IGASM0341Form;
import com.deliverik.infogovernor.asset.form.IGASM0346Form;

/**
 * 设备配置管理业务用DTO
 * 
 */
@SuppressWarnings("serial")
public class IGASM03DTO extends BaseDTO implements Serializable{

	protected IG800SearchCond configItemSearchCond;
	public IG800SearchCond getConfigItemSearchCond() {
		return configItemSearchCond;
	}

	public void setConfigItemSearchCond(IG800SearchCond configItemSearchCond) {
		this.configItemSearchCond = configItemSearchCond;
	}

	/** 设备信息 */
	protected IGASM0302Form igasm0302Form;
	
	/** 设备信息检索条件 */
	protected SOC0124SearchCond entityItemVWSearchCond;
	
	/** 检索最大件数 */
	protected int maxSearchCount;

	/** 翻页用DTO */
	protected PagingDTO pagingDto;

	/** 设备检索结果 */
	protected List<SOC0124Info> entityItemVWInfoList;

	/** 设备删除对象 */
	protected String[] deleteEntityItem;
	
	/** 设备批量处理对象 */
	protected String[] batchEntityItem;

	/** 设备配置信息 */
	protected IGASM0304Form igasm0304Form;
	/** 设备配置文件历史版本比较信息 */
	protected IGASM0341Form igasm0341Form;
	
	
	/** 设备配置信息检索结果 */
	protected List<IG002Info> configItemVWInfoList;

	/** 设备配置信息画面设备信息 */
	protected SOC0124Info entityItemVWInfo;

	/** 设备配置信息历史记录检索条件 */
	protected IGASM0305Form igasm0305Form;
	
	/** 设备配置信息历史记录检索结果 */
	protected List<IG800Info> configItemList;
	
	/** 设备关系管理检索条件 */
	protected IGASM0306Form igasm0306Form;
	
	protected IGASM0309Form igasm0309Form;
	
	protected IGASM0311Form igasm0311Form;
	
	protected IGASM0312Form igasm0312Form;
	
	protected IGASM0314Form igasm0314Form;
	
	protected IGASM0315Form igasm0315Form;
	
	protected IGASM0316Form igasm0316Form;
	
	protected IGASM0317Form igasm0317Form;
	
	/** 资产项关系信息1件数 */
	protected int parCount;
	
	/** 资产项关系信息2件数 */
	protected int cldCount;
	
	/** 资产管理关系下拉列表 */
	protected List<LabelValueBean> relationList;
	
	/** 资产项关系管理信息检索结果1 */
	protected List<SOC0119Info> parEntityItemRelationList;
	
	/** 资产项关系管理信息检索结果1 */
	protected Map<String,List<SOC0119Info>> parEntityItemRelationMap;
	
	/** 资产项关系管理信息检索结果2 */
	protected List<SOC0119Info> cldEntityItemRelationList;
	
	/** 资产项关系管理信息检索结果2 */
	protected Map<String,List<SOC0119Info>> cldEntityItemRelationMap;
	
	/** 设备关系编辑信息 */
	protected IGASM0307Form igasm0307Form;
	
	/** 设备关系编辑后信息 */
	protected SOC0119Info entityItemRelation;

	/** 设备关系删除对象 */
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
	
	/** 设备所属机构名称 */
	protected String eiorgname;
	
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
	
	/** 配置信息XML树 */
	protected Map<String,TreeNode> treeNodeMap = new LinkedHashMap<String,TreeNode>();
	
	/** 配置信息XML树结点信息 */
	protected Map<String,String> infoMap;
	
	protected IGASM0301Form igASM0301Form;
	
	/** 配置信息XML文件路径 */
	protected String filepath;
	
	/** 配置信息XML文件路径 */
	protected String otherfilepath;
	
	protected List<String> section_list;
	
	protected List<String> command_list1;
	
	protected List<String> output_list1;
	
	protected List<String> command_list2;
	
	protected List<String> output_list2;

	protected Map<String,List<TreeNode>> command_map;
	
	protected Map<String,List<TreeNode>> map1;
	
	protected Map<String,List<TreeNode>> map2;
	
	protected List<String> command_color_list;//0不变色 1变色
	
	protected List<String> output_color_list;//0不变色 1变色
	
	protected String inJiguiFlg;  //设备是否已上架标志位
	
	
	/** 所属关系 */
	protected List<EiBelongRelationInfo> eiBelongRelationList;
	
	
	/** 配置包含关系显示FORM */
	protected IGASM0346Form igasm0346Form;
	
	/** 设备资产所属区域*/
	protected String area;
	

	public List<EiBelongRelationInfo> getEiBelongRelationList() {
		return eiBelongRelationList;
	}

	public void setEiBelongRelationList(List<EiBelongRelationInfo> eiBelongRelationList) {
		this.eiBelongRelationList = eiBelongRelationList;
	}

	public List<String> getCommand_color_list() {
		return command_color_list;
	}

	public void setCommand_color_list(List<String> command_color_list) {
		this.command_color_list = command_color_list;
	}

	public List<String> getOutput_color_list() {
		return output_color_list;
	}

	public void setOutput_color_list(List<String> output_color_list) {
		this.output_color_list = output_color_list;
	}

	public Map<String, List<TreeNode>> getMap1() {
		return map1;
	}

	public void setMap1(Map<String, List<TreeNode>> map1) {
		this.map1 = map1;
	}

	public Map<String, List<TreeNode>> getMap2() {
		return map2;
	}

	public void setMap2(Map<String, List<TreeNode>> map2) {
		this.map2 = map2;
	}

	public List<String> getCommand_list1() {
		return command_list1;
	}

	public void setCommand_list1(List<String> command_list1) {
		this.command_list1 = command_list1;
	}

	public List<String> getOutput_list1() {
		return output_list1;
	}

	public void setOutput_list1(List<String> output_list1) {
		this.output_list1 = output_list1;
	}

	public List<String> getCommand_list2() {
		return command_list2;
	}

	public void setCommand_list2(List<String> command_list2) {
		this.command_list2 = command_list2;
	}

	public List<String> getOutput_list2() {
		return output_list2;
	}

	public void setOutput_list2(List<String> output_list2) {
		this.output_list2 = output_list2;
	}

	public String getOtherfilepath() {
		return otherfilepath;
	}

	public void setOtherfilepath(String otherfilepath) {
		this.otherfilepath = otherfilepath;
	}

	

	public List<String> getSection_list() {
		return section_list;
	}

	public void setSection_list(List<String> section_list) {
		this.section_list = section_list;
	}

	public Map<String, List<TreeNode>> getCommand_map() {
		return command_map;
	}

	public void setCommand_map(Map<String, List<TreeNode>> command_map) {
		this.command_map = command_map;
	}

	public Map<String, String> getInfoMap() {
		return infoMap;
	}

	public void setInfoMap(Map<String, String> infoMap) {
		this.infoMap = infoMap;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public IGASM0301Form getIgASM0301Form() {
		return igASM0301Form;
	}

	public void setIgASM0301Form(IGASM0301Form igASM0301Form) {
		this.igASM0301Form = igASM0301Form;
	}

	public Map<String, TreeNode> getTreeNodeMap() {
		return treeNodeMap;
	}

	public void setTreeNodeMap(Map<String, TreeNode> treeNodeMap) {
		this.treeNodeMap = treeNodeMap;
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

	public String getReciveUser() {
		return reciveUser;
	}

	public void setReciveUser(String reciveUser) {
		this.reciveUser = reciveUser;
	}
	
	protected IGASM0313Form igasm0313Form;
	
	/** 设备所属机构id */
	protected String orgid;
	
	/** 设备所属机构name */
	protected String orgname;
	
	/** 设备下发时间 */
	protected String issuetime;
	
	/** 设备领用人 */
	protected String recivename;
	
	/** 设备当前版本号 */
	protected String eiversion;
	
	public IGASM0317Form getIgasm0317Form() {
		return igasm0317Form;
	}

	public void setIgasm0317Form(IGASM0317Form igasm0317Form) {
		this.igasm0317Form = igasm0317Form;
	}

	public IGASM0316Form getIgasm0316Form() {
		return igasm0316Form;
	}

	public void setIgasm0316Form(IGASM0316Form igasm0316Form) {
		this.igasm0316Form = igasm0316Form;
	}

	public IGASM0312Form getIgasm0312Form() {
		return igasm0312Form;
	}

	public void setIgasm0312Form(IGASM0312Form igasm0312Form) {
		this.igasm0312Form = igasm0312Form;
	}

	public String[] getBatchEntityItem() {
		return batchEntityItem;
	}

	public void setBatchEntityItem(String[] batchEntityItem) {
		this.batchEntityItem = batchEntityItem;
	}

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

	public IGASM0315Form getIgasm0315Form() {
		return igasm0315Form;
	}

	public void setIgasm0315Form(IGASM0315Form igasm0315Form) {
		this.igasm0315Form = igasm0315Form;
	}

	public IGASM0311Form getIgasm0311Form() {
		return igasm0311Form;
	}

	public void setIgasm0311Form(IGASM0311Form igasm0311Form) {
		this.igasm0311Form = igasm0311Form;
	}
	
	/** 修改用设备基本信息显示 */
	protected IGASM0320Form igasm0320Form;
	
	/** 修改用设备基本信息 */
	protected IGASM0321Form igasm0321Form;
	
	/** 设备信息画面设备信息 */
	protected IG013Info entityItem;

	public IGASM0321Form getIgasm0321Form() {
		return igasm0321Form;
	}

	public void setIgasm0321Form(IGASM0321Form igasm0321Form) {
		this.igasm0321Form = igasm0321Form;
	}

	public IG013Info getEntityItem() {
		return entityItem;
	}

	public void setEntityItem(IG013Info entityItem) {
		this.entityItem = entityItem;
	}

	public IGASM0320Form getIgasm0320Form() {
		return igasm0320Form;
	}

	public void setIgasm0320Form(IGASM0320Form igasm0320Form) {
		this.igasm0320Form = igasm0320Form;
	}

	public IGASM0313Form getIgasm0313Form() {
		return igasm0313Form;
	}

	public void setIgasm0313Form(IGASM0313Form igasm0313Form) {
		this.igasm0313Form = igasm0313Form;
	}

	/**
	 * 设备信息取得
	 * @return 设备信息
	 */
	public IGASM0302Form getIgasm0302Form() {
		return igasm0302Form;
	}

	/**
	 * 设备信息设定
	 *
	 * @param igasm0302Form 设备信息
	 */
	public void setIgasm0302Form(IGASM0302Form igasm0302Form) {
		this.igasm0302Form = igasm0302Form;
	}
	
	public IGASM0314Form getIgasm0314Form() {
		return igasm0314Form;
	}

	public void setIgasm0314Form(IGASM0314Form igasm0314Form) {
		this.igasm0314Form = igasm0314Form;
	}

	/**
	 * 设备信息检索条件取得
	 * @return 设备信息检索条件
	 */
	public SOC0124SearchCond getEntityItemVWSearchCond() {
		return entityItemVWSearchCond;
	}

	/**
	 * 设备信息检索条件设定
	 *
	 * @param entityItemVWSearchCond 设备信息检索条件
	 */
	public void setEntityItemVWSearchCond(
			SOC0124SearchCond entityItemVWSearchCond) {
		this.entityItemVWSearchCond = entityItemVWSearchCond;
	}

	public IGASM0309Form getIgasm0309Form() {
		return igasm0309Form;
	}

	public void setIgasm0309Form(IGASM0309Form igasm0309Form) {
		this.igasm0309Form = igasm0309Form;
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
	 * 设备检索结果取得
	 * @return 设备检索结果
	 */
	public List<SOC0124Info> getEntityItemVWInfoList() {
		return entityItemVWInfoList;
	}

	/**
	 * 设备检索结果设定
	 *
	 * @param entityItemVWInfoList 设备检索结果
	 */
	public void setEntityItemVWInfoList(List<SOC0124Info> entityItemVWInfoList) {
		this.entityItemVWInfoList = entityItemVWInfoList;
	}

	/**
	 * 设备删除对象取得
	 * @return 设备删除对象
	 */
	public String[] getDeleteEntityItem() {
		return deleteEntityItem;
	}

	/**
	 * 设备删除对象设定
	 *
	 * @param deleteEntityItem 设备删除对象
	 */
	public void setDeleteEntityItem(String[] deleteEntityItem) {
		this.deleteEntityItem = deleteEntityItem;
	}

	/**
	 * 设备配置信息取得
	 * @return 设备配置信息
	 */
	public IGASM0304Form getIgasm0304Form() {
		return igasm0304Form;
	}


	/**
	 * 设备配置信息检索条件设定
	 *
	 * @param igasm0304Form 设备配置信息检索条件
	 */
	public void setIgasm0304Form(IGASM0304Form igasm0304Form) {
		this.igasm0304Form = igasm0304Form;
	}

	/**
	 * 设备配置信息检索结果取得
	 * @return 设备配置信息检索结果
	 */
	public List<IG002Info> getConfigItemVWInfoList() {
		return configItemVWInfoList;
	}

	/**
	 * 设备配置信息检索结果设定
	 *
	 * @param configItemVWInfoList 设备配置信息检索结果
	 */
	public void setConfigItemVWInfoList(List<IG002Info> configItemVWInfoList) {
		this.configItemVWInfoList = configItemVWInfoList;
	}

	/**
	 * 设备配置信息画面设备信息取得
	 * @return 设备配置信息画面设备信息
	 */
	public SOC0124Info getEntityItemVWInfo() {
		return entityItemVWInfo;
	}

	/**
	 * 设备配置信息画面设备信息设定
	 *
	 * @param entityItemVWInfo 设备配置信息画面设备信息
	 */
	public void setEntityItemVWInfo(SOC0124Info entityItemVWInfo) {
		this.entityItemVWInfo = entityItemVWInfo;
	}

	/**
	 * 设备配置信息历史记录检索条件取得
	 * @return 设备配置信息历史记录检索条件
	 */
	public IGASM0305Form getIgasm0305Form() {
		return igasm0305Form;
	}

	/**
	 * 设备配置信息历史记录检索条件设定
	 *
	 * @param igasm0305Form 设备配置信息历史记录检索条件
	 */
	public void setIgasm0305Form(IGASM0305Form igasm0305Form) {
		this.igasm0305Form = igasm0305Form;
	}

	/**
	 * 设备配置信息历史记录检索结果取得
	 * @return 设备配置信息历史记录检索结果
	 */
	public List<IG800Info> getConfigItemList() {
		return configItemList;
	}

	/**
	 * 设备配置信息历史记录检索结果设定
	 *
	 * @param configItemList 设备配置信息历史记录检索结果
	 */
	public void setConfigItemList(List<IG800Info> configItemList) {
		this.configItemList = configItemList;
	}

	/**
	 * 设备关系管理检索条件取得
	 * @return 设备关系管理检索条件
	 */
	public IGASM0306Form getIgasm0306Form() {
		return igasm0306Form;
	}

	/**
	 * 设备关系管理检索条件设定
	 *
	 * @param igasm0306Form 设备关系管理检索条件
	 */
	public void setIgasm0306Form(IGASM0306Form igasm0306Form) {
		this.igasm0306Form = igasm0306Form;
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
	 * 设备关系编辑信息取得
	 * @return 编辑信息
	 */
	public IGASM0307Form getIgasm0307Form() {
		return igasm0307Form;
	}

	/**
	 * 设备关系编辑信息设定
	 *
	 * @param igasm0307Form 设备关系编辑信息
	 */
	public void setIgasm0307Form(IGASM0307Form igasm0307Form) {
		this.igasm0307Form = igasm0307Form;
	}

	/**
	 * 设备关系编辑后信息取得
	 * @return 设备关系编辑后信息
	 */
	public SOC0119Info getEntityItemRelation() {
		return entityItemRelation;
	}

	/**
	 * 设备关系编辑后信息设定
	 *
	 * @param entityItemRelation 设备关系编辑后信息
	 */
	public void setEntityItemRelation(SOC0119Info entityItemRelation) {
		this.entityItemRelation = entityItemRelation;
	}

	/**
	 * 设备关系删除对象取得
	 * @return 设备关系删除对象
	 */
	public String[] getDeleteEntityItemRelation() {
		return deleteEntityItemRelation;
	}

	/**
	 * 设备关系删除对象设定
	 *
	 * @param entityItemRelation 设备关系删除对象
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
	 * 资产项关系管理信息检索结果1取得
	 * @return 资产项关系管理信息检索结果1
	 */
	public Map<String, List<SOC0119Info>> getParEntityItemRelationMap() {
		return parEntityItemRelationMap;
	}

	/**
	 * 资产项关系管理信息检索结果1设定
	 *
	 * @param username 资产项关系管理信息检索结果1
	 */
	public void setParEntityItemRelationMap(
			Map<String, List<SOC0119Info>> parEntityItemRelationMap) {
		this.parEntityItemRelationMap = parEntityItemRelationMap;
	}

	/**
	 * 资产项关系管理信息检索结果2取得
	 * @return 资产项关系管理信息检索结果2
	 */
	public Map<String, List<SOC0119Info>> getCldEntityItemRelationMap() {
		return cldEntityItemRelationMap;
	}

	/**
	 * 资产项关系管理信息检索结果2设定
	 *
	 * @param cldEntityItemRelationMap 资产项关系管理信息检索结果2
	 */
	public void setCldEntityItemRelationMap(
			Map<String, List<SOC0119Info>> cldEntityItemRelationMap) {
		this.cldEntityItemRelationMap = cldEntityItemRelationMap;
	}

	/**
	 * 资产项关系信息1件数取得
	 * @return 资产项关系信息1件数
	 */
	public int getParCount() {
		return parCount;
	}

	/**
	 * 资产项关系信息2件数设定
	 *
	 * @param parCount 资产项关系信息2件数
	 */
	public void setParCount(int parCount) {
		this.parCount = parCount;
	}

	/**
	 * 资产项关系信息1件数取得
	 * @return 资产项关系信息1件数
	 */
	public int getCldCount() {
		return cldCount;
	}

	/**
	 * 资产项关系信息2件数设定
	 *
	 * @param cldCount 资产项关系信息2件数
	 */
	public void setCldCount(int cldCount) {
		this.cldCount = cldCount;
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

	public IGASM0341Form getIgasm0341Form() {
		return igasm0341Form;
	}

	public void setIgasm0341Form(IGASM0341Form igasm0341Form) {
		this.igasm0341Form = igasm0341Form;
	}

	/**
	 * 配置包含关系显示FORM取得
	 * 
	 * @return 配置包含关系显示FORM
	 */
	public IGASM0346Form getIgasm0346Form() {
		return igasm0346Form;
	}

	/**
	 * 配置包含关系显示FORM设定
	 * 
	 * @param igasm0346Form配置包含关系显示FORM
	 */
	public void setIgasm0346Form(IGASM0346Form igasm0346Form) {
		this.igasm0346Form = igasm0346Form;
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
	
}


