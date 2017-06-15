/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.vir.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.soc.vir.model.VIM03CountByProjVWInfo;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM03CountByProjVWSearchCond;
import com.deliverik.infogovernor.soc.vir.model.entity.VIM03CountByProjVW;
/**
 * ���⻯ͳ�Ʒ���
 *
 */
public class VIM03CountByProjVWDAOImpl extends BaseHibernateDAOImpl<VIM03CountByProjVWInfo>
		implements VIM03CountByProjVWDAO {

	public VIM03CountByProjVWDAOImpl(){
		super(VIM03CountByProjVW.class);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	@SuppressWarnings("unchecked")
	public List<VIM03CountByProjVWInfo> findByCond(final VIM03CountByProjVWSearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback(){
			public Object doInHibernate(Session session)throws HibernateException, SQLException {
				session.flush();
				//��ȡquery
				StringBuffer query = new StringBuffer();
				query.append( session.getNamedQuery("COUNT_PROJ_VIM03VWDAO.findByCond").getQueryString());
				//׷������
				getSql(cond, query);
				//��ȡSQLQuery
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity("VIM03CountByProjVW",VIM03CountByProjVW.class);
				setFetchPoint(q, start, count);
				List<VIM03CountByProjVWInfo> list=q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<VIM03CountByProjVWInfo>)execute(action);
	}
	
	/**
	 * ��ѯ����
	 * */	
	protected void getSql(VIM03CountByProjVWSearchCond cond,StringBuffer query){
		//������
		if(StringUtils.isNotEmpty(cond.getPname_like())){
			query.append("and pname like '%"+cond.getPname_like()+"%'");
		}
	}
}
