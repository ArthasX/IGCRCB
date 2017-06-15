/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.risk.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.risk.model.RiskCheck;
import com.deliverik.infogovernor.risk.model.condition.RiskCheckSearchCond;

/**
 * 风险检查DAO接口
 * @author lipeng@deliverik.com
 */
public interface RiskCheckDAO extends BaseHibernateDAO<RiskCheck> {

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<RiskCheck> findAll();

	/**
	 * 主键检索处理
	 * @param eid 主键
	 * @return 检索结果
	 */
	public RiskCheck findByPK(Serializable rcid);
	

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final RiskCheckSearchCond cond);

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<RiskCheck> findByCond(final RiskCheckSearchCond cond, final int start, final int count);
	public List<RiskCheck> dbmselByrcclass();
	public List<RiskCheck> getRcclassByMonth(final RiskCheckSearchCond cond) ;
	public List<RiskCheck> getRcTestMode (final RiskCheckSearchCond cond) ;
	
}
