package com.deliverik.infogovernor.soc.mnt.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.asset.model.EiBelongRelationInfo;
import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.model.SOC0119Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.SOC0129Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.asset.form.IGASM0202Form;
import com.deliverik.infogovernor.asset.form.IGASM0204Form;
import com.deliverik.infogovernor.asset.form.IGASM0205Form;
import com.deliverik.infogovernor.asset.form.IGASM0206Form;
import com.deliverik.infogovernor.asset.form.IGASM0207Form;
import com.deliverik.infogovernor.soc.mnt.form.IGMNT0204Form;
import com.deliverik.infogovernor.soc.mnt.model.ConfigItem;
import com.deliverik.infogovernor.soc.mnt.model.ConfigItemVWInfo;

/**
 * 资产配置管理业务用DTO
 * 
 */
@SuppressWarnings("serial")
public class IGMNT03DTO extends BaseDTO implements Serializable{

	/** 资产项信息 */
	protected IGASM0202Form igasm0202Form;
	
	/** 资产项信息检索条件 */
	protected SOC0124SearchCond entityItemVWSearchCond;
	
	/** 检索最大件数 */
	protected int maxSearchCount;

	/** 翻页用DTO */
	protected PagingDTO pagingDto;

	/** 资产项检索结果 */
	protected List<SOC0124Info> entityItemVWInfoList;

	/** 资产项删除对象 */
	protected String[] deleteEntityItem;

	/** 资产项配置信息 */
	protected IGASM0204Form igasm0204Form;
	
	/** 资产项配置信息检索结果 */
	protected List<SOC0129Info> configItemVWInfoList;
	
	/** 资产项配置信息检索结果 */
	protected Map<String,List<SOC0129Info>> configItemVWInfoMap;

	/** 资产管理关系下拉列表 */
	protected List<LabelValueBean> relationList;

	/** 资产项配置信息画面资产项信息 */
	protected SOC0124Info entityItemVWInfo;

	/** 资产项配置信息历史记录检索条件 */
	protected IGASM0205Form igasm0205Form;
	
	/** 资产项配置信息历史记录检索结果 */
	protected List<ConfigItem> configItemList;
	
	/** 资产项关系管理检索条件 */
	protected IGASM0206Form igasm0206Form;
	
	/** 资产项关系管理信息检索结果1 */
	protected List<SOC0119Info> parEntityItemRelationList;
	
	/** 资产项关系管理信息检索结果2 */
	protected List<SOC0119Info> cldEntityItemRelationList;
	
	/** 资产项关系编辑信息 */
	protected IGASM0207Form igasm0207Form;
	
	/** 资产项关系编辑后信息 */
	protected SOC0119Info entityItemRelation;

	/** 资产项关系删除对象 */
	protected String[] deleteEntityItemRelation;
	
	/** 资产项配置信息检索结果 */
	protected Map<String,List<ConfigItem>> configItemMap;
	
	/** 用户对象 */
	private User user;
	
	/** 权限标识 */
	protected Boolean flag;
	
	
	protected Locale locale;
	
	/** 所属关系 */
	protected List<EiBelongRelationInfo> belongRelationList;
	
	protected IGMNT0204Form igmnt0204Form;
	
	protected String eiorgname;
	
	public List<EiBelongRelationInfo> getBelongRelationList() {
		return belongRelationList;
	}

	public void setBelongRelationList(List<EiBelongRelationInfo> belongRelationList) {
		this.belongRelationList = belongRelationList;
	}
	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
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
	 * 资产项信息取得
	 * @return 资产项信息
	 */
	public IGASM0202Form getIgasm0202Form() {
		return igasm0202Form;
	}

	
	protected Map<String,List<SOC0119Info>> parEntityItemRelationMap;
	protected Map<String,List<SOC0119Info>> cldEntityItemRelationMap;
	protected int parCount;
	protected int cldCount;

	public SOC0124SearchCond getEntityItemVWSearchCond() {
		return entityItemVWSearchCond;
	}

	public void setEntityItemVWSearchCond(SOC0124SearchCond entityItemVWSearchCond) {
		this.entityItemVWSearchCond = entityItemVWSearchCond;
	}

	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	public List<SOC0124Info> getEntityItemVWInfoList() {
		return entityItemVWInfoList;
	}

