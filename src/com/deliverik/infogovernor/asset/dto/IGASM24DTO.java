package com.deliverik.infogovernor.asset.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.asset.model.IG800Info;
import com.deliverik.framework.asset.model.IG002Info;
import com.deliverik.framework.asset.model.IG887Info;
import com.deliverik.framework.asset.model.IG313Info;
import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.asset.model.condition.IG688SearchCond;
import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.asset.form.IGASM2402Form;
import com.deliverik.infogovernor.asset.form.IGASM2404Form;
import com.deliverik.infogovernor.asset.form.IGASM2405Form;
import com.deliverik.infogovernor.asset.form.IGASM2406Form;
import com.deliverik.infogovernor.asset.form.IGASM2407Form;
import com.deliverik.infogovernor.asset.form.IGASM2412Form;

/**
 * 发票配置管理业务用DTO
 * 修改记录: 2012/11/27 LuJiayuan 增加标识判断是否显示图像按钮
 */
@SuppressWarnings("serial")
public class IGASM24DTO extends BaseDTO implements Serializable{

	/** 发票信息 */
	protected IGASM2402Form igasm2402Form;
	
	/** 发票信息检索条件 */
	protected IG688SearchCond entityItemVWSearchCond;
	
	/** 检索最大件数 */
	protected int maxSearchCount;

	/** 翻页用DTO */
	protected PagingDTO pagingDto;

	/** 发票检索结果 */
	protected List<IG688Info> entityItemVWInfoList;

	/** 发票删除对象 */
	protected String[] deleteEntityItem;

	/** 发票配置信息 */
	protected IGASM2404Form igasm2404Form;
	
	/** 发票配置信息检索结果 */
	protected List<IG002Info> configItemVWInfoList;

	/** 发票配置信息画面发票信息 */
	protected IG688Info entityItemVWInfo;

	/** 发票配置信息历史记录检索条件 */
	protected IGASM2405Form igasm2405Form;
	
	/** 发票配置信息历史记录检索结果 */
	protected List<IG800Info> configItemList;
	
	/** 发票关系管理检索条件 */
	protected IGASM2406Form igasm2406Form;
	
	/** 资产项关系管理信息检索结果1 */
	protected List<IG313Info> parEntityItemRelationList;
	
	/** 资产项关系管理信息检索结果2 */
	protected List<IG313Info> cldEntityItemRelationList;
	
	/** 发票关系编辑信息 */
	protected IGASM2407Form igasm2407Form;
	
	/** 发票关系编辑后信息 */
	protected IG313Info entityItemRelation;

	/** 发票关系删除对象 */
	protected String[] deleteEntityItemRelation;
	
	/** 资产管理关系下拉列表 */
	protected List<LabelValueBean> relationList;
	
	/** 资产项配置信息检索结果 */
	protected Map<String,List<IG800Info>> configItemMap;
	
	/** 资产项配置信息检索结果 */
	protected Map<String,List<IG002Info>> configItemVWInfoMap;
	
	protected Map<String,List<IG313Info>> parEntityItemRelationMap;
	protected Map<String,List<IG313Info>> cldEntityItemRelationMap;
	protected int parCount;
	protected int cldCount;
	/** 发票所属机构名称 */
	protected String eiorgname;
	protected IGASM2412Form igasm2412Form;
	
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
	protected List<IG887Info> configItemVersionTime;

    private String picuXml;

    private String picsXml;
    
    /** 是否显示图像按钮 */
    protected Boolean image_flag;
	
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
	
	
	public IGASM2412Form getIgasm2412Form() {
		return igasm2412Form;
	}

	public void setIgasm2412Form(IGASM2412Form igasm2412Form) {
		this.igasm2412Form = igasm2412Form;
	}
	public String getEiorgname() {
		return eiorgname;
	}

	public void setEiorgname(String eiorgname) {
		this.eiorgname = eiorgname;
	}
	public Map<String, List<IG313Info>> getParEntityItemRelationMap() {
		return parEntityItemRelationMap;
	}

	public void setParEntityItemRelationMap(
			Map<String, List<IG313Info>> parEntityItemRelationMap) {
		this.parEntityItemRelationMap = parEntityItemRelationMap;
	}

	public Map<String, List<IG313Info>> getCldEntityItemRelationMap() {
		return cldEntityItemRelationMap;
	}

