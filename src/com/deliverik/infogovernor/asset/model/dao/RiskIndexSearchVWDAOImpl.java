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
import com.deliverik.infogovernor.asset.model.RiskIndexSearchVWInfo;
import com.deliverik.infogovernor.asset.model.condition.RiskIndexSearchVWSearchCond;
import com.deliverik.infogovernor.asset.model.entity.RiskIndexSearchVW;

/**
  * ����: ����ָ���ѯDAOʵ��
  * ��������: ����ָ���ѯDAOʵ��
  * ������¼: 2014/07/25
  * �޸ļ�¼: 
  */
public class RiskIndexSearchVWDAOImpl extends
		BaseHibernateDAOImpl<RiskIndexSearchVWInfo> implements RiskIndexSearchVWDAO {

	/**
	 * ���캯��
	 */
	public RiskIndexSearchVWDAOImpl(){
		super(RiskIndexSearchVW.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<RiskIndexSearchVWInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public RiskIndexSearchVWInfo findByPK(Serializable pk) {
		RiskIndexSearchVWInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final RiskIndexSearchVWSearchCond cond){
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
	public List<RiskIndexSearchVWInfo> findByCond(final RiskIndexSearchVWSearchCond cond, final int start, final int count){
			HibernateCallback action = new HibernateCallback(){
			
			public Object doInHibernate(Session session)throws HibernateException, SQLException {
				
				session.flush();
				//��ȡquery
				StringBuffer query = new StringBuffer();
				query.append( session.getNamedQuery("RiskZB.SEARCH").getQueryString());
				
				/**׷�� �������� ��ѯ����*/
				
				/**����ID*/
				if(StringUtils.isNotEmpty(cond.getEiid())){
					query.append(" and riskzb.eiid = '"+cond.getEiid()+"'");
				}
				/**����ID*/
				if(StringUtils.isNotEmpty(cond.getEiid_NotIn())){
					query.append(" and riskzb.eiid not in ("+cond.getEiid_NotIn()+")");
				}
				/**����ID*/
				if(StringUtils.isNotEmpty(cond.getEiid_In())){
					query.append(" and riskzb.eiid in ("+cond.getEiid_In()+")");
				}
				/**��������*/
				if(StringUtils.isNotEmpty(cond.getEiname())){
					query.append(" and riskzb.einame like '%"+cond.getEiname()+"%'");
				}
				/**���ձ��*/
				if(StringUtils.isNotEmpty(cond.getEilabel())){
					query.append(" and riskzb.eilabel like '%"+cond.getEilabel()+"%'");
				}
				/**ָ����;*/
				if(StringUtils.isNotEmpty(cond.getIndexused())){
					query.append(" and riskzb.indexused = '"+cond.getIndexused()+"'");
				}
				/**��ֵ*/
				if(StringUtils.isNotEmpty(cond.getZbfz())){
					query.append(" and riskzb.zbfz = '"+cond.getZbfz()+"'");
				}
				/**ָ��������*/
				if(StringUtils.isNotEmpty(cond.getDutyuser())){
					query.append(" and riskzb.dutyuser like '%"+cond.getDutyuser()+"%'");
				}
				/**ָ�����β���*/
				if(StringUtils.isNotEmpty(cond.getDutydepartment())){
					query.append(" and riskzb.dutydepartment like '%"+cond.getDutydepartment()+"%'");
				}
				/**�Ƿ�ؼ�ָ��*/
				if(StringUtils.isNotEmpty(cond.getKeyindex())){
					query.append(" and riskzb.keyindex = '"+cond.getKeyindex()+"'");
				}
				/**ָ�������*/
				if(StringUtils.isNotEmpty(cond.getMguserid())){
					query.append(" and riskzb.mguserid = '"+cond.getMguserid()+"'");
				}
				/**�Ǽ�����*/
				if(StringUtils.isNotEmpty(cond.getEiStartDate())&&StringUtils.isNotEmpty(cond.getEiEndDate())){
					query.append(" and riskzb.eiinsdate between '"+cond.getEiStartDate()+"%' and  '"+cond.getEiEndDate()+"'");
				}
				/**��������*/
				if(StringUtils.isNotEmpty(cond.getEuStartDate())&&StringUtils.isNotEmpty(cond.getEuEndDate())){
					query.append(" and riskzb.eiupdtime between '"+cond.getEuStartDate()+"%' and  '"+cond.getEuEndDate()+"'");
				}
				//��ȡSQLQuery
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("riskzb",RiskIndexSearchVW.class);
				
					setFetchPoint(q, start, count);
				
				List<RiskIndexSearchVWInfo> list=q.list();
				session.clear();
				session.close();
				return list;
			}
			
		};
		return (List<RiskIndexSearchVWInfo>)execute(action);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(RiskIndexSearchVWSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		return c;
	}

}