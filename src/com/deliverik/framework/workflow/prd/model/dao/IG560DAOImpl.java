/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
  * ����: ����״̬��˽�б�Ĭ��ֵ��DAOʵ��
  * ��������: ����״̬��˽�б�Ĭ��ֵ��DAOʵ��
  * ������¼: 2015/02/07
  * �޸ļ�¼: 
  */
public class IG560DAOImpl extends
		BaseHibernateDAOImpl<IG560Info> implements IG560DAO {

	/**
	 * ���캯��
	 */
	public IG560DAOImpl(){
		super(IG560TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	@Override
    public List<IG560Info> findAll() {
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
    public IG560Info findByPK(Serializable pk) {
		IG560Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG560SearchCond cond){
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
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(IG560SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		return c;
	}
	/**
	 * ��ѯĬ��ֵ����ǰ״̬Ĭ��ֵ��ȫ��Ĭ��ֵ
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