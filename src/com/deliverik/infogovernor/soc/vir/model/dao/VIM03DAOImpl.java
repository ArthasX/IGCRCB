/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
  * 概述: 资源申请虚机信息表DAO实现
  * 功能描述: 资源申请虚机信息表DAO实现
  * 创建记录: 2014/02/13
  * 修改记录: 
  */
public class VIM03DAOImpl extends
		BaseHibernateDAOImpl<VIM03Info> implements VIM03DAO {

	/**
	 * 构造函数
	 */
	public VIM03DAOImpl(){
		super(VIM03TB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	@Override
	public List<VIM03Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	@Override
	public VIM03Info findByPK(Serializable pk) {
		VIM03Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final Vim03SearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<VIM03Info> findByCond(final Vim03SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(Vim03SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		// 虚拟化项目主键
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
	 * 查询一个季度内的资源申请数量
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
     * 检索条数取得
     *
     * @param cond 检索条件
     * @return 检索条数
     */
    public Integer  getVMCount4HostCountByCond(final Vim03SearchCond cond){
        HibernateCallback action = new HibernateCallback(){
            @SuppressWarnings("rawtypes")
            public Object doInHibernate(Session session)throws HibernateException, SQLException {
                session.flush();
                //获取query
                StringBuffer query = new StringBuffer();
                query.append( session.getNamedQuery("VIM03DAOImpl.VMCount4HostCount").getQueryString());
                //追加条件
                getSql(cond, query);
                //获取SQLQuery
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
     * 获取主机下虚机的个数
     *
     * @param cond 检索条件
     * @return 检索结果列表
     */
    @SuppressWarnings("unchecked")
    public List<Object[]> getVMCount4HostByCond(final Vim03SearchCond cond, final int start, final int count){
        HibernateCallback action = new HibernateCallback(){
            public Object doInHibernate(Session session)throws HibernateException, SQLException {
                session.flush();
                //获取query
                StringBuffer query = new StringBuffer();
                query.append( session.getNamedQuery("VIM03DAOImpl.VMCount4Host").getQueryString());
                //追加条件
                getSql(cond, query);
                //获取SQLQuery
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