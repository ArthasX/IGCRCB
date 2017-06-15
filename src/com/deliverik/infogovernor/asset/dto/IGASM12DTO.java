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
import com.deliverik.infogovernor.asset.form.IGASM1202Form;
import com.deliverik.infogovernor.asset.form.IGASM1204Form;
import com.deliverik.infogovernor.asset.form.IGASM1205Form;
import com.deliverik.infogovernor.asset.form.IGASM1206Form;
import com.deliverik.infogovernor.asset.form.IGASM1207Form;

/**
 * 机柜配置管理业务用DTO
 * 
 */
@SuppressWarnings("serial")
public class IGASM12DTO extends BaseDTO implements Serializable{

	/** 机柜信息 */
	protected IGASM1202Form igasm1202Form;
	
	/** 机柜信息检索条件 */
	protected IG688SearchCond entityItemVWSearchCond;
	
	/** 检索最大件数 */
	protected int maxSearchCount;

	/** 翻页用DTO */
	protected PagingDTO pagingDto;

	/** 机柜检索结果 */
	protected List<IG688Info> entityItemVWInfoList;

	/** 机柜删除对象 */
	protected String[] deleteEntityItem;

	/** 机柜配置信息 */
	protected IGASM1204Form igasm1204Form;
	
	/** 机柜配置信息检索结果 */
	protected List<IG002Info> configItemVWInfoList;

	/** 机柜配置信息画面机柜信息 */
	protected IG688Info entityItemVWInfo;

	/** 机柜配置信息历史记录检索条件 */
	protected IGASM1205Form igasm1205Form;
	
	/** 机柜配置信息历史记录检索结果 */
	protected List<IG800Info> configItemList;
	
	/** 机柜关系管理检索条件 */
	protected IGASM1206Form igasm1206Form;
	
	/** 资产项关系管理信息检索结果1 */
	protected List<IG313Info> parEntityItemRelationList;
	
	/** 资产项关系管理信息检索结果2 */
	protected List<IG313Info> cldEntityItemRelationList;
	
	/** 机柜关系编辑信息 */
	protected IGASM1207Form igasm1207Form;
	
	/** 机柜关系编辑后信息 */
	protected IG313Info entityItemRelation;

	/** 机柜关系删除对象 */
	protected String[] deleteEntityItemRelation;

	/**
	 * 机柜信息取得
	 * @return 机柜信息
	 */
	public IGASM1202Form getIgasm1202Form() {
		return igasm1202Form;
	}

	/**
	 * 机柜信息设定
	 *
	 * @param igasm1202Form 机柜信息
	 */
	public void setIgasm1202Form(IGASM1202Form igasm1202Form) {
		this.igasm1202Form = igasm1202Form;
	}

	/**
	 * 机柜信息检索条件取得
	 * @return 机柜信息检索条件
	 */
	public IG688SearchCond getEntityItemVWSearchCond() {
		return entityItemVWSearchCond;
	}

	/**
	 * 机柜信息检索条件设定
	 *
	 * @param entityItemVWSearchCond 机柜信息检索条件
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
	 * 机柜检索结果取得
	 * @return 机柜检索结果
	 */
	public List<IG688Info> getEntityItemVWInfoList() {
		return entityItemVWInfoList;
	}

	/**
	 * 机柜检索结果设定
	 *
	 * @param entityItemVWInfoList 机柜检索结果
	 */
	public void setEntityItemVWInfoList(List<IG688Info> entityItemVWInfoList) {
		this.entityItemVWInfoList = entityItemVWInfoList;
	}

	/**
	 * 机柜删除对象取得
	 * @return 机柜删除对象
	 */
	public String[] getDeleteEntityItem() {
		return deleteEntityItem;
	}

	/**
	 * 机柜删除对象设定
	 *
	 * @param deleteEntityItem 机柜删除对象
	 */
	public void setDeleteEntityItem(String[] deleteEntityItem) {
		this.deleteEntityItem = deleteEntityItem;
	}

	/**
	 * 机柜配置信息取得
	 * @return 机柜配置信息
	 */
	public IGASM1204Form getIgasm1204Form() {
		return igasm1204Form;
	}


