/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.igflow.resultset.RoleInfo;
import com.deliverik.framework.user.model.entity.RoleTB;
import com.deliverik.infogovernor.drm.IGDRMCONSTANTS;
import com.deliverik.infogovernor.drm.model.StructureRoleInfo;
import com.deliverik.infogovernor.drm.model.condition.StructureRoleSearchCond;
import com.deliverik.infogovernor.drm.model.entity.StructureRoleTB;

/**
  * 概述: 组织架构关联表DAO实现
  * 功能描述: 组织架构关联表DAO实现
  * 创建记录: 2015/03/09
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class StructureRoleDAOImpl extends
		BaseHibernateDAOImpl<StructureRoleInfo> implements StructureRoleDAO {

	/**
	 * 构造函数
	 */
	public StructureRoleDAOImpl(){
		super(StructureRoleTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	@Override
    public List<StructureRoleInfo> findAll() {
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
    public StructureRoleInfo findByPK(Serializable pk) {
		StructureRoleInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final StructureRoleSearchCond cond){
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
	public List<StructureRoleInfo> findByCond(final StructureRoleSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("syscoding"));
		c.addOrder(Order.desc("roleid"));
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(StructureRoleSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getCid())){
		    c.add(Expression.eq("cid", cond.getCid()));
		}
		if(StringUtils.isNotEmpty(cond.getRolename())){
		    c.add(Expression.like("rolename", "%"+cond.getRolename()+"%"));
		}
		if(StringUtils.isNotEmpty(cond.getSname())){
		    c.add(Expression.like("sname", "%"+cond.getSname()+"%"));
		}
		if(StringUtils.isNotEmpty(cond.getSrtype())){
		    c.add(Expression.eq("srtype", cond.getSrtype()));
		}
		if(StringUtils.isNotEmpty(cond.getSyscoding())){
		    c.add(Expression.like("syscoding", cond.getSyscoding()+"%"));
		}
		if(StringUtils.isNotEmpty(cond.getSyscoding_q())){
		    c.add(Expression.eq("syscoding", cond.getSyscoding_q()));
		}
		if(cond.getRoleid()!=null&&0!=cond.getRoleid().intValue()){
		    c.add(Expression.eq("roleid", cond.getRoleid()));
		}
		if(cond.getRoleid_in() != null && cond.getRoleid_in().size() >0){
			c.add(Restrictions.in("roleid", cond.getRoleid_in()));
		}
		return c;
	}
	/**
     * 角色查询
     * @param cond
     * @return
     */
	@SuppressWarnings("unchecked")
    public List<RoleInfo> searchRole(final StructureRoleSearchCond cond,final int start,final int count){
        HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException,
                    SQLException {
                session.flush();
                StringBuffer query = new StringBuffer();
                query.append("select r.* from role r where not exists(select 1 from structurerole sr where sr.roleid=r.roleid and sr.srtype='")
                    .append(StringUtils.isNotEmpty(cond.getSrtype())?cond.getSrtype():"").append("')");
                if(StringUtils.isNotEmpty(cond.getRolename())){
                    query.append(" and r.rolename like '%").append(cond.getRolename()).append("%' ");
                }
                query.append("and r.roletype='").append(IGDRMCONSTANTS.DRMROLETYPE).append("' ");
                //获取SQLQuery
                SQLQuery q = session.createSQLQuery(query.toString());
                q.addEntity(RoleTB.class);
                setFetchPoint(q, start, count);
                List<RoleInfo> list = q.list();
//                List list = q.list();
                session.clear();
                session.close();
                return list;
            }
        };
        return (List<RoleInfo>) execute(action);
    }
    /**
     * 角色查询
     * @param cond
     * @return
     */
	public Integer searchRoleCount(final StructureRoleSearchCond cond){
        HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException,
                    SQLException {
                session.flush();
                StringBuffer query = new StringBuffer();
                query.append("select count(*) from role r where not exists(select 1 from structurerole sr where sr.roleid=r.roleid and sr.srtype='")
                    .append(StringUtils.isNotEmpty(cond.getSrtype())?cond.getSrtype():"").append("')");
                if(StringUtils.isNotEmpty(cond.getRolename())){
                    query.append(" and r.rolename like '%").append(cond.getRolename()).append("%' ");
                }
                query.append("and r.roletype='").append(IGDRMCONSTANTS.DRMROLETYPE).append("' ");
                //获取SQLQuery
                SQLQuery q = session.createSQLQuery(query.toString());
                int reint = getCount(q.list());
                session.clear();
                session.close();
                return reint;
            }
        };
        return (Integer) execute(action);
    }
}