/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * ����: �ĵ���ѯ��ͼDAOʵ�� 
 * ��������: �ĵ���ѯ��ͼDAOʵ�� 
 * ������¼: 2014/07/15 
 * �޸ļ�¼:
 */
public class IGCRC1301DAOImpl extends BaseHibernateDAOImpl<IGCRC1301VWInfo>
		implements IGCRC1301DAO {

	/**
	 * ���캯��
	 */
	public IGCRC1301DAOImpl() {
		super(IGCRC1301VW.class);
	}

	/**
     * ���ݶ���ȶԽ��
     * 
     * @param cond ��������
     * @param version �汾
     * @return ��������б�
     */
	@SuppressWarnings("unchecked")
	public List<IGCRC1301VWInfo> searchIGCRC1301VWInfo(final IGCRC1301Cond cond, final int start,
			final int count) {
		 HibernateCallback action = new HibernateCallback() {
	            public Object doInHibernate(Session session) throws HibernateException, SQLException {
	                session.flush();
	                StringBuffer query = new StringBuffer();
	                query.append(session.getNamedQuery("EntityItemIGCRC1301VWDAO.entityItemIGCRC1301VWDAO").getQueryString());
	                // ƴ�Ӳ�ѯ����
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
	                // ƴ�Ӳ�ѯ����
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
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IGCRC1301Cond cond) {
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
				
				query.append( session.getNamedQuery("EntityItemIGCRC1301VWDAO.getSearchCount").getQueryString());
				
				// ƴ�Ӳ�ѯ����
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
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
    private void getSql(StringBuffer query, IGCRC1301Cond cond){
    	//�ĵ����
        if(StringUtils.isNotEmpty(cond.getEiNumber())){
        	query.append(" and t.eiNumber like '%"+cond.getEiNumber()+"%'");
        }
        //�ĵ�����
        if(StringUtils.isNotEmpty(cond.getEiName())){
        	query.append(" and t.eiName like '%"+cond.getEiName()+"%'");
        }
        //�ĵ�����
        if(StringUtils.isNotEmpty(cond.getEiType())){
        	query.append(" and t.eiType = '"+cond.getEiType()+"'");
        }
        //�ĵ�����
        if(StringUtils.isNotEmpty(cond.getEiSort())){
        	query.append(" and t.eiSort like '%"+cond.getEiSort()+"'");
        }
        //�ĵ��ܼ�
        if(StringUtils.isNotEmpty(cond.getEiDense())){
        	query.append(" and t.eiDense = '"+cond.getEiDense()+"'");
        }
        //����
        if(StringUtils.isNotEmpty(cond.getDepartment())){
        	query.append(" and t.department like '%"+cond.getDepartment()+"%'");
        }
        //������
        /*if(StringUtils.isNotEmpty(cond.getEiName())){
        	query.append(" and EINAME = '"+cond.getEiName()+"'");
        }*/
        //����
        if(StringUtils.isNotEmpty(cond.getContent())){
        	query.append(" and t.content like '%"+cond.getContent()+"%'");
        }
        //�Ƿ������
        if(StringUtils.isNotEmpty(cond.getIsDownload())){
        	query.append(" and t.isDownload = '"+cond.getIsDownload()+"'");
        }
    }
}
