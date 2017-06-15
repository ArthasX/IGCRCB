/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.asset.model.IG344Info;
import com.deliverik.infogovernor.asset.model.condition.IG344SearchCond;
import com.deliverik.infogovernor.asset.model.entity.IG344VW;

/**
  * ����: IG344DAOʵ��
  * ��������: IG344DAOʵ��
  * ������¼: 2012/07/13
  * �޸ļ�¼: 
  */

public class IG344DAOImpl extends
		BaseHibernateDAOImpl<IG344Info> implements IG344DAO {

	/**
	 * ���캯��
	 */
	public IG344DAOImpl(){
		super(IG344VW.class);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG344Info> findByCond(final IG344SearchCond cond, final int start, final int count){
		return query(cond, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	@SuppressWarnings("unchecked")
	public List<IG344Info> query(final IG344SearchCond cond, final int start, final int count) {
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws

			HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("EntityItemRelationDetailVWDAO.searchEntityItemCount").getQueryString());
				//���ݷ����̱�Ų�ѯ
				if(StringUtils.isNotEmpty(cond.getEiid_q())){
					query.append(" and cldeiid = "+cond.getEiid_q());
				}
				//���ݷ����¼��ʼʱ���ѯ
				if(StringUtils.isNotEmpty(cond.getBeginTime_q())){
					query.append(" and eiinsdate >= '" + cond.getBeginTime_q() +"'");
				}
				//���ݷ����¼��ֹʱ���ѯ
				if(StringUtils.isNotEmpty(cond.getEndTime_q())){
					query.append(" and eiinsdate <= '" + cond.getEndTime_q() +"'");
				}  
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity("prcount",IG344VW.class);
				List<IG344Info> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<IG344Info>) execute(action);
	}

}