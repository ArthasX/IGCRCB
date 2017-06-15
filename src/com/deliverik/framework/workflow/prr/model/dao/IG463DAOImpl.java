/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.model.dao;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prr.model.IG463Info;
import com.deliverik.framework.workflow.prr.model.condition.IG463SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG463TB;

/**
 * <p>概述:代理工作DAO实现</p>
 * <p>功能描述：1.条件检索处理</p>
 * <p>          2.检索条件生成</p>
 * <p>          3.主键检索处理</p>
 * <p>创建记录：</p>
 */
@SuppressWarnings("deprecation")
public class IG463DAOImpl extends BaseHibernateDAOImpl<IG463Info> implements IG463DAO {

	/**
	 * 构造函数
	 */
	public IG463DAOImpl(){
		super(IG463TB.class);
	}


	/**
	 * 功能：条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG463Info> findByCond(final IG463SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("ppwoptiontime"));
		List<IG463Info> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * 功能：检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(IG463SearchCond cond){
		
		DetachedCriteria c = getDetachedCriteria();

		if(StringUtils.isNotEmpty(cond.getPpwoptiontime_f())){
			c.add(Expression.ge("ppwoptiontime", cond.getPpwoptiontime_f()+" 00:00"));
			}
			if(StringUtils.isNotEmpty(cond.getPpwoptiontime_t())){
				c.add(Expression.le("ppwoptiontime", cond.getPpwoptiontime_t()+" 23:59"));
			}
			
			if(StringUtils.isNotEmpty(cond.getPpwauthorizeuserid())){
				c.add(Expression.eq("ppwauthorizeuserid", cond.getPpwauthorizeuserid()));
			}
			if(StringUtils.isNotEmpty(cond.getPpwcloseflag())){
				c.add(Expression.eq("ppwcloseflag", cond.getPpwcloseflag()));
			}
			if(StringUtils.isNotEmpty(cond.getPpwproxyusername())){
				c.add(Expression.like("ppwproxyusername", "%"+cond.getPpwproxyusername()+"%"));
			}
			if(StringUtils.isNotEmpty(cond.getPpwproxyuserid())){
				c.add(Expression.eq("ppwproxyuserid", cond.getPpwproxyuserid()));
			}
			if(StringUtils.isNotEmpty(cond.getPpwprserialnum())){
				c.add(Expression.eq("ppwprserialnum", cond.getPpwprserialnum()));
			}
			if(cond.getPpwprid() != null && cond.getPpwprid()>0){
				c.add(Expression.eq("ppwprid", cond.getPpwprid()));
			}
		return c;
	}
	
	/**
	 * 功能：主键检索处理
	 * @param ppwid 主键
	 * @return 检索结果
	 */
	public IG463Info findIG463InfoByPK(Integer ppwid) {
		IG463Info ret = findByPK(ppwid);
		return ret;
	}


}
