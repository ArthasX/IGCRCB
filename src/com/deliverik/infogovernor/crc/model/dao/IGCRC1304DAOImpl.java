package com.deliverik.infogovernor.crc.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.crc.model.IGCRC1303VWInfo;
import com.deliverik.infogovernor.crc.model.condition.IGCRC1304Cond;
import com.deliverik.infogovernor.crc.model.entity.IGCRC1303VW;

/**
 * 
 * ���ܣ�
 * @author ʷ����   2014-7-24
 */
public class IGCRC1304DAOImpl extends BaseHibernateDAOImpl<IGCRC1303VWInfo> implements IGCRC1304DAO{

	
	/**
	 * ���캯��
	 */
	public IGCRC1304DAOImpl() {
		super(IGCRC1303VW.class);
	}

	/**
     * ���ݶ���ȶԽ��
     * 
     * @param cond ��������
     * @param version �汾
     * @return ��������б�
     */
	@SuppressWarnings("unchecked")
	public List<IGCRC1303VWInfo> searchIGCRC1304VWInfo(final IGCRC1304Cond cond, final int start,
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
	                q.addEntity("t",IGCRC1303VW.class);
	                setFetchPoint(q, start , count);
	                List<IGCRC1303VWInfo> list = q.list();
	                session.clear();
	                session.close();
	                return list;
	            }
	        };
	        return (List<IGCRC1303VWInfo>) execute(action);
	}
	
	
	/**
     * ���ݲ�ѯ�������̵Ĳ�������
     */
	public List<String> searchType(){
		HibernateCallback action = new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                session.flush();
                StringBuffer query = new StringBuffer();
                query.append("select einame " +
                				"from ig500 ig5,ig731 ig7 ,soc0118 soc " +
                				"where ig5.prpdname like '%�ĵ�����%' " +
                				"and ig7.prid=ig5.prid  " +
                				"and soc.eiid=ig7.eiid order by soc.eiid");
                
                SQLQuery q = session.createSQLQuery(query.toString()); 

                List<String> list = q.list();
                session.clear();
                session.close();
                return list;
            }
        };
		return (List<String>) execute(action);
	}
	
	
	/**
     * ���ݲ�ѯ�������̵Ĳ�������id
     */
	public List<Integer> searchTypeID(final IGCRC1304Cond cond){
		HibernateCallback action = new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                session.flush();
                StringBuffer query = new StringBuffer();
                
                query.append("select ig5.prid " +
                				"from ig500 ig5,ig731 ig7 ,soc0118 soc  " +
                				"where ig5.prpdname like '%�ĵ�����%'  " +
                				"and ig7.prid=ig5.prid " +
                				"and soc.eiid=ig7.eiid " +
                				"and soc.eiid like '");
                query.append(cond.getEiid());
                query.append("'");
                SQLQuery q = session.createSQLQuery(query.toString()); 

                List<Integer> list = q.list();
                session.clear();
                session.close();
                return list;
            }
        };
		return (List<Integer>) execute(action);
	}
	
	
	

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IGCRC1304Cond cond) {
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
     * ��ѯ�����ص��ĵ��Ĳ���
     */
	public List<String> searchDownDepart(){
		HibernateCallback action = new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                session.flush();
                StringBuffer query = new StringBuffer();
                query.append("select einame " +
                				"from IGDOCDOWN igdo,soc0118 soc " +
                				"where soc.eiid = igdo.eiid");
                SQLQuery q = session.createSQLQuery(query.toString()); 

                List<String> bean = q.list();
                session.clear();
                session.close();
                return bean;
            }
        };
		return (List<String>) execute(action);
	}
	
	
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
    private void getSql(StringBuffer query, IGCRC1304Cond cond){
    	//�ĵ����
        if(StringUtils.isNotEmpty(cond.getEiNumber())){
        	query.append(" and t.eiNumber = '"+cond.getEiNumber()+"'");
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

    }
}
