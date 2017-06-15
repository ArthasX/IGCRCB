/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.util.LabelValueBean;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.prd.model.IG222Info;
import com.deliverik.framework.workflow.prd.model.IG309Info;
import com.deliverik.framework.workflow.prd.model.condition.IG222SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG222TB;
import com.deliverik.framework.workflow.prd.model.entity.IG309VW;

/**
 * 
 * ���̲����߶���DAOʵ��
 * @author maozhipeng@deliverik.com
 *
 */
@SuppressWarnings("deprecation")
public class IG222DAOImpl extends BaseHibernateDAOImpl<IG222Info> implements IG222DAO{

	/**
	 * ���캯��
	 */
	public IG222DAOImpl(){
		super(IG222TB.class);
	}
	
	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<IG222Info> findAll(){
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("ppdid"));
		List<IG222Info> ret = findByCriteria(c);
		return ret;
	}

	/**
	 * ������������
	 * @param ppdid ����
	 * @return �������
	 */
	public IG222Info findByPK(Serializable ppdid){
		
		IG222Info processParticipantDef = super.findByPK(ppdid);
		
		if(processParticipantDef == null) return null;

		return processParticipantDef;
	}
	

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG222SearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG222Info> findByCond(final IG222SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		List<IG222Info> ret = findByCriteria(c);
		return ret;
	}
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(IG222SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();		
		if(StringUtils.isNotEmpty(cond.getPsdid())){
			c.add(Expression.eq("psdid", cond.getPsdid()));
		}
		if(StringUtils.isNotEmpty(cond.getPpdid())){
			c.add(Expression.eq("ppdid", cond.getPpdid()));
		}
		if( cond.getRoleid() != null && cond.getRoleid() != 0){
			c.add(Expression.eq("roleid", cond.getRoleid()));
		}
		if(StringUtils.isNotEmpty(cond.getPpdid_like())){
			c.add(Expression.like("ppdid", cond.getPpdid_like() + "%"));
		}
		if(StringUtils.isNotEmpty(cond.getIsOrg())){
			if("Y".equals(cond.getIsOrg())){
				c.add(Expression.isNull("roleid"));
			}else if("N".equals(cond.getIsOrg())){
				c.add(Expression.or(Expression.isNull("orgid"), Expression.eq("orgid", "")));
			}
		}
		return c;
	}
	
	/**
	 * ��ȡָ���û����еķ������̵Ľ�ɫ
	 * @param userid �û�ID
	 * @param pdid ���̶���ID
	 * @return �����ɫ�����б�
	 */
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<LabelValueBean> searchInitProcessParticipantRole(final String userid, final String pdid){
		
			HibernateCallback action = new HibernateCallback() {
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					session.flush();
					StringBuffer query = new StringBuffer();
					query.append(session.getNamedQuery("IG222DAO.initRoleQuery").getQueryString());
					SQLQuery q = session.createSQLQuery(query.toString());
					q.setString("userid", userid);
					q.setString("pdid", pdid);
					setFetchPoint(q, 0, 0);
					List<Object[]> list = q.list();
					List<LabelValueBean> bean = new ArrayList<LabelValueBean>();
					for(Object[] obj : list) {
						bean.add(new LabelValueBean(obj[0].toString(),obj[1].toString()));
					}
					session.clear();
					return bean;
				}
			};
			return (List) execute(action);
		}
	
	/**
	 * ��ȡ�������̵Ľ�ɫ(��ά�ƻ�)
	 * @param userid �û�ID
	 * @param pdid ���̶���ID
	 * @return �����ɫ�����б�
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<LabelValueBean> searchInitProcessParticipantRoleAll(final String pdid){
		
			HibernateCallback action = new HibernateCallback() {
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					session.flush();
					StringBuffer query = new StringBuffer();
					query.append(session.getNamedQuery("IG222DAO.initRoleAllQuery").getQueryString());
					SQLQuery q = session.createSQLQuery(query.toString());
					q.setString("pdid", pdid);
					setFetchPoint(q, 0, 0);
					List<Object[]> list = q.list();
					List<LabelValueBean> bean = new ArrayList<LabelValueBean>();
					for(Object[] obj : list) {
						bean.add(new LabelValueBean(obj[0].toString(),obj[1].toString()));
					}
					session.clear();
					return bean;
				}
			};
			return (List) execute(action);
		}
	
	/**
	 * PPDID����ֵȡ��
	 * 
	 * @param ����״̬ID
	 * @return PPDID����ֵ
	 */
	@SuppressWarnings("rawtypes")
	public String getPpdidSequenceNextValue(String psdid) {
		String sql =  "SELECT MAX(ppd.ppdid) FROM IG222TB ppd WHERE ppd.ppdid LIKE :psdid";
		NamedParamMap p = getNamedParamMap();
		p.setString("psdid", psdid + "%");
		List l = findByNamedParamMap(sql, p);
		if( l.size() == 0 || StringUtils.isEmpty((String)l.get(0))) {
			return psdid + StringUtils.leftPad("1", IGPRDCONSTANTS.ID_SUFFIX_LENGTH, "0");
		} else {
			String id = (String)l.get(0);
			return psdid + StringUtils.leftPad((Integer.parseInt(id.replaceFirst(psdid, "")) + 1) + "", IGPRDCONSTANTS.ID_SUFFIX_LENGTH, "0"); 
		}
	}
	
	/**
	 * �����߿��Ӱ�ť��ѯ
	 * 
	 * @param psdid ״̬ID
	 * @param roleid ��ɫID
	 * @return ���Ӱ�ť�б�
	 */
	@SuppressWarnings("unchecked")
	public List<IG309Info> searchVisibleButton(final String psdid, final Integer roleid){
			HibernateCallback action = new HibernateCallback() {
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					session.flush();
					StringBuffer query = new StringBuffer();
					query.append(session.getNamedQuery("IG222DAO.searchVisibleButton").getQueryString());
					SQLQuery q = session.createSQLQuery(query.toString());
					q.setString("psdid", psdid);
					q.setInteger("roleid", roleid);
					setFetchPoint(q, 0, 0);
					q.addEntity(IG309VW.class);
					List<IG309Info> list = q.list();
					session.clear();
					return list;
				}
			};
			return (List<IG309Info>) execute(action);
		}
	
	/**
	 * ������ȱʡ���Ӱ�ť��ѯ
	 * 
	 * @param psdid ״̬ID
	 * @return ȱʡ���Ӱ�ť�б�
	 */
	@SuppressWarnings("unchecked")
	public List<IG309Info> searchDefaultVisibleButton(final String psdid){
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("IG222DAO.searchDefaultVisibleButton").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setString("psdid", psdid);
				setFetchPoint(q, 0, 0);
				q.addEntity(IG309VW.class);
				List<IG309Info> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<IG309Info>) execute(action);
	}
	
	/**
	 * ͬ��ɫ�������ύԾǨ��ť��ѯ����ͨȨ�ޣ�
	 * 
	 * @param psdid ״̬ID
	 * @return ��ť�б�
	 */
	@SuppressWarnings("unchecked")
	public Map<String, String> searchRoleCommitNormalAuth(final String psdid){
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("IG222DAO.searchRoleCommitNormalAuth").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString()).addScalar("ROLEID", Hibernate.STRING).
							addScalar("PBDID", Hibernate.STRING);
				q.setString("psdid", psdid);
				setFetchPoint(q, 0, 0);
				List<Object[]> list = q.list();
				Map<String, String> map = new HashMap<String, String>();
				for(Object[] obj : list) {
					map.put(obj[0].toString(), obj[1].toString());
				}
				session.clear();
				return map;
			}
		};
		return (Map<String, String>) execute(action);
	}
	
	/**
	 * ͬ��ɫ�������ύԾǨ��ť��ѯ��ȱʡȨ�ޣ�
	 * 
	 * @param psdid ״̬ID
	 * @return ��ť�б�
	 */
	@SuppressWarnings("unchecked")
	public List<String> searchRoleCommitDefaultAuth(final String psdid){
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("IG222DAO.searchRoleCommitDefaultAuth").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString()).addScalar("PBDID", Hibernate.STRING);
				q.setString("psdid", psdid);
				setFetchPoint(q, 0, 0);
				List<String> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<String>) execute(action);
	}
	
	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	@SuppressWarnings("unchecked")
	public List<IG222Info> findByCondRun(final IG222SearchCond cond){
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("IG222DAO.findByCondRun").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setString("pdid", cond.getPdid());
				q.setInteger("prid", cond.getPrid());
				setFetchPoint(q, 0, 0);
				q.addEntity("pptb",IG222TB.class);
				List<IG222Info> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<IG222Info>) execute(action);
	}
}