	/**
	 * 机柜配置信息检索条件设定
	 *
	 * @param igasm1204Form 机柜配置信息检索条件
	 */
	public void setIgasm1204Form(IGASM1204Form igasm1204Form) {
		this.igasm1204Form = igasm1204Form;
	}

	/**
	 * 机柜配置信息检索结果取得
	 * @return 机柜配置信息检索结果
	 */
	public List<IG002Info> getConfigItemVWInfoList() {
		return configItemVWInfoList;
	}

	/**
	 * 机柜配置信息检索结果设定
	 *
	 * @param configItemVWInfoList 机柜配置信息检索结果
	 */
	public void setConfigItemVWInfoList(List<IG002Info> configItemVWInfoList) {
		this.configItemVWInfoList = configItemVWInfoList;
	}

	/**
	 * 机柜配置信息画面机柜信息取得
	 * @return 机柜配置信息画面机柜信息
	 */
	public IG688Info getEntityItemVWInfo() {
		return entityItemVWInfo;
	}

	/**
	 * 机柜配置信息画面机柜信息设定
	 *
	 * @param entityItemVWInfo 机柜配置信息画面机柜信息
	 */
	public void setEntityItemVWInfo(IG688Info entityItemVWInfo) {
		this.entityItemVWInfo = entityItemVWInfo;
	}

	/**
	 * 机柜配置信息历史记录检索条件取得
	 * @return 机柜配置信息历史记录检索条件
	 */
	public IGASM1205Form getIgasm1205Form() {
		return igasm1205Form;
	}

	/**
	 * 机柜配置信息历史记录检索条件设定
	 *
	 * @param igasm1205Form 机柜配置信息历史记录检索条件
	 */
	public void setIgasm1205Form(IGASM1205Form igasm1205Form) {
		this.igasm1205Form = igasm1205Form;
	}

	/**
	 * 机柜配置信息历史记录检索结果取得
	 * @return 机柜配置信息历史记录检索结果
	 */
	public List<IG800Info> getConfigItemList() {
		return configItemList;
	}

	/**
	 * 机柜配置信息历史记录检索结果设定
	 *
	 * @param configItemList 机柜配置信息历史记录检索结果
	 */
	public void setConfigItemList(List<IG800Info> configItemList) {
		this.configItemList = configItemList;
	}

	/**
	 * 机柜关系管理检索条件取得
	 * @return 机柜关系管理检索条件
	 */
	public IGASM1206Form getIgasm1206Form() {
		return igasm1206Form;
	}

	/**
	 * 机柜关系管理检索条件设定
	 *
	 * @param igasm1206Form 机柜关系管理检索条件
	 */
	public void setIgasm1206Form(IGASM1206Form igasm1206Form) {
		this.igasm1206Form = igasm1206Form;
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
	 * 机柜关系编辑信息取得
	 * @return 编辑信息
	 */
	public IGASM1207Form getIgasm1207Form() {
		return igasm1207Form;
	}

	/**
	 * 机柜关系编辑信息设定
	 *
	 * @param igasm1207Form 机柜关系编辑信息
	 */
	public void setIgasm1207Form(IGASM1207Form igasm1207Form) {
		this.igasm1207Form = igasm1207Form;
	}

	/**
	 * 机柜关系编辑后信息取得
	 * @return 机柜关系编辑后信息
	 */
	public IG313Info getEntityItemRelation() {
		return entityItemRelation;
	}

	/**
	 * 机柜关系编辑后信息设定
	 *
	 * @param entityItemRelation 机柜关系编辑后信息
	 */
	public void setEntityItemRelation(IG313Info entityItemRelation) {
		this.entityItemRelation = entityItemRelation;
	}

	/**
	 * 机柜关系删除对象取得
	 * @return 机柜关系删除对象
	 */
	public String[] getDeleteEntityItemRelation() {
		return deleteEntityItemRelation;
	}

	/**
	 * 机柜关系删除对象设定
	 *
	 * @param entityItemRelation 机柜关系删除对象
	 */
	public void setDeleteEntityItemRelation(String[] deleteEntityItemRelation) {
		this.deleteEntityItemRelation = deleteEntityItemRelation;
	}

}


