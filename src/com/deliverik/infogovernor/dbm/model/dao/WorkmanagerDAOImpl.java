/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.dbm.model.dao;

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
import org.springframework.orm.hibernate3.HibernateCallback;

import com.csebank.lom.model.AdvanceDetail;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.dbm.model.WorkmanagerInfo;
import com.deliverik.infogovernor.dbm.model.condition.WorkmanagerSearchCond;
import com.deliverik.infogovernor.dbm.model.entity.WorkmanagerTB;
import com.deliverik.infogovernor.dbm.model.entity.WorkmanagerVW;

/**
  * ����: ��������DAOʵ��
  * ��������: ��������DAOʵ��
  * ������¼: 2016/04/19
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class WorkmanagerDAOImpl extends
		BaseHibernateDAOImpl<WorkmanagerInfo> implements WorkmanagerDAO {

	/**
	 * ���캯��
	 */
	public WorkmanagerDAOImpl(){
		super(WorkmanagerTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<WorkmanagerInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public WorkmanagerInfo findByPK(Serializable pk) {
		WorkmanagerInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final WorkmanagerSearchCond cond){
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
	public List<WorkmanagerInfo> findByCond(final WorkmanagerSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("wmstartdate"));
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(WorkmanagerSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//��������
		if(StringUtils.isNotEmpty(cond.getWmname())){
			c.add(Expression.like("wmname", "%"+cond.getWmname()+"%"));
		}
		//��������
		if(StringUtils.isNotEmpty(cond.getWmdesc())){
			c.add(Expression.like("wmdesc", "%"+cond.getWmdesc()+"%"));
		}
		//����״̬
		if(StringUtils.isNotEmpty(cond.getWmstatus())){
			c.add(Expression.eq("wmstatus", cond.getWmstatus()));
		}
		//��������ʱ��
		if(StringUtils.isNotEmpty(cond.getWmstartdate_from())){
			c.add(Expression.ge("wmstartdate", cond.getWmstartdate_from()));
		}
		if(StringUtils.isNotEmpty(cond.getWmstartdate_to())){
			c.add(Expression.le("wmstartdate", cond.getWmstartdate_to()));
		}
		//Ƶ��
		if(StringUtils.isNotEmpty(cond.getWmfrequency())){
			c.add(Expression.like("wmfrequency", "%"+cond.getWmfrequency()+"%"));
		}
		//����������
		if(StringUtils.isNotEmpty(cond.getWmusername())){
			c.add(Expression.like("wmusername", "%"+cond.getWmusername()+"%"));
		}
		//����Դid
		if(StringUtils.isNotEmpty(cond.getRewmid())){
			c.add(Expression.eq("wmid", cond.getWmusername()));
		}
		//��������
		if(StringUtils.isNotEmpty(cond.getWmstartdate())){
			c.add(Expression.like("wmstartdate", cond.getWmstartdate()+"%"));
		}
		//�Ƿ�����
		if(StringUtils.isNotEmpty(cond.getWmremind())){
			c.add(Expression.eq("wmremind", cond.getWmremind()));
		}
		return c;
	}

	/**
	 * ͳ�ƴ�������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	@SuppressWarnings("unchecked")
	public List<WorkmanagerVW> searchSumByCond(final WorkmanagerSearchCond cond) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer("select wmid,wmname,wmuserid,wmusername from workmanager where wmstatus=0 ");
				List<AdvanceDetail> list = null;
				//��������ʱ��
				if(StringUtils.isNotEmpty(cond.getWmstartdate_from())){
					query.append(" and wmlimitdate > '"+cond.getWmstartdate_from()+"'");
				}
				//��������ʱ��
				if(StringUtils.isNotEmpty(cond.getWmstartdate_to())){
					query.append(" and wmlimitdate <= '"+cond.getWmstartdate_to()+"'");
				}
				//�Ƿ�����
				if(StringUtils.isNotEmpty(cond.getWmremind())){
					query.append(" and wmremind = "+cond.getWmremind());
				}
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity("WorkmanagerVW", WorkmanagerVW.class);
				list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<WorkmanagerVW>) execute(action);
	}
	
}