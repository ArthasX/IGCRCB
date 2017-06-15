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

import com.csebank.lom.model.GoutDetailInfo;
import com.csebank.lom.model.condition.GoutDetailSearchCond;
import com.csebank.lom.model.entity.GoutDetailTB;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
 * 模块：后勤管理-食堂管理
 * 说明：食堂物品消耗明细DAO实现
 * 作者：唐晓娜
 */
public class GoutDetailInfoDAOImpl extends BaseHibernateDAOImpl<GoutDetailInfo> implements GoutDetailInfoDAO {

	/**
	 * 构造函数
	 */
	public GoutDetailInfoDAOImpl(){
		super(GoutDetailTB.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<GoutDetailInfo> findByCond(final GoutDetailSearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback()
		{  
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				List<GoutDetailInfo> list =null;
				
				query.append(session.getNamedQuery("GoutDetailInfoDAO.getGoutDetailInfo").getQueryString());
				getSQL(cond, query);
				query.append("  )AS GOUTDETAILINFO");
				
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("GOUTDETAILINFO",GoutDetailTB.class);
				setFetchPoint(q, start, count);
				list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<GoutDetailInfo>) execute(action);
	}
	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected void getSQL(GoutDetailSearchCond cond, StringBuffer query){
		//领用者
		if( StringUtils.isNotEmpty(cond.getGuser()) ){
			query.append(" AND gg. gorequsername like '%"+cond.getGuser()+ "%'");
		}
		//消耗类型
		if( StringUtils.isNotEmpty(cond.getUseType()) ){
			//普通消耗
			if(cond.getUseType().equals("1")){
				query.append(" AND GG.RID='0'");
			}
			//招待消耗
			if(cond.getUseType().equals("2")){
				query.append(" AND GG.RID!='0'");
			}
			
		}
	}
	

}
