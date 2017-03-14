/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.model.dao;

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
import com.deliverik.infogovernor.asset.model.CheckItemVWInfo;
import com.deliverik.infogovernor.asset.model.RiskPointVMInfo;
import com.deliverik.infogovernor.asset.model.condition.CheckItemVWSearchCond;
import com.deliverik.infogovernor.asset.model.entity.CheckItemVW;

/**
  * ����: ������ѯDAOʵ��
  * ��������: ������ѯDAOʵ��
  * ������¼: 2014/07/01
  * �޸ļ�¼: 
  */
public class CheckItemVWDAOImpl extends
		BaseHibernateDAOImpl<CheckItemVWInfo> implements CheckItemVWDAO {

	/**
	 * ���캯��
	 */
	public CheckItemVWDAOImpl(){
		super(CheckItemVW.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	@Override
	public List<CheckItemVWInfo> findAll() {
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
	public CheckItemVWInfo findByPK(Serializable pk) {
		CheckItemVWInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final CheckItemVWSearchCond cond){
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
	public List<CheckItemVWInfo> findByCond(final CheckItemVWSearchCond cond, final int start, final int count){
			HibernateCallback action = new HibernateCallback(){
			
			public Object doInHibernate(Session session)throws HibernateException, SQLException {
			
				session.flush();
				//��ȡquery
				StringBuffer query = new StringBuffer();
				query.append( session.getNamedQuery("Check.Item").getQueryString());
				
				/**׷�� �������� ��ѯ����*/
				/**�����Ƶ��*/
				if(StringUtils.isNotEmpty(cond.getCheckfrequency())){
					query.append(" and item.checkfrequency = '"+cond.getCheckfrequency()+"'");
				}
				
				/**���������*/
				if(StringUtils.isNotEmpty(cond.getEiname())){
					query.append(" and item.einame like  '%"+cond.getEiname()+"%'");
				}
				/**���չ�����*/
				if(StringUtils.isNotEmpty(cond.getManagername())){
					query.append(" and item.managername = '"+cond.getManagername()+"'");
				}
				/**�Ǽ���*/
				if(StringUtils.isNotEmpty(cond.getStartdate()) && StringUtils.isNotEmpty(cond.getEnddate())){
					query.append(" and item.eiinsdate between '"+cond.getStartdate()+"' and '"+cond.getEnddate()+"'");
				}
				/**���*/
				if(StringUtils.isNotEmpty(cond.getBh())){
					query.append(" and item.eilabel like '%"+cond.getBh()+"%'");
				}
				/**����*/
				if(StringUtils.isNotEmpty(cond.getEiid())){
					query.append(" and item.eiid = '"+cond.getEiid()+"'");
				}
				if(StringUtils.isNotEmpty(cond.getSyscoding())){
					query.append(" and item.ESYSCODING like '"+cond.getSyscoding()+"%'");
				}
				//��ȡSQLQuery
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("item",CheckItemVW.class);
				setFetchPoint(q, start, count);
				List<RiskPointVMInfo> list=q.list();
				session.clear();
				session.close();
				return list;
			}
			
		};
		return (List<CheckItemVWInfo>)execute(action);
	}
	/**
	 * (��ȫ��Ϣ �����)������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	@SuppressWarnings("unchecked")
	public List<CheckItemVWInfo> safeInfoFindByCond(final CheckItemVWSearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback(){
			
			public Object doInHibernate(Session session)throws HibernateException, SQLException {
				
				session.flush();
				//��ȡquery
				StringBuffer query = new StringBuffer();
				query.append( session.getNamedQuery("SafeInfoCheck.Item").getQueryString());
				
				/**׷�� �������� ��ѯ����*/
				/**�����Ƶ��*/
				if(StringUtils.isNotEmpty(cond.getCheckfrequency())){
					query.append(" and item.checkfrequency = '"+cond.getCheckfrequency()+"'");
				}
				
				/**���������*/
				if(StringUtils.isNotEmpty(cond.getEiname())){
					query.append(" and item.einame like  '%"+cond.getEiname()+"%'");
				}
				/**���չ�����*/
				if(StringUtils.isNotEmpty(cond.getManagername())){
					query.append(" and item.managername = '"+cond.getManagername()+"'");
				}
				/**�Ǽ���*/
//				if(StringUtils.isNotEmpty(cond.getStartdate()) || StringUtils.isNotEmpty(cond.getEnddate())){
//					query.append(" and item.eiinsdate between '"+cond.getStartdate()+"' and '"+cond.getEnddate()+"'");
//				}
				if(StringUtils.isNotEmpty(cond.getStartdate())){
					query.append(" and item.eiinsdate >= '").append(cond.getStartdate()).append("' ");
				}
				if(StringUtils.isNotEmpty(cond.getEnddate())){
					query.append(" and item.eiinsdate <= '").append(cond.getEnddate()).append("' ");
				}
				/**���*/
				if(StringUtils.isNotEmpty(cond.getBh())){
					query.append(" and item.eilabel like '%"+cond.getBh()+"%'");
				}
				/**����*/
				if(StringUtils.isNotEmpty(cond.getEiid())){
					query.append(" and item.eiid = '"+cond.getEiid()+"'");
				}
				/**����in*/
				if(StringUtils.isNotEmpty(cond.getEiid_NotIn())){
					query.append(" and item.eiid not in ("+ cond.getEiid_NotIn()+")");
				}
				if(StringUtils.isNotEmpty(cond.getSyscoding())){
					query.append(" and item.ESYSCODING like '"+cond.getSyscoding()+"%'");
				}
				//��ȡSQLQuery
				query.append(" order by eiupdtime desc");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("item",CheckItemVW.class);
				setFetchPoint(q, start, count);
				List<RiskPointVMInfo> list=q.list();
				session.clear();
				session.close();
				return list;
			}
			
		};
		return (List<CheckItemVWInfo>)execute(action);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(CheckItemVWSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		return c;
	}

}