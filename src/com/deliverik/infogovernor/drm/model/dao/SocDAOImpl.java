/**
 * 
 */
package com.deliverik.infogovernor.drm.model.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * @author Administrator
 *
 */
public class SocDAOImpl  extends HibernateDaoSupport implements SocDAO{
	/**
	 * 通过prid查询场景的定义ID
	 */
	@SuppressWarnings("unchecked")
	public String searchFlowPidid(Integer prid) {
		String pidid = "";
		Session session = getSession();
		StringBuffer sql =new StringBuffer( "select civalue from soc0107 where eiid = (select eiid from ig731 where piid = (select piid from ig599 where pivarname = '应急场景' and ");
		sql.append(" prid = "+prid+" )) and cid = 'CI600000001004'");
		SQLQuery q = session.createSQLQuery(sql.toString());
		List<String> list =q.list();
		if(list!=null && list.size()>0){
			pidid = list.get(0).toString();
		}
		return pidid;
	}

	
	

}
