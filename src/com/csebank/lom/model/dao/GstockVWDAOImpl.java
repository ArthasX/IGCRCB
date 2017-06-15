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

import com.csebank.lom.bl.IGLOMCONSTANTS;
import com.csebank.lom.model.GstockVWInfo;
import com.csebank.lom.model.condition.GstockVWSearchCond;
import com.csebank.lom.model.entity.GstockVW;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
 * 
 * ���Ԥ����Ϣ��ͼDAOʵ��
 *
 */
public class GstockVWDAOImpl extends BaseHibernateDAOImpl<GstockVWInfo> implements GstockVWDAO {

	/**
	 * ���캯��
	 */
	public GstockVWDAOImpl(){
		super(GstockVW.class);
	}


	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
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
				
				//���where����
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
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected void getSQL(GstockVWSearchCond cond, StringBuffer query,String type){
		
		//��������
		if(StringUtils.isNotEmpty(cond.getGsorg()) && "1".equals(type)){
			query.append("  and B.gsorg=:gsorg  ");
		}
		
		//��Ԥ����ѯ
		if(StringUtils.isNotEmpty(cond.getWarntype()) && IGLOMCONSTANTS.WARN_TYPE_YYJ.equals(cond.getWarntype()) && "0".equals(type)){
			query.append("  and B.GSNUM < A.GWARNINGNUM  ");
			
		}
		
		//�ٽ�Ԥ����ѯ
		if(StringUtils.isNotEmpty(cond.getWarntype()) && IGLOMCONSTANTS.WARN_TYPE_LJYJ.equals(cond.getWarntype()) && "0".equals(type)){
			if(cond!=null){
				if(cond.getWarnnum()!=null){
					query.append("  and B.GSNUM <:warnnum ");
				}
			}
		}
		
	}

}
