package com.deliverik.infogovernor.asset.dto;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.IG800Info;
import com.deliverik.framework.asset.model.IG002Info;
import com.deliverik.framework.asset.model.IG313Info;
import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.asset.model.condition.IG688SearchCond;
import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.asset.form.IGASM0702Form;
import com.deliverik.infogovernor.asset.form.IGASM0704Form;
import com.deliverik.infogovernor.asset.form.IGASM0705Form;
import com.deliverik.infogovernor.asset.form.IGASM0706Form;
import com.deliverik.infogovernor.asset.form.IGASM0707Form;

/**
 * 机房配置管理业务用DTO
 * 
 */
@SuppressWarnings("serial")
public class IGASM07DTO extends BaseDTO implements Serializable{

	/** 机房信息 */
	protected IGASM0702Form igasm0702Form;
	
	/** 机房信息检索条件 */
	protected IG688SearchCond entityItemVWSearchCond;
	
	/** 检索最大件数 */
	protected int maxSearchCount;

	/** 翻页用DTO */
	protected PagingDTO pagingDto;

	/** 机房检索结果 */
	protected List<IG688Info> entityItemVWInfoList;

	/** 机房删除对象 */
	protected String[] deleteEntityItem;

	/** 机房配置信息 */
	protected IGASM0704Form igasm0704Form;
	
	/** 机房配置信息检索结果 */
	protected List<IG002Info> configItemVWInfoList;

	/** 机房配置信息画面机房信息 */
	protected IG688Info entityItemVWInfo;

	/** 机房配置信息历史记录检索条件 */
	protected IGASM0705Form igasm0705Form;
	
	/** 机房配置信息历史记录检索结果 */
	protected List<IG800Info> configItemList;
	
	/** 机房关系管理检索条件 */
	protected IGASM0706Form igasm0706Form;
	
	/** 资产项关系管理信息检索结果1 */
	protected List<IG313Info> parEntityItemRelationList;
	
	/** 资产项关系管理信息检索结果2 */
	protected List<IG313Info> cldEntityItemRelationList;
	
	/** 机房关系编辑信息 */
	protected IGASM0707Form igasm0707Form;
	
	/** 机房关系编辑后信息 */
	protected IG313Info entityItemRelation;

	/** 机房关系删除对象 */
	protected String[] deleteEntityItemRelation;

	/**
	 * 机房信息取得
	 * @return 机房信息
	 */
	public IGASM0702Form getIgasm0702Form() {
		return igasm0702Form;
	}

	/**
	 * 机房信息设定
	 *
	 * @param igasm0702Form 机房信息
	 */
	public void setIgasm0702Form(IGASM0702Form igasm0702Form) {
		this.igasm0702Form = igasm0702Form;
	}

	/**
	 * 机房信息检索条件取得
	 * @return 机房信息检索条件
	 */
	public IG688SearchCond getEntityItemVWSearchCond() {
		return entityItemVWSearchCond;
	}

	/**
	 * 机房信息检索条件设定
	 *
	 * @param entityItemVWSearchCond 机房信息检索条件
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
	 * 机房检索结果取得
	 * @return 机房检索结果
	 */
	public List<IG688Info> getEntityItemVWInfoList() {
		return entityItemVWInfoList;
	}

	/**
	 * 机房检索结果设定
	 *
	 * @param entityItemVWInfoList 机房检索结果
	 */
	public void setEntityItemVWInfoList(List<IG688Info> entityItemVWInfoList) {
		this.entityItemVWInfoList = entityItemVWInfoList;
	}

	/**
	 * 机房删除对象取得
	 * @return 机房删除对象
	 */
	public String[] getDeleteEntityItem() {
		return deleteEntityItem;
	}

	/**
	 * 机房删除对象设定
	 *
	 * @param deleteEntityItem 机房删除对象
	 */
	public void setDeleteEntityItem(String[] deleteEntityItem) {
		this.deleteEntityItem = deleteEntityItem;
	}

	/**
	 * 机房配置信息取得
	 * @return 机房配置信息
	 */
	public IGASM0704Form getIgasm0704Form() {
		return igasm0704Form;
	}


