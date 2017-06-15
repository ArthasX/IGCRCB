/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prr.model.dao;

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
import com.deliverik.infogovernor.prr.model.CopyReadUserInfo;
import com.deliverik.infogovernor.prr.model.condition.CopyReadUserSearchCond;
import com.deliverik.infogovernor.prr.model.entity.CopyReadUserTB;

/**
  * ����: �����˱�DAOʵ��
  * ��������: �����˱�DAOʵ��
  * ������¼: 2013/02/25
  * �޸ļ�¼: 
  */
public class CopyReadUserDAOImpl extends
		BaseHibernateDAOImpl<CopyReadUserInfo> implements CopyReadUserDAO {

	/**
	 * ���캯��
	 */
	public CopyReadUserDAOImpl(){
		super(CopyReadUserTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CopyReadUserInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CopyReadUserInfo findByPK(Serializable pk) {
		CopyReadUserInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final CopyReadUserSearchCond cond){
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
	public List<CopyReadUserInfo> findByCond(final CopyReadUserSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(CopyReadUserSearchCond cond){
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
	public List<CopyReadUserInfo> getCopyReadUserInfo(
			final CopyReadUserSearchCond cond, final int start,final int count) {
			 HibernateCallback action = new HibernateCallback() {
		           public Object doInHibernate(Session session) throws HibernateException, SQLException {
		               session.flush();
		               StringBuffer query = new StringBuffer();
		               query.append( session.getNamedQuery("CopyReadUserDAO.getCopyReadUserInfo").getQueryString());
		               //������id
		       		   if(StringUtils.isNotEmpty(cond.getPruserid()) ){
		       			    query.append(" and cru.pruserid='"+cond.getPruserid()+"'");
		       		    }
		       		   //��������
		       		   if(StringUtils.isNotEmpty(cond.getPrtitle())){
		       			    query.append(" and cru.prtitle like '%"+cond.getPrtitle()+"%'");
		       		   }
		       		   //�Ƿ��Ѳ鿴
		       		   if(StringUtils.isNotEmpty(cond.getIslook())){
		       			    query.append(" and cru.islook='"+cond.getIslook()+"'");
		       		   }
		       		   //��������
		       		   if(cond.getPrid()!=null){
		       			    query.append(" and cru.prid="+cond.getPrid());
		       		   }
		       		   query.append(" order by cru.prstarttime");
		               SQLQuery q = session.createSQLQuery(query.toString());
		               q.addEntity("CopyReadUserTB",CopyReadUserTB.class);
		               setFetchPoint(q, start, count);
//		               System.out.println(query.toString());
		               List<CopyReadUserInfo> list = q.list();
		               session.clear();
		               return list;
		           }
		       };
			return (List<CopyReadUserInfo>) execute(action);
		}
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	@SuppressWarnings("unchecked")
	public List<CopyReadUserInfo> getCopyReadUserInfoDesc(
			final CopyReadUserSearchCond cond, final int start,final int count) {
			 HibernateCallback action = new HibernateCallback() {
		           public Object doInHibernate(Session session) throws HibernateException, SQLException {
		               session.flush();
		               StringBuffer query = new StringBuffer();
		               query.append( session.getNamedQuery("CopyReadUserDAO.getCopyReadUserInfo").getQueryString());
		               //������id
		       		   if(StringUtils.isNotEmpty(cond.getPruserid()) ){
		       			    query.append(" and cru.pruserid='"+cond.getPruserid()+"'");
		       		    }
		       		   //��������
		       		   if(StringUtils.isNotEmpty(cond.getPrtitle())){
		       			    query.append(" and cru.prtitle like '%"+cond.getPrtitle()+"%'");
		       		   }
		       		   //�Ƿ��Ѳ鿴
		       		   if(StringUtils.isNotEmpty(cond.getIslook())){
		       			    query.append(" and cru.islook='"+cond.getIslook()+"'");
		       		   }
		       		   //��������
		       		   if(cond.getPrid()!=null){
		       			    query.append(" and cru.prid="+cond.getPrid());
		       		   }
		       		   query.append(" order by cru.prstarttime desc");
		               SQLQuery q = session.createSQLQuery(query.toString());
		               q.addEntity("CopyReadUserTB",CopyReadUserTB.class);
		               setFetchPoint(q, start, count);
//		               System.out.println(query.toString());
		               List<CopyReadUserInfo> list = q.list();
		               session.clear();
		               return list;
		           }
		       };
			return (List<CopyReadUserInfo>) execute(action);
		}
	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public int getCopyReadUserCount( final CopyReadUserSearchCond cond) {
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
				query.append("select count(*) from(");
				query.append( session.getNamedQuery("CopyReadUserDAO.getCopyReadUserInfo").getQueryString());												
				//������id
	       		   if(StringUtils.isNotEmpty(cond.getPruserid()) ){
	       			    query.append(" and cru.pruserid='"+cond.getPruserid()+"'");
	       		    }
	       		   //��������
	       		   if(StringUtils.isNotEmpty(cond.getPrtitle())){
	       			    query.append(" and cru.prtitle like '%"+cond.getPrtitle()+"%'");
	       		   }
	       		   //�Ƿ��Ѳ鿴
	       		   if(StringUtils.isNotEmpty(cond.getIslook())){
	       			    query.append(" and cru.islook='"+cond.getIslook()+"'");
	       		   }
	       		 //��������
	       		   if(cond.getPrid()!=null){
	       			    query.append(" and cru.prid="+cond.getPrid());
	       		   }
	            query.append(")temp5");  
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				session.clear();
				session.close();
				return getCount(q.list());
			}
		};
		return (Integer) execute(action);
	}
}