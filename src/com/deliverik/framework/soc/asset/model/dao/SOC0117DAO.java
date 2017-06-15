package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.model.SOC0117Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0117SearchCond;



/**
 * 资产信息DAO接口
 * 
 */
public interface SOC0117DAO extends BaseHibernateDAO<SOC0117Info> {

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<SOC0117Info> findAll();

	/**
	 * 主键检索处理
	 * @param eid 主键
	 * @return 检索结果
	 */
	public SOC0117Info findByPK(Serializable eid);
	

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final SOC0117SearchCond cond);

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0117Info> findByCond(final SOC0117SearchCond cond, final int start, final int count);
	
	public List<SOC0117Info> findByCond(final SOC0117SearchCond cond,final String id);
	public List<SOC0117Info> findByCondCoding(final SOC0117SearchCond cond);
	
	/**
	 * 获取最大EID用
	 * @param cond
	 * @return
	 */
	public List<SOC0117Info> findMaxEidByCond(final SOC0117SearchCond cond);
	/**
	 * 查询模型下资产数量
	 * @param esyscoding
	 * @return
	 */
	public List<Map<String, Object>> getEntityNum(String rootEsyscoding);
	
	/**
	 * 获取最大EID用,存数字类型
	 * @param cond
	 * @return
	 */
	public Integer findMaxEidByCondNotLikeCM();

	/**
	 * 获取可导出一级资产列表
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0117Info> searchEntityForExport(SOC0117SearchCond cond);
	/**
	 * 查询模型下资产数量（新版应急资源专用）
	 * @param esyscoding
	 * @return
	 */
	public List<Map<String, Object>> getEntityNumNEW(String rootErcode,String resourceType);
}