	public void setCldEntityItemRelationMap(
			Map<String, List<IG313Info>> cldEntityItemRelationMap) {
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
	 * 发票信息取得
	 * @return 发票信息
	 */
	public IGASM2402Form getIgasm2402Form() {
		return igasm2402Form;
	}

	/**
	 * 发票信息设定
	 *
	 * @param igasm2402Form 发票信息
	 */
	public void setIgasm2402Form(IGASM2402Form igasm2402Form) {
		this.igasm2402Form = igasm2402Form;
	}

	/**
	 * 发票信息检索条件取得
	 * @return 发票信息检索条件
	 */
	public IG688SearchCond getEntityItemVWSearchCond() {
		return entityItemVWSearchCond;
	}

	/**
	 * 发票信息检索条件设定
	 *
	 * @param entityItemVWSearchCond 发票信息检索条件
	 */
	public void setEntityItemVWSearchCond(
			IG688SearchCond entityItemVWSearchCond) {
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
	 * 发票检索结果取得
	 * @return 发票检索结果
	 */
	public List<IG688Info> getEntityItemVWInfoList() {
		return entityItemVWInfoList;
	}

	/**
	 * 发票检索结果设定
	 *
	 * @param entityItemVWInfoList 发票检索结果
	 */
	public void setEntityItemVWInfoList(List<IG688Info> entityItemVWInfoList) {
		this.entityItemVWInfoList = entityItemVWInfoList;
	}

	/**
	 * 发票删除对象取得
	 * @return 发票删除对象
	 */
	public String[] getDeleteEntityItem() {
		return deleteEntityItem;
	}

	/**
	 * 发票删除对象设定
	 *
	 * @param deleteEntityItem 发票删除对象
	 */
	public void setDeleteEntityItem(String[] deleteEntityItem) {
		this.deleteEntityItem = deleteEntityItem;
	}

	/**
	 * 发票配置信息取得
	 * @return 发票配置信息
	 */
	public IGASM2404Form getIgasm2404Form() {
		return igasm2404Form;
	}


	/**
	 * 发票配置信息检索条件设定
	 *
	 * @param igasm2404Form 发票配置信息检索条件
	 */
	public void setIgasm2404Form(IGASM2404Form igasm2404Form) {
		this.igasm2404Form = igasm2404Form;
	}

	/**
	 * 发票配置信息检索结果取得
	 * @return 发票配置信息检索结果
	 */
	public List<IG002Info> getConfigItemVWInfoList() {
		return configItemVWInfoList;
	}

	/**
	 * 发票配置信息检索结果设定
	 *
	 * @param configItemVWInfoList 发票配置信息检索结果
	 */
	public void setConfigItemVWInfoList(List<IG002Info> configItemVWInfoList) {
		this.configItemVWInfoList = configItemVWInfoList;
	}

	/**
	 * 发票配置信息画面发票信息取得
	 * @return 发票配置信息画面发票信息
	 */
	public IG688Info getEntityItemVWInfo() {
		return entityItemVWInfo;
	}

	/**
	 * 发票配置信息画面发票信息设定
	 *
	 * @param entityItemVWInfo 发票配置信息画面发票信息
	 */
	public void setEntityItemVWInfo(IG688Info entityItemVWInfo) {
		this.entityItemVWInfo = entityItemVWInfo;
	}

	/**
	 * 发票配置信息历史记录检索条件取得
	 * @return 发票配置信息历史记录检索条件
	 */
	public IGASM2405Form getIgasm2405Form() {
		return igasm2405Form;
	}

	/**
	 * 发票配置信息历史记录检索条件设定
	 *
	 * @param igasm2405Form 发票配置信息历史记录检索条件
	 */
	public void setIgasm2405Form(IGASM2405Form igasm2405Form) {
		this.igasm2405Form = igasm2405Form;
	}

	/**
	 * 发票配置信息历史记录检索结果取得
	 * @return 发票配置信息历史记录检索结果
	 */
	public List<IG800Info> getConfigItemList() {
		return configItemList;
	}

	/**
	 * 发票配置信息历史记录检索结果设定
	 *
	 * @param configItemList 发票配置信息历史记录检索结果
	 */
	public void setConfigItemList(List<IG800Info> configItemList) {
		this.configItemList = configItemList;
	}

	/**
	 * 发票关系管理检索条件取得
	 * @return 发票关系管理检索条件
	 */
	public IGASM2406Form getIgasm2406Form() {
		return igasm2406Form;
	}

	/**
	 * 发票关系管理检索条件设定
	 *
	 * @param igasm2406Form 发票关系管理检索条件
	 */
	public void setIgasm2406Form(IGASM2406Form igasm2406Form) {
		this.igasm2406Form = igasm2406Form;
	}

	/**
	 * 资产项关系管理信息检索结果1取得
	 * @return 资产项关系管理信息检索结果1
	 */
	public List<IG313Info> getParEntityItemRelationList() {
		return parEntityItemRelationList;
	}

	/**
	 * 资产项关系管理信息检索结果1设定
	 *
	 * @param parEntityItemRelationList 资产项关系管理信息检索结果1
	 */
	public void setParEntityItemRelationList(
			List<IG313Info> parEntityItemRelationList) {
		this.parEntityItemRelationList = parEntityItemRelationList;
	}

	/**
	 * 资产项关系管理信息检索结果2取得
	 * @return 资产项关系管理信息检索结果2
	 */
	public List<IG313Info> getCldEntityItemRelationList() {
		return cldEntityItemRelationList;
	}

	/**
	 * 资产项关系管理信息检索结果2设定
	 *
	 * @param cldEntityItemRelationList 资产项关系管理信息检索结果2
	 */
	public void setCldEntityItemRelationList(
			List<IG313Info> cldEntityItemRelationList) {
		this.cldEntityItemRelationList = cldEntityItemRelationList;
	}

	/**
	 * 发票关系编辑信息取得
	 * @return 编辑信息
	 */
	public IGASM2407Form getIgasm2407Form() {
		return igasm2407Form;
	}

	/**
	 * 发票关系编辑信息设定
	 *
	 * @param igasm2407Form 发票关系编辑信息
	 */
	public void setIgasm2407Form(IGASM2407Form igasm2407Form) {
		this.igasm2407Form = igasm2407Form;
	}

	/**
	 * 发票关系编辑后信息取得
	 * @return 发票关系编辑后信息
	 */
	public IG313Info getEntityItemRelation() {
		return entityItemRelation;
	}

	/**
	 * 发票关系编辑后信息设定
	 *
	 * @param entityItemRelation 发票关系编辑后信息
	 */
	public void setEntityItemRelation(IG313Info entityItemRelation) {
		this.entityItemRelation = entityItemRelation;
	}

	/**
	 * 发票关系删除对象取得
	 * @return 发票关系删除对象
	 */
	public String[] getDeleteEntityItemRelation() {
		return deleteEntityItemRelation;
	}

	/**
	 * 发票关系删除对象设定
	 *
	 * @param entityItemRelation 发票关系删除对象
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
	public Map<String, List<IG800Info>> getConfigItemMap() {
		return configItemMap;
	}
	/**
	 * 资产项配置信息检索结果设定
	 *
	 * @param configItemMap 资产项配置信息检索结果
	 */
	public void setConfigItemMap(
			Map<String, List<IG800Info>> configItemMap) {
		this.configItemMap = configItemMap;
	}
	
	/**
	 * 资产项配置信息检索结果取得
	 * @return 资产项配置信息检索结果
	 */
	public Map<String, List<IG002Info>> getConfigItemVWInfoMap() {
		return configItemVWInfoMap;
	}
	/**
	 * 资产项配置信息检索结果设定
	 *
	 * @param configItemVWInfoMap 资产项配置信息检索结果
	 */
	public void setConfigItemVWInfoMap(
			Map<String, List<IG002Info>> configItemVWInfoMap) {
		this.configItemVWInfoMap = configItemVWInfoMap;
	}

	/**
	 * 资产版本列表取得
	 * @return 资产版本列表
	 */
	public List<IG887Info> getConfigItemVersionTime() {
		return configItemVersionTime;
	}

	/**
	 * 资产版本列表设定
	 *
	 * @param configItemVersionTime 资产版本列表
	 */
	public void setConfigItemVersionTime(
			List<IG887Info> configItemVersionTime) {
		this.configItemVersionTime = configItemVersionTime;
	}

    /**
     * @return
     */
    public String getPicsXml() {
        return picsXml;
    }

    /**
     * @return
     */
    public String getPicuXml() {
        // TODO Auto-generated method stub
        return picuXml;
    }

    /**
     * picuXml is set.
     * @param picuXml picuXml
     */
    public void setPicuXml(String picuXml) {
        this.picuXml = picuXml;
    }

    /**
     * picsXml is set.
     * @param picsXml picsXml
     */
    public void setPicsXml(String picsXml) {
        this.picsXml = picsXml;
    }
    
	/**
	 * 是否显示图像按钮取得
	 *
	 * @return image_flag 是否显示图像按钮
	 */
	public Boolean getImage_flag() {
		return image_flag;
	}
	
	/**
	 * 是否显示图像按钮设定
	 *
	 * @param image_flag 是否显示图像按钮
	 */
	public void setImage_flag(Boolean image_flag) {
		this.image_flag = image_flag;
	}
}