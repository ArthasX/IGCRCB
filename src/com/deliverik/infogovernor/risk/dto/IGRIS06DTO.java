package com.deliverik.infogovernor.risk.dto;

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
import com.deliverik.infogovernor.asset.model.CheckItemVWInfo;
import com.deliverik.infogovernor.asset.model.CheckToRiskRelateVWInfo;
import com.deliverik.infogovernor.asset.model.RiskToZhRelateVWInfo;
import com.deliverik.infogovernor.risk.form.IGRIS0602Form;
import com.deliverik.infogovernor.risk.form.IGRIS0604Form;
import com.deliverik.infogovernor.risk.form.IGRIS0605Form;
import com.deliverik.infogovernor.risk.form.IGRIS0606Form;
import com.deliverik.infogovernor.risk.form.IGRIS0607Form;
import com.deliverik.infogovernor.risk.form.IGRIS0612Form;
import com.deliverik.infogovernor.risk.form.IGRIS0614Form;

/**
 * 检查项配置管理业务用DTO
 * 
 */
@SuppressWarnings("serial")
public class IGRIS06DTO extends BaseDTO implements Serializable{

	/** 检查项信息 */
	protected IGRIS0602Form igris0602Form;
	
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
	protected IGRIS0604Form igris0604Form;
	
	/** 检查项配置信息检索结果 */
	protected List<SOC0129Info> configItemVWInfoList;

	/** 检查项配置信息画面检查项信息 */
	protected SOC0124Info entityItemVWInfo;

	/** 检查项配置信息历史记录检索条件 */
	protected IGRIS0605Form igris0605Form;
	
	/** 检查项配置信息历史记录检索结果 */
	protected List<SOC0107Info> configItemList;
	
	/** 检查项关系管理检索条件 */
	protected IGRIS0606Form igris0606Form;
	
	/** 资产项关系管理信息检索结果1 */
	protected List<SOC0119Info> parEntityItemRelationList;
	
	/** 资产项关系管理信息检索结果2 */
	protected List<SOC0119Info> cldEntityItemRelationList;
	
	/** 检查项关系编辑信息 */
	protected IGRIS0607Form igris0607Form;
	
	/** 检查项关系编辑后信息 */
	protected SOC0119Info entityItemRelation;

	/** 检查项关系删除对象 */
	protected String[] deleteEntityItemRelation;
	
	/** 资产管理关系下拉列表 */
	protected List<LabelValueBean> relationList;
	
	/** 资产项配置信息检索结果 */
	protected Map<String,List<SOC0107Info>> configItemMap;
	
	/**资产属性建议检查频度 取值范围集合*/
	protected List<SOC0151Info> checkfrequencyList;
	
	/** 资产项配置信息检索结果 */
	protected Map<String,List<SOC0129Info>> configItemVWInfoMap;
	
	
	/**检查项属性信息*/
	protected List<SOC0109Info> soc0109List;
	
	/**版本集合*/
	protected Map<Integer,Integer> checkVersionMap;
	
	protected Map<String,List<SOC0119Info>> parEntityItemRelationMap;
	protected Map<String,List<SOC0119Info>> cldEntityItemRelationMap;
	protected int parCount;
	protected int cldCount;
	/** 检查项所属机构名称 */
	protected String eiorgname;
	protected IGRIS0612Form igris0612Form;
	
	protected Integer eiid;
	
	/**风险点资产FORM*/
	protected IGRIS0614Form Igris0614form;
	
	/**风险点查询集合*/
	private  List<CheckItemVWInfo> itemList;
	
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
	
	
	/**检查项属性*/
	protected String[] civalue;
	
	/**是否有权限修改*/
	protected String identyFlag; 
	
	/**管理人id*/
	protected String hiddenmguserid;
	
	/**检查项 ----风险点关系集合*/
	protected List<CheckToRiskRelateVWInfo> checkToRiskRelateList;
	/**检查项---指标*/
	protected List<RiskToZhRelateVWInfo> riskToZhRelateList;
	
	/**
	 * 设置附件用
	 */
	protected IGRIS0602Form attachFile;
	
	/**
	 * 检查项---指标取得
	 * @return riskToZhRelateList 检查项---指标
	 */
	public List<RiskToZhRelateVWInfo> getRiskToZhRelateList() {
		return riskToZhRelateList;
	}

	/**
	 * 检查项---指标设定
	 * @param riskToZhRelateList 检查项---指标
	 */
	public void setRiskToZhRelateList(List<RiskToZhRelateVWInfo> riskToZhRelateList) {
		this.riskToZhRelateList = riskToZhRelateList;
	}

	/**
	 * 管理人id取得
	 * @return hiddenmguserid 管理人id
	 */
	public String getHiddenmguserid() {
		return hiddenmguserid;
	}

	/**
	 * 管理人id设定
	 * @param hiddenmguserid 管理人id
	 */
	public void setHiddenmguserid(String hiddenmguserid) {
		this.hiddenmguserid = hiddenmguserid;
	}

	/**
	 * 是否有权限修改取得
	 * @return identyFlag 是否有权限修改
	 */
	public String getIdentyFlag() {
		return identyFlag;
	}

