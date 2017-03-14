package com.deliverik.infogovernor.drm.model.dao;




import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.drm.model.ResponseStrategyInfo;
import com.deliverik.infogovernor.drm.model.condition.ResponseStrategySearchCond;
import com.deliverik.infogovernor.drm.model.entity.ResponseStrategyTB;

/**
  * 概述: 场景响应策略DAO实现
  * 功能描述: 场景响应策略DAO实现
  * 创建记录: 2016/09/20
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class ResponseStrategyDAOImpl extends
		BaseHibernateDAOImpl<ResponseStrategyInfo> implements ResponseStrategyDAO {

	/**
	 * 构造函数
	 */
	public ResponseStrategyDAOImpl(){
		super(ResponseStrategyTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<ResponseStrategyInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public ResponseStrategyInfo findByPK(Serializable pk) {
		ResponseStrategyInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final ResponseStrategySearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<ResponseStrategyInfo> findByCond(final ResponseStrategySearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(ResponseStrategySearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(cond.getSenceid()!=null&&cond.getSenceid()>0){
			c.add(Restrictions.eq("senceid", cond.getSenceid()));
		}
		return c;
	}

}