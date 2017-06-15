/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.crc.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.infogovernor.crc.form.IGCRC1301Form;
import com.deliverik.infogovernor.crc.form.IGCRC1304Form;
import com.deliverik.infogovernor.crc.model.IGCRC1303VWInfo;
import com.deliverik.infogovernor.crc.model.condition.IGCRC1304Cond;
import com.deliverik.infogovernor.crc.model.entity.DepartModelVW;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 文档查询用DTO
 * </p>
 * 
 * @author 
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGCRC1304DTO extends BaseDTO implements Serializable{
	
	
	/** 文档查询画面FORM */
	private IGCRC1304Form igcrc1304Form;
	
	
	protected IGCRC1301Form igcrc1301Form;
	
	/** 文档信息检索条件 */
	protected IGCRC1304Cond entityItemVWSearchCond;

	/** 翻页用DTO */
	protected PagingDTO pagingDto;

	/** 机房检索结果 */
	protected List<IGCRC1303VWInfo> entityItemVWInfoList;

	/** 检索最大件数 */
	protected int maxSearchCount;
	
	/** 用户 */
	protected User user;
	
	/** 是不是管理员 */
	protected String isManeger;
	
	/** 流程信息集合 */
	protected List<IG500Info> processList;
	
	protected Map<String,Integer> maps = new HashMap<String,Integer>();
	
	/** 封装DepartModelVW集合  */
	protected List<DepartModelVW> ListVM = new ArrayList<DepartModelVW>();

	public List<DepartModelVW> getListVM() {
		return ListVM;
	}

	public void setListVM(List<DepartModelVW> listVM) {
		ListVM = listVM;
	}

	/**
	 * @return the processList
	 */
	public List<IG500Info> getProcessList() {
		return processList;
	}

	/**
	 * @param processList the processList to set
	 */
	public void setProcessList(List<IG500Info> processList) {
		this.processList = processList;
	}

	public Map<String, Integer> getMaps() {
		return maps;
	}

	public void setMaps(Map<String, Integer> maps) {
		this.maps = maps;
	}

	  
	/**
	 * @return the igcrc1301Form
	 */
	public IGCRC1301Form getIgcrc1301Form() {
		return igcrc1301Form;
	}

	/**
	 * @param igcrc1301Form the igcrc1301Form to set
	 */
	public void setIgcrc1301Form(IGCRC1301Form igcrc1301Form) {
		this.igcrc1301Form = igcrc1301Form;
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
	 * 文档信息检索结果取得
	 * @return 文档信息检索结果
	 */
	public List<IGCRC1303VWInfo> getEntityItemVWInfoList() {
		return entityItemVWInfoList;
	}

	/**
	 * 文档信息检索结果设定
	 *
	 * @param entityItemVWInfoList 文档信息检索结果
	 */
	public void setEntityItemVWInfoList(List<IGCRC1303VWInfo> entityItemVWInfoList) {
		this.entityItemVWInfoList = entityItemVWInfoList;
	}

	
	
	public IGCRC1304Form getIgcrc1304Form() {
		return igcrc1304Form;
	}

	public void setIgcrc1304Form(IGCRC1304Form igcrc1304Form) {
		this.igcrc1304Form = igcrc1304Form;
	}

	/**
	 * 文档信息检索条件取得
	 * @return 文档信息检索条件
	 */
	public IGCRC1304Cond getEntityItemVWSearchCond() {
		return entityItemVWSearchCond;
	}

	/**
	 * 文档信息检索条件设定
	 *
	 * @param entityItemVWSearchCond 文档信息检索条件
	 */
	public void setEntityItemVWSearchCond(IGCRC1304Cond entityItemVWSearchCond) {
		this.entityItemVWSearchCond = entityItemVWSearchCond;
	}

	/**
	 * 用户取得
	 * @return user 用户
	 */
	public User getUser() {
		return user;
	}

	/**
	 * 用户设定
	 * @param user 用户
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * 是不是管理员取得
	 * @return isManeger 是不是管理员
	 */
	public String getIsManeger() {
		return isManeger;
	}

	/**
	 * 是不是管理员设定
	 * @param isManeger 是不是管理员
	 */
	public void setIsManeger(String isManeger) {
		this.isManeger = isManeger;
	}

}
