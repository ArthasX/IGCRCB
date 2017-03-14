/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.kgm.model.entity;

import java.io.Serializable;

import javax.persistence.Id;

import com.deliverik.framework.base.BasePK;

/**
 * 概述: 流程策略设定信息实体知识ID
 * 功能描述：流程策略设定信息实体知识ID
 * 创建记录：刘鹏 2010/11/26
 * 修改记录：
 */
@SuppressWarnings("serial")
public class KnowledgeTBPK extends BasePK implements Serializable{
	@Id
	/**知识ID */
	protected Integer knid;
	
	@Id
	/**知识版本 */
	protected Integer knversion;
	/**
	 * 知识信息实体主键构造函数
	 * 
	 */
	public KnowledgeTBPK() {
	}

	/**
	 * 知识信息实体主键构造函数
	 * 
	 * @param knid 知识ID
	 * @param knversion 知识版本
	 */
	public KnowledgeTBPK(Integer knid, Integer knversion) {
		super();
		this.knid = knid;
		this.knversion = knversion;
	}
	
	/**
	 *知识版本取得
	 * 
	 * @return 知识版本
	 */
	public Integer getKnversion() {
		return knversion;
	}
	/**
	 * 知识版本
	 * @param knversion 知识版本
	 */
	public void setKnversion(Integer knversion) {
		this.knversion = knversion;
	}
	
	/**
	 *知识ID取得
	 * 
	 * @return 知识ID
	 */
	public Integer getKnid() {
		return knid;
	}

	/**
	 *知识ID设定
	 * 
	 * @param knid 知识ID
	 */
	public void setKnid(Integer knid) {
		this.knid = knid;
	}
	
}
