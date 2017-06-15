/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.drm.dto;


import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.soc.asset.model.SOC0109Info;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.SOC0119Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.SOC0128Info;
import com.deliverik.framework.soc.asset.model.SOC0129Info;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.drm.form.IGDRM0501Form;
import com.deliverik.infogovernor.drm.form.IGDRM0502Form;
import com.deliverik.infogovernor.drm.form.IGDRM05031Form;
import com.deliverik.infogovernor.drm.form.IGDRM0503Form;
import com.deliverik.infogovernor.drm.form.IGDRM0504Form;
import com.deliverik.infogovernor.drm.form.IGDRM0506Form;
import com.deliverik.infogovernor.drm.form.IGDRM0507Form;
import com.deliverik.infogovernor.drm.util.FlowDetail;

/**
 * 专项预案资产管理DTO
 * @author zyl
 *
 * 2015-2-27 09:38:24
 */
public class IGDRM05DTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	
	/**
	 * */
	protected IGDRM0501Form igdrm0501Form ;
	protected IGDRM0502Form igdrm0502Form ;
	protected IGDRM0503Form igdrm0503Form ;
	protected IGDRM05031Form igdrm05031Form ;
	protected IGDRM0504Form igdrm0504Form ;
	protected IGDRM0506Form igdrm0506Form ;
	protected IGDRM0507Form igdrm0507Form ;
	protected List<FlowDetail> flowDetailList; 
	protected String maxSPNumber;
	
	protected int maxSearchCount;

	protected User user;
	
	protected List<SOC0109Info> configurationList;
	
	protected SOC0118Info entityItemInfo;
	
	protected List<SOC0118Info> entityItemList;
	
	protected List<SOC0107Info> entityItemConfigurations;
	
	protected SOC0124Info entityItemVW;
	
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
	
	/** 应急资产删除对象 */
	protected String[] deleteEntityItem;
	/** 人员配置信息画面人员信息 */
	protected SOC0124Info entityItemVWInfo;
	/** 资产版本列表 */
	protected List<SOC0128Info> configItemVersionTime;
	/** 资产项配置信息检索结果 */
	protected Map<String,List<SOC0107Info>> configItemMap;
	protected Map<String,List<SOC0119Info>> parEntityItemRelationMap;
	protected Map<String,List<SOC0119Info>> cldEntityItemRelationMap;
	protected int parCount;
	protected int cldCount;
	/** 文档关系删除对象 */
	protected String[] deleteEntityItemRelation;
	/** 文档关系编辑后信息 */
	protected SOC0119Info entityItemRelation;
	/** 资产管理关系下拉列表 */
	protected List<LabelValueBean> relationList;
	/**流程定义ID*/
	protected String pdid;
	/**输出的html*/
	protected String outPrintStr;
	
	/**  
	 * 获取outPrintStr  
	 * @return outPrintStr 
	 */
	public String getOutPrintStr() {
		return outPrintStr;
	}

	/**  
	 * 设置outPrintStr  
	 * @param outPrintStr
	 */
	
	public void setOutPrintStr(String outPrintStr) {
		this.outPrintStr = outPrintStr;
	}

	/**  
	 * 获取pdid  
	 * @return pdid 
	 */
	public String getPdid() {
		return pdid;
	}

	/**  
	 * 设置pdid  
	 * @param pdid
	 */
	
	public void setPdid(String pdid) {
		this.pdid = pdid;
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
	 * igdrm0501Form   取得
	 * @return igdrm0501Form igdrm0501Form
	 */
	public IGDRM0501Form getIgdrm0501Form() {
		return igdrm0501Form;
	}

	/**
	 * igdrm0501Form   设定
	 * @param igdrm0501Form igdrm0501Form
	 */
	public void setIgdrm0501Form(IGDRM0501Form igdrm0501Form) {
		this.igdrm0501Form = igdrm0501Form;
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
	public List<SOC0109Info> getConfigurationList() {
		return configurationList;
	}

	/**
	 * configurationList   设定
	 * @param configurationList configurationList
	 */
	public void setConfigurationList(List<SOC0109Info> configurationList) {
		this.configurationList = configurationList;
	}

	/**
	 * entityItemInfo   取得
	 * @return entityItemInfo entityItemInfo
	 */
	public SOC0118Info getEntityItemInfo() {
		return entityItemInfo;
	}

	/**
	 * entityItemInfo   设定
	 * @param entityItemInfo entityItemInfo
	 */
	public void setEntityItemInfo(SOC0118Info entityItemInfo) {
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
	 * igdrm0502Form   取得
	 * @return igdrm0502Form igdrm0502Form
	 */
	public IGDRM0502Form getIgdrm0502Form() {
		return igdrm0502Form;
	}

	/**
	 * igdrm0502Form   设定
	 * @param igdrm0502Form igdrm0502Form
	 */
	public void setIgdrm0502Form(IGDRM0502Form igdrm0502Form) {
		this.igdrm0502Form = igdrm0502Form;
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
	public SOC0124Info getEntityItemVW() {
		return entityItemVW;
	}

	/**
	 * entityItemVW   设定
	 * @param entityItemVW entityItemVW
	 */
	public void setEntityItemVW(SOC0124Info entityItemVW) {
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
	 * igdrm0504Form   取得
	 * @return igdrm0504Form igdrm0504Form
	 */
	public IGDRM0504Form getIgdrm0504Form() {
		return igdrm0504Form;
	}

	/**
	 * igdrm0504Form   设定
	 * @param igdrm0504Form igdrm0504Form
	 */
	public void setIgdrm0504Form(IGDRM0504Form igdrm0504Form) {
		this.igdrm0504Form = igdrm0504Form;
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
	 * flag   取得
	 * @return flag flag
	 */
	public boolean isFlag() {
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

	public String getMaxSPNumber() {
		return maxSPNumber;
	}

	public void setMaxSPNumber(String maxSPNumber) {
		this.maxSPNumber = maxSPNumber;
	}

	public IGDRM0503Form getIgdrm0503Form() {
		return igdrm0503Form;
	}

	public void setIgdrm0503Form(IGDRM0503Form igdrm0503Form) {
		this.igdrm0503Form = igdrm0503Form;
	}

	
	public SOC0124Info getEntityItemVWInfo() {
		return entityItemVWInfo;
	}

	public void setEntityItemVWInfo(SOC0124Info entityItemVWInfo) {
		this.entityItemVWInfo = entityItemVWInfo;
	}

	public List<SOC0128Info> getConfigItemVersionTime() {
		return configItemVersionTime;
	}

	public void setConfigItemVersionTime(List<SOC0128Info> configItemVersionTime) {
		this.configItemVersionTime = configItemVersionTime;
	}

	public Map<String, List<SOC0107Info>> getConfigItemMap() {
		return configItemMap;
	}

	public void setConfigItemMap(Map<String, List<SOC0107Info>> configItemMap) {
		this.configItemMap = configItemMap;
	}

	public IGDRM05031Form getIgdrm05031Form() {
		return igdrm05031Form;
	}

	public void setIgdrm05031Form(IGDRM05031Form igdrm05031Form) {
		this.igdrm05031Form = igdrm05031Form;
	}

	public IGDRM0506Form getIgdrm0506Form() {
		return igdrm0506Form;
	}

	public void setIgdrm0506Form(IGDRM0506Form igdrm0506Form) {
		this.igdrm0506Form = igdrm0506Form;
	}

	public IGDRM0507Form getIgdrm0507Form() {
		return igdrm0507Form;
	}

	public void setIgdrm0507Form(IGDRM0507Form igdrm0507Form) {
		this.igdrm0507Form = igdrm0507Form;
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

	public String[] getDeleteEntityItemRelation() {
		return deleteEntityItemRelation;
	}

	public void setDeleteEntityItemRelation(String[] deleteEntityItemRelation) {
		this.deleteEntityItemRelation = deleteEntityItemRelation;
	}

	public SOC0119Info getEntityItemRelation() {
		return entityItemRelation;
	}

	public void setEntityItemRelation(SOC0119Info entityItemRelation) {
		this.entityItemRelation = entityItemRelation;
	}

	public List<LabelValueBean> getRelationList() {
		return relationList;
	}

	public void setRelationList(List<LabelValueBean> relationList) {
		this.relationList = relationList;
	}

	/**  
	 * 获取flowDetailList  
	 * @return flowDetailList 
	 */
	public List<FlowDetail> getFlowDetailList() {
		return flowDetailList;
	}

	/**  
	 * 设置flowDetailList  
	 * @param flowDetailList
	 */
	
	public void setFlowDetailList(List<FlowDetail> flowDetailList) {
		this.flowDetailList = flowDetailList;
	}
	
}