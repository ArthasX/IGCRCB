/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.fxk.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.fxk.model.RiskprojectvwInfo;
import com.deliverik.infogovernor.fxk.model.condition.RiskprojectvwSearchCond;
import com.deliverik.infogovernor.fxk.model.entity.RiskprojectvwTB;

/**
  * 概述: 通讯录DAO实现
  * 功能描述: 通讯录DAO实现
  * 创建记录: 2014/07/24
  * 修改记录: 
  */
public class RiskprojectvwDAOImpl extends
		BaseHibernateDAOImpl<RiskprojectvwInfo> implements RiskprojectvwDAO {

	/**
	 * 构造函数
	 */
	public RiskprojectvwDAOImpl(){
		super(RiskprojectvwTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	@Override
    public List<RiskprojectvwInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	@Override
    public RiskprojectvwInfo findByPK(Serializable pk) {
		RiskprojectvwInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final RiskprojectvwSearchCond cond){
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
	public List<RiskprojectvwInfo> findByCond(final RiskprojectvwSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(RiskprojectvwSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		c.add(Restrictions.eq("prpdid", "0100301"));
		
		if(StringUtils.isNotEmpty(cond.getPrusername_l())){
            c.add(Restrictions.like("prusername", "%"+cond.getPrusername_l()+"%"));
        }
		if(StringUtils.isNotEmpty(cond.getRisknum_l())){
            c.add(Restrictions.like("risknum","%"+ cond.getRisknum_l()+"%"));
        }
		if(StringUtils.isNotEmpty(cond.getRiskstart_ge())){
            c.add(Restrictions.ge("riskstart",cond.getRiskstart_ge()));
        }
		if(StringUtils.isNotEmpty(cond.getRiskstart_le())){
            c.add(Restrictions.le("riskstart", cond.getRiskstart_le()));
        }
		if(StringUtils.isNotEmpty(cond.getRiskstatus_q())){
            c.add(Restrictions.eq("riskstatus", cond.getRiskstatus_q()));
        }
		if(StringUtils.isNotEmpty(cond.getRisktype_q())){
            c.add(Restrictions.eq("risktype", cond.getRisktype_q()));
        }
		if(StringUtils.isNotEmpty(cond.getTitle_l())){
            c.add(Restrictions.like("prtitle", "%"+cond.getTitle_l()+"%"));
        }
		
		return c;
	}

}