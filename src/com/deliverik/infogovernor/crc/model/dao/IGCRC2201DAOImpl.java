/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.crc.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.crc.model.IGCRC2201VWInfo;
import com.deliverik.infogovernor.crc.model.condition.IGCRC2201Cond;
import com.deliverik.infogovernor.crc.model.entity.IGCRC2201VW;

/**	
 * 概述:变更总体统计Dao接口实现	
 * 创建记录：yukexin    2014-8-15 下午5:18:16	
 * 修改记录：null
 */	
public class IGCRC2201DAOImpl extends BaseHibernateDAOImpl<IGCRC2201VWInfo> implements IGCRC2201DAO {

	/**
	 * 构造方法
	 */
	public IGCRC2201DAOImpl() {
		super(IGCRC2201DAOImpl.class);
	}

	/**
	 * 变更总体统计检索
	 * 
	 * @param cond
	 * @return List<ChangeTreadVWInfo>
	 */
	@SuppressWarnings("unchecked")
	public List<IGCRC2201VWInfo> searchChangeTreadVW(final IGCRC2201Cond cond) {
		
		HibernateCallback action = new HibernateCallback() {
			
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				
				query.append(session.getNamedQuery("EntityItemIGCRC2201VWDAO.entityItemIGCRC2201VWDAO").getQueryString());
				// 拼接查询条件
                getSql(query, cond);
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity(IGCRC2201VW.class);
				List<IGCRC2201VW> list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<IGCRC2201VWInfo>) execute(action);
	}
	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
    private void getSql(StringBuffer query, IGCRC2201Cond cond){
    	//年月
		query.append(" and pr.prclosetime like '"
				+ (cond.getYear() == null || "".equals(cond.getYear()) ? "%"
						: cond.getYear())
				+ "/"
				+ (cond.getMonth() == null || "".equals(cond.getMonth()) ? ""
						: "" + cond.getMonth()) + "%'");
		
		query.append(" group by cvalue,syscoding");
    }
}
