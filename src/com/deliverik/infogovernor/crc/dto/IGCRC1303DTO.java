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
import com.deliverik.infogovernor.crc.form.IGCRC1303Form;
import com.deliverik.infogovernor.crc.model.IGCRC1303VWInfo;
import com.deliverik.infogovernor.crc.model.condition.IGCRC1303Cond;
import com.deliverik.infogovernor.crc.model.entity.ModelVW;

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
public class IGCRC1303DTO extends BaseDTO implements Serializable{
	
	
	/** 文档查询画面FORM */
	private IGCRC1303Form igcrc1303Form;
	
	/** 文档信息检索条件 */
	protected IGCRC1303Cond entityItemVWSearchCond;

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
	
	/** 下载项的主键*/
	protected Integer ddid;
	
	/** 下载项的部门名称*/
	protected String civalue;
	
	public Integer getDdid() {
		return ddid;
	}

	public void setDdid(Integer ddid) {
		this.ddid = ddid;
	}

	public String getCivalue() {
		return civalue;
	}

	public void setCivalue(String civalue) {
		this.civalue = civalue;
	}

	protected Map<String,Integer> maps = new HashMap<String,Integer>();
	
	protected List<ModelVW> ListVM = new ArrayList<ModelVW>();
	
	
	public List<ModelVW> getListVM() {
		return ListVM;
	}

	public void setListVM(List<ModelVW> listVM) {
		ListVM = listVM;
	}

	public Map<String, Integer> getMaps() {
		return maps;
	}

	public void setMaps(Map<String, Integer> maps) {
		this.maps = maps;
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

	
	
	public IGCRC1303Form getIgcrc1303Form() {
		return igcrc1303Form;
	}

	public void setIgcrc1303Form(IGCRC1303Form igcrc1303Form) {
		this.igcrc1303Form = igcrc1303Form;
	}

	/**
	 * 文档信息检索条件取得
	 * @return 文档信息检索条件
	 */
	public IGCRC1303Cond getEntityItemVWSearchCond() {
		return entityItemVWSearchCond;
	}

	/**
	 * 文档信息检索条件设定
	 *
	 * @param entityItemVWSearchCond 文档信息检索条件
	 */
	public void setEntityItemVWSearchCond(IGCRC1303Cond entityItemVWSearchCond) {
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
