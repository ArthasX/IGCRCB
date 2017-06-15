/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.user.model.condition.UserRoleSearchCond;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.IG913Info;
import com.deliverik.framework.workflow.prd.model.condition.IG380SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG913SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG380TB;
import com.deliverik.framework.workflow.prd.model.entity.IG913VW;

/**
 * <p>����:�������Ͷ���DAOʵ��</p>
 * <p>����������1.��������ȫ������</p>
 * <p>          2.������ѯ�����</p>
 * <p>          3.������ѯ</p>
 * <p>          4.������ѯ���</p>
 * <p>          5.������������</p>
 * <p>          6.��������������Ա��ɫ����SearchCond ȫ��������</p>
 * <p>          7.��������������Ա��ɫ����SearchCond��</p>
 * <p>          8.��������(��ά�ƻ���)</p>
 * <p>������¼��</p>
 * <p>�޸ļ�¼����ʢ�	2010-12-13</p>
 */
public class IG380DAOImpl extends
		BaseHibernateDAOImpl<IG380Info> implements
		IG380DAO {
	
	private static String nextPdid = "";

	/**
	 * ���ܣ����캯��
	 */
	public IG380DAOImpl() {
		super(IG380TB.class);
	}

	/**
	 * ���ܣ���������ȫ������
	 * @return �������Ͷ�������
	 */
	@Override
	public List<IG380Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("ptid"));
		c.addOrder(Order.asc("pdid"));
		List<IG380Info> ret = findByCriteria(c);
		return ret;
	}

	/**
	 * ���ܣ�������ѯ
	 * @param prid
	 * @return IG380Info
	 */
	@Override
	public IG380Info findByPK(Serializable prid) {

		IG380Info pr = super.findByPK(prid);
		if (pr == null)
			return null;

		return pr;
	}

	/**
	 * ���ܣ�������ѯ���
	 * @param cond
	 * @param start
	 * @param count
	 * @return ��ѯ�����
	 */
	public List<IG380Info> findByCond(
			final IG380SearchCond cond, final int start,
			final int count) {
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("ptid"));
		//Ӧ������ר�ã�19���������̶���
		if(cond.getPtid()!=null&&cond.getPtid()==19){
			c.addOrder(Order.desc("pdid"));
		}else{
			c.addOrder(Order.asc("pdid"));
		}
		List<IG380Info> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * ���ܣ�������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(IG380SearchCond cond) {
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getPdid())){
			c.add(Restrictions.eq("pdid", cond.getPdid()));
		}
		if (cond.getPtid() != null && cond.getPtid() != 0) {
			c.add(Restrictions.eq("ptid", cond.getPtid()));
		}
		if (!StringUtils.isEmpty(cond.getPdname())) {
			c.add(Restrictions.eq("pdname", cond.getPdname()));
		}
		if (!StringUtils.isEmpty(cond.getPdstatus())) {
			c.add(Restrictions.eq("pdstatus", cond.getPdstatus()));
		}
		
		if (cond.getNotSelfPd() != null && cond.getNotSelfPd() != 0) {
			c.add(Restrictions.ne("ptid", cond.getNotSelfPd()));
		}
		if(cond.getPrTypeArray() != null){
			c.add(Restrictions.in("ptid", cond.getPrTypeArray()));
		}
		if(cond.getPdstatuses()!=null){
			c.add(Restrictions.in("pdstatus", cond.getPdstatuses()));
		}
		
		if(!StringUtils.isEmpty(cond.getPermission())){
			c.add(Restrictions.eq("permission", cond.getPermission()));
		}
		
		if(!StringUtils.isEmpty(cond.getPdid_like())){
			c.add(Restrictions.like("pdid", cond.getPdid_like() + "%"));
		}
		if(cond.getPdid_in()!=null &&cond.getPdid_in().length>0){
			c.add(Restrictions.in("pdid", cond.getPdid_in()));
		}
		if(cond.getPdid_not_in()!=null &&cond.getPdid_not_in().length>0){
			c.add(Restrictions.not(Restrictions.in("pdid", cond.getPdid_not_in())));
		}
		
		if(cond.getPrpdid_like_or() != null && cond.getPrpdid_like_or().length > 0){
		    String[] prpdid_like_or = cond.getPrpdid_like_or();
            StringBuffer query = new StringBuffer();
            query.append(" ( ");
            for (int i = 0; i < prpdid_like_or.length; i++) {
                query.append(" pdid like '").append(prpdid_like_or[i]).append("%' ");
                if(i < prpdid_like_or.length - 1){
                    query.append(" or ");
                }
            }
            query.append(" ) ");
            c.add(Restrictions.sqlRestriction(query.toString()));
        }
		if(StringUtils.isNotEmpty(cond.getActname())){
		    c.add(Restrictions.eq("pdactname", cond.getActname()));
		}
		if(cond.getPdid_in()!=null){	
			if(cond.getPdid_in().length>0){
				c.add(Restrictions.in("pdid", cond.getPdid_in()));
			}else{
				c.add(Restrictions.in("pdid", new String[]{"1"}));
			}
		}
		if(cond.getPdid_not_in()!=null){
			if(cond.getPdid_not_in().length>0){
				c.add(Restrictions.not(Restrictions.in("pdid", cond.getPdid_not_in())));
			}else{
				c.add(Restrictions.not(Restrictions.in("pdid", new String[]{"1"})));
			}
		}
		
		return c;
	}

	
	public int getSearchCount(final IG380SearchCond cond) {
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}
	
	/**
	 * ָ���û��ɷ����Զ������̲�ѯ����
	 * @param userid �û�ID
	 * @param pdstatus �Զ�������״̬
	 * @return ָ���û��ɷ����Զ��������б�
	 */
	
	@SuppressWarnings("unchecked")
	public List<IG380Info> findSelfDefinitionByUserId(final String userid, final String pdstatus){
		HibernateCallback action = new HibernateCallback() {
			
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("IG380DAO.selfDefQuery").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setString("userid", userid);
				q.setString("pdstatus", pdstatus);
				q.addEntity("pd",IG380TB.class);
				setFetchPoint(q, 0, 0);
				List<IG380Info> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<IG380Info>) execute(action);
	}
	
	/**
	 * ���ܣ�������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	
	@SuppressWarnings("unchecked")
	public List<IG380Info> findSelfDefinitionByUserIdCom(final UserRoleSearchCond cond, final Integer ptid
			, final String pdstatus){
		HibernateCallback action = new HibernateCallback() {
			
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("IG380DAO.selfDefComQuery").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.setInteger("ptid", ptid);
				q.setString("pdstatus", pdstatus);
				q.addEntity("pd",IG380TB.class);
				setFetchPoint(q, 0, 0);
				List<IG380Info> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<IG380Info>) execute(action);
	}
	//====>��ܱ���Begin
	/**
	 * PDID����ֵȡ��
	 * @param pdid_one ģ���ʶ
	 * 
	 * @return PDID����ֵ
	 */
	
	public String getPdidSequenceNextValue(String firstsite,String pdsequence) {
		return StringUtils.leftPad(getSequenceNextValue(pdsequence) + "", IGPRDCONSTANTS.ID_PREFIX_LENGTH, firstsite)
				+ StringUtils.leftPad("1", IGPRDCONSTANTS.ID_VERSION_LENGTH, "0");
		
	}
	//====>��ܱ���End
	/**
	 * �����PDID����ֵȡ��
	 * 
	 * @return �����PDID����ֵ
	 */
	private static String getPdidUpgradeNextValue(String pdid) {
		return pdid.substring(0, IGPRDCONSTANTS.ID_PREFIX_LENGTH)
		+ StringUtils.leftPad(Integer.parseInt(pdid.substring(
				IGPRDCONSTANTS.ID_PREFIX_LENGTH, IGPRDCONSTANTS.ID_PREFIX_LENGTH + IGPRDCONSTANTS.ID_VERSION_LENGTH)) + 1 + "", 
				IGPRDCONSTANTS.ID_VERSION_LENGTH, "0");
	}
	
	/**
	 * ���̶������洦��
	 * 
	 * @param pdid ���̶���ID
	 */
