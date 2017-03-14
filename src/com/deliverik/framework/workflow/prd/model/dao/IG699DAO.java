/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prd.model.IG699Info;
import com.deliverik.framework.workflow.prd.model.IG909Info;
import com.deliverik.framework.workflow.prd.model.condition.IG699SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG909SearchCond;

/**
 * 
 * 流程缺省参与者变量权限DAO接口
 *
 */
public interface IG699DAO extends BaseHibernateDAO<IG699Info>{
	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<IG699Info> findAll();

	/**
	 * 主键检索处理
	 * @param psdid 主键
	 * @return 检索结果
	 */
	public IG699Info findByPK(Serializable pdvid);
	

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG699SearchCond cond);

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG699Info> findByCond(final IG699SearchCond cond, final int start, final int count);
	
	/**
	 * 条件检索处理
	 * 
	 * @param cond检索条件
	 * @return 检索结果列表
	 */
	public List<IG909Info> searchIG909Info(final IG909SearchCond cond);
	
	/**
	 * PDVID主键值取得
	 * 
	 * @param 流程状态ID
	 * @return PDVID主键值
	 */
	public String getPdvidSequenceNextValue(String psdid);
	
}
