/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.kgm.model;

import com.deliverik.framework.base.BaseModel;

/**
 * 
 * @Description:知识评分实体接口
 * @Author
 * @History
 * @Version V1.0
 */
public interface KnowledgeGrade extends BaseModel {
	/**
	 *主键
	 */
	public Integer getKgid();

	/**
	 *知识表key
	 */
	public Integer getKnid();

	/**
	 *评分
	 */
	public Integer getKggrade();

	/**
	 *知识的评价
	 */
	public String getKgappraise();

	/**
	 *评分人
	 */
	public String getKguserid();

	/**
	 *评分时间
	 */
	public String getKgtime();

}