//	public void upgradeProcessDefVersion(final String pdid) {
//		HibernateCallback action = new HibernateCallback() {
//			public Object doInHibernate(Session session)
//					throws HibernateException, SQLException {
//				session.flush();
//				SQLQuery q = session.createSQLQuery(
//						"{Call PRO_PROCESSDEFVERSION(?, ?, ?)}");
//
//				q.setString(0, pdid);
//				q.setString(1, getPdidUpgradeNextValue(pdid));
//				q.setString(2,"0");
//				Object o = q.executeUpdate();
//				session.clear();
//				return o; 
//			}
//		};
//		execute(action);
//	}
	
	public String upgradeProcessDefVersion(final String pdid) {
		HibernateCallback action = new HibernateCallback() {
			
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				String newPdid = getPdidUpgradeNextValue(pdid);
				SQLQuery q = session.createSQLQuery(
//						"SELECT PRO_PROCESSDEFVERSION(?, ?, ?)");
			//���ô洢����
						"{Call PRO_PROCESSDEFVERSION(?, ?, '0')}");
				q.setString(0, pdid);
				q.setString(1, newPdid);
//				q.setString(2,"0");
				q.executeUpdate();
				session.clear();
				return newPdid; 
			}
		};
		return (String) execute(action);
	}
	/**
	 * ���̶��帴�ƴ���
	 * 
	 * @param pdid ���̶���ID
	 * @param pdsequence ���ж���
	 */
