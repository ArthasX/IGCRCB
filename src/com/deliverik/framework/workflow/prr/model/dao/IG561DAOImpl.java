/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prr.model.IG561Info;
import com.deliverik.framework.workflow.prr.model.IG561VWInfo;
import com.deliverik.framework.workflow.prr.model.condition.IG561SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG561TB;
import com.deliverik.framework.workflow.prr.model.entity.IG561VW;

/**
  * 概述: 状态级私有表单值记录表DAO实现
  * 功能描述: 状态级私有表单值记录表DAO实现
  * 创建记录: 2015/02/07
  * 修改记录: 
  */
@SuppressWarnings("unchecked")
public class IG561DAOImpl extends
		BaseHibernateDAOImpl<IG561Info> implements IG561DAO {

	/**
	 * 构造函数
	 */
	public IG561DAOImpl(){
		super(IG561TB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	@Override
    public List<IG561Info> findAll() {
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
    public IG561Info findByPK(Serializable pk) {
		IG561Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG561SearchCond cond){
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
	public List<IG561Info> findByCond(final IG561SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(IG561SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
        if (StringUtils.isNotEmpty(cond.getPidid_l())) {
            c.add(Restrictions.like("pidid", cond.getPidid_l()+"%"));
        }
        if (StringUtils.isNotEmpty(cond.getPrid_q())) {
            c.add(Restrictions.eq("prid", Integer.valueOf(cond.getPrid_q())));
        }
        if (StringUtils.isNotEmpty(cond.getPsdid_l())) {
            c.add(Restrictions.like("psdid", cond.getPsdid_l()+"%"));
        }
        if (StringUtils.isNotEmpty(cond.getPiid_q())) {
            c.add(Restrictions.eq("piid", Integer.valueOf(cond.getPiid_q())));
        }
		return c;
	}

    /**
     * 流程关闭节点 状态私有表单显示查询，将所有能显示的状态级私有表单都显示出来
     * @Title: searchIG561VW
     * @Description: 流程关闭节点 状态私有表单显示查询，将所有能显示的状态级私有表单都显示出来
     * @param 
     * prid 流程id 
     * ppuserid 参与者id
     * isAdmin 是否是流程管理员
     * @return list561VW
     * @throws
     */
	public List<IG561VWInfo> searchIG561VW(final String prid ,final String ppuserid,final boolean isAdmin) {
        HibernateCallback action = new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                session.flush();
                StringBuffer query = new StringBuffer();
                query.append(" select a.*,b.psdname from ig561 a ");
                query.append(" left join ig333 b on a.psdid=b.psdid ");
                query.append(" left join ig337 c on c.psdid=a.psdid and  a.prid=c.prid ");
                query.append(" where a.prid = '").append(prid).append("'");
                if(!isAdmin){
                    query.append(" and c.ppuserid='").append(ppuserid).append("' ");
                }
                query.append(" order by a.psdid asc ");
                SQLQuery q = session.createSQLQuery(query.toString());
                q.addEntity(IG561VW.class);
                setFetchPoint(q, 0, 0);
                List<IG561VWInfo> list = q.list();
                session.clear();
                return list;
            }
        };
        return (List<IG561VWInfo>) execute(action);
    }

}