	public void setEntityItemVWInfoList(List<SOC0124Info> entityItemVWInfoList) {
		this.entityItemVWInfoList = entityItemVWInfoList;
	}

	public String[] getDeleteEntityItem() {
		return deleteEntityItem;
	}

	public void setDeleteEntityItem(String[] deleteEntityItem) {
		this.deleteEntityItem = deleteEntityItem;
	}

	public IGASM0204Form getIgasm0204Form() {
		return igasm0204Form;
	}

	public void setIgasm0204Form(IGASM0204Form igasm0204Form) {
		this.igasm0204Form = igasm0204Form;
	}

	public List<LabelValueBean> getRelationList() {
		return relationList;
	}

	public void setRelationList(List<LabelValueBean> relationList) {
		this.relationList = relationList;
	}

	public SOC0124Info getEntityItemVWInfo() {
		return entityItemVWInfo;
	}

	public void setEntityItemVWInfo(SOC0124Info entityItemVWInfo) {
		this.entityItemVWInfo = entityItemVWInfo;
	}

	public IGASM0205Form getIgasm0205Form() {
		return igasm0205Form;
	}

	public void setIgasm0205Form(IGASM0205Form igasm0205Form) {
		this.igasm0205Form = igasm0205Form;
	}

	public List<ConfigItem> getConfigItemList() {
		return configItemList;
	}

	public void setConfigItemList(List<ConfigItem> configItemList) {
		this.configItemList = configItemList;
	}

	public IGASM0206Form getIgasm0206Form() {
		return igasm0206Form;
	}

	public void setIgasm0206Form(IGASM0206Form igasm0206Form) {
		this.igasm0206Form = igasm0206Form;
	}

	public List<SOC0119Info> getParEntityItemRelationList() {
		return parEntityItemRelationList;
	}

	public void setParEntityItemRelationList(
			List<SOC0119Info> parEntityItemRelationList) {
		this.parEntityItemRelationList = parEntityItemRelationList;
	}

	public List<SOC0119Info> getCldEntityItemRelationList() {
		return cldEntityItemRelationList;
	}

	public void setCldEntityItemRelationList(
			List<SOC0119Info> cldEntityItemRelationList) {
		this.cldEntityItemRelationList = cldEntityItemRelationList;
	}

	public IGASM0207Form getIgasm0207Form() {
		return igasm0207Form;
	}

	public void setIgasm0207Form(IGASM0207Form igasm0207Form) {
		this.igasm0207Form = igasm0207Form;
	}

	public SOC0119Info getEntityItemRelation() {
		return entityItemRelation;
	}

	public void setEntityItemRelation(SOC0119Info entityItemRelation) {
		this.entityItemRelation = entityItemRelation;
	}

	public String[] getDeleteEntityItemRelation() {
		return deleteEntityItemRelation;
	}

	public void setDeleteEntityItemRelation(String[] deleteEntityItemRelation) {
		this.deleteEntityItemRelation = deleteEntityItemRelation;
	}

	public Map<String, List<ConfigItem>> getConfigItemMap() {
		return configItemMap;
	}

	public void setConfigItemMap(Map<String, List<ConfigItem>> configItemMap) {
		this.configItemMap = configItemMap;
	}

	public IGMNT0204Form getIgmnt0204Form() {
		return igmnt0204Form;
	}

	public void setIgmnt0204Form(IGMNT0204Form igmnt0204Form) {
		this.igmnt0204Form = igmnt0204Form;
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

	public void setIgasm0202Form(IGASM0202Form igasm0202Form) {
		this.igasm0202Form = igasm0202Form;
	}
	public List<SOC0129Info> getConfigItemVWInfoList() {
		return configItemVWInfoList;
	}

	public void setConfigItemVWInfoList(List<SOC0129Info> configItemVWInfoList) {
		this.configItemVWInfoList = configItemVWInfoList;
	}

	public Map<String, List<SOC0129Info>> getConfigItemVWInfoMap() {
		return configItemVWInfoMap;
	}

	public void setConfigItemVWInfoMap(
			Map<String, List<SOC0129Info>> configItemVWInfoMap) {
		this.configItemVWInfoMap = configItemVWInfoMap;
	}

	
}


