/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.kgm.model;

/**
 * 
 * @Description:知识业务系统关联实体接口
 * @Author
 * @History
 * @Version V1.0
 */
public interface KnowledgeAppImpact {
	/**
	 *主键ID
	 */
	public Integer getKaiid();

	/**
	 *知识ID
	 */
	public Integer getKnid();

	/**
	 *业务系统Code
	 */
	public String getKaicode();
	
	/**
	 * 知识版本
	 */
	public Integer getKnversion();
}
