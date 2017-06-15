/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
  * ����: ��֯�ܹ�������DAOʵ��
  * ��������: ��֯�ܹ�������DAOʵ��
  * ������¼: 2015/03/09
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class StructureRoleDAOImpl extends
		BaseHibernateDAOImpl<StructureRoleInfo> implements StructureRoleDAO {

	/**
	 * ���캯��
	 */
	public StructureRoleDAOImpl(){
		super(StructureRoleTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	@Override
    public List<StructureRoleInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	@Override
    public StructureRoleInfo findByPK(Serializable pk) {
		StructureRoleInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final StructureRoleSearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<StructureRoleInfo> findByCond(final StructureRoleSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("syscoding"));
		c.addOrder(Order.desc("roleid"));
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
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
     * ��ɫ��ѯ
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
                //��ȡSQLQuery
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
     * ��ɫ��ѯ
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
                //��ȡSQLQuery
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