/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
import com.deliverik.infogovernor.crc.model.IGCRC1301VWInfo;
import com.deliverik.infogovernor.crc.model.condition.IGCRC1301Cond;
import com.deliverik.infogovernor.crc.model.entity.IGCRC1301VW;

/**
 * 概述: 文档查询视图DAO实现 
 * 功能描述: 文档查询视图DAO实现 
 * 创建记录: 2014/07/15 
 * 修改记录:
 */
public class IGCRC1301DAOImpl extends BaseHibernateDAOImpl<IGCRC1301VWInfo>
		implements IGCRC1301DAO {

	/**
	 * 构造函数
	 */
	public IGCRC1301DAOImpl() {
		super(IGCRC1301VW.class);
	}

	/**
     * 根据对象比对结果
     * 
     * @param cond 检索条件
     * @param version 版本
     * @return 检索结果列表
     */
	@SuppressWarnings("unchecked")
	public List<IGCRC1301VWInfo> searchIGCRC1301VWInfo(final IGCRC1301Cond cond, final int start,
			final int count) {
		 HibernateCallback action = new HibernateCallback() {
	            public Object doInHibernate(Session session) throws HibernateException, SQLException {
	                session.flush();
	                StringBuffer query = new StringBuffer();
	                query.append(session.getNamedQuery("EntityItemIGCRC1301VWDAO.entityItemIGCRC1301VWDAO").getQueryString());
	                // 拼接查询条件
	                getSql(query, cond);
	                query.append(" order by t.eiid desc");
	                SQLQuery q = session.createSQLQuery(query.toString());
	                q.setProperties(cond);
	                q.addEntity("t",IGCRC1301VW.class);
	                setFetchPoint(q, start , count);
	                List<IGCRC1301VWInfo> list = q.list();
	                session.clear();
	                session.close();
	                return list;
	            }
	        };
	        return (List<IGCRC1301VWInfo>) execute(action);
	}

	
	@SuppressWarnings("unchecked")
	public List<IGCRC1301VWInfo> searchIGCRC1302VWInfo(final IGCRC1301Cond cond, final int start,
			final int count) {
		 HibernateCallback action = new HibernateCallback() {
	            public Object doInHibernate(Session session) throws HibernateException, SQLException {
	                session.flush();
	                StringBuffer query = new StringBuffer();
	                query.append(session.getNamedQuery("EntityItemIGCRC1303VWDAO.entityItemIGCRC1303VWDAO").getQueryString());
	                // 拼接查询条件
	                getSql(query, cond);
	                query.append(" order by t.eiid desc");
	                SQLQuery q = session.createSQLQuery(query.toString());
	                q.setProperties(cond);
	                q.addEntity("t",IGCRC1301VW.class);
	                setFetchPoint(q, start , count);
	                List<IGCRC1301VWInfo> list = q.list();
	                session.clear();
	                session.close();
	                return list;
	            }
	        };
	        return (List<IGCRC1301VWInfo>) execute(action);
	}
	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IGCRC1301Cond cond) {
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
				
				query.append( session.getNamedQuery("EntityItemIGCRC1301VWDAO.getSearchCount").getQueryString());
				
				// 拼接查询条件
                getSql(query, cond);
				
				SQLQuery q = session.createSQLQuery(query.toString());

				q.setProperties(cond);

				session.clear();
				session.close();
				return getCount(q.list());
			}
		};
		return (Integer) execute(action);
	}
	
	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
    private void getSql(StringBuffer query, IGCRC1301Cond cond){
    	//文档编号
        if(StringUtils.isNotEmpty(cond.getEiNumber())){
        	query.append(" and t.eiNumber like '%"+cond.getEiNumber()+"%'");
        }
        //文档名称
        if(StringUtils.isNotEmpty(cond.getEiName())){
        	query.append(" and t.eiName like '%"+cond.getEiName()+"%'");
        }
        //文档类型
        if(StringUtils.isNotEmpty(cond.getEiType())){
        	query.append(" and t.eiType = '"+cond.getEiType()+"'");
        }
        //文档分类
        if(StringUtils.isNotEmpty(cond.getEiSort())){
        	query.append(" and t.eiSort like '%"+cond.getEiSort()+"'");
        }
        //文档密级
        if(StringUtils.isNotEmpty(cond.getEiDense())){
        	query.append(" and t.eiDense = '"+cond.getEiDense()+"'");
        }
        //部门
        if(StringUtils.isNotEmpty(cond.getDepartment())){
        	query.append(" and t.department like '%"+cond.getDepartment()+"%'");
        }
        //管理人
        /*if(StringUtils.isNotEmpty(cond.getEiName())){
        	query.append(" and EINAME = '"+cond.getEiName()+"'");
        }*/
        //内容
        if(StringUtils.isNotEmpty(cond.getContent())){
        	query.append(" and t.content like '%"+cond.getContent()+"%'");
        }
        //是否可下载
        if(StringUtils.isNotEmpty(cond.getIsDownload())){
        	query.append(" and t.isDownload = '"+cond.getIsDownload()+"'");
        }
    }
}
