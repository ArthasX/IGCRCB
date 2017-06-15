/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.kgm.model.condition;

/**
 * 概述: 知识流程关联信息检索条件实现
 * 功能描述：知识流程关联信息检索条件实现
 * 创建记录：刘鹏 2010/12/07
 * 修改记录：
 */
public class KnowledgeProcessSearchCondImpl implements
		KnowledgeProcessSearchCond {
	
	/** 知识ID */
	protected Integer knid;
	
	/** 知识版本 */
	protected Integer knversion;
	
	/** 流程ID */
	protected Integer prid;
	
	/** 服务工单ID */
	protected Integer sfid;
	
	/** 关联类型 */
	protected String connecttype;
	
	/** 是否有效标识：0-无效，1-有效*/
	protected String kpEffect;
	
	/**
	 * 知识ID取得
	 * 
	 * @return 知识ID
	 */
	public Integer getKnid() {
		return knid;
	}
	
	/**
	 * 知识ID设定
	 * 
	 * @param knid知识ID
	 */
	public void setKnid(Integer knid) {
		this.knid = knid;
	}
	
	/**
	 * 知识版本取得
	 * @return 知识版本
	 */
	public Integer getKnversion() {
		return knversion;
	}

	/**
	 * 知识版本设定
	 * @param knversion知识版本
	 */
	public void setKnversion(Integer knversion) {
		this.knversion = knversion;
	}

	/**
	 * 流程ID取得
	 * 
	 * @return 流程ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 流程ID设定
	 * 
	 * @param prid流程ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}
	
	/**
	 * 服务工单ID取得
	 * 
	 * @return 服务工单ID
	 */
	public Integer getSfid() {
		return sfid;
	}

	/**
	 * 服务工单ID设定
	 * 
	 * @param sfid服务工单ID
	 */
	public void setSfid(Integer sfid) {
		this.sfid = sfid;
	}

	/**
	 * 关联类型取得
	 * 
	 * @return 关联类型
	 */
	public String getConnecttype() {
		return connecttype;
	}

	/**
	 * 关联类型设定
	 * 
	 * @param connecttype关联类型
	 */
	public void setConnecttype(String connecttype) {
		this.connecttype = connecttype;
	}

	/**
	 * 有效标识位取得
	 * @return 有效标识位
	 */
	public String getKpEffect() {
		return kpEffect;
	}

	/**
	 * 有效标识位设定
	 * @param kpEffect 有效标识位
	 */
	public void setKpEffect(String kpEffect) {
		this.kpEffect = kpEffect;
	}
	
}