	/**
	 * 机房配置信息检索条件设定
	 *
	 * @param igasm0704Form 机房配置信息检索条件
	 */
	public void setIgasm0704Form(IGASM0704Form igasm0704Form) {
		this.igasm0704Form = igasm0704Form;
	}

	/**
	 * 机房配置信息检索结果取得
	 * @return 机房配置信息检索结果
	 */
	public List<IG002Info> getConfigItemVWInfoList() {
		return configItemVWInfoList;
	}

	/**
	 * 机房配置信息检索结果设定
	 *
	 * @param configItemVWInfoList 机房配置信息检索结果
	 */
	public void setConfigItemVWInfoList(List<IG002Info> configItemVWInfoList) {
		this.configItemVWInfoList = configItemVWInfoList;
	}

	/**
	 * 机房配置信息画面机房信息取得
	 * @return 机房配置信息画面机房信息
	 */
	public IG688Info getEntityItemVWInfo() {
		return entityItemVWInfo;
	}

	/**
	 * 机房配置信息画面机房信息设定
	 *
	 * @param entityItemVWInfo 机房配置信息画面机房信息
	 */
	public void setEntityItemVWInfo(IG688Info entityItemVWInfo) {
		this.entityItemVWInfo = entityItemVWInfo;
	}

	/**
	 * 机房配置信息历史记录检索条件取得
	 * @return 机房配置信息历史记录检索条件
	 */
	public IGASM0705Form getIgasm0705Form() {
		return igasm0705Form;
	}

	/**
	 * 机房配置信息历史记录检索条件设定
	 *
	 * @param igasm0705Form 机房配置信息历史记录检索条件
	 */
	public void setIgasm0705Form(IGASM0705Form igasm0705Form) {
		this.igasm0705Form = igasm0705Form;
	}

	/**
	 * 机房配置信息历史记录检索结果取得
	 * @return 机房配置信息历史记录检索结果
	 */
	public List<IG800Info> getConfigItemList() {
		return configItemList;
	}

	/**
	 * 机房配置信息历史记录检索结果设定
	 *
	 * @param configItemList 机房配置信息历史记录检索结果
	 */
	public void setConfigItemList(List<IG800Info> configItemList) {
		this.configItemList = configItemList;
	}

	/**
	 * 机房关系管理检索条件取得
	 * @return 机房关系管理检索条件
	 */
	public IGASM0706Form getIgasm0706Form() {
		return igasm0706Form;
	}

	/**
	 * 机房关系管理检索条件设定
	 *
	 * @param igasm0706Form 机房关系管理检索条件
	 */
	public void setIgasm0706Form(IGASM0706Form igasm0706Form) {
		this.igasm0706Form = igasm0706Form;
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
	 * 机房关系编辑信息取得
	 * @return 编辑信息
	 */
	public IGASM0707Form getIgasm0707Form() {
		return igasm0707Form;
	}

	/**
	 * 机房关系编辑信息设定
	 *
	 * @param igasm0707Form 机房关系编辑信息
	 */
	public void setIgasm0707Form(IGASM0707Form igasm0707Form) {
		this.igasm0707Form = igasm0707Form;
	}

	/**
	 * 机房关系编辑后信息取得
	 * @return 机房关系编辑后信息
	 */
	public IG313Info getEntityItemRelation() {
		return entityItemRelation;
	}

	/**
	 * 机房关系编辑后信息设定
	 *
	 * @param entityItemRelation 机房关系编辑后信息
	 */
	public void setEntityItemRelation(IG313Info entityItemRelation) {
		this.entityItemRelation = entityItemRelation;
	}

	/**
	 * 机房关系删除对象取得
	 * @return 机房关系删除对象
	 */
	public String[] getDeleteEntityItemRelation() {
		return deleteEntityItemRelation;
	}

	/**
	 * 机房关系删除对象设定
	 *
	 * @param entityItemRelation 机房关系删除对象
	 */
	public void setDeleteEntityItemRelation(String[] deleteEntityItemRelation) {
		this.deleteEntityItemRelation = deleteEntityItemRelation;
	}

}


