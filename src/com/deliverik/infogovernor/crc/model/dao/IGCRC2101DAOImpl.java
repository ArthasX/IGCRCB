/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.crc.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.crc.model.IGCRC2101VWInfo;
import com.deliverik.infogovernor.crc.model.IGCRC2102VWInfo;
import com.deliverik.infogovernor.crc.model.condition.IGCRC2101Cond;
import com.deliverik.infogovernor.crc.model.entity.IGCRC2101VW;
import com.deliverik.infogovernor.crc.model.entity.IGCRC2102VW;
/**
 * 概述: 人员工作统计视图DAO实现 
 * 功能描述: 人员工作统计视图DAO实现 
 * 创建记录: yukexin 2014-8-8 13:43:46
 * 修改记录:
 */
public class IGCRC2101DAOImpl extends BaseHibernateDAOImpl<IGCRC2101VWInfo> implements IGCRC2101DAO{

	
	/**
	 * 构造函数
	 */
	public IGCRC2101DAOImpl() {
		super(IGCRC2101VW.class);
	}

	/**
     * 根据对象比对结果
     * 
     * @param cond 检索条件
     * @param version 版本
     * @return 检索结果列表
     */
	@SuppressWarnings("unchecked")
	public List<IGCRC2101VWInfo> searchIGCRC2101VWInfo(final IGCRC2101Cond cond, final int start,
			final int count) {
		 HibernateCallback action = new HibernateCallback() {
	            public Object doInHibernate(Session session) throws HibernateException, SQLException {
	                session.flush();
	                StringBuffer query = new StringBuffer();
	                query.append(session.getNamedQuery("EntityItemIGCRC2101VWDAO.entityItemIGCRC2101VWDAO").getQueryString());
	                // 拼接查询条件
	                getSql(query, cond);
	                query.append(" order by userid desc");
	                SQLQuery q = session.createSQLQuery(query.toString());
	                if(cond.getPropentime() != null){
						q.setString("propentime", cond.getPropentime());
					}
	                q.setProperties(cond);
	                q.addEntity("t",IGCRC2101VW.class);
	                setFetchPoint(q, start , count);
	                List<IGCRC2101VWInfo> list = q.list();
	                session.clear();
	                session.close();
	                return list;
	            }
	        };
	        return (List<IGCRC2101VWInfo>) execute(action);
	}
	
	/**
     * 根据对象比对结果
     * @param cond 检索条件
     * @return 检索结果列表
     */
	@SuppressWarnings("unchecked")
	public List<IGCRC2101VWInfo> searchIGCRC2101VWInfo(final IGCRC2101Cond cond) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery(
						"EntityItemIGCRC2101VWDAO.entityItemIGCRC2101VWDAO")
						.getQueryString());
				// 拼接查询条件
				getSql(query, cond);
				query.append(" group by userName,ppuserid");
				SQLQuery q = session.createSQLQuery(query.toString());
				if(cond.getPropentime() != null){
					q.setString("propentime", cond.getPropentime());
				}
				q.setProperties(cond);
				q.addEntity("t", IGCRC2101VW.class);
				List<IGCRC2101VWInfo> list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<IGCRC2101VWInfo>) execute(action);
	}

	
	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
    private void getSql(StringBuffer query, IGCRC2101Cond cond){
    	//年月
		query.append(" and a.ppproctime is not null and a.propentime like '"
				+ (cond.getYear() == null || "".equals(cond.getYear()) ? "%"
						: cond.getYear())
				+ "/"
				+ (cond.getMonth() == null || "".equals(cond.getMonth()) ? ""
						: "" + cond.getMonth()) + "%'");
        //部门
        if(StringUtils.isNotEmpty(cond.getDepartment())){
        	query.append(" and  ppuserid in (select userid from userrolevw where orgid = '" + cond.getDepartment() + "')");
        }else{
        	query.append(" and 1=2");
        }
    }

	/**	
	 * 功能：查询部门下拉列表
	 * @return 部门下拉列表
	 * 修改记录：null
	 */	
	@SuppressWarnings("unchecked")
	public List<IGCRC2102VWInfo> searchDepartmentBeanList() {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery(
						"EntityItemIGCRC2101VWDAO.searchDepartmentBeanList")
						.getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity("t", IGCRC2102VW.class);
				List<IGCRC2102VWInfo> list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<IGCRC2102VWInfo>) execute(action);
	}
}
