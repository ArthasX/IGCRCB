/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.crc.dto;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.workflow.prr.model.IG500Info;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 
 * </p>
 * 
 * @author shenbing@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGCRC1302DTO extends BaseDTO implements Serializable{
	
	/** 翻页用DTO */
	protected PagingDTO pagingDto;
	
	/** 文档借阅检索结果 */
	protected List<IG500Info> entityItemInfoList;
	
	/** 当前用户ID */
	protected String userId;

	/**
	 * 翻页用DTO取得
	 * @return pagingDto 翻页用DTO
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * 翻页用DTO设定
	 * @param pagingDto 翻页用DTO
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * 文档借阅检索结果取得
	 * @return entityItemInfoList 文档借阅检索结果
	 */
	public List<IG500Info> getEntityItemInfoList() {
		return entityItemInfoList;
	}

	/**
	 * 文档借阅检索结果设定
	 * @param entityItemInfoList 文档借阅检索结果
	 */
	public void setEntityItemInfoList(List<IG500Info> entityItemInfoList) {
		this.entityItemInfoList = entityItemInfoList;
	}

	/**
	 * 当前用户ID取得
	 * @return userId 当前用户ID
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * 当前用户ID设定
	 * @param userId 当前用户ID
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
