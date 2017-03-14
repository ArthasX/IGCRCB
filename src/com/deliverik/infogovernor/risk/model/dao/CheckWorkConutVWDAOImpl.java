/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.risk.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.risk.model.CheckWorkConutVWInfo;
import com.deliverik.infogovernor.risk.model.condition.CheckWorkConutVWSearchCond;
import com.deliverik.infogovernor.risk.model.entity.CheckWorkConutVW;

/**
  * ����: ��鹤��ͳ�Ʊ���DAOʵ��
  * ��������: ��鹤��ͳ�Ʊ���DAOʵ��
  * ������¼: 2014/07/09
  * �޸ļ�¼: 
  */
public class CheckWorkConutVWDAOImpl extends
		BaseHibernateDAOImpl<CheckWorkConutVWInfo> implements CheckWorkConutVWDAO {

	/**
	 * ���캯��
	 */
	public CheckWorkConutVWDAOImpl(){
		super(CheckWorkConutVW.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CheckWorkConutVWInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CheckWorkConutVWInfo findByPK(Serializable pk) {
		CheckWorkConutVWInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final CheckWorkConutVWSearchCond cond){
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
	@SuppressWarnings("unchecked")
	public List<CheckWorkConutVWInfo> findByCond(final CheckWorkConutVWSearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback(){
			
			public Object doInHibernate(Session session)throws HibernateException, SQLException {
			
				session.flush();
				//��ȡquery
				StringBuffer query = new StringBuffer();
				query.append( session.getNamedQuery("CheckWorkDAo.ResultQuery").getQueryString());
				
				if(StringUtils.isNotBlank(cond.getRcrtestmode())){
					query.append(" and rcrtestmode = '"+cond.getRcrtestmode()+"'");
				}
				if(StringUtils.isNotBlank(cond.getHalfyear())){
					query.append(cond.getHalfyear());
				}
				if(StringUtils.isNotBlank(cond.getQuart())){
					query.append(cond.getQuart());
				}
				if(StringUtils.isNotBlank(cond.getYear())){
					query.append(cond.getYear());
				}
				if(StringUtils.isNotBlank(cond.getCg())){
					query.append(cond.getCg());
				}
				query.append(" order by t.rccategoryname");
				//��ȡSQLQuery
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity("t",CheckWorkConutVW.class);
				List<CheckWorkConutVWInfo> list=q.list();
				session.clear();
				session.close();
				return list;
			}
			
		};
		return (List<CheckWorkConutVWInfo>)execute(action);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(CheckWorkConutVWSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		return c;
	}

}