/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.asset.model.EiBelongRelationInfo;
import com.deliverik.framework.asset.model.EiBelongRelationVWInfo;
import com.deliverik.framework.asset.model.IG013Info;
import com.deliverik.framework.asset.model.condition.EiBelongRelationSearchCond;
import com.deliverik.framework.asset.model.condition.EiBelongRelationVWSearchCond;
import com.deliverik.framework.asset.model.entity.EiBelongRelationTB;
import com.deliverik.framework.asset.model.entity.EiBelongRelationVW;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
  * ����: ����������ϵ��DAOʵ��
  * ��������: ����������ϵ��DAOʵ��
  * ������¼: 2011/04/20
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class EiBelongRelationDAOImpl extends
		BaseHibernateDAOImpl<EiBelongRelationInfo> implements EiBelongRelationDAO {

	/**
	 * ���캯��
	 */
	public EiBelongRelationDAOImpl(){
		super(EiBelongRelationTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<EiBelongRelationInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public EiBelongRelationInfo findByPK(Serializable pk) {
		EiBelongRelationInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final EiBelongRelationSearchCond cond){
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
	public List<EiBelongRelationInfo> findByCond(final EiBelongRelationSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(EiBelongRelationSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//Դ�ʲ�ID
		if (StringUtils.isNotEmpty(cond.getBrpareiid())) {
			c.add(Expression.eq("brpareiid", Integer.parseInt(cond.getBrpareiid())));
		}
		//Դ�ʲ���汾
		if (StringUtils.isNotEmpty(cond.getBrparversion())) {
			c.add(Expression.eq("brparversion", Integer.parseInt(cond.getBrparversion())));
		}
		//Դ�ʲ�С�汾
		if (StringUtils.isNotEmpty(cond.getBrparsmallversion())) {
			c.add(Expression.eq("brparsmallversion", Integer.parseInt(cond.getBrparsmallversion())));
		}
		//Ŀ���ʲ�ID
		if (StringUtils.isNotEmpty(cond.getBrcldeiid())) {
			c.add(Expression.eq("brcldeiid", Integer.parseInt(cond.getBrcldeiid())));
		}
		//Ŀ���ʲ���汾
		if (StringUtils.isNotEmpty(cond.getBrcldversion())) {
			c.add(Expression.eq("brcldversion", Integer.parseInt(cond.getBrcldversion())));
		}
		//Ŀ���ʲ�С�汾
		if (StringUtils.isNotEmpty(cond.getBrcldsmallversion())) {
			c.add(Expression.eq("brcldsmallversion", Integer.parseInt(cond.getBrcldsmallversion())));
		}
		//ɾ����־
		if (StringUtils.isNotEmpty(cond.getDeleteflag())) {
			c.add(Expression.eq("deleteflag", cond.getDeleteflag()));
		}
		//�ʲ����������ڵ�ʵ���ʶ
		if (StringUtils.isNotEmpty(cond.getEirootmark())) {
			c.add(Expression.eq("eirootmark", Integer.parseInt(cond.getEirootmark())));
		}
		
		return c;
	}
	
	/**
	 * ���ð������汾��ϵ����
	 * @param cond ��������
	 * @return ��������б�
	 */
	@SuppressWarnings("unchecked")
	public List<EiBelongRelationVWInfo> searchEiBelongRelationVW(final EiBelongRelationVWSearchCond cond) {
		HibernateCallback action = new HibernateCallback()
		{  
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				List<IG013Info> list = null;
				query.append(session.getNamedQuery("EiBelongRelationDAO.searchEiBelongRelationVW").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity(EiBelongRelationVW.class);
				setFetchPoint(q, 0, 0);
				list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<EiBelongRelationVWInfo>) execute(action);
	}
	
	/**
	 * ���ð�����ϵ���汾����
	 * @param cond ��������
	 * @return ��������б�
	 */
	@SuppressWarnings("unchecked")
	public List<EiBelongRelationInfo> searchMaxEiBelongRelation(final EiBelongRelationSearchCond cond) {
		HibernateCallback action = new HibernateCallback()
		{  
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				List<IG013Info> list = null;
				query.append(session.getNamedQuery("EiBelongRelationDAO.searchMaxEiBelongRelationVW1").getQueryString());
				if(StringUtils.isNotEmpty(cond.getBrpareiid())) {
					query.append(" AND brpareiid = :brpareiid ");
					query.append(" AND brparversion = :brparversion ");
					query.append(" AND brparsmallversion = :brparsmallversion ");
				} else if(StringUtils.isNotEmpty(cond.getBrcldeiid())) {
					query.append(" AND brcldeiid = :brcldeiid ");
					query.append(" AND brcldversion = :brcldversion ");
					query.append(" AND brcldsmallversion = :brcldsmallversion ");
				}
				query.append(session.getNamedQuery("EiBelongRelationDAO.searchMaxEiBelongRelationVW2").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity(EiBelongRelationTB.class);
				setFetchPoint(q, 0, 0);
				list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<EiBelongRelationInfo>) execute(action);
	}

}