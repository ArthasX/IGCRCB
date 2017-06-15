/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prd.model.IG560Info;
import com.deliverik.framework.workflow.prd.model.IG560VWInfo;
import com.deliverik.framework.workflow.prd.model.condition.IG560SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG560TB;
import com.deliverik.framework.workflow.prd.model.entity.IG560VW;

/**
  * 概述: 流程状态级私有表单默认值表DAO实现
  * 功能描述: 流程状态级私有表单默认值表DAO实现
  * 创建记录: 2015/02/07
  * 修改记录: 
  */
public class IG560DAOImpl extends
		BaseHibernateDAOImpl<IG560Info> implements IG560DAO {

	/**
	 * 构造函数
	 */
	public IG560DAOImpl(){
		super(IG560TB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	@Override
    public List<IG560Info> findAll() {
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
    public IG560Info findByPK(Serializable pk) {
		IG560Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG560SearchCond cond){
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
	public List<IG560Info> findByCond(final IG560SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		if(StringUtils.isNotEmpty(cond.getPidid_l())){
			c.add(Restrictions.like("pidid", cond.getPidid_l()+"%"));
		}
		if(StringUtils.isNotEmpty(cond.getPsdid_l())){
			c.add(Restrictions.like("psdid", cond.getPsdid_l()+"%"));
		}
		if(StringUtils.isNotEmpty(cond.getPsdid())){
			c.add(Restrictions.eq("psdid", cond.getPsdid()));
		}
		if(StringUtils.isNotEmpty(cond.getUsedToAll())){
			c.add(Restrictions.eq("usedtoall", cond.getUsedToAll()));
		}
		if(StringUtils.isNotEmpty(cond.gettOrpsdid())){
			c.add(Restrictions.or(Restrictions.eq("usedtoall", "T"), Restrictions.like("psdid", cond.gettOrpsdid()+"%")));
		}
		if(StringUtils.isNotEmpty(cond.getPidid_q())){
			c.add(Restrictions.eq("pidid", cond.getPidid_q()));
		}
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(IG560SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		return c;
	}
	/**
	 * 查询默认值，当前状态默认值或全局默认值
	 */
	@SuppressWarnings("unchecked")
	public List<IG560VWInfo> searchIG560VW(final IG560SearchCond cond){
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append("select v6.pidname,v6.pidoption,v6.pidtype,ROW_NUMBER() over() as dvid,v6.pidid,v5.psdid,v5.dfvalue,v5.usedtoall,v5.fingerprint from ig007 v6 ");
				query.append("  left join ig560 v5 on v5.pidid=v6.pidid ");
				if(StringUtils.isNotEmpty(cond.getUsedToAll())||StringUtils.isNotEmpty(cond.getPsdid_l())){
					query.append(" and (");
					if(StringUtils.isNotEmpty(cond.getUsedToAll())){
						query.append(" v5.usedtoall ='").append(cond.getUsedToAll()).append("' ");
						if(StringUtils.isNotEmpty(cond.getPsdid_l())){
							query.append(" or v5.psdid like '").append(cond.getPsdid_l()).append("%' ");
						}
					}else if(StringUtils.isNotEmpty(cond.getPsdid_l())){
						query.append(" v5.psdid like '").append(cond.getPsdid_l()).append("%' ");
					}
					query.append(")");
				}
				query.append("where v6.pidmode='2' ");
				if(StringUtils.isNotEmpty(cond.getPidid_l())){
					query.append(" and v6.pidid like '").append(cond.getPidid_l()).append("%' ");
				}
				query.append("  order by v6.pidid asc ");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity(IG560VW.class);
				setFetchPoint(q, 0, 0);
				List<IG560VWInfo> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<IG560VWInfo>) execute(action);
	}
	

}