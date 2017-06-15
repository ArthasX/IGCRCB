/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.crc.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.crc.model.ChangeProcessVWInfo;
import com.deliverik.infogovernor.crc.model.condition.ChangeProcessVWSearchCond;
import com.deliverik.infogovernor.crc.model.entity.ChangeProcessVWTB;

/**
  * ����: �������DAOʵ��
  * ��������: �������DAOʵ��
  * ������¼: 2015/01/04
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class ChangeProcessVWDAOImpl extends
		BaseHibernateDAOImpl<ChangeProcessVWInfo> implements ChangeProcessVWDAO {

	/**
	 * ���캯��
	 */
	public ChangeProcessVWDAOImpl(){
		super(ChangeProcessVWTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<ChangeProcessVWInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public ChangeProcessVWInfo findByPK(Serializable pk) {
		ChangeProcessVWInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final ChangeProcessVWSearchCond cond){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("EntityItemIGCRC1401VWDAO.getSearchCount").getQueryString());
				query = getSQL(cond, query);
				query.append(")");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				Integer count = getCount(q.list());
				session.clear();
				return count;
			}
		};
		return (Integer) execute(action);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<ChangeProcessVWInfo> findByCond(final ChangeProcessVWSearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
				
				query.append( session.getNamedQuery("EntityItemIGCRC1401VWDAO.getChangeProcess").getQueryString());
				
				query = getSQL(cond, query);
				
				SQLQuery q = session.createSQLQuery(query.toString());

				q.addEntity("RCTB",ChangeProcessVWTB.class);

				setFetchPoint(q, start, count);

				List<ChangeProcessVWInfo> list = q.list();
				
				session.clear();
				
				return list;
			}
		};
		return (List<ChangeProcessVWInfo>) execute(action);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(ChangeProcessVWSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		return c;
	}
	
	/**
	 * ���ܣ�������������
	 * 
	 * @param cond ��������
	 * @param query sql
	 * @return �����ü���������
	 */
	protected StringBuffer getSQL(ChangeProcessVWSearchCond cond, StringBuffer query){
		
		//������
		if(StringUtils.isNotBlank(cond.getPrserialnum_like())){
			query.append(" and a.prserialnum like '%" + cond.getPrserialnum_like() + "%'");
		}
		//�������
		if(StringUtils.isNotBlank(cond.getPrtitle_like())){
			query.append(" and a.prtitle like '%" + cond.getPrtitle_like() + "%'");
		}
		//�������
		if(StringUtils.isNotBlank(cond.getChangetype_like())){
			query.append(" and d.pivarvalue like '%" + cond.getChangetype_like() + "%'");
		}
		//����ƽ̨
		if(StringUtils.isNotBlank(cond.getUpdateplatform_like())){
			query.append(" and c.pivarvalue like '%" + cond.getUpdateplatform_like() + "%'");
		}
		//����״̬
		if(StringUtils.isNotBlank(cond.getPrstatus())){
			query.append(" and a.prstatus = '" + cond.getPrstatus() + "'");
		}
		//������
		if(StringUtils.isNotBlank(cond.getChangecategory())){
			query.append(" and f.pivarvalue = '" + cond.getChangecategory() + "'");
		}
		//����ʱ��
		if(StringUtils.isNotBlank(cond.getPropentime_begin())){
			query.append(" and a.propentime >= '" + cond.getPropentime_begin() + "'");
		}
		if(StringUtils.isNotBlank(cond.getPropentime_end())){
			query.append(" and a.propentime <= '" + cond.getPropentime_end() + "'");
		}
		//ҵ��Ӱ�췶Χ
		if(StringUtils.isNotBlank(cond.getBusinessscope())){
			query.append(" and g.pivarvalue = '" + cond.getBusinessscope() + "'");
		}
		//���ԭ��
		if(StringUtils.isNotBlank(cond.getChangereason_like())){
			query.append(" and e.pivarvalue like '%" + cond.getChangereason_like() + "%'");
		}
		//�Ƿ�Ӱ��ҵ��
		if(StringUtils.isNotBlank(cond.getIsinfluence())){
			query.append(" and h.pivarvalue = '" + cond.getIsinfluence() + "'");
		}
		//�������
		if(StringUtils.isNotBlank(cond.getChangeclassify())){
			query.append(" and b.pivarvalue = '" + cond.getChangeclassify() + "'");
		}
		//�������
		if(StringUtils.isNotBlank(cond.getChangecontent_like())){
			query.append(" and i.pivarvalue like '%" + cond.getChangecontent_like() + "%'");
		}
		//������
		if(StringUtils.isNotBlank(cond.getPpusername_like())){
			query.append(" and exists (select 1 from ig337 pp where a.prid = pp.prid and pp.ppusername like '%"+cond.getPpusername_like()+"%' ) ");
		}
		query.append(" order by propentime desc ");
		return query;
	}
}