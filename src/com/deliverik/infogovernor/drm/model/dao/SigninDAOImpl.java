/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.drm.model.SigninInfo;
import com.deliverik.infogovernor.drm.model.condition.SigninSearchCond;
import com.deliverik.infogovernor.drm.model.entity.SigninTB;

/**
  * ����: ǩ����DAOʵ��
  * ��������: ǩ����DAOʵ��
  * ������¼: 2015/03/12
  * �޸ļ�¼: 
  */
public class SigninDAOImpl extends
		BaseHibernateDAOImpl<SigninInfo> implements SigninDAO {

	/**
	 * ���캯��
	 */
	public SigninDAOImpl(){
		super(SigninTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	@Override
	public List<SigninInfo> findAll() {
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
	public SigninInfo findByPK(Serializable pk) {
		SigninInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SigninSearchCond cond){
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
	public List<SigninInfo> findByCond(final SigninSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		
		c.addOrder(Order.asc("siroleid"));
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(SigninSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if (StringUtils.isNotEmpty(cond.getSiuserid())) {
	        c.add(Restrictions.eq("siuserid", cond.getSiuserid()));
	    }
		if (StringUtils.isNotEmpty(cond.getSiusername())) {
			c.add(Restrictions.eq("siusername", cond.getSiusername()));
		}
		if (StringUtils.isNotEmpty(cond.getSitime())) {
			c.add(Restrictions.eq("sitime", cond.getSitime()));
		}
	    if (cond.getDrillprid()!=null&& !(0 ==cond.getDrillprid().intValue())) {
	        c.add(Restrictions.eq("drillprid", cond.getDrillprid()));
	    }
	    if (cond.getEcprid()!=null&& !(0 ==cond.getEcprid().intValue())) {
	    	c.add(Restrictions.eq("ecprid", cond.getEcprid()));
	    }
	    if (cond.getSceneprid()!=null&& !(0 ==cond.getSceneprid().intValue())) {
	    	c.add(Restrictions.eq("sceneprid", cond.getSceneprid()));
	    }
	    if (cond.getSiid()!=null&& !(0 ==cond.getSiid().intValue())) {
	    	c.add(Restrictions.eq("siid", cond.getSiid()));
	    }
	    if (cond.getSiroleid()!=null&& !(0 ==cond.getSiroleid().intValue())) {
	    	c.add(Restrictions.eq("siroleid", cond.getSiroleid()));
	    }
	    if (cond.getWdc()!=null&& !(0 ==cond.getWdc().intValue())) {
	    	c.add(Restrictions.eq("wdc", cond.getWdc()));
	    }
	    if (cond.getWdp()!=null&& !(0 ==cond.getWdp().intValue())) {
	    	c.add(Restrictions.eq("wdp", cond.getWdp()));
	    }
	    if(cond.getRoleidin()!=null&&cond.getRoleidin().length>0){
			c.add(Restrictions.in("siroleid", cond.getRoleidin()));
		}
		return c;
	}
	/**
	 * ǩ����Ϣ��ѯ
	 * @param �û�id
	 * @param ����prid
	 * @param �Ƿ������� true ��
	 */
		@SuppressWarnings("unchecked")
		public List<Map<String,Object>> searchSignInList(String userid,Integer prid,boolean isDrill) {
			
			Session session = getSession();
			
			
			String sql = "";
			if(isDrill){
				sql = session.getNamedQuery("signinDAO.searchSigninListForDrill").getQueryString();
			}else{
				sql = session.getNamedQuery("signinDAO.searchSigninListForDirect").getQueryString();
			}
			if(StringUtils.isNotEmpty(userid)){
				
				sql+= "  AND T.SIUSERID = '"+userid+"' ";
			}
			
			if(prid!=null && prid>0){
				sql+= " AND I5.PRID = "+prid;
			}
			
			sql+= " ORDER BY I5.PROPENTIME DESC";
			SQLQuery q = session.createSQLQuery(sql);
			q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
			if(isDrill){
				q.addScalar("DRILLPRID", Hibernate.STRING);
			}else{
				q.addScalar("ECPRID", Hibernate.STRING);
			}
			q.addScalar("SIUSERID", Hibernate.STRING);
			q.addScalar("PRID", Hibernate.STRING);
			q.addScalar("PRSTATUS", Hibernate.STRING);
			q.addScalar("PRSUBSTATUS", Hibernate.STRING);
			q.addScalar("PRTITLE", Hibernate.STRING);
			q.addScalar("PROPENTIME", Hibernate.STRING);
			q.addScalar("PRCLOSETIME", Hibernate.STRING);
			q.addScalar("USERNAME", Hibernate.STRING);
			q.addScalar("SIGNINED", Hibernate.STRING);
			q.addScalar("PRSERIALNUM", Hibernate.STRING);
			q.addScalar("PRTYPE", Hibernate.STRING);
			q.addScalar("SITIME", Hibernate.STRING);
			q.addScalar("PRDESC", Hibernate.STRING);
			q.addScalar("PROPENTIME", Hibernate.STRING);
			return q.list();
		}
		/**
		 * dashboard ��Ա��Ϣ��ʼ����Ϣ
		 */
		@SuppressWarnings("unchecked")
		public List<Map<String,Object>> searchSigninInitData(Integer ecprid) {
			
			Session session = getSession();
			
			String sql = "";
			sql = session.getNamedQuery("SigninDAO.searchSigninInitDataByCond").getQueryString();
			
			SQLQuery q = session.createSQLQuery(sql);
			q.setInteger("ECPRID", ecprid);
			
			q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
			q.addScalar("SNAME", Hibernate.STRING);
			q.addScalar("TOTALCOUNT", Hibernate.STRING);
			q.addScalar("INCOUNT", Hibernate.STRING);
			return q.list();
		}
		/**
		 * ��ѯ������
		 * @param ecprid
		 * @return
		 */
		public List<Map<String,Object>> searchSigninPeopleDataByCond(Integer ecprid){
			Session session = getSession();
			String sql = "";
			sql = session.getNamedQuery("SigninDAO.searchSigninPeopleDataByCond").getQueryString();
			SQLQuery q = session.createSQLQuery(sql);
			q.setInteger("ECPRID", ecprid);
			
			q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
			q.addScalar("SNAME", Hibernate.STRING);
			q.addScalar("SIGNINED", Hibernate.INTEGER);
			return q.list();
			
		}
		/**
		 * ����ǩ������Ӧ��ָ������prid
		 * @param drillPrid ��������id
		 * @param directPrid Ӧ��ָ������prid
		 * @return
		 */
		public int setDirectPrid(Integer drillPrid,Integer directPrid){
			Session session = getSession();
			String sql = session.getNamedQuery("signinDAO.setDirectPrid").getQueryString();
			SQLQuery q = session.createSQLQuery(sql);
			q.setInteger("ecprid", directPrid);
			q.setInteger("drillprid", drillPrid);
			return q.executeUpdate();
			
		}

		/**
		 * ����ǩ�����г�������prid
		 * @param directPrid ָ������prid
		 * @param scenePrid ��������prid
		 * @return
		 */
		public int setScenePrid(Integer directPrid,Integer scenePrid){
			
			Session session = getSession();
			String sql = session.getNamedQuery("signinDAO.setScenePrid").getQueryString();
			SQLQuery q = session.createSQLQuery(sql);
			q.setInteger("ecprid", directPrid);
			q.setInteger("sceneprid", scenePrid);
			return q.executeUpdate();
		}

	/**
	 * ����ǩ�����г�������prid
	 * 
	 * @param drillPrid
	 *            ��������id
	 * @param scenePrid
	 *            ��������prid
	 * @return
	 */
	public int setScenePridFormDrill(Integer drillPrid, Integer scenePrid) {

		Session session = getSession();
		String sql = session.getNamedQuery("signinDAO.setScenePridFormDrill").getQueryString();
		SQLQuery q = session.createSQLQuery(sql);
		q.setInteger("drillprid", drillPrid);
		q.setInteger("sceneprid", scenePrid);
		return q.executeUpdate();
	}
		
		/**
		 * ��ԭ������Ա��Ϣ  ɾ��
		 * @param ecprid
		 */
		public void delWDP (Integer ecprid){
			String sql = " delete from signin where ecprid = :ecprid and WDC is null and WDP is not null";
			Session session = getSession();
			SQLQuery q = session.createSQLQuery(sql);
			q.setInteger("ecprid", ecprid);
			q.executeUpdate();
		}
		/**
		 * ��ԭ������Ա��Ϣ  �޸�
		 * @param ecprid
		 */
		public void updWDP (Integer ecprid){
			String sql = "  update signin set WDP  = null where ecprid = :ecprid and WDC is not null and WDP is not null";
			Session session = getSession();
			SQLQuery q = session.createSQLQuery(sql);
			q.setInteger("ecprid", ecprid);
			q.executeUpdate();
		}
}