/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prr.model.IG898Info;
import com.deliverik.framework.workflow.prr.model.condition.IG898SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG898TB;

/**
  * 概述: 表格类表单值表DAO实现
  * 功能描述: 表格类表单值表DAO实现
  * 创建记录: 2013/06/25
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class IG898DAOImpl extends
		BaseHibernateDAOImpl<IG898Info> implements IG898DAO {

	/**
	 * 构造函数
	 */
	public IG898DAOImpl(){
		super(IG898TB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG898Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG898Info findByPK(Serializable pk) {
		IG898Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG898SearchCond cond){
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
	public List<IG898Info> findByCond(final IG898SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("pvrownumber"));
		return findByCriteria(c, start, count);
	}

	/**
     * 取得表格类型表单的行数
     *
     * @param cond 检索条件
     * @return 表格表单行数
     */
    @SuppressWarnings("rawtypes")
	public int getTableRowCount(final IG898SearchCond cond){
        String sql =  "select max(pvrownumber) from IG898TB where prid=:prid and pidname=:pidname";
        NamedParamMap paramMap = getNamedParamMap();
        paramMap.setInteger("prid", cond.getPrid());
        paramMap.setString("pidname", cond.getPidname());
        List resultList = findByNamedParamMap(sql, paramMap);
        if (resultList.size() == 0) 
            return 0;
        return Integer.parseInt((String)resultList.get(0));
    }
    
	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(IG898SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(cond.getPrid() != null && cond.getPrid() > 0){
			c.add(Expression.eq("prid", cond.getPrid()));
		}
		if(StringUtils.isNotEmpty(cond.getPidid())){
			c.add(Expression.eq("pidid", cond.getPidid()));
		}
		if(StringUtils.isNotEmpty(cond.getRownumber())){
			c.add(Expression.eq("pvrownumber", cond.getRownumber()));
		}
		if(StringUtils.isNotEmpty(cond.getPvcolname())){
			c.add(Restrictions.eq("pvcolname", cond.getPvcolname()));
		}
		return c;
	}

}