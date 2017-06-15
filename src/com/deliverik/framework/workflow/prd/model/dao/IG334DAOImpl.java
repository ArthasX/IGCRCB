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
import org.hibernate.criterion.Expression;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prd.model.IG334Info;
import com.deliverik.framework.workflow.prd.model.IG334VWInfo;
import com.deliverik.framework.workflow.prd.model.condition.IG334SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG334TB;
import com.deliverik.framework.workflow.prd.model.entity.IG334VW;

/**
  * ����: ֪ͨ���Ի�����ϢDAOʵ��
  * ��������: ֪ͨ���Ի�����ϢDAOʵ��
  * ������¼: 2013/09/03
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class IG334DAOImpl extends
		BaseHibernateDAOImpl<IG334Info> implements IG334DAO {

	/**
	 * ���캯��
	 */
	public IG334DAOImpl(){
		super(IG334TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG334Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG334Info findByPK(Serializable pk) {
		IG334Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG334SearchCond cond){
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
	public List<IG334Info> findByCond(final IG334SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond
	 *            ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(IG334SearchCond cond) {
		DetachedCriteria c = getDetachedCriteria();
		if (StringUtils.isNotEmpty(cond.getPdid_like())) {
			c.add(Expression.like("pdid", cond.getPdid_like() + "%"));
		}
		if (StringUtils.isNotEmpty(cond.getPdid_eq())) {
			c.add(Expression.eq("pdid", cond.getPdid_eq()));
		}
		//���̱�ID(��ȫƥ��)
		if (StringUtils.isNotEmpty(cond.getPidid_eq())) {
			c.add(Expression.eq("pidid", cond.getPidid_eq()));
		}
		//���̱�ID(ģ��ƥ��)
		if (StringUtils.isNotEmpty(cond.getPidid_like())) {
			c.add(Expression.like("pidid", cond.getPidid_like() + "%"));
		}
		return c;
	}
	
	/**
	 * ������������
	 * @param cond ��������
	 * @return ��������б�
	 */
	@SuppressWarnings("unchecked")
	public List<IG334VWInfo> findByCondTactics(final IG334SearchCond cond){
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("IG334DAO.searchIG334InfoStactics").getQueryString());
				getSQL(cond, query);
				
				SQLQuery q = session.createSQLQuery(query.toString());
//				q.setString("pdid", cond.getPdid());
				setFetchPoint(q, 0, 0);
				q.addEntity("pi", IG334VW.class);
				List<IG334VWInfo> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<IG334VWInfo>) execute(action);
	}
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected void getSQL(IG334SearchCond cond, StringBuffer query){
		//��������IDģ����ѯ
		if(StringUtils.isNotEmpty(cond.getPdid_like())){
			query.append(" and pdid like '").append(cond.getPdid_like()).append("%' ");
		}
	}
}