/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.soc.vir.model.VIM03CountByUserVWInfo;
import com.deliverik.infogovernor.soc.vir.model.VIM03Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM03CountByUserVWSearchCond;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM03CountVWSearchCond;
import com.deliverik.infogovernor.soc.vir.model.condition.Vim03SearchCond;
import com.deliverik.infogovernor.soc.vir.model.entity.VIM03CountByUserVW;
import com.deliverik.infogovernor.soc.vir.model.entity.VIM03TB;

/**
  * ����: ��Դ���������Ϣ��DAOʵ��
  * ��������: ��Դ���������Ϣ��DAOʵ��
  * ������¼: 2014/02/13
  * �޸ļ�¼: 
  */
public class VIM03DAOImpl extends
		BaseHibernateDAOImpl<VIM03Info> implements VIM03DAO {

	/**
	 * ���캯��
	 */
	public VIM03DAOImpl(){
		super(VIM03TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	@Override
	public List<VIM03Info> findAll() {
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
	public VIM03Info findByPK(Serializable pk) {
		VIM03Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final Vim03SearchCond cond){
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
	public List<VIM03Info> findByCond(final Vim03SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(Vim03SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		// ���⻯��Ŀ����
		if (null != cond.getPid_eq()) {
		    c.add(Restrictions.eq("pid", cond.getPid_eq()));
		}
		if(StringUtils.isNotEmpty(cond.getUserid_eq())){
			c.add(Restrictions.eq("userid", cond.getUserid_eq()));
		}
		if(StringUtils.isNotEmpty(cond.getOrgsyscoding_eq())){
			c.add(Restrictions.eq("orgsyscoding", cond.getOrgsyscoding_eq()));
		}
		if(StringUtils.isNotEmpty(cond.getProgress_eq())){
			c.add(Restrictions.eq("progress",cond.getProgress_eq()));
		}
		if (cond.isProgressIsNull()) {
		    c.add(Restrictions.sqlRestriction(" ( progress is null or progress = '' )"));
		}
		
		if (null != cond.getPrid()) {
		    c.add(Restrictions.eq("prid", cond.getPrid()));
		}
		if(StringUtils.isNotEmpty(cond.getStatus())){
			c.add(Restrictions.eq("status", cond.getStatus()));
		}
		if(cond.getVcid() != null && cond.getVcid() > 0){
			c.add(Restrictions.eq("vcid", cond.getVcid()));
		}
		if(StringUtils.isNotEmpty(cond.getHostname())){
			c.add(Restrictions.eq("hostName", cond.getHostname()));
		}
		if(StringUtils.isNotEmpty(cond.getStatus_nq())){
			c.add(Restrictions.ne("status", cond.getStatus_nq()));
		}
		if(cond.getPrid_in() != null && cond.getPrid_in().size() > 0){
			c.add(Restrictions.in("prid", cond.getPrid_in()));
		}
		if(StringUtils.isNotEmpty(cond.getVmName())){
			c.add(Restrictions.eq("vmName", cond.getVmName()));
		}
		return c;
	}
	
	@SuppressWarnings("unchecked")
	public List<Object[]> getOrgCountByMonth(String sDate){
		String sql ="select orgname,orgsyscoding,count(*),to_char(to_date(applytime,'YYYY/MM/DD'),'YYYYMM')as mm " +
					"from vim03 where progress = '100' and  applytime >= :sDate " +
					"group by orgname,orgsyscoding,to_char(to_date(applytime,'YYYY/MM/DD'),'YYYYMM') " +
					"order by orgname,mm";
		SQLQuery q = getSession().createSQLQuery(sql);
		
		q.setParameter("sDate", sDate);
		
		List<Object[]> result = q.list();
		
		return result;
		
	}
	
	/**
	 * ��ѯһ�������ڵ���Դ��������
	 * 
	 * @param sDate
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Object[]> getOrgCount(String sDate){
	    String sql ="select count(*),to_char(to_date(applytime,'YYYY/MM/DD'),'YYYYMM')as mm " +
	            "from vim03 where progress = '100' and  applytime >= :sDate " +
	            "group by to_char(to_date(applytime,'YYYY/MM/DD'),'YYYYMM') " +
	            "order by mm";
	    SQLQuery q = getSession().createSQLQuery(sql);
	    
	    q.setParameter("sDate", sDate);
	    
	    List<Object[]> result = q.list();
	    
	    return result;
	    
	}
	
	/**
     * ��������ȡ��
     *
     * @param cond ��������
     * @return ��������
     */
    public Integer  getVMCount4HostCountByCond(final Vim03SearchCond cond){
        HibernateCallback action = new HibernateCallback(){
            @SuppressWarnings("rawtypes")
            public Object doInHibernate(Session session)throws HibernateException, SQLException {
                session.flush();
                //��ȡquery
                StringBuffer query = new StringBuffer();
                query.append( session.getNamedQuery("VIM03DAOImpl.VMCount4HostCount").getQueryString());
                //׷������
                getSql(cond, query);
                //��ȡSQLQuery
                SQLQuery q = session.createSQLQuery(query.toString());
                List list = q.list();
                session.clear();
                session.close();
                return getCount(list);
            }
            
        };
        return (Integer) execute(action);
    }

	/**
     * ��ȡ����������ĸ���
     *
     * @param cond ��������
     * @return ��������б�
     */
    @SuppressWarnings("unchecked")
    public List<Object[]> getVMCount4HostByCond(final Vim03SearchCond cond, final int start, final int count){
        HibernateCallback action = new HibernateCallback(){
            public Object doInHibernate(Session session)throws HibernateException, SQLException {
                session.flush();
                //��ȡquery
                StringBuffer query = new StringBuffer();
                query.append( session.getNamedQuery("VIM03DAOImpl.VMCount4Host").getQueryString());
                //׷������
                getSql(cond, query);
                //��ȡSQLQuery
                SQLQuery q = session.createSQLQuery(query.toString());
                setFetchPoint(q, start, count);
                List<Object[]> list = q.list();
                session.clear();
                session.close();
                return list;
            }
            
        };
        return (List<Object[]>)execute(action);
    }
    
    private void getSql(Vim03SearchCond cond,  StringBuffer query){
        
    }
}