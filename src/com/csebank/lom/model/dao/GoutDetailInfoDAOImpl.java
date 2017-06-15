/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
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
 * ģ�飺���ڹ���-ʳ�ù���
 * ˵����ʳ����Ʒ������ϸDAOʵ��
 * ���ߣ�������
 */
public class GoutDetailInfoDAOImpl extends BaseHibernateDAOImpl<GoutDetailInfo> implements GoutDetailInfoDAO {

	/**
	 * ���캯��
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
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected void getSQL(GoutDetailSearchCond cond, StringBuffer query){
		//������
		if( StringUtils.isNotEmpty(cond.getGuser()) ){
			query.append(" AND gg. gorequsername like '%"+cond.getGuser()+ "%'");
		}
		//��������
		if( StringUtils.isNotEmpty(cond.getUseType()) ){
			//��ͨ����
			if(cond.getUseType().equals("1")){
				query.append(" AND GG.RID='0'");
			}
			//�д�����
			if(cond.getUseType().equals("2")){
				query.append(" AND GG.RID!='0'");
			}
			
		}
	}
	

}
