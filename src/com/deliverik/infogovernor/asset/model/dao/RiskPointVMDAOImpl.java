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
import com.deliverik.infogovernor.asset.model.RiskPointVMInfo;
import com.deliverik.infogovernor.asset.model.condition.RiskPointVMSearchCond;
import com.deliverik.infogovernor.asset.model.entity.RiskPointVM;

/**
  * ����: ���յ��ѯDAOʵ��
  * ��������: ���յ��ѯDAOʵ��
  * ������¼: 2014/06/30
  * �޸ļ�¼: 
  */
public class RiskPointVMDAOImpl extends
		BaseHibernateDAOImpl<RiskPointVMInfo> implements RiskPointVMDAO {

	/**
	 * ���캯��
	 */
	public RiskPointVMDAOImpl(){
		super(RiskPointVM.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	@Override
	public List<RiskPointVMInfo> findAll() {
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
	public RiskPointVMInfo findByPK(Serializable pk) {
		RiskPointVMInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final RiskPointVMSearchCond cond){
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
	public List<RiskPointVMInfo> findByCond(final RiskPointVMSearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback(){
			
			public Object doInHibernate(Session session)throws HibernateException, SQLException {
			
				session.flush();
				//��ȡquery
				StringBuffer query = new StringBuffer();
				query.append( session.getNamedQuery("RiskPoint.search").getQueryString());
				
				/**׷�� �������� ��ѯ����*/
				
				/**����ID*/
				if(StringUtils.isNotEmpty(cond.getEiid())){
					query.append(" and risk.eiid = '"+cond.getEiid()+"'");
				}
				/**��������*/
				if(StringUtils.isNotEmpty(cond.getEiname())){
					query.append(" and risk.einame like '%"+cond.getEiname()+"%'");
				}
				/**���ձ��*/
				if(StringUtils.isNotEmpty(cond.getEilabel())){
					query.append(" and risk.eilabel like '%"+cond.getEilabel()+"%'");
				}
				
				/**���յȼ�*/
				if(StringUtils.isNotEmpty(cond.getGrad())){
					query.append(" and risk.grad = '"+cond.getGrad()+"'");
				}
				/**���չ�����*/
				if(StringUtils.isNotEmpty(cond.getMguserid())){
					query.append(" and risk.managername = '"+cond.getMguserid()+"'");
				}
				/**�Ǽ���*/
				if(StringUtils.isNotEmpty(cond.getStartdate())&&StringUtils.isNotEmpty(cond.getEnddate())){
					query.append(" and risk.eiinsdate between '"+cond.getStartdate()+"%' and  '"+cond.getEnddate()+"'");
				}
				/**����������*/
				if(StringUtils.isNotEmpty(cond.getPoss())){
					query.append(" and risk.poss = '"+cond.getPoss()+"'");
				}
				
				/**���ձ�־*/
				if(StringUtils.isNotEmpty(cond.getRisksign())){
					query.append(" and risk.risksign = '"+cond.getRisksign()+"'");
				}
				
				//����� 
				if(StringUtils.isNotEmpty(cond.getSyscoding())){
					query.append(" and risk.ESYSCODING like '"+cond.getSyscoding()+"%'");
				}
				//��ȡSQLQuery
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("risk",RiskPointVM.class);
				setFetchPoint(q, start, count);
				List<RiskPointVMInfo> list=q.list();
				session.clear();
				session.close();
				return list;
			}
			
		};
		return (List<RiskPointVMInfo>)execute(action);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(RiskPointVMSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		return c;
	}

}