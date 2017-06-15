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
import com.deliverik.framework.workflow.prd.model.IG212Info;
import com.deliverik.framework.workflow.prd.model.IG238Info;
import com.deliverik.framework.workflow.prd.model.condition.IG212SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG212TB;
import com.deliverik.framework.workflow.prd.model.entity.IG238VW;

/**
  * ����: ����֪ͨ����DAOʵ��
  * ��������: ����֪ͨ����DAOʵ��
  * ������¼: 2012/04/24
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class IG212DAOImpl extends
		BaseHibernateDAOImpl<IG212Info> implements IG212DAO {

	/**
	 * ���캯��
	 */
	public IG212DAOImpl(){
		super(IG212TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG212Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG212Info findByPK(Serializable pk) {
		IG212Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG212SearchCond cond){
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
	public List<IG212Info> findByCond(final IG212SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(IG212SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getPsdid_like())){
			c.add(Expression.like("pdid", cond.getPsdid_like() + "%"));
		}
		
		if(StringUtils.isNotEmpty(cond.getPdid())){
			c.add(Expression.eq("pdid", cond.getPdid()));
		}
		return c;
	}
	
	/**
	 * ����֪ͨ���Բ�ѯ
	 * 
	 * @param pdid ���̶���ID
	 * @return ����֪ͨ�����б�
	 */
	@SuppressWarnings("unchecked")
	public List<IG238Info> searchIG238Info(final String pdid){
			HibernateCallback action = new HibernateCallback() {
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					session.flush();
					StringBuffer query = new StringBuffer();
					query.append(session.getNamedQuery("IG212DAO.searchIG238").getQueryString());
					SQLQuery q = session.createSQLQuery(query.toString());
					q.setString("pdid", pdid);
					setFetchPoint(q, 0, 0);
					q.addEntity(IG238VW.class);
					List<IG238Info> list = q.list();
					session.clear();
					return list;
				}
			};
			return (List<IG238Info>) execute(action);
		}

}