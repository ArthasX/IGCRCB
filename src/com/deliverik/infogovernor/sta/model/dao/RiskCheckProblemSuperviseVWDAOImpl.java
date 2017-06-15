/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.sta.model.dao;

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
import com.deliverik.infogovernor.prr.model.entity.DispatchStatisticsVW;
import com.deliverik.infogovernor.sta.model.RiskCheckProblemSuperviseVWInfo;
import com.deliverik.infogovernor.sta.model.condition.RiskCheckProblemSuperviseVWSearchCond;
import com.deliverik.infogovernor.sta.model.entity.RiskCheckProblemSuperviseVW;

/**
  * ����: �������ļලDAOʵ��
  * ��������: �������ļලDAOʵ��
  * ������¼: 2013/02/27
  * �޸ļ�¼: 
  */
public class RiskCheckProblemSuperviseVWDAOImpl extends
		BaseHibernateDAOImpl<RiskCheckProblemSuperviseVWInfo> implements RiskCheckProblemSuperviseVWDAO {

	/**
	 * ���캯��
	 */
	public RiskCheckProblemSuperviseVWDAOImpl(){
		super(DispatchStatisticsVW.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<RiskCheckProblemSuperviseVWInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public RiskCheckProblemSuperviseVWInfo findByPK(Serializable pk) {
		RiskCheckProblemSuperviseVWInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final RiskCheckProblemSuperviseVWSearchCond cond){
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
	public List<RiskCheckProblemSuperviseVWInfo> findByCond(final RiskCheckProblemSuperviseVWSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(RiskCheckProblemSuperviseVWSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		return c;
	}
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	@SuppressWarnings("unchecked")
	public List<RiskCheckProblemSuperviseVWInfo> findRiskCheckProblemSupervise(
			final RiskCheckProblemSuperviseVWSearchCond cond, final int start,final int count) {
			 HibernateCallback action = new HibernateCallback() {
		           public Object doInHibernate(Session session) throws HibernateException, SQLException {
		               session.flush();
		               StringBuffer query = new StringBuffer();
		               query.append( session.getNamedQuery("RiskCheckProblemSuperviseVWDAO.searchRiskCheckProblemSupervise").getQueryString());
		               getSql(cond, query);
		               SQLQuery q = session.createSQLQuery(query.toString());
		               q.addEntity("pr",RiskCheckProblemSuperviseVW.class);
		               setFetchPoint(q, start, count);
		               List<RiskCheckProblemSuperviseVWInfo> list = q.list();
		               session.clear();
		               return list;
		           }
		       };
			return (List<RiskCheckProblemSuperviseVWInfo>) execute(action);
		}
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	public int findRiskCheckProblemSuperviseSearchCount(final RiskCheckProblemSuperviseVWSearchCond cond) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("RiskCheckProblemSuperviseVWDAO.getCount").getQueryString());
				getSql(cond, query);
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				session.clear();
				return getCount(q.list());
			}
		};
		return (Integer) execute(action);
	}

	private void getSql(RiskCheckProblemSuperviseVWSearchCond cond, StringBuffer query){
		//�������
	   if(StringUtils.isNotEmpty(cond.getPrtitle())){
		    query.append(" and pr.prtitle like '%"+cond.getPrtitle()+"%'");
	   }
	   //��ѯ������ʼʱ��
	   if(StringUtils.isNotEmpty(cond.getPropentime_from()) ){
		    query.append(" and pr.propentime > '"+cond.getPropentime_from()+" 00:00'");
	    }
	   //��ѯ��������ʱ��
	   if(StringUtils.isNotEmpty(cond.getPropentime_to()) ){
		    query.append(" and pr.propentime < '"+cond.getPropentime_to()+" 23:59'");
	    }
	   if(StringUtils.isNotEmpty(cond.getQuestionstatus())){
		   if("1".equals(cond.getQuestionstatus())){
		       if(StringUtils.isNotEmpty(cond.getPrstatus())){
		           query.append(" and pr.prstatus = '"+cond.getPrstatus()+"'");
		       }else{
		           query.append(" and pr.prstatus <> 'C'");
		       }
		   } else if("2".equals(cond.getQuestionstatus())){
			   query.append(" and pr.prstatus = 'C'");
		   }
	   }
	   if(StringUtils.isNotEmpty(cond.getCategory())){
	       if("1".equals(cond.getCategory())){
//	           query.append(" and pr.prpdid like '01020%'");
	           query.append(" and pr.prpdid like '01021%'");
	       } else if("2".equals(cond.getCategory())){
	           query.append(" and (pr.prpdid like '01183%' or pr.prpdid like '01206%')");
	       }
	   }else {
//	       query.append(" and (pr.prpdid like '01020%' or pr.prpdid like '01183%' or pr.prpdid like '01206%')");
	       query.append(" and (pr.prpdid like '01021%')");
	   }
	   if(StringUtils.isNotEmpty(cond.getRcclass())){
		   query.append(" and exists (select 1 from IG599 pi where pi.prid = pr.prid and pi.pivarname = '���������' and pi.pivarvalue = '"+cond.getRcclass()+"')");
	   }
	   if(StringUtils.isNotEmpty(cond.getRcsourse())){
		   query.append(" and exists (select 1 from IG599 pi where pi.prid = pr.prid and pi.pivarname = '�����Դ' and pi.pivarvalue = '"+cond.getRcsourse()+"')");
	   }
	}
}