	/**
	 * 是否有权限修改设定
	 * @param identyFlag 是否有权限修改
	 */
	public void setIdentyFlag(String identyFlag) {
		this.identyFlag = identyFlag;
	}

	/**
	 * 检查项属性取得
	 * @return civalue 检查项属性
	 */
	public String[] getCivalue() {
		return civalue;
	}

	/**
	 * 检查项属性设定
	 * @param civalue 检查项属性
	 */
	public void setCivalue(String[] civalue) {
		this.civalue = civalue;
	}

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
	
	
	/**
	 * eiid取得
	 * @return eiid eiid
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * eiid设定
	 * @param eiid eiid
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	public IGRIS0612Form getIgris0612Form() {
		return igris0612Form;
	}

	public void setIgris0612Form(IGRIS0612Form igris0612Form) {
		this.igris0612Form = igris0612Form;
	}
	/**
	 * 检查项属性信息取得
	 * @return soc0109List 检查项属性信息
	 */
	public List<SOC0109Info> getSoc0109List() {
		return soc0109List;
	}

	/**
	 * 检查项属性信息设定
	 * @param soc0109List 检查项属性信息
	 */
	public void setSoc0109List(List<SOC0109Info> soc0109List) {
		this.soc0109List = soc0109List;
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
	public IGRIS0602Form getIgris0602Form() {
		return igris0602Form;
	}

	/**
	 * 检查项信息设定
	 *
	 * @param igris0602Form 检查项信息
	 */
	public void setIgris0602Form(IGRIS0602Form igris0602Form) {
		this.igris0602Form = igris0602Form;
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
	public IGRIS0604Form getIgris0604Form() {
		return igris0604Form;
	}


	/**
	 * 检查项配置信息检索条件设定
	 *
	 * @param igris0604Form 检查项配置信息检索条件
	 */
	public void setIgris0604Form(IGRIS0604Form igris0604Form) {
		this.igris0604Form = igris0604Form;
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
	public IGRIS0605Form getIgris0605Form() {
		return igris0605Form;
	}

	/**
	 * 检查项配置信息历史记录检索条件设定
	 *
	 * @param igris0605Form 检查项配置信息历史记录检索条件
	 */
	public void setIgris0605Form(IGRIS0605Form igris0605Form) {
		this.igris0605Form = igris0605Form;
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
	public IGRIS0606Form getIgris0606Form() {
		return igris0606Form;
	}

	/**
	 * 检查项关系管理检索条件设定
	 *
	 * @param igris0606Form 检查项关系管理检索条件
	 */
	public void setIgris0606Form(IGRIS0606Form igris0606Form) {
		this.igris0606Form = igris0606Form;
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
	public IGRIS0607Form getIgris0607Form() {
		return igris0607Form;
	}

	/**
	 * 检查项关系编辑信息设定
	 *
	 * @param igris0607Form 检查项关系编辑信息
	 */
	public void setIgris0607Form(IGRIS0607Form igris0607Form) {
		this.igris0607Form = igris0607Form;
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
	 * igris0614form取得
	 * @return igris0614form igris0614form
	 */
	public IGRIS0614Form getIgris0614form() {
		return Igris0614form;
	}

	/**
	 * igris0614form设定
	 * @param igris0614form igris0614form
	 */
	public void setIgris0614form(IGRIS0614Form igris0614form) {
		Igris0614form = igris0614form;
	}

	/**
	 * 风险点查询集合取得
	 * @return itemList 风险点查询集合
	 */
	public List<CheckItemVWInfo> getItemList() {
		return itemList;
	}

	/**
	 * 风险点查询集合设定
	 * @param itemList 风险点查询集合
	 */
	public void setItemList(List<CheckItemVWInfo> itemList) {
		this.itemList = itemList;
	}

	/**
	 * 检查项----风险点关系集合取得
	 * @return checkToRiskRelateList 检查项----风险点关系集合
	 */
	public List<CheckToRiskRelateVWInfo> getCheckToRiskRelateList() {
		return checkToRiskRelateList;
	}

	/**
	 * 检查项----风险点关系集合设定
	 * @param checkToRiskRelateList 检查项----风险点关系集合
	 */
	public void setCheckToRiskRelateList(
			List<CheckToRiskRelateVWInfo> checkToRiskRelateList) {
		this.checkToRiskRelateList = checkToRiskRelateList;
	}

	/**
	 * 资产属性建议检查频度取值范围集合取得
	 * @return checkfrequencyList 资产属性建议检查频度取值范围集合
	 */
	public List<SOC0151Info> getCheckfrequencyList() {
		return checkfrequencyList;
	}

	/**
	 * 资产属性建议检查频度取值范围集合设定
	 * @param checkfrequencyList 资产属性建议检查频度取值范围集合
	 */
	public void setCheckfrequencyList(List<SOC0151Info> checkfrequencyList) {
		this.checkfrequencyList = checkfrequencyList;
	}

	/**
	 * 设置附件用取得
	 * @return attachFile  设置附件用
	 */
	public IGRIS0602Form getAttachFile() {
		return attachFile;
	}

	/**
	 * 设置附件用设定
	 * @param attachFile  设置附件用
	 */
	public void setAttachFile(IGRIS0602Form attachFile) {
		this.attachFile = attachFile;
	}

}


