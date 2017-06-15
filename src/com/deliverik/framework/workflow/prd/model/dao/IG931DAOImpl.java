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
import com.deliverik.framework.workflow.prd.model.IG931Info;
import com.deliverik.framework.workflow.prd.model.condition.IG931SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG380TB;
import com.deliverik.framework.workflow.prd.model.entity.IG931TB;

/**
  * ����: ȱʡ״̬�����߹����������Ͷ����DAOʵ��
  * ��������: ȱʡ״̬�����߹����������Ͷ����DAOʵ��
  * ������¼: 2012/10/18
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class IG931DAOImpl extends
		BaseHibernateDAOImpl<IG931Info> implements IG931DAO {

	/**
	 * ���캯��
	 */
	public IG931DAOImpl(){
		super(IG931TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG931Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG931Info findByPK(Serializable pk) {
		IG931Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG931SearchCond cond){
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
	public List<IG931Info> findByCond(final IG931SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(IG931SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getPdid())){
            c.add(Expression.eq("pdid", cond.getPdid()));
        }
        if(StringUtils.isNotEmpty(cond.getPsdid())){
            c.add(Expression.eq("psdid", cond.getPsdid()));
        }
		return c;
	}
	/**
     * dpsprpid����ֵȡ��
     * 
     * @param ����״̬ID
     * @return psprpid����ֵ
     */
    @SuppressWarnings("rawtypes")
	public String getDpsprpidSequenceNextValue(String psdid) {
        String sql =  "SELECT MAX(ppd.dpsprpid) FROM IG931TB ppd WHERE ppd.dpsprpid LIKE :psdid";
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
     * ��ط�������״̬Ϊ����״̬��Ĭ��Ȩ�޵���ط�����Ϣȡ��
     * 
     * @param cond��������
     * @return ��������б�
     */
    @SuppressWarnings("unchecked")
    public List<IG931Info> getIg931RelevantPdidfindByCond(final IG931SearchCond cond) {
        HibernateCallback action = new HibernateCallback() {
            public Object doInHibernate(Session session)
            throws HibernateException, SQLException {
                session.flush();
                StringBuffer query = new StringBuffer();
                query.append(session.getNamedQuery("IG931DAO.searchIG931RelevantPdid").getQueryString());
                SQLQuery q = session.createSQLQuery(query.toString());
                q.setProperties(cond);
                q.addEntity("IG931TB", IG931TB.class);
                setFetchPoint(q, 0, 0);
                List<IG931Info> list = q.list();
                session.clear();
                return list;
            }
        };
        return (List<IG931Info>) execute(action);
    }
    
    /**
     * ��ط���ɷ������̵����̶�����Ϣȡ�ã�����IG931����ȡ��IG380����Ϣ��
     * 
     * @param cond��������
     * @return ��������б�
     */
    @SuppressWarnings("unchecked")
    public List<IG380Info> getIg380InfoByIg931Cond(final IG931SearchCond cond) {
        HibernateCallback action = new HibernateCallback() {
            public Object doInHibernate(Session session)
            throws HibernateException, SQLException {
                session.flush();
                StringBuffer query = new StringBuffer();
                query.append(session.getNamedQuery("IG931DAO.searchIG380Info").getQueryString());
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
    
    /**
     * ��ط�������״̬Ϊ����״̬��Ĭ��Ȩ�޵���ط�����Ϣ����ȡ��
     * @param cond ��������
     * @return �������
     */
    public int getIg931RelevantPdidCount(final IG931SearchCond cond) {
        HibernateCallback action = new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                session.flush();
                StringBuffer query = new StringBuffer();
                query.append(session.getNamedQuery("IG931DAO.countIG931RelevantPdid").getQueryString());
                SQLQuery q = session.createSQLQuery(query.toString());
                q.setProperties(cond);
                session.clear();
                return getCount(q.list());
            }
        };
        return (Integer)execute(action);
    }
}