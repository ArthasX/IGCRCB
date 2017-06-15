/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.cic.model.dao;

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
import com.deliverik.infogovernor.cic.model.CompareroleInfo;
import com.deliverik.infogovernor.cic.model.condition.CompareroleSearchCond;
import com.deliverik.infogovernor.cic.model.entity.CompareroleTB;

/**
  * ����: �Աȹ���DAOʵ��
  * ��������: �Աȹ���DAOʵ��
  * ������¼: 2014/04/22
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class CompareroleDAOImpl extends
		BaseHibernateDAOImpl<CompareroleInfo> implements CompareroleDAO {

	/**
	 * ���캯��
	 */
	public CompareroleDAOImpl(){
		super(CompareroleTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	@Override
	public List<CompareroleInfo> findAll() {
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
	public CompareroleInfo findByPK(Serializable pk) {
		CompareroleInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final CompareroleSearchCond cond){
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
	public List<CompareroleInfo> findByCond(final CompareroleSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(CompareroleSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getCrtype())){
			c.add(Expression.eq("crtype", cond.getCrtype()));
		}
		if(cond.getCrsystemid()!=null&& cond.getCrsystemid()>1){
			c.add(Expression.eq("crsystemid", cond.getCrsystemid()));
		}
		
		return c;
	}

	
	/**
     * ���ݹ�ϵ���ѯ���򼰶���
     * 
     * @param cond ��������
     * @param version �汾
     * @return ��������б�
     */
    @SuppressWarnings("unchecked")
    public List<CompareroleInfo> searchCompareroleByRelation(final CompareroleSearchCond cond) {
        HibernateCallback action = new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                session.flush();
                StringBuffer query = new StringBuffer();
                
                query.append(session.getNamedQuery("CompareroleDAO.searchComparerolebyRelation").getQueryString());
                // ƴ�Ӳ�ѯ����
                getSql(query, cond);
                SQLQuery q = session.createSQLQuery(query.toString());
                
                q.setProperties(cond);
                q.addEntity("t3",CompareroleTB.class);
                
                setFetchPoint(q, 0, 0);
                List<CompareroleInfo> list = q.list();
                session.clear();
                session.close();
                return list;
            }
        };
        return (List<CompareroleInfo>) execute(action);
    }
    
    //  ��ѯ����
    private void getSql(StringBuffer query, CompareroleSearchCond cond){
        
        if (cond.getCpid() != null) {
            query.append(" and t3.cpid = :cpid ");
           
        }
    }
}