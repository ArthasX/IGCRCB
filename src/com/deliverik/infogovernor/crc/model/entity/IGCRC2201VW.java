/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.crc.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.infogovernor.crc.model.IGCRC2201VWInfo;

/**	
 * 概述: 变更总体统计实体
 * 创建记录：yukexin    2014-8-7 上午9:10:14	
 * 修改记录：null
 */	
@Entity
public class IGCRC2201VW implements IGCRC2201VWInfo {
	
	@Id
	/** 主键 */
	private String typeId;
	
	/** 分类名 */
	private String typeName;

	/** 总数 */
	private Integer totalnum;

	/** 评审通过数量 */
	private Integer passnum;

	/** 评审通过率 */
//	private Double passrate;

	/** 成功数量 */
	private Integer successnum;

	/** 成功率 */
//	private Double successrate;

	/**
	 * typeId取得
	 * @return typeId  typeId
	 */
	public String getTypeId() {
		return typeId;
	}

	/**
	 * typeId设定
	 * @param typeId  typeId
	 */
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	/**
	 * 分类名取得
	 * @return typeName  分类名
	 */
	public String getTypeName() {
		return typeName;
	}

	/**
	 * 分类名设定
	 * @param typeName  分类名
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	/**
	 * 总数取得
	 * @return totalnum  总数
	 */
	public Integer getTotalnum() {
		return totalnum;
	}

	/**
	 * 总数设定
	 * @param totalnum  总数
	 */
	public void setTotalnum(Integer totalnum) {
		this.totalnum = totalnum;
	}

	/**
	 * 评审通过数量取得
	 * @return passnum  评审通过数量
	 */
	public Integer getPassnum() {
		return passnum;
	}

	/**
	 * 评审通过数量设定
	 * @param passnum  评审通过数量
	 */
	public void setPassnum(Integer passnum) {
		this.passnum = passnum;
	}


	/**
	 * 成功数量取得
	 * @return successnum  成功数量
	 */
	public Integer getSuccessnum() {
		return successnum;
	}

	/**
	 * 成功数量设定
	 * @param successnum  成功数量
	 */
	public void setSuccessnum(Integer successnum) {
		this.successnum = successnum;
	}




}
