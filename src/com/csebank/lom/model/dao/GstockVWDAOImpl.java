/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.csebank.lom.bl.IGLOMCONSTANTS;
import com.csebank.lom.model.GstockVWInfo;
import com.csebank.lom.model.condition.GstockVWSearchCond;
import com.csebank.lom.model.entity.GstockVW;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
 * 
 * 库存预警信息视图DAO实现
 *
 */
public class GstockVWDAOImpl extends BaseHibernateDAOImpl<GstockVWInfo> implements GstockVWDAO {

	/**
	 * 构造函数
	 */
	public GstockVWDAOImpl(){
		super(GstockVW.class);
	}


	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<GstockVWInfo> findByCond(final GstockVWSearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();			
				query.append(session.getNamedQuery("GstockVWDAO.ig0213action").getQueryString());
				getSQL(cond, query,"0");			
				//query.append(" ) WHERE 1=1 ");
				
				//组成where条件
				getSQL(cond, query,"1");				
				query.append(" ) as gstock ORDER BY gid");
				
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("gstock",GstockVW.class);
				setFetchPoint(q, start, count);
				List<GstockVWInfo> list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<GstockVWInfo>) execute(action);
	}
	
	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected void getSQL(GstockVWSearchCond cond, StringBuffer query,String type){
		
		//所属机构
		if(StringUtils.isNotEmpty(cond.getGsorg()) && "1".equals(type)){
			query.append("  and B.gsorg=:gsorg  ");
		}
		
		//已预警查询
		if(StringUtils.isNotEmpty(cond.getWarntype()) && IGLOMCONSTANTS.WARN_TYPE_YYJ.equals(cond.getWarntype()) && "0".equals(type)){
			query.append("  and B.GSNUM < A.GWARNINGNUM  ");
			
		}
		
		//临界预警查询
		if(StringUtils.isNotEmpty(cond.getWarntype()) && IGLOMCONSTANTS.WARN_TYPE_LJYJ.equals(cond.getWarntype()) && "0".equals(type)){
			if(cond!=null){
				if(cond.getWarnnum()!=null){
					query.append("  and B.GSNUM <:warnnum ");
				}
			}
		}
		
	}

}