//	public void copyProcessDefVersion(final String pdid,final String pdsequence) {
//		HibernateCallback action = new HibernateCallback() {
//			public Object doInHibernate(Session session)
//					throws HibernateException, SQLException {
//				session.flush();
//				
//				SQLQuery q = session.createSQLQuery(
//						"{Call PRO_PROCESSDEFVERSION(?, ?, ?)}");
//				q.setString(0, pdid);
//				q.setString(1, getPdidSequenceNextValue(new String(new char[]{pdid.charAt(0)}),pdsequence));
//				q.setString(2,"1");
//				Object o = q.executeUpdate();
//				session.clear();
//				return o; 
//			}
//		};
//		execute(action);
//	}
	
	public String copyProcessDefVersion(final String pdid,final String pdsequence) {
		nextPdid = getPdidSequenceNextValue(new String(new char[]{pdid.charAt(0)}),pdsequence);
		HibernateCallback action = new HibernateCallback() {
			
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				
				SQLQuery q = session.createSQLQuery(
"{CALL PRO_PROCESSDEFVERSION(?, ?, ?)}");
				q.setString(0, pdid);
				q.setString(1, nextPdid);
				q.setString(2,"1"); 
				int i = q.executeUpdate();
				session.clear();  
				return i; 
			}
		};
		execute(action);
		//�����ɵ�pdid 
		return nextPdid; 
	}
	
	public int getSearchLastCount(final IG380SearchCond cond) {
		HibernateCallback action = new HibernateCallback() {
			
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("IG380DAO.searchLastCount1").getQueryString()).append(" ");
				getSQL(cond,query);
				query.append(session.getNamedQuery("IG380DAO.searchLastCount3").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				session.clear();
				return getCount(q.list());
			}
		};
		return (Integer)execute(action);
	}
	
	/**
	 * ������ʷ���̶���汾��Ϣ
	 * @param cond ��������
	 * @return �������
	 */
	
	public int getSearchHistoryCount(final IG380SearchCond cond) {
		HibernateCallback action = new HibernateCallback() {
			
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("IG380DAO.searchHistoryCount1").getQueryString());
				getSQLHistory(cond,query);
				SQLQuery q = session.createSQLQuery(query.toString());
				session.clear();
				return getCount(q.list());
			}
		};
		return (Integer)execute(action);
	}
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected void getSQL(IG380SearchCond cond, StringBuffer query){
		if(cond.getPrTypeArray() != null && cond.getPrTypeArray().length > 0){
			StringBuffer queryBuf = new StringBuffer(" AND PTID IN (");
			for(int typeId : cond.getPrTypeArray()){
				queryBuf.append(typeId).append(",");
			}
			query.append(queryBuf.toString().substring(0, queryBuf.toString().length()-1)).append(") ");
		}
	}
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected void getSQLHistory(IG380SearchCond cond, StringBuffer query){
		if(cond.getPtid() != null && cond.getPtid() > 0){
			query.append(" and ptid = ");
			query.append(cond.getPtid());
			query.append(" ");
		}
		if(cond.getPrTypeArray() != null && cond.getPrTypeArray().length > 0){
			StringBuffer queryBuf = new StringBuffer(" AND PTID IN (");
			for(int typeId : cond.getPrTypeArray()){
				queryBuf.append(typeId).append(",");
			}
			query.append(queryBuf.toString().substring(0, queryBuf.toString().length()-1)).append(") ");
		}
		//ȡPDID��ǰ��λ
		if(StringUtils.isNotEmpty(cond.getPdid()) && cond.getPdid().length() == 7){
			query.append(" AND PDID LIKE '").append(cond.getPdid().substring(0,5)).append("%' AND PDID !='").append(cond.getPdid()).append("'");
		}
		if(StringUtils.isNotEmpty(cond.getPdstatus())){
			query.append(" AND PDSTATUS = '").append(cond.getPdstatus()).append("' ");
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public List<IG380Info> findLastByCond(
			final IG380SearchCond cond, final int start,
			final int count) {
		HibernateCallback action = new HibernateCallback() {
			
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("IG380DAO.searchLastCount2").getQueryString()).append(" ");
				getSQL(cond,query);
				query.append(session.getNamedQuery("IG380DAO.searchLastCount3").getQueryString());
				query.append(" ORDER BY PDID ");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity("pd",IG380TB.class);
				setFetchPoint(q, start, count);
				List<IG380Info> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<IG380Info>) execute(action);
	}
	
	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	
	@SuppressWarnings("unchecked")
	public List<IG380Info> findHistoryByCond(
			final IG380SearchCond cond, final int start,
			final int count) {
		HibernateCallback action = new HibernateCallback() {
			
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("IG380DAO.searchHistoryCount2").getQueryString());
				getSQLHistory(cond,query);
				query.append(" ORDER BY PDID ");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity("pd",IG380TB.class);
				setFetchPoint(q, start, count);
				List<IG380Info> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<IG380Info>) execute(action);
	}
	
	/**
	 * ���ܣ���������(��ά�ƻ���)
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	
	@SuppressWarnings("unchecked")
	public List<IG380Info> findSelfDefinitionAll(){
		HibernateCallback action = new HibernateCallback() {
			
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("IG380DAO.selfDefAllQuery").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity("pd",IG380TB.class);
				setFetchPoint(q, 0, 0);
				List<IG380Info> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<IG380Info>) execute(action);
	}
	
	/**
     * ��ѯ��ط�����Զ�������������Ϣ
     * 
     * @param cond��������
     * @return ��������б�
     */
    
	@SuppressWarnings("unchecked")
    public List<IG913Info> relevantProcessfindByCond(final IG913SearchCond cond) {
        HibernateCallback action = new HibernateCallback() {
            
			public Object doInHibernate(Session session)
                    throws HibernateException, SQLException {
                session.flush();
                StringBuffer query = new StringBuffer();
                query.append(session.getNamedQuery("IG380DAO.searchIG911").getQueryString());
                SQLQuery q = session.createSQLQuery(query.toString());
                q.setProperties(cond);
                q.addEntity("IG913VW", IG913VW.class);
                setFetchPoint(q, 0, 0);
                List<IG913Info> list = q.list();
                session.clear();
                return list;
            }
        };
        return (List<IG913Info>) execute(action);
    }
    
    /**
     * ��ѯȱʡȨ�޵���ط�����Զ�������������Ϣ
     * 
     * @param cond��������
     * @return ��������б�
     */
    
	@SuppressWarnings("unchecked")
    public List<IG913Info> relevantProcessfindByCondDefault(final IG913SearchCond cond) {
        HibernateCallback action = new HibernateCallback() {
            
			public Object doInHibernate(Session session)
                    throws HibernateException, SQLException {
                session.flush();
                StringBuffer query = new StringBuffer();
                query.append(session.getNamedQuery("IG380DAO.searchIG931").getQueryString());
                SQLQuery q = session.createSQLQuery(query.toString());
                q.setProperties(cond);
                q.addEntity("IG913VW", IG913VW.class);
                setFetchPoint(q, 0, 0);
                List<IG913Info> list = q.list();
                session.clear();
                return list;
            }
        };
        return (List<IG913Info>) execute(action);
    }
}
