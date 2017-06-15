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
import org.hibernate.criterion.Expression;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.IG911Info;
import com.deliverik.framework.workflow.prd.model.condition.IG911SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG380TB;
import com.deliverik.framework.workflow.prd.model.entity.IG911TB;

/**
  * ����: ״̬�����߹����������Ͷ����DAOʵ��
  * ��������: ״̬�����߹����������Ͷ����DAOʵ��
  * ������¼: 2012/10/18
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class IG911DAOImpl extends
		BaseHibernateDAOImpl<IG911Info> implements IG911DAO {

	/**
	 * ���캯��
	 */
	public IG911DAOImpl(){
		super(IG911TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG911Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG911Info findByPK(Serializable pk) {
		IG911Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG911SearchCond cond){
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
	public List<IG911Info> findByCond(final IG911SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(IG911SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getPdid())){
            c.add(Expression.eq("pdid", cond.getPdid()));
        }
		if(StringUtils.isNotEmpty(cond.getPsdid())){
            c.add(Expression.eq("psdid", cond.getPsdid()));
        }
		if( cond.getRoleid() != null && cond.getRoleid() != 0){
            c.add(Expression.eq("roleid", cond.getRoleid()));
        }
		return c;
	}

	 /**
     * psprpid����ֵȡ��
     * 
     * @param ����״̬ID
     * @return psprpid����ֵ
     */
    @SuppressWarnings("rawtypes")
	public String getPsprpidSequenceNextValue(String psdid) {
        String sql =  "SELECT MAX(ppd.psprpid) FROM IG911TB ppd WHERE ppd.psprpid LIKE :psdid";
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
     * ��ط�������״̬Ϊ����״̬��״̬��������ط�����Ϣȡ��
     * 
     * @param cond��������
     * @return ��������б�
     */
    @SuppressWarnings("unchecked")
    public List<IG911Info> getIg911RelevantPdidfindByCond(final IG911SearchCond cond) {
        HibernateCallback action = new HibernateCallback() {
            public Object doInHibernate(Session session)
            throws HibernateException, SQLException {
                session.flush();
                StringBuffer query = new StringBuffer();
                query.append(session.getNamedQuery("IG911DAO.searchIG911RelevantPdid").getQueryString());
                SQLQuery q = session.createSQLQuery(query.toString());
                q.setProperties(cond);
                q.addEntity("IG911TB", IG911TB.class);
                setFetchPoint(q, 0, 0);
                List<IG911Info> list = q.list();
                session.clear();
                return list;
            }
        };
        return (List<IG911Info>) execute(action);
    }
    
    /**
     * ��ط�������״̬Ϊ����״̬��״̬��������ط�����Ϣ����ȡ��
     * @param cond ��������
     * @return �������
     */
    public int getIg911RelevantPdidCount(final IG911SearchCond cond) {
        HibernateCallback action = new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                session.flush();
                StringBuffer query = new StringBuffer();
                query.append(session.getNamedQuery("IG911DAO.countIG911RelevantPdid").getQueryString());
                SQLQuery q = session.createSQLQuery(query.toString());
                q.setProperties(cond);
                session.clear();
                return getCount(q.list());
            }
        };
        return (Integer)execute(action);
    }
    
    /**
     * ��ط���ɷ������̵����̶�����Ϣȡ�ã�����IG911����ȡ��IG380����Ϣ��
     * 
     * @param cond��������
     * @return ��������б�
     */
    @SuppressWarnings("unchecked")
    public List<IG380Info> getIg380InfoByIg911Cond(final IG911SearchCond cond) {
        HibernateCallback action = new HibernateCallback() {
            public Object doInHibernate(Session session)
            throws HibernateException, SQLException {
                session.flush();
                StringBuffer query = new StringBuffer();
                query.append(session.getNamedQuery("IG911DAO.searchIG380Info").getQueryString());
                SQLQuery q = session.createSQLQuery(query.toString());
                q.setProperties(cond);
                q.addEntity("IG380TB", IG380TB.class);
                setFetchPoint(q, 0, 0);
                List<IG380Info> list = q.list();
                session.clear();
                return list;
            }
        };
        return (List<IG380Info>) execute(action);
    }
}